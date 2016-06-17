package org.uengine.essencia.model;

import org.uengine.essencia.enactment.AlphaInstance;
import org.uengine.essencia.enactment.LanguageElementInstance;
import org.uengine.essencia.enactment.NotCompletableException;
import org.uengine.kernel.ProcessInstance;
import org.uengine.kernel.ProcessVariableValue;
import org.uengine.kernel.ValidationContext;
import org.uengine.util.UEngineUtil;

import java.util.ArrayList;
import java.util.List;

public class Criterion extends LanguageElement {

    private String description;
    private State state;
    private LevelOfDetail levelOfDetail;

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public State getState() {
	return state;
    }

    public void setState(State state) {
	this.state = state;
    }

    public LevelOfDetail getLevelOfDetail() {
	return levelOfDetail;
    }

    public void setLevelOfDetail(LevelOfDetail levelOfDetail) {
	this.levelOfDetail = levelOfDetail;
    }


    public State getStateOrLevelOfDetail(){
        if(getState()!=null)
            return getState();

        if(getLevelOfDetail()!=null)
            return getLevelOfDetail();

        return null;
    }

    public void setUpState(String state, String alpha) {
	State tempState = new State(state);
	Alpha tempAlpha = new Alpha(alpha);
	tempState.setParentAlpha(tempAlpha);
	setState(tempState);
    }

    public void setUpLevelOfDetail(String levelOfDetail, String workProduct) {
	LevelOfDetail tempLevelOfDetail = new LevelOfDetail(levelOfDetail);
	WorkProduct tempWorkProduct = new WorkProduct(workProduct);
	tempLevelOfDetail.setParentWorkProduct(tempWorkProduct);
	setLevelOfDetail(tempLevelOfDetail);
    }

    //// TODO: later should be done by polymorphism not by if ~ then ~ else.
    public BasicElement getElement(){
        if(getState()!=null){
            return getState().getParentAlpha();
        }else if(getLevelOfDetail()!=null){
            return getLevelOfDetail().getParentWorkProduct();
        }

        return null;
    }

    public LanguageElement getLevelElement(){
        if(getState()!=null){
            return getState();
        }else if(getLevelOfDetail()!=null){
            return getLevelOfDetail();
        }

        return null;
    }

    public ValidationContext investigateCompletable(ProcessInstance instance) {

        ValidationContext validationContext = new ValidationContext();

        if(getStateOrLevelOfDetail()!=null && UEngineUtil.isNotEmpty(getStateOrLevelOfDetail().getName())){ //means Alpha

            Alpha alpha = getState().getParentAlpha();

            List<AlphaInstance> alphaInstances =  alpha.getInstances(instance);

            try {
                if(alphaInstances!=null)
                for (AlphaInstance alphaInstance : alphaInstances) {
                    if(alphaInstance!=null) {
                        alphaInstance.setLanguageElement(alpha); //alpha in the alphaInstance will be empty since it is heavy, so it should be re-assigned.
                        alphaInstance.calculateState();

                        if(!isMet(alphaInstance)){
                            throw new NotCompletableException("State of Alpha ["+ alpha.getName() + "] is not reached to [" + getState().getName() + "]");
                        }
                    }

                }
            }catch(NotCompletableException nce){
                validationContext.add(nce.getMessage());
            }


            ProcessVariableValue pvv = new ProcessVariableValue();
            pvv.setName(alpha.getName());

            if(alphaInstances!=null)
            for (AlphaInstance alphaInstance : alphaInstances) {
                pvv.setValue(alphaInstance);
                pvv.moveToAdd();
            }

            try {
                instance.set("", pvv);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }


        return validationContext;
    }

    public boolean isMet(AlphaInstance alphaInstance) {

        for(int i = getState().getParentAlpha().getStates().size() - 1; i>=0; i--){

            State postState = getState().getParentAlpha().getStates().get(i);

            if(postState.getName().equals(alphaInstance.getCurrentStateName())){
                return true;
            }

            if(getState().getName().equals(postState.getName()))
                break;
        }

        return false;
    }
}
