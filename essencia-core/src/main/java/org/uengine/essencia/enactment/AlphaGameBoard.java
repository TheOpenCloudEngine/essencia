package org.uengine.essencia.enactment;

import org.metaworks.AllChildFacesAreIgnored;
import org.metaworks.Instance;
import org.metaworks.MetaworksContext;
import org.metaworks.annotation.*;
import org.metaworks.dwr.MetaworksRemoteService;
import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.LanguageElement;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.kernel.ProcessDefinition;
import org.uengine.kernel.ProcessInstance;
import org.uengine.kernel.ProcessVariable;
import org.uengine.kernel.ProcessVariableValue;
import org.uengine.modeling.IElement;
import org.uengine.modeling.Relation;
import org.uengine.processmanager.ProcessManagerRemote;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlphaGameBoard extends MetaworksContext {

    public AlphaGameBoard(String instanceId, Alpha alpha, Map<String, List<AlphaInstanceInList>> alphaInstancesMap) {
        setAlpha(alpha);
        setAlphaInstancesMap(alphaInstancesMap);
        setInstanceId(instanceId);

        setMetaworksContext(new MetaworksContext());
        getMetaworksContext().setWhere("gameboard");

//        AlphaInstanceList alphaInstanceList = new AlphaInstanceList();
//        alphaInstanceList.setLanguageElementType(alpha);
//        alphaInstanceList.addAll(getAlphaInstancesMap().get(alpha.getName()));
//        setAlphaInstances(alphaInstanceList);

        setAlphaInstances(getAlphaInstancesMap().get(alpha.getName()));


        setChildAlphaGameBoards(new ArrayList<AlphaGameBoard>());
        if(alpha.getOutgoingRelations()!=null)
        for(Relation relation : alpha.getOutgoingRelations()){

            LanguageElement childAlpha = (LanguageElement) relation.getTargetElement();

            if(childAlpha instanceof Alpha){

                AlphaGameBoard alphaGameBoard = new AlphaGameBoard(instanceId, (Alpha)childAlpha, alphaInstancesMap);

                getChildAlphaGameBoards().add(alphaGameBoard);
            }
        }


    }

    Map<String, List<AlphaInstanceInList>> alphaInstancesMap;
        public Map<String, List<AlphaInstanceInList>> getAlphaInstancesMap() {
            return alphaInstancesMap;
        }

        public void setAlphaInstancesMap(Map<String, List<AlphaInstanceInList>> alphaInstancesMap) {
            this.alphaInstancesMap = alphaInstancesMap;
        }


//    AlphaInstanceList alphaInstances;
//        public AlphaInstanceList getAlphaInstances() {
//            return alphaInstances;
//        }
//
//        public void setAlphaInstances(AlphaInstanceList alphaInstances) {
//            this.alphaInstances = alphaInstances;
//        }

    List<AlphaInstanceInList> alphaInstances;
        public List<AlphaInstanceInList> getAlphaInstances() {
            return alphaInstances;
        }
        public void setAlphaInstances(List<AlphaInstanceInList> alphaInstances) {
            this.alphaInstances = alphaInstances;
        }

    String instanceId;
        public String getInstanceId() {
            return instanceId;
        }
        public void setInstanceId(String instanceId) {
            this.instanceId = instanceId;
        }




    List<AlphaGameBoard> childAlphaGameBoards;
        public List<AlphaGameBoard> getChildAlphaGameBoards() {
            return childAlphaGameBoards;
        }

        public void setChildAlphaGameBoards(List<AlphaGameBoard> childAlphaGameBoards) {
            this.childAlphaGameBoards = childAlphaGameBoards;
        }

    Alpha alpha;
    @Face(faceClass= AllChildFacesAreIgnored.class)
        public Alpha getAlpha() {
            return alpha;
        }
        public void setAlpha(Alpha alpha) {
            this.alpha = alpha;
        }


    public AlphaGameBoard() throws Exception {
        /*ExampleAlphaInstance exampleAlphaInstance = new ExampleAlphaInstance();

        ProcessInstance instance = exampleAlphaInstance.getProcessInstance();
        ProcessDefinition processDefinition = exampleAlphaInstance.getProcessInstance().getProcessDefinition();

        setAlphaInstances(new HashMap<String, List<? extends LanguageElementInstance>>());


        for(ProcessVariable pv : processDefinition.getProcessVariables()){

            ProcessVariableValue pvv = pv.getMultiple(instance, "");
            Alpha alpha1 = null;
            if(pvv!=null && pvv.size() > 0){
                AlphaInstance alphaInstance = (AlphaInstance) pvv.getValue();
                alpha1 = alphaInstance.getAlpha();

                getAlphaInstances().put(pv.getName(), alpha1.getInstances(instance));

            }
        }

        setAlpha(exampleAlphaInstance.getAlphaInstance().getAlpha());*/

    }


    MetaworksContext metaworksContext;
        public MetaworksContext getMetaworksContext() {
            return metaworksContext;
        }

        public void setMetaworksContext(MetaworksContext metaworksContext) {
            this.metaworksContext = metaworksContext;
        }


    @ServiceMethod(inContextMenu = true, target = ServiceMethod.TARGET_SELF)
    @Available(when="edit")
    public AlphaGameBoard addAlphaInstance(@Payload("instanceId") String instanceId, @Payload("alpha") Alpha alpha) throws Exception {
        LanguageElementInstance alphaInstance = alpha.createObjectInstance();
        alphaInstance.setBeanProperty("id", "New " + alpha.getName());

        ProcessManagerRemote processManagerRemote = MetaworksRemoteService.getComponent(ProcessManagerRemote.class);

        ProcessInstance instance = processManagerRemote.getProcessInstance(getInstanceId());

        ProcessVariableValue processVariableValue = instance.getMultiple("", alpha.getName());

        if(processVariableValue==null){
            processVariableValue = new ProcessVariableValue();
            processVariableValue.setName(alpha.getName());
        }
        processVariableValue.moveToAdd();
        processVariableValue.setValue(alphaInstance);

        instance.set("",  processVariableValue);

        processManagerRemote.applyChanges();


        EssenceProcessDefinition essenceProcessDefinition = (EssenceProcessDefinition) instance.getProcessDefinition();
        PracticeDefinition practiceDefinition = essenceProcessDefinition.getPracticeDefinition();
        GameBoard gameBoard = new GameBoard(instance, true);

        AlphaGameBoard alphaGameBoard = new AlphaGameBoard(getInstanceId(), (Alpha) practiceDefinition.getElementByName(alpha.getName()), gameBoard.getAlphaInstancesMap());

        //MetaworksRemoteService.wrapReturn(alphaGameBoard);

        return alphaGameBoard;
    }

}
