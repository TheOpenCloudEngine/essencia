package org.uengine.essencia.portal;

import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.ModalWindow;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.uengine.codi.mw3.model.InstanceTooltip;
import org.uengine.essencia.dashboard.Dashboard;
import org.uengine.essencia.enactment.AlphaGameBoard;
import org.uengine.essencia.enactment.EssenceProcessDefinition;
import org.uengine.essencia.enactment.GameBoard;
import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.kernel.ProcessInstance;

@Scope("prototype")
@Component
public class EssenciaInstanceTooltip extends InstanceTooltip{
    public EssenciaInstanceTooltip() throws Exception {
        super();
    }

    @Override
    @ServiceMethod(callByContent=true, target= ServiceMethodContext.TARGET_POPUP)
    public ModalWindow monitor() throws Exception{

        ProcessInstance instance = processManager.getProcessInstance(""+getInstanceId());

        if(!(instance.getProcessDefinition() instanceof EssenceProcessDefinition))
            throw new RuntimeException("This instance is not an EssenceProcessDefinition's instance");

        PracticeDefinition practiceDefinition = ((EssenceProcessDefinition)instance.getProcessDefinition()).getPracticeDefinition();

        ModalWindow modal = new ModalWindow(new GameBoard(practiceDefinition, instance), 600, 700);

        modal.setTitle("Alpha Dashboard");


        return modal;
    }

    @ServiceMethod(callByContent=true, target= ServiceMethodContext.TARGET_POPUP)
    public ModalWindow showDashBoard() throws Exception{

        PracticeDefinition pc = new PracticeDefinition();

        Dashboard dashboard = new Dashboard(pc);

        ModalWindow modal = new ModalWindow(dashboard, 900, 700);

        modal.setTitle("Alpha Dashboard");

        return modal;
    }



}
