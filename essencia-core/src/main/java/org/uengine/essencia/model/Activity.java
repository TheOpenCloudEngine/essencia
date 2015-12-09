package org.uengine.essencia.model;

import java.util.ArrayList;
import java.util.List;

import org.metaworks.annotation.Face;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.Order;
import org.metaworks.component.SelectBox;
import org.uengine.essencia.component.EssenciaConcernSelectBox;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.model.card.ActivityCard;
import org.uengine.essencia.model.card.ActivityCardByElement;
import org.uengine.essencia.model.card.Card;
import org.uengine.essencia.model.face.*;
import org.uengine.essencia.model.face.list.ActionListFace;
import org.uengine.essencia.model.face.list.ApproachListFace;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.modeling.IElement;

public class Activity extends AbstractActivity {

    private List<EntryCriterion> entryCriteria;
    private transient CriterionFace entryCriteriaPanel;

//    private List<LanguageElement> workProductList;
    private transient WorkProductFace workProductFace;

//    private SelectBox competency;
    Competency competency;

    private List<CompetencyLevel> requiredCompetencyLevel;
    private transient RequiredCompetencyLevelFace requiredCompetencyLevelFace;

    private transient ApproachListFace approachPanel;
    private transient ActionListFace actionPanel;

    @Hidden
    public List<EntryCriterion> getEntryCriteria() {
        return entryCriteria;
    }

    public void setEntryCriteria(List<EntryCriterion> entryCriteria) {
        this.entryCriteria = entryCriteria;
    }

//    @Order(7)
//    @Hidden
//    public List<LanguageElement> getWorkProductList() {
//        return workProductList;
//    }
//
//    public void setWorkProductList(List<LanguageElement> workProductList) {
//        this.workProductList = workProductList;
//    }

    @Order(5)
    @Face(displayName = "EntryCriterion")
    public CriterionFace getEntryCriteriaPanel() {
        return entryCriteriaPanel;
    }

    public void setEntryCriteriaPanel(CriterionFace entryCriteriaPanel) {
        this.entryCriteriaPanel = entryCriteriaPanel;
    }

    @Face(displayName = "Action")
    public ActionListFace getActionPanel() {
        return actionPanel;
    }

    public void setActionPanel(ActionListFace actionPanel) {
        this.actionPanel = actionPanel;
    }

    @Face(displayName = "Approach")
    public ApproachListFace getApproachPanel() {
        return approachPanel;
    }

    public void setApproachPanel(ApproachListFace approachPanel) {
        this.approachPanel = approachPanel;
    }

    @Order(4)
    @Face(faceClass = CompetencySelector.class)
    public Competency getCompetency() {
        return competency;
    }
    public void setCompetency(Competency competency) {
        this.competency = competency;
    }

    //    public SelectBox getCompetency() {
//        return competency;
//    }
//
//    public void setCompetency(SelectBox competency) {
//        this.competency = competency;
//    }


    @Face(displayName = "WorkProduct")
    public WorkProductFace getWorkProductFace() {
        return workProductFace;
    }

    public void setWorkProductFace(WorkProductFace workProductFace) {
        this.workProductFace = workProductFace;
    }

    @Hidden
    public List<CompetencyLevel> getRequiredCompetencyLevel() {
        return requiredCompetencyLevel;
    }

    public void setRequiredCompetencyLevel(List<CompetencyLevel> requiredCompetencyLevel) {
        this.requiredCompetencyLevel = requiredCompetencyLevel;
    }

    @Face(displayName = "RequiredCompetencyLevels")
    public RequiredCompetencyLevelFace getRequiredCompetencyLevelFace() {
        return requiredCompetencyLevelFace;
    }

    public void setRequiredCompetencyLevelFace(RequiredCompetencyLevelFace requiredCompetencyLevelFace) {
        this.requiredCompetencyLevelFace = requiredCompetencyLevelFace;
    }

//    public String getCompetencyName() {
//        if (getCompetency() == null) {
//            return null;
//        } else {
//            return getCompetency().getSelectedText();
//        }
//
//    }

