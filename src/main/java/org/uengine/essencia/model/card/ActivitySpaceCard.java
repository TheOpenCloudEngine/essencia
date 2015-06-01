package org.uengine.essencia.model.card;

import org.uengine.essencia.model.Activity;
import org.uengine.essencia.model.ActivitySpace;
import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.BasicElement;
import org.uengine.essencia.model.Criterion;
import org.uengine.essencia.model.LanguageElement;
import org.uengine.essencia.model.view.ActivityArrowView;
import org.uengine.essencia.model.view.AlphaView;

public class ActivitySpaceCard extends BasicCard {

	private final String NEXT_LINE = "<br/>";
	private final int X_INTERVAL = 96;
	private final int Y_INTERVAL = 70;
	private final int X_START = 64;
	private final int Y_START = -30;

	public ActivitySpaceCard() {

	}

	public ActivitySpaceCard(BasicElement element) {
		this();
		makeCard(element);
	}

	protected void makeCard(BasicElement element) {

		setName(element.getName());
		String description = element.getDescription() + NEXT_LINE + NEXT_LINE + "<span>The activity space is completed when:</span>";
		setImg(IMG_LOCATION + element.getElementView().getShapeId() + IMG_EXTENSION);

		int elementIndex = 0;
		y = Y_START;

		for (LanguageElement e : ((ActivitySpace) element).getInputFace().createValue()) {
		    	Alpha inputAlpha = (Alpha)e;
			setSymbol((new AlphaView().createSymbol()));
			setView(inputAlpha.createView());

			x = getXCoordinate(elementIndex);
			y = getYCoordinate(y, elementIndex);

			getView().fill(getSymbol());
			getView().setX(String.valueOf(x));
			getView().setY(String.valueOf(y));
			getView().setWidth(String.valueOf(64));
			getView().setHeight(String.valueOf(24));

			getView().setElement(inputAlpha);
			getView().setId(String.valueOf(trcTag++));

			getCanvas().getElementViewList().add(getView());
			elementIndex++;
		}
		// Competency Arrow View
		y = y + Integer.valueOf(getView().getHeight()) + Y_INTERVAL;
		setView(new ActivityArrowView());
		setSymbol(getView().createSymbol());

		getView().fill(getSymbol());
		getView().setX(String.valueOf(110));
		getView().setY(String.valueOf(y));
		getView().setWidth(String.valueOf(120));
		getView().setHeight(String.valueOf(100));

		getView().setId(String.valueOf(trcTag++));

		getCanvas().getElementViewList().add(getView());
		y += 20;
		// Output Alpha View
		elementIndex = 0;
		description += "<ul>";
		for (LanguageElement e : ((ActivitySpace) element).getCompletionCriterionFace().createValue()) {
		    Criterion criterion = (Criterion)e;
			description += "<li>" + criterion.getState().getParentAlpha().getName() + ": " + criterion.getState().getName() + "</li>";
			setSymbol((new AlphaView().createSymbol()));
			setView(criterion.getState().getParentAlpha().createView());

			x = getXCoordinate(elementIndex);
			y = getYCoordinate(y, elementIndex);

			((BasicElement)getView().getElement()).setName(criterion.getState().getParentAlpha().getName() + "(" + criterion.getState().getName() + ")");
			getView().fill(getSymbol());
			getView().setX(String.valueOf(x));
			getView().setY(String.valueOf(y));
			getView().setWidth(String.valueOf(64));
			getView().setHeight(String.valueOf(24));
			getView().setId(String.valueOf(trcTag++));

			getCanvas().getElementViewList().add(getView());
			elementIndex++;
		}
		description += "</ul>";
		description += "<span>Activities:</span><ul>";
		if (((ActivitySpace) element).getChildActivities() != null) {
			for (Activity activity : ((ActivitySpace) element).getChildActivities()) {
				description += "<li>" + activity.getName() + "</li>";
			}
		}
		description += "</ul>";
		setDescription(description);
	}

	private int getXCoordinate(int elementIndex) {
		if (elementIndex % 2 == 1) {
			return X_START + X_INTERVAL;
		}
		return X_START;
	}

	private int getYCoordinate(int y, int elementIndex) {
		if (elementIndex % 2 == 0) {
			y += Y_INTERVAL;
		}
		return y;
	}
}
