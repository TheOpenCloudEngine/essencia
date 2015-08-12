package org.uengine.essencia.enactment;

import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.Id;
import org.metaworks.dwr.SerializationSensitive;
import org.uengine.essencia.model.*;
import org.uengine.kernel.NeedArrangementToSerialize;
import org.uengine.uml.model.Attribute;
import org.uengine.uml.model.AttributeInstance;

import java.io.Serializable;
import java.util.*;

//@Face(faceClass=LanguageElementInstanceFace.class)
public class LanguageElementInstance implements Serializable, NeedArrangementToSerialize, SerializationSensitive{

    String id;
    @Id
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }


    BasicElement languageElement;
    @Hidden
        public BasicElement getLanguageElement() {
            return languageElement;
        }
        public void setLanguageElement(BasicElement languageElement) {
            this.languageElement = languageElement;
        }


    transient
    HashMap<String, Serializable> cachedMap;
    @Hidden
        private HashMap<String, Serializable> getCachedMap() {
            return cachedMap;
        }


    public LanguageElementInstance(BasicElement languageElement1, String id){

        cachedMap = new HashMap<String, Serializable>();

        if(languageElement1 == null)
            throw new IllegalArgumentException("Alpha should be provided to instantiate an AlphaInstance");

        if(id == null)
            throw new IllegalArgumentException("Id should be provided to instantiate an AlphaInstance");

        setLanguageElement(languageElement1);
        setId(id);
    }

    //only for serialization / deserialization
    public LanguageElementInstance(){



        //if(!DWR.inSerialization()) throw new IllegalStatusError('This constructor is only for DWR instantiation');
    }

    public Serializable setAttribute(String key, Serializable value) {

        Map<String, Attribute> propertyMap = getLanguageElement().createAttributeMap();

        if("id".equals(key)){
            throw new IllegalArgumentException("Don't use 'put(\"id\", id)'. Use 'setId(id)' instead.");
        }

        if(!propertyMap.containsKey(key))
            throw new IllegalArgumentException("No such property ["+key+"] is defined for this Alpha - " + getLanguageElement().getName());

        if(value == null)
            return getCachedMap().remove(key);

        Class propertyType = null;
        try {
            propertyType = Class.forName(propertyMap.get(key).getType());
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }

        if(!propertyType.isAssignableFrom(value.getClass())){
            throw new IllegalArgumentException("Property [" + key + ":"+ propertyType + "] is not assignable with value " + value + " which is a " + value.getClass());
        }

        return getCachedMap().put(key, value);
    }

    public Serializable getAttribute(String key){
        return getCachedMap().get(key);
    }

    List<AttributeInstance> attributeValues;
        public List<AttributeInstance> getAttributeValues() {
            return attributeValues;
        }
        public void setAttributeValues(List<AttributeInstance> attributeValues) {
            this.attributeValues = attributeValues;
        }


    @Override
    public String toString() {
        return id;
    }

    @Override
    public void beforeSerialization() {
        if(cachedMap==null){
            //create default values

            if(attributeValues==null || attributeValues.size()==0) {
                if (getLanguageElement().getAttributeList() != null) {
                    cachedMap = new HashMap<String, Serializable>();

                    for (Attribute property : getLanguageElement().getAttributeList()) {

                        AttributeInstance defaultPropertyValue = null;
                        try {
                            defaultPropertyValue = property.createInstance();
                        } catch (Exception e) {

                        }

                        if (defaultPropertyValue != null)
                            setAttribute(property.getName(), (Serializable) defaultPropertyValue.getValue());
                    }
                }
            }else{
                return;
            }
        }

        List<AttributeInstance> values = new ArrayList<AttributeInstance>();

        if (getLanguageElement().getAttributeList() != null) {
            for (Attribute property : getLanguageElement().getAttributeList()) {
                AttributeInstance propertyValue = null;

                propertyValue = property.createInstance();
                propertyValue.setName(property.getName());

                if(cachedMap.containsKey(property.getName())) {
                    propertyValue.setValue(cachedMap.get(property.getName()));

                    values.add(propertyValue);
                }
            }

            setAttributeValues(values);
        }
    }

    @Override
    public void afterDeserialization() {
        if(cachedMap!=null) return;



        cachedMap = new HashMap<String, Serializable>();

        if(attributeValues !=null)
        for(AttributeInstance propertyValue : attributeValues){
            if(propertyValue!=null)
                cachedMap.put(propertyValue.getName(), (Serializable) propertyValue.getValue());
        }
    }
}
