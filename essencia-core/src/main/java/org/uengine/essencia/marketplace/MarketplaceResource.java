package org.uengine.essencia.marketplace;

import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.ServiceMethod;
import org.uengine.codi.mw3.model.Popup;
import org.uengine.essencia.resource.ModelResource;

/**
 * Created by soo on 2015. 8. 19..
 */
public class MarketplaceResource {

    public ModelResource modelResource;

    public ModelResource getModelResource() {
        return modelResource;
    }

    public void setModelResource(ModelResource modelResource) {
        this.modelResource = modelResource;
    }

    @ServiceMethod(target = ServiceMethodContext.TARGET_POPUP)
    public Object findResource() {
        Popup popup = new Popup();
        popup.setPanel(new MarketplaceNavigator());
        popup.setName("Choose Resource");

        return popup;
    }

}
