package org.uengine.essencia.model.face.selectbox;

import org.uengine.essencia.component.EssenciaSelectBox;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.model.LevelOfDetail;
import org.uengine.essencia.model.WorkProduct;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.modeling.IElement;

public class WorkProductSelectBoxFace extends CriterionSelectBoxFace {

    public WorkProductSelectBoxFace() {
    }

    @Override
    public void selectBoxChanged() {
	setSubSelectBox(new EssenciaSelectBox());
	for (IElement e : essenciaCanvas.takeElementList()) {
	    if (e instanceof WorkProduct && getMainSelectBox().getSelectedText().equals(((WorkProduct) e).getName())) {
		for (LevelOfDetail l : ((WorkProduct) e).getList()) {
		    getSubSelectBox().add(l.getName(), l.getName());
		}
	    }
	}
	ContextUtil.setWhen(this, EssenciaContext.WHEN_EDIT);
    }

}
