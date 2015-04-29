package org.uengine.essencia.model.face;

import java.util.ArrayList;
import java.util.List;

import org.uengine.essencia.component.EssenciaSelectBox;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.model.ActivitySpace;
import org.uengine.essencia.model.CompletionCriterion;
import org.uengine.essencia.model.Criterion;
import org.uengine.essencia.model.LanguageElement;
import org.uengine.essencia.model.face.selectbox.AbstractSelectBoxFace;
import org.uengine.essencia.model.face.selectbox.ActivityCompletionCriterionSelectBoxFace;
import org.uengine.essencia.model.face.selectbox.CriterionSelectBoxFace;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.modeling.IElement;

public class ActivityCompletionCriterionFace extends CriterionFace {
    @Override
    public void add() {
	CriterionSelectBoxFace box = new ActivityCompletionCriterionSelectBoxFace();
	for (IElement e : getElementListFromCanvas()) {
	    if (e instanceof ActivitySpace && !"".equals(((ActivitySpace) e).getName())) {
		for (LanguageElement temp : ((ActivitySpace) e).getCompletionCriteria()) {
		    Criterion c = (Criterion)temp;
		    box.getMainSelectBox().add(c.getState().getParentAlpha().getName(), c.getState().getParentAlpha().getName());
		}
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
