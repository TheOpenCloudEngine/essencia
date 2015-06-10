package org.uengine.essencia.enactment.face;

import org.metaworks.*;
import org.metaworks.Face;
import org.metaworks.annotation.*;
import org.metaworks.component.CheckBox;
import org.uengine.contexts.TextContext;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.enactment.AlphaInstance;
import org.uengine.essencia.enactment.LanguageElementInstance;
import org.uengine.essencia.model.*;
import org.uengine.essencia.model.card.BasicCard;
import org.uengine.essencia.model.card.Card;
import org.uengine.essencia.model.view.StateView;
import org.uengine.essencia.modeling.canvas.CardCanvas;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.kernel.bpmn.SequenceFlow;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.IElement;
import org.uengine.modeling.RelationView;
import org.uengine.modeling.Symbol;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by uengine on 2015-06-08.
 */
public class AlphaInstanceFace implements Card, Face<AlphaInstance> {

    protected List<CheckBox> list;
    protected List<String> states;
    protected TextContext name;
    protected String parentName;
    protected String img;
    protected AlphaInstance alphaInstance;

    public List<String> getStates() {
        return states;
    }

    public void setStates(List<String> states) {
        this.states = states;
    }


    public AlphaInstance getAlphaInstance() {
        return alphaInstance;
    }

    public void setAlphaInstance(AlphaInstance alphaInstance) {
        this.alphaInstance = alphaInstance;
    }


    public List<CheckBox> getList() {
        return list;
    }

    public void setList(List<CheckBox> list) {
        this.list = list;
    }

    protected ElementView view = null;

    public ElementView getView() {
        return view;
    }

    public void setView(ElementView view) {
        this.view = view;
    }


    @Override
    public String getName() {
        return name.getText();
    }

    @Override
    public void setName(String name) {
        this.name.setText(name);
    }


    @Override
    public String getImg() {
        return img;
    }

    @Override
    public void setImg(String img) {
        this.img = img;
    }


    @Override
    public String getParentName() {
        return parentName;
    }

    @Override
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    protected TextContext description;

    public String getDescription() {
        return description.getText();
    }

    public void setDescription(String description) {
        this.description.setText(description);
    }


    public AlphaInstanceFace() {
        this.name = new TextContext();
        this.description = new TextContext();
        setList(new ArrayList<CheckBox>());
        setStates(new ArrayList<String>());
    }

    public AlphaInstanceFace(ElementView view) {
      this();
        setView(view);
        setImg(IMG_LOCATION + view.getShapeId() + IMG_EXTENSION);
        setParentName(view.getLabel().substring(0, view.getLabel().indexOf("(")));
        setName(view.getLabel().substring(view.getLabel().indexOf("(") + 1, view.getLabel().length()-1 ) );

        for(int i=0; i < ((Alpha)view.getElement()).getList().size(); i++){
            State state = ((Alpha)view.getElement()).getList().get(i);
            getStates().add(state.getName());
            if(state.getName().equals(getName())){
                for (CheckPoint checkPoint : state.getList()){
                    CheckBox c = new CheckBox();
                    ContextUtil.setWhen(c, EssenciaContext.WHEN_EDIT);
                    c.add(checkPoint.getName(), checkPoint.getName());
                    getList().add(c);
                }
            }
        }
        alphaInstance = ((Alpha)view.getElement()).createInstance(getParentName()+"@"+getName());
        alphaInstance.setCurrentStateName(getName());

    }

    @Override
    public void setValueToFace(AlphaInstance value) {

    }

    @Override
    public AlphaInstance createValueFromFace() {
        return null;

    }

    @Order(1)
    @org.metaworks.annotation.Face(displayName = "Apply")
    @ServiceMethod(callByContent = true, target = ServiceMethodContext.TARGET_APPEND)
    public Object[] apply() {

        for(CheckBox c : getList()){
            if(!"".equals(c.getSelected())){
                alphaInstance.setChecked(c.getOptionValues().get(0));
            }
        }
        return new Object[]{new ToEvent(ServiceMethodContext.TARGET_SELF, EventContext.EVENT_CLOSE), new Refresh(alphaInstance, true)};
    }

    @Order(2)
    @org.metaworks.annotation.Face(displayName = "Cancel")
    @ServiceMethod(callByContent = true, target = ServiceMethodContext.TARGET_APPEND)
    public ToEvent cancel() {
        return new ToEvent(ServiceMethodContext.TARGET_SELF, EventContext.EVENT_CLOSE);
    }
}
