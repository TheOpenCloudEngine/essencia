package org.uengine.essencia.enactment.face;

import org.metaworks.Face;
import org.metaworks.annotation.Group;
import org.metaworks.dwr.MetaworksRemoteService;
import org.springframework.beans.BeanUtils;
import org.uengine.essencia.enactment.AlphaInstance;
import org.uengine.essencia.enactment.CheckPointInstance;
import org.uengine.essencia.enactment.CheckPointInstanceGroup;
import org.uengine.essencia.enactment.EssenceProcessDefinition;
import org.uengine.essencia.model.CheckPoint;
import org.uengine.essencia.model.State;
import org.uengine.modeling.resource.DefaultResource;
import org.uengine.modeling.resource.ResourceManager;

import java.util.ArrayList;
import java.util.List;

@org.metaworks.annotation.Face(faceClass=org.metaworks.IgnoreFaceClassOfSuper.class) //this prohibits recursive face replacement.
public class AlphaInstanceFace2 extends AlphaInstance implements Face<AlphaInstance> {

    @Group(name="Checkpoints")
//    List<CheckPointInstance> checkPointInstanceList;
//        public List<CheckPointInstance> getCheckPointInstanceList() {
//            return checkPointInstanceList;
//        }
//        public void setCheckPointInstanceList(List<CheckPointInstance> checkPointInstanceList) {
//            this.checkPointInstanceList = checkPointInstanceList;
//        }
//

    List<CheckPointInstanceGroup> checkPointInstanceGroups;
        public List<CheckPointInstanceGroup> getCheckPointInstanceGroups() {
            return checkPointInstanceGroups;
        }
        public void setCheckPointInstanceGroups(List<CheckPointInstanceGroup> checkPointInstanceGroups) {
            this.checkPointInstanceGroups = checkPointInstanceGroups;
        }

    AlphaPlanningPanel alphaPlanningPanel;
        public AlphaPlanningPanel getAlphaPlanningPanel() {
            return alphaPlanningPanel;
        }
        public void setAlphaPlanningPanel(AlphaPlanningPanel alphaPlanningPanel) {
            this.alphaPlanningPanel = alphaPlanningPanel;
        }

    AlphaActivityPanel alphaActivityPanel;
        public AlphaActivityPanel getAlphaActivityPanel() {
            return alphaActivityPanel;
        }

        public void setAlphaActivityPanel(AlphaActivityPanel alphaActivityPanel) {
            this.alphaActivityPanel = alphaActivityPanel;
        }





    @Override
    public void setValueToFace(AlphaInstance value) {
        BeanUtils.copyProperties(value, this);

 //       setAttributeValues(value.getAttributeValues());

        int indexOfTargetState = 1000, i=0;

        setCheckPointInstanceGroups(new ArrayList<CheckPointInstanceGroup>());

        fillStates();

//        value.calculateState();

        if(getAlpha()!=null && getAlpha().getStates()!=null)
        for(State state : getAlpha().getStates()){

            CheckPointInstanceGroup group = new CheckPointInstanceGroup();
            getCheckPointInstanceGroups().add(group);

            group.setCheckPointInstanceList(new ArrayList<CheckPointInstance>());
            group.setTitle(state.getName());

            group.setCompletionCriteria(indexOfTargetState >= i);

            for(CheckPoint checkPoint : state.getCheckPoints()){
                CheckPointInstance checkPointInstance = new CheckPointInstance();
                checkPointInstance.setCheckPoint(checkPoint);
                checkPointInstance.setChecked(value.isChecked(checkPoint.getName()));

                group.getCheckPointInstanceList().add(checkPointInstance);
            }


            if(state.getName().equals(getTargetStateName())){
                indexOfTargetState = i;
            }

            i++;
        }

        //TODO planning panel must be restored someday.
        //setAlphaPlanningPanel(new AlphaPlanningPanel(value));

// to set the activity list
        String[] processResourceNameAndLanguageElementName = getClassName().split("\\#");

        ResourceManager resourceManager = MetaworksRemoteService.getComponent(ResourceManager.class);

        String resourcePath = processResourceNameAndLanguageElementName[0];

        //TODO: temporal
        if(resourcePath.startsWith("codi/codi/"))
            resourcePath = resourcePath.substring("codi/".length(), resourcePath.length());

        DefaultResource classDefinitionResource = new DefaultResource( resourcePath );
        try {
            EssenceProcessDefinition definition = (EssenceProcessDefinition) resourceManager.getObject(classDefinitionResource);

            setAlphaActivityPanel(new AlphaActivityPanel(value, definition.getPracticeDefinition()));

        } catch (Exception e) {
            e.printStackTrace();
        }



    }



    @Override
    public AlphaInstance createValueFromFace() {


//        if(alphaInstance==null)
//            return null;

        AlphaInstance alphaInstance = new AlphaInstance();
        BeanUtils.copyProperties(this, alphaInstance);

//        alphaInstance.setAttributeValues(getAttributeValues());


        if(getCheckPointInstanceGroups()!=null){
            for(CheckPointInstanceGroup group : getCheckPointInstanceGroups()) {
                for (CheckPointInstance checkPointInstance : group.getCheckPointInstanceList()) {
                    alphaInstance.setChecked(checkPointInstance.getCheckPoint().getName(), checkPointInstance.isChecked());
                }
            }
        }


        if(getAlphaPlanningPanel()!=null){
            getAlphaPlanningPanel().applyToAlphaInstance(alphaInstance);
        }

        //alphaInstance.fillStates(); //it is not available since the tenant information is not available until tenantAware method is called

        return alphaInstance;
    }
}
