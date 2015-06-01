package org.uengine.essencia;

import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.menu.SubMenu;

public class FormatSubMenu extends SubMenu {

	
	@Face(displayName="투명도")
	@ServiceMethod(target=ServiceMethodContext.TARGET_STICK)
	public SubMenu opacity(){
		return new OpacitySubMenu();
	}
}
