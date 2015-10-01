package org.uengine.modeling.resource.resources;

import org.metaworks.Remover;
import org.metaworks.dwr.MetaworksRemoteService;
import org.uengine.codi.CodiProcessDefinitionFactory;
import org.uengine.essencia.modeling.editor.Editor;
import org.uengine.essencia.modeling.editor.MethodComposerEditor;
import org.uengine.essencia.resource.FolderResourceType;
import org.uengine.essencia.resource.ModelResource;
import org.uengine.essencia.resource.RepositoryFolderResource;
import org.uengine.essencia.resource.ResourceType;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.modeling.resource.DefaultResource;
import org.uengine.modeling.resource.IResource;
import org.uengine.modeling.resource.ResourceManager;

public class MethodResource extends ModelResource {

	public MethodResource() {
		
	}
	
	public MethodResource(String path) {
		super(path);
	}

	@Override
	public Editor createEditor() throws Exception {
		MethodComposerEditor editor = new MethodComposerEditor();
		editor.load(essenciaSession, this);
		
		return editor; 
	}
	
	public EssenceProcessResource getProcessResource(){
		EssenceProcessResource resource = new EssenceProcessResource();
		resource.setPath(CodiProcessDefinitionFactory.codiProcessDefinitionFolder + getPath().substring(FolderResourceType.METHOD_FOLDER.getName().length()));

		resource.setType(ResourceType.PROCESS_RESOURCE.getType());
		ContextUtil.fillContext(resource, getMetaworksContext());
		return resource;
	}
//
//	@Face(displayName = "deploy")
//	@Available(condition = "metaworksContext.how == 'tree' && metaworksContext.where == 'navigator'")
//	@ServiceMethod(callByContent = true, inContextMenu = true, target = ServiceMethodContext.TARGET_APPEND)
//	public ModalWindow deploy() throws Exception {
//		DeployPanel deployPanel = new DeployPanel(this);
//		ModalWindow modalWindow = new ModalWindow();
//		deployPanel.setMetaworksContext(new MetaworksContext());
//		deployPanel.getMetaworksContext().setWhen(MetaworksContext.WHEN_EDIT);
//
//		modalWindow.setPanel(deployPanel);
//		modalWindow.setWidth(300);
//		modalWindow.setHeight(300);
//		modalWindow.setTitle("Deploy...");
//		return modalWindow;
//	}

	@Override
	public Object delete() {
		try {
			ResourceManager resourceManager = MetaworksRemoteService.getComponent(ResourceManager.class);
			resourceManager.getStorage().delete(this);
			EssenceProcessResource processResource = new EssenceProcessResource();
			processResource.setPath(this.getPath().replace(ResourceType.METHOD_RESOURCE.getType(),
					ResourceType.PROCESS_RESOURCE.getType()));
			resourceManager.getStorage().delete(processResource);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return new Remover(this);
	}

	@Override
	public void commit() throws Exception {
		super.commit();

		ResourceManager resourceManager =MetaworksRemoteService.getComponent(ResourceManager.class);

		resourceManager.getStorage().copy(this, RepositoryFolderResource.getRepository(FolderResourceType.METHOD_FOLDER)
				+ getRecord().getResources()
				+ "." + getRecord().getRevision() + ResourceType.REVISION_RESOURCE.getType());

		IResource resource = DefaultResource.createResource(this.getPath().replace(ResourceType.METHOD_RESOURCE.getType(),
				ResourceType.PROCESS_RESOURCE.getType()));

		resourceManager.getStorage().copy(resource, RepositoryFolderResource.getRepository(FolderResourceType.METHOD_FOLDER)
				+ getRecord().getResources()
				.replace(ResourceType.METHOD_RESOURCE.getType(), ResourceType.PROCESS_RESOURCE.getType())
				+ "." + getRecord().getRevision() + ResourceType.REVISION_RESOURCE.getType());
	}
}
