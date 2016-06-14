package org.uengine.essencia.portal;

import org.metaworks.MetaworksContext;
import org.metaworks.dwr.MetaworksRemoteService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.uengine.codi.mw3.model.RoleMappingPanel;
import org.uengine.essencia.enactment.EssenceProcessDefinition;
import org.uengine.essencia.modeling.modeler.MethodComposer;
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
    public void load(String defId) throws Exception {
        super.load(defId);

        defId = VersionManager.getProductionResourcePath("codi", defId);

        if(!defId.endsWith(".method")) return;

        methodView = new MethodComposer();
        MetaworksRemoteService.autowire(methodView);

        methodView.setPalette(null);

        EssenceProcessDefinition essenceProcessDefinition = (EssenceProcessDefinition) processManager.getProcessDefinition(defId);

        methodView.setModel(essenceProcessDefinition.getPracticeDefinition());
        methodView.setElementViewActionDelegate(MetaworksRemoteService.getComponent(ElementViewActionDelegateForInstanceMonitoring.class));

    }
}
