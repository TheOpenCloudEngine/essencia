package org.uengine.essencia.enactment;

import org.metaworks.annotation.Face;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.dwr.MetaworksRemoteService;
import org.metaworks.widget.ModalWindow;
import org.uengine.essencia.enactment.face.AlphaInstanceFace2;
import org.uengine.essencia.model.*;
import org.uengine.kernel.ProcessInstance;
import org.uengine.modeling.Relation;
import org.uengine.util.UEngineUtil;

import java.util.*;

@Face(faceClass= AlphaInstanceFace2.class)
public class AlphaInstance extends LanguageElementInstance {

    public static String STATE_PROP_KEY_WorkInProgressCount = "WIPCount";

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

            if(getCurrentStateName()==null) return null;

            return getAlpha().findState(getCurrentStateName());
        }

    String targetStateName;
        public String getTargetStateName() {
            return targetStateName;
        }
        public void setTargetStateName(String targetStateName) {
            this.targetStateName = targetStateName;
        }


    Set<String> checkedCheckpointNames = new HashSet<String>();
        public boolean isChecked(String checkpointName){
            checkpointName = String.valueOf(checkpointName.hashCode());

            return checkedCheckpointNames.contains(checkpointName);
        }
        public void setChecked(String checkpointName){
            setChecked(checkpointName, true);
        }
        public void setChecked(String checkpointName, boolean checked){

            //try to find the checkpoint is in the current state to prevent illegal checking
            //getCurrentState().findCheckpoint(checkpointName);

            checkpointName = String.valueOf(checkpointName.hashCode());

            if(checked)
                checkedCheckpointNames.add(checkpointName);
            else
                checkedCheckpointNames.remove(checkpointName);
        }


    Map<String, Map<String, Object>> stateDetailsByStateName = new HashMap<String, Map<String, Object>>();
        public Map<String, Map<String, Object>> getStateDetailsByStateName() {
            return stateDetailsByStateName;
        }
        public void setStateDetailsByStateName(Map<String, Map<String, Object>> stateDetailsByStateName) {
            this.stateDetailsByStateName = stateDetailsByStateName;
        }


//    public AlphaInstance(Alpha alpha, String id){
//
//        super(alpha, id);
//
//        if(getAlpha().getStates()!=null && getAlpha().getStates().size() > 0)
//            setCurrentStateName(getAlpha().getStates().get(0).getName());
//    }

    //only for serialization / deserialization
    public AlphaInstance(){
        //if(!DWR.inSerialization()) throw new IllegalStatusError('This constructor is only for DWR instantiation');
    }


    public boolean isCurrentStateCompletable() {
        State currentState = getCurrentState();

        if(currentState==null) return false;

        return currentState.isAllChecked(this);
    }


    public void calculateState(){

        Alpha alpha = getAlpha();

        alpha.getStates();

        for(State state : alpha.getStates()){
            if(state.isAllChecked(this))
                setCurrentStateName(state.getName());
            else
                break;
        }
    }

