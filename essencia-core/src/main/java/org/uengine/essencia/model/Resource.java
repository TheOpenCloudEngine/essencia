package org.uengine.essencia.model;

public class Resource extends LanguageElement {

    private String content;

    public String getContent() {
	return content;
    }

    public void setContent(String content) {
	this.content = content;
    }

    public Resource() {

    }

    @Override
    public void setUpElement() {
    }

    @Override
    public void beforeApply() {
    }

}
