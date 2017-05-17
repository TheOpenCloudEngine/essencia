package org.uengine.essencia.enactment;

import org.metaworks.Refresh;
import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.ServiceMethod;
import org.uengine.codi.mw3.model.SubProcessAttachStartingWorkItem;
import org.uengine.kernel.AwareProcessInstanceId;
import org.uengine.kernel.ProcessInstance;
import org.uengine.kernel.VariablePointer;

/**
 * Created by uengine on 2017. 1. 12..
 */
public class AlphaInstanceCommentWorkItem extends SubProcessAttachStartingWorkItem {

    @Override
    @ServiceMethod(callByContent = true, target= ServiceMethodContext.TARGET_SELF)
    public Object[] add(@AutowiredFromClient(payload={"instanceId", "processInstanceId", "variablePointer"}) AwareProcessInstanceId processInstanceContext) throws Exception {
        Object[] returnValues = super.add(processInstanceContext);

        if(processInstanceContext instanceof AlphaInstanceInEditor){
            VariablePointer variablePointer = ((AlphaInstanceInEditor) processInstanceContext).getVariablePointer();
            ProcessInstance mainProcessInstance = processManager.getProcessInstance(((AlphaInstanceInEditor) processInstanceContext).getInstanceId());
            AlphaInstance alphaInstance = (AlphaInstance) variablePointer.getValue(mainProcessInstance);
            alphaInstance.getValueMap().put(AlphaInstance.VALUEMAP_KEY_COMMENT_INST_ID, ""+ getInstId());
            variablePointer.setValue(mainProcessInstance, alphaInstance);

            processManager.setChanged();
        }


        return new Object[]{((Refresh)returnValues[1]).getTarget()};
    }
}
