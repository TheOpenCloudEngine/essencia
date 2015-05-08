package org.uengine.essencia.model;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.metaworks.MetaworksContext;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.Id;
import org.metaworks.annotation.Name;
import org.metaworks.annotation.Order;
import org.uengine.contexts.TextContext;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.IElement;
import org.uengine.util.UEngineUtil;

public abstract class BasicElement extends LanguageElement implements IElement {

	protected TextContext name;
	protected TextContext briefDescription;
	protected TextContext description;
	private ElementView elementView;

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

	protected String parentElementId;

	@Hidden
	public String getParentElementId() {
		return parentElementId;
	}

	public void setParentElementId(String parentElementId) {
		this.parentElementId = parentElementId;
	}

	@Hidden
	@Override
	public ElementView getElementView() {
		return elementView;
	}

	@Override
	public void setElementView(ElementView elementView) {
		this.elementView = elementView;
	}

	transient MetaworksContext metaworksContext;

	@Override
	public MetaworksContext getMetaworksContext() {
		return metaworksContext;
	}

	@Override
	public void setMetaworksContext(MetaworksContext metaworksContext) {
		this.metaworksContext = metaworksContext;
	}

	protected Extension extensionFrom;

	@Hidden
	public Extension getExtensionFrom() {
		return extensionFrom;
	}

	public void setExtensionFrom(Extension extensionFrom) {
		this.extensionFrom = extensionFrom;
	}

	protected boolean isSuppressable;

	@Hidden
	public boolean isSuppressable() {
		return isSuppressable;
	}

	public void setSuppressable(boolean isSuppressable) {
		this.isSuppressable = isSuppressable;
	}

	public BasicElement() {

		this.name = new TextContext();
		this.description = new TextContext();
		this.briefDescription = new TextContext();

	}

	@Override
	public ElementView createView() {
//		StringBuilder fullClassPath = new StringBuilder(getClass().getPackage().getName());
//		fullClassPath.append(".view.");
//		fullClassPath.append(getClass().getSimpleName());
//		fullClassPath.append("View");
//
//		ElementView elementView = null;
//		try {
//			Constructor constructor = Thread.currentThread().getContextClassLoader().loadClass(fullClassPath.toString())
//					.getConstructor(new Class[] { IElement.class });
//			elementView = (ElementView) constructor.newInstance(this);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (NoSuchMethodException e) {
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		} catch (IllegalArgumentException e) {
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			e.printStackTrace();
//		}
//
//		return elementView;

		ElementView elementView = (ElementView) UEngineUtil.getComponentByEscalation(getClass(), "view");
		elementView.setElement(this);

		return elementView;


	}

}
