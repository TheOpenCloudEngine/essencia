package org.uengine.essencia.designer;

import org.metaworks.ContextAware;
import org.metaworks.EventContext;
import org.metaworks.MetaworksContext;
import org.metaworks.Refresh;
import org.metaworks.ServiceMethodContext;
import org.metaworks.ToEvent;
import org.metaworks.annotation.Available;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.Order;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.ModalWindow;
import org.uengine.essencia.modeling.editor.Editor;
import org.uengine.essencia.modeling.editor.EmptyEditor;

@Face(ejsPath="dwr/metaworks/genericfaces/FormFace.ejs")
public class MessagePanel implements ContextAware {
	public static final String HOW_SAVE 		= "save";
	public static final String HOW_CHECKOUT_SAVE= "checkout_save";
	public static final String HOW_SAVE_CHECK 	= "save_check";
	public static final String HOW_CHECKOUT 	= "checkout";
	
	
	public MessagePanel(){
		this.setMetaworksContext(new MetaworksContext());
	}
	
	public MessagePanel(String id){
		this();
		this.id = id;
	}
	

	String id;
	@Hidden
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}

	String message;
	@Order(1)
	@Face(displayName="메세지", options="hideLabel", values="true")
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}

	MetaworksContext metaworksContext;
		public MetaworksContext getMetaworksContext() {
			return metaworksContext;
		}
		public void setMetaworksContext(MetaworksContext metaworksContext) {
			this.metaworksContext = metaworksContext;
		}

	@Order(2)
	@Face(displayName="예")
	@Available(how={HOW_SAVE, HOW_SAVE_CHECK, HOW_CHECKOUT_SAVE})
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] Save() throws Exception{
		Editor editor = new EmptyEditor();
		editor.setId(this.getId());
		if(getMetaworksContext().getHow().equals(HOW_SAVE_CHECK)){
			this.getMetaworksContext().setHow(HOW_CHECKOUT);
			ModalWindow modal = new ModalWindow(this, 400, 200, "checkout");
			this.setMessage("check out?");
			modal.setId(this.getId());
			return new Object[]{new ToEvent(editor, EventContext.EVENT_SAVE),new Refresh(modal, true)};
		} else {
			if(getMetaworksContext().getHow().equals(HOW_CHECKOUT_SAVE)){
				return new Object[]{new ToEvent(new EmptyEditor(), "savecheckout"),
						new ToEvent(ServiceMethodContext.TARGET_SELF, EventContext.EVENT_CLOSE)};
			}else{
				return new Object[]{new ToEvent(editor, EventContext.EVENT_SAVE),
						new ToEvent(ServiceMethodContext.TARGET_SELF, EventContext.EVENT_CLOSE)};
			}
		}
	}
	
	@Order(3)
	@Face(displayName="예")
	@Available(how=HOW_CHECKOUT)
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] CheckOut() throws Exception{
		Editor editor = new EmptyEditor();
		editor.setId(this.getId());
		ModalWindow modal = new ModalWindow(this);
		modal.setId(this.getId());
//		return new Object[]{new ToEvent(new Editor(), EventContext.EVENT_SAVE),new Remover(new ModalWindow(), true),new Remover(editor, true)};
		return new Object[]{new ToEvent(editor, "checkout"),
			new ToEvent(editor, "destroy"),
			new ToEvent(ServiceMethodContext.TARGET_SELF, EventContext.EVENT_CLOSE)};
	}
	
	@Order(4)
	@Face(displayName="아니오")
	@Available(how={HOW_SAVE,HOW_SAVE_CHECK,HOW_CHECKOUT_SAVE})
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] SaveCencle(){
		Editor editor = new EmptyEditor();
		editor.setId(this.getId());
		if(getMetaworksContext().getHow().equals(HOW_SAVE_CHECK)){
			this.getMetaworksContext().setHow(HOW_CHECKOUT);
			ModalWindow modal = new ModalWindow(this, 400, 200, "checkout");
			this.setMessage("check out?");
			modal.setId(this.getId());
			return new Object[]{new Refresh(modal, true)};
		}else{
			if(getMetaworksContext().getHow().equals(HOW_CHECKOUT_SAVE)){
				return new Object[]{new ToEvent(editor, "checkout"),
						new ToEvent(ServiceMethodContext.TARGET_SELF, EventContext.EVENT_CLOSE)};
			}else{
				return new Object[]{new ToEvent(new EmptyEditor(), "destroy"),
						new ToEvent(ServiceMethodContext.TARGET_SELF, EventContext.EVENT_CLOSE)};
			}
		}
	}
	
	@Order(5)
	@Face(displayName="no")
	@Available(how=HOW_CHECKOUT)
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] CheckOutCencle(){
		Editor editor = new EmptyEditor();
		editor.setId(this.getId());
		return new Object[]{new ToEvent(new EmptyEditor(), "destroy"),
				new ToEvent(ServiceMethodContext.TARGET_SELF, EventContext.EVENT_CLOSE)};
	}
	
	@Order(6)
	@Face(displayName="cancel")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object Cencle(){
		return new ToEvent(ServiceMethodContext.TARGET_SELF, EventContext.EVENT_CLOSE);
	}
}
