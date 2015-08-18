package org.uengine.essencia.resource;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.metaworks.Refresh;
import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.Available;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Order;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.dwr.MetaworksRemoteService;
import org.metaworks.widget.ModalWindow;
import org.uengine.codi.mw3.model.Session;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.dashboard.Dashboard;
import org.uengine.essencia.designer.Designer;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.modeling.editor.PracticeDefinerEditor;
import org.uengine.essencia.modeling.modeler.PracticeDefiner;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.modeling.resource.IResource;

import com.thoughtworks.xstream.XStream;
import org.uengine.modeling.resource.ResourceManager;

public class PracticeFolderResource extends ContainerResource {

	@AutowiredFromClient
	public Session session;

	@AutowiredFromClient
	public Designer designer;

	public PracticeFolderResource() {

	}

	public PracticeFolderResource(String path) {
		this();
		setPath(path);
	}

	@Order(2)
	@Face(displayName = "New Practice")
	@Available(condition = "metaworksContext.how == 'tree' && metaworksContext.where == 'navigator'")
	@ServiceMethod(callByContent = true, inContextMenu = true)
	public Refresh newDefiner() throws Exception {

		//this.setChildren(null);
		Resource newChildResource = this.newChildResource(ModelResource.UNTITLED + PracticeDefiner.SUFFIX);
		ContextUtil.setWhen(newChildResource, EssenciaContext.WHEN_NEW);
		designer.getEditorPanel().setEditor(new PracticeDefinerEditor(newChildResource));
		return new Refresh(designer);
	}

	@Override
	public List<IResource> list() {
		List<IResource> resourceList = new ArrayList<>();
		try {
			ResourceManager resourceManager = MetaworksRemoteService.getComponent(ResourceManager.class);
			resourceList = resourceManager.getStorage().listFiles(this);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resourceList;
//		File currentFile = new File(this.getAbsolutePath());
//		File[] fileList = currentFile.listFiles();
//
//		if (fileList == null) {
//			return new ArrayList<IResource>();
//		} else {
//			List<IResource> list = new ArrayList<IResource>();
//			for (File file : fileList) {
//				if (file.isDirectory()) {
//
//					IResource resource = (IResource) Resource.newPracticeFolderResource(file);
//					ContextUtil.setWhere(resource, this.getMetaworksContext().getWhere());
//					resource.setParent(this);
//
//					list.add(resource);
//				} else {
//					for (ResourceType resourceType : FolderResourceType.PRACTICE_FOLDER.getDisplayResources()) {
//						if (file.getAbsolutePath().endsWith(resourceType.getType())) {
//							IResource resource = (IResource) Resource.newInstance(file);
//							ContextUtil.setWhere(resource, this.getMetaworksContext().getWhere());
//							resource.setParent(this);
//
//							list.add(resource);
//						}
//					}
//				}
//			}
//			return orderByName(list);
//		}

	}

	@Override
	public String getResourceType() {
		return ResourceType.PRACTICE_RESOURCE.getType();
	}

	@Available(condition = "metaworksContext.how == 'tree' && metaworksContext.where == 'navigator'")
	@ServiceMethod(inContextMenu = true, target = ServiceMethodContext.TARGET_POPUP)
	public ModalWindow viewDashboard() {

		//  TODO Project별 값이 채워진 Alphas는 어떻게 획득하나?

		// Dashboard db = new Dashboard();

		// TODO
		PracticeDefinition practice = null;
		try {
			InputStream is = getClass().getResourceAsStream("/org/uengine/essencia/model/kernel/kernel.practice");
			XStream x = new XStream();
			InputStreamReader isr = new InputStreamReader(is);
			practice = (PracticeDefinition)x.fromXML(isr);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModalWindow(new Dashboard(practice), 1100, 600);
	}

}
