package org.uengine.essencia.resource;

import org.uengine.util.FileUtil;

import java.io.File;

/**
 * Created by manage on 3/4/2015.
 */
public class RepositoryFolderResource extends ContainerResource{

    private static final String historyFile = "history.xml";

    static{
        FileUtil.createFolders(RepositoryFolderResource.getPracticesRepository());
        FileUtil.createFolders(RepositoryFolderResource.getMethodsRepository());
    }

    public RepositoryFolderResource() {
    }

    public RepositoryFolderResource(String path) {
        this();
        setPath(path);
    }

    public static String getHistoryPath() {
        return Resource.getCodebase() + FolderResourceType.REPOSITORY_FOLDER.getName() + File.separator + historyFile;
    }

    public static String getRepositoryFilePath(String resource, int revision){
        return (resource.endsWith(ResourceType.PRACTICE_RESOURCE.getType())?getPracticesRepository():getMethodsRepository()) + resource + "." + revision + ResourceType.REVISION_RESOURCE.getType();
    }

    public static String getPracticesRepository(){
        return Resource.getCodebase() + FolderResourceType.REPOSITORY_FOLDER.getName() + File.separator + FolderResourceType.PRACTICE_FOLDER.getName() + File.separator;
    }

    public static String getMethodsRepository(){
        return Resource.getCodebase() + FolderResourceType.REPOSITORY_FOLDER.getName() + File.separator + FolderResourceType.METHOD_FOLDER.getName() + File.separator;
    }
}
