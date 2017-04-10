package org.uengine.essencia.model.view;

import org.metaworks.EventContext;
import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.ServiceMethod;
import org.uengine.essencia.model.State;
import org.uengine.essencia.modeling.canvas.MethodCanvas;
import org.uengine.modeling.Canvas;
import org.uengine.modeling.IElement;
import org.uengine.modeling.Symbol;

/**
 * @author jyj
 */
public class StateView extends LanguageElementView {
	public final static String SHAPE_ID = "OG.shape.essencia.State";
	
	public StateView(){
	}
	
	public StateView(IElement element){
		super(element);
	}

	@Override
	public Symbol createSymbol() {
		Symbol symbol = new Symbol();
		symbol.setName("State");
		symbol.setShapeId(SHAPE_ID);
		symbol.setHeight(40);
		symbol.setWidth(96);
		symbol.setShapeType(GEOM_TYPE);
		symbol.setElementClassName(State.class.getName());
		return symbol;
	}

	@ServiceMethod(eventBinding = EventContext.EVENT_DBLCLICK, target = ServiceMethodContext.TARGET_POPUP, clientSide = true)
	public Object showProperty() throws Exception {
		/* client side */
		return super.showProperty();
	}

	@ServiceMethod(eventBinding = EventContext.EVENT_DBLCLICK, target = ServiceMethodContext.TARGET_POPUP, clientSide = true)
	public Object showPropertyWhenView(@AutowiredFromClient(payload = "id") MethodCanvas canvas) throws Exception {
		/* client side */
		return super.showPropertyWhenView(canvas);
	}
}
