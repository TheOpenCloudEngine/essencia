package org.uengine.essencia.model.face;

import java.util.ArrayList;
import java.util.List;

import org.uengine.essencia.component.EssenciaSelectBox;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.model.*;
import org.uengine.essencia.model.face.selectbox.AbstractSelectBoxFace;
import org.uengine.essencia.model.face.selectbox.ActivityCompletionCriterionSelectBoxFace;
import org.uengine.essencia.model.face.selectbox.CriterionSelectBoxFace;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.modeling.IElement;

import javax.annotation.processing.Completion;

public class ActivityCompletionCriterionFace extends CriterionFace {
    @Override
    public void add() {
        CriterionSelectBoxFace box = new ActivityCompletionCriterionSelectBoxFace();
//        for (IElement e : getElementListFromCanvas()) {
//            if (e instanceof ActivitySpace && !"".equals(((ActivitySpace) e).getName())) {
//                for (LanguageElement temp : ((ActivitySpace) e).getCompletionCriteria()) {
//                    Criterion c = (Criterion) temp;
//                    box.getMainSelectBox().add(c.getState().getParentAlpha().getName(), c.getState().getParentAlpha().getName());
//                }
//            }
//        }
        for (IElement e : getElementListFromCanvas()) {
            if (e instanceof Alpha && !"".equals(((Alpha) e).getName())) {
                box.getMainSelectBox().add(((Alpha) e).getName(), ((Alpha) e).getName());
            }
        }
        ContextUtil.setWhen(box, EssenciaContext.WHEN_EDIT);
        getAbstractSelectBoxFaceList().add(box);
    }

    @Override
    public List<CompletionCriterion> createValue() {
        List<CompletionCriterion> returnList = new ArrayList<CompletionCriterion>();
        for (AbstractSelectBoxFace box : getAbstractSelectBoxFaceList()) {
            CompletionCriterion criterion = new CompletionCriterion();
            criterion.setUpState(((CriterionSelectBoxFace) box).getSubSelectBox().getSelectedText(), box.getMainSelectBox().getSelectedText());
            returnList.add(criterion);
        }
        getAbstractSelectBoxFaceList().clear();
        return returnList;
    }

    @Override
    public void fillElements(List<? extends LanguageElement> list) {
        for (int i = 0; i < list.size(); i++) {
            add();
            getAbstractSelectBoxFaceList().get(i).getMainSelectBox().setSelected(((Criterion) list.get(i)).getState().getParentAlpha().getName());
            ((CriterionSelectBoxFace) getAbstractSelectBoxFaceList().get(i)).setSubSelectBox(new EssenciaSelectBox());

            for (LanguageElement e : list) {
                ((CriterionSelectBoxFace) getAbstractSelectBoxFaceList().get(i)).getSubSelectBox().add(((Criterion) e).getState().getName(),
                        ((Criterion) e).getState().getName());
            }
            ((CriterionSelectBoxFace) getAbstractSelectBoxFaceList().get(i)).getSubSelectBox().setSelected(
                    ((Criterion) list.get(i)).getState().getName());
        }

    }
}
