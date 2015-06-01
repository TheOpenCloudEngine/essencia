package org.uengine;

import org.metaworks.ContextAware;
import org.metaworks.MetaworksContext;
import org.metaworks.Remover;
import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.Available;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.Order;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.ModalWindow;
import org.uengine.essencia.resource.Resource;

@Face(ejsPath="dwr/metaworks/genericfaces/FormFace.ejs")
public class ConfirmPanel implements ContextAware{
	public static final String FOLDER    		= "folder";
	public static final String PROCESS			= "process";
	public static final String DUPLICATED		= "duplicated";
	public static final String ETC_ERROR		= "etc";
	
	MetaworksContext metaworksContext;
		public MetaworksContext getMetaworksContext() {
			return metaworksContext;
		}
		public void setMetaworksContext(MetaworksContext metaworksContext) {
			this.metaworksContext = metaworksContext;
		}

	String message;
	@Order(3)
	@Face(displayName="Message")
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
	Resource resource;
	@Hidden
	public Resource getResource() {
			return resource;
		}
		public void setResource(Resource resource) {
			this.resource = resource;
		}
		
	public ConfirmPanel(){
		this.setMetaworksContext(new MetaworksContext());
	}
	
	public ConfirmPanel(String context, String message){
		this();
		
		this.getMetaworksContext().setHow(context);
		this.setMessage(message);
	}
	
	public ConfirmPanel(Resource resource){
		this();
		this.setResource(resource);
	}
	
	@Order(5)
	@Face(displayName="Delete")
	@Available(condition="metaworksContext.how != 'folder' && metaworksContext.how !='lock' && metaworksContext.how !='duplicated' && metaworksContext.how !='etc'")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] delete(){
		try {
			resource.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Object[]{new Remover(new ModalWindow(), true), new Remover(resource)};
	}

	@Order(6)
	@Face(displayName="Cancel")
	@Available(condition="metaworksContext.how != 'duplicated'")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object cancelPopup(){
		return new Remover(new ModalWindow(), true);
	}
	@Order(6)
	@Face(displayName="Confirm")
	@Available(how=DUPLICATED)
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object cancelModal(){
		return new Remover(new ModalWindow(), true);
	}
	
}
