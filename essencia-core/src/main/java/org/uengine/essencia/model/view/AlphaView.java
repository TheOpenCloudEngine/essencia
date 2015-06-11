package org.uengine.essencia.model.view;

import org.metaworks.annotation.AutowiredFromClient;
import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.modeling.EssenciaKernelSymbol;
import org.uengine.modeling.Canvas;
import org.uengine.modeling.IElement;
import org.uengine.modeling.Symbol;

/**
 * @author jyj
 */
public class AlphaView extends LanguageElementView implements KernelLanguageViewable{

public final static String SHAPE_ID = "OG.shape.essencia.Alpha";

	@AutowiredFromClient
	public Canvas canvas;

	public AlphaView(){
		
	}
	
	public AlphaView(IElement element){
		super(element);
	}
	
	@Override
	public Symbol createSymbol() {
		Symbol symbol = new Symbol();
		symbol.setName("Alpha");
		symbol.setShapeId(SHAPE_ID);
		symbol.setHeight(50);
		symbol.setWidth(130);
		symbol.setShapeType(GEOM_TYPE);
		symbol.setElementClassName(Alpha.class.getName());
		
		return symbol;
	}
	
	@Override
	public EssenciaKernelSymbol createKernelSymbol() {
		EssenciaKernelSymbol symbol = new EssenciaKernelSymbol();
		symbol.setShapeId(SHAPE_ID);
		symbol.setHeight(50);
		symbol.setWidth(130);
		symbol.setShapeType(GEOM_TYPE);
		symbol.setElementClassName(Alpha.class.getName());
		
		return symbol;
	}
	
}
