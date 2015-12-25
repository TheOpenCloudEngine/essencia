package org.uengine.essencia.enactment;

import org.metaworks.MetaworksContext;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.Payload;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.dwr.MetaworksRemoteService;
import org.metaworks.widget.ModalWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.uengine.kernel.ProcessInstance;
import org.uengine.kernel.VariablePointer;
import org.uengine.processmanager.ProcessManagerRemote;


/**
 * Created by jjy on 2015. 12. 23..
 */

@Face(options = {"htmlTag"}, values={"tr"}, ejsPathForArray = "dwr/metaworks/org/uengine/essencia/enactment/AlphaInstanceTableFace.ejs")
public class AlphaInstanceInList {

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
        public LanguageElementInstance getLanguageElementInstance() {
            return languageElementInstance;
        }
        public void setLanguageElementInstance(LanguageElementInstance languageElementInstance) {
            this.languageElementInstance = languageElementInstance;
        }

    @Autowired
    public ProcessManagerRemote processManagerRemote;

    @ServiceMethod(target=ServiceMethod.TARGET_POPUP)
    public void edit(@Payload("instanceId") String instanceId, @Payload("variablePointer") VariablePointer variablePointer) throws Exception {

        AlphaInstanceInEditor alphaInstanceInEditor = new AlphaInstanceInEditor();
        alphaInstanceInEditor.setInstanceId(instanceId);
        alphaInstanceInEditor.setVariablePointer(variablePointer);

        ProcessInstance instance = processManagerRemote.getProcessInstance(getInstanceId());
        LanguageElementInstance leInstance = (LanguageElementInstance) variablePointer.getValue(instance);

        alphaInstanceInEditor.setLanguageElementInstance(leInstance);

        ModalWindow modalWindow = new ModalWindow(alphaInstanceInEditor, 500, 400, "Edit Alpha Instance");
        modalWindow.getMetaworksContext().setWhen(MetaworksContext.WHEN_EDIT);
        MetaworksRemoteService.wrapReturn(modalWindow);
    }
}
