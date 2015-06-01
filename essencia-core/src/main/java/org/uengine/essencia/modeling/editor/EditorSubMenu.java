package org.uengine.essencia.modeling.editor;

import org.metaworks.MetaworksContext;
import org.metaworks.ServiceMethodContext;
import org.metaworks.ToEvent;
import org.metaworks.annotation.Available;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Order;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.menu.SubMenu;
import org.uengine.modeling.Canvas;

public class EditorSubMenu extends SubMenu {

	@Order(1)
	@Face(displayName="Select All(Ctrl + A)")
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object selectAll(){
		return new ToEvent(new Canvas(), "selectAll");
	}

	@Order(4)
	@Face(displayName="Delete(Delete)")
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object deleteElement(){
		return new ToEvent(new Canvas(), "deleteElement");
	}

	@Order(2)
	@Face(displayName="Copy(Ctrl + C)")
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object copyElement(){
		return new ToEvent(new Canvas(), "copyElement");
	}

	@Order(3)
	@Face(displayName="Paste(Ctrl + V)")
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object pasteElement(){
		return new ToEvent(new Canvas(), "pasteElement");
	}
}
