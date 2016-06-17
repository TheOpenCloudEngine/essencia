package org.uengine.essencia.portal;

import org.metaworks.MetaworksContext;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.dwr.MetaworksRemoteService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.uengine.codi.mw3.model.RoleMappingPanel;
import org.uengine.essencia.enactment.EssenceProcessDefinition;
import org.uengine.essencia.modeling.modeler.MethodComposer;
import org.uengine.kernel.ProcessDefinition;
import org.uengine.modeling.modeler.ProcessCanvas;
import org.uengine.modeling.modeler.ProcessModeler;
import org.uengine.modeling.resource.VersionManager;
import org.uengine.social.ElementViewActionDelegateForInstanceMonitoring;

/**
 * Created by jjy on 2016. 6. 13..
 */

@Component
@Scope("prototype")
public class EssenciaRoleMappingPanel extends RoleMappingPanel{

    MethodComposer methodView;
        public MethodComposer getMethodView() {
            return methodView;
        }
        public void setMethodView(MethodComposer methodView) {
            this.methodView = methodView;
        }


    @Override
    public void load(String defId_) throws Exception {
        super.load(defId_);

        defId_ = VersionManager.getProductionResourcePath("codi", defId_);

        if(!defId_.endsWith(".method")) return;

        methodView = new MethodComposer();
        MetaworksRemoteService.autowire(methodView);

        methodView.setPalette(null);

        EssenceProcessDefinition essenceProcessDefinition = (EssenceProcessDefinition) processManager.getProcessDefinition(defId_);

        methodView.setModel(essenceProcessDefinition.getPracticeDefinition());
        methodView.setElementViewActionDelegate(MetaworksRemoteService.getComponent(ElementViewActionDelegateForInstanceMonitoring.class));

    }

    @Override
    protected void installProcessView(ProcessDefinition definition) throws Exception {
        //do not install process view.
        if(getMetaworksContext()==null || "behavioral".equals(getMetaworksContext().getWhen()))
            super.installProcessView(definition);

    }

    @ServiceMethod()
    public void behavioralView() throws Exception {
        super.load(getDefId());

        setMetaworksContext(new MetaworksContext());
        getMetaworksContext().setWhen(MetaworksContext.WHEN_EDIT);
        getMetaworksContext().setHow("behavioral");
    }

    @ServiceMethod()
    public void structuralView() throws Exception {
        load(getDefId());

        setMetaworksContext(new MetaworksContext());
        getMetaworksContext().setWhen(MetaworksContext.WHEN_EDIT);
        getMetaworksContext().setHow("structural");

    }
}
