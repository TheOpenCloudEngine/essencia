package org.uengine.codi.mw3.model;

import org.metaworks.EventContext;
import org.metaworks.Refresh;
import org.metaworks.ServiceMethodContext;
import org.metaworks.ToEvent;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.ServiceMethod;
import org.uengine.codi.mw3.marketplace.Marketplace;
import org.uengine.essencia.Essencia;
import org.uengine.essencia.Loader;

/**
 * Created by hoo.lim on 6/3/2015.
 */
@Face(ejsPath = "dwr/metaworks/org/uengine/codi/mw3/model/EssenciaAllAppList.ejs")
public class EssenciaAllAppList extends AllAppList {

    /**
     * @return11111111
     * @throws Exception
     */
    @ServiceMethod(target = ServiceMethodContext.TARGET_APPEND)
    public Object[] goEssencia() throws Exception {
        Loader loader = new Loader();
        loader.setUserId(session.getUser().getUserId());
        Essencia essencia = (Essencia) loader.run();

        
        EssenciaApplication application = new EssenciaApplication();
        application.setEssencia(essencia);

        topPanel.setTopCenterTitle("Composer");
        return new Object[]{new Refresh(application), new Refresh(topPanel), new ToEvent(ServiceMethodContext.TARGET_SELF, EventContext.EVENT_CLOSE)};
    }

    @ServiceMethod(target = ServiceMethodContext.TARGET_APPEND)
    public Object[] goMarketplace() throws Exception {
        Marketplace essenciaMarketplace = new Marketplace(session);

        topPanel.setTopCenterTitle("Marketplace");
        return new Object[]{new Refresh(essenciaMarketplace), new Refresh(topPanel), new ToEvent(ServiceMethodContext.TARGET_SELF, EventContext.EVENT_CLOSE)};
    }
}