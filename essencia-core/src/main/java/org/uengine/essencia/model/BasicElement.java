package org.uengine.essencia.model;

import java.util.*;

import org.metaworks.MetaworksContext;
import org.metaworks.annotation.*;
import org.metaworks.dwr.MetaworksRemoteService;
import org.metaworks.dwr.SerializationSensitive;
import org.uengine.contexts.TextContext;
import org.uengine.essencia.enactment.AlphaInstance;
import org.uengine.essencia.enactment.AlphaInstanceInList;
import org.uengine.essencia.enactment.EssenceProcessDefinition;
import org.uengine.essencia.enactment.LanguageElementInstance;
import org.uengine.kernel.ProcessInstance;
import org.uengine.kernel.ProcessVariableValue;
import org.uengine.kernel.VariablePointer;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.IElement;
import org.uengine.modeling.Relation;
import org.uengine.modeling.resource.DefaultResource;
import org.uengine.modeling.resource.ResourceManager;
import org.uengine.uml.ClassSystemMode;
import org.uengine.uml.model.Attribute;
import org.uengine.uml.model.face.AttributeListFace;
import org.uengine.util.UEngineUtil;

public abstract class BasicElement extends LanguageElement implements IElement {

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
//	@Available(where = WHERE_ADVANCED)
//	@Group(name="Advanced")

