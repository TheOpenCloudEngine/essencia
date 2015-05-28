package org.uengine.essencia.enactment;

import org.uengine.contexts.TextContext;
import org.uengine.essencia.model.*;
import org.uengine.essencia.model.Activity;
import org.uengine.kernel.*;

import java.util.List;

public class EssenceActivity extends HumanActivity implements NeedArrangementToSerialize {

    org.uengine.essencia.model.Activity activityInEssenceDefinition;
        public Activity getActivityInEssenceDefinition() {
            return activityInEssenceDefinition;
        }
        public void setActivityInEssenceDefinition(Activity activityInEssenceDefinition) {
            this.activityInEssenceDefinition = activityInEssenceDefinition;
        }


    public EssenceActivity(org.uengine.essencia.model.Activity activityInEssenceDefinition){
        setActivityInEssenceDefinition(activityInEssenceDefinition);
        setName(activityInEssenceDefinition.getName());
        setRole(Role.forName(activityInEssenceDefinition.getCompetencyName()));//TODO: should be getCompetency().getName()

        setInputOutputParameters();

//        setMessage(essenceActivity.getName());
    }

    private void setInputOutputParameters() {

        if(getActivityInEssenceDefinition().getWorkProductList()!=null && getActivityInEssenceDefinition().getWorkProductList().size() > 0){
            ParameterContext[] parameterContexts = new ParameterContext[getActivityInEssenceDefinition().getWorkProductList().size()];

            int i = 0;

            for(LanguageElement workProduct_ : getActivityInEssenceDefinition().getWorkProductList()){

                WorkProduct workProduct = (WorkProduct) workProduct_;

                parameterContexts[i] = new ParameterContext();
                parameterContexts[i].setDirection(ParameterContext.DIRECTION_INOUT);

                TextContext textContext = TextContext.createInstance();
                textContext.setText(workProduct.getName());
                parameterContexts[i].setArgument(textContext);

                //workProducts should be accessed by global naming
                parameterContexts[i].setVariable(ProcessVariable.forName(workProduct.getName()));

                i++;

            }

            setParameters(parameterContexts);

        }


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

            Alpha alpha = criterion.getState().getParentAlpha();

            List<AlphaInstance> alphaInstances =  alpha.getInstances(instance);

            for(AlphaInstance alphaInstance : alphaInstances ){
                alphaInstance.advanceState();
            }
        }



        super.fireComplete(instance);
    }

    @Override
    public void beforeSerialization() {

    }

    @Override
    public void afterDeserialization() {
        for(ParameterContext parameterContext : getParameters()){
            if(parameterContext.getVariable()!=null){
                ProcessVariable realPV = getProcessDefinition().getProcessVariable(parameterContext.getVariable().getName());
                parameterContext.setVariable(realPV);
            }
        }
    }
}
