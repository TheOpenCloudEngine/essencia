package org.uengine.essencia.enactment;

import org.metaworks.ContextAware;
import org.metaworks.MetaworksContext;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.dwr.MetaworksRemoteService;
import org.metaworks.model.SortableElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.uengine.codi.mw3.model.*;
import org.uengine.essencia.model.Activity;
import org.uengine.essencia.model.Criterion;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.model.card.ActivityCard;
import org.uengine.kernel.*;
import org.uengine.kernel.handler.SubParameterValueSelector;
import org.uengine.processmanager.ProcessManagerRemote;
import org.uengine.social.RoleUser;
import org.uengine.util.ActivityFor;
import org.uengine.webservices.worklist.DefaultWorkList;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by uengine on 2016. 12. 21..
 */
public class ActivityInstanceRunPanel implements ContextAware{

    public ActivityInstanceRunPanel(){}

    public ActivityInstanceRunPanel(Activity activity, ProcessInstance instance, AlphaInstanceInEditor alphaInstanceInEditor) throws Exception {
        setActivityName(activity.getName());

        //check if any task is linked to this alphaInstance, if then, just show the work-item-handler rather.
        AlphaInstance alphaInstance = (AlphaInstance) alphaInstanceInEditor.getVariablePointer().getValue(instance);
        String taskId = (String) alphaInstance.getValueMap().get("__taskIdFor_" + getActivityName());

        if(taskId!=null){
            IWorkItem workItem = WorkItem.findByTaskId(taskId);
            if(DefaultWorkList.WORKITEM_STATUS_NEW.equals(workItem.getStatus()) || DefaultWorkList.WORKITEM_STATUS_CONFIRMED.equals(workItem.getStatus())) {
                WorkItem contentWorkItem = new WorkItem();
                contentWorkItem.copyFrom(workItem);

                MetaworksRemoteService.autowire(contentWorkItem);
                contentWorkItem.detail();
                setWorkItemHandler(contentWorkItem.getWorkItemHandler());

                return;
            }
        }
        //

        ActivityCard activityCard = (ActivityCard) activity.createCardView();//new ActivityCard();

        setActivityCard(activityCard);
        setAssignee(new RoleUser());
        setMetaworksContext(new MetaworksContext());
        getMetaworksContext().setWhen(MetaworksContext.WHEN_EDIT);
        setFilled(true);


        setSubParameterValueSelectors(new ArrayList<SubParameterValueSelector>());

        if(activity.getEntryCriteria()!=null)
        for(Criterion criterion : activity.getEntryCriteria()){

            //selected alpha instance would not be showed for selection
            if(!alphaInstance.getAlpha().getName().equals(criterion.getElement().getName())){

                SubParameterValueSelector subParameterValueSelector = new SubParameterValueSelector();
                MetaworksRemoteService.autowire(subParameterValueSelector);
                subParameterValueSelector.load(instance, criterion.getElement().getName());

                getSubParameterValueSelectors().add(subParameterValueSelector);

            }
        }
    }


    WorkItemHandler workItemHandler;
        public WorkItemHandler getWorkItemHandler() {
            return workItemHandler;
        }
        public void setWorkItemHandler(WorkItemHandler workItemHandler) {
            this.workItemHandler = workItemHandler;
        }

    ActivityCard activityCard;
        public ActivityCard getActivityCard() {
            return activityCard;
        }
        public void setActivityCard(ActivityCard activityCard) {
            this.activityCard = activityCard;
        }

    boolean filled;
        public boolean isFilled() {
            return filled;
        }
        public void setFilled(boolean filled) {
            this.filled = filled;
        }

    RoleUser assignee;
        public RoleUser getAssignee() {
            return assignee;
        }
        public void setAssignee(RoleUser assignee) {
            this.assignee = assignee;
        }

    Date dueDate;
        public Date getDueDate() {
            return dueDate;
        }
        public void setDueDate(Date dueDate) {
            this.dueDate = dueDate;
        }

    MetaworksContext metaworksContext;
        @Override
        public MetaworksContext getMetaworksContext() {
            return metaworksContext;
        }
        public void setMetaworksContext(MetaworksContext metaworksContext) {
            this.metaworksContext = metaworksContext;
        }

    String activityName;
        public String getActivityName() {
            return activityName;
        }
        public void setActivityName(String activityName) {
            this.activityName = activityName;
        }

