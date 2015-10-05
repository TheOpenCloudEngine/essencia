package org.uengine.essencia.resource;

import org.metaworks.EventContext;
import org.metaworks.Refresh;
import org.metaworks.Remover;
import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.*;
import org.metaworks.dwr.MetaworksRemoteService;
import org.metaworks.widget.Clipboard;
import org.metaworks.widget.Download;
import org.metaworks.widget.Popup;
import org.uengine.essencia.IUser;
import org.uengine.essencia.Session;
import org.uengine.essencia.common.*;
import org.uengine.essencia.designer.EditorPanel;
import org.uengine.essencia.marketplace.MarketplaceResource;
import org.uengine.essencia.modeling.canvas.EssenciaCanvas;
import org.uengine.essencia.modeling.editor.Editor;
import org.uengine.essencia.resource.element.CompetenciesResource;
import org.uengine.essencia.resource.element.EssenciaResource;
import org.uengine.essencia.resource.element.ThingsToDoResource;
import org.uengine.essencia.resource.element.ThingsToWorkResource;
import org.uengine.modeling.IModel;
import org.uengine.modeling.resource.ResourceManager;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModelResource extends Resource implements IModelResource, Lockable, Commitable {
	
	@AutowiredFromClient
	public EditorPanel editorPanel;

	@AutowiredFromClient
	public Session essenciaSession;

	@AutowiredFromClient
	public org.uengine.codi.mw3.model.Session session;

	@AutowiredFromClient
	public MarketplaceResource marketplaceResource;

	private boolean locked;

    private CommitRecord record;

    @Hidden
    public CommitRecord getRecord() {
        return record;
    }

    @Override
    public void setRecord(CommitRecord record) {
        this.record = record;
    }

    private List<EssenciaResource> childList;

	public ModelResource() {
		setChildList(new ArrayList<EssenciaResource>());
	}

	public ModelResource(String path) {
		this();
		setPath(path);

		update();
	}
	
	private void update(){
		this.locked = (new LockResource(this)).exists();
	}

	@Hidden
	@Available(condition = "metaworksContext.how == 'tree' && metaworksContext.where == 'navigator'")
	@ServiceMethod(mouseBinding = "drag", bindingHidden = true, target = ServiceMethodContext.TARGET_APPEND)
	public Object drag() {
		return new Refresh(new Clipboard(EssenciaCanvas.CANVAS_DROP, this),
				true);
	}

	@Children
	public List<EssenciaResource> getChildList() {
		return childList;
	}

	public void setChildList(List<EssenciaResource> childList) {
		this.childList = childList;
	}

	@Field(descriptor = "container")
	public boolean isContainer() {
		return true;
	}


	public void setContainer(boolean container) {

	}

	@Order(6)
	@Face(displayName = "open")
	@Available(condition = "metaworksContext.how == 'tree' && metaworksContext.where == 'navigator'")
	@ServiceMethod(callByContent = true, except = "children", eventBinding=EventContext.EVENT_DBLCLICK, inContextMenu = true, target=ServiceMethodContext.TARGET_APPEND)
	public Refresh open() throws Exception {
		update();
		editorPanel.setEditor(createEditor());
		
		return new Refresh(editorPanel);
	}

	@Available(condition = "metaworksContext.where == 'marketplaceNavigator'")
	@ServiceMethod(callByContent = true, except = "children", eventBinding=EventContext.EVENT_DBLCLICK, target=ServiceMethodContext.TARGET_APPEND)
	public void selectResource() {
		marketplaceResource.setModelResource(this);
		MetaworksRemoteService.wrapReturn(new Refresh(marketplaceResource), new Remover(new Popup()));
	}

	@Available(condition = "metaworksContext.how == 'tree' && metaworksContext.where == 'navigator'")
	@ServiceMethod(callByContent = true, except = "children", childrenLoader = true, target = ServiceMethodContext.TARGET_APPEND)
	public Refresh expand() throws Exception {

		ThingsToWorkResource alphas = new ThingsToWorkResource(getPath());
		ThingsToDoResource activities = new ThingsToDoResource(getPath());
		CompetenciesResource competencies = new CompetenciesResource(getPath());
		getChildList().add(alphas);
		getChildList().add(activities);
		getChildList().add(competencies);

		return new Refresh(this, false, true);
	}
	
	@Override
	public void rename(String newName){
		LockResource lockResource = new LockResource(this);
		
		super.rename(newName);
		
		if(lockResource.exists())
			lockResource.rename(newName);
	}
	
	@Override
	public void saveResource(IModel model) throws Exception {
		Resource.saveToStorage(this,model);
	}

	@Override
	public IModel loadModel() throws Exception {
		try {
			ResourceManager resourceManager = MetaworksRemoteService.getComponent(ResourceManager.class);
			IModel model =  (IModel)resourceManager.getStorage().getObject(this);

			return model;
		} catch (Exception e) {
			throw new Exception("Can't open " + getName() + " due to: ", e);
		}

	}

	@Override
	public Editor createEditor() throws Exception {
		return null;
	}

	@Override
	public boolean isLocked() {
		return this.locked;
	}
	public void setLocked(boolean locked){
		this.locked = locked;
	}
	
	@Override
	public void lock(IUser user) throws Exception {
		LockResource lockResource = new LockResource(this);
		lockResource.write(new LockInfo(user, new Date()));
		
		this.locked = true;
	}

	@Override
	public void unlock(IUser user) throws Exception {
		LockResource lockResource = new LockResource(this);		
		lockResource.delete(user);

		this.locked = false;
	}

	@Available(condition="!locked && metaworksContext.where != 'marketplaceNavigator'")
	@ServiceMethod(callByContent=true, inContextMenu=true)
	public void checkOut() throws Exception {
		this.lock(essenciaSession.getUser());
	}

	@Available(condition = "locked && metaworksContext.where != 'marketplaceNavigator'")
	@ServiceMethod(callByContent = true, inContextMenu = true)
	public void checkIn() throws Exception {
		this.unlock(essenciaSession.getUser());
	}

    public void commit() throws Exception {
		CommitHistory commitHistory = CommitHistory.load();
		commitHistory.addRecord(getRecord());
		commitHistory.save();
    }
}