//    public void advanceStateTo(String stateName) {
//        //TODO: implements
//        setCurrentStateName(stateName);
//    }

    public Object getStateDetails(String stateName, String propName) {

        try {
            return stateDetailsByStateName.get(stateName).get(propName);
        }catch(NullPointerException npe){
            return null;
        }

    }

    public Object setStateDetails(String stateName, String propName, Object value) {

        try {
            if(!stateDetailsByStateName.containsKey(stateName))
                stateDetailsByStateName.put(stateName, new HashMap<String, Object>());

            return stateDetailsByStateName.get(stateName).put(propName, value);
        }catch(NullPointerException npe){
            return null;
        }

    }

    public void aggregateStateDetails(ProcessInstance instance){
       // Map<String, Integer> runningCntByState = new HashMap<String, Integer>();

        PracticeDefinition practiceDefinition;
        try {
            practiceDefinition = ((EssenceProcessDefinition)instance.getProcessDefinition()).getPracticeDefinition();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //replace alpha with actual one
        setClassDefinition((Alpha) practiceDefinition.getElementByName(getAlpha().getName()));


        int totalCount = 0;

        if(getAlpha().getOutgoingRelations()!=null)
        for(Relation relation : getAlpha().getOutgoingRelations()){

            BasicElement element = (BasicElement) relation.getTargetElement();

            if(element instanceof Alpha){
                Alpha subAlpha = (Alpha)element;

                List<AlphaInstance> subAlphaInstances = subAlpha.getInstances(instance);

                if(subAlphaInstances!=null){

                    //reset state details first.
                    for(State state : getAlpha().getStates()){
                        setStateDetails(state.getName(), STATE_PROP_KEY_WorkInProgressCount, null);


                    }



                    int minStateOrder = 1000;

                    for(AlphaInstance subAlphaInstance : subAlphaInstances){
                        String aggregationAlphaStateName = null;

                        if(subAlphaInstance==null) continue; //ignore deleted ones

                        totalCount++;

                        if(subAlphaInstance.getCurrentState()!=null) {
                            Alpha realAlpha = (Alpha) practiceDefinition.getElementByName(subAlphaInstance.getAlpha().getName());

                            subAlphaInstance.setLanguageElement(realAlpha);

                            aggregationAlphaStateName = subAlphaInstance.getCurrentState().getAggregationAlphaState();

                        }

                        //don't validate. sometimes there is nothing related between super and sub alpha
                        //getAlpha().findState(aggregationAlphaStateName);
                        if(!UEngineUtil.isNotEmpty(aggregationAlphaStateName))
                            continue;

                        int runningCntOfThisState = 0;
                        Object wipCntObject = getStateDetails(aggregationAlphaStateName, STATE_PROP_KEY_WorkInProgressCount); //count of 'work in progress'

                        if(wipCntObject!=null)
                            runningCntOfThisState = (int)wipCntObject;

                        setStateDetails(aggregationAlphaStateName, STATE_PROP_KEY_WorkInProgressCount, runningCntOfThisState + 1);


                        int order = 0;
                        for(State state : getAlpha().getStates()){
                            if(state.getName().equals(aggregationAlphaStateName)){
                                break;
                            }
                            order ++;
                        }

                        if(minStateOrder > order) {

                            setCurrentStateName(aggregationAlphaStateName);
                            minStateOrder = order;
                        }
                    }

                }

            }else if(element instanceof WorkProduct){
                WorkProduct subAlpha = (WorkProduct)element;

                List<WorkProductInstance> subAlphaInstances = subAlpha.getInstances(instance);

                if(subAlphaInstances!=null) {
                    totalCount += subAlphaInstances.size();

                    for (WorkProductInstance subAlphaInstance : subAlphaInstances) {

                        String aggregationAlphaStateName = subAlphaInstance.getCurrentLevelOfDetail().getAggregationAlphaState();

                        try {
                            getAlpha().findState(aggregationAlphaStateName);


                            int runningCntOfThisState = 0;
                            Object wipCntObject = getStateDetails(aggregationAlphaStateName, STATE_PROP_KEY_WorkInProgressCount); //count of 'work in progress'

                            if (wipCntObject != null)
                                runningCntOfThisState = (int) wipCntObject;

                            setStateDetails(aggregationAlphaStateName, STATE_PROP_KEY_WorkInProgressCount, runningCntOfThisState + 1);
                        }catch(Exception e){}
                    }
                }
            }

        }

        setSubAlphaInstanceCount(totalCount);
    }

    int subAlphaInstanceCount;
        public int getSubAlphaInstanceCount() {
            return subAlphaInstanceCount;
        }

        public void setSubAlphaInstanceCount(int subAlphaInstanceCount) {
            this.subAlphaInstanceCount = subAlphaInstanceCount;
        }

    /** Rather use Criteria.isReachedToState() instead. **/

//    public boolean meetCriteria(Criterion criterion){
//
//        String currentStateName = getCurrentStateName();
//
//        boolean startCheck = false;
//        for(int i=0; i<getAlpha().getStates().size(); i++){
//            State state = getAlpha().getStates().get(i);
//            if(state.getName().equals(criterion.getState().getName())){
//                startCheck = true;
//            }
//
//            if(startCheck
//                    && state.getName().equals(currentStateName)){
//                return true;
//            }
//        }
//
//        return false;
//    }

}