    public Activity() {
        setConcernBox(new EssenciaConcernSelectBox());

    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Competency) {
            Competency competency = (Competency) obj;

            return getCompetency().getName().equals(competency.getName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((competency == null) ? 0 : competency.getName().hashCode());
        return result;
    }

    @Override
    public void setUpElement(List<IElement> elementList) {
        super.setUpElement(elementList);

        String temp = "";
//        if (getCompetency() != null) {
//            temp = getCompetency().getSelected();
//        }
//        setCompetency(new SelectBox());
//        for (IElement element : elementList) {
//            if (element instanceof Competency) {
//                Competency competency = (Competency) element;
//                getCompetency().add(competency.getName(), competency.getName());
//            }
//        }
//        getCompetency().setSelected(temp);

        setRequiredCompetencyLevelFace(new RequiredCompetencyLevelFace());
        getRequiredCompetencyLevelFace().fill(elementList);

        setEntryCriteriaPanel(new ActivityEntryCriterionFace());
        getEntryCriteriaPanel().fill(elementList);

        setCompletionCriterionFace(new ActivityCompletionCriterionFace());
        getCompletionCriterionFace().fill(elementList);

        setWorkProductFace(new WorkProductFace());
        getWorkProductFace().fill(elementList);

        this.elementListFromCanvas = elementList;

        super.setUpElement();

        setApproachPanel(new ApproachListFace());
        setActionPanel(new ActionListFace());

        if (getRequiredCompetencyLevel() != null) {
            getRequiredCompetencyLevelFace().fillElements(getRequiredCompetencyLevel());
            getRequiredCompetencyLevel().clear();
        }
        if (getEntryCriteria() != null) {
            getEntryCriteriaPanel().fillElements(getEntryCriteria());
            getEntryCriteria().clear();
        }
        if (getCompletionCriteria() != null) {
            List<LanguageElement> stateCriteria = new ArrayList<>();
            List<LanguageElement> levelOfDetailCriteria = new ArrayList<>();

            for( LanguageElement l : getCompletionCriteria()){
                Criterion c = (Criterion)l;
                if ( c.getLevelOfDetail() == null ){
                    stateCriteria.add(l);
                } else {
                    levelOfDetailCriteria.add(l);
                }
            }
            getCompletionCriterionFace().fillElements(stateCriteria);
            getWorkProductFace().fillElements(levelOfDetailCriteria);
            getCompletionCriteria().clear();
        }
    }

    @Override
    public void beforeApply() {

        super.beforeApply();
        setRequiredCompetencyLevel(getRequiredCompetencyLevelFace().createValue());
        setEntryCriteria(((ActivityEntryCriterionFace) getEntryCriteriaPanel()).createValue());
        setCompletionCriteria(((ActivityCompletionCriterionFace) getCompletionCriterionFace()).createValue());
        getCompletionCriteria().addAll(getWorkProductFace().createValue());
    }

    @Override
    public Card createCardView() {
        Card card = null;
        if( getElementView() == null ){
            card = new ActivityCardByElement(this);
        } else {
            card = new ActivityCard(this);
        }
        return card;
    }

    @Override
    public void transformContext() {
        ContextUtil.setWhen(this, EssenciaContext.WHEN_EDIT);
    }

    @Override
    public Essence.Foundation.BasicElement toXmi(Essence.Foundation.Practice practice) {
        Essence.ActivitySpaceAndActivity.Activity activity = Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityFactory.eINSTANCE
                .createActivity();
        activity.setName(getName());
        activity.setDescription(getDescription());
        activity.setBriefDescription(getBriefDescription());
        for (LanguageElement e : getEntryCriteria()) {
            Criterion criterion = (Criterion) e;
            Essence.ActivitySpaceAndActivity.Criterion entryCriterion = Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityFactory.eINSTANCE
                    .createEntryCriterion();

            for (Essence.Foundation.LanguageElement languageElement : practice.getOwnedElements()) {
                if (languageElement instanceof Essence.AlphaAndWorkProduct.Alpha) {
                    org.eclipse.emf.common.util.EList<Essence.AlphaAndWorkProduct.State> states = ((Essence.AlphaAndWorkProduct.Alpha) languageElement)
                            .getStates();
                    for (Essence.AlphaAndWorkProduct.State state : states) {
                        if (((Essence.AlphaAndWorkProduct.Alpha) languageElement).getName().equals(criterion.getState().getParentAlpha().getName())
                                && state.getName().equals(criterion.getState().getName())) {
                            entryCriterion.setState(state);
                            entryCriterion.getState().setAlpha((Essence.AlphaAndWorkProduct.Alpha) languageElement);
                            break;
                        }
                    }
                }
            }

            activity.getCriterion().add(entryCriterion);
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

            activity.getCriterion().add(completionCriterion);
        }

        for (LanguageElement e : getCompletionCriteria()) {
            Criterion criterion = (Criterion) e;
            Essence.ActivitySpaceAndActivity.Criterion output = Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityFactory.eINSTANCE
                    .createCompletionCriterion();

            for (Essence.Foundation.LanguageElement languageElement : practice.getOwnedElements()) {
                if (languageElement instanceof Essence.AlphaAndWorkProduct.WorkProduct) {
                    org.eclipse.emf.common.util.EList<Essence.AlphaAndWorkProduct.LevelOfDetail> levelOfDetails = ((Essence.AlphaAndWorkProduct.WorkProduct) languageElement)
                            .getLevelOfDetail();

                    for (Essence.AlphaAndWorkProduct.LevelOfDetail levelOfDetail : levelOfDetails) {
                        if (((Essence.AlphaAndWorkProduct.WorkProduct) languageElement).getName().equals(
                                criterion.getLevelOfDetail().getParentWorkProduct().getName())
                                && levelOfDetail.getName().equals(criterion.getLevelOfDetail().getName())) {
                            output.setLevelOfDetail(levelOfDetail);
                            output.getLevelOfDetail().setWorkProduct((Essence.AlphaAndWorkProduct.WorkProduct) languageElement);
                        }
                    }
                }
            }
            activity.getCriterion().add(output);
        }

        for (Essence.Foundation.LanguageElement languageElement : practice.getOwnedElements()) {
            for (LanguageElement essenciaElement : getRequiredCompetencyLevel()) {
                if (languageElement instanceof Essence.Competency.Competency
                        && ((Essence.Competency.Competency) languageElement).getName().equals(essenciaElement.getParentElementId())) {
                    org.eclipse.emf.common.util.EList<Essence.Competency.CompetencyLevel> compentencyLevels = ((Essence.Competency.Competency) languageElement)
                            .getPossibleLevel();
                    for (Essence.Competency.CompetencyLevel competencyLevel : compentencyLevels) {
                        if (competencyLevel.getName().equals(((CompetencyLevel) essenciaElement).getName())) {
                            activity.getRequiredCompetencyLevel().add(competencyLevel);
                        }
                    }
                }
            }
        }
        return activity;
    }

}