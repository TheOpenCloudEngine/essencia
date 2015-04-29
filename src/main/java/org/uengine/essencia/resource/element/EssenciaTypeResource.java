package org.uengine.essencia.resource.element;

import java.util.List;

import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.modeling.IElement;

public abstract class EssenciaTypeResource extends EssenciaResource {

	public EssenciaTypeResource() {
	}

	public EssenciaTypeResource(String id, String name) {
		setPath(id);
		setDisplayName(name);
	}

	@Override
	protected List<IElement> findCandidateResources(PracticeDefinition practice) {
		List<IElement> firstDepthElements = practice.findChildElements(practice.getElementByName(practice.getPracticeName()).getElementView());
		return firstDepthElements;
	}

	@Override
	protected void makeChildResource(IElement element, String path) {
		EssenciaElementResource resource = null;

		resource = makeResource(element, path);

		if (resource != null) {
			addResourceAsChild(resource, element, path);
		}
	}

	protected abstract EssenciaElementResource makeResource(IElement element, String path);

}
