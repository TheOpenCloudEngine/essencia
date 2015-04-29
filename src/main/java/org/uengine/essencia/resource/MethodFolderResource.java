package org.uengine.essencia.resource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.metaworks.ServiceMethodContext;
import org.metaworks.ToAppend;
import org.metaworks.annotation.Available;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Group;
import org.metaworks.annotation.Order;
import org.metaworks.annotation.ServiceMethod;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.modeling.editor.EditorTabs;
import org.uengine.essencia.modeling.editor.MethodComposerEditor;
import org.uengine.essencia.modeling.modeler.MethodComposer;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.modeling.IResource;

	
public class MethodFolderResource extends ContainerResource {
	
	public MethodFolderResource() {
	}
	
	public MethodFolderResource(String path) {
		this();
		setPath(path);
	}

	@Order(2)
	@Face(displayName = "New Method")
	@Available(condition = "metaworksContext.how == 'tree' && metaworksContext.where == 'navigator'")
	@ServiceMethod(callByContent = true, inContextMenu = true, target = ServiceMethodContext.TARGET_APPEND)
	public Object newComposer() throws Exception {
		this.setChildren(null);
		
		IResource resource = Resource.newInstance(getPath()+ File.separator + ModelResource.UNTITLED + MethodComposer.SUFFIX);
		resource.setParent(this);
		ContextUtil.setWhen((Resource)resource, EssenciaContext.WHEN_NEW);
		
		return new ToAppend(new EditorTabs(), new MethodComposerEditor(resource));
	}
	
	@Override
	public List<IResource> list() {

		File currentFile = new File(this.getAbsolutePath());
		File[] fileList = currentFile.listFiles();
		
		if (fileList == null){
			return new ArrayList<IResource>();
		} else {
			List<IResource> list = new ArrayList<IResource>();
			for (File file : fileList) {
				if(file.isDirectory()){
					
					IResource resource = (IResource) Resource.newMethodFolderResource(file);
					ContextUtil.setWhere(resource, this.getMetaworksContext().getWhere());
					resource.setParent(this);
					
					list.add(resource);
				} else {
					for(ResourceType resourceType : FolderResourceType.METHOD_FOLDER.getDisplayResources()){
						if(file.getAbsolutePath().endsWith(resourceType.getType())){
							IResource resource = (IResource) Resource.newInstance(file);
							ContextUtil.setWhere(resource, this.getMetaworksContext().getWhere());
							resource.setParent(this);
							
							list.add(resource);
						} 
					}
				}
			}
			return orderByName(list);
		}
	}
	
	@Override
	public String getResourceType() {
		return ResourceType.METHOD_RESOURCE.getType();
	}

}
