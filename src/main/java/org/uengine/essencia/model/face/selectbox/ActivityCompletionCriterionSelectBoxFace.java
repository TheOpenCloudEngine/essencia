package org.uengine.essencia.model.face.selectbox;

import org.uengine.essencia.component.EssenciaSelectBox;
import org.uengine.essencia.model.ActivitySpace;
import org.uengine.essencia.model.Criterion;
import org.uengine.essencia.model.LanguageElement;
import org.uengine.modeling.IElement;

public class ActivityCompletionCriterionSelectBoxFace extends CriterionSelectBoxFace {

    public ActivityCompletionCriterionSelectBoxFace() {
    }

    @Override
    public void selectBoxChanged() {
	setSubSelectBox(new EssenciaSelectBox());
	for (IElement e : essenciaCanvas.takeElementList()) {
	    if (e instanceof ActivitySpace) {
		for (LanguageElement temp : ((ActivitySpace) e).getCompletionCriteria()) {
		    Criterion c = (Criterion) temp;
		    if (getMainSelectBox().getSelectedText().equals(c.getState().getParentAlpha().getName())) {
			getSubSelectBox().add(c.getState().getName(), c.getState().getName());
		    }
		}
	    }
	}
    }

}
