package org.uengine.essencia.dashboard;

import org.metaworks.MetaworksContext;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Payload;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.component.MultiSelectBox;
import org.metaworks.component.SelectBox;
import org.metaworks.widget.chart.Radar;
import org.metaworks.widget.chart.RadarData;
import org.springframework.beans.factory.annotation.Autowired;
import org.uengine.codi.mw3.model.*;
import org.uengine.essencia.enactment.*;
import org.uengine.essencia.model.*;
import org.uengine.essencia.model.Activity;
import org.uengine.essencia.util.KernelUtil;
import org.uengine.kernel.*;
import org.uengine.modeling.Relation;
import org.uengine.modeling.resource.VersionManager;
import org.uengine.processmanager.ProcessManagerRemote;
import org.metaworks.dwr.MetaworksRemoteService;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jjy on 2016. 1. 3..
 */
//@Face(ejsPath="genericfaces/CleanObjectFace.ejs")
public class Benchmark {

   // private static final int DEFAULT_LOAD_INSTANCE_CNT = 0;
    static String[] colors = {
            "192, 57, 43",
            "41, 128, 185",
            "22, 160, 133",
            "243, 156, 18",
            "142, 68, 173",
            "44, 62, 80",
            "231, 76, 60",
            "52, 152, 219",
            "39, 174, 96",
            "241, 196, 15",
            "155, 89, 182",
            "52, 73, 94",
    };

    static String[] alphas = {"Stakeholders", "Opportunity", "Requirements", "Software System", "Team", "Work", "Way of working"};


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

    CoverageTable coverageTable;
        public CoverageTable getCoverageTable() {
            return coverageTable;
        }
        public void setCoverageTable(CoverageTable coverageTable) {
            this.coverageTable = coverageTable;
        }

