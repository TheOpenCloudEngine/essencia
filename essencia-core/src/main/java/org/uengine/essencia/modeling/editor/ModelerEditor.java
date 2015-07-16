package org.uengine.essencia.modeling.editor;

import org.metaworks.MetaworksContext;
import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.dwr.MetaworksRemoteService;
import org.uengine.codi.mw3.model.Session;
import org.uengine.essencia.context.EssenciaContext;
//import org.uengine.essencia.modeling.modeler.EssenciaModeler;
import org.uengine.essencia.modeling.modeler.EssenciaModeler;
import org.uengine.essencia.resource.IModelResource;
import org.uengine.essencia.resource.Resource;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.modeling.IModel;
import org.uengine.modeling.Modeler;
import org.uengine.modeling.modeler.ProcessModeler;

import java.util.Objects;

public abstract class ModelerEditor extends Editor {

    @AutowiredFromClient
    public Session session;

    private Modeler modeler;

    public Modeler getModeler() {
        return modeler;
    }

    public void setModeler(Modeler modeler) {
        this.modeler = modeler;
    }

    public EssenciaModeler takeEssenciaModeler() {
        return ((EssenciaModeler) modeler);
    }

    public IModelResource getModelResource() {
        return (IModelResource) getResource();
    }

    @Hidden
    @ServiceMethod(callByContent = true, childrenLoader = true, target = ServiceMethodContext.TARGET_SELF)
    @Override
    public void load() throws Exception {
        createModeler();

        ContextUtil.fillContext(getModeler(), this.getMetaworksContext());

        if (!MetaworksContext.WHEN_NEW.equals(getResource().getMetaworksContext().getWhen())) {
            IModel model = ((IModelResource) getResource()).loadModel();
            if( model == null ){
                throw new IllegalStateException("No Such Practice Definition");
            } else {
                this.getModeler().setModel(model);
            }
        }
    }

    public IModel loadModel() throws Exception {
        IModel model = getModelResource().loadModel();
        return model;
    }

    @Override
    public boolean validate() throws Exception {
        Resource.checkDuplicatedFile(getResource().getPath());

        return true;
    }

    @Override
    public void save() throws Exception {
        IModel model = null;
        if (getModeler() instanceof EssenciaModeler) {
            model = ((EssenciaModeler) this.getModeler()).takeModel();
        } else {
            ProcessModeler processModeler = (ProcessModeler) getModeler();

            MetaworksRemoteService.autowire(processModeler);

            model = processModeler.getModel();

            if(model == null){
                model = processModeler.createModel();
            }
        }
        getModelResource().saveResource(model);

        ContextUtil.setWhen((Resource) getResource(), EssenciaContext.WHEN_EDIT);
    }

    public abstract void createModeler();

}
