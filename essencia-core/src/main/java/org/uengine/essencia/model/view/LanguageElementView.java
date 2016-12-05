package org.uengine.essencia.model.view;

import org.metaworks.EventContext;
import org.metaworks.MetaworksContext;
import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.dwr.MetaworksRemoteService;
import org.metaworks.widget.ModalWindow;
import org.uengine.essencia.designer.EssenciaPropertyPanel;
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

    @AutowiredFromClient(payload = "id")
    public Canvas canvas;

    @ServiceMethod(callByContent = true, eventBinding = EventContext.EVENT_DBLCLICK, target = ServiceMethodContext.TARGET_STICK)
    public Object showProperty() throws Exception {

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

}
