package org.uengine.essencia.model.face;

import java.util.ArrayList;
import java.util.List;

import org.uengine.essencia.component.EssenciaSelectBox;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.model.ActivitySpace;
import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.Criterion;
import org.uengine.essencia.model.EntryCriterion;
import org.uengine.essencia.model.LanguageElement;
import org.uengine.essencia.model.State;
import org.uengine.essencia.model.face.selectbox.AbstractSelectBoxFace;
import org.uengine.essencia.model.face.selectbox.CriterionSelectBoxFace;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.modeling.IElement;

public class ActivityEntryCriterionFace extends CriterionFace {

    public ActivityEntryCriterionFace() {
        setAbstractSelectBoxFaceList(new ArrayList<AbstractSelectBoxFace>());
    }

    @Override
    public void add() {
        // activity entry
        CriterionSelectBoxFace box = new CriterionSelectBoxFace();
//        for (IElement e : getElementListFromCanvas()) {
//            if (e instanceof ActivitySpace) {
//                box.getMainSelectBox().addActivitySpaceForEntry((ActivitySpace) e);
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
    public List<LanguageElement> createValue() {
        List<LanguageElement> returnList = new ArrayList<LanguageElement>();
        for (AbstractSelectBoxFace box : getAbstractSelectBoxFaceList()) {
            Criterion criterion = new EntryCriterion();
            criterion.setUpState(((CriterionSelectBoxFace) box).getSubSelectBox().getSelectedText(), box.getMainSelectBox().getSelectedText());
            returnList.add(criterion);
        }
        getAbstractSelectBoxFaceList().clear();
        return returnList;
    }

    @Override
    public void fillElements(List<LanguageElement> list) {
        for (int i = 0; i < list.size(); i++) {
            add();
            getAbstractSelectBoxFaceList().get(i).getMainSelectBox().setSelected(((Criterion) list.get(i)).getState().getParentAlpha().getName());
            ((CriterionSelectBoxFace) getAbstractSelectBoxFaceList().get(i)).setSubSelectBox(new EssenciaSelectBox());
            for (IElement e : getElementListFromCanvas()) {
                if (e instanceof Alpha && ((Criterion) list.get(i)).getState().getParentAlpha().getName().equals(((Alpha) e).getName())) {

                    for (State s : ((Alpha) e).getList()) {
                        ((CriterionSelectBoxFace) getAbstractSelectBoxFaceList().get(i)).getSubSelectBox().add(s.getName(), s.getName());
                    }
                }
            }
            ((CriterionSelectBoxFace) getAbstractSelectBoxFaceList().get(i)).getSubSelectBox().setSelected(((Criterion) list.get(i)).getState().getName());
        }
    }
}
