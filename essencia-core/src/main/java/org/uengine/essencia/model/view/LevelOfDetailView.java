package org.uengine.essencia.model.view;

import org.uengine.essencia.model.LevelOfDetail;
import org.uengine.modeling.IElement;
import org.uengine.modeling.Symbol;

/**
 * @author jyj
 */
public class LevelOfDetailView extends StateView {
	public final static String SHAPE_ID = "OG.shape.essencia.LevelOfDetail";
	
	public LevelOfDetailView(){
	}
	
	public LevelOfDetailView(IElement element){
		super(element);
	}
	
	@Override
	public Symbol createSymbol() {
		Symbol symbol = new Symbol();
		symbol.setName("LevelOfDetail");
		symbol.setShapeId(SHAPE_ID);
		symbol.setHeight(40);
		symbol.setWidth(176);
		symbol.setShapeType(GEOM_TYPE);
		symbol.setElementClassName(LevelOfDetail.class.getName());
		return symbol;
	}
	
}
