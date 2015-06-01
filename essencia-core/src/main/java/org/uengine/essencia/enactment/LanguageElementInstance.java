package org.uengine.essencia.enactment;

import org.metaworks.annotation.Id;
import org.uengine.essencia.model.*;

import java.io.Serializable;
import java.util.*;

//@Face(faceClass=LanguageElementInstanceFace.class)
public class LanguageElementInstance extends HashMap<String, Serializable> {

    String id;
    @Id
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }


    BasicElement languageElement;
        public BasicElement getLanguageElement() {
            return languageElement;
        }

        public void setLanguageElement(BasicElement languageElement) {
            this.languageElement = languageElement;
        }



    public LanguageElementInstance(BasicElement languageElement1, String id){

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

    @Override
    public Serializable put(String key, Serializable value) {

        if("id".equals(key)){
            throw new IllegalArgumentException("Don't use 'put(\"id\", id)'. Use 'setId(id)' instead.");
        }

        if(!getLanguageElement().getProperties().containsKey(key))
            throw new IllegalArgumentException("No such property ["+key+"] is defined for this Alpha - " + getLanguageElement().getName());

        if(value == null)
            return remove(key);

        Class propertyType = null;
        try {
            propertyType = Class.forName(getLanguageElement().getProperties().get(key).getType());
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }

        if(!propertyType.isAssignableFrom(value.getClass())){
            throw new IllegalArgumentException("Property [" + key + ":"+ propertyType + "] is not assignable with value " + value + " which is a " + value.getClass());
        }

        return super.put(key, value);
    }

    public List<PropertyValue> getPropertyValues() {

        List<PropertyValue> propertyValues = new ArrayList<PropertyValue>();

        if(getLanguageElement()!=null){
            for(Property property : getLanguageElement().getPropertyList()){
                PropertyValue propertyValue = new PropertyValue();
                propertyValue.setKey(property.getKey());
                propertyValue.setType(property.getType());
                propertyValue.setValue(get(property.getKey()));

                propertyValues.add(propertyValue);
            }
        }

        return propertyValues;
    }

    public void setPropertyValues(List<PropertyValue> propertyValues) {

        for(PropertyValue propertyValue : propertyValues){
            put(propertyValue.getKey(), propertyValue.getValue());
        }

    }

    @Override
    public String toString() {
        return id;
    }

}
