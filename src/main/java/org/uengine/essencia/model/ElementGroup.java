package org.uengine.essencia.model;

import java.util.ArrayList;
import java.util.List;

import org.metaworks.annotation.Id;
import org.metaworks.annotation.Name;
import org.metaworks.annotation.Order;
import org.uengine.contexts.TextContext;

public class ElementGroup extends LanguageElement {

	private TextContext name;
	private TextContext briefDescription;
	private TextContext description;

	private List<LanguageElement> referredElements;
	private List<LanguageElement> ownedElements;

	@Order(1)
	@Id
	@Name
	public String getName() {
		return name.getText();
	}

	public void setName(String name) {
		this.name.setText(name);
	}

	public String getName(String locale) {
		return name.getText(locale);
	}

	public void setName(String locale, String name) {
		this.name.setText(locale, name);
	}

	@Order(3)
	public String getDescription() {
		return description.getText();
	}

	public void setDescription(String description) {
		this.description.setText(description);
	}

	public String getDescription(String locale) {
		return description.getText(locale);
	}

	public void setDescription(String locale, String description) {
		this.description.setText(locale, description);
	}

	@Order(2)
	public String getBriefDescription() {
		return briefDescription.getText();
	}

	public void setBriefDescription(String description) {
		this.briefDescription.setText(description);
	}

	public String getBriefDescription(String locale) {
		return briefDescription.getText(locale);
	}

	public void setBriefDescription(String locale, String description) {
		this.briefDescription.setText(locale, description);
	}

	public List<LanguageElement> getReferredElements() {
		if(this.referredElements == null){
			setReferredElements(new ArrayList<LanguageElement>());
		}
		return referredElements;
	}

	public void setReferredElements(List<LanguageElement> referredElements) {
		this.referredElements = referredElements;
	}

	public List<LanguageElement> getOwnedElements() {
		if(this.ownedElements == null){
			setOwnedElements(new ArrayList<LanguageElement>());
		}
		return ownedElements;
	}

	public void setOwnedElements(List<LanguageElement> ownedElements) {
		this.ownedElements = ownedElements;
	}

	public ElementGroup() {
		name = new TextContext();
		briefDescription = new TextContext();
		description = new TextContext();
	}

}
