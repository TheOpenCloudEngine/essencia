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

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by uengine on 2015-06-08.
 */
public class AlphaInstanceFace implements Card, Face<AlphaInstance> {

    String IMG_LOCATION = "resources" + File.separator + "images"+ File.separator + "symbol" + File.separator + "OG.shape.essencia.Alpha.png";

    protected List<CheckBox> list;
    protected List<String> states;
    protected TextContext name;
    protected String parentName;
    protected String img;
    private AlphaInstance alphaInstance;

    public List<String> getStates() {
        return states;
    }

    public void setStates(List<String> states) {
        this.states = states;
    }

    public List<CheckBox> getList() {
        return list;
    }

    public void setList(List<CheckBox> list) {
        this.list = list;
    }

    private Alpha alpha;

    public Alpha getAlpha() {
        return alpha;
    }

    public void setAlpha(Alpha alpha) {
        this.alpha = alpha;
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

    private void doDefaultSetting() {
        setImg(IMG_LOCATION);
//        setParentName(getAlpha().getName().substring(0, getAlpha().getName().indexOf("(")));
//        setName(getAlpha().getName().substring(getAlpha().getName().indexOf("(") + 1, getAlpha().getName().length() - 1));
        setParentName(this.alphaInstance.getAlpha().getName());
        setName(this.alphaInstance.getCurrentStateName());

        for (int i = 0; i < getAlpha().getStates().size(); i++) {
            State state = getAlpha().getStates().get(i);
            getStates().add(state.getName());
            if (state.getName().equals(getName())) {
                for (CheckPoint checkPoint : state.getCheckPoints()) {
                    CheckBox c = new CheckBox();
                    ContextUtil.setWhen(c, EssenciaContext.WHEN_EDIT);
                    c.add(checkPoint.getName(), checkPoint.getName());
                    if(this.alphaInstance.isChecked(checkPoint.getName())){
                        c.setSelected(checkPoint.getName());
                    }
                    getList().add(c);
                }
            }
        }
    }

    private void initAlphaInstance() {
        this.alphaInstance = getAlpha().createInstance(getParentName() + "@" + getName());
        this.alphaInstance.setCurrentStateName(getName());

    }

    @Override
    public void setValueToFace(AlphaInstance value) {
        this.alphaInstance = value;

        setAlpha(value.getAlpha());

        doDefaultSetting();

    }

    @Override
    public AlphaInstance createValueFromFace() {
        initAlphaInstance();
        applyCheckPointToInstance();
        return this.alphaInstance;

    }

    @Order(1)
    @org.metaworks.annotation.Face(displayName = "Apply")
    @ServiceMethod(callByContent = true, target = ServiceMethodContext.TARGET_APPEND)
    public Object[] apply() {
        applyCheckPointToInstance();
        return new Object[]{new ToEvent(ServiceMethodContext.TARGET_SELF, EventContext.EVENT_CLOSE), new Refresh(this.alphaInstance, true)};
    }

    @Order(2)
    @org.metaworks.annotation.Face(displayName = "Cancel")
    @ServiceMethod(callByContent = true, target = ServiceMethodContext.TARGET_APPEND)
    public ToEvent cancel() {
        return new ToEvent(ServiceMethodContext.TARGET_SELF, EventContext.EVENT_CLOSE);
    }

    private void applyCheckPointToInstance() {
        for (CheckBox c : getList()) {
            if (!"".equals(c.getSelected())) {
                this.alphaInstance.setChecked(c.getOptionValues().get(0));
            }
        }
    }
}
