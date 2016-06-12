package org.uengine.essencia.portal;

import org.metaworks.MetaworksContext;
import org.uengine.codi.mw3.model.ListPanel;
import org.uengine.codi.mw3.model.ProcessMapPanel;
import org.uengine.codi.mw3.model.Session;

/**
 * Created by jangjinyoung on 2016. 6. 11..
 */
public class ProcessExplorer {

    ProcessMapPanel processMapPanel;
    public ProcessMapPanel getProcessMapPanel() {
        return processMapPanel;
    }
    public void setProcessMapPanel(ProcessMapPanel processMapPanel) {
        this.processMapPanel = processMapPanel;
    }


    public ProcessExplorer(Session session) throws Exception {

        processMapPanel = new ProcessMapPanel();
        processMapPanel.setMetaworksContext(new MetaworksContext());
        processMapPanel.load(session);


    }
}
