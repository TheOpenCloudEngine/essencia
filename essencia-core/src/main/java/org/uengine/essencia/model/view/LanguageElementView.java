package org.uengine.essencia.model.view;

import org.metaworks.EventContext;
import org.metaworks.MetaworksContext;
import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.ModalWindow;
import org.uengine.essencia.designer.EssenciaPropertyPanel;
import org.uengine.essencia.enactment.AlphaInstance;
import org.uengine.essencia.enactment.face.AlphaInstanceFace;
import org.uengine.essencia.enactment.face.LanguageElementInstanceFace;
import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.CardViewable;
import org.uengine.essencia.model.card.Card;
import org.uengine.essencia.modeling.canvas.CardCanvas;
import org.uengine.essencia.modeling.canvas.MethodCanvas;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.IElement;
import org.uengine.modeling.Symbol;

public abstract class LanguageElementView extends ElementView {

    public static final String GEOM_TYPE = "GEOM";

    public LanguageElementView() {
    }

    public LanguageElementView(IElement element) {
        super(element);
    }

    @ServiceMethod(callByContent = true, eventBinding = EventContext.EVENT_DBLCLICK, target = ServiceMethodContext.TARGET_STICK)
    public Object showProperty() throws Exception {

        if(elementViewActionDelegate!=null){
            elementViewActionDelegate.onDoubleClick(this);

            return null;
        }

        EssenciaPropertyPanel propertyPanel = new EssenciaPropertyPanel(this);
        ContextUtil.setHow(propertyPanel, "dynamicSize");
        ModalWindow modal = new ModalWindow(propertyPanel, 900, 500, "Essencia Element Properties Editor [ " + getLabel() + "]");
        return modal;
    }

}
