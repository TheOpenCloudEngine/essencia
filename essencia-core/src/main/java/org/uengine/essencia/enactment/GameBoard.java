package org.uengine.essencia.enactment;

import org.metaworks.ContextAware;
import org.metaworks.MetaworksContext;
import org.metaworks.annotation.*;
import org.metaworks.dwr.MetaworksRemoteService;
import org.springframework.stereotype.Service;
import org.uengine.essencia.model.*;
import org.uengine.kernel.ProcessDefinition;
import org.uengine.kernel.ProcessInstance;
import org.uengine.kernel.ProcessVariable;
import org.uengine.kernel.ProcessVariableValue;
import org.uengine.modeling.IElement;
import org.uengine.modeling.Relation;
import org.uengine.processmanager.ProcessManagerRemote;
import org.uengine.uml.model.Attribute;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameBoard implements ContextAware{

    public GameBoard(){}

    List<AlphaGameBoard> alphaGameBoards;
        public List<AlphaGameBoard> getAlphaGameBoards() {
            return alphaGameBoards;
        }
        public void setAlphaGameBoards(List<AlphaGameBoard> alphaGameBoards) {
            this.alphaGameBoards = alphaGameBoards;
        }

    Map<String, List<AlphaInstanceInList>> alphaInstancesMap;
        public Map<String, List<AlphaInstanceInList>> getAlphaInstancesMap() {
            return alphaInstancesMap;
        }

        public void setAlphaInstancesMap(Map<String, List<AlphaInstanceInList>> alphaInstancesMap) {
            this.alphaInstancesMap = alphaInstancesMap;
        }

    String instanceId;
    @Id
        public String getInstanceId() {
            return instanceId;
        }
        public void setInstanceId(String instanceId) {
            this.instanceId = instanceId;
        }



    public GameBoard(ProcessInstance instance, boolean editable) throws Exception {
        load(instance, editable);
    }

    public void load(ProcessInstance instance, boolean editable) throws Exception {

        setInstanceId(instance.getInstanceId());

        PracticeDefinition practiceDefinition;

        EssenceProcessDefinition essenceProcessDefinition = (EssenceProcessDefinition) instance.getProcessDefinition();
        practiceDefinition = essenceProcessDefinition.getPracticeDefinition();

        if(editable) {
            setMetaworksContext(new MetaworksContext());
            getMetaworksContext().setWhen(MetaworksContext.WHEN_EDIT);
        }

        practiceDefinition.arrangeRelations();

        ProcessDefinition processDefinition = instance.getProcessDefinition();
        setAlphaGameBoards(new ArrayList<AlphaGameBoard>());

        alphaInstancesMap = new HashMap<String, List<AlphaInstanceInList>>();


        for(IElement element : practiceDefinition.getElementList()){
            if(element instanceof Alpha){

                Alpha alpha = (Alpha)element;
                List<AlphaInstanceInList> alphaInstanceInLists = alpha.getInstanceInLists(instance, !editable /*means not sorted*/);

                if(alphaInstanceInLists==null || alphaInstanceInLists.size()==0){
                    alphaInstanceInLists = new ArrayList<AlphaInstanceInList>();

                    AlphaInstance alphaInstance = alpha.createObjectInstance();
                    alphaInstance.setId(alpha.getName());

                    AlphaInstanceInList alphaInstanceInList = new AlphaInstanceInList(alphaInstance, instance, 0);
                    alphaInstanceInLists.add(alphaInstanceInList);

                }

                for(AlphaInstanceInList alphaInstanceInList : alphaInstanceInLists){
                    ((AlphaInstance)alphaInstanceInList.getLanguageElementInstance()).aggregateStateDetails(instance);
                }


                alphaInstancesMap.put(alpha.getName(), alphaInstanceInLists);

            }

        }


        for(IElement element : practiceDefinition.getElementList()){

            if(element instanceof Practice){

                Practice practice = (Practice) element;

                for(Relation relation : practice.getOutgoingRelations()){
                    if(relation.getTargetElement() instanceof Alpha){
                        AlphaGameBoard alphaGameBoard = new AlphaGameBoard(instance.getInstanceId(), (Alpha)relation.getTargetElement(), alphaInstancesMap);
                        getAlphaGameBoards().add(alphaGameBoard);
                    }
                }

            }

        }

    }

    MetaworksContext metaworksContext;
        @Override
        public MetaworksContext getMetaworksContext() {
            return metaworksContext;
        }
        @Override
        public void setMetaworksContext(MetaworksContext metaworksContext) {
            this.metaworksContext = metaworksContext;
        }

    @ServiceMethod(target = ServiceMethod.TARGET_SELF, inContextMenu = true)
    public GameBoard toggleEditable() throws Exception {

        boolean editable = (getMetaworksContext()!=null && MetaworksContext.WHEN_EDIT.equals(getMetaworksContext().getWhen()));

        ProcessManagerRemote processManagerRemote = MetaworksRemoteService.getComponent(ProcessManagerRemote.class);

        ProcessInstance instance = processManagerRemote.getProcessInstance(getInstanceId());

        return new GameBoard(instance, !editable);
    }
//
//    @ServiceMethod(target = ServiceMethod.TARGET_SELF, inContextMenu = true)
//    @Available(when=MetaworksContext.WHEN_EDIT)
//    public GameBoard editable() throws Exception {
//        return toggleEditable();
//    }
//
//    @ServiceMethod(target = ServiceMethod.TARGET_SELF, inContextMenu = true)
//    @Hidden(when=MetaworksContext.WHEN_EDIT)
//    public GameBoard view() throws Exception {
//        return toggleEditable();
//    }

}
