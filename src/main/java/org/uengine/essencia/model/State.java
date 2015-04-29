package org.uengine.essencia.model;

import java.util.List;

import org.metaworks.annotation.Face;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.Id;
import org.metaworks.annotation.Name;
import org.metaworks.annotation.Order;
import org.uengine.essencia.model.card.DetailCard;
import org.uengine.essencia.model.card.StateCard;
import org.uengine.essencia.model.face.list.CheckPointListFace;
import org.uengine.essencia.model.view.StateView;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.IElement;

public class State extends LanguageElement implements IElement, FaceTransformer {

    private String name;
    private String description;

    private ElementView elementView;
    private Alpha parentAlpha;

    private List<CheckPoint> list;
    private transient CheckPointListFace listFace;

    @Hidden
    public List<CheckPoint> getList() {
	return list;
    }

    public void setList(List<CheckPoint> list) {
	this.list = list;
    }

    @Face(displayName = "CheckPoint")
    public CheckPointListFace getListFace() {
	return listFace;
    }

    public void setListFace(CheckPointListFace listFace) {
	this.listFace = listFace;
    }

    @Name
    @Order(1)
    @Id
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Order(2)
    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    @Hidden
    public Alpha getParentAlpha() {
	return parentAlpha;
    }

    public void setParentAlpha(Alpha parentAlpha) {
	this.parentAlpha = parentAlpha;
    }

    public State() {
	setListFace(new CheckPointListFace());
    }

    public State(String name) {
	this();
	setName(name);
    }

    public DetailCard createDetailCardView(Alpha parentElement) {
	DetailCard card = new StateCard(this, parentElement);
	return card;
    }

    public Essence.AlphaAndWorkProduct.State toXmi() {
	Essence.AlphaAndWorkProduct.State state = Essence.AlphaAndWorkProduct.AlphaAndWorkProductFactory.eINSTANCE.createState();
	state.setName(getName());
	state.setDescription(getDescription());
	for (CheckPoint c : getList()) {
	    state.getCheckListItem().add(c.toXmi());
	}
	return state;
    }

    @Hidden
    @Override
    public ElementView getElementView() {
	return this.elementView;
    }

    @Override
    public void setElementView(ElementView elementView) {
	this.elementView = elementView;
    }

    @Override
    public void setUpElement() {
	setListFace(new CheckPointListFace());
	if (getList() != null) {
	    getListFace().fillElements(getList());
	    getList().clear();
	}
    }

    @Override
    public void beforeApply() {
	setList(getListFace().createValue());
    }

    @Override
    public ElementView createView() {
	return new StateView(this);
    }

}