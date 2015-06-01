package org.uengine.essencia.resource;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.metaworks.EventContext;
import org.metaworks.MetaworksContext;
import org.metaworks.ServiceMethodContext;
import org.metaworks.ToEvent;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.Available;
import org.metaworks.annotation.Children;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Field;
import org.metaworks.annotation.Order;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.website.EssenceFile;
import org.metaworks.widget.Clipboard;
import org.metaworks.widget.ModalWindow;
import org.uengine.essencia.designer.ResourceNavigator;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.modeling.IContainer;
import org.uengine.modeling.IResource;
import org.uengine.modeling.IResourceVisitor;

public class ContainerResource extends Resource implements IContainer {

	@AutowiredFromClient(select = ResourceNavigator.NAVIGATOR_ID)
	public Clipboard clipboard;
	
	private List<IResource> children;

	private boolean isContainer;

	public ContainerResource() {
		setContainer(true);
	}

	public ContainerResource(String path) {
		this();
		setPath(path);
	}

	@Children
	@Available(when = MetaworksContext.WHEN_VIEW)
	public List<IResource> getChildren() {
		if (children == null) {
			children = new ArrayList<IResource>();
		}
		return children;
	}

	public void setChildren(List<IResource> children) {
		this.children = children;
	}

	@Field(descriptor = "container")
	public boolean isContainer() {
		return isContainer;
	}

	public void setContainer(boolean container) {
		isContainer = container;
	}

	public void accept(IResourceVisitor visitor) {
		visitor.visit(this);

		for (IResource resource : this.list())
			resource.accept(visitor);
	}

	@Override
	public void accept(IResourceVisitor visitor, boolean admin) {
		super.accept(visitor, admin);

		for (IResource resource : this.list())
			resource.accept(visitor);
	}

	@Face(displayName = "save")
	@Available(when = MetaworksContext.WHEN_EDIT)
	@ServiceMethod(callByContent = true, target = ServiceMethodContext.TARGET_APPEND)
	public Object[] save() throws Exception {
		super.save();

		return new Object[] { new ToEvent(ServiceMethodContext.TARGET_SELF, EventContext.EVENT_CLOSE), new ToEvent(this.getParent(), "refresh") };
	}

	@Order(6)
	@Face(displayName = "refresh")
	@Available(condition = "metaworksContext.how == 'tree' && metaworksContext.where == 'navigator'")
	@ServiceMethod(callByContent = true, eventBinding = "refresh", bindingHidden = true, inContextMenu = true, target = ServiceMethodContext.TARGET_SELF)
	public void refresh() throws Exception {
		this.setChildren(this.list());
	}
	
	@Order(3)
	@Face(displayName = "Import")
	@Available(condition = "metaworksContext.how == 'tree' && metaworksContext.where == 'navigator'")
	@ServiceMethod(callByContent = true, inContextMenu = true, target = ServiceMethodContext.TARGET_POPUP)
	public ModalWindow essenceImport() {
		ModalWindow modalWindow = new ModalWindow();
	    modalWindow.setWidth(600);
	    modalWindow.setHeight(200);
	    modalWindow.setTitle("Import");
	    
	    MetaworksContext metaworksContext = new MetaworksContext();
	    metaworksContext.setWhen(MetaworksContext.WHEN_NEW);
	    
	    EssenceFile essenceFile = new EssenceFile();
	    essenceFile.setMetaworksContext(metaworksContext);
        essenceFile.setResourceFolder(getPath() + File.separator);
	    essenceFile.setResourceType(getResourceType());
	    
	    modalWindow.setPanel(essenceFile);

	    return modalWindow;
	}

	public List<IResource> orderByName(List<IResource> target) {

		List<IResource> returnResources = new ArrayList<IResource>();
		List<IResource> tempResourceList = new ArrayList<IResource>();

		for (IResource resource : target)
			if (resource instanceof ContainerResource) {
				returnResources.add(resource);
			} else {
				tempResourceList.add(resource);
			}

		Collections.sort(returnResources, Comparators.NAME);
		Collections.sort(tempResourceList, Comparators.NAME);

		returnResources.addAll(tempResourceList);

		return returnResources;
	}

	@Order(6)
	@Face(displayName = "open")
	@Available(condition = "metaworksContext.how == 'tree'")
	@ServiceMethod(callByContent = true, except = "children", childrenLoader = true, target = ServiceMethodContext.TARGET_SELF)
	public void open() {
		this.setChildren(this.list());
	}

	@Override
	public List<IResource> list() {

		File currentFile = new File(this.getAbsolutePath());
		File[] fileList = currentFile.listFiles();

		if (fileList == null) {
			return new ArrayList<IResource>();
		} else {
			List<IResource> list = new ArrayList<IResource>();
			for (File file : fileList) {
				if (file.getAbsolutePath().endsWith(ResourceType.PRACTICE_RESOURCE.getType())) {
					IResource resource = Resource.newInstance(file);
					ContextUtil.setWhere(resource, this.getMetaworksContext().getWhere());
					resource.setParent(this);

					list.add(resource);
				} else if (file.getAbsolutePath().endsWith(ResourceType.METHOD_RESOURCE.getType())) {
					IResource resource = Resource.newInstance(file);
					ContextUtil.setWhere(resource, this.getMetaworksContext().getWhere());
					resource.setParent(this);

					list.add(resource);
				} else if (file.isDirectory()) {
					IResource resource = Resource.newInstance(file);
					ContextUtil.setWhere(resource, this.getMetaworksContext().getWhere());
					resource.setParent(this);

					list.add(resource);
				}
			}
			return orderByName(list);
		}

	}

	public Resource newChildResource(String newName) {
		Resource resource = (Resource)Resource.newInstance(getPath()+ File.separator + newName);
		resource.setParent(this);

		return resource;
	}
	
	public String getResourceType(){
		return null;
	}
}
