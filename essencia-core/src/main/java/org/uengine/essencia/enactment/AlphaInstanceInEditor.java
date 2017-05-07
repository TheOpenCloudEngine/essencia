package org.uengine.essencia.enactment;

import org.metaworks.*;
import org.metaworks.annotation.*;
import org.metaworks.annotation.Face;
import org.metaworks.dwr.MetaworksRemoteService;
import org.metaworks.widget.ModalWindow;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.uengine.codi.mw3.model.IWorkItem;
import org.uengine.codi.mw3.model.InstanceViewThreadPanel;
import org.uengine.codi.mw3.model.Session;
import org.uengine.essencia.model.*;
import org.uengine.kernel.AwareProcessInstanceId;
import org.uengine.kernel.ProcessInstance;
import org.uengine.kernel.VariablePointer;
import org.uengine.modeling.Relation;
import org.uengine.processmanager.ProcessManagerRemote;
import org.uengine.uml.model.ClassDefinition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jjy on 2015. 12. 23..
 */
@Face(ejsPath="genericfaces/CleanObjectFace.ejs")
public class AlphaInstanceInEditor extends AlphaInstanceInList implements AwareProcessInstanceId {

    @Hidden
    @Available(when="NONE")
    public void edit(@Payload("instanceId") String instanceId, @Payload("variablePointer") VariablePointer variablePointer) throws Exception {
    //    super.edit(instanceId, variablePointer);
    }

    @Override
    @Hidden(on = false)
    @Order(1)
    public LanguageElementInstance getLanguageElementInstance() {
        return super.getLanguageElementInstance();
    }

    @Autowired
    public ProcessManagerRemote processManagerRemote;


    @AutowiredFromClient
    public Session session;

    @ServiceMethod(
            payload = {
                    "instanceId",
                    "variablePointer",
                    "languageElementInstance.className",
                    "languageElementInstance.currentStateName",
                    "languageElementInstance._face_",
                    "languageElementInstance.valueMap"
                },
        target=ServiceMethod.TARGET_POPUP
    )
    public void save() throws Exception {
        ProcessInstance instance = processManagerRemote.getProcessInstance(getInstanceId());

        if(getLanguageElementInstance() instanceof AlphaInstance){
            AlphaInstance alphaInstance = ((AlphaInstance) getLanguageElementInstance());
            alphaInstance.fillStates();
            alphaInstance.calculateState(instance);
        }

        AlphaInstance beforeAlphaInstance = (AlphaInstance) variablePointer.getValue(instance);

        signalBeforeAfter(beforeAlphaInstance, (AlphaInstance) getLanguageElementInstance(), instance);

        variablePointer.setValue(instance, getLanguageElementInstance());

        processManagerRemote.applyChanges();

        // finding parent alpha instances should be refreshed
        AlphaInstanceInList alphaInstanceListToRefresh = null;

        PracticeDefinition practiceDefinition = ((EssenceProcessDefinition)instance.getProcessDefinition()).getPracticeDefinition();
        BasicElement alphaOrWP = (BasicElement) practiceDefinition.getElementByName(getLanguageElementInstance().getLanguageElement().getName());

        if(alphaOrWP.getIncomingRelations()!=null){

            for(Relation relation : alphaOrWP.getIncomingRelations()){
                if(relation.getSourceElement() instanceof Alpha){ //if the element has kernel, this mean if there's one or more kernel elements, the root can't be aggregated.
                    Alpha parentAlpha = (Alpha)relation.getSourceElement();

                    List<AlphaInstance> parentAlphaInstances = parentAlpha.getInstances(instance);
                    int i = -1;

                    if(parentAlphaInstances==null){  //parent alpha should be a kernel alpha, and it never have a instance value or just have single instance.
                        AlphaInstance parentAlphaObjectInstance = (AlphaInstance) parentAlpha.createObjectInstance();

                        parentAlphaObjectInstance.aggregateStateDetails(instance);

                        alphaInstanceListToRefresh = new AlphaInstanceInList(parentAlphaObjectInstance, instance, 0);
                    }else {

                        Map<String, Integer> rowSpanMap = new HashMap<String, Integer>();
                        AlphaInstance prevInstance = null;

                        for(AlphaInstance alphaInstance : parentAlphaInstances){

                            i++;

                            if(alphaInstance==null) continue;

                            alphaInstance.aggregateStateDetails(instance);

                            alphaInstanceListToRefresh = new AlphaInstanceInList(alphaInstance, instance, i);

                            ClassDefinition type = alphaInstance.getAlpha();

                        }
                    }

                }
            }

        }

        getLanguageElementInstance().setId((String) getLanguageElementInstance().getAttribute("Id"));

        AlphaInstanceInList alphaInstanceInList = new AlphaInstanceInList();
        BeanUtils.copyProperties(this, alphaInstanceInList);
        alphaInstanceInList.setMetaworksContext(new MetaworksContext());
        alphaInstanceInList.getMetaworksContext().setWhen(MetaworksContext.WHEN_EDIT);
        alphaInstanceInList.getMetaworksContext().setHow("agile");

        if(false) { //if agile mode
            MetaworksRemoteService.wrapReturn(new ToEvent(new GameBoard(), "refresh"), new Remover(new ModalWindow()));

            return;
        }

        if(alphaInstanceListToRefresh!=null){
            MetaworksRemoteService.wrapReturn(new ToOpener(alphaInstanceInList)/*, new Refresh(alphaInstanceListToRefresh)*/, new Remover(new ModalWindow()), new ToEvent(new Abacus(), "refresh"));

//            HashMap<String, String> pushUserMap = new HashMap<String, String>();
//            pushUserMap.put("3","3");
//
//            MetaworksRemoteService.pushClientObjectsFiltered(
//                    new OtherSessionFilter(pushUserMap, session.getUser().getUserId().toUpperCase()),
//                    new Object[]{new Refresh(alphaInstanceInList), new Refresh(alphaInstanceListToRefresh)});

        }else{
            MetaworksRemoteService.wrapReturn(new ToOpener(alphaInstanceInList), new Remover(new ModalWindow()));

//            HashMap<String, String> pushUserMap = new HashMap<String, String>();
//            pushUserMap.put("4","4");
//
//            MetaworksRemoteService.pushClientObjectsFiltered(
//                    new OtherSessionFilter(pushUserMap, session.getUser().getUserId().toUpperCase()),
//                    new Object[]{new Refresh(alphaInstanceInList)});
        }
    }