    int defaultLoadingInstanceCount;
        public int getDefaultLoadingInstanceCount() {
            return defaultLoadingInstanceCount;
        }
        public void setDefaultLoadingInstanceCount(int defaultLoadingInstanceCount) {
            this.defaultLoadingInstanceCount = defaultLoadingInstanceCount;
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
        navigation.setPerspectiveType(Perspective.TYPE_NEWSFEED);
        navigation.setPerspectiveValue("2"); //why 2?

        String[] instanceIds = new String[]{};
        if(getTargetInstances()!=null){
            instanceIds = getTargetInstances().getSelected().split(", ");
        }else{
            setTargetInstances(new MultiSelectBox());
            getTargetInstances().getMetaworksContext().setWhen(MetaworksContext.WHEN_EDIT);


            //Load default

            if(getDefaultLoadingInstanceCount() > 0){
                IInstance instances = Instance.load(navigation, 0, 50);
                List instanceIdList = new ArrayList<String>();

                while(instances.next()){

                    if(instances.getDefVerId()!=null && instances.getDefVerId().endsWith(".method")){
                        if(instanceIdList.size() < getDefaultLoadingInstanceCount() ) {
                            instanceIdList.add(instances.getInstId().toString());
                        }

                        getTargetInstances().getOptionValues().add(instances.getInstId().toString());
                        getTargetInstances().getOptionNames().add(instances.getName());
                    }

                }

                instanceIds = new String[instanceIdList.size()];
                instanceIdList.toArray(instanceIds);
            }


        }



        setChart(new Radar());
        getChart().setWidth(400);
        getChart().setHeight(400);
        getChart().setRadarData(new ArrayList<RadarData>());

        //gathering kernel alphas which will be the each axis of radar.

        List<String> gatheredAlphas = new ArrayList<String>();
        Map kernelLoaded = new HashMap<String, String>();
        boolean essenceKernelEverLoaded = false;
        for(String instanceId : instanceIds){

            try {
                ProcessInstance instance = processManagerRemote.getProcessInstance(instanceId);

                org.uengine.kernel.ProcessDefinition processDefinition = instance.getProcessDefinition();

                if(!(processDefinition instanceof EssenceProcessDefinition)) continue;

                String baseKernelName = ((EssenceProcessDefinition) processDefinition).getPracticeDefinition().getBaseKernel();


                if(kernelLoaded.containsKey(baseKernelName) || ((baseKernelName==null || baseKernelName.startsWith("essence_")) && essenceKernelEverLoaded)) continue; //skip if the kernel is already gathered one with its alpha.
                kernelLoaded.put(baseKernelName, baseKernelName);

                PracticeDefinition theKernel = KernelUtil.getInstance().getPracticeDefinition(baseKernelName);
                List<Alpha> kernelAlphas = theKernel.getElements(Alpha.class);

                for(Alpha alpha : kernelAlphas){
                    if(!gatheredAlphas.contains(alpha.getName())){
                        gatheredAlphas.add(alpha.getName());
                    }
                }

                if(baseKernelName==null || baseKernelName.startsWith("essence_")) essenceKernelEverLoaded = true;

            }catch (Exception e){
                e.printStackTrace();
            }

        }

        //end of gathering alphas from different kernels


        int i=0;
        for(String instanceId : instanceIds){

            ProcessInstance instance = processManagerRemote.getProcessInstance(instanceId);

            org.uengine.kernel.ProcessDefinition processDefinition = null;

            try {
                processDefinition = instance.getProcessDefinition();
            }catch (Exception e){


                continue; //if there's no definition file, skip the instance
            }

            if(!(processDefinition instanceof EssenceProcessDefinition)) continue;

            GameBoard gameBoard = null;
            try {
                gameBoard = new GameBoard(instance, true);
            }catch (Exception e){
                continue; //TODO: temporary disabled.
            }

            RadarData pointOfEachAlphas = new RadarData();
            pointOfEachAlphas.setLabel(instance.getName());
            pointOfEachAlphas.setColor(colors[i++]);
            getChart().getRadarData().add(pointOfEachAlphas);

            for(String alpha : gatheredAlphas) {
                List<AlphaInstanceInList> alphaInstances = gameBoard.getAlphaInstancesMap().get(alpha);

                double point = 0;
                if(alphaInstances!=null && alphaInstances.size()>0){

                    LanguageElementInstance languageElementInstance = alphaInstances.get(0).getLanguageElementInstance();
                    if(languageElementInstance instanceof AlphaInstance){
                        AlphaInstance alphaInstance = (AlphaInstance) languageElementInstance;

                        Alpha alphaInObject = ((AlphaInstance) languageElementInstance).getAlpha();
                        for(int j=0; j< alphaInObject.getStates().size(); j++){
                            if(alphaInObject.getStates().get(j).getName().equals(alphaInstance.getCurrentStateName())){
                                point = (j+1) * 6 / alphaInObject.getStates().size();
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

        for(String label : gatheredAlphas)
            getChart().getPerspectives().add(label);

    }

    @ServiceMethod(mouseBinding = "drop")
    public void drop(@AutowiredFromClient Session session, @Payload("targetInstances") SelectBox targetInstances) throws Exception {

        if(session==null) return;

        if(session.getClipboard() instanceof InstanceDrag){

            InstanceDrag instanceDrag = (InstanceDrag) session.getClipboard();
            Instance instance = new Instance();
            instance.setInstId(instanceDrag.getInstanceId());

            if(getTargetInstances().getSelected()==null) getTargetInstances().setSelected(instance.getInstId().toString());

            else
                getTargetInstances().setSelected(getTargetInstances().getSelected()+ ", " + instance.getInstId());

            load();
        }else if(session.getClipboard() instanceof DefinitionDrag){

            DefinitionDrag definitionDrag = (DefinitionDrag) session.getClipboard();

            if(getDefinitionIds()==null){
                setDefinitionIds(new ArrayList<String>());
            }

            getDefinitionIds().add(definitionDrag.getId());


            loadPracticeBenchmark();
        }

    }


    List<String> definitionIds;
        public List<String> getDefinitionIds() {
            return definitionIds;
        }
        public void setDefinitionIds(List<String> definitionIds) {
            this.definitionIds = definitionIds;
        }



    private void loadPracticeBenchmark() throws RemoteException {

        List<CoverageTable> coverageTables = new ArrayList<CoverageTable>();



        for(int i=0; i<definitionIds.size(); i++){
            CoverageTable coverageTable1 = new CoverageTable();
//            coverageTable1.setColorRed(colors[i * 3]);
//            coverageTable1.setColorGreen(colors[i * 3 + 1]);
//            coverageTable1.setColorBlue(colors[i * 3 + 2]);

            String rgb = colors[i];
            String[] rgbs = rgb.split(", ");

            int red = new Integer(rgbs[0]);
            int green = new Integer(rgbs[1]);
            int blue = new Integer(rgbs[2]);


            coverageTables.add(coverageTable1);

            VersionManager versionManager = MetaworksRemoteService.getComponent(VersionManager.class);
            versionManager.setAppName("codi");
            org.uengine.kernel.ProcessDefinition processDefinition = processManagerRemote.getProcessDefinition(versionManager.getProductionResourcePath(definitionIds.get(i)));
            PracticeDefinition practiceDefinition = ((EssenceProcessDefinition)processDefinition).getPracticeDefinition();

           // processDefinition.beforeSerialization();

            List<Activity> activities = practiceDefinition.getElements(org.uengine.essencia.model.Activity.class);

            coverageTable1.setCoverages(new HashMap<String, Map<Integer, Coverage>>());

            Coverage coverage = new Coverage();
            coverage.setRed(red);
            coverage.setGreen(green);
            coverage.setBlue(blue);


            for(Activity activity : activities) {

                if(activity instanceof ActivitySpace) continue; //skip ActivitySpaces

                if(activity.getEntryCriteria()!=null)
                for (Criterion criterion : activity.getEntryCriteria()) {
                    markCoverage(coverageTable1, coverage, criterion);
                }

                if(activity.getCompletionCriteria()!=null)
                for (Criterion criterion : activity.getCompletionCriteria()) {
                    markCoverage(coverageTable1, coverage, criterion);
                }
            }


        }


        ///// merging coverage table into one.

        setCoverageTable(new CoverageTable());
        getCoverageTable().setCoverages(new HashMap<String, Map<Integer, Coverage>>());

        for(CoverageTable coverageTable1 : coverageTables){

            for(int stateIdex = 0; stateIdex < alphas.length; stateIdex++){
                String stateName = alphas[stateIdex];

                Map<Integer, Coverage> coverageByStateIndex = coverageTable1.getCoverages().get(stateName);

                if(coverageByStateIndex!=null){
                    if(!getCoverageTable().getCoverages().containsKey(stateName)){
                        getCoverageTable().getCoverages().put(stateName, new HashMap<Integer, Coverage>());
                    }

                    boolean started = false;
                    Coverage coverage = null;
                    for(int i = 6; i>=0; i--){
                        if(coverageByStateIndex.containsKey(i)){
                            started = !started;
                            coverage = coverageByStateIndex.get(i);
                        }

                        if(started){
                            if(!getCoverageTable().getCoverages().get(stateName).containsKey(i)){
                                getCoverageTable().getCoverages().get(stateName).put(i, coverage);
                            }

                            Coverage mergingCoverage = getCoverageTable().getCoverages().get(stateName).get(i);

                            mergingCoverage.add(coverage);
                        }
                    }

                }
            }

        }

        for(Map<Integer, Coverage> coverageByStateNames : getCoverageTable().getCoverages().values()){

            for(Coverage coverage: coverageByStateNames.values()){
                coverage.merge();
            }
        }



        PracticeDefinition kernel = KernelUtil.getInstance().getPracticeDefinition();
        getCoverageTable().setKernelAlphas(kernel.getElements(Alpha.class));


    }

    private void markCoverage(CoverageTable coverageTable1, Coverage coverage, Criterion criterion) {

        if(criterion.getState()==null) return; //ignore work product.

        String alphaName = null;
        int stateIndex = 0;

        if(criterion.getState().getAggregationAlphaState()==null){  //means alpha in the kernel
            stateIndex = criterion.getState().getParentAlpha().indexOfState(criterion.getState());
            alphaName = criterion.getState().getParentAlpha().getName();
        }else{  //means we need to find the kernel connected with the aggregationAlphaStateName
            for(Relation relation : criterion.getState().getParentAlpha().getIncomingRelations()){
                if(relation.getSourceElement()!=null && relation.getSourceElement() instanceof Alpha){
                    Alpha kernel = (Alpha) relation.getSourceElement();

                    stateIndex = kernel.indexOfState(criterion.getState().getAggregationAlphaState());

                    alphaName = kernel.getName();
                }
            }

            if(alphaName==null) return; //if there's no kernel found, skip this mark.
        }

        if (!coverageTable1.getCoverages().containsKey(alphaName)) {
            coverageTable1.getCoverages().put(alphaName, new HashMap<Integer, Coverage>());
            //new Coverage());
        }

        Map<Integer, Coverage> coverageByStateIndex = coverageTable1.getCoverages().get(alphaName);

        Coverage copy = coverage.copy();
        //copy.setName(criterion.getState().getName());

        coverageByStateIndex.put(stateIndex, copy);
    }


    @AutowiredFromClient(onDrop = true)
    public IInstance dropInstance;

    @AutowiredFromClient(onDrop = true)
    public InstanceDrag dropInstanceDrag;

    @AutowiredFromClient(onDrop = true)
    public DefinitionDrag dropDefinitionDrag;

}
