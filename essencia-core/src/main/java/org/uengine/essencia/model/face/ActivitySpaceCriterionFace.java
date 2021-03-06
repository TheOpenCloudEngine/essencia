package org.uengine.essencia.model.face;

import java.util.ArrayList;
import java.util.List;

import org.metaworks.MetaworksContext;
import org.metaworks.annotation.Hidden;
import org.metaworks.component.SelectBox;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.CompletionCriterion;
import org.uengine.essencia.model.Criterion;
import org.uengine.essencia.model.LanguageElement;
import org.uengine.essencia.model.State;
import org.uengine.essencia.model.face.selectbox.AbstractSelectBoxFace;
import org.uengine.essencia.model.face.selectbox.CriterionSelectBoxFace;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.modeling.IElement;

public class ActivitySpaceCriterionFace extends CriterionFace {

    @Hidden(when = MetaworksContext.WHEN_VIEW)
    @Override
    public void add() {
        CriterionSelectBoxFace box = new CriterionSelectBoxFace();
        for (IElement e : getElementListFromCanvas()) {
            if (e instanceof Alpha && e.getName() != null && !"".equals(e.getName())) {
                box.getMainSelectBox().add(e.getName(), e.getName());
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
            criterion.setUpState(((CriterionSelectBoxFace) box).getSubSelectBox().getSelected(), box.getMainSelectBox().getSelected());
            returnList.add(criterion);
        }
        getAbstractSelectBoxFaceList().clear();
        return returnList;
    }

    @Override
    public void fillElements(List<? extends LanguageElement> list) {
        for (int i = 0; i < list.size(); i++) {
            add();
            Criterion criterion = (Criterion) list.get(i);
            getAbstractSelectBoxFaceList().get(i).getMainSelectBox().setSelected(criterion.getState().getParentAlpha().getName());
            ((CriterionSelectBoxFace) getAbstractSelectBoxFaceList().get(i)).setSubSelectBox(new SelectBox());
            for (IElement e : getElementListFromCanvas()) {
                if (criterion.getState().getParentAlpha().getName().equals(((Alpha) e).getName()) && e instanceof Alpha) {
                    for (State s : ((Alpha) e).getStates()) {
                        ((CriterionSelectBoxFace) getAbstractSelectBoxFaceList().get(i)).getSubSelectBox().add(s.getName(), s.getName());
                    }
                }
            }
            ((CriterionSelectBoxFace) getAbstractSelectBoxFaceList().get(i)).getSubSelectBox().setSelected(criterion.getState().getName());
        }
    }
}
