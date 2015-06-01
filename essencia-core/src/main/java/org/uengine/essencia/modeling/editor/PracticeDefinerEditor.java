package org.uengine.essencia.modeling.editor;

import org.uengine.modeling.IResource;



public class PracticeDefinerEditor extends EssenciaEditor {
	
	public PracticeDefinerEditor() {
		
	}
	
	public PracticeDefinerEditor(IResource resource) throws Exception {
		super(resource);
	}
	
	@Override
	public void createEditors(){
		super.add(new DefinerEditor(getResource()));
	}
}	