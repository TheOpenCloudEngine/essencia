package org.uengine.modeling.resource.resources;

import org.metaworks.EventContext;
import org.metaworks.Refresh;
import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.Available;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.Clipboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.uengine.codi.CodiProcessDefinitionFactory;
import org.uengine.codi.mw3.model.Session;
import org.uengine.essencia.modeling.canvas.EssenciaCanvas;
import org.uengine.essencia.modeling.canvas.MethodCanvas;
import org.uengine.kernel.ProcessDefinition;
import org.uengine.kernel.ProcessDefinitionFactory;
import org.uengine.modeling.resource.DefaultResource;
import org.uengine.modeling.resource.EditorPanel;
import org.uengine.modeling.resource.IEditor;
import org.uengine.modeling.resource.editor.MethodEditor;
import org.uengine.processadmin.ProcessAdminEditorPanel;

import java.util.ArrayList;
import java.util.HashMap;

public class MethodResource extends DefaultResource {

    private boolean isJoin;

    public boolean isJoin() {
        return isJoin;
    }

    public void setIsJoin(boolean isJoin) {
        this.isJoin = isJoin;
    }

    public static HashMap<String, ArrayList<String>> sessions = new HashMap<String, ArrayList<String>>();

    @AutowiredFromClient
    public Session session;

    @ServiceMethod(callByContent = true, except = "children", eventBinding = EventContext.EVENT_DBLCLICK, inContextMenu = true, target = ServiceMethodContext.TARGET_POPUP)
    public void joinEditing() throws Exception {

//        if (!sessions.containsKey(getPath()))
//            sessions.put(getPath(), new ArrayList<String>());
//
//        ArrayList<String> sessionsOfThisResource = sessions.get(getPath());
//        sessionsOfThisResource.add(session.getUser().getUserId());

        this.setIsJoin(true);
        open(null);
    }

    @Override
    public EditorPanel _newAndOpen(boolean isNew) throws Exception {
        EditorPanel editorPanel = super._newAndOpen(isNew);

        if (this.isJoin() && editorPanel instanceof ProcessAdminEditorPanel) {
            IEditor editor = ((ProcessAdminEditorPanel) editorPanel).getEditor();
            if (editor instanceof MethodEditor) {
                MethodCanvas methodCanvas = (MethodCanvas) ((MethodEditor) editor).getCanvas();
                methodCanvas.setJoinEditing(true);
                methodCanvas.setResourcePath(getPath());
                methodCanvas.setRemoteUserKey(session.getUser().getUserId());
                methodCanvas.setRemoteUserName(session.getUser().getName());
            }
        }
        return editorPanel;
    }

    @Autowired
    public ProcessDefinitionFactory definitionFactory;

    @Override
    public void save(Object editingObject) throws Exception {

        ProcessDefinition processDefinition = (ProcessDefinition) editingObject;

//		{//Extract Class Definitions and deploy them, and replace the class definition itself with a link
//
//			for (ProcessVariable processVariable : processDefinition.getProcessVariables()) {
//				if (processVariable.getDefaultValue() instanceof LanguageElementInstance) {
//					LanguageElementInstance languageElementInstance = (LanguageElementInstance) processVariable.getDefaultValue();
//					ClassDefinition classDefinition = languageElementInstance.getClassDefinition();
//
//					String classLinkName = getPath() + "#" + classDefinition.getName();
//
//					languageElementInstance.setClassName(classLinkName);
//
//				}
//			}
//
//		}

        super.save(editingObject);

        definitionFactory.removeFromCache(getPath().substring(CodiProcessDefinitionFactory.codiProcessDefinitionFolder.length() + 1));
    }


    @Hidden
    @Available(condition = "metaworksContext.how == 'tree' && metaworksContext.where == 'navigator'")
    @ServiceMethod(mouseBinding = "drag", bindingHidden = true, target = ServiceMethodContext.TARGET_APPEND)
    public Object drag() {
        return new Refresh(new Clipboard(EssenciaCanvas.CANVAS_DROP, this),
                true);
    }


}
