package org.uengine.essencia.model.face.selectbox;

import org.uengine.essencia.component.EssenciaSelectBox;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.model.Competency;
import org.uengine.essencia.model.CompetencyLevel;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.modeling.IElement;

public class CompetencySelectBoxFace extends CriterionSelectBoxFace {

    public CompetencySelectBoxFace() {
    }

    @Override
    public void selectBoxChanged() {
		setSubSelectBox(new EssenciaSelectBox());
		for (IElement e : essenciaCanvas.takeElementList()) {
			if (e instanceof Competency && getMainSelectBox().getSelectedText().equals(((Competency) e).getName())) {
			for (CompetencyLevel l : ((Competency)e).getCompetencyLevels()) {
				getSubSelectBox().add(l.getName(), l.getName());
			}
			}
		}
		ContextUtil.setWhen(this, EssenciaContext.WHEN_EDIT);
    }

}
