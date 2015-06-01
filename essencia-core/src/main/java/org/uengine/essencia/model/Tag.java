package org.uengine.essencia.model;

public class Tag extends LanguageElement {

    private String value;

    public String getValue() {
	return value;
    }

    public void setValue(String value) {
	this.value = value;
    }

    public Tag() {

    }

    @Override
    public void setUpElement() {
    }

    @Override
    public void beforeApply() {
    }
}
