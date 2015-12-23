package org.uengine.essencia.enactment.face;

import org.metaworks.Face;
import org.metaworks.annotation.Group;
import org.springframework.beans.BeanUtils;
import org.uengine.essencia.enactment.AlphaInstance;
import org.uengine.essencia.enactment.CheckPointInstance;
import org.uengine.essencia.enactment.CheckPointInstanceGroup;
import org.uengine.essencia.model.CheckPoint;
import org.uengine.essencia.model.State;

import java.util.ArrayList;
import java.util.List;

@org.metaworks.annotation.Face(faceClass=org.metaworks.Face.class)
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


    @Override
    public void setValueToFace(AlphaInstance value) {
        BeanUtils.copyProperties(value, this);

 //       setAttributeValues(value.getAttributeValues());

        boolean isCompletionCriteria = (getCurrentStateName()==null ? true : false);

        setCheckPointInstanceGroups(new ArrayList<CheckPointInstanceGroup>());

        if(getAlpha()!=null && getAlpha().getStates()!=null)
        for(State state : getAlpha().getStates()){

            CheckPointInstanceGroup group = new CheckPointInstanceGroup();
            getCheckPointInstanceGroups().add(group);

            group.setCheckPointInstanceList(new ArrayList<CheckPointInstance>());
            group.setTitle(state.getName());

            if(state.getName().equals(getCurrentStateName())){
                isCompletionCriteria = true;
            }

            group.setCompletionCriteria(isCompletionCriteria);

            for(CheckPoint checkPoint : state.getCheckPoints()){
                CheckPointInstance checkPointInstance = new CheckPointInstance();
                checkPointInstance.setCheckPoint(checkPoint);
                checkPointInstance.setChecked(value.isChecked(checkPoint.getName()));

                group.getCheckPointInstanceList().add(checkPointInstance);
            }


            if(state.getName().equals(getTargetStateName())){
                isCompletionCriteria = false;
            }

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

        return alphaInstance;
    }
}
