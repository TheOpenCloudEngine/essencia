package org.uengine.essencia.modeling.editor;

import java.io.File;
import java.util.List;

import org.metaworks.MetaworksContext;
import org.metaworks.Refresh;
import org.metaworks.ServiceMethodContext;
import org.metaworks.ToEvent;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.Available;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.Id;
import org.metaworks.annotation.Name;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.Download;
import org.metaworks.widget.ModalWindow;
import org.uengine.ConfirmPanel;
import org.uengine.essencia.IUser;
import org.uengine.essencia.Session;
import org.uengine.essencia.common.CommitRecord;
import org.uengine.essencia.common.Commitable;
import org.uengine.essencia.common.LockInfo;
import org.uengine.essencia.common.Lockable;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.context.EssenciaEventContext;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.modeling.modeler.MethodComposer;
import org.uengine.essencia.resource.ExportResource;
import org.uengine.essencia.resource.IModelResource;
import org.uengine.essencia.resource.LockResource;
import org.uengine.essencia.util.ElementUtil;
import org.uengine.kernel.ProcessDefinition;
import org.uengine.kernel.UEngineException;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.IModel;
import org.uengine.modeling.IResource;

public abstract class EssenciaEditor extends CompositeEditor {

	@AutowiredFromClient
	public Session session;
	
	private EditorMenu menu;
	
	public EssenciaEditor() {
		super();
	}

	public EssenciaEditor(IResource resource) throws Exception {
		this();
		
		getMetaworksContext().setWhen(MetaworksContext.WHEN_NEW);
		
		loadNewEditor(resource);
	}
	
	public void loadNewEditor(IResource resource) throws Exception {
		setMenu(new EditorMenu());
		setResource(resource);

		setChanged(true);
		
		super.load();
	}
	
	public void load(Session session, IResource resource) throws Exception {
		processContext(resource, session.getUser());
		setChanged(true);
		
		loadNewEditor(resource);		
		setChanged(false);
	}
	
	private void processContext(IResource resource, IUser user) {
		getMetaworksContext().setWhen(MetaworksContext.WHEN_VIEW);
		
		if(resource instanceof Lockable)
			processContextForLock(resource, user);
	}
	
	private void processContextForLock(IResource resource, IUser user) {
		if(!((Lockable)resource).isLocked())
			return;
		
		getMetaworksContext().setWhen(EssenciaContext.WHEN_VIEW_LOCK);
		
		LockResource lockResource = new LockResource(resource);
		if(lockResource.confirmLocker(user))
			getMetaworksContext().setWhen(MetaworksContext.WHEN_EDIT);
	}
	
	@ServiceMethod(callByContent = true, eventBinding = EditorContext.CHECK_OUT, target = ServiceMethodContext.TARGET_APPEND)
	public Object[] checkOut() throws Exception {
		if(getResource() instanceof Lockable){
			((Lockable)getResource()).lock(session.getUser());
			
			load(session, getResource());
			
			return new Object[] { new Refresh(this, false, true) };
		}
		
		return null;
	}

	@ServiceMethod(callByContent = true, target = ServiceMethodContext.TARGET_APPEND)
	public Object[] checkIn() throws Exception {
		if(getResource() instanceof Lockable){
			((Lockable)getResource()).unlock(session.getUser());
			
			load(session, getResource());
			
			return new Object[] { new Refresh(this, false, true) };
		}

		return null;
	}
	
	@ServiceMethod(payload="resource", eventBinding = EditorContext.LOCK_INFO, target = ServiceMethodContext.TARGET_POPUP)
	public ModalWindow lockInfo() throws Exception {
		if(getResource() instanceof Lockable){
			LockResource lockResource = new LockResource(this.getResource());
			LockInfo lockInfo = lockResource.getLockInfo();

			return new ModalWindow(lockInfo, 400, 300, "Lock Info");
		}

		return null;
	}

	public Download exportXmi()throws Exception{
		IResource resouce = getResource();
		Download download = null;
		if(resouce instanceof IModelResource){
			ExportResource es = new ExportResource((IModelResource) resouce);
			download = es.exportXmi();
		}
		return download;
	}
	
