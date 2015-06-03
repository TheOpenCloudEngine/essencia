package org.uengine.essencia.enactment;

import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.LanguageElement;
import org.uengine.essencia.model.State;
import org.uengine.kernel.ProcessInstance;

import java.util.*;

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


    transient  Map<String, Map<String, Object>> stateDetailsByStateName = new HashMap<String, Map<String, Object>>();
//        public Map<String, Map<String, Object>> getStateDetailsByStateName() {
//            return stateDetailsByStateName;
//        }
//        public void setStateDetailsByStateName(Map<String, Map<String, Object>> stateDetailsByStateName) {
//            this.stateDetailsByStateName = stateDetailsByStateName;
//        }


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


    public void advanceState(ProcessInstance instance){

        if(!isCurrentStateCompletable()){
            throw new NotCompletableException("Not completable");
        }else{


            int currentStateIndex = getAlpha().getList().indexOf(getCurrentState());

            if(currentStateIndex < getAlpha().getList().size() -1){
                currentStateIndex ++;
                State currentState = getAlpha().getList().get(currentStateIndex);
                setCurrentStateName(currentState.getName());
            }

//            //TODO: affect to related alphas:
//            if(getCurrentState().getAggregationAlphaState()!=null){
//
//                String [] relatedAlphaAndStateName = getCurrentState().getAggregationAlphaState().split("\\.");
//
//                if(relatedAlphaAndStateName.length < 2){
//                    throw new RuntimeException("Association reference expression is not properly defined: " + getCurrentState().getAggregationAlphaState() + ". [AlphaName].[StateName] is correnct.");
//                }
//
//                String relatedAlphaName = relatedAlphaAndStateName[0];
//                String relatedStateName = relatedAlphaAndStateName[1];//
//
//                AlphaInstance relatedAlphaInstance = null;
//                try {
//                    relatedAlphaInstance = (AlphaInstance) instance.get(relatedAlphaName);
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
//
//                if(relatedAlphaInstance==null)
//                    throw new RuntimeException(getAlpha().getName() + " tries to affect state change to related (parent) Alpha [" + relatedAlphaName + "]. There's no mapped alpha or alpha instance: " + relatedAlphaName);
//
//                relatedAlphaInstance.advanceStateTo(relatedStateName);
//            }

        }

    }

    public void advanceStateTo(String stateName) {
        //TODO: implements
        setCurrentStateName(stateName);
    }

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

        int totalCount = 0;
        for(LanguageElement element : getAlpha().getChildElements()){
            if(element instanceof Alpha){
                Alpha subAlpha = (Alpha)element;

                List<AlphaInstance> subAlphaInstances = subAlpha.getInstances(instance);

                totalCount += subAlphaInstances.size();

                for(AlphaInstance subAlphaInstance : subAlphaInstances){

                    String aggregationAlphaStateName = subAlphaInstance.getCurrentState().getAggregationAlphaState();

                    getAlpha().findState(aggregationAlphaStateName);


                    int runningCntOfThisState = 0;
                    Object wipCntObject = getStateDetails(aggregationAlphaStateName, "WIPCount"); //count of 'work in progress'

                    if(wipCntObject!=null)
                        runningCntOfThisState = (int)wipCntObject;

                    setStateDetails(aggregationAlphaStateName, "WIPCount", runningCntOfThisState + 1);
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

}
