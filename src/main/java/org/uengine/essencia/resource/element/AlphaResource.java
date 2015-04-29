package org.uengine.essencia.resource.element;

import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.WorkProduct;
import org.uengine.modeling.IElement;

public class AlphaResource extends EssenciaElementResource {

	public AlphaResource() {
	}

	public AlphaResource(String id, String displayName) {
		super(id, displayName);
	}

	@Override
	protected void makeChildResource(IElement element, String path) {
		EssenciaElementResource resource = null;

		if (element instanceof Alpha) {
			resource = new AlphaResource(getPath(), element.getName());
		} else if (element instanceof WorkProduct) {
			resource = new WorkProductResource(getPath(), element.getName());
		}

		addResourceAsChild(resource, element, path);
	}
}