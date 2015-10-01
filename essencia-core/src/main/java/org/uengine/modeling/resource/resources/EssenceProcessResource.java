package org.uengine.modeling.resource.resources;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.uengine.codi.CodiProcessDefinitionFactory;
import org.uengine.essencia.resource.ModelResource;
import org.uengine.essencia.resource.element.EssenciaResource;
import org.uengine.kernel.ProcessDefinitionFactory;
import org.uengine.modeling.IModel;

public class EssenceProcessResource extends ModelResource {
	
	public EssenceProcessResource() {
		setChildList(new ArrayList<EssenciaResource>());
	}
	
	public EssenceProcessResource(String path) {
		this();
		setPath(path);
	}

	@Override
	public void saveResource(IModel model) throws Exception {
		super.saveResource(model);
		definitionFactory.removeFromCache(getPath().substring(CodiProcessDefinitionFactory.codiProcessDefinitionFolder.length() + 1));
	}

	@Autowired
	public ProcessDefinitionFactory definitionFactory;
}
