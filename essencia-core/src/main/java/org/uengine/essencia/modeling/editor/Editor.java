package org.uengine.essencia.modeling.editor;

import org.metaworks.ContextAware;
import org.metaworks.MetaworksContext;
import org.metaworks.annotation.Id;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.modeling.resource.IResource;

public abstract class Editor implements ContextAware {

	private String id;
	private IResource resource;
	private boolean saveable = true;
	private boolean changed = false;
	private MetaworksContext metaworksContext;

	public Editor(){
		ContextUtil.setWhen(this, EssenciaContext.WHEN_VIEW);
	}
	
	@Id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public IResource getResource(){
		return this.resource;
	}
	public void setResource(IResource resource){
		this.resource = resource;
	}

	public boolean isSaveable() {
		return saveable;
	}
	public void setSaveable(boolean saveable) {
		this.saveable = saveable;
	}

	public boolean isChanged() {
		return changed;
	}
	public void setChanged(boolean changed) {
		this.changed = changed;
	}

	@Override
	public MetaworksContext getMetaworksContext() {
		return metaworksContext;
	}
	@Override
	public void setMetaworksContext(MetaworksContext metaworksContext) {
		this.metaworksContext = metaworksContext;
	}

	public abstract void load() throws Exception;
	public abstract void save() throws Exception;
	public abstract boolean validate() throws Exception;
}
