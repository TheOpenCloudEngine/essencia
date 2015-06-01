package org.uengine.essencia.resource.element;

import java.util.List;

import org.metaworks.Refresh;
import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.Available;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.Clipboard;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.modeling.canvas.EssenciaCanvas;
import org.uengine.modeling.IElement;

public abstract class EssenciaElementResource extends EssenciaResource {

	public EssenciaElementResource() {
	}

	public EssenciaElementResource(String id, String displayName) {
		setPath(id);
		setDisplayName(displayName);
	}

	@Override
	protected List<IElement> findCandidateResources(PracticeDefinition practice) {
		List<IElement> firstDepthElements = practice.findChildElements(practice.getElementByName(getDisplayName()).getElementView());
		return firstDepthElements;
	}

	@Hidden
	@Available(condition = "metaworksContext.how == 'tree' && metaworksContext.where == 'navigator'")
	@ServiceMethod(callByContent = true, mouseBinding = "drag", bindingHidden = true, target = ServiceMethodContext.TARGET_APPEND)
	public Object drag() {
		return new Refresh(new Clipboard(EssenciaCanvas.CANVAS_DROP, this), true);
	}

}
