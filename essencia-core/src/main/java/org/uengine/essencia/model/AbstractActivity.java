package org.uengine.essencia.model;

import java.util.List;

import org.metaworks.annotation.Face;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.Order;
import org.uengine.essencia.model.face.CriterionFace;
import org.uengine.modeling.IElement;

public abstract class AbstractActivity extends BasicElement implements ContextTransformer, CardViewable, XMIElement {

    private List<LanguageElement> completionCriteria;
    private transient CriterionFace completionCriterionFace;

    protected transient List<IElement> elementListFromCanvas;

    @Hidden
    public List<LanguageElement> getCompletionCriteria() {
	return completionCriteria;
    }

    public void setCompletionCriteria(List<LanguageElement> completionCriteria) {
	this.completionCriteria = completionCriteria;
    }

    @Order(6)
    @Face(displayName = "CompletionCriterion")
    public CriterionFace getCompletionCriterionFace() {
	return completionCriterionFace;
    }

    public void setCompletionCriterionFace(CriterionFace completionCriterionFace) {
	this.completionCriterionFace = completionCriterionFace;
    }

    public abstract void setUpElement(List<IElement> elementList);

}
