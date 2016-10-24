package org.uengine.web.process;

import org.metaworks.ContextAware;
import org.metaworks.MetaworksContext;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.dwr.MetaworksRemoteService;
import org.oce.garuda.multitenancy.TenantContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.uengine.codi.mw3.model.*;
import org.uengine.kernel.NoSuchProcessDefinitionException;
import org.uengine.kernel.ProcessDefinition;
import org.uengine.kernel.Role;
import org.uengine.modeling.modeler.ProcessCanvas;
import org.uengine.modeling.modeler.ProcessModeler;
import org.uengine.modeling.resource.VersionManager;
import org.uengine.processmanager.ProcessManagerRemote;
import org.uengine.social.ElementViewActionDelegateForInstanceMonitoring;

import java.util.ArrayList;

public class ProcessMapPanel implements ContextAware {

    MetaworksContext metaworksContext;

    public MetaworksContext getMetaworksContext() {
        return metaworksContext;
    }

    public void setMetaworksContext(MetaworksContext metaworksContext) {
        this.metaworksContext = metaworksContext;
    }

    public ProcessMapPanel() {

    }
    @Autowired
    public ProcessManagerRemote processManager;

    @AutowiredFromClient
    public Session session;

    ProcessModeler processView;

    public ProcessModeler getProcessView() {
        return processView;
    }

    public void setProcessView(ProcessModeler processView) {
        this.processView = processView;
    }

    String defId;

    @Hidden
    public String getDefId() {
        return defId;
    }

    public void setDefId(String defId) {
        this.defId = defId;
    }

    String jiraTenant;

    @Hidden
    public String getJiraTenant() {
        return jiraTenant;
    }

    public void setJiraTenant(String jiraTenant) {
        this.jiraTenant = jiraTenant;
    }

    @ServiceMethod(callByContent = true)
    public ProcessModeler loadJira() throws Exception {

        new TenantContext(this.getJiraTenant());

        VersionManager versionManager = org.metaworks.dwr.MetaworksRemoteService.getComponent(VersionManager.class);
        versionManager.setAppName("codi");
        String defId = versionManager.getProductionResourcePath(this.getDefId());

        if (defId == null)
            throw new NoSuchProcessDefinitionException();

        ProcessDefinition definition = processManager.getProcessDefinition(defId);

        {//setting process view
            ProcessModeler processModeler = new ProcessModeler();
            processModeler.setPalette(null);

            ((ProcessCanvas) processModeler.getCanvas()).setMetaworksContext(new MetaworksContext());
            ((ProcessCanvas) processModeler.getCanvas()).getMetaworksContext().setWhen("monitor");
            setProcessView(processModeler);

            getProcessView().setModel(definition);
            getProcessView().setElementViewActionDelegate(MetaworksRemoteService.getComponent(ElementViewActionDelegateForInstanceMonitoring.class));

        }
        return this.getProcessView();
    }
}

