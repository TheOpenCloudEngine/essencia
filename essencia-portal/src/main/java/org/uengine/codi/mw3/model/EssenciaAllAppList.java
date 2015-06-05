package org.uengine.codi.mw3.model;

import org.metaworks.*;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.ServiceMethod;
import org.uengine.codi.mw3.widget.IFrame;
import org.uengine.essencia.Essencia;
import org.uengine.essencia.Loader;

/**
 * Created by hoo.lim on 6/3/2015.
 */
@Face(ejsPath = "dwr/metaworks/org/uengine/codi/mw3/model/EssenciaAllAppList.ejs")
public class EssenciaAllAppList extends AbstractAllAppList{
    @Override
    public void load() throws Exception{
    }

    @ServiceMethod(target= ServiceMethodContext.TARGET_APPEND)
    public Object[] goEssencia() throws Exception {
        Loader loader = new Loader();
        loader.setUserId(session.getUser().getUserId());
        Essencia essencia = (Essencia) loader.run();

        EssenciaApplication application = new EssenciaApplication();
        application.setEssencia(essencia);
        return new Object[]{new Refresh(application), new Refresh(application.loadTopCenterPanel(session)), new ToEvent(ServiceMethodContext.TARGET_SELF, EventContext.EVENT_CLOSE)};
    }

    @ServiceMethod(target= ServiceMethodContext.TARGET_APPEND)
    public Object[] goBaidu() throws Exception {
        IFrame iframe = new IFrame("http://www.baidu.com/");

        IKFrameApplication application = new IKFrameApplication();
        application.setContent(iframe);

        return new Object[]{new Refresh(application), new Refresh(application.loadTopCenterPanel(session)), new ToEvent(ServiceMethodContext.TARGET_SELF, EventContext.EVENT_CLOSE)};
    }

}