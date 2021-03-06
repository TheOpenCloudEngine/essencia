package org.uengine.codi.mw3.model;

import org.metaworks.*;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.dwr.MetaworksRemoteService;
import org.metaworks.widget.ModalWindow;
import org.metaworks.widget.chart.Radar;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.uengine.essencia.dashboard.Benchmark;
import org.uengine.social.SocialBPMAppList;

/**
 * Created by hoo.lim on 6/3/2015.
 */
@Face(ejsPath = "dwr/metaworks/org/uengine/codi/mw3/model/EssenciaAllAppList.ejs")
@Component
@Order(10)
public class EssenciaAllAppList extends SocialBPMAppList {

//    /**
//     * @return11111111
//     * @throws Exception
//     */
//    @ServiceMethod(target = ServiceMethodContext.TARGET_APPEND)
//    public Object[] goEssencia() throws Exception {
//        Loader loader = new Loader();
//        loader.setUserId(session.getUser().getUserId());
//        Essencia essencia = (Essencia) loader.run();
//
//
//        EssenciaApplication application = new EssenciaApplication();
//        application.setEssencia(essencia);
//
//        topPanel.setTopCenterTitle("Composer");
//        return new Object[]{new Refresh(application), new Refresh(topPanel), new ToEvent(ServiceMethodContext.TARGET_SELF, EventContext.EVENT_CLOSE)};
//    }
//
//    @ServiceMethod(target = ServiceMethodContext.TARGET_APPEND)
//    public Object[] goMarketplace() throws Exception {
//        Marketplace essenciaMarketplace = new Marketplace(session);
//
//        topPanel.setTopCenterTitle("Marketplace");
//        return new Object[]{new Refresh(essenciaMarketplace), new Refresh(topPanel), new ToEvent(ServiceMethodContext.TARGET_SELF, EventContext.EVENT_CLOSE)};
//    }


    @ServiceMethod(target=ServiceMethod.TARGET_POPUP)
    public void showCompare() throws Exception {

        Benchmark benchmark = new Benchmark();
        MetaworksRemoteService.autowire(benchmark);
        benchmark.load();

        Popup popup = new Popup();
        popup.setPanel(benchmark);
        popup.setName("Benchmark");
        popup.setHeight(500);
        popup.setWidth(450);
        popup.setAnimate(true);

        MetaworksRemoteService.wrapReturn(popup);

        //MetaworksRemoteService.wrapReturn(new ToPrepend(new InstanceList(), benchmark));
    }

    @ServiceMethod(target= ServiceMethodContext.TARGET_APPEND)
    @Override
    public Object[] goSNS() throws Exception {
        SNS sns = new SNS();
        sns.load(session);
        topPanel.setTopCenterTitle("Workspace");
        return new Object[]{new Refresh(sns), new Refresh(topPanel),
                new ToEvent(ServiceMethodContext.TARGET_SELF, EventContext.EVENT_CLOSE)};
    }

    @ServiceMethod(target= ServiceMethodContext.TARGET_APPEND)
    public Object[] showDashboard() throws Exception {
        SNS sns = MetaworksRemoteService.getComponent(SNS.class);
        sns.load(session);
        topPanel.setTopCenterTitle("Dashboard");
        return new Object[]{new Refresh(sns), new Refresh(topPanel),
                new ToEvent(ServiceMethodContext.TARGET_SELF, EventContext.EVENT_CLOSE)};
    }
}