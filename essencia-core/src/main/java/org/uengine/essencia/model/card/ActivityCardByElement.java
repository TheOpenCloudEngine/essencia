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
import org.uengine.kernel.GlobalContext;
import org.uengine.modeling.IElement;

import javax.annotation.processing.Completion;
import java.util.ArrayList;
import java.util.List;

public class ActivityCardByElement extends ActivityCard implements ContextAware {
    public ActivityCardByElement() {

    }

    public ActivityCardByElement(BasicElement element) {
        this();

        try {
            element = (BasicElement) GlobalContext.deserialize(GlobalContext.serialize(element, String.class), String.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        makeCard(element);
    }

    protected void makeCard(BasicElement element) {

        setName(element.getName());
        String description = element.getDescription() + NEXT_LINE + NEXT_LINE + "<span>The activity is completed when:</span>";

        List<EntryCriterion> entryList = null;
        List<CompletionCriterion> completionList = null;
        List<CompletionCriterion> workProductList = null;

        setView(element.createView());
        setImg(IMG_LOCATION + getView().getShapeId() + IMG_EXTENSION);

        entryList = ((Activity) element).getEntryCriteria();
        completionList = new ArrayList<>();
        workProductList = new ArrayList<>();

        for (LanguageElement l : ((Activity) element).getCompletionCriteria()) {
            Criterion c = (Criterion) l;
            if (c.getState() != null) {
                completionList.add((CompletionCriterion)c);
            } else {
                workProductList.add((CompletionCriterion)c);
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
                getView().setX((x));
                getView().setY((y));
                getView().setWidth((64));
                getView().setHeight((24));

                getView().setElement(criterion.getState().getParentAlpha());
                getCanvas().getElementViewList().add(getView());
                elementIndex++;
            }
        }
        // Competency View
        y = y + (getView().getHeight()) + Y_INTERVAL;
        String competencyName = ((Activity) element).getCompetency().getSelectedText();
        setSymbol(new CompetencyView().createSymbol());
        Competency competency = new Competency();
        competency.setName(competencyName);
        setView(competency.createView());

        getView().fill(getSymbol());
        getView().setX((110));
        getView().setY((y));
        getView().setWidth((56));
        getView().setHeight((56));

        getView().setId(String.valueOf(trcTag++));

        getCanvas().getElementViewList().add(getView());
        // Competency Arrow View
        setView(new ActivityArrowView());
        setSymbol(getView().createSymbol());

        getView().fill(getSymbol());
        getView().setX((110));
        getView().setY((y));
        getView().setWidth((120));
        getView().setHeight((100));

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

            ((BasicElement) getView().getElement()).setName(criterion.getState().getParentAlpha().getName() + "(" + criterion.getState().getName()
                    + ")");
            getView().fill(getSymbol());
            getView().setX((x));
            getView().setY((y));
            getView().setWidth((64));
            getView().setHeight((24));

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

//            ((BasicElement) getView().getElement()).setName(criterion.getLevelOfDetail().getName() + "(" + criterion.getLevelOfDetail().getName()
//                    + ")");
            getView().fill(getSymbol());
            getView().setX((x));
            getView().setY((y));

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
