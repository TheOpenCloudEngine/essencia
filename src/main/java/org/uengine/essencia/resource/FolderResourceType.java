package org.uengine.essencia.resource;

import org.uengine.modeling.IContainer;

public enum FolderResourceType {
	PRACTICE_FOLDER(PracticeFolderResource.class, new ResourceType[]{ResourceType.PRACTICE_RESOURCE}, "Practices"),
	METHOD_FOLDER(MethodFolderResource.class, new ResourceType[]{ResourceType.METHOD_RESOURCE}, "Methods"),
    REPOSITORY_FOLDER(RepositoryFolderResource.class, new ResourceType[]{ResourceType.REVISION_RESOURCE}, "Repository"),
    UPLOAD_TEMP_FOLDER(UploadTempFolderResource.class, new ResourceType[]{ResourceType.ESSENCE_RESOURCE}, "UploadTemp"),
    DOWNLOAD_TEMP_FOLDER(DownloadTempFolderResource.class, new ResourceType[]{ResourceType.ESSENCE_RESOURCE}, "DownloadTemp");

	private final Class<?> clazz;
		public Class<?> getClazz() {
			return clazz;
		}
	
	private final ResourceType[] displayResources;
		public ResourceType[] getDisplayResources() {
			return displayResources;
		}
		
	private final String name;
		public String getName() {
			return name;
		}


	FolderResourceType(Class<? extends IContainer> clazz, ResourceType[] displayResources, String name){
		this.clazz = clazz;
		this.displayResources = displayResources;
		this.name = name;
	}
	
}
