package org.uengine.essencia.model;

import java.util.List;

import org.metaworks.annotation.Face;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.Order;
import org.metaworks.component.SelectBox;
import org.uengine.essencia.component.EssenciaConcernSelectBox;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.model.card.Card;
import org.uengine.essencia.model.card.CompetencyCard;
import org.uengine.essencia.model.face.list.CompetencyLevelListFace;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.kernel.designer.ui.RoleView;

public class Competency extends BasicElement implements Concernable, ContextTransformer, CardViewable, FaceTransformer, XMIResourceElement {

    private String concern;
    private transient SelectBox concernSelectBox;

    private List<CompetencyLevel> list;
    private transient CompetencyLevelListFace listFace;

    @Hidden
    public List<CompetencyLevel> getList() {
	return list;
    }

    public void setList(List<CompetencyLevel> list) {
	this.list = list;
    }

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

    @Order(5)
    @Face(displayName = "CompetencyLevel")
    public CompetencyLevelListFace getListFace() {
	return listFace;
    }

    public void setListFace(CompetencyLevelListFace listFace) {
	this.listFace = listFace;
    }

    public Competency() {
	setConcernBox(new EssenciaConcernSelectBox());

	setListFace(new CompetencyLevelListFace());
    }

    @Override
    public boolean equals(Object obj) {
	if (obj instanceof RoleView) {
	    RoleView view = (RoleView) obj;
	    return getName().equals(view.getLabel());
	}
	return false;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
    }

    @Override
    public Card createCardView() {
	Card card = new CompetencyCard(this);
	return card;
    }

    @Override
    public void transformContext() {
	ContextUtil.setWhen(this, EssenciaContext.WHEN_EDIT);
	// for (CompetencyLevel cl : getList()) {
	// ContextUtil.setHow(cl, EssenciaContext.HOW_IN_LIST);
	// }
    }

    @Override
    public Essence.Foundation.BasicElement toXmi() {
	Essence.Competency.Competency competency = Essence.Competency.CompetencyFactory.eINSTANCE.createCompetency();

	// set alpha
	competency.setName(getName());
	competency.setDescription(getDescription());
	for (CompetencyLevel cl : getList()) {
	    competency.getPossibleLevel().add(cl.toXmi());
	}

	return competency;
    }

    @Override
    public void setUpElement() {
	super.setUpElement();
	setListFace(new CompetencyLevelListFace());
	if (getList() != null) {
	    getListFace().fillElements(getList());
	    getList().clear();
	}

	setConcernBox(new EssenciaConcernSelectBox());
	getConcernBox().setSelected(getConcern());
	setConcern("");
    }

    @Override
    public void beforeApply() {
	super.beforeApply();
	setList(getListFace().createValue());

	setConcern(getConcernBox().getSelected());
	setConcernBox(null);
    }

}