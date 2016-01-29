package org.uengine.essencia.portal;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.uengine.codi.mw3.model.InstanceView;
import org.uengine.codi.mw3.model.InstanceViewDetail;
import org.uengine.essencia.enactment.EssenceProcessDefinition;
import org.uengine.essencia.enactment.GameBoard;
import org.uengine.kernel.ProcessInstance;

/**
 * Created by jjy on 2016. 1. 28..
 */
@Component
@Scope("prototype")
public class EssenciaInstanceView extends InstanceView{

    @Override
    public InstanceViewDetail createInstanceViewDetail() {
        ProcessInstance instance = null;
        try {
            instance = processManager.getProcessInstance(""+getInstanceId());

            if((instance.getProcessDefinition() instanceof EssenceProcessDefinition))
                return (new GameBoard(instance, false));
            else
                return super.createInstanceViewDetail();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
