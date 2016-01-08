package org.uengine.essencia.enactment;

import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.metaworks.AllChildFacesAreIgnored;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.Id;
import org.metaworks.annotation.Payload;
import org.metaworks.dwr.MetaworksRemoteService;
import org.metaworks.dwr.SerializationSensitive;
import org.metaworks.website.AbstractMetaworksFile;
import org.uengine.essencia.model.*;
import org.uengine.kernel.NeedArrangementToSerialize;
import org.uengine.modeling.resource.DefaultResource;
import org.uengine.modeling.resource.ResourceManager;
import org.uengine.uml.model.Attribute;
import org.uengine.uml.model.ClassDefinition;
import org.uengine.uml.model.ObjectInstance;

import java.io.Serializable;
import java.util.*;

//@Face(faceClass=LanguageElementInstanceFace.class)
public class LanguageElementInstance extends ObjectInstance implements Serializable, NeedArrangementToSerialize, SerializationSensitive{

    String id;
    @Id
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }

//    //@XStreamOmitField
//    BasicElement languageElement;
    @Hidden
    @Face(faceClass=AllChildFacesAreIgnored.class)
        public BasicElement getLanguageElement() {
            return (BasicElement) getClassDefinition();
        }
        public void setLanguageElement(BasicElement languageElement) {
            setClassDefinition(languageElement);
        }



//    transient
//    HashMap<String, Serializable> cachedMap;
//    @Hidden
//        private HashMap<String, Serializable> getCachedMap() {
//            return cachedMap;
//        }


//    ObjectInstance propertyValues;
//        public ObjectInstance getPropertyValues() {
//            return propertyValues;
//        }
//
//        public void setPropertyValues(ObjectInstance propertyValues) {
//            this.propertyValues = propertyValues;
//        }


//    public LanguageElementInstance(BasicElement languageElement1, String id){
//
//
//        setClassDefinition(languageElement1);
//
//        if(languageElement1 == null)
//            throw new IllegalArgumentException("Alpha should be provided to instantiate an AlphaInstance");
//
//        if(id == null)
//            throw new IllegalArgumentException("Id should be provided to instantiate an AlphaInstance");
//
//        setLanguageElement(languageElement1);
//        setId(id);
//    }

    //only for serialization / deserialization
    public LanguageElementInstance(){



        //if(!DWR.inSerialization()) throw new IllegalStatusError('This constructor is only for DWR instantiation');
    }

    public Serializable setAttribute(String key, Serializable value) {

        setBeanProperty(key, value);

        return value;

//        Map<String, Attribute> propertyMap = getLanguageElement().createAttributeMap();
//
//        if("id".equals(key)){
//            throw new IllegalArgumentException("Don't use 'put(\"id\", id)'. Use 'setId(id)' instead.");
//        }
//
//        if(!propertyMap.containsKey(key))
//            throw new IllegalArgumentException("No such property ["+key+"] is defined for this Alpha - " + getLanguageElement().getName());
//
//        if(value == null)
//            return getCachedMap().remove(key);
//
//        Class propertyType = null;
//        try {
//            propertyType = Class.forName(propertyMap.get(key).getClassName());
//        } catch (ClassNotFoundException e) {
//            throw new IllegalStateException(e);
//        }
//
//        if(!propertyType.isAssignableFrom(value.getClass())){
//            throw new IllegalArgumentException("Property [" + key + ":"+ propertyType + "] is not assignable with value " + value + " which is a " + value.getClass());
//        }
//
//        return getCachedMap().put(key, value);
    }

    public Serializable getAttribute(String key){
        //return getCachedMap().get(key);

        return (Serializable) getBeanProperty(key);
    }

//    List<AttributeInstance> attributeValues;
//        public List<AttributeInstance> getAttributeValues() {
//            return attributeValues;
//        }
//        public void setAttributeValues(List<AttributeInstance> attributeValues) {
//            this.attributeValues = attributeValues;
//        }


    @Override
    public String toString() {
        return id;
    }

    @Override
    public void beforeSerialization() {

        //exchange the classDefinition object itself with a link info to avoid the huge serialization of definition-side object (also it eager to be an old value).

        if(getClassName()==null && getLanguageElement()!=null){
            String classLinkName = /*getLanguageElement().getResourcePath() + "#" + */ getLanguageElement().getName();

            setClassName(classLinkName);

            setClassDefinition(null);
        }

    }

    @Override
    public void afterDeserialization() {

        for(Object fieldValue : getValueMap().values()){
            if(fieldValue instanceof AbstractMetaworksFile && ((AbstractMetaworksFile) fieldValue).getUploadedPath()==null){
                try {
                    ((AbstractMetaworksFile) fieldValue).upload();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        if(getClassName()!=null && getClassName().indexOf("#") > 0 && getClassDefinition()==null) {

            try {
                fillClassDefinition(getClassName());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


    @Override
    public ObjectInstance fillClassDefinition(@Payload("className") String className) throws Exception {

        //className pattern defined:  codi/scrum.process#sprint

        String[] processResourceNameAndLanguageElementName = className.split("\\#");

        if(processResourceNameAndLanguageElementName.length < 2){
            throw new IllegalArgumentException("ClassName should be defined like this : codi/processName.process#languageElement");
        }

        ResourceManager resourceManager = MetaworksRemoteService.getComponent(ResourceManager.class);

        DefaultResource classDefinitionResource = new DefaultResource( processResourceNameAndLanguageElementName[0]);
        EssenceProcessDefinition definition = (EssenceProcessDefinition) resourceManager.getStorage().getObject(classDefinitionResource);

        LanguageElement languageElement = (LanguageElement) definition.getPracticeDefinition().getElementByName(processResourceNameAndLanguageElementName[1]);

        setClassDefinition(languageElement);


        return this;
    }
}
