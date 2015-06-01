package org.uengine.essencia.designer;

import java.io.File;

import org.metaworks.widget.Clipboard;
import org.uengine.essencia.i18n.Locale;
import org.uengine.essencia.resource.Resource;
import org.uengine.essencia.resource.FolderResourceType;
import org.uengine.modeling.IContainer;

public class ResourceNavigator {

	public final static String DEFAULT_LOCALE = "en";
	public final static String NAVIGATOR_ID = "navigator";

	public Clipboard clipboard;
	private IContainer practiceResource;
	private IContainer methodResource;

	public Clipboard getClipboard() {
		return clipboard;
	}

	public void setClipboard(Clipboard clipboard) {
		this.clipboard = clipboard;
	}

	public IContainer getPracticeResource() {
		return practiceResource;
	}

	public void setPracticeResource(IContainer practiceResource) {
		this.practiceResource = practiceResource;
	}

	public IContainer getMethodResource() {
		return methodResource;
	}

	public void setMethodResource(IContainer methodResource) {
		this.methodResource = methodResource;
	}

	public ResourceNavigator() {
	}

	public ResourceNavigator(Locale locale) {
		this.load(locale.getLanguage());
		this.setClipboard(new Clipboard(NAVIGATOR_ID));
	}

	public void load(String locale) {
		IContainer practiceResource = (IContainer) Resource.newPracticeFolderResource(File.separator.concat(FolderResourceType.PRACTICE_FOLDER.getName()));
		practiceResource.setChildren(practiceResource.list());

		IContainer methodResource = (IContainer) Resource.newMethodFolderResource(File.separator.concat(FolderResourceType.METHOD_FOLDER.getName()));
		methodResource.setChildren(methodResource.list());

		this.setPracticeResource(practiceResource);
		this.setMethodResource(methodResource);
	}

}
