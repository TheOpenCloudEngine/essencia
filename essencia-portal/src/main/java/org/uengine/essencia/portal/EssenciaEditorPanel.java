package org.uengine.essencia.portal;

import org.metaworks.annotation.Available;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.dwr.MetaworksRemoteService;
import org.metaworks.widget.Download;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.uengine.codi.mw3.model.Popup;
import org.uengine.essencia.enactment.EssenceProcessDefinition;
import org.uengine.modeling.resource.editor.MethodEditor;
import org.uengine.modeling.resource.editor.MethodEditor_ProcessMode;
import org.uengine.processadmin.ProcessAdminEditorPanel;
import org.uengine.processadmin.ProcessExporter;

import java.io.FileNotFoundException;
import java.io.IOException;


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

    @Override
    public Download download() throws FileNotFoundException, IOException, Exception {

        if(MetaworksRemoteService.metaworksCall()) {
            Popup popup = new Popup(new EssenciaExporter());
            MetaworksRemoteService.wrapReturn(popup);

            return null;
        }

        return super.download();

    }
}
