package org.uengine.essencia.modeling.editor;

import org.metaworks.MetaworksContext;
import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.ServiceMethod;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.modeling.modeler.EssenciaModeler;
import org.uengine.essencia.resource.IModelResource;
import org.uengine.essencia.resource.Resource;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.modeling.IModel;
import org.uengine.modeling.Modeler;

public abstract class ModelerEditor extends Editor {

	private Modeler modeler;

	public Modeler getModeler() {
		return modeler;
	}

	public void setModeler(Modeler modeler) {
		this.modeler = modeler;
	}

	public EssenciaModeler getEssenciaModeler() {
		return ((EssenciaModeler) modeler);
	}

	public IModelResource getModelResource() {
		return (IModelResource) getResource();
	}

	@Hidden
	@ServiceMethod(callByContent = true, childrenLoader=true, target=ServiceMethodContext.TARGET_SELF)
	@Override
	public void load() throws Exception {
		createModeler();

		ContextUtil.fillContext(getModeler(), this.getMetaworksContext());

		if(!MetaworksContext.WHEN_NEW.equals(getResource().getMetaworksContext().getWhen())){
			IModel model = ((IModelResource)getResource()).loadModel();
			
			this.getModeler().setModel(model);
		}
	}
	
	public IModel loadModel() throws Exception{
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
		IModel model = this.getModeler().getModel();
		getModelResource().saveResource(model);

		ContextUtil.setWhen((Resource) getResource(), EssenciaContext.WHEN_EDIT);
	}

	public abstract void createModeler();

}
