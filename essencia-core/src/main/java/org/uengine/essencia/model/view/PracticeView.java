package org.uengine.essencia.model.view;

import org.uengine.essencia.model.Practice;
import org.uengine.essencia.modeling.EssenciaKernelSymbol;
import org.uengine.modeling.IElement;
import org.uengine.modeling.Symbol;

/**
 * @author jyj
 */
public class PracticeView extends LanguageElementView {

public final static String SHAPE_ID = "OG.shape.essencia.Practice";

	public PracticeView(){
		
	}
	
	public PracticeView(IElement element){
		super(element);
	}
	
	@Override
	public Symbol createSymbol() {
		Symbol symbol = new Symbol();
		symbol.setName("Practice");
		symbol.setShapeId(SHAPE_ID);
		symbol.setHeight(88);
		symbol.setWidth(88);
		symbol.setShapeType(GEOM_TYPE);
		symbol.setElementClassName(Practice.class.getName());
		
		return symbol;
	}
	
	public EssenciaKernelSymbol createKernelSymbol() {
		EssenciaKernelSymbol symbol = new EssenciaKernelSymbol();
		symbol.setShapeId(SHAPE_ID);
		symbol.setHeight(88);
		symbol.setWidth(88);
		symbol.setShapeType(GEOM_TYPE);
		symbol.setElementClassName(Practice.class.getName());
		
		return symbol;
	}
	
}
