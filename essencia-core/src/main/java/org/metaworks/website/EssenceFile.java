package org.metaworks.website;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.metaworks.Refresh;
import org.metaworks.Remover;
import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.ModalWindow;
import org.uengine.essencia.designer.ResourceNavigator;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.model.adapter.EssenceXmiAPI;
import org.uengine.essencia.resource.FolderResourceType;
import org.uengine.essencia.resource.ModelResource;
import org.uengine.essencia.resource.Resource;
import org.uengine.util.FileUtil;


public class EssenceFile extends AbstractMetaworksFile {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@AutowiredFromClient
	public ResourceNavigator resourceNavigator;

    private String resourceFolder;

    public String getResourceFolder() {
        return resourceFolder;
    }

    public void setResourceFolder(String resourceFolder) {
        this.resourceFolder = resourceFolder;
    }

    private String resourceType;

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    @Override
	public String overrideUploadPathPrefix() {	
		String uploadPath = Resource.getCodebase() + FolderResourceType.UPLOAD_TEMP_FOLDER.getName() + File.separator;
		FileUtil.createFolders(uploadPath);
		return uploadPath;
	}
	
	@Face(displayName="Improt")
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] importEssence() throws FileNotFoundException, IOException, Exception{
		super.upload();

		EssenceXmiAPI essenceImportable = new EssenceXmiAPI();
		essenceImportable.setXmiPath(overrideUploadPathPrefix() + getUploadedPath());
		PracticeDefinition pd = essenceImportable.importXmi();

        ModelResource resource = (ModelResource) Resource.newInstance(new File(getResourceFolder() + pd.getName().getText() + getResourceType()));
		resource.setPath(getResourceFolder() + pd.getName().getText() + getResourceType());
		resource.saveResource(pd);
		
	    resourceNavigator.load(null);
	    
	    return new Object[]{new Remover(new ModalWindow()), new Refresh(resourceNavigator)};
	}
}