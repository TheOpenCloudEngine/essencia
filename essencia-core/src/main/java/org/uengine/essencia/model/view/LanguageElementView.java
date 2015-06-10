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

/**
 * @author jyj
 */
public abstract class LanguageElementView extends ElementView {

    @AutowiredFromClient
    public CardCanvas cardCanvas;

    public LanguageElementView() {
        setMetaworksContext(new MetaworksContext());
    }

    public LanguageElementView(IElement element) {
        super(element);
    }

    @Override
    abstract public Symbol createSymbol();

    public Symbol createKernelSymbol() {
        return null;
    }

    @ServiceMethod(callByContent = true, eventBinding = EventContext.EVENT_DBLCLICK, target = ServiceMethodContext.TARGET_STICK)
    public Object showProperty() throws Exception {
        ModalWindow modal = null;
        if (cardCanvas != null && (this instanceof AlphaView || this instanceof WorkProductView) ) {
            //instance card view
            if (getElement() instanceof CardViewable) {
                if(this instanceof  AlphaView){
                    AlphaInstance a = ((Alpha)getElement()).createInstance(getElement().getName());
//                    AlphaInstanceFace f = new AlphaInstanceFace(this);
                    modal = new ModalWindow(a, 650, 600, "Card View");
                } else {
                    LanguageElementInstanceFace ff = new LanguageElementInstanceFace(this);
                    modal = new ModalWindow(ff, 650, 600, "Card View");
                }
            }
        } else {
            EssenciaPropertyPanel propertyPanel = new EssenciaPropertyPanel(this);
            ContextUtil.setHow(propertyPanel, "dynamicSize");
            modal = new ModalWindow(propertyPanel, 85, 85, "Essencia Element Properties Editor [ " + getLabel() + "]");

        }
        return modal;
    }

}
