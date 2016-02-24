package org.uengine.essencia.portal;

import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.dwr.MetaworksRemoteService;
import org.metaworks.widget.ModalWindow;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.uengine.codi.mw3.model.InstanceView;
import org.uengine.codi.mw3.model.InstanceViewDetail;
import org.uengine.essencia.enactment.EssenceProcessDefinition;
import org.uengine.essencia.enactment.GameBoard;
import org.uengine.kernel.ProcessInstance;
import org.uengine.social.InstanceMonitorPanel;
import org.uengine.social.SocialBPMInstanceTooltip;

@Scope("prototype")
@Component
public class EssenciaInstanceTooltip extends SocialBPMInstanceTooltip{
    public EssenciaInstanceTooltip() throws Exception {
        super();
    }

    @ServiceMethod(callByContent=true)
    public InstanceViewDetail workItems() throws Exception{

        InstanceView instanceView = new InstanceView();
        instanceView.setInstanceId(String.valueOf(getInstanceId()));
        MetaworksRemoteService.autowire(instanceView);

        return instanceView.createInstanceViewDetail();
    }

    @ServiceMethod(callByContent=true)//, target= ServiceMethodContext.TARGET_POPUP)
    public ModalWindow showDashBoard() throws Exception{

        ProcessInstance instance = processManager.getProcessInstance(""+getInstanceId());

        if(!(instance.getProcessDefinition() instanceof EssenceProcessDefinition))
            throw new RuntimeException("This instance is not an EssenceProcessDefinition's instance");

        ModalWindow modal = new ModalWindow(new GameBoard(instance, false), 900, 700);

        modal.setTitle("Alpha Dashboard");

        //Gam application = new Application();

        MetaworksRemoteService.wrapReturn(modal.getPanel());

        return modal;
    }

    @ServiceMethod(callByContent=true, target= ServiceMethodContext.TARGET_POPUP)
    public ModalWindow showDashBoardPopup() throws Exception{

        ProcessInstance instance = processManager.getProcessInstance(""+getInstanceId());

        if(!(instance.getProcessDefinition() instanceof EssenceProcessDefinition))
            throw new RuntimeException("This instance is not an EssenceProcessDefinition's instance");

        ModalWindow modal = new ModalWindow(new GameBoard(instance, false), 900, 700);

        modal.setTitle("Alpha Dashboard");

        //Gam application = new Application();

        MetaworksRemoteService.wrapReturn(modal.getPanel());

        return modal;
    }

    @ServiceMethod(callByContent=true, target= ServiceMethodContext.TARGET_POPUP)
    public ModalWindow monitorPopup() throws Exception{
        InstanceMonitorPanel instanceMonitorPanel = new InstanceMonitorPanel();
        instanceMonitorPanel.load(this.getInstanceId(), this.processManager);

        ModalWindow modal = new ModalWindow(instanceMonitorPanel, 900, 700);

        modal.setTitle("Process Monitor");

        //Gam application = new Application();

        MetaworksRemoteService.wrapReturn(modal.getPanel());

        return modal;
    }

    @Override
    protected InstanceMonitorPanel createInstanceMonitorPanel() throws Exception {
        InstanceMonitorPanel instanceMonitorPanel =  super.createInstanceMonitorPanel();
        instanceMonitorPanel.setElementViewActionDelegate(new ElementViewActionDelegateForCardView());

        return instanceMonitorPanel;
    }
}
