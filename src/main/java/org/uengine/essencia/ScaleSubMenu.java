package org.uengine.essencia;

import org.metaworks.ServiceMethodContext;
import org.metaworks.ToEvent;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Order;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.menu.SubMenu;
import org.uengine.modeling.Canvas;

public class ScaleSubMenu extends SubMenu {

	@Order(2)
	@Face(displayName="확대")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] zoomIn(){
		return new Object[]{new ToEvent(new Canvas(), "zoomIn")};
	}
	
	@Order(3)
	@Face(displayName="축소")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] zoomOut(){
		return new Object[]{new ToEvent(new Canvas(), "zoomOut")};
	}
	
	@Order(1)
	@Face(displayName="실제 사이즈")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] actualSize(){
		return new Object[]{new ToEvent(new Canvas(), "actualSize")};
	}
	
	@Order(4)
	@Face(displayName="25%")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] twentyFive(){
		return new Object[]{new ToEvent(new Canvas(), "setScale", 0.25)};
	}	
	
	@Order(5)
	@Face(displayName="50%")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] fifty(){
		return new Object[]{new ToEvent(new Canvas(), "setScale", 0.5)};
	}
	
	@Order(6)
	@Face(displayName="75%")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] seventyFive(){
		return new Object[]{new ToEvent(new Canvas(), "setScale", 0.75)};
	}
	
	@Order(7)
	@Face(displayName="100%")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] hundred(){
		return new Object[]{new ToEvent(new Canvas(), "setScale", 1)};
	}
	
	@Order(8)
	@Face(displayName="150%")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] hundredFifty(){
		return new Object[]{new ToEvent(new Canvas(), "setScale", 1.5)};
	}
	
	@Order(9)
	@Face(displayName="200%")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] twoHundred(){
		return new Object[]{new ToEvent(new Canvas(), "setScale", 2)};
	}
	
	@Order(10)
	@Face(displayName="300%")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] threeHundred(){
		return new Object[]{new ToEvent(new Canvas(), "setScale", 3)};
	}
	
	@Order(11)
	@Face(displayName="400%")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] fourHundred(){
		return new Object[]{new ToEvent(new Canvas(), "setScale", 4)};
	}
}
