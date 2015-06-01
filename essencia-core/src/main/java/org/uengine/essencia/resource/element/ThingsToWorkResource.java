package org.uengine.essencia.resource.element;

import org.uengine.essencia.model.Alpha;
import org.uengine.modeling.IElement;

public class ThingsToWorkResource extends EssenciaTypeResource {

	public ThingsToWorkResource() {
	}

	public ThingsToWorkResource(String id) {
		super(id, "things to work with");
	}

	@Override
	protected EssenciaElementResource makeResource(IElement element, String path) {
		EssenciaElementResource resource = null;

		if (element instanceof Alpha) {
			resource = new AlphaResource(getPath(), element.getName());
		}
		return resource;
	}

}
