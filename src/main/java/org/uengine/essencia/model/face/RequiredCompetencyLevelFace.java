package org.uengine.essencia.model.face;

import java.util.ArrayList;
import java.util.List;

import org.uengine.essencia.component.EssenciaSelectBox;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.model.Competency;
import org.uengine.essencia.model.CompetencyLevel;
import org.uengine.essencia.model.Criterion;
import org.uengine.essencia.model.LanguageElement;
import org.uengine.essencia.model.WorkProduct;
import org.uengine.essencia.model.face.selectbox.AbstractSelectBoxFace;
import org.uengine.essencia.model.face.selectbox.CompetencySelectBoxFace;
import org.uengine.essencia.model.face.selectbox.CriterionSelectBoxFace;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.essencia.util.ElementUtil;
import org.uengine.modeling.IElement;

public class RequiredCompetencyLevelFace extends CriterionFace {

    @Override
    public void add() {
	CompetencySelectBoxFace box = new CompetencySelectBoxFace();
	for (IElement e : getElementListFromCanvas()) {
	    if (e instanceof Competency && !"".equals(((Competency) e).getName())) {
		box.getMainSelectBox().add(((Competency) e).getName(), ((Competency) e).getName());
	    }
	}
	ContextUtil.setWhen(box, EssenciaContext.WHEN_EDIT);
	setAbstractSelectBoxFaceList(ElementUtil.syncList(getAbstractSelectBoxFaceList()));
	getAbstractSelectBoxFaceList().add(box);
    }

    @Override
    public List<LanguageElement> createValue() {
	List<LanguageElement> returnList = new ArrayList<LanguageElement>();
	for (AbstractSelectBoxFace box : getAbstractSelectBoxFaceList()) {
	    CompetencyLevel competencyLevel = new CompetencyLevel();
	    competencyLevel.setName(((CriterionSelectBoxFace) box).getSubSelectBox().getSelected());
	    competencyLevel.setParentElementId(box.getMainSelectBox().getSelected());
	    returnList.add(competencyLevel);
	}
	getAbstractSelectBoxFaceList().clear();
	return returnList;
    }

    @Override
    public void fillElements(List<LanguageElement> list) {
	for (int i = 0; i < list.size(); i++) {
	    add();
	    getAbstractSelectBoxFaceList().get(i).getMainSelectBox().setSelected(list.get(i).getParentElementId());
	    ((CriterionSelectBoxFace) getAbstractSelectBoxFaceList().get(i)).setSubSelectBox(new EssenciaSelectBox());
	    for (IElement e : getElementListFromCanvas()) {
		if (e instanceof Competency && list.get(i).getParentElementId().equals(((Competency) e).getName())) {
		    for (CompetencyLevel l : ((Competency) e).getList()) {
			((CriterionSelectBoxFace) getAbstractSelectBoxFaceList().get(i)).getSubSelectBox().add(l.getName(), l.getName());
		    }
		}
	    }
	    ((CriterionSelectBoxFace) getAbstractSelectBoxFaceList().get(i)).getSubSelectBox().setSelected(
		    ((CompetencyLevel) list.get(i)).getName());
	}

    }
}
