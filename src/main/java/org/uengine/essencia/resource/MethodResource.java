package org.uengine.essencia.resource;

import org.metaworks.MetaworksContext;
import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.Available;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.ModalWindow;
import org.uengine.essencia.modeling.editor.Editor;
import org.uengine.essencia.modeling.editor.MethodComposerEditor;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.essencia.common.DeployPanel;

public class MethodResource extends ModelResource {
	
	public MethodResource() {
		
	}
	
	public MethodResource(String path) {
		super(path);
	}

	@Override
	public Editor createEditor() throws Exception {
		MethodComposerEditor editor = new MethodComposerEditor();
		editor.load(session, this);
		
		return editor; 
	}
	
	public ProcessResource getProcessResource(){
		ProcessResource resource = new ProcessResource();
		resource.setPath(getPath());
		resource.setType(ResourceType.PROCESS_RESOURCE.getType());
		ContextUtil.fillContext(resource, getMetaworksContext());
		return resource;
	}

	@Face(displayName = "deploy")
	@Available(condition = "metaworksContext.how == 'tree' && metaworksContext.where == 'navigator'")
	@ServiceMethod(callByContent = true, inContextMenu = true, target = ServiceMethodContext.TARGET_APPEND)
	public ModalWindow deploy() throws Exception {
		DeployPanel deployPanel = new DeployPanel(this.getName());
		ModalWindow modalWindow = new ModalWindow();
		deployPanel.setMetaworksContext(new MetaworksContext());
		deployPanel.getMetaworksContext().setWhen(MetaworksContext.WHEN_EDIT);
		
		modalWindow.setPanel(deployPanel);
		modalWindow.setWidth(300);
		modalWindow.setHeight(300);
		modalWindow.setTitle("DeployPanel");
		return modalWindow;
	}
}
