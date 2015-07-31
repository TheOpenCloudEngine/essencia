package org.uengine.modeling.resource.resources;

import org.uengine.essencia.modeling.editor.Editor;
import org.uengine.essencia.modeling.editor.PracticeDefinerEditor;
import org.uengine.essencia.resource.ModelResource;

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
