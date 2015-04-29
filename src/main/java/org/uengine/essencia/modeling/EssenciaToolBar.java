package org.uengine.essencia.modeling;

import org.metaworks.EventContext;
import org.metaworks.ToEvent;
import org.metaworks.annotation.ServiceMethod;
import org.uengine.modeling.Canvas;

public class EssenciaToolBar {

	@ServiceMethod
	public Object save() throws Exception{
		
		return new ToEvent(new Canvas(), EventContext.EVENT_SAVE);
	}
}
