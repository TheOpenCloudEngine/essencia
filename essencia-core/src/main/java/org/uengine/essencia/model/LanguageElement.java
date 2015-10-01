package org.uengine.essencia.model;

import java.io.Serializable;
import java.util.List;

import org.metaworks.ContextAware;
import org.metaworks.FieldDescriptor;
import org.metaworks.MetaworksContext;
import org.metaworks.WebFieldDescriptor;
import org.metaworks.annotation.*;
import org.uengine.contexts.TextContext;
import org.uengine.essencia.model.face.list.ResourceListFace;
import org.uengine.essencia.model.face.list.TagListFace;
import org.uengine.kernel.GlobalContext;
import org.uengine.uml.model.Attribute;
import org.uengine.uml.model.ClassDefinition;
import org.uengine.util.UEngineUtil;

@Face(ejsPath = "dwr/metaworks/genericfaces/ElementFace.ejs")
public abstract class LanguageElement extends ClassDefinition implements ContextAware, Serializable, FaceTransformer {

	private static final long serialVersionUID = GlobalContext.SERIALIZATION_UID;

	protected TextContext name;
	@Order(1)
	@Id
	@Name
	@Hidden(on=false)
	public String getName() {
		return name.getText();
	}
	public void setName(String name) {
		this.name.setText(name);
	}
	public String getName(String locale) {
		return name.getText(locale);
	}
	public void setName(String locale, String name) {
		this.name.setText(locale, name);
	}

	protected TextContext description;
	public String getDescription() {
		return description.getText();
	}

	public void setDescription(String description) {
		this.description.setText(description);
	}

	public String getDescription(String locale) {
		return description.getText(locale);
	}

	public void setDescription(String locale, String description) {
		this.description.setText(locale, description);
	}


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
		this.name = new TextContext();
		this.description = new TextContext();
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


	public void addAttribute(String name, Class clazz) {
		Attribute attribute = new Attribute();

		attribute.setName(name);
		attribute.setClassName(clazz.getName());

		Attribute[] attributes = getFieldDescriptors();
		attributes = (Attribute[]) UEngineUtil.addArrayElement(attributes, attribute);

		setFieldDescriptors(attributes);

	}
}
