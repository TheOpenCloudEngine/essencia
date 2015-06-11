package org.uengine.essencia.model.view;

import org.uengine.essencia.model.State;
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
}
