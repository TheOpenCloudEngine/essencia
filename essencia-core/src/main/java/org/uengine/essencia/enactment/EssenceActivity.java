package org.uengine.essencia.enactment;

import org.uengine.contexts.TextContext;
import org.uengine.essencia.model.*;
import org.uengine.essencia.model.Activity;
import org.uengine.kernel.*;
import org.uengine.util.UEngineUtil;

import java.util.ArrayList;
import java.util.List;

public class EssenceActivity extends HumanActivity implements NeedArrangementToSerialize {

    private org.uengine.essencia.model.Activity activityInEssenceDefinition;
        public Activity getActivityInEssenceDefinition() {
            return activityInEssenceDefinition;
        }
        public void setActivityInEssenceDefinition(Activity activityInEssenceDefinition) {
            this.activityInEssenceDefinition = activityInEssenceDefinition;
        }

    public EssenceActivity(){}


    public EssenceActivity(org.uengine.essencia.model.Activity activityInEssenceDefinition){
        setActivityInEssenceDefinition(activityInEssenceDefinition);
        setName(activityInEssenceDefinition.getName());
        setRole(Role.forName(activityInEssenceDefinition.getCompetencyName()));//TODO: should be getCompetency().getName()

        setInputOutputParameters();

        setTool("mw3." + UEngineUtil.getComponentClassName(getClass(),  "handler"));

    }

    private void setInputOutputParameters() {

        List<ParameterContext> parameterContexts = new ArrayList<ParameterContext>();


        if(getActivityInEssenceDefinition().getCompletionCriteria()!=null && getActivityInEssenceDefinition().getCompletionCriteria().size() > 0) {

            for (LanguageElement completionCriterion_ : getActivityInEssenceDefinition().getCompletionCriteria()) {

                ParameterContext parameterContext = createParameterContextFromCriterion((Criterion) completionCriterion_);
                parameterContext.setDirection(ParameterContext.DIRECTION_INOUT);
                parameterContexts.add(parameterContext);
            }
        }

        //TODO: disabled for now
//
//        if(getActivityInEssenceDefinition().getEntryCriteria()!=null && getActivityInEssenceDefinition().getEntryCriteria().size() > 0) {
//
//            for(LanguageElement completionCriterion_ : getActivityInEssenceDefinition().getEntryCriteria()){
//
//                ParameterContext parameterContext = createParameterContextFromCriterion((Criterion) completionCriterion_);
//                parameterContext.setDirection(ParameterContext.DIRECTION_IN);
//                parameterContexts.add(parameterContext);
//            }
//
//
//        }

        ParameterContext [] parameterContextsInArray = new ParameterContext[parameterContexts.size()];
        parameterContexts.toArray(parameterContextsInArray);

        setParameters(parameterContextsInArray);


    }

    private ParameterContext createParameterContextFromCriterion(Criterion completionCriterion_) {
        ParameterContext parameterContext = new ParameterContext();

        Criterion completionCriterion = completionCriterion_;

        parameterContext = new ParameterContext();

        TextContext textContext = TextContext.createInstance();

        textContext.setText(completionCriterion.getElement().getName());

        parameterContext.setArgument(textContext);

        //workProducts should be accessed by global naming
        parameterContext.setVariable(ProcessVariable.forName(parameterContext.getArgument().getText()));


        return parameterContext;

    }


    @Override
    protected void beforeExecute(ProcessInstance instance) throws Exception {

        if(getActivityInEssenceDefinition().getEntryCriteria()!=null)
        for(LanguageElement criterion1 : getActivityInEssenceDefinition().getEntryCriteria()){
            Criterion criterion = (Criterion)criterion1;   //TODO: why entrycriteria is not named as criterion and Criterion class.

            Alpha alpha = criterion.getState().getParentAlpha(); //this structure may cause recursive reference

            List<AlphaInstance> alphaInstances =  alpha.getInstances(instance);

            for(AlphaInstance alphaInstance : alphaInstances ){
                if(!criterion.getState().equals(alphaInstance.getCurrentState())){
                    throw new IllegalStateException("Not reached to entry state '" + criterion.getState().getName() + "' to begin this activity" + getName());
                }
            }
        }

        super.beforeExecute(instance);
    }
//
//    @Override
//    protected void executeActivity(ProcessInstance instance) throws Exception {
//
//
//        super.executeActivity(instance);
//    }

    @Override
    public void fireComplete(ProcessInstance instance) throws Exception {

        if(getActivityInEssenceDefinition().getCompletionCriteria()!=null)
        for(LanguageElement criterion1 : getActivityInEssenceDefinition().getCompletionCriteria()){
            Criterion criterion = (Criterion)criterion1;   //TODO: why entrycriteria is not named as criterion and Criterion class.

            ValidationContext validationContext = criterion.investigateCompletable(instance);

            if(validationContext!=null && validationContext.size() > 0){
                throw new NotCompletableException(validationContext);
            }

        }

        super.fireComplete(instance);
    }

    @Override
    public void beforeSerialization() {
        for(ParameterContext parameterContext : getParameters()){
            if(parameterContext.getVariable()!=null){
                parameterContext.getVariable().setName(parameterContext.getArgument().getText());
                ProcessVariable realPV = getProcessDefinition().getProcessVariable(parameterContext.getVariable().getName());
                parameterContext.setVariable(realPV);
            }
        }
    }

    @Override
    public void afterDeserialization() {

    }
}
