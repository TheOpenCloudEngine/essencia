package org.uengine.essencia.model;

import java.util.ArrayList;
import java.util.List;

import org.metaworks.annotation.Hidden;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.model.view.ActivitySpaceView;
import org.uengine.essencia.model.view.ActivityView;
import org.uengine.essencia.util.ContextUtil;

public class ActivitySpace extends Activity{

    private List<Activity> childActivities;

    private List<Alpha> input;
        public List<Alpha> getInput() {
            return input;
        }
        public void setInput(List<Alpha> input) {
            this.input = input;
        }

    @Hidden
    public List<Activity> getChildActivities() {
        return childActivities;
    }

    public void setChildActivities(List<Activity> childActivities) {
        this.childActivities = childActivities;
    }


    public ActivitySpace() {
        super();
    }


    @Override
    public void transformContext() {
        if (getOwner() != null && EssenciaContext.ESSENCE_KERNEL.equals(getOwner().getName())) {
            ContextUtil.setWhen(this, EssenciaContext.WHEN_VIEW);
        } else {
            ContextUtil.setWhen(this, EssenciaContext.WHEN_EDIT);
        }
    }

    @Override
    public Essence.Foundation.BasicElement toXmi(Essence.Foundation.Practice practice) {
        Essence.ActivitySpaceAndActivity.ActivitySpace activitySpace = Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityFactory.eINSTANCE
                .createActivitySpace();
        // set alpha
        activitySpace.setName(getName());
        activitySpace.setDescription(getDescription());
        activitySpace.setBriefDescription(getBriefDescription());

        for (LanguageElement e : getInput()) {
            Alpha essenciaAlpha = (Alpha) e;

            for (Essence.Foundation.LanguageElement languageElement : practice.getOwnedElements()) {
                if (languageElement instanceof Essence.AlphaAndWorkProduct.Alpha
                        && ((Essence.AlphaAndWorkProduct.Alpha) languageElement).getName().equals(essenciaAlpha.getName())) {
                    activitySpace.getInput().add((Essence.AlphaAndWorkProduct.Alpha) languageElement);
                }
            }
        }

        for (LanguageElement e : getCompletionCriteria()) {
            Criterion criterion = (Criterion) e;
            Essence.ActivitySpaceAndActivity.Criterion completionCriterion = Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityFactory.eINSTANCE
                    .createCompletionCriterion();

            for (Essence.Foundation.LanguageElement languageElement : practice.getOwnedElements()) {
                if (languageElement instanceof Essence.AlphaAndWorkProduct.Alpha) {
                    org.eclipse.emf.common.util.EList<Essence.AlphaAndWorkProduct.State> states = ((Essence.AlphaAndWorkProduct.Alpha) languageElement)
                            .getStates();
                    for (Essence.AlphaAndWorkProduct.State state : states) {
                        if (((Essence.AlphaAndWorkProduct.Alpha) languageElement).getName().equals(criterion.getState().getParentAlpha().getName())
                                && state.getName().equals(criterion.getState().getName())) {
                            completionCriterion.setState(state);
                            completionCriterion.getState().setAlpha((Essence.AlphaAndWorkProduct.Alpha) languageElement);
                            break;
                        }
                    }
                }
            }
            activitySpace.getCriterion().add(completionCriterion);
        }
        return activitySpace;
    }

    public void addActivity(PracticeDefinition practiceDefinition) {
        List<Activity> activityList = practiceDefinition.getElements(Activity.class);
        ActivitySpaceView activitySpaceView = (ActivitySpaceView) this.getElementView();
        List<Activity> activitieList = new ArrayList<Activity>();
        if (activitySpaceView.getToEdge() != null) {
            String[] toEdges = activitySpaceView.getToEdge().split(",");
            for (Activity activity : activityList) {
                ActivityView activityView = (ActivityView) activity.getElementView();
                for (String edge : toEdges) {
                    if (edge.equals(activityView.getFromEdge())) {
                        activitieList.add(activity);
                    }
                }
            }
        }
        this.setChildActivities(activitieList);
    }

}