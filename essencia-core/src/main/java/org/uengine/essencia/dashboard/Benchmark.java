package org.uengine.essencia.dashboard;

import org.metaworks.MetaworksContext;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.component.MultiSelectBox;
import org.metaworks.component.SelectBox;
import org.metaworks.widget.chart.Radar;
import org.metaworks.widget.chart.RadarData;
import org.springframework.beans.factory.annotation.Autowired;
import org.uengine.codi.mw3.model.*;
import org.uengine.essencia.enactment.*;
import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.kernel.ProcessInstance;
import org.uengine.processmanager.ProcessManagerRemote;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jjy on 2016. 1. 3..
 */
//@Face(ejsPath="genericfaces/CleanObjectFace.ejs")
public class Benchmark {

    private static final int DEFAULT_LOAD_INSTANCE_CNT = 5;
    static String[] colors = {
            "rgba(192, 57, 43,1.0)",
            "rgba(41, 128, 185,1.0)",
            "rgba(22, 160, 133,1.0)",
            "rgba(243, 156, 18,1.0)",
            "rgba(142, 68, 173,1.0)",
            "rgba(44, 62, 80,1.0)",
            "rgba(231, 76, 60,1.0)",
            "rgba(52, 152, 219,1.0)",
            "rgba(39, 174, 96,1.0)",
            "rgba(241, 196, 15,1.0)",
            "rgba(155, 89, 182,1.0)",
            "rgba(52, 73, 94,1.0)}",
    };

    SelectBox targetInstances;
        public SelectBox getTargetInstances() {
            return targetInstances;
        }
        public void setTargetInstances(SelectBox targetInstances) {
            this.targetInstances = targetInstances;
        }

    Radar chart;
        public Radar getChart() {
            return chart;
        }
        public void setChart(Radar chart) {
            this.chart = chart;
        }

    @AutowiredFromClient
    public Session session;

    @Autowired
    public ProcessManagerRemote processManagerRemote;

    public Benchmark() {
    }

    @ServiceMethod(payload = "targetInstances")
    public void load() throws Exception {

        //session.getUser();

        Navigation navigation = new Navigation(session);
        navigation.setPerspectiveMode(Perspective.MODE_PERSONAL);
        navigation.setPerspectiveType(Perspective.TYPE_FOLLOWING);
        navigation.setPerspectiveValue("2"); //why 2?

        String[] instanceIds;
        if(getTargetInstances()!=null){
            instanceIds = getTargetInstances().getSelected().split(", ");
        }else{
            setTargetInstances(new MultiSelectBox());
            getTargetInstances().getMetaworksContext().setWhen(MetaworksContext.WHEN_EDIT);


            IInstance instances = Instance.load(navigation, 0, 50);
            List instanceIdList = new ArrayList<String>();

            while(instances.next()){

                if(instances.getDefVerId()!=null && instances.getDefVerId().endsWith(".method")){
                    if(instanceIdList.size() < DEFAULT_LOAD_INSTANCE_CNT ) {
                        instanceIdList.add(instances.getInstId().toString());
                    }

                    getTargetInstances().getOptionValues().add(instances.getInstId().toString());
                    getTargetInstances().getOptionNames().add(instances.getName());
                }

            }

            instanceIds = new String[instanceIdList.size()];
            instanceIdList.toArray(instanceIds);
        }

        String[] alphas = {"Stakeholders", "Opportunity", "Requirements", "System", "Team", "Work", "Way-of-working"};

        setChart(new Radar());
        getChart().setRadarData(new ArrayList<RadarData>());


        int i=0;
        for(String instanceId : instanceIds){

            ProcessInstance instance = processManagerRemote.getProcessInstance(instanceId);

            org.uengine.kernel.ProcessDefinition processDefinition = instance.getProcessDefinition();

            if(!(processDefinition instanceof EssenceProcessDefinition)) continue;

            GameBoard gameBoard = new GameBoard(instance, true);

            RadarData pointOfEachAlphas = new RadarData();
            pointOfEachAlphas.setLabel(instance.getName());
            pointOfEachAlphas.setColor(colors[i++]);
            getChart().getRadarData().add(pointOfEachAlphas);

            for(String alpha : alphas) {
                List<AlphaInstanceInList> alphaInstances = gameBoard.getAlphaInstancesMap().get(alpha);

                double point = 0;
                if(alphaInstances!=null && alphaInstances.size()>0){

                    LanguageElementInstance languageElementInstance = alphaInstances.get(0).getLanguageElementInstance();
                    if(languageElementInstance instanceof AlphaInstance){
                        AlphaInstance alphaInstance = (AlphaInstance) languageElementInstance;

                        Alpha alphaInObject = ((AlphaInstance) languageElementInstance).getAlpha();
                        for(int j=0; j< alphaInObject.getStates().size(); j++){
                            if(alphaInObject.getStates().get(j).getName().equals(alphaInstance.getCurrentStateName())){
                                point = j * 100 / alphaInObject.getStates().size();
                            }
                        }


                    }else{
                        // case of workproduct. but there's no kernel workproduct. so it can be ignored for now.
                    }
                }

                pointOfEachAlphas.getData().add(point);
            }


        }


        getChart().setPerspectives(new ArrayList<String>());

        for(String label : alphas)
            getChart().getPerspectives().add(label);

    }
}
