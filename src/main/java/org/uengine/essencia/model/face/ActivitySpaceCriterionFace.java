package org.uengine.essencia.model.face;

import java.util.ArrayList;
import java.util.List;

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
    @Override
    public void add() {
	CriterionSelectBoxFace box = new CriterionSelectBoxFace();
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
	    Criterion criterion = new CompletionCriterion();
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
	    Criterion criterion = (Criterion) list.get(i);
	    getAbstractSelectBoxFaceList().get(i).getMainSelectBox().setSelected(criterion.getState().getParentAlpha().getName());
	    ((CriterionSelectBoxFace) getAbstractSelectBoxFaceList().get(i)).setSubSelectBox(new SelectBox());
	    for (IElement e : getElementListFromCanvas()) {
		if (criterion.getState().getParentAlpha().getName().equals(((Alpha) e).getName()) && e instanceof Alpha) {
		    for (State s  : ((Alpha) e).getList()) {
			((CriterionSelectBoxFace) getAbstractSelectBoxFaceList().get(i)).getSubSelectBox().add(s.getName(), s.getName());
		    }
		}
	    }
	    ((CriterionSelectBoxFace) getAbstractSelectBoxFaceList().get(i)).getSubSelectBox().setSelected(criterion.getState().getName());
	}
    }
}
