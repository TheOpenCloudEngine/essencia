package org.uengine.essencia.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.metaworks.ContextAware;
import org.metaworks.MetaworksContext;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Hidden;
import org.uengine.essencia.enactment.AlphaInstance;
import org.uengine.essencia.enactment.LanguageElementInstance;
import org.uengine.essencia.model.face.PropertyListFace;
import org.uengine.essencia.model.face.list.ResourceListFace;
import org.uengine.essencia.model.face.list.TagListFace;
import org.uengine.kernel.GlobalContext;
import org.uengine.kernel.ProcessInstance;
import org.uengine.kernel.ProcessVariableValue;

@Face(ejsPath = "dwr/metaworks/genericfaces/ElementFace.ejs")
public abstract class LanguageElement implements ContextAware, Serializable, FaceTransformer {

	private static final long serialVersionUID = GlobalContext.SERIALIZATION_UID;

	private List<Resource> resourceList;
	private transient ResourceListFace resourceListFace;

	private List<Tag> tagList;
	private transient TagListFace tagListFace;

	private ElementGroup owner;

	protected String parentElementId;

	protected Extension extensionFrom;
	protected boolean isSuppressable;

	@Hidden
	public List<Resource> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<Resource> resourceList) {
		this.resourceList = resourceList;
	}

	@Hidden
	public List<Tag> getTagList() {
		return tagList;
	}

	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}

	@Face(displayName = "Resource")
	public ResourceListFace getResourceListFace() {
		return resourceListFace;
	}

	public void setResourceListFace(ResourceListFace resourceListFace) {
		this.resourceListFace = resourceListFace;
	}

	@Face(displayName = "Tag")
	public TagListFace getTagListFace() {
		return tagListFace;
	}

	public void setTagListFace(TagListFace tagListFace) {
		this.tagListFace = tagListFace;
	}

	@Hidden
	public String getParentElementId() {
		return parentElementId;
	}

	public void setParentElementId(String parentElementId) {
		this.parentElementId = parentElementId;
	}

	transient MetaworksContext metaworksContext;

	@Override
	public MetaworksContext getMetaworksContext() {
		return metaworksContext;
	}

	@Override
	public void setMetaworksContext(MetaworksContext metaworksContext) {
		this.metaworksContext = metaworksContext;
	}

	@Hidden
	public Extension getExtensionFrom() {
		return extensionFrom;
	}

	public void setExtensionFrom(Extension extensionFrom) {
		this.extensionFrom = extensionFrom;
	}

	@Hidden
	public boolean isSuppressable() {
		return isSuppressable;
	}

	public void setSuppressable(boolean isSuppressable) {
		this.isSuppressable = isSuppressable;
	}

	public ElementGroup getOwner() {
		return owner;
	}

	public void setOwner(ElementGroup owner) {
		this.owner = owner;
	}

	public LanguageElement() {
		setSuppressable(true);
	}

	@Override
	public void setUpElement() {
		setResourceListFace(new ResourceListFace());
		if (getResourceList() != null) {
			getResourceListFace().fillElements(getResourceList());
			getResourceList().clear();
		}
		setTagListFace(new TagListFace());
		if (getTagList() != null) {
			getTagListFace().fillElements(getTagList());
			getTagList().clear();
		}
	}

	@Override
	public void beforeApply() {
		setResourceList(getResourceListFace().createValue());
		setTagList(getTagListFace().createValue());
	}



}
