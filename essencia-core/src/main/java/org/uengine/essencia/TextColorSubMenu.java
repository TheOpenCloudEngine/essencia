package org.uengine.essencia;

import org.metaworks.MetaworksContext;
import org.metaworks.Remover;
import org.metaworks.ServiceMethodContext;
import org.metaworks.ToEvent;
import org.metaworks.annotation.Available;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Order;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.menu.SubMenu;
import org.uengine.modeling.Canvas;

public class TextColorSubMenu extends SubMenu {

	@Order(1)
	@Face(displayName="하양")
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] white(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "setFontColor", "white")};
	}
	
	@Order(2)
	@Face(displayName="회색")
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] gray(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "setFontColor", "gray")};
	}
	
	@Order(3)
	@Face(displayName="빨강")
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] red(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "setFontColor", "red")};
	}
	
	@Order(4)
	@Face(displayName="파랑")
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] blue(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "setFontColor", "blue")};
	}
	
	@Order(5)
	@Face(displayName="노랑")
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] yellow(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "setFontColor", "yellow")};
	}
	
	@Order(6)
	@Face(displayName="오렌지")
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] orange(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "setFontColor", "orange")};
	}
	
	@Order(7)
	@Face(displayName="녹색")
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] green(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "setFontColor", "green")};
	}
	
	@Order(8)
	@Face(displayName="검정")
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] black(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "setFontColor", "black")};
	}
	
}
