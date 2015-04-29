package org.uengine.essencia.resource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.metaworks.EventContext;
import org.metaworks.Refresh;
import org.metaworks.ServiceMethodContext;
import org.metaworks.ToAppend;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.Available;
import org.metaworks.annotation.Children;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Field;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.Order;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.Clipboard;
import org.uengine.essencia.IUser;
import org.uengine.essencia.Session;
import org.uengine.essencia.common.*;
import org.uengine.essencia.modeling.canvas.EssenciaCanvas;
import org.uengine.essencia.modeling.editor.Editor;
import org.uengine.essencia.modeling.editor.EditorTabs;
import org.uengine.essencia.repository.ObjectRepository;
import org.uengine.essencia.resource.element.CompetenciesResource;
import org.uengine.essencia.resource.element.EssenciaResource;
import org.uengine.essencia.resource.element.ThingsToDoResource;
import org.uengine.essencia.resource.element.ThingsToWorkResource;
import org.uengine.modeling.IModel;
import org.uengine.util.FileUtil;

import javax.xml.bind.JAXBException;

public class ModelResource extends Resource implements IModelResource, Lockable, Commitable {

	@AutowiredFromClient
	public Session session;

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
	@ServiceMethod(callByContent = true, except = "children", eventBinding=EventContext.EVENT_DBLCLICK, inContextMenu = true, target = ServiceMethodContext.TARGET_APPEND)
	public Object open() throws Exception {
		update();
		
		return new ToAppend(new EditorTabs(), createEditor());

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

		return new Refresh(this, true, true);
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
		ObjectRepository.getInstance().put(this, model);
	}

	@Override
	public IModel loadModel() throws Exception {
		try {
			return (IModel) ObjectRepository.getInstance().get(this);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
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

	@Available(condition="!locked")
	@ServiceMethod(callByContent=true, inContextMenu=true)
	public void checkOut() throws Exception {
		this.lock(session.getUser());
	}

	@Available(condition = "locked")
	@ServiceMethod(callByContent = true, inContextMenu = true)
	public void checkIn() throws Exception {
		this.unlock(session.getUser());
	}

    public void commit() throws Exception {
        CommitUtils.serializeRecord(record);

        if(record.getResources().endsWith(ResourceType.PRACTICE_RESOURCE.getType())){
            File source = new File(Resource.getCodebase() + FolderResourceType.PRACTICE_FOLDER.getName() + File.separator + record.getResources());
            File dest = new File(RepositoryFolderResource.getRepositoryFilePath(record.getResources(), record.getRevision()));
            FileUtil.copyFile(source, dest);
        }else{
            File source = new File(Resource.getCodebase() + FolderResourceType.METHOD_FOLDER.getName() + File.separator + record.getResources());
            File dest = new File(RepositoryFolderResource.getRepositoryFilePath(record.getResources(), record.getRevision()));
            FileUtil.copyFile(source, dest);

            String resource = record.getResources().replaceFirst(ResourceType.METHOD_RESOURCE.getType(), ResourceType.PROCESS_RESOURCE.getType());
            source = new File(Resource.getCodebase() + FolderResourceType.METHOD_FOLDER.getName() + File.separator + resource);
            dest = new File(RepositoryFolderResource.getRepositoryFilePath(resource, record.getRevision()));
            FileUtil.copyFile(source, dest);
        }
    }
}
