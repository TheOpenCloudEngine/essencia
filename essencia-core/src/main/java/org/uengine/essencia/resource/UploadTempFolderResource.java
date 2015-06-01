package org.uengine.essencia.resource;

/**
 * Created by manage on 3/4/2015.
 */
public class UploadTempFolderResource extends ContainerResource{
    public UploadTempFolderResource(){

    }

    public UploadTempFolderResource(String path) {
        this();
        setPath(path);
    }
}
