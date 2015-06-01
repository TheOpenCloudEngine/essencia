package org.uengine.essencia.model;

import java.util.List;

import org.metaworks.annotation.Hidden;
import org.uengine.essencia.model.face.InputAlphaFace;
import org.uengine.essencia.model.face.list.ActionListFace;
import org.uengine.essencia.resource.ActionKind;

public class Action extends LanguageElement {

    private transient ActionListFace actionListFace;
    private InputAlphaFace inputAlpha;
    private List<WorkProduct> worksProducts;
    private ActionKind actionKind;

    @Hidden
    public ActionListFace getActionListFace() {
	return actionListFace;
    }

    public void setActionListFace(ActionListFace actionListFace) {
	this.actionListFace = actionListFace;
    }

    public ActionKind getActionKind() {
	return actionKind;
    }

    public void setActionKind(ActionKind actionKind) {
	this.actionKind = actionKind;
    }

    public InputAlphaFace getInputAlpha() {
	return inputAlpha;
    }

    public void setInputAlpha(InputAlphaFace inputAlpha) {
	this.inputAlpha = inputAlpha;
    }

    public List<WorkProduct> getWorksProducts() {
	return worksProducts;
    }

    public void setWorksProducts(List<WorkProduct> worksProducts) {
	this.worksProducts = worksProducts;
    }

    public Action() {
	setInputAlpha(new InputAlphaFace());
    }

}
