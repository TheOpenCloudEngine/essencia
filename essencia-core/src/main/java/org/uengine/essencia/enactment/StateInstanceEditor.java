package org.uengine.essencia.enactment;

import org.metaworks.Remover;
import org.metaworks.ToEvent;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.dwr.MetaworksRemoteService;
import org.uengine.codi.mw3.model.Popup;
import org.uengine.kernel.ProcessInstance;
import org.uengine.processmanager.ProcessManagerRemote;

import java.rmi.RemoteException;
import java.util.Date;

/**
 * Created by uengine on 2016. 12. 20..
 */
public class StateInstanceEditor {

    public StateInstanceEditor(){}

    Date dueDate;
        public Date getDueDate() {
            return dueDate;
        }
        public void setDueDate(Date dueDate) {
            this.dueDate = dueDate;
        }

    String instanceId;
        @Hidden
        public String getInstanceId() {
            return instanceId;
        }
        public void setInstanceId(String instanceId) {
            this.instanceId = instanceId;
        }

    String targetStateName;
        @Hidden
        public String getTargetStateName() {
            return targetStateName;
        }

        public void setTargetStateName(String targetStateName) {
            this.targetStateName = targetStateName;
        }


    String targetAlphaName;
        @Hidden
        public String getTargetAlphaName() {
            return targetAlphaName;
        }

        public void setTargetAlphaName(String targetAlphaName) {
            this.targetAlphaName = targetAlphaName;
        }


    public StateInstanceEditor load() throws Exception {
        ProcessManagerRemote processManagerRemote = MetaworksRemoteService.getComponent(ProcessManagerRemote.class);

        ProcessInstance instance = processManagerRemote.getProcessInstance(getInstanceId());

        AlphaInstance alphaInstance = (AlphaInstance) instance.get("", getTargetAlphaName());
        setDueDate((Date) alphaInstance.getStateDetails(getTargetStateName(), AlphaInstance.STATE_PROP_KEY_DueDate));

        return this;
    }

    @ServiceMethod(callByContent = true, target = ServiceMethod.TARGET_POPUP)
    public void save() throws Exception {
        ProcessManagerRemote processManagerRemote = MetaworksRemoteService.getComponent(ProcessManagerRemote.class);

        ProcessInstance instance = processManagerRemote.getProcessInstance(getInstanceId());

        AlphaInstance alphaInstance = (AlphaInstance) instance.get("", getTargetAlphaName());
        alphaInstance.setStateDetails(getTargetStateName(), AlphaInstance.STATE_PROP_KEY_DueDate, getDueDate());
        alphaInstance.calculateState(instance);

        instance.set("", getTargetAlphaName(), alphaInstance);

        processManagerRemote.applyChanges();

        MetaworksRemoteService.wrapReturn(new ToEvent(new Abacus(), "refresh"), new Remover(new Popup()));
    }
}
