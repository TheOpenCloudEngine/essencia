package org.uengine.essencia.model.view;

import org.uengine.essencia.model.CompetencyLevel;
import org.uengine.essencia.modeling.EssenciaKernelSymbol;
import org.uengine.modeling.IElement;
import org.uengine.modeling.Symbol;

/**
 * @author jyj
 */
public class CompetencyLevelView extends LanguageElementView {
	
public final static String SHAPE_ID = "OG.shape.essencia.CompetencyLevel";
	
	public CompetencyLevelView(){
		
	}
	
	public CompetencyLevelView(IElement element){
		super(element);
	}
	
	@Override
	public Symbol createSymbol() {
		Symbol symbol = new Symbol();
		symbol.setName("CompetencyLevel");
		symbol.setShapeId(SHAPE_ID);
		symbol.setHeight(32);
		symbol.setWidth(130);
		symbol.setShapeType(GEOM_TYPE);
		symbol.setElementClassName(CompetencyLevel.class.getName());
		
		return symbol;
	}
	
	public EssenciaKernelSymbol createKernelSymbol() {
		EssenciaKernelSymbol symbol = new EssenciaKernelSymbol();
		symbol.setShapeId(SHAPE_ID);
		symbol.setHeight(40);
		symbol.setWidth(100);
		symbol.setShapeType(GEOM_TYPE);
		symbol.setElementClassName(CompetencyLevel.class.getName());
		
		return symbol;
	}

}
