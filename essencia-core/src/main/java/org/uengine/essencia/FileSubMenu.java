package org.uengine.essencia;

import org.metaworks.EventContext;
import org.metaworks.MetaworksContext;
import org.metaworks.ServiceMethodContext;
import org.metaworks.ToEvent;
import org.metaworks.annotation.Available;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Order;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.menu.SubMenu;
import org.uengine.essencia.modeling.editor.EmptyEditor;

public class FileSubMenu extends SubMenu {

	@Order(1)
	@Face(displayName="저장(Ctrl + S)")
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object save(){
		return new Object[]{new ToEvent(new EmptyEditor(), EventContext.EVENT_SAVE)};
	}
	
}
