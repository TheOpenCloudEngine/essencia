package org.uengine.essencia.model.view;

import java.util.ArrayList;
import java.util.List;

import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.widget.ModalWindow;
import org.uengine.essencia.designer.ActivitySpaceAndActivityPropertyPanel;
import org.uengine.essencia.model.ActivitySpace;
import org.uengine.essencia.modeling.EssenciaKernelSymbol;
import org.uengine.essencia.modeling.canvas.EssenciaCanvas;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.essencia.util.ElementUtil;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.IElement;
import org.uengine.modeling.Symbol;

public class ActivitySpaceView extends ActivityView implements KernelLanguageViewable{
	public final static String SHAPE_ID = "OG.shape.essencia.ActivitySpace";
	
	public ActivitySpaceView(){
	}
	
	public ActivitySpaceView(IElement element){
		super(element);
	}

	@Override
	public Symbol createSymbol() {
		Symbol symbol = new Symbol();
		symbol.setName("ActivitySpace");
		symbol.setShapeId(SHAPE_ID);
		symbol.setHeight(56);
		symbol.setWidth(96);
		symbol.setShapeType(GEOM_TYPE);
		symbol.setElementClassName(ActivitySpace.class.getName());
		return symbol;
	}
	
	@Override
	public EssenciaKernelSymbol createKernelSymbol() {
		EssenciaKernelSymbol symbol = new EssenciaKernelSymbol();
		symbol.setShapeId(SHAPE_ID);
		symbol.setHeight(56);
		symbol.setWidth(96);
		symbol.setShapeType(GEOM_TYPE);
		symbol.setElementClassName(ActivitySpace.class.getName());
		return symbol;
	}
	
//	@Override
//	public Object showProperty() throws Exception {
//		List<ElementView> list = new ArrayList<ElementView>();
//		for(ElementView e : essenciaCanvas.getSafeElementViewList()){
//			if(e instanceof AlphaView){
//				list.add(e);
//			}
//		}
//		ActivitySpaceAndActivityPropertyPanel panel = new ActivitySpaceAndActivityPropertyPanel(this, ElementUtil.convertToElementList(list));
//		ContextUtil.setHow(panel, "dynamicSize");
//		return new ModalWindow(panel, 85, 85, "Essencia Element Properties Editor [ " + getLabel() +"]");
//	}

}
