package org.uengine.essencia.model.card;

import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.BasicElement;
import org.uengine.essencia.model.EssenciaElement;
import org.uengine.essencia.model.State;
import org.uengine.essencia.model.view.StateView;

public class AlphaCard extends BasicCard {

	public AlphaCard() {

	}

	public AlphaCard(BasicElement element) {
		this();
		makeCard(element);
	}

	protected void makeCard(BasicElement element) {

		setName(element.getName());
		setDescription(element.getDescription());
		setImg(IMG_LOCATION + element.getElementView().getShapeId() + IMG_EXTENSION);

		x = 96;
		y = 32;

		for (EssenciaElement essenciaElement : ((Alpha) element).getListFace().getEssenciaElementList()) {
			State state = (State) essenciaElement.getValue();
			setSymbol((new StateView().createSymbol()));
			setView(state.createView());

			makeUpView(state);
			if (trcTag == 0) {
				String.valueOf(trcTag++);
			} else {
				getView().setFromEdge(String.valueOf(trcTag++));
			}
			getView().setId(String.valueOf(trcTag++));
			if (((Alpha) element).getListFace().getEssenciaElementList().size() + ((Alpha) element).getListFace().getEssenciaElementList().size() > trcTag) {
				getView().setToEdge(String.valueOf(trcTag));
				makeRelation("");

			}

			getCanvas().getElementViewList().add(getView());
		}

	}

}
