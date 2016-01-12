package org.uengine.essencia.model;

import java.util.List;

import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.*;
import org.metaworks.widget.ModalWindow;
import org.uengine.essencia.enactment.AlphaInstance;
import org.uengine.essencia.model.card.DetailCard;
import org.uengine.essencia.model.card.StateCard;
import org.uengine.essencia.model.face.list.CheckPointListFace;
import org.uengine.essencia.model.view.StateView;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.IElement;

public class State extends LanguageElement implements IElement, FaceTransformer {

//    private String name;
//
//    @Name
//    @Order(1)
//    @Id
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

//    private String description;

    private ElementView elementView;
    private Alpha parentAlpha;

    private List<CheckPoint> checkPoints;
    private transient CheckPointListFace listFace;


    private String aggregationAlphaState;

    public String getAggregationAlphaState() {
        return aggregationAlphaState;
    }

    public void setAggregationAlphaState(String aggregationAlphaState) {
        this.aggregationAlphaState = aggregationAlphaState;
    }

    @Hidden
    public List<CheckPoint> getCheckPoints() {
        return checkPoints;
    }

    public void setCheckPoints(List<CheckPoint> checkPoints) {
        this.checkPoints = checkPoints;
    }

    @Face(displayName = "CheckPoint")
    public CheckPointListFace getListFace() {
        return listFace;
    }

    public void setListFace(CheckPointListFace listFace) {
        this.listFace = listFace;
    }


//    @Order(2)
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }

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

    public Essence.Foundation.LanguageElement toXmi() {
        Essence.AlphaAndWorkProduct.State state = Essence.AlphaAndWorkProduct.AlphaAndWorkProductFactory.eINSTANCE.createState();
        state.setName(getName());
        state.setDescription(getDescription());
        for (CheckPoint c : getCheckPoints()) {
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
        if (getCheckPoints() != null) {
            getListFace().fillElements(getCheckPoints());
            getCheckPoints().clear();
        }
    }

    @Override
    public void beforeApply() {
        setCheckPoints(getListFace().createValue());
    }

    @Override
    public ElementView createView() {
        return new StateView(this);
    }

    public CheckPoint findCheckpoint(String checkpointName) {
        for (CheckPoint checkPoint : getCheckPoints()) {
            if (checkpointName.equals(checkPoint.getName())) {
                return checkPoint;
            }
        }

        throw new IllegalArgumentException("No such checkPoint named '" + checkpointName + "' in this state '" + getName() + "'");
    }

    public boolean isAllChecked(AlphaInstance alphaInstance) {
        for (CheckPoint checkPoint : getCheckPoints()) {
            if (!alphaInstance.isChecked(checkPoint.getName())) {
                return false;
            }
        }

        return true;
    }


    @ServiceMethod(callByContent = true, when = "openDashboard", target = ServiceMethodContext.TARGET_POPUP)
    public ModalWindow showDetailState(){
        ModalWindow modal = new ModalWindow(this, 600, 500);

        modal.setTitle("State Detail View!");

        return modal;
    }
}