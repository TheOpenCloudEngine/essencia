package org.uengine.essencia.model.view;

import org.metaworks.EventContext;
import org.metaworks.MetaworksContext;
import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.ModalWindow;
import org.uengine.essencia.designer.EssenciaPropertyPanel;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.IElement;
import org.uengine.modeling.Symbol;

/**
 * @author jyj
 */
public abstract class LanguageElementView extends ElementView {
	
	public LanguageElementView(){
		setMetaworksContext(new MetaworksContext());
	}
	
	public LanguageElementView(IElement element){
		super(element);
	}
	
	@Override
	abstract public Symbol createSymbol();
	
	public Symbol createKernelSymbol(){return null;}
	
	@ServiceMethod(callByContent=true, eventBinding=EventContext.EVENT_DBLCLICK, target=ServiceMethodContext.TARGET_STICK)
	public Object showProperty() throws Exception {
//		PropertyTabs tabs = new PropertyTabs(this);
		EssenciaPropertyPanel propertyPanel  = new EssenciaPropertyPanel(this);
		ContextUtil.setHow(propertyPanel, "dynamicSize");
		return new ModalWindow(propertyPanel, 85, 85, "Essencia Element Properties Editor [ " + getLabel() +"]");
	}

}
