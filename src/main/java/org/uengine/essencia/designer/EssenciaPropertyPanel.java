package org.uengine.essencia.designer;

import javax.validation.Valid;

import org.metaworks.ContextAware;
import org.metaworks.EventContext;
import org.metaworks.MetaworksContext;
import org.metaworks.Refresh;
import org.metaworks.ServiceMethodContext;
import org.metaworks.ToEvent;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.Order;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.ModalWindow;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.model.AbstractActivity;
import org.uengine.essencia.model.BasicElement;
import org.uengine.essencia.model.CardViewable;
import org.uengine.essencia.model.ContextTransformer;
import org.uengine.essencia.model.FaceTransformer;
import org.uengine.essencia.model.LanguageElement;
import org.uengine.essencia.model.card.Card;
import org.uengine.modeling.ElementView;

@Face(displayName = "Properties", ejsPath = "dwr/metaworks/genericfaces/CleanObjectFace.ejs")
public class EssenciaPropertyPanel implements ContextAware {

    protected BasicElement element;
    protected ElementView elementView;
    protected MetaworksContext metaworksContext;

    @Valid
    public BasicElement getElement() {
        return element;
    }

    public void setElement(BasicElement element) {
        this.element = element;
    }

    @Hidden
    public ElementView getElementView() {
        return elementView;
    }

    public void setElementView(ElementView elementView) {
        this.elementView = elementView;
    }

    @Override
    public MetaworksContext getMetaworksContext() {
        return metaworksContext;
    }

    @Override
    public void setMetaworksContext(MetaworksContext contect) {
        this.metaworksContext = contect;
    }

    public EssenciaPropertyPanel() {

    }

    public EssenciaPropertyPanel(ElementView elementView) {
        setElementView(elementView);
        setElement((BasicElement) elementView.getElement());

        if (getElement() instanceof FaceTransformer) {
            ((FaceTransformer) getElement()).setUpElement();// TODO
        }

        if (getElement() instanceof ContextTransformer) {
            ((ContextTransformer) getElement()).transformContext();
        }

    }

    @Hidden(when = EssenciaContext.WHEN_VIEW)
    @Order(1)
    @Face(displayName = "Apply")
    @ServiceMethod(callByContent = true, target = ServiceMethodContext.TARGET_APPEND)
    public Object[] apply() {
        if (getElement() instanceof FaceTransformer) {
            ((FaceTransformer) getElement()).beforeApply();// TODO
        }
        getElementView().setElement(getElement());

        return new Object[]{new ToEvent(ServiceMethodContext.TARGET_SELF, EventContext.EVENT_CLOSE), new Refresh(getElementView(), true)};
    }

    @Hidden(when = EssenciaContext.WHEN_VIEW)
    @Order(2)
    @Face(displayName = "Cancel")
    @ServiceMethod(callByContent = true, target = ServiceMethodContext.TARGET_APPEND)
    public ToEvent cancel() {
        getElementView().setElement(getElement());

        return new ToEvent(ServiceMethodContext.TARGET_SELF, EventContext.EVENT_CLOSE);
    }

    @Order(2)
    @Face(displayName = "Card Preview")
    @ServiceMethod(callByContent = true, target = ServiceMethodContext.TARGET_POPUP_OVER_POPUP)
    public ModalWindow showCardView() {

        if (getElement() instanceof CardViewable) {
            getElementView().setElement(null);
            getElement().setElementView(getElementView());
            Card card = ((CardViewable) getElement()).createCardView();
            return new ModalWindow(card, 650, 600, "Card View");
        }

        return new ModalWindow();
    }

}
