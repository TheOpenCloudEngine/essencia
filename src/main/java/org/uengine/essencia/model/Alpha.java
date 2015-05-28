package org.uengine.essencia.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.metaworks.annotation.Face;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.Order;
import org.metaworks.component.SelectBox;
import org.metaworks.dwr.SerializationSensitive;
import org.uengine.essencia.enactment.AlphaInstance;
import org.uengine.essencia.component.EssenciaConcernSelectBox;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.enactment.LanguageElementInstance;
import org.uengine.essencia.model.card.AlphaCard;
import org.uengine.essencia.model.card.Card;
import org.uengine.essencia.model.face.PropertyListFace;
import org.uengine.essencia.model.face.list.StateListFace;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.kernel.ProcessInstance;
import org.uengine.kernel.ProcessVariableValue;

public class Alpha extends BasicElement implements Concernable, ContextTransformer, CardViewable, FaceTransformer, XMIResourceElement {

    private String concern;
    private transient SelectBox concernSelectBox;

    private List<Alpha> childElements;

    private List<State> list;
    private transient StateListFace listFace;

    public Alpha() {
        setConcernBox(new EssenciaConcernSelectBox());
    }

    @Hidden
    public List<State> getStates() {
        return getList();
    }

    @Hidden
    public List<State> getList() {
        return list;
    }

    public void setList(List<State> list) {
        this.list = list;
    }

    @Face(displayName = "State")
    public StateListFace getListFace() {
        return listFace;
    }

    public void setListFace(StateListFace listFace) {
        this.listFace = listFace;
    }

    @Hidden
    public List<Alpha> getChildElements() {
        if (childElements == null) {
            setChildElements(new ArrayList<Alpha>());
        }
        return childElements;
    }

    public void setChildElements(List<Alpha> childElements) {
        this.childElements = childElements;
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

    @Override
    public Card createCardView() {
        Card card = new AlphaCard(this);
        return card;
    }

    @Override
    public String getDescription() {
        return description.getText();
    }

    public String getName() {
        return name.getText();
    }

    public Alpha(String name) {
        this();
        setName(name);
    }

    @Override
    public void transformContext() {
        if (getOwner() != null && EssenciaContext.ESSENCE_KERNEL.equals(getOwner().getName())) {
            ContextUtil.setWhen(this, EssenciaContext.WHEN_VIEW);
            ContextUtil.setWhen(getListFace(), EssenciaContext.WHEN_VIEW);
        } else {
            ContextUtil.setWhen(this, EssenciaContext.WHEN_EDIT);
            ContextUtil.setWhen(getListFace(), EssenciaContext.WHEN_EDIT);
        }
    }

    @Override
    public Essence.Foundation.BasicElement toXmi() {
        Essence.AlphaAndWorkProduct.Alpha alpha = Essence.AlphaAndWorkProduct.AlphaAndWorkProductFactory.eINSTANCE.createAlpha();
        alpha.setName(getName());
        alpha.setDescription(getDescription());
        alpha.setBriefDescription(getBriefDescription());
        for (State s : getList()) {
            alpha.getStates().add(s.toXmi());
        }
        return alpha;
    }

    @Override
    public void setUpElement() {
        super.setUpElement();
        setListFace(new StateListFace());
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

    public AlphaInstance createInstance(String id) {

        return new AlphaInstance(this, id);
    }

    @Override
    public List<AlphaInstance> getInstances(ProcessInstance instance) {
        return (List<AlphaInstance>) super.getInstances(instance);
    }

    public State findState(String stateName) {

        if(stateName==null) throw new IllegalArgumentException("Finding state name is null");

        for(State state : getList()){
            if(stateName.equals(state.getName())){
                return state;
            }
        }

        throw new IllegalArgumentException("No such state named " + stateName);
    }

}