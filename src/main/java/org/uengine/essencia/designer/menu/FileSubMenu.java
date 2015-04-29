package org.uengine.essencia.designer.menu;

import org.metaworks.EventContext;
import org.metaworks.Remover;
import org.metaworks.ServiceMethodContext;
import org.metaworks.ToEvent;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.menu.SubMenu;
import org.uengine.essencia.modeling.editor.EmptyEditor;
import org.uengine.modeling.Canvas;
   
public class FileSubMenu extends SubMenu {

	@AutowiredFromClient
	public Canvas canvas;
	
	@Face(displayName="$menu.file.new")
	@ServiceMethod(target=ServiceMethodContext.TARGET_STICK)
	public SubMenu newFile(){
		return new NewFileSubMenu();
	}
	
	@Face(displayName="$menu.file.open")
	@ServiceMethod(target=ServiceMethodContext.TARGET_APPEND)
	public Object[] openFile() throws Exception{
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new EmptyEditor(), "load")};
	}
	
	@Face(displayName="$menu.file.save")
	@ServiceMethod(target=ServiceMethodContext.TARGET_APPEND)
	public Object[] saveFile() throws Exception{
		return new Object[]{new Remover(ServiceMethodContext.TARGET_SELF), new ToEvent(new EmptyEditor(), EventContext.EVENT_SAVE)};
		
	}
	
}
