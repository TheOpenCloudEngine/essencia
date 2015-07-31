package org.uengine.essencia.resource;

import java.util.ArrayList;

import org.uengine.essencia.resource.element.EssenciaResource;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.modeling.resource.resources.MethodResource;

public class RevisionResource extends MethodResource {
	
	public RevisionResource() {
		setChildList(new ArrayList<EssenciaResource>());
	}
	
	public RevisionResource(String path) {
		this();
		setPath(path);
	}
	
	@Override
	public ProcessResource getProcessResource(){
		ProcessResource resource = new ProcessResource();
		resource.setPath(getPath());
		resource.setType(resource.getType().replace("method", "process"));
		ContextUtil.fillContext(resource, getMetaworksContext());
		return resource;
	}
	
}
