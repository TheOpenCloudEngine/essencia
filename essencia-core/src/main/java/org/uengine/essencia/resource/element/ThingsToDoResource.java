package org.uengine.essencia.resource.element;

import org.uengine.essencia.model.ActivitySpace;
import org.uengine.modeling.IElement;

public class ThingsToDoResource extends EssenciaTypeResource {

	public ThingsToDoResource() {
	}

	public ThingsToDoResource(String id) {
		super(id, "things to do");
	}

	@Override
	protected EssenciaElementResource makeResource(IElement element, String path) {
		EssenciaElementResource resource = null;
		if (element instanceof ActivitySpace) {
			resource = new ActivitySpaceResource(getPath(), element.getName());
		}
		return resource;
	}

}
