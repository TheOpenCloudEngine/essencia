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
import org.uengine.modeling.ElementView;
import org.uengine.modeling.layout.FlowLayout;
import org.uengine.modeling.layout.GridLayout;
import org.uengine.modeling.layout.LayoutGroup;

import java.util.ArrayList;
import java.util.List;

public class ActivityCard extends BasicCard {

    public static final int competencyH = 100;
    protected final String NEXT_LINE = "<br/>";
    protected final int X_INTERVAL = 96;
    protected final int Y_INTERVAL = 70;
    protected final int X_START = 64;
    protected final int Y_START = 48;


    public static final int canvasW = 400, canvasH = 300;




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
        String description = element.getDescription() + NEXT_LINE + NEXT_LINE + "<h3>The activity is completed when:</h3>";
        setImg(IMG_LOCATION + element.getElementView().getShapeId() + IMG_EXTENSION);

        int elementIndex = 0;
        y = -30;

        List<EntryCriterion> entryCriteriaList;

        if (((Activity) element).getEntryCriteriaPanel() != null) {
            entryCriteriaList = ((ActivityEntryCriterionFace) ((Activity) element).getEntryCriteriaPanel()).createValue();
        } else {
            entryCriteriaList = ((Activity) element).getEntryCriteria();
        }

        GridLayout gridLayout = new GridLayout();

        List<ElementView> entryElementViews = new ArrayList<ElementView>();

        if (entryCriteriaList != null) {

            for (LanguageElement e : entryCriteriaList) {
                Criterion criterion = (Criterion) e;
                setSymbol((new AlphaView()).createSymbol());
                setView(criterion.getState().getParentAlpha().createView());

                getView().fill(getSymbol());
                getView().setElement(criterion.getState().getParentAlpha());
                getView().setId(String.valueOf(trcTag++));

                ((BasicElement) getView().getElement()).setName(criterion.getState().getParentAlpha().getName());// + "(" + criterion.getState().getName()+ ")");

                getCanvas().getElementViewList().add(getView());
                elementIndex++;

                entryElementViews.add(getView());
            }

            FlowLayout flowLayout = new FlowLayout();
            flowLayout.setElementViews(entryElementViews);
            gridLayout.add(flowLayout);

        }


        ////// center arrow

        LayoutGroup centerArrow = new LayoutGroup();

        y = competencyH / 2;

        {
            // Competency Arrow View
            setView(new ActivityArrowView());
            setSymbol(getView().createSymbol());

            getView().fill(getSymbol());
            getView().setX((canvasW / 2));
            getView().setY((y));
            getView().setWidth((120));
            getView().setHeight((competencyH));

            getView().setId(String.valueOf(trcTag++));

            centerArrow.getElementViews().add(getView());

            getCanvas().getElementViewList().add(getView());
        }

        {
            Competency competency= ((Activity) element).getCompetency();
            setSymbol(new CompetencyView().createSymbol());
            setView(competency.createView());

            getView().fill(getSymbol());
            getView().setX((canvasW / 2));
            getView().setY((y));
            getView().setWidth((56));
            getView().setHeight((56));

            getView().setId(String.valueOf(trcTag++));

            getCanvas().getElementViewList().add(getView());
            centerArrow.getElementViews().add(getView());
        }


        // Output Alpha View
        elementIndex = 0;
        description += "<ul>";


        gridLayout.add(centerArrow);


        /////////


        List<CompletionCriterion> completionCriterionList;
        if(((Activity) element).getCompletionCriterionFace()!=null){
            completionCriterionList = ((ActivityCompletionCriterionFace)((Activity) element).getCompletionCriterionFace()).createValue();
        }else{
            completionCriterionList = ((Activity) element).getCompletionCriteria();
        }


        List<ElementView> completionElementViews = new ArrayList<ElementView>();

        if(completionCriterionList!=null) {

            for (LanguageElement e : completionCriterionList) {
                Criterion criterion = (Criterion) e;

                BasicElement theElementForCriteria = criterion.getElement();

                if(theElementForCriteria==null || (theElementForCriteria instanceof Alpha ? criterion.getState()==null : criterion.getLevelOfDetail()==null)) continue;

                description += "<h4>" + theElementForCriteria.getName() + ": "

                        + (theElementForCriteria instanceof Alpha ? criterion.getState().getName() : criterion.getLevelOfDetail().getName()) //TODO: must be criterion.getLevelElement()
                ;

                setView(theElementForCriteria.createView());

                setSymbol(getView().createSymbol());

                ((BasicElement) getView().getElement()).setName(theElementForCriteria.getName() + "("
                        + (theElementForCriteria instanceof Alpha ? criterion.getState().getName() : criterion.getLevelOfDetail().getName()) //TODO: must be criterion.getLevelElement()
                        + ")");
                getView().fill(getSymbol());
                getView().setId(String.valueOf(trcTag++));

                getCanvas().getElementViewList().add(getView());

                completionElementViews.add(getView());
                elementIndex++;
            }

        }

        List<CompletionCriterion> workProductList;

        if(((Activity) element).getWorkProductFace()!=null){
            workProductList = ((WorkProductFace)((Activity) element).getWorkProductFace()).createValue();
        }else{
            workProductList = null;
        }

        // Output WorkProduct View
        if(workProductList!=null) {
            for (LanguageElement e : workProductList) {
                Criterion criterion = (Criterion) e;
                description += "<h4>" + criterion.getLevelOfDetail().getParentWorkProduct().getName() + ": " + criterion.getLevelOfDetail().getName()
                        + "</h4>";
                setSymbol((new WorkProductView().createSymbol()));
                setView(new WorkProduct().createView());

                ((BasicElement) getView().getElement()).setName(criterion.getLevelOfDetail().getName() + "(" + criterion.getLevelOfDetail().getName()
                        + ")");
                getView().fill(getSymbol());

                getView().setId(String.valueOf(trcTag++));

                getCanvas().getElementViewList().add(getView());
                elementIndex++;

                completionElementViews.add(getView());

            }
        }

        if(completionElementViews.size() > 0) {
            FlowLayout flowLayout = new FlowLayout();
            //flowLayout.setStartY(startY);
            flowLayout.setElementViews(completionElementViews);

            gridLayout.add(flowLayout);
        }

        description += "</ul>";
        setDescription(description);



        gridLayout.layout();

//        //adjust the whole elements to be vertically middle.
//
//        int adjustY = (canvasH - y ) / 2;
//
//        for(ElementView elementView : getCanvas().getElementViewList()){
//            //Integer.parseInt(elementView.getX());
//            int currY = Integer.parseInt(elementView.getY());
//            elementView.setY(currY + adjustY);
//        }

    }


    protected double getXCoordinate(double elementIndex) {
        if (elementIndex % 2 == 1) {
            return X_START + X_INTERVAL;
        }
        return X_START;
    }

    protected double getYCoordinate(double y, int elementIndex) {
        if (elementIndex % 2 == 0) {
            y += Y_INTERVAL;
        }
        return y;
    }
}
