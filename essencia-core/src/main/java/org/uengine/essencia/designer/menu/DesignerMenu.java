package org.uengine.essencia.designer.menu;

import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.menu.MainMenu;
import org.metaworks.widget.menu.SubMenu;

public class DesignerMenu extends MainMenu {

	@Face(displayName="$menu.file")
	@ServiceMethod(target=ServiceMethodContext.TARGET_STICK)
	public SubMenu file(){
		return new FileSubMenu();
	}
	
	@Face(displayName="$menu.edit")
	@ServiceMethod(target=ServiceMethodContext.TARGET_STICK)
	public SubMenu edit(){
		return new EditSubMenu();
	}
	
}
