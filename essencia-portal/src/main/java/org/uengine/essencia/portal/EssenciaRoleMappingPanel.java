package org.uengine.essencia.portal;

import org.metaworks.AllChildFacesAreIgnored;
import org.metaworks.MetaworksContext;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.dao.TransactionContext;
import org.metaworks.dwr.MetaworksRemoteService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.uengine.codi.mw3.model.RoleMappingPanel;
import org.uengine.essencia.enactment.EssenceProcessDefinition;
import org.uengine.essencia.model.Practice;
import org.uengine.essencia.modeling.canvas.MethodCanvas;
import org.uengine.essencia.modeling.modeler.MethodComposer;
import org.uengine.kernel.ProcessDefinition;
import org.uengine.modeling.modeler.ProcessCanvas;
import org.uengine.modeling.modeler.ProcessModeler;
import org.uengine.modeling.resource.VersionManager;
import org.uengine.social.ElementViewActionDelegateForInstanceMonitoring;

import java.util.List;

/**
 * Created by jjy on 2016. 6. 13..
 */

@Component
@Scope("prototype")
public class EssenciaRoleMappingPanel extends RoleMappingPanel{

    String practiceName;

        public String getPracticeName() {
            return practiceName;
        }

        public void setPracticeName(String practiceName) {
            this.practiceName = practiceName;
        }

    String practiceDescription;
        public String getPracticeDescription() {
            return practiceDescription;
        }

        public void setPracticeDescription(String practiceDescription) {
            this.practiceDescription = practiceDescription;
        }

    String practiceBriefDescription;

        public String getPracticeBriefDescription() {
            return practiceBriefDescription;
        }

        public void setPracticeBriefDescription(String practiceBriefDescription) {
            this.practiceBriefDescription = practiceBriefDescription;
        }


    MethodComposer methodView;
    @Face(faceClass= AllChildFacesAreIgnored.class)
        public MethodComposer getMethodView() {
            return methodView;
        }
        public void setMethodView(MethodComposer methodView) {
            this.methodView = methodView;
        }


    @Override
    public void load(String defId_) throws Exception {
        super.load(defId_);

        VersionManager versionManager = org.metaworks.dwr.MetaworksRemoteService.getComponent(VersionManager.class);
        versionManager.setAppName("codi");

        defId_ = versionManager.getProductionResourcePath(defId_);

        if(!defId_.endsWith(".method")) return;

        methodView = new MethodComposer();
        MetaworksRemoteService.autowire(methodView);

        methodView.setPalette(null);

        EssenceProcessDefinition essenceProcessDefinition = (EssenceProcessDefinition) processManager.getProcessDefinition(defId_);

        methodView.setModel(essenceProcessDefinition.getPracticeDefinition().shallowCopy());
        methodView.setElementViewActionDelegate(MetaworksRemoteService.getComponent(ElementViewActionDelegateForInstanceMonitoring.class));


        List<Practice> practices = essenceProcessDefinition.getPracticeDefinition().getElements(Practice.class);

        if(practices.size() > 0){
            Practice practice = practices.get(0);
            setPracticeName(practice.getName());
            setPracticeBriefDescription(practice.getBriefDescription());
            setPracticeDescription(practice.getDescription());
        }else{
            setPracticeName(essenceProcessDefinition.getName());
            setPracticeBriefDescription(essenceProcessDefinition.getShortDescription());
        }

        //TransactionContext.getThreadLocalInstance().setMW3FaceOptionEnabled(false);
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
