package org.uengine.essencia.modeling.modeler;

import org.metaworks.annotation.AutowiredToClient;
import org.metaworks.annotation.Hidden;
import org.uengine.essencia.model.*;
import org.uengine.essencia.modeling.canvas.EssenciaCanvas;
import org.uengine.essencia.modeling.canvas.MethodCanvas;
import org.uengine.essencia.modeling.palette.EssenciaPalette;
import org.uengine.essencia.util.ElementUtil;
import org.uengine.modeling.ElementViewActionDelegate;
import org.uengine.modeling.IModel;
import org.uengine.modeling.modeler.DefaultElementViewActionDelegate;
import org.uengine.util.UEngineUtil;

public class MethodComposer extends PracticeDefiner {

    public final static String SUFFIX = ".method";

    public MethodComposer() {
        setType(SUFFIX);
        setCanvas(new MethodCanvas());
        setPalette(new EssenciaPalette());
    }


    ElementViewActionDelegate elementViewActionDelegate;
    @Hidden
    @AutowiredToClient
    public ElementViewActionDelegate getElementViewActionDelegate() {
        return elementViewActionDelegate;
    }
    public void setElementViewActionDelegate(ElementViewActionDelegate elementViewActionDelegate) {
        this.elementViewActionDelegate = elementViewActionDelegate;
    }

    /**
     * make complete practice definition from canvas
     * @return
     */
    public PracticeDefinition createPracticeDefinition() {
        PracticeDefinition pd = new PracticeDefinition();

        pd.setBaseKernel(getBaseKernel());

        pd.setElementList(ElementUtil.convertToElementList(((EssenciaCanvas) getCanvas()).getSafeElementViewList()));
        pd.setRelationList(ElementUtil.convertToRelationList(((EssenciaCanvas) getCanvas()).getSafeRelationViewList()));

        for (org.uengine.essencia.model.Activity activity : pd.getElements(org.uengine.essencia.model.Activity.class)) {

            if(activity.getEntryCriteria()!=null)
            for (int i=0; i<activity.getEntryCriteria().size(); i++) {

                LanguageElement e = activity.getEntryCriteria().get(i);

                if(!fillRealCriterion(pd, (Criterion) e)){
                    activity.getEntryCriteria().remove(e);
                }
            }

            if(activity.getCompletionCriteria()!=null)
            for (int i=0; i<activity.getCompletionCriteria().size(); i++) {

                if(activity instanceof ActivitySpace) continue;  //TODO:  remove this sometime

                LanguageElement e = activity.getCompletionCriteria().get(i);

                Criterion completionCriterion = (Criterion)e;

                boolean filled = false;

                //TODO: if value is valid, the value states are valid too.
                if(completionCriterion.getLevelOfDetail()!=null && UEngineUtil.isNotEmpty(completionCriterion.getLevelOfDetail().getName())) {
                    filled = fillRealCriterion(pd, (Criterion) e);
                }else if(completionCriterion.getState()!=null && UEngineUtil.isNotEmpty(completionCriterion.getState().getName())) {
                    filled = fillRealCriterion(pd, (Criterion) e);
                }

                if(!filled){
                    activity.getCompletionCriteria().remove(e);
                }

            }
        }
        return pd;
    }

    /**
     * make entry & completion criteria  completely
     * @param pd
     * @param criterion
     */
    private boolean fillRealCriterion(PracticeDefinition pd, Criterion criterion) {
        if( criterion.getLevelOfDetail() == null ){
            Alpha fullParentAlpha = pd.getElement(criterion.getState().getParentAlpha().getName(), Alpha.class);

            if(fullParentAlpha!=null && fullParentAlpha.getStates()!=null){
                for (State state : fullParentAlpha.getStates()) {
                    if (criterion.getState().getName().equals(state.getName())) {
                        criterion.setState(state);
                        break;
                    }

                }

                criterion.getState().setParentAlpha(fullParentAlpha);

                return true;
            }

        } else {
            WorkProduct fullWorkProduct = pd.getElement(criterion.getLevelOfDetail().getParentWorkProduct().getName(), WorkProduct.class);

            if(fullWorkProduct!=null && fullWorkProduct.getLevelOfDetails()!=null) {
                for (LevelOfDetail levelOfDetail : fullWorkProduct.getLevelOfDetails()) {
                    if (criterion.getLevelOfDetail().getName().equals(levelOfDetail.getName())) {
                        criterion.setLevelOfDetail(levelOfDetail);
                        break;
                    }

                }

                criterion.getLevelOfDetail().setParentWorkProduct(fullWorkProduct);

                return true;
            }
        }

        return false;
    }

    @Override
    public void setModel(IModel model) throws Exception {

        setElementViewActionDelegate(new EssenciaDefaultElementViewActionDelegate());

        super.setModel(model);
    }
}
