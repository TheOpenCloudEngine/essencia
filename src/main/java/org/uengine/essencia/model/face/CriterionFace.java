package org.uengine.essencia.model.face;

import java.util.ArrayList;

import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.model.ActivitySpace;
import org.uengine.essencia.model.face.selectbox.AbstractSelectBoxFace;
import org.uengine.essencia.model.face.selectbox.CriterionSelectBoxFace;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.modeling.IElement;

public abstract class CriterionFace extends AbstractInputAndCriterionFace {

    public CriterionFace() {
	
	setAbstractSelectBoxFaceList(new ArrayList<AbstractSelectBoxFace>());
    }

    @Override
    public void add() {
	// activity entry
	CriterionSelectBoxFace box = new CriterionSelectBoxFace();
	for (IElement e : getElementListFromCanvas()) {
	    if (e instanceof ActivitySpace) {
		box.getMainSelectBox().addActivitySpaceForCompletion((ActivitySpace) e);
	    }
	}
	ContextUtil.setWhen(box, EssenciaContext.WHEN_EDIT);
	getAbstractSelectBoxFaceList().add(box);

    }

}
