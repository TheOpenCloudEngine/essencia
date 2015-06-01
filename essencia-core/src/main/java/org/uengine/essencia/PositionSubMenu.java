package org.uengine.essencia;

import org.metaworks.Remover;
import org.metaworks.ServiceMethodContext;
import org.metaworks.ToEvent;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Order;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.menu.SubMenu;
import org.uengine.modeling.Canvas;

public class PositionSubMenu extends SubMenu {
	
	@Order(2)
	@Face(displayName="왼쪽")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] leftLabelLocation(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "labelPosition", "left")};
	}
	
	@Order(4)
	@Face(displayName="오른쪽")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] rightLabelLocation(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "labelPosition", "right")};
	}
	
	@Order(1)
	@Face(displayName="위")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] topLabelLocation(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "labelPosition", "top")};
	}
	
	@Order(5)
	@Face(displayName="아래")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] bottomLabelLocation(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "labelPosition", "bottom")};
	}
	
	@Order(3)
	@Face(displayName="가운데")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] centerLabelLocation(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "labelPosition", "center")};
	}
}
