package org.uengine.essencia.designer.menu;

import org.metaworks.Remover;
import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.menu.SubMenu;

public class NewFileSubMenu extends SubMenu {

	@Face(displayName="$menu.file.new.folder")
	@ServiceMethod(target=ServiceMethodContext.TARGET_APPEND)
	public Object[] newFolder(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF)};
	}
	
	@Face(displayName="$menu.file.new.process")
	@ServiceMethod(target=ServiceMethodContext.TARGET_APPEND)
	public Object[] newProcess(){
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF)};
	}
	
}
