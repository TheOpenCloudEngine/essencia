package org.uengine.essencia.modeling.editor;

import org.metaworks.MetaworksContext;
import org.metaworks.ServiceMethodContext;
import org.metaworks.ToEvent;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.Available;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Order;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.Download;
import org.metaworks.widget.ModalWindow;
import org.metaworks.widget.menu.MainMenu;
import org.metaworks.widget.menu.SubMenu;
import org.uengine.essencia.AlignElementSubMenu;
import org.uengine.essencia.ScaleSubMenu;
import org.uengine.essencia.TextSubMenu;
import org.uengine.essencia.common.CommitHistory;
import org.uengine.essencia.common.CommitUtils;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.model.coverage.MethodCoverage;
import org.uengine.essencia.modeling.canvas.EssenciaCanvas;

import static org.uengine.essencia.common.CommitUtils.getHistoryByFilename;

public class EditorMenu extends MainMenu {

	@AutowiredFromClient
	public EssenciaEditor essenciaEditor;

	@AutowiredFromClient
	public EssenciaCanvas essenciaCanvas;
	
	@Order(1)
	@Face(displayName="Check Out")
	@Available(when={MetaworksContext.WHEN_VIEW})
	@ServiceMethod(target=ServiceMethodContext.TARGET_APPEND)
	public Object[] checkOut(){
		return new Object[]{new ToEvent(new EmptyEditor(), EditorContext.CHECK_OUT)};
	}
	
	@Order(1)
	@Face(displayName="Lock Info")
	@Available(when={EssenciaContext.WHEN_VIEW_LOCK})
	@ServiceMethod(target=ServiceMethodContext.TARGET_APPEND)
	public Object[] lockInfo(){
		return new Object[]{new ToEvent(new EmptyEditor(), EditorContext.LOCK_INFO)};
	}

	@Order(1)
	@Face(displayName="Save")
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@ServiceMethod(target=ServiceMethodContext.TARGET_APPEND)
	public Object[] save(){
		return new Object[]{new ToEvent(new EmptyEditor(), EditorContext.SAVE)};
	}


	@Order(2)
	@Face(displayName="Check In")
	@Available(when={MetaworksContext.WHEN_EDIT})
	@ServiceMethod(target=ServiceMethodContext.TARGET_APPEND)
	public Object[] checkIn(){
		return new Object[]{new ToEvent(new EmptyEditor(), EditorContext.CHECK_IN)};
	}
	
	@Order(3)
	@Face(displayName="Edit")
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@ServiceMethod(target=ServiceMethodContext.TARGET_STICK)
	public SubMenu edit(){
		return new EditorSubMenu();
	}

	@Order(4)
	@Face(displayName="Font")
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@ServiceMethod(target=ServiceMethodContext.TARGET_STICK)
	public SubMenu text(){
		return new TextSubMenu();
	}

	@Order(6)
	@Face(displayName="Align")
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@ServiceMethod(target=ServiceMethodContext.TARGET_STICK)
	public SubMenu alignElement(){
		return new AlignElementSubMenu();
	}
	
	@Order(7)
	@Face(displayName="Zoom In/Out")
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@ServiceMethod(target=ServiceMethodContext.TARGET_STICK)
	public SubMenu scale(){
		return new ScaleSubMenu();
	}

	@Order(8)
	@Face(displayName="History")
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@ServiceMethod(target=ServiceMethodContext.TARGET_POPUP)
	public Object History(){
		CommitHistory history = new CommitHistory();
		history = getHistoryByFilename(essenciaEditor.getResource().getName());
		
		ModalWindow modalWindow = new ModalWindow();
		modalWindow.setWidth(300);
		modalWindow.setHeight(500);
		modalWindow.setTitle("History");
		modalWindow.setPanel(history);
		return modalWindow;
	}
	
	@Order(9)
	@Face(displayName="Export")
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@ServiceMethod(except="fileTransfer", target=ServiceMethodContext.TARGET_APPEND)
	public Download exportXmi() throws Exception{
		return essenciaEditor.exportXmi();
	}
	
	@Order(10)
	@Face(displayName="Coverage")
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@ServiceMethod(target=ServiceMethodContext.TARGET_POPUP)
	public Object coverage(){
		return new ModalWindow(new MethodCoverage(essenciaCanvas), 1100, 650, "Method Coverage");
	}
}
