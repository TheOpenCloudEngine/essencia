package org.uengine.essencia.resource;

/**
 * Created by manage on 3/4/2015.
 */
public class DownloadTempFolderResource extends ContainerResource{
    public DownloadTempFolderResource(){

    }

    public DownloadTempFolderResource(String path) {
        this();
        setPath(path);
    }
}