    private void signalBeforeAfter(AlphaInstance beforeAlphaInstance, AlphaInstance afterAlphaInstance, ProcessInstance instance) {
        beforeAlphaInstance.aggregateStateDetails(instance);
        State beforeState = beforeAlphaInstance.getCurrentState();
        State afterState = afterAlphaInstance.getCurrentState();


        int indexOfBeforeState = beforeAlphaInstance.getAlpha().getStates().indexOf(beforeState);
        int indexOfAfterState = afterAlphaInstance.getAlpha().getStates().indexOf(afterState);

        int proceed = (indexOfAfterState - indexOfBeforeState);

        boolean everChanged = false;

        afterAlphaInstance.afterDeserialization();//not good

        String json =
                "{for: '" + beforeAlphaInstance.getAlpha().getName() + ":" + afterAlphaInstance.getId() + "'"
                + ", proceed: " + proceed
                +", beforeState: '" + (beforeState!=null ? beforeState.getName() : "none") + "', afterState: '" + (afterState != null ? afterState.getName() : "none") + "'"
                +", changedCheckpoints: [";


        for(State state : beforeAlphaInstance.getAlpha().getStates()){ //for all states
            for(CheckPoint checkpoint: state.getCheckPoints()){

                boolean beforeChecked = beforeAlphaInstance.isChecked(checkpoint.getName());
                boolean afterChecked = afterAlphaInstance.isChecked(checkpoint.getName());
                int mark = 0;

                if(!beforeChecked && afterChecked) mark = 1;
                else if(beforeChecked && !afterChecked) mark = -1;

                if(beforeChecked != afterChecked){
                    everChanged = true;
                    json = json + "{mark: " + mark + ", state: '" + state.getName() + "', name:'" + checkpoint.getName() + "'},";
                }
            }
        }

        json = json + "]}";

        if(everChanged){
            StateDiffCommentWorkItem commentWorkItem = new StateDiffCommentWorkItem();
            commentWorkItem.setTitle("Changed project states.");
            commentWorkItem.setWriter(session.getUser());
            commentWorkItem.setContent(json);
            commentWorkItem.setInstId(Long.valueOf(instance.getInstanceId()));

            MetaworksRemoteService.autowire(commentWorkItem);

            try {
                commentWorkItem.add();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    @Hidden
    @Available(when="NONE")
    public void delete(@Payload("instanceId") String instanceId, @Payload("variablePointer") VariablePointer variablePointer) throws Exception {
    }



    IWorkItem newComment;
    @Order(30)
        public IWorkItem getNewComment() {
            return newComment;
        }
        public void setNewComment(IWorkItem newComment) {
            this.newComment = newComment;
        }

    @Override
    public String getProcessInstanceId() {
        return getInstanceId();
    }


    InstanceViewThreadPanel instanceViewThreadPanel;
        @Order(31)
        public InstanceViewThreadPanel getInstanceViewThreadPanel() {
            return instanceViewThreadPanel;
        }
        public void setInstanceViewThreadPanel(InstanceViewThreadPanel instanceViewThreadPanel) {
            this.instanceViewThreadPanel = instanceViewThreadPanel;
        }

}
