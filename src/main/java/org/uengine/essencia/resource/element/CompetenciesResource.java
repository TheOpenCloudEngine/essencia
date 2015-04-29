package org.uengine.essencia.resource.element;

import org.uengine.essencia.model.Competency;
import org.uengine.modeling.IElement;

public class CompetenciesResource extends EssenciaTypeResource {

	public CompetenciesResource() {
	}

	public CompetenciesResource(String id) {
		super(id, "competencies");
	}

	@Override
	protected EssenciaElementResource makeResource(IElement element, String path) {
		EssenciaElementResource resource = null;

		if (element instanceof Competency) {
			resource = new CompetencyResource(getPath(), element.getName());
		}
		return resource;
	}

}
