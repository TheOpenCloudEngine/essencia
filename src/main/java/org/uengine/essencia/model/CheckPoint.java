package org.uengine.essencia.model;

import Essence.Foundation.Method;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.Id;
import org.metaworks.annotation.Order;
import org.uengine.kernel.ProcessInstance;

import javax.persistence.Basic;

public class CheckPoint extends BasicElement implements FaceTransformer {

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

    public boolean isCompleted(ProcessInstance instance) {
        try {
            return (boolean) instance.getProperty(this.getName(), "isCompleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setCompleted(ProcessInstance instance, boolean isCompleted) {
        try {
            instance.setProperty(this.getName(), "isCompleted", isCompleted);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
