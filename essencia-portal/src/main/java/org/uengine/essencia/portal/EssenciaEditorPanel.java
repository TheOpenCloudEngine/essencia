package org.uengine.essencia.portal;

import org.metaworks.annotation.Available;
import org.metaworks.annotation.ServiceMethod;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.uengine.essencia.enactment.EssenceProcessDefinition;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.kernel.ProcessDefinition;
import org.uengine.modeling.resource.Serializer;
import org.uengine.modeling.resource.editor.MethodEditor;
import org.uengine.modeling.resource.editor.MethodEditor_ProcessMode;
import org.uengine.modeling.resource.editor.ProcessEditor;
import org.uengine.processadmin.ProcessAdminEditorPanel;

/**
 * Created by jjy on 2015. 11. 10..
 */
@Component
@Scope("prototype")
@Order(5) //makes it used.
public class EssenciaEditorPanel extends ProcessAdminEditorPanel{

    @ServiceMethod(callByContent = true)
    @Available(condition = "editor.__className=='org.uengine.modeling.resource.editor.MethodEditor'")
    public void processMode() throws Exception {
        EssenceProcessDefinition essenceProcessDefinition = (EssenceProcessDefinition) getEditor().createEditedObject();

        MethodEditor_ProcessMode editor = new MethodEditor_ProcessMode();

        setEditor(editor);
        getEditor().setEditingObject(essenceProcessDefinition);
    }

    @ServiceMethod(callByContent = true)
    @Available(condition = "editor.__className=='org.uengine.modeling.resource.editor.MethodEditor_ProcessMode'")
    public void methodMode() throws Exception {

        MethodEditor_ProcessMode methodEditor_processMode = (MethodEditor_ProcessMode) getEditor();

        EssenceProcessDefinition essenceProcessDefinition = (EssenceProcessDefinition) getEditor().createEditedObject();

        setEditor(new MethodEditor());
        ((MethodEditor) getEditor()).setEditingObject(essenceProcessDefinition);
    }

}
