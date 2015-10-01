package org.uengine.modeling.resource.resources;

import java.util.ArrayList;

import org.uengine.essencia.resource.ModelResource;
import org.uengine.essencia.resource.element.EssenciaResource;

public class EssenceProcessResource extends ModelResource {
	
	public EssenceProcessResource() {
		setChildList(new ArrayList<EssenciaResource>());
	}
	
	public EssenceProcessResource(String path) {
		this();
		setPath(path);
	}
	
}
