package org.uengine.modeling.resource.editor;

import org.metaworks.dwr.MetaworksRemoteService;
import org.uengine.codi.mw3.model.ProcessMap;
import org.uengine.codi.mw3.model.RoleMappingPanel;
import org.uengine.essencia.enactment.EssenceProcessDefinition;
import org.uengine.essencia.enactment.LanguageElementInstance;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.modeling.modeler.MethodComposer;
import org.uengine.essencia.modeling.palette.EssenciaPalette;
import org.uengine.essencia.util.KernelUtil;
import org.uengine.kernel.ProcessDefinition;
import org.uengine.kernel.ProcessVariable;
import org.uengine.modeling.resource.IEditor;
import org.uengine.modeling.resource.IResource;
import org.uengine.modeling.resource.Serializer;
import org.uengine.modeling.resource.Simulatable;
import org.uengine.processmanager.ProcessManagerRemote;
import org.uengine.uml.model.ClassDefinition;

/**
 * Created by jjy on 2015. 11. 10..
 */
public class MethodEditor extends MethodComposer implements IEditor<EssenceProcessDefinition>, Simulatable {


    public MethodEditor() throws Exception {
        //createEditors();
    }


    @Override
    public void setEditingObject(EssenceProcessDefinition object) {
        setBaseKernel(object.getPracticeDefinition().getBaseKernel());

        if(!KernelUtil.DEFAULT_KERNEL.equals(object.getPracticeDefinition().getBaseKernel())){
//            try {
                setPalette(new EssenciaPalette(object.getPracticeDefinition().getBaseKernel()));
//            }catch(Exception e){
//                e.printStackTrace(); // should be messaged to user as well even if it shows the editor with the default kernel anyhow.
//            }
        }

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

    
    @Override
    public Object simulator(IResource resource) {
        return ProcessEditor.simulator_(resource);
    }


}
