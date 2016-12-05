package org.uengine.essencia.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import Essence.AlphaAndWorkProduct.AlphaAndWorkProductFactory;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Group;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.Order;
import org.metaworks.component.SelectBox;
import org.uengine.essencia.enactment.AlphaInstance;
import org.uengine.essencia.component.EssenciaConcernSelectBox;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.model.card.AlphaCard;
import org.uengine.essencia.model.card.Card;
import org.uengine.essencia.model.face.list.ListFace;
import org.uengine.essencia.model.face.list.StateListFace;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.kernel.NeedArrangementToSerialize;
import org.uengine.kernel.ProcessInstance;
import org.uengine.uml.model.Attribute;
import org.uengine.uml.model.ObjectInstance;
import org.uengine.uml.model.face.AttributeListFace;
import org.uengine.util.UEngineUtil;

public class Alpha extends BasicElement implements Concernable, ContextTransformer, CardViewable, FaceTransformer, XMIResourceElement, NeedArrangementToSerialize {

    private String concern;
    private transient SelectBox concernSelectBox;

    private List<LanguageElement> childElements;

    private List<State> states;
    //private transient ListFace listFace;

    public Alpha() {
        setStates(new ArrayList<State>());
        setConcernBox(new EssenciaConcernSelectBox());
    }

    //@Hidden
    @Face(faceClass = StateListFace.class)
    @Group(name = "States")
    public List<State> getStates() {
        return states;
    }
    public void setStates(List<State> states) {
        this.states = states;
    }



//    @Face(displayName = "State")
//    public ListFace getListFace() {
//        return listFace;
//    }
//
//    public void setListFace(ListFace listFace) {
//        this.listFace = listFace;
//    }

    @Hidden
    public List<LanguageElement> getChildElements() {
        if (childElements == null) {
            setChildElements(new ArrayList<LanguageElement>());
        }
        return childElements;
    }

    public void setChildElements(List<LanguageElement> childElements) {
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

//    @Override
//    public String getDescription() {
//        return description.getText();
//    }

    public String getName() {
        return name.getText();
    }

    public Alpha(String name) {
        this();
        setName(name);
    }

    @Override
    public void transformContext() {
//        if (getOwner() != null && EssenciaContext.ESSENCE_KERNEL.equals(getOwner().getName())) {
//            ContextUtil.setWhen(this, EssenciaContext.WHEN_VIEW);
//            ContextUtil.setWhen(getListFace(), EssenciaContext.WHEN_VIEW);
//        } else {
//            ContextUtil.setWhen(this, EssenciaContext.WHEN_EDIT);
//            ContextUtil.setWhen(getListFace(), EssenciaContext.WHEN_EDIT);
//        }
    }

    @Override
    public Essence.Foundation.BasicElement toXmi() {
        Essence.AlphaAndWorkProduct.Alpha alpha = AlphaAndWorkProductFactory.eINSTANCE.createAlpha();
        alpha.setName(getName());
        alpha.setDescription(getDescription());
        alpha.setBriefDescription(getBriefDescription());
        for (State s : getStates()) {
            alpha.getStates().add((Essence.AlphaAndWorkProduct.State) s.toXmi());
        }
        return alpha;
    }

//    protected ListFace createListFace(){
//        return new StateListFace();
//    }

    @Override
    public void setUpElement() {
        super.setUpElement();
        //setStates(new ArrayList<State>());
//        if (getStates() != null) {
//            getListFace().fillElements(getStates());
//            getStates().clear();
//        }

        setConcernBox(new EssenciaConcernSelectBox());
        getConcernBox().setSelected(getConcern());
        setConcern("");
    }

    @Override
    public void beforeApply() {
        super.beforeApply();
//        setStates(getListFace().createValue());

        setConcern(getConcernBox().getSelected());
        setConcernBox(null);
    }

//    public AlphaInstance createInstance(String id) {
//
//        try {
//            AlphaInstance alphaInstance = (AlphaInstance) createObjectInstance();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        return new AlphaInstance(this, id);
//    }

    @Override
    protected ObjectInstance newObjectInstance() {

        return new AlphaInstance();

    }

    @Override
    public AlphaInstance createObjectInstance() {
        return (AlphaInstance) super.createObjectInstance();
    }

    @Override
    public List<AlphaInstance> getInstances(ProcessInstance instance) {
        return (List<AlphaInstance>) super.getInstances(instance);
    }

    public State findState(String stateName) {

        if(stateName==null) return null; //throw new IllegalArgumentException("Finding state name is null");

        if(getStates()!=null)
        for(State state : getStates()){
            if(stateName.equals(state.getName())){
                return state;
            }
        }

        return null;

        //throw new IllegalArgumentException("No such state named " + stateName);
    }

    @Override
    @Hidden(on=false)
    public Attribute[] getFieldDescriptors() {
        return super.getFieldDescriptors();
    }


    @Override
    public void beforeSerialization() {

        //// if there is no attributes defined, add Id attribute by default.
        if(getFieldDescriptors()==null || getFieldDescriptors().length == 0){
            Attribute attribute = createIdAttribute();

            setFieldDescriptors(new Attribute[]{attribute});
        }else{
            for(Attribute attribute : getFieldDescriptors()){
                if(attribute.getName().equals("Id")) return;
            }

            //if there is no attribute named "Id", add Id attribute first order.
            Attribute[] attributes = getFieldDescriptors();
            attributes = (Attribute[]) UEngineUtil.addArrayElementAtFirst(attributes, createIdAttribute());

            setFieldDescriptors(attributes);
        }
    }

    @Override
    public void afterDeserialization() {

    }

    public Attribute createIdAttribute() {
        Attribute attribute = new Attribute();

        attribute.setName("Id");
        attribute.setClassName("java.lang.String");
        return attribute;
    }

    public int indexOfState(State state) {
        for(int i=0; i<getStates().size(); i++){
            if(getStates().get(i).equals(state)){
                return i;
            }
        }

        return -1;
    }

    public int indexOfState(String stateName) {
        State state = new State();
        state.setName(stateName);

        return indexOfState(state);
    }

    @Override
    public Set<String> reduceProperties() {
        Set set = super.reduceProperties();

        set.add("States");

        return set;
    }
}