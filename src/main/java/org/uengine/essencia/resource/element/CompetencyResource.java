package org.uengine.essencia.resource.element;

import org.uengine.modeling.IElement;

public class CompetencyResource extends EssenciaElementResource {

	public CompetencyResource() {
	}

	public CompetencyResource(String id, String displayName) {
		super(id, displayName);
	}

	@Override
	protected void makeChildResource(IElement element, String path) {
		EssenciaElementResource resource = new CompetencyResource(getPath(), element.getName());

		addResourceAsChild(resource, element, path);
	}

}