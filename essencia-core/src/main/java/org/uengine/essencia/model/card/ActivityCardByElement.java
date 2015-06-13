package org.uengine.essencia.model.card;

import org.metaworks.ContextAware;
import org.metaworks.MetaworksContext;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.model.*;
import org.uengine.essencia.model.view.ActivityArrowView;
import org.uengine.essencia.model.view.AlphaView;
import org.uengine.essencia.model.view.CompetencyView;
import org.uengine.essencia.model.view.WorkProductView;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.modeling.IElement;

import java.util.ArrayList;
import java.util.List;

public class ActivityCardByElement extends ActivityCard implements ContextAware {
    public ActivityCardByElement() {

    }

    public ActivityCardByElement(BasicElement element) {
        this();
        makeCard(element);
    }

    protected void makeCard(BasicElement element) {

        setName(element.getName());
        String description = element.getDescription() + NEXT_LINE + NEXT_LINE + "<span>The activity is completed when:</span>";

        List<Criterion> entryList = null;
        List<LanguageElement> completionList = null;
        List<LanguageElement> workProductList = null;

        setView(element.createView());
        setImg(IMG_LOCATION + getView().getShapeId() + IMG_EXTENSION);

        entryList = ((Activity) element).getEntryCriteria();
        completionList = new ArrayList<>();
        workProductList = new ArrayList<>();

        for (LanguageElement l : ((Activity) element).getCompletionCriteria()) {
            Criterion c = (Criterion) l;
            if (c.getState() != null) {
                completionList.add(l);
            } else {
                workProductList.add(l);
            }
        }

        int elementIndex = 0;
        y = -30;

        if (entryList != null) {
            for (LanguageElement e : entryList) {
                Criterion criterion = (Criterion) e;
                setSymbol((new AlphaView()).createSymbol());
                setView(criterion.getState().getParentAlpha().createView());

                x = getXCoordinate(elementIndex);
                y = getYCoordinate(y, elementIndex);

                getView().fill(getSymbol());
                getView().setX(String.valueOf(x));
                getView().setY(String.valueOf(y));
                getView().setWidth(String.valueOf(64));
                getView().setHeight(String.valueOf(24));

                getView().setElement(criterion.getState().getParentAlpha());
                getCanvas().getElementViewList().add(getView());
                elementIndex++;
            }
        }
        // Competency View
        y = y + Integer.valueOf(getView().getHeight()) + Y_INTERVAL;
        String competencyName = ((Activity) element).getCompetency().getSelectedText();
        setSymbol(new CompetencyView().createSymbol());
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

        getCanvas().getElementViewList().add(getView());
        y += 20;
        // Output Alpha View
        elementIndex = 0;
        description += "<ul>";
        for (LanguageElement e : completionList) {
            Criterion criterion = (Criterion) e;
            description += "<li>" + criterion.getState().getParentAlpha().getName() + ": "
                    + criterion.getState().getParentAlpha().getName() + "</li>";
            setSymbol((new AlphaView().createSymbol()));
            setView(criterion.getState().getParentAlpha().createView());

            x = getXCoordinate(elementIndex);
            y = getYCoordinate(y, elementIndex);

            ///TODO:  Never do like this: model will be re-used. so, it may distort operation
//            ((BasicElement) getView().getElement()).setName(criterion.getState().getParentAlpha().getName() + "(" + criterion.getState().getName()
//                    + ")");
            getView().fill(getSymbol());
            getView().setX(String.valueOf(x));
            getView().setY(String.valueOf(y));
            getView().setWidth(String.valueOf(64));
            getView().setHeight(String.valueOf(24));

            getCanvas().getElementViewList().add(getView());
            elementIndex++;
        }
        // Output WorkProduct View
        for (LanguageElement e : workProductList) {
            Criterion criterion = (Criterion) e;
            description += "<li>" + criterion.getLevelOfDetail().getParentWorkProduct().getName() + ": " + criterion.getLevelOfDetail().getName()
                    + "</li>";
            setSymbol((new WorkProductView().createSymbol()));
            setView(new WorkProduct().createView());

            x = getXCoordinate(elementIndex);
            y = getYCoordinate(y, elementIndex);

            //TODO: never do this: instance data may harm the definition data. two should be separated by context input
//            ((BasicElement) getView().getElement()).setName(criterion.getLevelOfDetail().getName() + "(" + criterion.getLevelOfDetail().getName()
//                    + ")");

            getView().fill(getSymbol());
            getView().setX(String.valueOf(x));
            getView().setY(String.valueOf(y));

            getCanvas().getElementViewList().add(getView());
            elementIndex++;
        }
        description += "</ul>";
        setDescription(description);

        ContextUtil.setWhen(this, EssenciaContext.WHEN_VIEW);
    }

    private MetaworksContext context;
    @Override
    public MetaworksContext getMetaworksContext() {
        return this.context;
    }

    @Override
    public void setMetaworksContext(MetaworksContext context) {
        this.context = context;
    }
}