	public String getBriefDescription() {

//		if(!ClassSystemMode.getThreadLocalInstance().isDesignTime()){
//			if(getSuperClasses()!=null && !UEngineUtil.isNotEmpty(briefDescription.getText())){
//				String superClassName = getSuperClasses().get(0);
//
//				String[] processResourceNameAndLanguageElementName = superClassName.split("\\#");
//
//				ResourceManager resourceManager = MetaworksRemoteService.getComponent(ResourceManager.class);
//
//				DefaultResource classDefinitionResource = new DefaultResource( processResourceNameAndLanguageElementName[0]);
//				EssenceProcessDefinition definition = null;
//				try {
//					definition = (EssenceProcessDefinition) resourceManager.getStorage().getObject(classDefinitionResource);
//
//					BasicElement languageElement = (BasicElement) definition.getPracticeDefinition().getElementByName(processResourceNameAndLanguageElementName[1]);
//
//					languageElement.getBriefDescription();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//
//			}
//		}

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

//		Attribute attr_Id = new Attribute();
//		attr_Id.setName("Id");
//		attr_Id.setClassName("java.lang.String");
//
//
//		this.setFieldDescriptors(new Attribute[]{attr_Id});

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


//	public LanguageElementInstance createInstance(String id) {
//
//		return new LanguageElementInstance(this, id);
//	}


	public List<? extends LanguageElementInstance> getInstances(ProcessInstance instance) {

		try {
			ProcessVariableValue pvv = instance.getMultiple("", getName());

			if(pvv==null)
				return null;

			pvv.beforeFirst();

			List<LanguageElementInstance> elementInstanceList = new ArrayList<LanguageElementInstance>();

			do{
				LanguageElementInstance elementInstance = (LanguageElementInstance) pvv.getValue(instance);
				elementInstanceList.add(elementInstance);

			}while(pvv.next());

			return elementInstanceList;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	public List<AlphaInstanceInList> getInstanceInLists(ProcessInstance instance) {
		return getInstanceInLists(instance, true);
	}

	public List<AlphaInstanceInList> getInstanceInLists(ProcessInstance instance, boolean sorting) {

		List<? extends LanguageElementInstance> alphaInstances = getInstances(instance);
		List<AlphaInstanceInList> alphaInstanceInLists = new ArrayList<AlphaInstanceInList>();

		if(alphaInstances==null) return null;

		int i=-1;
		for (LanguageElementInstance alphaInstance : alphaInstances) {
			i++;  //should count the index even if the value is null since the index is important.

			if(alphaInstance==null) continue;

			AlphaInstanceInList alphaInstanceInList = new AlphaInstanceInList(alphaInstance, instance, i);
			alphaInstanceInLists.add(alphaInstanceInList);
		}

		if(sorting) {

			Collections.sort(alphaInstanceInLists, new Comparator<AlphaInstanceInList>() {
				@Override
				public int compare(AlphaInstanceInList o1, AlphaInstanceInList o2) {
					if(getFieldDescriptors()!=null) {
						int compResult = 0;

						for (Attribute fd : getFieldDescriptors()) {
							Object fieldValueO1 = o1.getLanguageElementInstance().getBeanProperty(fd.getName());
							Object fieldValue02 = o2.getLanguageElementInstance().getBeanProperty(fd.getName());

							if(fieldValueO1 instanceof Comparable) {
								compResult = ((Comparable) fieldValueO1).compareTo(fieldValue02);
							}else{
								compResult = 0;
							}

							if(compResult!=0){
								return compResult;
							}
						}
					}else{
						return o1.getLanguageElementInstance().getId().compareTo(o2.getLanguageElementInstance().getId());
					}

					return 0;
				}
			});

			////// calculate row span

			LanguageElementInstance prevInstance = null;
			Map<String, Integer> rowSpanMap = new HashMap<String, Integer>();

			i=-1;
			for (AlphaInstanceInList alphaInstanceInList : alphaInstanceInLists) {
				i++;

				if (prevInstance != null && getFieldDescriptors() != null) {

					boolean priorFieldValueChanged = false;
					boolean lastField = false;

					int fieldIndex = 0;
					AlphaInstanceInList total = null;

					for (Attribute fd : getFieldDescriptors()) {
						fieldIndex++;
						boolean totalling = false;
						lastField = (fieldIndex == getFieldDescriptors().length);

						if(Double.class.getName().equals(fd.getClassName())){
							totalling = true;
						}

						Object fieldValue = alphaInstanceInList.getLanguageElementInstance().getBeanProperty(fd.getName());
						Object prevFieldValue = null;

						prevFieldValue = prevInstance.getBeanProperty(fd.getName());

						int rowSpan = 0;

						Integer rowSpanObject = rowSpanMap.get(fd.getName());
						if (rowSpanObject == null)
							rowSpan = 1;
						else
							rowSpan = rowSpanObject.intValue();

						if (!priorFieldValueChanged && ((fieldValue == null && prevFieldValue == null) || (fieldValue != null && fieldValue.equals(prevFieldValue)))) {
							rowSpan++;

							rowSpanMap.put(fd.getName(), new Integer(rowSpan));

							if(totalling){

							}

						} else {

							priorFieldValueChanged = true;

							int whereRowSpanStart = i - rowSpan;
							AlphaInstanceInList alphaInstanceInListNeedToSetRowSpanMap = alphaInstanceInLists.get(whereRowSpanStart);

							if (alphaInstanceInListNeedToSetRowSpanMap.getRowSpanMap() == null) {
								alphaInstanceInListNeedToSetRowSpanMap.setRowSpanMap(new HashMap<String, Integer>());
							}

							alphaInstanceInListNeedToSetRowSpanMap.getRowSpanMap().put(fd.getName(), new Integer(rowSpan));

							rowSpanMap.put(fd.getName(), new Integer(1));


							//totalling and insert the total row
							if(totalling && rowSpan > 1){ //at lease two or more rows are meaningful

								if(total == null) {
									total = new AlphaInstanceInList();


									total.setLanguageElementInstance(createObjectInstance());
									total.getLanguageElementInstance().setId("Total");

									//copy values from the head.
									total.getLanguageElementInstance().getValueMap().putAll(alphaInstanceInListNeedToSetRowSpanMap.getLanguageElementInstance().getValueMap());
								}

								Double totalValue = (Double) total.getLanguageElementInstance().getBeanProperty(fd.getName());
								if(totalValue==null){
									totalValue = 0d;
								}

								totalValue = totalValue + ((Double)fieldValue).doubleValue();

								total.getLanguageElementInstance().setBeanProperty(fd.getName(), totalValue);

								if(lastField){
									alphaInstanceInLists.add(whereRowSpanStart, total); //maybe error
								}
							}
						}
					}

				}

				prevInstance = alphaInstanceInList.getLanguageElementInstance();
			}


			if (prevInstance != null && getFieldDescriptors() != null) {
				for (Attribute fd : getFieldDescriptors()) {
					Integer rowSpan = rowSpanMap.get(fd.getName());

					if (rowSpan != null) {
						int whereRowSpanStart = i - rowSpan + 1;
						AlphaInstanceInList alphaInstanceInListNeedToSetRowSpanMap = alphaInstanceInLists.get(whereRowSpanStart);

						if (alphaInstanceInListNeedToSetRowSpanMap.getRowSpanMap() == null)
							alphaInstanceInListNeedToSetRowSpanMap.setRowSpanMap(new HashMap<String, Integer>());

						//rowSpanMap.put(fd.getName(), rowSpan + 1);

						alphaInstanceInListNeedToSetRowSpanMap.getRowSpanMap().put(fd.getName(), rowSpan);
					}
				}
			}
		}

		return alphaInstanceInLists;

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
