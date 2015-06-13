package org.uengine.essencia.enactment;

import org.metaworks.annotation.Face;
import org.uengine.essencia.enactment.face.AlphaInstanceFace;
import org.uengine.essencia.enactment.face.LevelOfDetailNameSelector;
import org.uengine.essencia.model.*;
import org.uengine.kernel.ProcessInstance;

import java.util.*;

//@Face(faceClass= AlphaInstanceFace.class)
public class WorkProductInstance extends LanguageElementInstance {

    public static String STATE_PROP_KEY_WorkInProgressCount = "WIPCount";

    public WorkProduct getWorkProduct() {
        return (WorkProduct)getLanguageElement();
    }

    String currentLevelOfDetailName;
    @Face(faceClass = LevelOfDetailNameSelector.class)
        public String getCurrentLevelOfDetailName() {
            return currentLevelOfDetailName;
        }
        public void setCurrentLevelOfDetailName(String currentLevelOfDetailName) {
            this.currentLevelOfDetailName = currentLevelOfDetailName;
        }

    public LevelOfDetail getCurrentLevelOfDetail(){
        return getWorkProduct().findLevelOfDetail(getCurrentLevelOfDetailName());
    }

    public WorkProductInstance(WorkProduct workProduct, String id){

        super(workProduct, id);

        if(getWorkProduct().getList().size() > 0)
            setCurrentLevelOfDetailName(getWorkProduct().getList().get(0).getName());
    }

    //only for serialization / deserialization
    public WorkProductInstance(){
        //if(!DWR.inSerialization()) throw new IllegalStatusError('This constructor is only for DWR instantiation');
    }

}
