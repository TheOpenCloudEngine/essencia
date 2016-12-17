package org.uengine.essencia.enactment.face;

import org.uengine.essencia.enactment.AlphaInstance;
import org.uengine.essencia.enactment.ActivityForAlphaInstance;
import org.uengine.essencia.model.Activity;
import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.Criterion;
import org.uengine.essencia.model.PracticeDefinition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by uengine on 2016. 12. 14..
 */
public class AlphaActivityPanel {



    List<ActivityForAlphaInstance> runnableActivityList;
        public List<ActivityForAlphaInstance> getRunnableActivityList() {
            return runnableActivityList;
        }
        public void setRunnableActivityList(List<ActivityForAlphaInstance> runnableActivityList) {
            this.runnableActivityList = runnableActivityList;
        }

    String targetStateName;
        public String getTargetStateName() {
            return targetStateName;
        }

        public void setTargetStateName(String targetStateName) {
            this.targetStateName = targetStateName;
        }

    String currentStateName;
        public String getCurrentStateName() {
            return currentStateName;
        }

        public void setCurrentStateName(String currentStateName) {
            this.currentStateName = currentStateName;
        }



    public AlphaActivityPanel(){

    }

    public AlphaActivityPanel(AlphaInstance alphaInstance, PracticeDefinition practiceDefinition){
        Alpha alpha = alphaInstance.getAlpha();
        setAlpha(alpha);

        String targetState = alphaInstance.getTargetStateName();
        String currentState = alphaInstance.getCurrentStateName();

        if(targetState==null){
            targetState = alpha.getStates().get(alpha.getStates().size()-1).getName();
        }
        setTargetStateName(targetState);
        setCurrentStateName(currentState);

        List<Activity> activities = practiceDefinition.getElements(Activity.class);
        List<Activity> recommendedActivities = practiceDefinition.getElements(Activity.class);

        setRunnableActivityList(new ArrayList<ActivityForAlphaInstance>());

        for(Activity activity : activities){
            ActivityForAlphaInstance activityForAlphaInstance = new ActivityForAlphaInstance(activity, alpha);

            if(activityForAlphaInstance.getCompletionStateName()!=null){
                getRunnableActivityList().add(activityForAlphaInstance);
            }
        }

    }

    Alpha alpha;
        public Alpha getAlpha() {
            return alpha;
        }
        public void setAlpha(Alpha alpha) {
            this.alpha = alpha;
        }


}
