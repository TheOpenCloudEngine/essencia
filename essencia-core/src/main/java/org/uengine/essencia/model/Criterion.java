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

        if(getState()!=null && UEngineUtil.isNotEmpty(getState().getName())){ //means Alpha

            Alpha alpha = getState().getParentAlpha();

            List<AlphaInstance> alphaInstances =  alpha.getInstances(instance);

            try {
                for (AlphaInstance alphaInstance : alphaInstances) {
                    if(alphaInstance!=null) {
                        alphaInstance.calculateState();

                        if(getState().getName().equals(alphaInstance.getCurrentStateName())){
                            throw new NotCompletableException("State of Alpha ["+ alpha.getName() + "] is not reached to [" + getState().getName() + "]");
                        }
                    }

                }
            }catch(NotCompletableException nce){
                validationContext.add(nce.getMessage());
            }


            ProcessVariableValue pvv = new ProcessVariableValue();
            pvv.setName(alpha.getName());

            for (AlphaInstance alphaInstance : alphaInstances) {
                pvv.setValue(alphaInstance);
                pvv.moveToAdd();
            }

            try {
                instance.set("", pvv);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }else if(getLevelOfDetail()!=null){ //means WorkProduct

            WorkProduct workProduct = getLevelOfDetail().getParentWorkProduct();



///
        }


        return validationContext;
    }
}
