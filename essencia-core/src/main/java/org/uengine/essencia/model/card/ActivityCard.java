package org.uengine.essencia.model.card;

import org.uengine.essencia.model.Activity;
import org.uengine.essencia.model.BasicElement;
import org.uengine.essencia.model.Competency;
import org.uengine.essencia.model.Criterion;
import org.uengine.essencia.model.LanguageElement;
import org.uengine.essencia.model.WorkProduct;
import org.uengine.essencia.model.view.ActivityArrowView;
import org.uengine.essencia.model.view.AlphaView;
import org.uengine.essencia.model.view.CompetencyView;
import org.uengine.essencia.model.view.WorkProductView;
import org.uengine.modeling.SymbolFactory;

public class ActivityCard extends BasicCard {

    private final String NEXT_LINE = "<br/>";
    private final int X_INTERVAL = 96;
    private final int Y_INTERVAL = 70;
    private final int X_START = 64;
    private final int Y_START = 48;

    public ActivityCard() {

    }

    public ActivityCard(BasicElement element) {
	this();
	makeCard(element);
    }

    protected void makeCard(BasicElement element) {

	setName(element.getName());
	String description = element.getDescription() + NEXT_LINE + NEXT_LINE + "<span>The activity is completed when:</span>";
	setImg(IMG_LOCATION + element.getElementView().getShapeId() + IMG_EXTENSION);

	int elementIndex = 0;
	y = -30;
	for (LanguageElement e : ((Activity) element).getEntryCriteriaPanel().createValue()) {
	    Criterion criterion = (Criterion) e;
	    setSymbol(SymbolFactory.create(AlphaView.class));
	    setView(criterion.getState().getParentAlpha().createView());

	    x = getXCoordinate(elementIndex);
	    y = getYCoordinate(y, elementIndex);

	    getView().fill(getSymbol());
	    getView().setX(String.valueOf(x));
	    getView().setY(String.valueOf(y));
	    getView().setWidth(String.valueOf(64));
	    getView().setHeight(String.valueOf(24));

	    getView().setElement(criterion.getState().getParentAlpha());
	    getView().setId(String.valueOf(trcTag++));

	    getCanvas().getElementViewList().add(getView());
	    elementIndex++;
	}
	// Competency View
	y = y + Integer.valueOf(getView().getHeight()) + Y_INTERVAL;
	String competencyName = ((Activity) element).getCompetency().getSelectedText();
	setSymbol(SymbolFactory.create(CompetencyView.class));
	Competency competency = new Competency();
	competency.setName(competencyName);
	setView(competency.createView());

	getView().fill(getSymbol());
	getView().setX(String.valueOf(110));
	getView().setY(String.valueOf(y));
	getView().setWidth(String.valueOf(56));
	getView().setHeight(String.valueOf(56));

	getView().setId(String.valueOf(trcTag++));

	getCanvas().getElementViewList().add(getView());
	// Competency Arrow View
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
	for (LanguageElement e : ((Activity) element).getCompletionCriterionFace().createValue()) {
	    Criterion criterion = (Criterion) e;
	    description += "<li>" + criterion.getState().getParentAlpha().getName() + ": "
		    + criterion.getState().getParentAlpha().getName() + "</li>";
	    setSymbol(SymbolFactory.create(AlphaView.class));
	    setView(criterion.getState().getParentAlpha().createView());

	    x = getXCoordinate(elementIndex);
	    y = getYCoordinate(y, elementIndex);

	    ((BasicElement) getView().getElement()).setName(criterion.getState().getParentAlpha().getName() + "(" + criterion.getState().getName()
		    + ")");
	    getView().fill(getSymbol());
	    getView().setX(String.valueOf(x));
	    getView().setY(String.valueOf(y));
	    getView().setWidth(String.valueOf(64));
	    getView().setHeight(String.valueOf(24));
	    getView().setId(String.valueOf(trcTag++));

	    getCanvas().getElementViewList().add(getView());
	    elementIndex++;
	}
	// Output WorkProduct View
	for (LanguageElement e : ((Activity) element).getWorkProductFace().createValue()) {
	    Criterion criterion = (Criterion) e;
	    description += "<li>" + criterion.getLevelOfDetail().getParentWorkProduct().getName() + ": " + criterion.getLevelOfDetail().getName()
		    + "</li>";
	    setSymbol(SymbolFactory.create(WorkProductView.class));
	    setView(new WorkProduct().createView());

	    x = getXCoordinate(elementIndex);
	    y = getYCoordinate(y, elementIndex);

	    ((BasicElement) getView().getElement()).setName(criterion.getLevelOfDetail().getName() + "(" + criterion.getLevelOfDetail().getName()
		    + ")");
	    getView().fill(getSymbol());
	    getView().setX(String.valueOf(x));
	    getView().setY(String.valueOf(y));

	    getView().setId(String.valueOf(trcTag++));

	    getCanvas().getElementViewList().add(getView());
	    elementIndex++;
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
