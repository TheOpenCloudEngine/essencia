package org.uengine.essencia.enactment.handler;

import com.itextpdf.text.Meta;
import org.metaworks.annotation.AutowiredToClient;
import org.metaworks.annotation.Available;
import org.metaworks.annotation.Hidden;
import org.metaworks.model.MetaworksElement;
import org.uengine.codi.mw3.model.ParameterValue;
import org.uengine.codi.mw3.model.ProcessVariableValueList;
import org.uengine.codi.mw3.model.WorkItemHandler;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.enactment.AlphaInstance;
import org.uengine.essencia.enactment.EssenceActivity;
import org.uengine.essencia.model.Activity;
import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.Criterion;
import org.uengine.essencia.model.card.ActivityCard;
import org.uengine.essencia.model.card.Card;
import org.uengine.essencia.portal.ElementViewActionDelegateForCardView;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.kernel.HumanActivity;
import org.uengine.kernel.ProcessVariableValue;
import org.uengine.modeling.ElementViewActionDelegate;
import org.uengine.modeling.modeler.DefaultElementViewActionDelegate;
import org.uengine.social.SocialBPMWorkItemHandler;
import org.uengine.util.UEngineUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class EssenceActivityHandler extends SocialBPMWorkItemHandler {


    ElementViewActionDelegate elementViewActionDelegate;
    @Hidden
    @AutowiredToClient
    public ElementViewActionDelegate getElementViewActionDelegate() {
        return elementViewActionDelegate;
    }
    public void setElementViewActionDelegate(ElementViewActionDelegate elementViewActionDelegate) {
        this.elementViewActionDelegate = elementViewActionDelegate;
    }


    ActivityCard activityCard;
    @Available(where = "detail")
        public ActivityCard getActivityCard() {
            return activityCard;
        }
        public void setActivityCard(ActivityCard activityCard) {
            this.activityCard = activityCard;
        }




    @Override
    public void load() throws Exception {
        super.load();

        setElementViewActionDelegate(new ElementViewActionDelegateForCardView());


        Long instanceId = new Long(getInstanceId());
        Long taskId = getTaskId();
        String tracingTag = getTracingTag();



        EssenceActivity essenceActivity = (EssenceActivity) processManager.getProcessInstance(getInstanceId()).getProcessDefinition().getActivity(tracingTag);

        activityCard = (ActivityCard) essenceActivity.getActivityInEssenceDefinition().createCardView();

        Activity activityInEssenceDefinition = essenceActivity.getActivityInEssenceDefinition();

        HashMap<String, Criterion> criterionByElementName = new HashMap<String, Criterion>();   // Map of Completion criteria of this activity
        for(Criterion criterion : activityInEssenceDefinition.getCompletionCriteria()){
            criterionByElementName.put(criterion.getElement().getName(), criterion);
        }

        List<AlphaInstance> alphaInstanceList = new ArrayList<AlphaInstance>();


        //set target states when the output parameter value is an alphaInstance.
        if(getOutputParameters()!=null)
        for(ParameterValue parameterValue : getOutputParameters()){


            Object parameterValueValue = parameterValue.getValue();

            if(parameterValue.getProcessVariableValueList()!=null){

                parameterValueValue = parameterValue.getProcessVariableValueList().getDefaultValue();

                for(MetaworksElement metaworksElement : parameterValue.getProcessVariableValueList().getElements()){
                    alphaInstanceList.add((AlphaInstance) metaworksElement.getValue());
                }

            }

            if(parameterValueValue instanceof AlphaInstance)
                alphaInstanceList.add((AlphaInstance) parameterValueValue);

            for(AlphaInstance alphaInstance : alphaInstanceList){
                if(criterionByElementName.containsKey(alphaInstance.getAlpha().getName())){
                    Criterion criterion = criterionByElementName.get(alphaInstance.getAlpha().getName());

                    alphaInstance.setTargetStateName(criterion.getStateOrLevelOfDetail().getName());
                }
            }
        }
    }


//TODO: checkpoint tools

}


