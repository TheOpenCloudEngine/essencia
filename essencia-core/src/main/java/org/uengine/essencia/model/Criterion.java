package org.uengine.essencia.model;

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

}
