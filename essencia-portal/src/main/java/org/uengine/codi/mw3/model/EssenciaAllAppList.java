package org.uengine.codi.mw3.model;

import org.metaworks.EventContext;
import org.metaworks.Refresh;
import org.metaworks.ServiceMethodContext;
import org.metaworks.ToEvent;
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
    public void showDashboard() throws Exception {

        Benchmark benchmark = new Benchmark();
        MetaworksRemoteService.autowire(benchmark);
        benchmark.load();

        MetaworksRemoteService.wrapReturn(new ModalWindow(benchmark, 700, 700, "Alpha Status Comparison"));
    }
}