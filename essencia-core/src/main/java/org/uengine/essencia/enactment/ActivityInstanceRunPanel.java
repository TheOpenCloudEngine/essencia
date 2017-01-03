package org.uengine.essencia.enactment;

import org.metaworks.ContextAware;
import org.metaworks.MetaworksContext;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.ServiceMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.uengine.essencia.model.Activity;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.model.card.ActivityCard;
import org.uengine.kernel.ExecutionScopeContext;
import org.uengine.kernel.ProcessInstance;
import org.uengine.kernel.VariablePointer;
import org.uengine.processmanager.ProcessManagerRemote;
import org.uengine.social.RoleUser;
import org.uengine.util.ActivityFor;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Date;

/**
 * Created by uengine on 2016. 12. 21..
 */
public class ActivityInstanceRunPanel implements ContextAware{

    public ActivityInstanceRunPanel(){}

    public ActivityInstanceRunPanel(ActivityCard activityCard){
        setActivityCard(activityCard);
        setAssignee(new RoleUser());
        setMetaworksContext(new MetaworksContext());
        getMetaworksContext().setWhen(MetaworksContext.WHEN_EDIT);
        setFilled(true);

        setActivityName(getActivityCard().getName());
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



    @ServiceMethod(except = "activityCard", callByContent = true)
    public void runThisActivity(@AutowiredFromClient AlphaInstanceInEditor alphaInstanceInEditor) throws Exception {
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
        org.uengine.kernel.Activity bpmActivity = (org.uengine.kernel.Activity) findBPMActivity.getReturnValue();

        ExecutionScopeContext oldEsc = instance.getExecutionScopeContext();
        AlphaInstance alphaInstance = (AlphaInstance) alphaInstanceInEditor.getVariablePointer().getValue(instance);

        ExecutionScopeContext esc = instance.issueNewExecutionScope(bpmActivity, bpmActivity, (alphaInstance.getValueMap().get("Id")!=null ? alphaInstance.getValueMap().get("Id").toString() : "<No name>"));
        instance.setExecutionScopeContext(esc);

        instance.execute(bpmActivity.getTracingTag());

        processManager.setChanged();

    }

    @Autowired
    public ProcessManagerRemote processManager;

}
