package org.uengine.essencia.enactment;

import org.uengine.essencia.model.card.ActivityCard;

/**
 * Created by uengine on 2016. 12. 21..
 */
public class ActivityInstanceRunPanel {
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


}
