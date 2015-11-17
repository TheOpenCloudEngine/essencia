package org.uengine.essencia.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.metaworks.MetaworksContext;
import org.metaworks.annotation.*;
import org.metaworks.dwr.SerializationSensitive;
import org.uengine.contexts.TextContext;
import org.uengine.essencia.enactment.LanguageElementInstance;
import org.uengine.kernel.ProcessInstance;
import org.uengine.kernel.ProcessVariableValue;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.IElement;
import org.uengine.modeling.Relation;
import org.uengine.uml.model.Attribute;
import org.uengine.uml.model.face.AttributeListFace;
import org.uengine.util.UEngineUtil;

public abstract class BasicElement extends LanguageElement implements IElement, SerializationSensitive {

//	protected TextContext name;
//	@Order(1)
//	@Id
//	@Name
//	public String getName() {
//		return name.getText();
//	}
//	public void setName(String name) {
//		this.name.setText(name);
//	}

	protected TextContext briefDescription;
//	protected TextContext description;
	private ElementView elementView;


//	public String getName(String locale) {
//		return name.getText(locale);
//	}
//	public void setName(String locale, String name) {
//		this.name.setText(locale, name);
//	}

	@Order(2)
	public String getBriefDescription() {
		return briefDescription.getText();
	}

	public void setBriefDescription(String description) {
		this.briefDescription.setText(description);
	}

	public String getBriefDescription(String locale) {
		return briefDescription.getText(locale);
	}

	public void setBriefDescription(String locale, String description) {
		this.briefDescription.setText(locale, description);
	}



//	@Order(3)
//	public String getDescription() {
//		return description.getText();
//	}
//
//	public void setDescription(String description) {
//		this.description.setText(description);
//	}
//
//	public String getDescription(String locale) {
//		return description.getText(locale);
//	}
//
//	public void setDescription(String locale, String description) {
//		this.description.setText(locale, description);
//	}

	protected String parentElementId;

	@Hidden
	public String getParentElementId() {
		return parentElementId;
	}

	public void setParentElementId(String parentElementId) {
		this.parentElementId = parentElementId;
	}

	@Hidden
	@Override
	public ElementView getElementView() {
		return elementView;
	}

	@Override
	public void setElementView(ElementView elementView) {
		this.elementView = elementView;
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

	protected Extension extensionFrom;

	@Hidden
	public Extension getExtensionFrom() {
		return extensionFrom;
	}

	public void setExtensionFrom(Extension extensionFrom) {
		this.extensionFrom = extensionFrom;
	}

	protected boolean isSuppressable;

	@Hidden
	public boolean isSuppressable() {
		return isSuppressable;
	}

	public void setSuppressable(boolean isSuppressable) {
		this.isSuppressable = isSuppressable;
	}

	public BasicElement() {

//		this.name = new TextContext();
//		this.description = new TextContext();
		this.briefDescription = new TextContext();

	}

	@Override
	public ElementView createView() {

		ElementView elementView = (ElementView) UEngineUtil.getComponentByEscalation(getClass(), "view");
		elementView.setElement(this);

		return elementView;


	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}

		return compareName(obj);
	}

	private boolean compareName(Object obj){
		if(getName().equals(((BasicElement)obj).getName())){
			return true;
		} else  {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getClass().getSimpleName().hashCode() *  name.hashCode();
	}

	/**
	 * convert main object from IElement to ElementView
	 *
	 * @return ElementView which have this class as element
	 */
	public ElementView asView() {
		ElementView view = getElementView();
		setElementView(null);
		view.setElement(this);
		return view;

	}







	////// advanced properties /////

	//transient Map<String, Property> properties = new HashMap<String, Property>();

//	public void addAttribute(String id, Attribute property)
//	{
//		attributeList.add(property);
//	}
//	public void addAttribute(String id, Class type) {
//
//		Attribute property = new Attribute();
//		property.setName(id);
//		property.setClassName(type.getName());
//
//		attributeList.add(property);
//	}

//	List<Attribute> attributeList = new ArrayList<Attribute>();
//	@Face(faceClass = AttributeListFace.class)
//	public List<Attribute> getAttributeList() {
//		return attributeList;
//	}
//	public void setAttributeList(List<Attribute> attributeList) {
//		this.attributeList = attributeList;
//	}
//
//
//	public Map<String, Attribute> createAttributeMap(){
//		Map<String, Attribute> map = new HashMap<String, Attribute>();
//
//		for(Attribute property : attributeList){
//			map.put(property.getName(), property);
//		}
//
//		return map;
//	}


	public LanguageElementInstance createInstance(String id) {

		return new LanguageElementInstance(this, id);
	}


	public List<? extends LanguageElementInstance> getInstances(ProcessInstance instance) {

		try {
			ProcessVariableValue pvv = instance.getMultiple("", getName());

			if(pvv==null)
				return null;

			pvv.beforeFirst();

			List<LanguageElementInstance> elementInstanceList = new ArrayList<LanguageElementInstance>();

			do{
				LanguageElementInstance elementInstance = (LanguageElementInstance) pvv.getValue();
				elementInstanceList.add(elementInstance);

			}while(pvv.next());

			return elementInstanceList;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void afterDeserialization() {
//		properties = new HashMap<String, Property>();
//
//		for(Property property : getPropertyList()){
//			properties.put(property.getKey(), property);
//		}
	}

	@Override
	public void beforeSerialization() {

	}

//	public List<AttributeInstance> createDefaultPropertyValues() {
//
//		List<AttributeInstance> attributeInstances = new ArrayList<AttributeInstance>();
//
//		for(Attribute property : getAttritbuteList()){
//			AttributeInstance propertyValue = new AttributeInstance();
//			propertyValue.setName(property.getName());
//			propertyValue.setType(property.getType());
//
//			attributeInstances.add(propertyValue);
//		}
//
//		return attributeInstances;
//	}

	protected transient List<Relation> outgoingRelations;
		public List<Relation> getOutgoingRelations() {
			return outgoingRelations;
		}

	protected transient List<Relation> incomingRelations;
		public List<Relation> getIncomingRelations() {
			return incomingRelations;
		}
}
