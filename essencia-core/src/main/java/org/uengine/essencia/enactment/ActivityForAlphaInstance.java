package org.uengine.essencia.enactment;

import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.dwr.MetaworksRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.uengine.essencia.model.Activity;
import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.Criterion;
import org.uengine.essencia.model.card.ActivityCard;
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

        setInstanceId(instanceId);
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

        setActivityInstanceRunPanel(new ActivityInstanceRunPanel()); //empty
    }

    public ActivityForAlphaInstance(){}



    @ServiceMethod(mouseBinding = "left", payload = {"instanceId", "name", "activityInstanceRunPanel.filled"})
    public void run(@AutowiredFromClient(payload={"instanceId"}) Abacus abacus) throws Exception {

        //toggle
        if(getActivityInstanceRunPanel()!=null && getActivityInstanceRunPanel().isFilled()){
            ActivityInstanceRunPanel activityInstanceRunPanel = new ActivityInstanceRunPanel();
            MetaworksRemoteService.wrapReturn(activityInstanceRunPanel);
        }else {

            setInstanceId(abacus.getInstanceId());

            ProcessInstance instance = processManager.getProcessInstance(getInstanceId());
            EssenceProcessDefinition definition = (EssenceProcessDefinition) instance.getProcessDefinition();

            //EssenceActivity activity = (EssenceActivity) definition.getActivity(getTracingTag());
            Activity activity = (Activity) definition.getPracticeDefinition().getElementByName(getName());

            ActivityCard activityCard = new ActivityCard(activity);
            ActivityInstanceRunPanel activityInstanceRunPanel = new ActivityInstanceRunPanel();
            activityInstanceRunPanel.setActivityCard(activityCard);
            activityInstanceRunPanel.setFilled(true);
            MetaworksRemoteService.wrapReturn(activityInstanceRunPanel);
        }
    }

    ActivityInstanceRunPanel activityInstanceRunPanel;
        public ActivityInstanceRunPanel getActivityInstanceRunPanel() {
            return activityInstanceRunPanel;
        }
        public void setActivityInstanceRunPanel(ActivityInstanceRunPanel activityInstanceRunPanel) {
            this.activityInstanceRunPanel = activityInstanceRunPanel;
        }

//    ActivityCard activityCard;
//        public ActivityCard getActivityCard() {
//            return activityCard;
//        }
//        public void setActivityCard(ActivityCard activityCard) {
//            this.activityCard = activityCard;
//        }


    @Autowired
    public ProcessManagerRemote processManager;

}
