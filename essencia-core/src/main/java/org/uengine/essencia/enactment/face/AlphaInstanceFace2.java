package org.uengine.essencia.enactment.face;

import org.metaworks.Face;
import org.metaworks.annotation.Hidden;
import org.springframework.beans.BeanUtils;
import org.uengine.essencia.enactment.AlphaInstance;
import org.uengine.essencia.enactment.CheckPointInstance;
import org.uengine.essencia.model.CheckPoint;

import java.util.ArrayList;
import java.util.List;

@org.metaworks.annotation.Face(faceClass=org.metaworks.Face.class)
public class AlphaInstanceFace2 extends AlphaInstance implements Face<AlphaInstance> {

    List<CheckPointInstance> checkPointInstanceList;
        public List<CheckPointInstance> getCheckPointInstanceList() {
            return checkPointInstanceList;
        }
        public void setCheckPointInstanceList(List<CheckPointInstance> checkPointInstanceList) {
            this.checkPointInstanceList = checkPointInstanceList;
        }
//
//    AlphaInstance alphaInstance;
//    @Hidden
//        public AlphaInstance getAlphaInstance() {
//            return alphaInstance;
//        }
//        public void setAlphaInstance(AlphaInstance alphaInstance) {
//            this.alphaInstance = alphaInstance;
//        }


    @Override
    public void setValueToFace(AlphaInstance value) {
        BeanUtils.copyProperties(value, this);

        setPropertyValues(value.getPropertyValues());

        setCheckPointInstanceList(new ArrayList<CheckPointInstance>());

        if(value.getCurrentState()!=null)
        for(CheckPoint checkPoint : value.getCurrentState().getCheckPoints()){
            CheckPointInstance checkPointInstance = new CheckPointInstance();
            checkPointInstance.setCheckPoint(checkPoint);
            checkPointInstance.setChecked(value.isChecked(checkPoint.getName()));

            getCheckPointInstanceList().add(checkPointInstance);
        }
    }

    @Override
    public AlphaInstance createValueFromFace() {


//        if(alphaInstance==null)
//            return null;

        AlphaInstance alphaInstance = new AlphaInstance();
        BeanUtils.copyProperties(this, alphaInstance);

        alphaInstance.setPropertyValues(getPropertyValues());

        if(alphaInstance.getCurrentState()!=null && getCheckPointInstanceList()!=null)
        for(CheckPointInstance checkPointInstance : getCheckPointInstanceList()){
            alphaInstance.setChecked(checkPointInstance.getCheckPoint().getName(), checkPointInstance.isChecked());
        }

        return alphaInstance;
    }
}
