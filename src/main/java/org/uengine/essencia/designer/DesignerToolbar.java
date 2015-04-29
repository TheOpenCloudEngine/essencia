package org.uengine.essencia.designer;

import org.metaworks.annotation.Face;
import org.uengine.essencia.designer.menu.DesignerMenu;

@Face(ejsPath="dwr/metaworks/genericfaces/WindowFace.ejs", options={"hideTitleBar", "hideLabels"}, values={"true", "true"})
public class DesignerToolbar {
	DesignerMenu designerMenu;

	public DesignerMenu getDesignerMenu() {
		return designerMenu;
	}
	public void setDesignerMenu(DesignerMenu designerMenu) {
		this.designerMenu = designerMenu;
	}

	public DesignerToolbar(){
		this.designerMenu = new DesignerMenu();
	}
}
