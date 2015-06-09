package org.uengine.essencia.modeling.modeler;

import org.uengine.essencia.model.*;
import org.uengine.essencia.model.face.list.ListFace;
import org.uengine.essencia.modeling.canvas.EssenciaCanvas;
import org.uengine.essencia.modeling.canvas.MethodCanvas;
import org.uengine.essencia.modeling.palette.EssenciaPalette;
import org.uengine.essencia.util.ElementUtil;
import org.uengine.modeling.IElement;
import org.uengine.modeling.IModel;
import org.uengine.modeling.IRelation;

import java.util.List;

public class MethodComposer extends PracticeDefiner {

    public final static String SUFFIX = ".method";

    public MethodComposer() {
        setType(SUFFIX);
        setCanvas(new MethodCanvas());
        setPalette(new EssenciaPalette());
    }

    /**
     * make complete practice definition from canvas
     * @return
     */
    public PracticeDefinition createPracticeDefinition() {
        PracticeDefinition pd = new PracticeDefinition();

        pd.setElementList(ElementUtil.convertToElementList(((EssenciaCanvas) getCanvas()).getSafeElementViewList()));
        pd.setRelationList(ElementUtil.convertToRelationList(((EssenciaCanvas) getCanvas()).getSafeRelationViewList()));

        for (org.uengine.essencia.model.Activity activity : pd.getElements(org.uengine.essencia.model.Activity.class)) {
            for (LanguageElement e : activity.getEntryCriteria()) {
                createFullCriterion(pd, (Criterion) e);
            }

            for (LanguageElement e : activity.getCompletionCriteria()) {
                createFullCriterion(pd, (Criterion) e);
            }
        }
        return pd;
    }

    /**
     * make entry & completion criteria  completely
     * @param pd
     * @param criterion
     */
    private void createFullCriterion(PracticeDefinition pd, Criterion criterion) {
        if( criterion.getLevelOfDetail() == null ){
            Alpha fullParentAlpha = pd.getElement(criterion.getState().getParentAlpha().getName(), Alpha.class);
            for (State state : fullParentAlpha.getStates()) {
                if (criterion.getState().getName().equals(state.getName())) {
                    criterion.setState(state);
                    break;
                }

            }

            criterion.getState().setParentAlpha(fullParentAlpha);
        } else {
            WorkProduct fullWorkProduct = pd.getElement(criterion.getLevelOfDetail().getParentWorkProduct().getName(), WorkProduct.class);
            for (LevelOfDetail levelOfDetail : fullWorkProduct.getLevelOfDetails()) {
                if (criterion.getLevelOfDetail().getName().equals(levelOfDetail.getName())) {
                    criterion.setLevelOfDetail(levelOfDetail);
                    break;
                }

            }

            criterion.getLevelOfDetail().setParentWorkProduct(fullWorkProduct);
        }

    }


}
