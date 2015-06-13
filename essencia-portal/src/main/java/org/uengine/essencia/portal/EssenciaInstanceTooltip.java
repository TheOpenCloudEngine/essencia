package org.uengine.essencia.portal;

import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.ModalWindow;
import org.springframework.stereotype.Component;
import org.uengine.codi.mw3.model.InstanceTooltip;
import org.uengine.essencia.enactment.AlphaGameBoard;
import org.uengine.essencia.enactment.EssenceProcessDefinition;
import org.uengine.essencia.enactment.GameBoard;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.kernel.ProcessInstance;

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

        ModalWindow modal = new ModalWindow(
                new GameBoard(practiceDefinition, instance)

        );


        return modal;
    }

}
