package org.uengine.essencia;

import org.metaworks.MetaworksContext;
import org.metaworks.ServiceMethodContext;
import org.metaworks.ToEvent;
import org.metaworks.annotation.Available;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Order;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.menu.SubMenu;
import org.uengine.modeling.Canvas;

public class TextSubMenu extends SubMenu {


	@Order(1)
	@Face(displayName="굵게")
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object boldLabel(){
		return new ToEvent(new Canvas(), "boldLabel");
	}

	@Order(2)
	@Face(displayName="이탤릭")
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object italicLabel(){
		return new ToEvent(new Canvas(), "italicLabel");
	}
	
	@Order(3)
	@Face(displayName="글 위치")
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@ServiceMethod(target=ServiceMethodContext.TARGET_STICK)
	public SubMenu position(){
		return new PositionSubMenu();
	}
	
	@Order(4)
	@Face(displayName="수직 정렬")
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@ServiceMethod(target=ServiceMethodContext.TARGET_STICK)
	public SubMenu verticalAlign(){
		return new VerticalAlignSubMenu();
	}
	
	@Order(5)
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@Face(displayName="수평 정렬")
	@ServiceMethod(target=ServiceMethodContext.TARGET_STICK)
	public SubMenu horizontalAlign(){
		return new HorizontalAlignSubMenu();
	}
}