    List<SubParameterValueSelector> subParameterValueSelectors;
        public List<SubParameterValueSelector> getSubParameterValueSelectors() {
            return subParameterValueSelectors;
        }
        public void setSubParameterValueSelectors(List<SubParameterValueSelector> subParameterValueSelectors) {
            this.subParameterValueSelectors = subParameterValueSelectors;
        }


    @ServiceMethod(except = "activityCard", callByContent = true)
    public void runThisActivity(@AutowiredFromClient(payload = {"instanceId", "variablePointer"}) AlphaInstanceInEditor alphaInstanceInEditor) throws Exception {
        String instanceId = alphaInstanceInEditor.getInstanceId();

        ProcessInstance instance = processManager.getProcessInstance(instanceId);
        EssenceProcessDefinition essenceProcessDefinition = (EssenceProcessDefinition) instance.getProcessDefinition();
        PracticeDefinition practiceDefinition = essenceProcessDefinition.getPracticeDefinition();

        Activity activity = (Activity) practiceDefinition.getElementByName(getActivityName());

        ActivityFor findBPMActivity = new ActivityFor(){

            @Override
            public void logic(org.uengine.kernel.Activity activity) {
                if(activity.getName().equals(getActivityName()) && activity instanceof EssenceActivity && ((EssenceActivity) activity).getActivityInEssenceDefinition().getName().equals(getActivityName())){
                    stop(activity);
                }
            }
        };


        findBPMActivity.run(essenceProcessDefinition);
        HumanActivity bpmActivity = (HumanActivity) findBPMActivity.getReturnValue();

        if(bpmActivity==null) throw new Exception("Could'nt find the defined actionable BPM activity for the Essence Activity named [" + getActivityName() + "]");

        ExecutionScopeContext oldEsc = instance.getExecutionScopeContext();
        AlphaInstance alphaInstance = (AlphaInstance) alphaInstanceInEditor.getVariablePointer().getValue(instance);

        ExecutionScopeContext esc = instance.issueNewExecutionScope(bpmActivity, bpmActivity, (alphaInstance.getValueMap().get("Id")!=null ? alphaInstance.getValueMap().get("Id").toString() : "<No name>"));
        instance.setExecutionScopeContext(esc);

        //set the alphaInstance as sub process variable first

        instance.set("", alphaInstanceInEditor.getVariablePointer().getKey(), alphaInstanceInEditor.getVariablePointer());

        //set the selected input values as sub process variables.

        if(getSubParameterValueSelectors()!=null)
        for(SubParameterValueSelector subParameterValueSelector : getSubParameterValueSelectors()){
            MetaworksRemoteService.autowire(subParameterValueSelector);
            subParameterValueSelector.setInstanceId(instance.getFullInstanceId());
            subParameterValueSelector.narrowValue();
        }

        if(getAssignee()!=null) {
            instance.putRoleMapping(bpmActivity.getRole().getName(), getAssignee().getEndpoint()); //may be problematic
            sendNoti(instance, bpmActivity);
        }

        instance.setProperty("","__adhoc", true); // don't continue to execute the followed activities after.
        instance.execute(bpmActivity.getTracingTag());

        // link the task with the alphaInstance
        String taskId = bpmActivity.getTaskIds(instance)[0];
        alphaInstance.getValueMap().put("__taskIdFor_" + getActivityName(), taskId );
        alphaInstanceInEditor.getVariablePointer().setValue(instance, alphaInstance);
        // end

        if(getDueDate()!=null) {
            Calendar dueDate = Calendar.getInstance();
            dueDate.setTime(getDueDate());
            bpmActivity.setDueDate(instance, dueDate);
        }



        processManager.setChanged();

    }

    private void sendNoti(ProcessInstance instance, HumanActivity bpmActivity) throws Exception {

            Notification noti = new Notification();
            noti.setNotiId(System.currentTimeMillis()); //TODO: why generated is hard to use
            noti.setUserId(getAssignee().getEndpoint());
            noti.setActorId(getAssignee().getEndpoint());
            noti.setConfirm(false);
            noti.setInputDate(Calendar.getInstance().getTime());
            noti.setInstId(Long.valueOf(instance.getInstanceId()));
            noti.setActAbstract(bpmActivity.getName() + " 업무가 부여되었습니다.");


        IInstance instance1 = new Instance();
        instance1.setInstId(Long.valueOf(instance.getInstanceId()));
        noti.add(instance1);

    }

    @Autowired
    public ProcessManagerRemote processManager;

}
