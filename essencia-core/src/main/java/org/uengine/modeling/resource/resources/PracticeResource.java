package org.uengine.modeling.resource.resources;

import org.uengine.bean.factory.MetaworksSpringBeanFactory;
import org.uengine.essencia.modeling.editor.Editor;
import org.uengine.essencia.modeling.editor.PracticeDefinerEditor;
import org.uengine.essencia.resource.FolderResourceType;
import org.uengine.essencia.resource.ModelResource;
import org.uengine.essencia.resource.RepositoryFolderResource;
import org.uengine.essencia.resource.ResourceType;
import org.uengine.modeling.resource.ResourceManager;

public class PracticeResource extends ModelResource {
	
	public PracticeResource() {
		
	}
	
	public PracticeResource(String path) {
		super(path);
	}

	@Override
	public Editor createEditor() throws Exception {
		PracticeDefinerEditor editor = new PracticeDefinerEditor();
		editor.load(essenciaSession, this);
		
		return editor; 
	}

	@Override
	public void commit() throws Exception {
		super.commit();

		ResourceManager resourceManager = MetaworksSpringBeanFactory.getBean(ResourceManager.class);

		resourceManager.getStorage().copy(this, RepositoryFolderResource.getRepository(FolderResourceType.PRACTICE_FOLDER)
				+ getRecord().getResources()
				+ "." + getRecord().getRevision() + ResourceType.REVISION_RESOURCE.getType());
	}
}
