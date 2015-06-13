package org.uengine.essencia.model.face.selectbox;

import org.uengine.essencia.component.EssenciaSelectBox;
import org.uengine.essencia.model.*;
import org.uengine.modeling.IElement;

public class ActivityCompletionCriterionSelectBoxFace extends CriterionSelectBoxFace {

    public ActivityCompletionCriterionSelectBoxFace() {
    }

    @Override
    public void selectBoxChanged() {
        setSubSelectBox(new EssenciaSelectBox());
//        for (IElement e : essenciaCanvas.takeElementList()) {
//            if (e instanceof ActivitySpace) {
//                //
//                for (LanguageElement temp : ((ActivitySpace) e).getCompletionCriteria()) {
//                    Criterion c = (Criterion) temp;
//                    if (getMainSelectBox().getSelectedText().equals(c.getState().getParentAlpha().getName())) {
//                        getSubSelectBox().add(c.getState().getName(), c.getState().getName());
//                    }
//                }
//            }
//        }
        for (IElement e : essenciaCanvas.takeElementList()) {
            if (e instanceof Alpha && getMainSelectBox().getSelectedText().equals(((Alpha) e).getName())) {
                for (State state : ((Alpha) e).getList()) {
                    getSubSelectBox().add(state.getName(), state.getName());
                }
            }
        }
    }

}
