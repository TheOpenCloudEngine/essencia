package org.uengine.essencia.model.card;

import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.BasicElement;
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


		setDetail(new Detail());
		getDetail().setDescription(element.getDescription());


		setImg(IMG_LOCATION + element.getElementView().getShapeId() + IMG_EXTENSION);

		x = 96;
		y = 32;

		for (State state : ((Alpha) element).getStates()) {
			setSymbol((new StateView().createSymbol()));
			setView(state.createView());

			makeUpView(state);
			if (trcTag == 0) {
				trcTag++;
			} else {
				getView().setFromEdge("ac" + String.valueOf(trcTag++));
			}
			getView().setId("ac" + String.valueOf(trcTag++));

			if (((Alpha) element).getStates().size() * 2 > trcTag) {
				getView().setToEdge("ac" + String.valueOf(trcTag));
				makeRelation("ac");
			}

			getCanvas().getElementViewList().add(getView());
		}

	}



}
