package org.uengine.essencia.enactment;

import org.metaworks.annotation.Hidden;
import org.uengine.contexts.TextContext;
import org.uengine.essencia.model.*;
import org.uengine.essencia.model.Activity;
import org.uengine.kernel.*;
import org.uengine.util.UEngineUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EssenceActivity extends HumanActivity {

    private org.uengine.essencia.model.Activity activityInEssenceDefinition;
        @Hidden
        public Activity getActivityInEssenceDefinition() {
            return activityInEssenceDefinition;
        }
        public void setActivityInEssenceDefinition(Activity activityInEssenceDefinition) {
            this.activityInEssenceDefinition = activityInEssenceDefinition;
        }

    public EssenceActivity(){}

    @Override
    @Hidden
    public String getTool() {
        return "mw3." + UEngineUtil.getComponentClassName(getClass(),  "handler");
    }

    public EssenceActivity(org.uengine.essencia.model.Activity activityInEssenceDefinition){
        setActivityInEssenceDefinition(activityInEssenceDefinition);
        setName(activityInEssenceDefinition.getName());
        setRole(Role.forName(activityInEssenceDefinition.getCompetencyName()));//TODO: should be getCompetency().getName()

        initInputOutputParameters();
    }

    public void initInputOutputParameters() {

        List<ParameterContext> addingParameterContexts = new ArrayList<ParameterContext>();

        HashMap<String, ParameterContext> parameterContextHashMap = new HashMap<String, ParameterContext>();

        if(getParameters()!=null)
        for(ParameterContext parameterContext : getParameters()){
            parameterContextHashMap.put(parameterContext.getArgument().getText(), parameterContext);
        }

        if(getActivityInEssenceDefinition().getCompletionCriteria()!=null && getActivityInEssenceDefinition().getCompletionCriteria().size() > 0) {

            //HashMap<String, Criterion> completionCriteriaByName = new HashMap<String, Criterion>();

            for (LanguageElement completionCriterion_ : getActivityInEssenceDefinition().getCompletionCriteria()) {

                Criterion criterion = (Criterion) completionCriterion_;

                String criterionName = criterion.getElement().getName();
                ParameterContext existingParameterContext = null;

                boolean newlyAddedParameterContext = !parameterContextHashMap.containsKey(criterionName);

                if(!newlyAddedParameterContext){
                    existingParameterContext = parameterContextHashMap.get(criterionName);
                }

                ParameterContext parameterContext = createParameterContextFromCriterion(criterion, existingParameterContext);

                addingParameterContexts.add(parameterContext);

                //completionCriteriaByName.put(criterionName, criterion);
            }


            for(int i=0; i<addingParameterContexts.size(); i++){
                ParameterContext parameterContext = addingParameterContexts.get(i);

                boolean found = false;
                for (LanguageElement completionCriterion_ : getActivityInEssenceDefinition().getCompletionCriteria()) {

                    Criterion criterion = (Criterion) completionCriterion_;
                    String criterionName = criterion.getElement().getName();

                    if(parameterContext.getArgument().getText().equals(criterionName)){
                        found = true;
                        break;
                    }
                }

                if(!found || !UEngineUtil.isNotEmpty(parameterContext.getArgument().getText())){
                    addingParameterContexts.remove(parameterContext);
                }
            }

            ParameterContext[] newParameterContexts = new ParameterContext[addingParameterContexts.size()];

            newParameterContexts = addingParameterContexts.toArray(newParameterContexts);

            setParameters(newParameterContexts);
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

        ParameterContext [] parameterContextsInArray = new ParameterContext[addingParameterContexts.size()];
        addingParameterContexts.toArray(parameterContextsInArray);

        setParameters(parameterContextsInArray);


    }

    private ParameterContext createParameterContextFromCriterion(Criterion completionCriterion_, ParameterContext existingParameterContext) {
        ParameterContext parameterContext = (existingParameterContext == null ? new ParameterContext() : existingParameterContext);

        Criterion completionCriterion = completionCriterion_;


        TextContext textContext = TextContext.createInstance();

        textContext.setText(completionCriterion.getElement().getName());

        parameterContext.setArgument(textContext);

        //workProducts should be accessed by global naming
        parameterContext.setVariable(ProcessVariable.forName(parameterContext.getArgument().getText()));

        if(existingParameterContext==null){
            parameterContext.setDirection(ParameterContext.DIRECTION_INOUT);
        }


        return parameterContext;

    }


    @Override
    protected void beforeExecute(ProcessInstance instance) throws Exception {


        //check for entry criteria

        if(getActivityInEssenceDefinition().getEntryCriteria()!=null)
        for(LanguageElement criterion1 : getActivityInEssenceDefinition().getEntryCriteria()){
            Criterion criterion = (Criterion)criterion1;   //TODO: why entrycriteria is not named as criterion and Criterion class.

            Alpha alpha = criterion.getState().getParentAlpha(); //this structure may cause recursive reference

            List<AlphaInstance> alphaInstances =  alpha.getInstances(instance);

            if(alphaInstances!=null)
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



}
