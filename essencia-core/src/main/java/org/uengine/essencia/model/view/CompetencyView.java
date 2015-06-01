package org.uengine.essencia.model.view;

import org.uengine.essencia.model.Competency;
import org.uengine.essencia.modeling.EssenciaKernelSymbol;
import org.uengine.modeling.IElement;
import org.uengine.modeling.Symbol;

/**
 * @author jyj
 */
public class CompetencyView extends LanguageElementView implements KernelLanguageViewable {
	
public final static String SHAPE_ID = "OG.shape.essencia.Competency";
	
	public CompetencyView(){
		
	}
	
	public CompetencyView(IElement element){
		super(element);
	}
	
	@Override
	public Symbol createSymbol() {
		Symbol symbol = new Symbol();
		symbol.setName("Competency");
		symbol.setShapeId(SHAPE_ID);
		symbol.setHeight(96);
		symbol.setWidth(96);
		symbol.setShapeType("GEOM");
		symbol.setElementClassName(Competency.class.getName());
		
		return symbol;
	}
	
	@Override
	public EssenciaKernelSymbol createKernelSymbol() {
		EssenciaKernelSymbol symbol = new EssenciaKernelSymbol();
		symbol.setShapeId(SHAPE_ID);
		symbol.setHeight(96);
		symbol.setWidth(96);
		symbol.setShapeType("GEOM");
		symbol.setElementClassName(Competency.class.getName());
		
		return symbol;
	}

}
