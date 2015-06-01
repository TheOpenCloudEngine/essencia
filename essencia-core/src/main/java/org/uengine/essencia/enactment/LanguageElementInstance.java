package org.uengine.essencia.enactment;

import org.metaworks.annotation.Face;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.Id;
import org.metaworks.dwr.SerializationSensitive;
import org.uengine.essencia.enactment.face.LanguageElementInstanceFace;
import org.uengine.essencia.model.*;
import org.uengine.kernel.NeedArrangementToSerialize;

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

    public Serializable setProperty(String key, Serializable value) {

        Map<String, Property> propertyMap = getLanguageElement().createPropertyMap();

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

    public Serializable getProperty(String key){
        return getCachedMap().get(key);
    }

    List<PropertyValue> propertyValues;
        public List<PropertyValue> getPropertyValues() {
            return propertyValues;
        }
        public void setPropertyValues(List<PropertyValue> propertyValues) {
            this.propertyValues = propertyValues;
        }


    @Override
    public String toString() {
        return id;
    }

    @Override
    public void beforeSerialization() {
        if(cachedMap==null) return;

        List<PropertyValue> values = new ArrayList<PropertyValue>();

        for(String key : cachedMap.keySet()){
            PropertyValue propertyValue = new PropertyValue();
            propertyValue.setKey(key);
            propertyValue.setValue(cachedMap.get(key));

            values.add(propertyValue);
        }

        setPropertyValues(values);
    }

    @Override
    public void afterDeserialization() {
        if(cachedMap!=null) return;

        cachedMap = new HashMap<String, Serializable>();

        if(propertyValues!=null)
        for(PropertyValue propertyValue : propertyValues){
            cachedMap.put(propertyValue.getKey(), propertyValue.getValue());
        }
    }
}
