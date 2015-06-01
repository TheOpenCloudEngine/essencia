package org.uengine.essencia.resource.element;

import org.uengine.modeling.IElement;

public class WorkProductResource extends EssenciaElementResource {

	public WorkProductResource() {
	}

	public WorkProductResource(String id, String displayName) {
		super(id, displayName);
	}

	@Override
	protected void makeChildResource(IElement element, String path) {
		EssenciaElementResource resource = new WorkProductResource(getPath(), element.getName());

		addResourceAsChild(resource, element, path);
	}

}