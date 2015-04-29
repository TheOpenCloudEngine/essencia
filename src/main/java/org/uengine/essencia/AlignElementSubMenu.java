package org.uengine.essencia;

import org.metaworks.Remover;
import org.metaworks.ServiceMethodContext;
import org.metaworks.ToEvent;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Order;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.menu.SubMenu;
import org.uengine.modeling.Canvas;

public class AlignElementSubMenu extends SubMenu {

	@Order(2)
	@Face(displayName="왼쪽")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] alignLeft(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "alignLeft")};
	}
	
	@Order(3)
	@Face(displayName="오른쪽")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] alignRight(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "alignRight")};
	}
	
	@Order(1)
	@Face(displayName="위")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] alignTop(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "alignTop")};
	}
	
	@Order(4)
	@Face(displayName="아래")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] alignBottom(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "alignBottom")};
	}
}
