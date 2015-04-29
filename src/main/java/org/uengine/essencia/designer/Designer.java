package org.uengine.essencia.designer;

import org.metaworks.EventContext;
import org.metaworks.ServiceMethodContext;
import org.metaworks.ToEvent;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.ServiceMethod;
import org.uengine.essencia.IContent;
import org.uengine.essencia.i18n.Locale;
import org.uengine.essencia.modeling.editor.EditorTabs;
import org.uengine.essencia.modeling.editor.EmptyEditor;

public class Designer implements IContent {

	public Designer() {
	}
	
	public Designer(Locale locale) {
		this.resourceNavigator = new ResourceNavigator(locale);
		this.editorTabs = new EditorTabs();
	}
		
	private ResourceNavigator resourceNavigator;
		public ResourceNavigator getResourceNavigator() {
			return resourceNavigator;
		}
		public void setResourceNavigator(ResourceNavigator resourceNavigator) {
			this.resourceNavigator = resourceNavigator;
		}
	
	private EditorTabs editorTabs;
		public EditorTabs getEditorTabs() {
			return editorTabs;
		}
		public void setEditorTabs(EditorTabs editorTabs) {
			this.editorTabs = editorTabs;
		}
	
	@Hidden
	@ServiceMethod(bindingHidden=true, keyBinding="Ctrl+S@Global", target=ServiceMethodContext.TARGET_APPEND)
	public ToEvent save(){
		return new ToEvent(new EmptyEditor(), EventContext.EVENT_SAVE);	
	}
}
