package org.uengine.essencia.enactment;

import org.metaworks.ContextAware;
import org.metaworks.MetaworksContext;
import org.metaworks.annotation.*;
import org.metaworks.dwr.MetaworksRemoteService;
import org.metaworks.widget.ModalWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.uengine.codi.mw3.model.*;
import org.uengine.kernel.ProcessInstance;
import org.uengine.kernel.ProcessVariableValue;
import org.uengine.kernel.VariablePointer;
import org.uengine.processmanager.ProcessManagerRemote;

import java.util.Map;


/**
 * Created by jjy on 2015. 12. 23..
 */

@Face(
        ejsPathForArray = "dwr/metaworks/org/uengine/essencia/enactment/AlphaInstanceTableFace.ejs",
        ejsPathMappingByContext = "{how:'agile', face:'dwr/metaworks/org/uengine/essencia/enactment/AlphaInstanceInList_agile_board.ejs'}"
)
public class AlphaInstanceInList implements ContextAware{

    public AlphaInstanceInList(LanguageElementInstance objectInstance, ProcessInstance instance, int index) {
        setLanguageElementInstance(objectInstance);

        setVariablePointer(new VariablePointer());
        getVariablePointer().setKey(objectInstance.getLanguageElement().getName());
        getVariablePointer().setIndex(index);

        setInstanceId(instance.getInstanceId());

    }

    public AlphaInstanceInList(){}//for dwr

    String instanceId;
    @Hidden
        public String getInstanceId() {
            return instanceId;
        }
        public void setInstanceId(String instanceId) {
            this.instanceId = instanceId;
        }


    VariablePointer variablePointer;
    @Hidden
        public VariablePointer getVariablePointer() {
            return variablePointer;
        }
        public void setVariablePointer(VariablePointer variablePointer) {
            this.variablePointer = variablePointer;
        }


    LanguageElementInstance languageElementInstance;
    @Hidden
    @Id
        public LanguageElementInstance getLanguageElementInstance() {
            return languageElementInstance;
        }
        public void setLanguageElementInstance(LanguageElementInstance languageElementInstance) {
            this.languageElementInstance = languageElementInstance;
        }

    @Autowired
    public ProcessManagerRemote processManagerRemote;

    @ServiceMethod(target=ServiceMethod.TARGET_POPUP, inContextMenu = true/*, mouseBinding = "double-click"*/)
    @Available(when=MetaworksContext.WHEN_EDIT)
    public void edit(@Payload("instanceId") String instanceId, @Payload("variablePointer") VariablePointer variablePointer, @AutowiredFromClient Session session) throws Exception {

        AlphaInstanceInEditor alphaInstanceInEditor = new AlphaInstanceInEditor();
        alphaInstanceInEditor.setInstanceId(instanceId);
        alphaInstanceInEditor.setVariablePointer(variablePointer);

        ProcessInstance instance = processManagerRemote.getProcessInstance(getInstanceId());
        LanguageElementInstance leInstance = (LanguageElementInstance) variablePointer.getValue(instance);

        if(leInstance instanceof AlphaInstance){
            ((AlphaInstance) leInstance).calculateState(instance);
        }

        alphaInstanceInEditor.setLanguageElementInstance(leInstance);

        //set the languageElement edit context.
        {
            if (alphaInstanceInEditor.getLanguageElementInstance().getMetaworksContext() == null)
                alphaInstanceInEditor.getLanguageElementInstance().setMetaworksContext(new MetaworksContext());

            alphaInstanceInEditor.getLanguageElementInstance().getMetaworksContext().setWhen(MetaworksContext.WHEN_EDIT);
        }

        //set the comment part
        String commentInstanceId = (String) alphaInstanceInEditor.getLanguageElementInstance().getValueMap().get("__commentInstId");
        if(commentInstanceId==null) {
            CommentWorkItem newComment = new AlphaInstanceCommentWorkItem();
            User writer = new User();
            writer.copyFrom(session.getUser());
            writer.setMetaworksContext(new MetaworksContext());

            newComment.session = session;
            newComment.setWriter(writer);

            alphaInstanceInEditor.setNewComment(newComment);
        }else{

            InstanceViewThreadPanel instanceViewThreadPanel = MetaworksRemoteService.getComponent(InstanceViewThreadPanel.class);
            instanceViewThreadPanel.load(commentInstanceId);
            instanceViewThreadPanel.getMetaworksContext().setWhen(MetaworksContext.WHEN_VIEW);
            alphaInstanceInEditor.setInstanceViewThreadPanel(instanceViewThreadPanel);

        }



        if(leInstance==null) throw new Exception("There's no alpha value. It maybe removed by other people. Please refresh your screen.");

        //reset the className information so that the user interface can be loaded.
        leInstance.setClassName("codi/" + instance.getProcessDefinition().getId() + "#" + leInstance.getClassDefinition().getName());

        ModalWindow modalWindow = new ModalWindow(alphaInstanceInEditor, 1000, 700, "Edit Alpha Instance");
        modalWindow.getMetaworksContext().setWhen(MetaworksContext.WHEN_EDIT);
        MetaworksRemoteService.wrapReturn(modalWindow);
    }

    @ServiceMethod(target=ServiceMethod.TARGET_SELF, inContextMenu = true, needToConfirm = true)
    @Available(when=MetaworksContext.WHEN_EDIT)
    public void delete(@Payload("instanceId") String instanceId, @Payload("variablePointer") VariablePointer variablePointer) throws Exception {

        ProcessInstance instance = processManagerRemote.getProcessInstance(getInstanceId());

        ProcessVariableValue processVariableValue = instance.getMultiple("", variablePointer.getKey());

        processVariableValue.setCursor(variablePointer.getIndex());
        processVariableValue.setValue(null);

        instance.set("",  processVariableValue);

        processManagerRemote.applyChanges();

        setMetaworksContext(new MetaworksContext());
        getMetaworksContext().setHow("agile");


        //getLanguageElementInstance().setId("___deleted____");
        setDeleted(true);

    }

    boolean deleted;
    @Hidden
        public boolean isDeleted() {
            return deleted;
        }
        public void setDeleted(boolean deleted) {
            this.deleted = deleted;
        }


    Map<String, Integer> rowSpanMap;
        public Map<String, Integer> getRowSpanMap() {
            return rowSpanMap;
        }
        public void setRowSpanMap(Map<String, Integer> rowSpanMap) {
            this.rowSpanMap = rowSpanMap;
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

}
