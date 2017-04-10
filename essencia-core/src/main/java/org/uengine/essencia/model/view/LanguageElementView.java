package org.uengine.essencia.model.view;

import org.metaworks.EventContext;
import org.metaworks.MetaworksContext;
import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.Available;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.dao.TransactionContext;
import org.metaworks.dwr.MetaworksRemoteService;
import org.metaworks.widget.ModalWindow;
import org.uengine.essencia.designer.EssenciaPropertyPanel;
import org.uengine.essencia.modeling.canvas.MethodCanvas;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.modeling.Canvas;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.IElement;

public abstract class LanguageElementView extends ElementView {

    public static final String GEOM_TYPE = "GEOM";

    public LanguageElementView() {
    }

    public LanguageElementView(IElement element) {
        super(element);
    }

//    @AutowiredFromClient(payload = "id")
//    public Canvas canvas;

    @Available(when = {MetaworksContext.WHEN_EDIT, MetaworksContext.WHEN_NEW, "" })
    @ServiceMethod(callByContent = true, eventBinding = EventContext.EVENT_DBLCLICK, target = ServiceMethodContext.TARGET_STICK)
    public Object showProperty(@AutowiredFromClient(payload = "id") Canvas canvas) throws Exception {

        TransactionContext.getThreadLocalInstance().setMW3FaceOptionEnabled(true);

        if(elementViewActionDelegate!=null){
            MetaworksRemoteService.autowire(elementViewActionDelegate);
            elementViewActionDelegate.onDoubleClick(this);

            return null;
        }

        EssenciaPropertyPanel propertyPanel = new EssenciaPropertyPanel(this);
        ContextUtil.setHow(propertyPanel, "dynamicSize");
        ModalWindow modal = new ModalWindow(propertyPanel, 900, 500, "Essencia Element Properties Editor [ " + getLabel() + "]");
        return modal;
    }

    @ServiceMethod(payload="element.name", eventBinding = EventContext.EVENT_DBLCLICK, target = ServiceMethodContext.TARGET_STICK, when = MetaworksContext.WHEN_VIEW )
    public Object showPropertyWhenView(@AutowiredFromClient(payload = "id") MethodCanvas canvas) throws Exception {
        return showProperty(canvas);
    }

}
