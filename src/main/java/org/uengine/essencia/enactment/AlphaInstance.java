package org.uengine.essencia.enactment;

import com.sun.tools.internal.xjc.Language;
import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.State;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AlphaInstance extends LanguageElementInstance {

    public Alpha getAlpha() {
        return (Alpha)getLanguageElement();
    }

    String currentStateName;
        public String getCurrentStateName() {
            return currentStateName;
        }
        public void setCurrentStateName(String currentStateName) {
            this.currentStateName = currentStateName;
        }

        public State getCurrentState(){
            return getAlpha().findState(getCurrentStateName());
        }

    Set<String> checkedCheckpointNames = new HashSet<String>();

        public boolean isChecked(String checkpointName){
            return checkedCheckpointNames.contains(checkpointName);
        }

        public void setChecked(String checkpointName){

            //try to find the checkpoint is in the current state to prevent illegal checking
            getCurrentState().findCheckpoint(checkpointName);

            checkedCheckpointNames.add(checkpointName);
        }




    public AlphaInstance(Alpha alpha, String id){

        super(alpha, id);

        if(getAlpha().getList().size() > 0)
            setCurrentStateName(getAlpha().getList().get(0).getName());
    }

    //only for serialization / deserialization
    public AlphaInstance(){
        //if(!DWR.inSerialization()) throw new IllegalStatusError('This constructor is only for DWR instantiation');
    }


    public boolean isCurrentStateCompletable() {
        return getCurrentState().isAllChecked(this);
    }


    public void advanceState(){

        if(!isCurrentStateCompletable()){
            throw new NotCompletableException("Not completable");
        }else{


            int currentStateIndex = getAlpha().getList().indexOf(getCurrentState());

            if(currentStateIndex < getAlpha().getList().size() -1){
                currentStateIndex ++;
                setCurrentStateName(getAlpha().getList().get(currentStateIndex).getName());
            }

        }

    }
}
