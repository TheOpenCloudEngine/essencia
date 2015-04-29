package org.uengine.essencia.resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.metaworks.ServiceMethodContext;
import org.metaworks.ToAppend;
import org.metaworks.annotation.Available;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Order;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.ModalWindow;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.dashboard.Dashboard;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.modeling.editor.EditorTabs;
import org.uengine.essencia.modeling.editor.PracticeDefinerEditor;
import org.uengine.essencia.modeling.modeler.PracticeDefiner;
import org.uengine.essencia.modeling.palette.EssenciaKernelPalette;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.modeling.IResource;

import com.thoughtworks.xstream.XStream;

public class PracticeFolderResource extends ContainerResource {

    public PracticeFolderResource() {

    }

    public PracticeFolderResource(String path) {
	this();
	setPath(path);
    }

    @Order(2)
    @Face(displayName = "New Practice")
    @Available(condition = "metaworksContext.how == 'tree' && metaworksContext.where == 'navigator'")
    @ServiceMethod(callByContent = true, inContextMenu = true, target = ServiceMethodContext.TARGET_APPEND)
    public Object newDefiner() throws Exception {
	this.setChildren(null);

	Resource newChildResource = this.newChildResource(ModelResource.UNTITLED + PracticeDefiner.SUFFIX);
	ContextUtil.setWhen(newChildResource, EssenciaContext.WHEN_NEW);

	return new ToAppend(new EditorTabs(), new PracticeDefinerEditor(newChildResource));
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
		if (file.isDirectory()) {

		    IResource resource = (IResource) Resource.newPracticeFolderResource(file);
		    ContextUtil.setWhere(resource, this.getMetaworksContext().getWhere());
		    resource.setParent(this);

		    list.add(resource);
		} else {
		    for (ResourceType resourceType : FolderResourceType.PRACTICE_FOLDER.getDisplayResources()) {
			if (file.getAbsolutePath().endsWith(resourceType.getType())) {
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
	return ResourceType.PRACTICE_RESOURCE.getType();
    }

    @Available(condition = "metaworksContext.how == 'tree' && metaworksContext.where == 'navigator'")
    @ServiceMethod(inContextMenu = true, target = ServiceMethodContext.TARGET_POPUP)
    public ModalWindow viewDashboard() {

	// TODO Project별 값이 채워진 Alphas는 어떻게 획득하나?

	// Dashboard db = new Dashboard();

	// TODO
	PracticeDefinition practice = null;
	URL url = getClass().getResource("../model/kernel/kernel.practice");
	try {
	    XStream x = new XStream();
	    File file = new File(url.getPath());
	    FileInputStream fis = new FileInputStream(file);
	    InputStreamReader isr = new InputStreamReader(fis);
	    practice = (PracticeDefinition) x.fromXML(isr);
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return new ModalWindow(new Dashboard(practice), 1100, 600);
    }

}
