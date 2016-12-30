package org.uengine.essencia.enactment;

import org.uengine.essencia.model.card.ActivityCard;
import org.uengine.social.RoleUser;

/**
 * Created by uengine on 2016. 12. 21..
 */
public class ActivityInstanceRunPanel {

    public ActivityInstanceRunPanel(){}

    public ActivityInstanceRunPanel(ActivityCard activityCard){
        setActivityCard(activityCard);
        setAssignee(new RoleUser());
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

}
