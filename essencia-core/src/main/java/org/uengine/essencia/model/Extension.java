package org.uengine.essencia.model;

public class Extension extends LanguageElement {

    private String referElementId;

    public String getReferElementId() {
	return referElementId;
    }

    public void setReferElementId(String referElementId) {
	this.referElementId = referElementId;
    }

    private String extensionFunction;

    public String getExtensionFunction() {
	return extensionFunction;
    }

    public void setExtensionFunction(String extensionFunction) {
	this.extensionFunction = extensionFunction;
    }

    private LanguageElement referElement;

    public LanguageElement getReferElement() {
	return referElement;
    }

    public void setReferElement(LanguageElement referElement) {
	this.referElement = referElement;
    }

}
