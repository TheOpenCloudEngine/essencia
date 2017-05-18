package org.uengine.essencia.enactment;

import org.metaworks.AllChildFacesAreIgnored;
import org.metaworks.Instance;
import org.metaworks.MetaworksContext;
import org.metaworks.annotation.*;
import org.metaworks.dao.TransactionAdvice;
import org.metaworks.dao.TransactionContext;
import org.metaworks.dwr.MetaworksRemoteService;
import org.uengine.codi.mw3.model.CommentWorkItem;
import org.uengine.codi.mw3.model.Session;
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

@Face(ejsPathMappingByContext = {"{how:'agile', face:'dwr/metaworks/org/uengine/essencia/enactment/AlphaGameBoard_agile_board.ejs'}"})
public class AlphaGameBoard extends MetaworksContext {

    boolean topLevel;
        public boolean isTopLevel() {
            return topLevel;
        }
        public void setTopLevel(boolean topLevel) {
            this.topLevel = topLevel;
        }


    public AlphaGameBoard(String instanceId, Alpha alpha, Map<String, List<AlphaInstanceInList>> alphaInstancesMap) {
        setAlpha(alpha);
        setAlphaInstancesMap(alphaInstancesMap);
        setInstanceId(instanceId);

        setMetaworksContext(new MetaworksContext());
        getMetaworksContext().setWhere("gameboard");
        getMetaworksContext().setHow("agile");//agile as default

//        AlphaInstanceList alphaInstanceList = new AlphaInstanceList();
//        alphaInstanceList.setLanguageElementType(alpha);
//        alphaInstanceList.addAll(getAlphaInstancesMap().get(alpha.getName()));
//        setAlphaInstances(alphaInstanceList);

        setAlphaInstances(getAlphaInstancesMap().get(alpha.getName()));


        String essencia_alreadyLoaded_gameboard = "essencia_alreadyLoaded_gameboard";
        HashMap<String, String> alreadyLoaded = (HashMap<String, String>) TransactionContext.getThreadLocalInstance().getSharedContext(essencia_alreadyLoaded_gameboard);
        if(alreadyLoaded==null) {
            alreadyLoaded = new HashMap<String, String>();
            TransactionContext.getThreadLocalInstance().setSharedContext(essencia_alreadyLoaded_gameboard, alreadyLoaded);
        }

        setChildAlphaGameBoards(new ArrayList<AlphaGameBoard>());

        if(alpha.getOutgoingRelations()!=null)
        for(Relation relation : alpha.getOutgoingRelations()){

            LanguageElement childAlpha = (LanguageElement) relation.getTargetElement();

            if(childAlpha instanceof Alpha && !alreadyLoaded.containsKey(childAlpha.getName())){
                alreadyLoaded.put(childAlpha.getName(), childAlpha.getName());

                AlphaGameBoard alphaGameBoard = new AlphaGameBoard(instanceId, (Alpha)childAlpha, alphaInstancesMap);
                alphaGameBoard.getMetaworksContext().setWhen(MetaworksContext.WHEN_EDIT);

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


    @AutowiredFromClient
    public Session session;

    @ServiceMethod(inContextMenu = true, target = ServiceMethod.TARGET_SELF)
    @Available(when="edit")
    public AlphaGameBoard addAlphaInstance(@Payload("instanceId") String instanceId, @Payload("alpha") Alpha alpha) throws Exception {

        TransactionContext.getThreadLocalInstance().setMW3FaceOptionEnabled(false);

        //TODO: [tunning] find why there is no proper className firstly
        if(alpha.getFieldDescriptors()==null){
            LanguageElementInstance alphaInstance = alpha.createObjectInstance();

            ProcessManagerRemote processManagerRemote = MetaworksRemoteService.getComponent(ProcessManagerRemote.class);
            ProcessInstance instance = processManagerRemote.getProcessInstance(instanceId);

            alphaInstance.setClassName("codi/" + instance.getProcessDefinition().getId() + "#" + alphaInstance.getClassDefinition().getName());

            alphaInstance.fillClassDefinition(alphaInstance.getClassName());  ////
            alpha = (Alpha) alphaInstance.getLanguageElement();
        }

        LanguageElementInstance alphaInstance = alpha.createObjectInstance();
        alphaInstance.setBeanProperty("Id", "New " + alpha.getName());
        alphaInstance.setId("New " + alpha.getName());


        ProcessManagerRemote processManagerRemote = MetaworksRemoteService.getComponent(ProcessManagerRemote.class);

        ProcessInstance instance = processManagerRemote.getProcessInstance(getInstanceId());

        ProcessVariableValue processVariableValue = instance.getMultiple("", alpha.getName());  //

        if(processVariableValue==null){
            processVariableValue = new ProcessVariableValue();
            processVariableValue.setName(alpha.getName());
        }
        processVariableValue.moveToAdd();
        processVariableValue.setValue(alphaInstance);

        {//add register log
            CommentWorkItem commentWorkItem = new CommentWorkItem();
            commentWorkItem.setTitle("Registered this alpha instance.");
            commentWorkItem.setWriter(session.getUser());
            commentWorkItem.setInstId(null);
            commentWorkItem.setRootInstId(Long.valueOf(instance.getRootProcessInstanceId()));

            MetaworksRemoteService.autowire(commentWorkItem);

            try {
                commentWorkItem.add(); // inside this, there's a applyChanges method will be invoked that problematic

                Long subInstanceId = commentWorkItem.getInstId();
                alphaInstance.getValueMap().put(AlphaInstance.VALUEMAP_KEY_COMMENT_INST_ID, ""+subInstanceId);

                ProcessInstance theSubProcessContainingComments = processManagerRemote.getProcessInstance(""+subInstanceId);
                theSubProcessContainingComments.setMainProcessInstanceId(instance.getRootProcessInstanceId());

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }



        instance.set("",  processVariableValue);

        processManagerRemote.applyChanges(); ///


        EssenceProcessDefinition essenceProcessDefinition = (EssenceProcessDefinition) instance.getProcessDefinition();
        PracticeDefinition practiceDefinition = essenceProcessDefinition.getPracticeDefinition();
        GameBoard gameBoard = new GameBoard(instance, true);  //

        AlphaGameBoard alphaGameBoard = new AlphaGameBoard(getInstanceId(), (Alpha) practiceDefinition.getElementByName(alpha.getName()), gameBoard.getAlphaInstancesMap());
        alphaGameBoard.getMetaworksContext().setWhen(MetaworksContext.WHEN_EDIT);

        //MetaworksRemoteService.wrapReturn(alphaGameBoard);


        return alphaGameBoard;
    }

}
