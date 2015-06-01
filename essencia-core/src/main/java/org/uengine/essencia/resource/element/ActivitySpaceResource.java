package org.uengine.essencia.resource.element;

import org.uengine.essencia.model.Activity;
import org.uengine.modeling.IElement;

public class ActivitySpaceResource extends EssenciaElementResource {

	public ActivitySpaceResource() {
	}

	public ActivitySpaceResource(String id, String displayName) {
		super(id, displayName);

	}

	@Override
	protected void makeChildResource(IElement element, String path) {
		EssenciaElementResource resource = null;

		if (element instanceof Activity) {
			resource = new ActivityResource(getPath(), element.getName());
		}

		addResourceAsChild(resource, element, path);
	}
}