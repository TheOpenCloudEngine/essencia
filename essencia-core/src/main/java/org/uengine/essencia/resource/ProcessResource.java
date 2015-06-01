package org.uengine.essencia.resource;

import java.util.ArrayList;

import org.uengine.essencia.resource.element.EssenciaResource;

public class ProcessResource extends ModelResource {
	
	public ProcessResource() {
		setChildList(new ArrayList<EssenciaResource>());
	}
	
	public ProcessResource(String path) {
		this();
		setPath(path);
	}
	
}
