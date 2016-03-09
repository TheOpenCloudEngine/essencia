package org.uengine.modeling.resource.editor;

import org.uengine.essencia.enactment.EssenceProcessDefinition;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.modeling.modeler.MethodComposer;
import org.uengine.kernel.ProcessDefinition;
import org.uengine.modeling.modeler.ProcessModeler;
import org.uengine.modeling.resource.IEditor;
import org.uengine.modeling.resource.IResource;
import org.uengine.modeling.resource.Serializer;
import org.uengine.modeling.resource.Simulatable;

/**
 * Created by jjy on 2015. 11. 10..
 */
public class MethodEditor_ProcessMode extends ProcessModeler implements IEditor<EssenceProcessDefinition> , Simulatable {

    @Override
    public void setEditingObject(EssenceProcessDefinition object) {

        try {
            setModel(object);

            setObjStr(Serializer.serialize(object.getPracticeDefinition()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public EssenceProcessDefinition createEditedObject() {
        try {
//            EssenceProcessDefinition essenceProcessDefinition = new EssenceProcessDefinition();

            EssenceProcessDefinition processDefinition = (EssenceProcessDefinition) createModel();

            PracticeDefinition practiceDefinition = (PracticeDefinition) Serializer.deserialize(getObjStr());
            processDefinition.setPracticeDefinition(practiceDefinition);

            //essenceProcessDefinition.setPracticeDefinition(practiceDefinition);

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

    @Override
    protected ProcessDefinition createEmptyProcessDefinition() {
        return new EssenceProcessDefinition();
    }

    String objStr;
        public String getObjStr() {
            return objStr;
        }
        public void setObjStr(String objStr) {
            this.objStr = objStr;
        }


    @Override
    public Object simulator(IResource resource) {
        MethodEditor methodEditor = null;
        try {
            methodEditor = new MethodEditor();
            return methodEditor.simulator(resource);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
