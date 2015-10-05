package org.uengine.essencia.enactment.handler;

import org.metaworks.annotation.Available;
import org.metaworks.model.MetaworksElement;
import org.uengine.codi.mw3.model.ParameterValue;
import org.uengine.codi.mw3.model.ProcessVariableValueList;
import org.uengine.codi.mw3.model.WorkItemHandler;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.enactment.EssenceActivity;
import org.uengine.essencia.model.Activity;
import org.uengine.essencia.model.card.ActivityCard;
import org.uengine.essencia.model.card.Card;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.kernel.HumanActivity;
import org.uengine.util.UEngineUtil;

import java.util.ArrayList;
import java.util.List;


public class EssenceActivityHandler extends WorkItemHandler {

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

        Long instanceId = new Long(getInstanceId());
        Long taskId = getTaskId();
        String tracingTag = getTracingTag();

        EssenceActivity essenceActivity = (EssenceActivity) humanActivity;

        activityCard = (ActivityCard) essenceActivity.getActivityInEssenceDefinition().createCardView();
    }


//TODO: checkpoint tools

}
