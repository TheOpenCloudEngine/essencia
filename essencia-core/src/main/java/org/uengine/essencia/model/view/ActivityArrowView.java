package org.uengine.essencia.model.view;

import org.uengine.modeling.ElementView;
import org.uengine.modeling.Symbol;

/**
 * @author jyj
 */
public class ActivityArrowView extends ElementView {

public final static String SHAPE_ID = "OG.shape.essencia.ActivityArrow";

	public ActivityArrowView(){
		
	}

	@Override
	public Symbol createSymbol() {
		Symbol symbol = new Symbol();
		symbol.setShapeId(SHAPE_ID);
		symbol.setHeight(100);
		symbol.setWidth(100);
		symbol.setShapeType("GEOM");
		
		return symbol;
	}
	
	
}
