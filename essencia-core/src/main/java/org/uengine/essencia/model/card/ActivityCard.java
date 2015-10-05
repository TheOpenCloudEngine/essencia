package org.uengine.essencia.model.card;

import org.uengine.essencia.model.*;
import org.uengine.essencia.model.face.ActivityCompletionCriterionFace;
import org.uengine.essencia.model.face.ActivityEntryCriterionFace;
import org.uengine.essencia.model.face.WorkProductFace;
import org.uengine.essencia.model.view.ActivityArrowView;
import org.uengine.essencia.model.view.AlphaView;
import org.uengine.essencia.model.view.CompetencyView;
import org.uengine.essencia.model.view.WorkProductView;
import org.uengine.kernel.GlobalContext;

import java.util.List;

public class ActivityCard extends BasicCard {

    protected final String NEXT_LINE = "<br/>";
    protected final int X_INTERVAL = 96;
    protected final int Y_INTERVAL = 70;
    protected final int X_START = 64;
    protected final int Y_START = 48;

    public ActivityCard() {

    }

    public ActivityCard(BasicElement element) {
        this();

//        try {
//            element = (BasicElement)GlobalContext.deserialize(GlobalContext.serialize(element, String.class), String.class);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        makeCard(element);
    }

    protected void makeCard(BasicElement element) {

        //TODO: costly
        try {
            element = (BasicElement) GlobalContext.deserialize(GlobalContext.serialize(element, String.class));
        } catch (Exception e) {
            throw new RuntimeException("Error when to clone Alpha element", e);
        }

        setName(element.getName());
        String description = element.getDescription() + NEXT_LINE + NEXT_LINE + "<span>The activity is completed when:</span>";
        setImg(IMG_LOCATION + element.getElementView().getShapeId() + IMG_EXTENSION);

        int elementIndex = 0;
        y = -30;

        List<EntryCriterion> entryCriteriaList;

        if(((Activity) element).getEntryCriteriaPanel()!=null){
            entryCriteriaList =((ActivityEntryCriterionFace)((Activity) element).getEntryCriteriaPanel()).createValue();
        }else{
            entryCriteriaList = ((Activity) element).getEntryCriteria();
        }

        if(entryCriteriaList!=null)
        for (LanguageElement e : entryCriteriaList) {
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
            getView().setId(String.valueOf(trcTag++));

            ((BasicElement) getView().getElement()).setName(criterion.getState().getParentAlpha().getName());// + "(" + criterion.getState().getName()+ ")");

            getCanvas().getElementViewList().add(getView());
            elementIndex++;
        }
        // Competency View

        if(getView()!=null)
            y = y + Integer.valueOf(getView().getHeight()) + Y_INTERVAL;
        else
            y = y + Y_INTERVAL;

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

        List<CompletionCriterion> completionCriterionList;
        if(((Activity) element).getCompletionCriterionFace()!=null){
            completionCriterionList = ((ActivityCompletionCriterionFace)((Activity) element).getCompletionCriterionFace()).createValue();
        }else{
            completionCriterionList = ((Activity) element).getCompletionCriteria();
        }

        if(completionCriterionList!=null)
        for (LanguageElement e : completionCriterionList) {
            Criterion criterion = (Criterion) e;

            BasicElement theElementForCriteria = criterion.getElement();

            description += "<li>" + theElementForCriteria.getName() + ": "

                    + (theElementForCriteria instanceof Alpha ? criterion.getState().getName() : criterion.getLevelOfDetail().getName()) //TODO: must be criterion.getLevelElement()
                    ;

            setView(theElementForCriteria.createView());

            setSymbol(getView().createSymbol());

            x = getXCoordinate(elementIndex);
            y = getYCoordinate(y, elementIndex);

            ((BasicElement) getView().getElement()).setName(theElementForCriteria.getName() + "("
                    + (theElementForCriteria instanceof Alpha ? criterion.getState().getName() : criterion.getLevelOfDetail().getName()) //TODO: must be criterion.getLevelElement()
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

        List<CompletionCriterion> workProductList;

        if(((Activity) element).getWorkProductFace()!=null){
            workProductList = ((WorkProductFace)((Activity) element).getWorkProductFace()).createValue();
        }else{
            workProductList = null;
        }

        // Output WorkProduct View
        if(workProductList!=null)
        for (LanguageElement e : workProductList) {
            Criterion criterion = (Criterion) e;
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

    protected int getXCoordinate(int elementIndex) {
        if (elementIndex % 2 == 1) {
            return X_START + X_INTERVAL;
        }
        return X_START;
    }

    protected int getYCoordinate(int y, int elementIndex) {
        if (elementIndex % 2 == 0) {
            y += Y_INTERVAL;
        }
        return y;
    }
}
