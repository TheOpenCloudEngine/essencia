package org.uengine.modeling.resource.editor;

import org.uengine.essencia.enactment.EssenceProcessDefinition;
import org.uengine.essencia.enactment.LanguageElementInstance;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.modeling.editor.MethodComposerEditor;
import org.uengine.essencia.modeling.modeler.MethodComposer;
import org.uengine.kernel.ProcessDefinition;
import org.uengine.kernel.ProcessVariable;
import org.uengine.modeling.resource.IEditor;
import org.uengine.modeling.resource.IResource;
import org.uengine.modeling.resource.Serializer;
import org.uengine.uml.model.ClassDefinition;

/**
 * Created by jjy on 2015. 11. 10..
 */
public class MethodEditor extends MethodComposer implements IEditor<EssenceProcessDefinition> {


    public MethodEditor() throws Exception {
        //createEditors();
    }


    @Override
    public void setEditingObject(EssenceProcessDefinition object) {

        try {
            setModel(object.getPracticeDefinition());

            object.setPracticeDefinition(null);
            setObjStr(Serializer.serialize(object));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public EssenceProcessDefinition createEditedObject() {
        try {
            EssenceProcessDefinition processDefinition;

            if(getObjStr()!=null) {
                processDefinition = (EssenceProcessDefinition) Serializer.deserialize(getObjStr());
            }else{
                processDefinition = new EssenceProcessDefinition();
            }

            PracticeDefinition practiceDefinition = (PracticeDefinition) createModel();
            processDefinition.setPracticeDefinition(practiceDefinition);
            processDefinition = (EssenceProcessDefinition) processDefinition.getPracticeDefinition().toProcessDefinition(processDefinition);

            return processDefinition;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public EssenceProcessDefinition newObject(IResource resource) {
        EssenceProcessDefinition essenceProcessDefinition = new EssenceProcessDefinition();
        essenceProcessDefinition.setName(resource.getName());

        return essenceProcessDefinition;
    }

    String objStr;

        public String getObjStr() {
            return objStr;
        }

        public void setObjStr(String objStr) {
            this.objStr = objStr;
        }
}
