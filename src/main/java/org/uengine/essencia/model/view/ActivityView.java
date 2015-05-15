package org.uengine.essencia.model.view;

import java.util.ArrayList;
import java.util.List;

import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.widget.ModalWindow;
import org.uengine.essencia.designer.ActivitySpaceAndActivityPropertyPanel;
import org.uengine.essencia.model.Activity;
import org.uengine.essencia.modeling.EssenciaKernelSymbol;
import org.uengine.essencia.modeling.canvas.EssenciaCanvas;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.essencia.util.ElementUtil;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.IElement;
import org.uengine.modeling.Symbol;

public class ActivityView extends LanguageElementView {
    public final static String SHAPE_ID = "OG.shape.essencia.Activity";

    @AutowiredFromClient
    public EssenciaCanvas essenciaCanvas;

    public ActivityView() {
    }

    public ActivityView(IElement element) {
	super(element);
    }

    @Override
    public Symbol createSymbol() {
	Symbol symbol = new Symbol();
	symbol.setName("Activity");
	symbol.setShapeId(SHAPE_ID);
	symbol.setHeight(56);
	symbol.setWidth(96);
	symbol.setShapeType("GEOM");
	symbol.setElementClassName(Activity.class.getName());
	return symbol;
    }

    public EssenciaKernelSymbol createKernelSymbol() {
	EssenciaKernelSymbol symbol = new EssenciaKernelSymbol();
	symbol.setShapeId(SHAPE_ID);
	symbol.setHeight(56);
	symbol.setWidth(96);
	symbol.setShapeType("GEOM");
	symbol.setElementClassName(Activity.class.getName());
	return symbol;
    }

    @Override
    public Object showProperty() throws Exception {
	List<ElementView> list = new ArrayList<ElementView>();
	for (ElementView e : essenciaCanvas.getElementViewList()) {
	    if (e instanceof AlphaView) {
		list.add(e);
	    } else if (e instanceof WorkProductView) {
		list.add(e);
	    } else if (e instanceof CompetencyView) {
		list.add(e);
	    } else if (e instanceof ActivitySpaceView) {
		if (getFromEdge() != null) {
		    String[] fromEdges = getFromEdge().split(",");
		    //the activitySpace doesn't have any child activity
		    if(e.getToEdge() == null){
			continue;
		    }
		    String[] toEdges = e.getToEdge().split(",");
		    for (String fromEdeg : fromEdges) {
			for (String toEdge : toEdges) {
			    if (fromEdeg.equals(toEdge)) {
				list.add(e);
			    }
			}
		    }
		}
	    }
	}

	ActivitySpaceAndActivityPropertyPanel panel = new ActivitySpaceAndActivityPropertyPanel(this, ElementUtil.convertToElementList(list));
	ContextUtil.setHow(panel, "dynamicSize");
	return new ModalWindow(panel, 85, 85, "Essencia Element Properties Editor [ " + getLabel() + "]");
    }

}
