package org.uengine.essencia.resource;

import org.uengine.util.FileUtil;

import java.io.File;

/**
 * Created by manage on 3/4/2015.
 */
public class RepositoryFolderResource extends ContainerResource{

    private static final String historyFile = "repository.history";

    public RepositoryFolderResource() {
    }

    public RepositoryFolderResource(String path) {
        this();
        setPath(path);
    }

    public static String getHistoryPath() {
        return FolderResourceType.REPOSITORY_FOLDER.getName() + File.separator + historyFile;
    }

    public static String getPracticesRepository(){
        return FolderResourceType.REPOSITORY_FOLDER.getName() + File.separator + FolderResourceType.PRACTICE_FOLDER.getName() + File.separator;
    }

    public static String getMethodsRepository(){
        return FolderResourceType.REPOSITORY_FOLDER.getName() + File.separator + FolderResourceType.METHOD_FOLDER.getName() + File.separator;
    }
}
