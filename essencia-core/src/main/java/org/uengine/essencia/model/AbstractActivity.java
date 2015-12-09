package org.uengine.essencia.model;

import java.util.List;

import org.metaworks.annotation.Face;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.Order;
import org.metaworks.component.SelectBox;
import org.uengine.essencia.component.EssenciaConcernSelectBox;
import org.uengine.essencia.model.face.CriterionFace;
import org.uengine.modeling.IElement;

public abstract class AbstractActivity extends BasicElement implements ContextTransformer, CardViewable, XMIElement, Concernable  {

    private String concern;
    private transient SelectBox concernSelectBox;

    @Hidden
    @Override
    public String getConcern() {
        return concern;
    }

    @Override
    public void setConcern(String concern) {
        this.concern = concern;
    }

    @Face(displayName = "Concern")
    @Order(4)
    @Override
    public SelectBox getConcernBox() {
        return concernSelectBox;
    }

    @Override
    public void setConcernBox(SelectBox concern) {
        this.concernSelectBox = concern;
    }


    private transient CriterionFace completionCriterionFace;

    protected transient List<IElement> elementListFromCanvas;

    private List<CompletionCriterion> completionCriteria;
        @Hidden
        public List<CompletionCriterion> getCompletionCriteria() {
            return completionCriteria;
        }
        public void setCompletionCriteria(List<CompletionCriterion> completionCriteria) {
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

    public void setUpElement(List<IElement> elementList){
        setConcernBox(new EssenciaConcernSelectBox());
        getConcernBox().setSelected(getConcern());
        setConcern("");

    }

    @Override
    public void beforeApply() {
        super.beforeApply();

        if(getConcernBox()!=null)
            setConcern(getConcernBox().getSelected());

        setConcernBox(null);

    }
}
