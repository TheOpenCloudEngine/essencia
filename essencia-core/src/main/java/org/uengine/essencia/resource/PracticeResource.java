package org.uengine.essencia.resource;

import org.uengine.essencia.modeling.editor.Editor;
import org.uengine.essencia.modeling.editor.PracticeDefinerEditor;

public class PracticeResource extends ModelResource {
	
	public PracticeResource() {
		
	}
	
	public PracticeResource(String path) {
		super(path);
	}

	@Override
	public Editor createEditor() throws Exception {
		PracticeDefinerEditor editor = new PracticeDefinerEditor();
		editor.load(essenciaSession, this);
		
		return editor; 
	}

}
