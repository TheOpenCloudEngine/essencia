package org.uengine.essencia.designer;

import org.metaworks.EventContext;
import org.metaworks.ServiceMethodContext;
import org.metaworks.ToEvent;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.ServiceMethod;
import org.uengine.essencia.IContent;
import org.uengine.essencia.i18n.Locale;
import org.uengine.essencia.modeling.editor.EmptyEditor;

public class Designer implements IContent {

	public Designer() {
	}

	public Designer(Locale locale) {
		this.resourceNavigator = new ResourceNavigator(locale);
		this.editorPanel = new EditorPanel();
	}

	private ResourceNavigator resourceNavigator;

	public ResourceNavigator getResourceNavigator() {
		return resourceNavigator;
	}

	public void setResourceNavigator(ResourceNavigator resourceNavigator) {
		this.resourceNavigator = resourceNavigator;
	}

	private EditorPanel editorPanel;

	public EditorPanel getEditorPanel() {
		return editorPanel;
	}

	public void setEditorPanel(EditorPanel editorPanel) {
		this.editorPanel = editorPanel;
	}

	@Hidden
	@ServiceMethod(bindingHidden = true, keyBinding = "Ctrl+S@Global", target = ServiceMethodContext.TARGET_APPEND)
	public ToEvent save() {
		return new ToEvent(new EmptyEditor(), EventContext.EVENT_SAVE);
	}
}
