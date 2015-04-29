package org.uengine.essencia.model;

import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.Id;
import org.metaworks.annotation.Order;

public class CheckPoint extends LanguageElement implements FaceTransformer {

    private String name;
    private String description;

    @Order(1)
    @Id
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    private boolean isCompleted = false;

    @Hidden
    public boolean isCompleted() {
	return isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
	this.isCompleted = isCompleted;
    }

    public CheckPoint() {
    }

    public Essence.Foundation.Checkpoint toXmi() {
	Essence.Foundation.Checkpoint checkPoint = Essence.Foundation.FoundationFactory.eINSTANCE.createCheckpoint();
	checkPoint.setName(getName());
	checkPoint.setDescription(getDescription());
	return checkPoint;
    }

    @Override
    public void setUpElement() {
    }

    @Override
    public void beforeApply() {
    }
}
