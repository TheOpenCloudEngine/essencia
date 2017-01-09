package org.uengine.essencia.portal;

import org.metaworks.ToAppend;
import org.metaworks.ToPrepend;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.dwr.MetaworksRemoteService;
import org.uengine.codi.mw3.model.InstanceList;
import org.uengine.codi.mw3.model.ListWindow;
import org.uengine.codi.mw3.model.Popup;
import org.uengine.essencia.dashboard.Benchmark;

/**
 * Created by jangjinyoung on 2017. 1. 8..
 */
public class ProjectsPanel extends ListWindow{

    @ServiceMethod(eventBinding = ServiceMethod.EVENT_AFTERCALL, bindingFor = "org.uengine.codi.mw3.model.InstanceList.load", target = ServiceMethod.TARGET_POPUP, inContextMenu = true)
    public void loadBenchmarkPanel() throws Exception {
        Benchmark benchmark = new Benchmark();
        MetaworksRemoteService.autowire(benchmark);

        benchmark.setDefaultLoadingInstanceCount(5);
        benchmark.load();

        BootstrapColumn bootstrapColumn = new BootstrapColumn();
        bootstrapColumn.setValue(benchmark);

        MetaworksRemoteService.wrapReturn(new ToPrepend(new InstanceList(), bootstrapColumn));
    }

}
