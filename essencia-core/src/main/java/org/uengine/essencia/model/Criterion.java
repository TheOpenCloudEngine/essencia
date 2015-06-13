package org.uengine.essencia.model;

import org.metaworks.annotation.Face;
import org.uengine.essencia.enactment.AlphaInstance;
import org.uengine.essencia.enactment.LanguageElementInstance;
import org.uengine.essencia.enactment.NotCompletableException;
import org.uengine.essencia.model.face.CriterionFace;
import org.uengine.essencia.model.face.CriterionFace2;
import org.uengine.kernel.ProcessInstance;
import org.uengine.kernel.ValidationContext;

import java.util.ArrayList;
import java.util.List;

@Face(faceClass= CriterionFace2.class)
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

    public ValidationContext investigateCompletable(ProcessInstance instance) {

        ValidationContext validationContext = new ValidationContext();

        if(getState()!=null){ //means Alpha

            Alpha alpha = getState().getParentAlpha();

            List<AlphaInstance> alphaInstances =  alpha.getInstances(instance);

            try {
                for (AlphaInstance alphaInstance : alphaInstances) {
                    alphaInstance.advanceState(instance);
                }
            }catch(NotCompletableException nce){
                validationContext.add(nce.getMessage());
            }

        }else if(getLevelOfDetail()!=null){ //means WorkProduct

            WorkProduct workProduct = getLevelOfDetail().getParentWorkProduct();



///
        }


        return validationContext;
    }
}
