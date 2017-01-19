package org.uengine.essencia.enactment;

import org.metaworks.ContextAware;
import org.metaworks.MetaworksContext;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.dwr.MetaworksRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.uengine.codi.mw3.model.IWorkItem;
import org.uengine.codi.mw3.model.WorkItem;
import org.uengine.codi.mw3.model.WorkItemHandler;
import org.uengine.essencia.model.Activity;
import org.uengine.essencia.model.Criterion;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.model.card.ActivityCard;
import org.uengine.kernel.ExecutionScopeContext;
import org.uengine.kernel.HumanActivity;
import org.uengine.kernel.ProcessInstance;
import org.uengine.kernel.VariablePointer;
import org.uengine.kernel.handler.SubParamaterValueSelector;
import org.uengine.processmanager.ProcessManagerRemote;
import org.uengine.social.RoleUser;
import org.uengine.util.ActivityFor;
import org.uengine.webservices.worklist.DefaultWorkList;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
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


        setSubParamaterValueSelectors(new ArrayList<SubParamaterValueSelector>());

        if(activity.getEntryCriteria()!=null)
        for(Criterion criterion : activity.getEntryCriteria()){
            SubParamaterValueSelector subParamaterValueSelector = new SubParamaterValueSelector();
            MetaworksRemoteService.autowire(subParamaterValueSelector);
            subParamaterValueSelector.load(instance, criterion.getElement().getName());

            getSubParamaterValueSelectors().add(subParamaterValueSelector);
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

    List<SubParamaterValueSelector> subParamaterValueSelectors;
        public List<SubParamaterValueSelector> getSubParamaterValueSelectors() {
            return subParamaterValueSelectors;
        }
        public void setSubParamaterValueSelectors(List<SubParamaterValueSelector> subParamaterValueSelectors) {
            this.subParamaterValueSelectors = subParamaterValueSelectors;
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

        ExecutionScopeContext oldEsc = instance.getExecutionScopeContext();
        AlphaInstance alphaInstance = (AlphaInstance) alphaInstanceInEditor.getVariablePointer().getValue(instance);

        ExecutionScopeContext esc = instance.issueNewExecutionScope(bpmActivity, bpmActivity, (alphaInstance.getValueMap().get("Id")!=null ? alphaInstance.getValueMap().get("Id").toString() : "<No name>"));
        instance.setExecutionScopeContext(esc);

        if(getSubParamaterValueSelectors()!=null)
        for(SubParamaterValueSelector subParamaterValueSelector : getSubParamaterValueSelectors()){
            MetaworksRemoteService.autowire(subParamaterValueSelector);
            subParamaterValueSelector.setInstanceId(instance.getFullInstanceId());
            subParamaterValueSelector.narrowValue();
        }

        instance.execute(bpmActivity.getTracingTag());

        // link the task with the alphaInstance
        String taskId = bpmActivity.getTaskIds(instance)[0];
        alphaInstance.getValueMap().put("__taskIdFor_" + getActivityName(), taskId );
        alphaInstanceInEditor.getVariablePointer().setValue(instance, alphaInstance);
        // end

        processManager.setChanged();

    }

    @Autowired
    public ProcessManagerRemote processManager;

}
