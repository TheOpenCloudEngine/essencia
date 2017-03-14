package org.uengine.essencia.model.view;

import java.util.ArrayList;
import java.util.List;

import org.metaworks.EventContext;
import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.dwr.MetaworksRemoteService;
import org.metaworks.widget.ModalWindow;
import org.uengine.essencia.designer.ActivitySpaceAndActivityPropertyPanel;
import org.uengine.essencia.model.Activity;
import org.uengine.essencia.modeling.EssenciaKernelSymbol;
import org.uengine.essencia.modeling.canvas.EssenciaCanvas;
import org.uengine.essencia.modeling.modeler.EssenciaDefaultElementViewActionDelegate;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.essencia.util.ElementUtil;
import org.uengine.modeling.Canvas;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.IElement;
import org.uengine.modeling.Symbol;

public class ActivityView extends LanguageElementView {
    public final static String SHAPE_ID = "OG.shape.essencia.Activity";

//    @AutowiredFromClient
//    public EssenciaCanvas essenciaCanvas;


    public ActivityView() {
        setShapeId(SHAPE_ID);
        setHeight(56);
        setWidth(96);
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
        symbol.setShapeType(GEOM_TYPE);
        symbol.setElementClassName(Activity.class.getName());
        return symbol;
    }

    public EssenciaKernelSymbol createKernelSymbol() {
        EssenciaKernelSymbol symbol = new EssenciaKernelSymbol();
        symbol.setShapeId(SHAPE_ID);
        symbol.setHeight(56);
        symbol.setWidth(96);
        symbol.setShapeType(GEOM_TYPE);
        symbol.setElementClassName(Activity.class.getName());
        return symbol;
    }

    @ServiceMethod(callByContent = true, eventBinding = EventContext.EVENT_DBLCLICK, target = ServiceMethodContext.TARGET_STICK)
    public Object showProperty(@AutowiredFromClient(payload = {"id", "elementViewList[true].element.name"/*, "elementViewList[true].label" --> TODO: enable after fixing : https://github.com/TheOpenCloudEngine/metaworks/issues/5 */})
                                   Canvas canvas
    ) throws Exception {

        //TODO: the below logics must be moved to EssenciaPropertyPopup and remove  class - ActivitySpaceAndActivityPropertyPanel
        if(elementViewActionDelegate!=null && !(elementViewActionDelegate instanceof EssenciaDefaultElementViewActionDelegate)){
            MetaworksRemoteService.autowire(elementViewActionDelegate);
            elementViewActionDelegate.onDoubleClick(this);

            return null;
        }

        EssenciaCanvas essenciaCanvas = (EssenciaCanvas) canvas;

        List<ElementView> list = new ArrayList<ElementView>();
        for (ElementView e : essenciaCanvas.getSafeElementViewList()) {
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
                    if (e.getToEdge() == null) {
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

//        return super.showProperty();

        ActivitySpaceAndActivityPropertyPanel panel = new ActivitySpaceAndActivityPropertyPanel(this, ElementUtil.asElementList(list));
        ContextUtil.setHow(panel, "dynamicSize");
        return new ModalWindow(panel, 900, 800, "Essencia Element Properties Editor [ " + getLabel() + "]");
    }

}
