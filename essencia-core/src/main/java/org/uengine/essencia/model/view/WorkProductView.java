package org.uengine.essencia.model.view;

import org.uengine.essencia.model.WorkProduct;
import org.uengine.modeling.IElement;
import org.uengine.modeling.Symbol;

/**
 * @author jyj
 */
public class WorkProductView extends LanguageElementView {
	public final static String SHAPE_ID = "OG.shape.essencia.WorkProduct";
	
	public WorkProductView(){
	}
	
	public WorkProductView(IElement element){
		super(element);
	}

	@Override
	public Symbol createSymbol() {
		Symbol symbol = new Symbol();
		symbol.setName("WorkProduct");
		symbol.setShapeId(SHAPE_ID);
		symbol.setHeight(72);
		symbol.setWidth(40);
		symbol.setShapeType(GEOM_TYPE);
		symbol.setElementClassName(WorkProduct.class.getName());
		return symbol;
	}

}
