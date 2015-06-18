package org.uengine.codi.mw3.model;

import org.metaworks.*;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.ServiceMethod;
import org.uengine.codi.mw3.admin.TopPanel;
import org.uengine.codi.mw3.widget.IFrame;
import org.uengine.essencia.Essencia;
import org.uengine.essencia.Loader;

/**
 * Created by hoo.lim on 6/3/2015.
 */
@Face(ejsPath = "dwr/metaworks/org/uengine/codi/mw3/model/EssenciaAllAppList.ejs")
public class EssenciaAllAppList extends AbstractAllAppList {
    @AutowiredFromClient
    public TopPanel topPanel;

    @Override
    public void load() throws Exception {
    }

    @Override
    public Object[] goSNS() throws Exception {
        SNS sns = new SNS(session);
        topPanel.setTopCenterTitle(getSnsAppName());
        return new Object[]{new Refresh(sns), new Refresh(topPanel),
                new ToEvent(ServiceMethodContext.TARGET_SELF, EventContext.EVENT_CLOSE)};
    }

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

        topPanel.setTopCenterTitle(getEssenciaAppName());
        return new Object[]{new Refresh(application), new Refresh(topPanel), new ToEvent(ServiceMethodContext.TARGET_SELF, EventContext.EVENT_CLOSE)};
    }

    String snsAppName;

    public String getSnsAppName() {
        return "Workspace";
    }

    public void setSnsAppName(String snsAppName) {
        this.snsAppName = snsAppName;
    }

    String essenciaAppName;

    public String getEssenciaAppName() {
        return "Practice Composer";
    }

    public void setEssenciaAppName(String essenciaAppName) {
        this.essenciaAppName = essenciaAppName;
    }
}