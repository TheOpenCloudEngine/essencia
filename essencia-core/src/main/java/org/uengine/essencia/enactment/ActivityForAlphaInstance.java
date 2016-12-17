package org.uengine.essencia.enactment;

import org.metaworks.annotation.ServiceMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.uengine.essencia.model.Activity;
import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.Criterion;
import org.uengine.kernel.ProcessDefinition;
import org.uengine.kernel.ProcessInstance;
import org.uengine.processmanager.ProcessManagerBean;
import org.uengine.processmanager.ProcessManagerRemote;

import java.rmi.RemoteException;

/**
 * Created by uengine on 2016. 12. 14..
 */
public class ActivityForAlphaInstance {

    String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

    String tracingTag;
        public String getTracingTag() {
            return tracingTag;
        }
        public void setTracingTag(String tracingTag) {
            this.tracingTag = tracingTag;
        }

    String status;
        public String getStatus() {
            return status;
        }
        public void setStatus(String status) {
            this.status = status;
        }

    String instanceId;
        public String getInstanceId() {
            return instanceId;
        }
        public void setInstanceId(String instanceId) {
            this.instanceId = instanceId;
        }

    String entryStateName;
        public String getEntryStateName() {
            return entryStateName;
        }
        public void setEntryStateName(String entryStateName) {
            this.entryStateName = entryStateName;
        }

    String completionStateName;
        public String getCompletionStateName() {
            return completionStateName;
        }
        public void setCompletionStateName(String completionStateName) {
            this.completionStateName = completionStateName;
        }

    public ActivityForAlphaInstance(Activity activity, Alpha alpha){

        setName(activity.getName());

        if(activity.getEntryCriteria()!=null)
        for(Criterion criterion : activity.getEntryCriteria()){
            if(criterion.getElement()!=null && criterion.getElement().getName()!=null && criterion.getElement().getName().equals(alpha.getName())){
                setEntryStateName(criterion.getStateOrLevelOfDetail().getName());
            }
        }

        if(activity.getCompletionCriteria()!=null)
        for(Criterion criterion : activity.getCompletionCriteria()) {
            if (criterion.getElement()!=null && criterion.getElement().getName()!=null && criterion.getElement().getName().equals(alpha.getName())) {
                setCompletionStateName(criterion.getStateOrLevelOfDetail().getName());
            }
        }
    }

    public ActivityForAlphaInstance(){}



    @ServiceMethod(callByContent = true)
    public void run() throws Exception {
        ProcessInstance instance = processManager.getProcessInstance(getInstanceId());
        ProcessDefinition definition = instance.getProcessDefinition();

        EssenceActivity activity = (EssenceActivity) definition.getActivity(getTracingTag());


    }

    @Autowired
    public ProcessManagerRemote processManager;

}
