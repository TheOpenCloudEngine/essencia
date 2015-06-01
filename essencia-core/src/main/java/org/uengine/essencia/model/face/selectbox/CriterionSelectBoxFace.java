package org.uengine.essencia.model.face.selectbox;

import org.metaworks.EventContext;
import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.component.SelectBox;
import org.uengine.essencia.component.EssenciaSelectBox;
import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.State;
import org.uengine.essencia.modeling.canvas.EssenciaCanvas;
import org.uengine.modeling.IElement;

public class CriterionSelectBoxFace extends AbstractSelectBoxFace {

    @AutowiredFromClient
    public EssenciaCanvas essenciaCanvas;

    private transient SelectBox subSelectBox;

    public SelectBox getSubSelectBox() {
        return subSelectBox;
    }

    public void setSubSelectBox(SelectBox subSelectBox) {
        this.subSelectBox = subSelectBox;
    }

    public CriterionSelectBoxFace() {
    }

    @Hidden
    @ServiceMethod(callByContent = true, eventBinding = EventContext.EVENT_CHANGE, bindingFor = "mainSelectBox", bindingHidden = true, target = ServiceMethodContext.TARGET_SELF)
    public void selectBoxChanged() {
        setSubSelectBox(new EssenciaSelectBox());
        for (IElement e : essenciaCanvas.takeElementList()) {
            if (e instanceof Alpha && getMainSelectBox().getSelectedText().equals(((Alpha) e).getName())) {
                for (State s : ((Alpha) e).getList()) {
                    getSubSelectBox().add(s.getName(), s.getName());
                }
            }
        }
    }
}
