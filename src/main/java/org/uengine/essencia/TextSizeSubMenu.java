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

public class TextSizeSubMenu extends SubMenu {

	@Order(1)
	@Face(displayName="10")
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] ten(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "setFontSize", "10")};
	}
	
	@Order(2)
	@Face(displayName="11")
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] eleven(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "setFontSize", "11")};
	}
	
	@Order(3)
	@Face(displayName="12")
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] twelve(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "setFontSize", "12")};
	}
	
	@Order(4)
	@Face(displayName="13")
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] thirteen(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "setFontSize", "13")};
	}
	
	@Order(5)
	@Face(displayName="14")
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] fourteen(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "setFontSize", "14")};
	}

	@Order(6)
	@Face(displayName="15")
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] fifteen(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "setFontSize", "15")};
	}
	
	@Order(7)
	@Face(displayName="16")
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] sixteen(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new Canvas(), "setFontSize", "16")};
	}
}
