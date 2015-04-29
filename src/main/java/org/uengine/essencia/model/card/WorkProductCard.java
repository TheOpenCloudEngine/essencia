package org.uengine.essencia.model.card;

import org.uengine.essencia.model.BasicElement;
import org.uengine.essencia.model.LevelOfDetail;
import org.uengine.essencia.model.WorkProduct;
import org.uengine.essencia.model.view.LevelOfDetailView;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.SymbolFactory;

public class WorkProductCard extends BasicCard {

    public WorkProductCard() {

    }

    public WorkProductCard(BasicElement element) {
	this();
	makeCard(element);
    }

    protected void makeCard(BasicElement element) {

	setName(element.getName());
	setDescription(element.getDescription());
	ElementView tempView = element.createView();
	tempView.fill(tempView.createSymbol());
	element.setElementView(tempView);
	setImg(IMG_LOCATION + element.getElementView().getShapeId() + IMG_EXTENSION);

	x = 120;
	y = 48;

	String prefix = getName().replaceAll(" ", "");

	for (LevelOfDetail levelOfDetail : ((WorkProduct) element).getListFace().createValue()) {
	    setSymbol(SymbolFactory.create(LevelOfDetailView.class));
	    setView(levelOfDetail.createView());

	    makeUpView(levelOfDetail);

	    if (trcTag > 0) {
		getView().setFromEdge(prefix + String.valueOf(trcTag++));
	    }

	    getView().setId(prefix + String.valueOf(trcTag++));

	    if (getCanvas().getElementViewList().size() < ((WorkProduct) element).getListFace().getEssenciaElementList().size() - 1) {
		getView().setToEdge(prefix + String.valueOf(trcTag));
		makeRelation(prefix);
	    }

	    getCanvas().getElementViewList().add(getView());
	}
    }

}
