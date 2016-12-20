package org.uengine.essencia.enactment;

import org.metaworks.AllChildFacesAreIgnored;
import org.metaworks.annotation.Face;
import org.metaworks.dwr.MetaworksRemoteService;
import org.uengine.essencia.enactment.face.AlphaInstanceFace2;
import org.uengine.essencia.model.*;
import org.uengine.kernel.ProcessInstance;
import org.uengine.modeling.Relation;
import org.uengine.modeling.resource.DefaultResource;
import org.uengine.modeling.resource.ResourceManager;
import org.uengine.util.UEngineUtil;

import java.util.*;

@Face(faceClass= AlphaInstanceFace2.class)
public class AlphaInstance extends LanguageElementInstance {

    public static String STATE_PROP_KEY_WorkInProgressCount = "WIPCount";
    public static String STATE_PROP_KEY_DueDate = "Due";

    @Face(faceClass=AllChildFacesAreIgnored.class)
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

            if(getAlpha()==null) return null;

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


    public void calculateState(ProcessInstance instance){

        Alpha alpha = getAlpha();

        alpha.getStates();



        //// calculate Current State
        if(alpha.getStates()!=null)
        for(State state : alpha.getStates()){
            if(state.isAllChecked(this))
//                if(state == alpha.getStates().get(alpha.getStates().size() - 1)){ //if last
//                    setCurrentStateName("completed");
//                } else
                setCurrentStateName(state.getName());
            else
                break;
        }

        //// calculate Target State
        java.util.Date today = new java.util.Date();


        if(alpha.getStates()!=null) {
            for (State state : alpha.getStates()) {
                java.util.Date dueDate = (Date) getStateDetails(state.getName(), STATE_PROP_KEY_DueDate);

                //amend the due date from kernel if there is.
                if (dueDate == null && state.getAggregationAlphaState()!=null) {

                    String[] processResourceNameAndLanguageElementName = getClassName().split("\\#");

                    ResourceManager resourceManager = MetaworksRemoteService.getComponent(ResourceManager.class);

                    String resourcePath = processResourceNameAndLanguageElementName[0];

                    if (resourcePath.startsWith("codi/codi/"))
                        resourcePath = resourcePath.substring("codi/".length(), resourcePath.length());

                    DefaultResource classDefinitionResource = new DefaultResource(resourcePath);
                    try {
                        EssenceProcessDefinition definition = (EssenceProcessDefinition) resourceManager.getObject(classDefinitionResource);
                        BasicElement element = (BasicElement) definition.getPracticeDefinition().getElementByName(getAlpha().getName());
                        BasicElement kernel = (BasicElement) element.getIncomingRelations().get(0).getSourceElement();

                        if(kernel!=null && kernel instanceof Alpha){

                            Alpha kernelAlpha = (Alpha)kernel;
                            for(State kernelState : kernelAlpha.getStates()){
                                if(kernelState.getName().equals(state.getAggregationAlphaState())){
                                    List<LanguageElementInstance> kernelInstances = (List<LanguageElementInstance>) kernel.getInstances(instance);
                                    if(kernelInstances.size() > 0){
                                        AlphaInstance kernelAlphaInstance = (AlphaInstance) kernelInstances.get(0);
                                        Date dueDateFromKernel = (Date) kernelAlphaInstance.getStateDetails(kernelState.getName(), AlphaInstance.STATE_PROP_KEY_DueDate);

                                        if(dueDateFromKernel!=null)
                                            dueDate = dueDateFromKernel;

                                        break;
                                    }

                                }
                            }

                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                if (dueDate != null && today.after(dueDate)) {
                    setTargetStateName(state.getName());
                }
            }
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

        if(getAlpha().getOutgoingRelations()!=null) {


            // count sub alpha instances firstly.
            for(Relation relation : getAlpha().getOutgoingRelations()) { //for root alphas

                BasicElement element = (BasicElement) relation.getTargetElement();

                if (element instanceof Alpha) {
                    Alpha subAlpha = (Alpha) element;

                    List<AlphaInstance> subAlphaInstances = subAlpha.getInstances(instance);

                    if (subAlphaInstances != null) {

                        for (AlphaInstance subAlphaInstance : subAlphaInstances) {
                            if (subAlphaInstance == null) continue; //ignore deleted ones

                            totalCount++;
                        }
                    }
                }
            }


            setSubAlphaInstanceCount(totalCount);


            for (Relation relation : getAlpha().getOutgoingRelations()) { //for root alphas

                BasicElement element = (BasicElement) relation.getTargetElement();

                if (element instanceof Alpha) {
                    Alpha subAlpha = (Alpha) element;

                    List<AlphaInstance> subAlphaInstances = subAlpha.getInstances(instance);

                    if (subAlphaInstances != null) {

                        //reset state details first.
                        for (State state : getAlpha().getStates()) {
                            setStateDetails(state.getName(), STATE_PROP_KEY_WorkInProgressCount, null);
                        }

                        int minStateOrder = 1000;

                        boolean subAlphaIsConnectedWithAggregation = false;

                        for (AlphaInstance subAlphaInstance : subAlphaInstances) {
                            String aggregationAlphaStateName = null;

                            if (subAlphaInstance == null) continue; //ignore deleted ones

                            if (subAlphaInstance.getCurrentState() != null) {
                                Alpha realAlpha = (Alpha) practiceDefinition.getElementByName(subAlphaInstance.getAlpha().getName());

                                subAlphaInstance.setLanguageElement(realAlpha);

                                aggregationAlphaStateName = subAlphaInstance.getCurrentState().getAggregationAlphaState();
                            }

                            //don't validate. sometimes there is nothing related between super and sub alpha
                            //getAlpha().findState(aggregationAlphaStateName);
                            if (!UEngineUtil.isNotEmpty(aggregationAlphaStateName))
                                continue;

                            subAlphaIsConnectedWithAggregation = true;

                            int runningCntOfThisState = 0;
                            Object wipCntObject = getStateDetails(aggregationAlphaStateName, STATE_PROP_KEY_WorkInProgressCount); //count of 'work in progress'

                            if (wipCntObject != null)
                                runningCntOfThisState = (int) wipCntObject;

                            setStateDetails(aggregationAlphaStateName, STATE_PROP_KEY_WorkInProgressCount, ++runningCntOfThisState);

                        }


                        if(subAlphaIsConnectedWithAggregation) {
                            //calculate the parent alpha's current state
                            boolean neverStarted = true;
                            for (State state : getAlpha().getStates()) {
                                Object wipCntObject = getStateDetails(state.getName(), STATE_PROP_KEY_WorkInProgressCount); //count of 'work in progress'

                                int runningCntOfThisState = 0;

                                if (wipCntObject != null)
                                    runningCntOfThisState = (int) wipCntObject;

                                if (runningCntOfThisState == 0) {
                                    setCurrentStateName(state.getName());
                                } else if (runningCntOfThisState > 0) {
                                    setCurrentStateName(state.getName());

                                    neverStarted = false;

                                    break;
                                }
                            }

                            if(neverStarted) setCurrentStateName(null);
                        }



                    }

                }

            }
        }


    }

    int subAlphaInstanceCount;
        public int getSubAlphaInstanceCount() {
            return subAlphaInstanceCount;
        }

        public void setSubAlphaInstanceCount(int subAlphaInstanceCount) {
            this.subAlphaInstanceCount = subAlphaInstanceCount;
        }


    public void fillStates() {
        if(getClassName()!=null && (getAlpha()==null || getAlpha().getStates()==null)){
            try {
                fillClassDefinition(getClassName());
            } catch (Exception e) {
//                throw new RuntimeException("failed to fill up alpha definition", e);
            }
        }
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
