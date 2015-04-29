package org.uengine.essencia.modeling;

import org.metaworks.EventContext;
import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.ServiceMethod;
import org.uengine.essencia.modeling.palette.ConnectorPalette;
import org.uengine.modeling.Palette;
import org.uengine.modeling.Symbol;

public class ConnectorSymbol extends Symbol {
	@ServiceMethod(callByContent=true, eventBinding=EventContext.EVENT_CLICK, target=ServiceMethodContext.TARGET_STICK)
	public Object open(){
		Palette palette = new ConnectorPalette();
		return palette;
	}

}
