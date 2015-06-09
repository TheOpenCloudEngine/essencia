package org.uengine.essencia.enactment.handler;

import org.uengine.codi.mw3.model.WorkItemHandler;
import org.uengine.essencia.model.card.ActivityCard;


public class EssenceActivityHandler extends WorkItemHandler {

    ActivityCard activityCard;
        public ActivityCard getActivityCard() {
            return activityCard;
        }
        public void setActivityCard(ActivityCard activityCard) {
            this.activityCard = activityCard;
        }



    //TODO: checkpoint tools

}
