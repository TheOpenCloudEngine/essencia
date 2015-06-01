package org.uengine.essencia;

import org.metaworks.Remover;
import org.metaworks.ServiceMethodContext;
import org.metaworks.ToEvent;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Order;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.menu.SubMenu;
import org.uengine.modeling.Canvas;

public class OpacitySubMenu extends SubMenu {

	@Order(1)
	@Face(displayName="10%")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] ten(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "opacity", "0.1")};
	}
	
	@Order(2)
	@Face(displayName="20%")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] twenty(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "opacity", "0.2")};
	}
	
	@Order(3)
	@Face(displayName="30%")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] thirty(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "opacity", "0.3")};
	}
	
	@Order(4)
	@Face(displayName="40%")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] fourty(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "opacity", "0.4")};
	}
	
	@Order(5)
	@Face(displayName="50%")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] fifty(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "opacity", "0.5")};
	}
	
	@Order(6)
	@Face(displayName="60%")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] sixty(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "opacity", "0.6")};
	}
	
	@Order(7)
	@Face(displayName="70%")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] seventy(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "opacity", "0.7")};
	}
	
	@Order(8)
	@Face(displayName="80%")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] eighty(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "opacity", "0.8")};
	}
	
	@Order(9)
	@Face(displayName="90%")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] ninety(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "opacity", "0.9")};
	}
	
	@Order(10)
	@Face(displayName="100%")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] hundred(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "opacity", "1")};
	}
}