	@ServiceMethod(callByContent = true, target = ServiceMethodContext.TARGET_APPEND)
	@Override
	public void save() throws Exception {
		validate();
		
		rename();
//		processNewResource(getResource(), session.getUser());

		super.save();
		
//		commit();
	}

    private void commit()throws Exception{
        if(getResource() instanceof Commitable){
            CommitRecord record = new CommitRecord();
            record.setResources(getResource().getName());
            record.setAuthor(session.getUser().getEmpName());

            Commitable commitable = (Commitable)getResource();
            commitable.setRecord(record);
            commitable.commit();
        }
    }

	
	@Available(condition="saveable")
	@ServiceMethod(callByContent = true, eventBinding = EditorContext.SAVE, target = ServiceMethodContext.TARGET_APPEND)
	public Object[] saveAndRefresh() throws Exception {
		try {
			this.save();
		} catch (UEngineException ue) {
			return new Object[] { new ModalWindow(new ConfirmPanel(ConfirmPanel.DUPLICATED, ue.getMessage()), 300, 200) };
		}
		
		load(session, getResource());
		
		return new Object[] { 
				new ToEvent(getResource().getParent(), EssenciaEventContext.REFRESH, true), 
				new Refresh(this, false, true)
		};
	}
	
	@ServiceMethod(callByContent = true, target = ServiceMethodContext.TARGET_APPEND)
	public Object[] saveAndCheckIn() throws Exception {
		this.save();
		return this.checkIn();
	}
	
	private void processNewResource(IResource resource, IUser user) throws Exception {
		if(MetaworksContext.WHEN_NEW.equals(getMetaworksContext().getWhen())){
			resource.getMetaworksContext().setWhen(MetaworksContext.WHEN_EDIT);
		
			processNewResourceForLock(resource, user);
		}
	}
	
	private void processNewResourceForLock(IResource resource, IUser user) throws Exception {
		if(resource instanceof Lockable)
			((Lockable)resource).lock(user);
	}
	
	private void rename() throws Exception {
		renameResource();
		renameChildResource();
	}
	
	private void renameResource() throws Exception {
		try {
			getResource().rename(getEssenciaModelerEditor().getAlias());
		} catch (Exception e) {
			throw new Exception("rename failed.", e);
		}
	}

	private void renameChildResource() {
		for (Editor editor : getItems()) {
			editor.getResource().rename(getResource().getDisplayName());
		}
	}

	@Override
	public boolean validate() throws Exception {
		String name = getEssenciaModelerEditor().getAlias();

		String sourceName = "";
		if(name.startsWith(File.separator)){
			sourceName = name.substring(name.lastIndexOf(File.separator) + 1, name.lastIndexOf("."));
		} else {
			sourceName = name;
		}
		if("".equals(sourceName.trim())){
			throw new UEngineException("name is required, please fill it");
		} 

		String regex = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
		String targetName = sourceName.replaceAll(regex, " ");
		
		if(!(sourceName.equals(targetName))){
			throw new UEngineException("can not use special character in name");
		}

		return true;
	}
		
	@Hidden
	@ServiceMethod(callByContent=true, eventBinding="sync", bindingHidden=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object sync(){
		List<ElementView> elementViewList = null;
		
		try {
			PracticeDefinition practiceDefinition = ( (MethodComposer)getEssenciaModelerEditor().getModeler() ).createPracticeDefinition();

			ProcessDefinition processDefinition = practiceDefinition.toProcessDefinition();
			getProcessModelerEditor().getModeler().setModel(processDefinition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new Refresh(getProcessModelerEditor());
	}

	private EssenciaModelerEditor getEssenciaModelerEditor() {
		return ((EssenciaModelerEditor) getItems().get(0));
	}

	private ProcessModelerEditor getProcessModelerEditor() {
		return ((ProcessModelerEditor) getItems().get(1));
	}

	@Override
	@Name
	@Id 
	public IResource getResource(){
		return super.getResource();
	}
	
	public EditorMenu getMenu() {
		return menu;
	}
	public void setMenu(EditorMenu menu) {
		this.menu = menu;
	}
}
