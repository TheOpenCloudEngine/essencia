package org.uengine.essencia.resource;

import org.uengine.modeling.resource.IResource;
import org.uengine.modeling.resource.resources.MethodResource;
import org.uengine.modeling.resource.resources.PracticeResource;
import org.uengine.modeling.resource.resources.EssenceProcessResource;

public enum ResourceType {
	PRACTICE_RESOURCE(PracticeResource.class, ".practice"),
	METHOD_RESOURCE(MethodResource.class, ".method"),
	PROCESS_RESOURCE(EssenceProcessResource.class, ".process"),
	REVISION_RESOURCE(RevisionResource.class, ".rev"),
    ESSENCE_RESOURCE(EssenceResource.class, ".xmi"),
	FOLDER_RESOURCE(ContainerResource.class, "folder");
	
	
	private final Class<?> clazz;
		public Class<?> getClazz() {
			return clazz;
		}
	
	private final String type;
		public String getType() {
			return type;
		}
		
	ResourceType(Class<? extends IResource> clazz, String type){
		this.clazz = clazz;
		this.type = type;
	}
}
