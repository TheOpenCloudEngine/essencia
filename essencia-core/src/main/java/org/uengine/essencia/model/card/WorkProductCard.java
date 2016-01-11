package org.uengine.essencia.model.card;

import org.uengine.essencia.model.*;
import org.uengine.essencia.model.view.LevelOfDetailView;
import org.uengine.modeling.ElementView;

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
        setImg(IMG_LOCATION + element.getElementView().getShapeId() + IMG_EXTENSION);

        x = 120;
        y = 48;

        for (LevelOfDetail levelOfDetail : ((WorkProduct)element).getLevelOfDetails()) {
            setSymbol(new LevelOfDetailView().createSymbol());
            setView(levelOfDetail.createView());

            makeUpView(levelOfDetail);

            if (trcTag == 0) {
                String.valueOf(trcTag++);
            } else {
                getView().setFromEdge(String.valueOf(trcTag++));
            }

            getView().setId(String.valueOf(trcTag++));

            if (((WorkProduct) element).getListFace().getEssenciaElementList().size() + ((WorkProduct) element).getListFace().getEssenciaElementList().size() > trcTag) {
                getView().setToEdge(String.valueOf(trcTag));
                makeRelation("");
            }

            getCanvas().getElementViewList().add(getView());
        }
    }

}
