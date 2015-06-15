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
import org.uengine.essencia.model.face.PropertyListFace;
import org.uengine.kernel.ProcessInstance;
import org.uengine.kernel.ProcessVariableValue;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.IElement;
import org.uengine.util.UEngineUtil;

public abstract class BasicElement extends LanguageElement implements IElement, SerializationSensitive {

	protected TextContext name;
	@Order(1)
	@Id
	@Name
	public String getName() {
		return name.getText();
	}
	public void setName(String name) {
		this.name.setText(name);
	}

	protected TextContext briefDescription;
	protected TextContext description;
	private ElementView elementView;


	public String getName(String locale) {
		return name.getText(locale);
	}

	public void setName(String locale, String name) {
		this.name.setText(locale, name);
	}

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

	@Order(3)
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

		this.name = new TextContext();
		this.description = new TextContext();
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

	public void addProperty(String id, Property property)
	{
		propertyList.add(property);
	}
	public void addProperty(String id, Class type) {
//		Property property = new Property();
//		property.setKey(id);
//		property.setType(type.getName());
//
//		properties.put(id, property);

		Property property = new Property();
		property.setKey(id);
		property.setType(type.getName());

		propertyList.add(property);
	}

	List<Property> propertyList = new ArrayList<Property>();
	@Face(faceClass = PropertyListFace.class)
	public List<Property> getPropertyList() {
		return propertyList;
	}
	public void setPropertyList(List<Property> propertyList) {
		this.propertyList = propertyList;
	}


	public Map<String, Property> createPropertyMap(){
		Map<String, Property> map = new HashMap<String, Property>();

		for(Property property : propertyList){
			map.put(property.getKey(), property);
		}

		return map;
	}


	public LanguageElementInstance createInstance(String id) {

		return new LanguageElementInstance(this, id);
	}


	public List<? extends LanguageElementInstance> getInstances(ProcessInstance instance) {

		try {
			ProcessVariableValue pvv = instance.getMultiple("", getName());

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

	public List<PropertyValue> createDefaultPropertyValues() {

		List<PropertyValue> propertyValues = new ArrayList<PropertyValue>();

		for(Property property : getPropertyList()){
			PropertyValue propertyValue = new PropertyValue();
			propertyValue.setKey(property.getKey());
			propertyValue.setType(property.getType());

			propertyValues.add(propertyValue);
		}

		return propertyValues;
	}

}
