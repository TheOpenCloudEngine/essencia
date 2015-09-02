package org.uengine.essencia.marketplace;

import org.uengine.essencia.designer.ResourceNavigator;
import org.uengine.essencia.resource.FolderResourceType;
import org.uengine.essencia.resource.Resource;
import org.uengine.modeling.resource.IContainer;

import java.io.File;

/**
 * Created by soo on 2015. 8. 19..
 */
public class MarketplaceNavigator extends ResourceNavigator {

    public MarketplaceNavigator() {
        this.load();
    }


    public void load() {

        IContainer practiceResource = (IContainer) Resource.newPracticeFolderResource(File.separator.concat(FolderResourceType.PRACTICE_FOLDER.getName()));
        practiceResource.getMetaworksContext().setWhere("marketplaceNavigator");
        try {
            practiceResource.setChildren(practiceResource.list());
        } catch (Exception e) {
            e.printStackTrace();
        }

        IContainer methodResource = (IContainer) Resource.newMethodFolderResource(File.separator.concat(FolderResourceType.METHOD_FOLDER.getName()));
        methodResource.getMetaworksContext().setWhere("marketplaceNavigator");
        try {
            methodResource.setChildren(methodResource.list());
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setPracticeResource(practiceResource);
        this.setMethodResource(methodResource);

    }
}
