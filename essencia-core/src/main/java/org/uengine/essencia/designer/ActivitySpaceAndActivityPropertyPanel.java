package org.uengine.essencia.designer;

import java.util.List;

import org.metaworks.*;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.dwr.MetaworksRemoteService;
import org.uengine.contexts.TextContext;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.model.AbstractActivity;
import org.uengine.essencia.model.ActivitySpace;
import org.uengine.essencia.model.LanguageElement;
import org.uengine.essencia.model.face.selectbox.AbstractSelectBoxFace;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.IElement;


@Face(displayName = "Properties", ejsPath = "dwr/metaworks/genericfaces/CleanObjectFace.ejs")
public class ActivitySpaceAndActivityPropertyPanel extends EssenciaPropertyPanel {

    private List<LanguageElement> elementList;

    @Hidden
    public List<LanguageElement> getElementList() {
        return elementList;
    }

    public void setElementList(List<LanguageElement> elementList) {
        this.elementList = elementList;
    }

    public ActivitySpaceAndActivityPropertyPanel() {

    }

    public ActivitySpaceAndActivityPropertyPanel(ElementView elementView, List<IElement> elementList) {
        super(elementView);
        ((AbstractActivity) getElement()).setUpElement(elementList);

        if (getElement().getOwner() != null && EssenciaContext.ESSENCE_KERNEL.equals(getElement().getOwner().getName()) && getElement() instanceof ActivitySpace) {
            ContextUtil.setWhen(this, EssenciaContext.WHEN_VIEW);
            ContextUtil.setWhen(((ActivitySpace) getElement()).getInputFace(), EssenciaContext.WHEN_VIEW);
            for (AbstractSelectBoxFace a : ((ActivitySpace) getElement()).getInputFace().getAbstractSelectBoxFaceList()) {
                ContextUtil.setWhen(a, EssenciaContext.WHEN_VIEW);
            }
            ContextUtil.setWhen(((ActivitySpace) getElement()).getCompletionCriterionFace(), EssenciaContext.WHEN_VIEW);
            for (AbstractSelectBoxFace a : ((ActivitySpace) getElement()).getCompletionCriterionFace().getAbstractSelectBoxFaceList()) {
                ContextUtil.setWhen(a, EssenciaContext.WHEN_VIEW);
            }
        } else {
            ContextUtil.setWhen(this, EssenciaContext.WHEN_EDIT);
        }
    }

    @Face(displayName = "Apply")
    @ServiceMethod(callByContent = true, target = ServiceMethodContext.TARGET_APPEND, keyBinding = "Enter")
    public Object[] apply() {
        ((AbstractActivity) getElement()).beforeApply();

        getElementView().setElement(getElement());

        //getElementView().setChanged(true);
        return new Object[]{new ToEvent(ServiceMethodContext.TARGET_SELF, EventContext.EVENT_CLOSE), new Refresh(getElementView(), true)};
    }

}
