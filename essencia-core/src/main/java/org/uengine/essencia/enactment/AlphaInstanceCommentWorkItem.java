package org.uengine.essencia.enactment;

import org.metaworks.annotation.AutowiredFromClient;
import org.uengine.codi.mw3.model.CommentWorkItem;
import org.uengine.codi.mw3.model.SubProcessAttatchStartingWorkItem;
import org.uengine.kernel.AwareProcessInstanceId;
import org.uengine.kernel.ProcessInstance;
import org.uengine.kernel.VariablePointer;

/**
 * Created by uengine on 2017. 1. 12..
 */
public class AlphaInstanceCommentWorkItem extends SubProcessAttatchStartingWorkItem {
    @Override
    public Object[] add(@AutowiredFromClient(payload={"processInstanceId", "variablePointer"}) AwareProcessInstanceId processInstanceContext) throws Exception {
        Object[] returnValues = super.add();

        if(processInstanceContext instanceof AlphaInstanceInEditor){
            VariablePointer variablePointer = ((AlphaInstanceInEditor) processInstanceContext).getVariablePointer();
            ProcessInstance mainProcessInstance = processManager.getProcessInstance(((AlphaInstanceInEditor) processInstanceContext).getInstanceId());
            AlphaInstance alphaInstance = (AlphaInstance) variablePointer.getValue(mainProcessInstance);
            alphaInstance.getValueMap().put("__commentInstId", ""+ getInstId());
            variablePointer.setValue(mainProcessInstance, alphaInstance);

            processManager.setChanged();
        }


        return returnValues;
    }
}
