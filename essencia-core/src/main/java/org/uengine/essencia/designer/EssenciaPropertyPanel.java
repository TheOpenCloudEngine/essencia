package org.uengine.essencia.designer;

import javax.validation.Valid;

import org.metaworks.ContextAware;
import org.metaworks.EventContext;
import org.metaworks.MetaworksContext;
import org.metaworks.Refresh;
import org.metaworks.ServiceMethodContext;
import org.metaworks.ToEvent;
import org.metaworks.annotation.*;
import org.metaworks.dwr.MetaworksRemoteService;
import org.metaworks.widget.ModalWindow;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.model.*;
import org.uengine.essencia.model.card.Card;
import org.uengine.essencia.modeling.canvas.MethodCanvas;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.IElement;

@Face(displayName = "Properties", ejsPath = "dwr/metaworks/genericfaces/CleanObjectFace.ejs")
public class EssenciaPropertyPanel implements ContextAware {

    protected IElement element;
    protected ElementView elementView;
    protected MetaworksContext metaworksContext;

    @Valid
    public IElement getElement() {
        return element;
    }

    public void setElement(IElement element) {
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
        setElement(elementView.getElement());

        if (getElement() instanceof FaceTransformer) {
            ((FaceTransformer) getElement()).setUpElement();
        }

        if (getElement() instanceof ContextTransformer) {
            ((ContextTransformer) getElement()).transformContext();
        }

//        if (getElement().getOwner() != null && EssenciaContext.ESSENCE_KERNEL.equals(getElement().getOwner().getName())) {
//            ContextUtil.setWhen(this, EssenciaContext.WHEN_VIEW);
//        } else {
        ContextUtil.setWhen(this, EssenciaContext.WHEN_EDIT);
//        }

    }

    @Hidden(when = EssenciaContext.WHEN_VIEW)
    @Order(1)
    @Face(displayName = "Apply")
    @ServiceMethod(callByContent = true, target = ServiceMethodContext.TARGET_APPEND, keyBinding = "Ctrl+S")
    public Object[] apply() {
        if (getElement() instanceof FaceTransformer) {
            ((FaceTransformer) getElement()).beforeApply();// TODO
        }
        getElementView().setElement(getElement());

        if(getElementView().getMetaworksContext()==null)
            getElementView().setMetaworksContext(new MetaworksContext());

        getElementView().getMetaworksContext().setWhen(MetaworksContext.WHEN_EDIT);

        return new Object[]{new ToEvent(ServiceMethodContext.TARGET_SELF, EventContext.EVENT_CLOSE), new Refresh(getElementView(), true)};
    }

    @Order(2)
    @Face(displayName = "Cancel")
    @ServiceMethod(callByContent = true, target = ServiceMethodContext.TARGET_APPEND)
    public ToEvent cancel() {
        getElementView().setElement(getElement());

        return new ToEvent(ServiceMethodContext.TARGET_SELF, EventContext.EVENT_CLOSE);
    }

    @Order(3)
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

    @ServiceMethod
    //@Available(condition = "elementView.fromEdge")
    public void amendFromKernel(
        @AutowiredFromClient(
            payload = "elementViewList[value.elementView.fromEdge.indexOf(toEdge) > -1 || toEdge.indexOf(value.elementView.fromEdge) > -1].element")
        MethodCanvas methodCanvas
    ){

        if(methodCanvas.getElementViewList().size() > 0) {
            IElement kernel = methodCanvas.getElementViewList().get(0).getElement();



        }

    }



}
