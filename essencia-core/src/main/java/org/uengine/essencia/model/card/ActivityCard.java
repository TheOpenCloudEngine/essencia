package org.uengine.essencia.model.card;

import org.uengine.essencia.model.*;
import org.uengine.essencia.model.view.ActivityArrowView;
import org.uengine.essencia.model.view.AlphaView;
import org.uengine.essencia.model.view.CompetencyView;
import org.uengine.essencia.model.view.WorkProductView;
import org.uengine.modeling.IElement;

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
            for (IElement iElement : ((Activity) element).getEntryCriteriaPanel().getElementListFromCanvas()) {
                if (criterion.getState().getParentAlpha().getName().equals(iElement.getName())) {
                    for (State s : ((Alpha) iElement).getStates()) {
                        if (criterion.getState().getName().equals(s.getName())) {

                            criterion.setState(s);
                            Alpha alpha = new Alpha();
                            alpha.setName(iElement.getName());
                            alpha.setList(((Alpha) iElement).getList());
                            criterion.getState().setParentAlpha(alpha);
//                            criterion.getState().setParentAlpha((Alpha) iElement);
                            break;
                        }
                    }
                    break;
                }
            }
            setSymbol((new AlphaView()).createSymbol());
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

            getView().setElement(criterion.getState().getParentAlpha());
            getView().setId(String.valueOf(trcTag++));

            getCanvas().getElementViewList().add(getView());
            elementIndex++;
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

        getView().setId(String.valueOf(trcTag++));

        getCanvas().getElementViewList().add(getView());
        y += 20;
        // Output Alpha View
        elementIndex = 0;
        description += "<ul>";
        for (LanguageElement e : ((Activity) element).getCompletionCriterionFace().createValue()) {

            Criterion criterion = (Criterion) e;

            for (IElement iElement : ((Activity) element).getCompletionCriterionFace().getElementListFromCanvas()) {
                if (criterion.getState().getParentAlpha().getName().equals(iElement.getName())) {
                    for (State s : ((Alpha) iElement).getStates()) {
                        if (criterion.getState().getName().equals(s.getName())) {
                            criterion.setState(s);
                            Alpha alpha = new Alpha();
                            alpha.setName(iElement.getName());
                            alpha.setList(((Alpha) iElement).getList());
                            criterion.getState().setParentAlpha(alpha);
                            break;
                        }
                    }
                    break;
                }
            }
            description += "<li>" + criterion.getState().getParentAlpha().getName() + ": "
                    + criterion.getState().getParentAlpha().getName() + "</li>";
            setSymbol((new AlphaView().createSymbol()));
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
            for (IElement iElement : ((Activity) element).getWorkProductFace().getElementListFromCanvas()) {
                if ( criterion.getLevelOfDetail().getParentWorkProduct().getName().equals(iElement.getName())) {
                    for (LevelOfDetail l : ((WorkProduct) iElement).getLevelOfDetails()) {
                        if (criterion.getLevelOfDetail().getName().equals(l.getName())) {
                            criterion.setLevelOfDetail(l);
                            criterion.getLevelOfDetail().setParentWorkProduct((WorkProduct) iElement);
                            break;

                        }

                    }
                    break;
                }

            }
            description += "<li>" + criterion.getLevelOfDetail().getParentWorkProduct().getName() + ": " + criterion.getLevelOfDetail().getName()
                    + "</li>";
            setSymbol((new WorkProductView().createSymbol()));
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
