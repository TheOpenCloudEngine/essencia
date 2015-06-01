package org.uengine.essencia.model;

import org.metaworks.annotation.Order;

public class Approach extends LanguageElement {

    private String name;
    private String description;

    @Order(1)
    public String getName() {
	return name;
    }

    public void setName(String name) {

	this.name = name;
    }

    @Order(2)
    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public Approach() {

    }

    @Override
    public void setUpElement() {
    }

    @Override
    public void beforeApply() {
    }

}
