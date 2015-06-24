package org.uengine.essencia.model;

import java.util.ArrayList;
import java.util.List;

import org.metaworks.annotation.Face;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.Order;
import org.metaworks.component.SelectBox;
import org.uengine.essencia.component.EssenciaConcernSelectBox;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.model.card.ActivitySpaceCard;
import org.uengine.essencia.model.card.Card;
import org.uengine.essencia.model.face.ActivitySpaceCriterionFace;
import org.uengine.essencia.model.face.InputAlphaFace;
import org.uengine.essencia.model.view.ActivitySpaceView;
import org.uengine.essencia.model.view.ActivityView;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.modeling.IElement;

public class ActivitySpace extends AbstractActivity implements Concernable {

    private List<Activity> childActivities;

    private List<Alpha> inputList;
    private transient InputAlphaFace inputFace;

    private String concern;
    private transient SelectBox concernSelectBox;

    @Hidden
    public List<Alpha> getInputList() {
        return inputList;
    }

    public void setInputList(List<Alpha> inputList) {
        this.inputList = inputList;
    }

    @Hidden
    public List<Activity> getChildActivities() {
        return childActivities;
    }

    public void setChildActivities(List<Activity> childActivities) {
        this.childActivities = childActivities;
    }

    @Order(5)
    @Face(displayName = "Input")
    public InputAlphaFace getInputFace() {
        return inputFace;
    }

    public void setInputFace(InputAlphaFace inputFace) {
        this.inputFace = inputFace;
    }

    public ActivitySpace() {
        setConcernBox(new EssenciaConcernSelectBox());

    }

    @Override
    public void setUpElement(List<IElement> elementList) {

        setInputFace(new InputAlphaFace());
        getInputFace().fill(elementList);

        setCompletionCriterionFace(new ActivitySpaceCriterionFace());
        getCompletionCriterionFace().fill(elementList);

        this.elementListFromCanvas = elementList;

        super.setUpElement();
        if (getInputList() != null) {
            getInputFace().fillElements(getInputList());
            getInputList().clear();
        }
        if (getCompletionCriteria() != null) {
            getCompletionCriterionFace().fillElements(getCompletionCriteria());
            getCompletionCriteria().clear();
        }

        setConcernBox(new EssenciaConcernSelectBox());
        getConcernBox().setSelected(getConcern());
        setConcern("");

    }

    @Override
    public void beforeApply() {

        super.beforeApply();
        setInputList(getInputFace().createValue());
        setCompletionCriteria(((ActivitySpaceCriterionFace)getCompletionCriterionFace()).createValue());

        setConcern(getConcernBox().getSelected());
        setConcernBox(null);
    }

    @Hidden
    @Override
    public String getConcern() {
        return concern;
    }

    @Override
    public void setConcern(String concern) {
        this.concern = concern;
    }

    @Face(displayName = "Concern")
    @Order(4)
    @Override
    public SelectBox getConcernBox() {
        return concernSelectBox;
    }

    @Override
    public void setConcernBox(SelectBox concern) {
        this.concernSelectBox = concern;
    }

    @Override
    public Card createCardView() {
        Card card = new ActivitySpaceCard(this);
        return card;
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

        for (LanguageElement e : getInputList()) {
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