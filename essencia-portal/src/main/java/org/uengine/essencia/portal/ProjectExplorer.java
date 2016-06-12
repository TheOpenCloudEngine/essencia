package org.uengine.essencia.portal;

import org.metaworks.MetaworksContext;
import org.metaworks.dwr.MetaworksRemoteService;
import org.uengine.codi.mw3.model.*;
import org.uengine.essencia.dashboard.Benchmark;

/**
 * Created by jangjinyoung on 2016. 6. 12..
 */
public class ProjectExplorer {

    public ProjectExplorer(Session session) throws Exception {

        ListWindow listWindow = SNS.createInstanceListWindow(session);
        InstanceList instanceList = ((ListPanel)listWindow.getPanel()).getInstanceListPanel().getInstanceList();

        if(instanceList.getMetaworksContext()==null)
            instanceList.setMetaworksContext(new MetaworksContext());

        instanceList.getMetaworksContext().setWhere("pinterest");

        setInstanceList(instanceList);

        setBenchmark(new Benchmark());
        MetaworksRemoteService.autowire(getBenchmark());
        getBenchmark().load();

    }

    public Benchmark getBenchmark() {
        return benchmark;
    }

    public void setBenchmark(Benchmark benchmark) {
        this.benchmark = benchmark;
    }

    Benchmark benchmark;

    public InstanceList getInstanceList() {
        return instanceList;
    }

    public void setInstanceList(InstanceList instanceList) {
        this.instanceList = instanceList;
    }

    InstanceList instanceList;
}
