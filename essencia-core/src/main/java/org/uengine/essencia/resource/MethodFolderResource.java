package org.uengine.essencia.resource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.metaworks.Refresh;
import org.metaworks.annotation.*;
import org.metaworks.dwr.MetaworksRemoteService;
import org.uengine.codi.mw3.model.Session;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.designer.Designer;
import org.uengine.essencia.modeling.editor.MethodComposerEditor;
import org.uengine.essencia.modeling.modeler.MethodComposer;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.modeling.resource.IResource;
import org.uengine.modeling.resource.ResourceManager;


public class MethodFolderResource extends ContainerResource {

	@AutowiredFromClient
	public Session session;

	@AutowiredFromClient
	public Designer designer;


	public MethodFolderResource() {
	}
	
	public MethodFolderResource(String path) {
		this();
		setPath(path);
	}

	@Order(2)
	@Face(displayName = "New Method")
	@Available(condition = "metaworksContext.how == 'tree' && metaworksContext.where == 'navigator'")
	@ServiceMethod(callByContent = true, inContextMenu = true/*, target = ServiceMethodContext.TARGET_APPEND*/)
	public Refresh newComposer() throws Exception {

		//this.setChildren(null);
//		Resource newChildResource = this.newChildResource(ModelResource.UNTITLED + MethodComposer.SUFFIX);


		//this.setChildren(null);

		Resource newChildResource = this.newChildResource(ModelResource.UNTITLED + MethodComposer.SUFFIX);
		ContextUtil.setWhen(newChildResource, EssenciaContext.WHEN_NEW);
		designer.getEditorPanel().setEditor(new MethodComposerEditor(newChildResource));
		return new Refresh(designer);
//		ContextUtil.setWhen((Resource)resource, EssenciaContext.WHEN_NEW);
		
		/*return new ToAppend(new EditorTabs(), new MethodComposerEditor(resource));*/
	}
	
	@Override
	public List<IResource> list() {

		List<IResource> methodResourceList = new ArrayList<>();
		try {
			ResourceManager resourceManager = MetaworksRemoteService.getComponent(ResourceManager.class);
			List<IResource> resourceList = resourceManager.getStorage().listFiles(this);

			for(IResource resource : resourceList){
				for(ResourceType resourceType : FolderResourceType.METHOD_FOLDER.getDisplayResources()){
					if(resource.getType().equals(resourceType.getType().substring(1))){
						ContextUtil.setWhere(resource, this.getMetaworksContext().getWhere());
						methodResourceList.add(resource);
					}
				}
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return methodResourceList;
	}
	
	@Override
	public String getResourceType() {
		return ResourceType.METHOD_RESOURCE.getType();
	}

}
