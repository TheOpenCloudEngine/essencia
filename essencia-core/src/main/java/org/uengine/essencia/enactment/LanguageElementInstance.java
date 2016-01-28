package org.uengine.essencia.enactment;

import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.metaworks.AllChildFacesAreIgnored;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.Id;
import org.metaworks.annotation.Payload;
import org.metaworks.dao.TransactionContext;
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


    //only for serialization / deserialization
    public LanguageElementInstance(){



        //if(!DWR.inSerialization()) throw new IllegalStatusError('This constructor is only for DWR instantiation');
    }

    public Serializable setAttribute(String key, Serializable value) {

        setBeanProperty(key, value);

        return value;


    }

    public Serializable getAttribute(String key){
        //return getCachedMap().get(key);

        return (Serializable) getBeanProperty(key);
    }



    @Override
    public String toString() {
        return id;
    }

    @Override
    public void beforeSerialization() {

        //exchange the classDefinition object itself with a link info to avoid the huge serialization of definition-side object (also it eager to be an old value).

        if((getClassName()==null || getClassName().indexOf("#") == -1) && getLanguageElement()!=null){

            String resourcePath = (String) TransactionContext.getThreadLocalInstance().getSharedContext("resourceManager.resourcePath");
            if(resourcePath==null) {
                resourcePath = "";
            }else{
                resourcePath = resourcePath + "#";
            }

            String classLinkName = resourcePath + getLanguageElement().getName();

            setClassName(classLinkName);

            //setClassDefinition(null);
        }

    }

    @Override
    public void afterDeserialization() {

        for(Object fieldValue : getValueMap().values()){
            if(fieldValue instanceof AbstractMetaworksFile){
                AbstractMetaworksFile metaworksFile = ((AbstractMetaworksFile) fieldValue);

                if(metaworksFile.getUploadedPath()==null && metaworksFile.getFileTransfer()!=null) {
                    try {
                        ((AbstractMetaworksFile) fieldValue).upload();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        if(getClassName()==null || getClassName().indexOf("#") == -1) {
            String resourcePath = (String) TransactionContext.getThreadLocalInstance().getSharedContext("resourceManager.resourcePath");
            if(resourcePath==null) {
                resourcePath = "";
            }else{
                resourcePath = resourcePath + "#";
            }

            String classLinkName = resourcePath + getLanguageElement().getName();

            setClassName(classLinkName);
        }
    }


    @Override
    public ObjectInstance fillClassDefinition(@Payload("className") String className) throws Exception {

        //className pattern defined:  codi/scrum.process#sprint

        String[] processResourceNameAndLanguageElementName = className.split("\\#");

        if(processResourceNameAndLanguageElementName.length < 2){
            throw new IllegalArgumentException("ClassName should be defined like this : codi/processName.process#languageElement, but this is " + className);
        }

        ResourceManager resourceManager = MetaworksRemoteService.getComponent(ResourceManager.class);

        DefaultResource classDefinitionResource = new DefaultResource( processResourceNameAndLanguageElementName[0]);
        EssenceProcessDefinition definition = (EssenceProcessDefinition) resourceManager.getStorage().getObject(classDefinitionResource);

        LanguageElement languageElement = (LanguageElement) definition.getPracticeDefinition().getElementByName(processResourceNameAndLanguageElementName[1]);

        setClassDefinition(languageElement);


        return this;
    }
}
