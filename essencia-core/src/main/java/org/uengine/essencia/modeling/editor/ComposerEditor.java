package org.uengine.essencia.modeling.editor;

import org.metaworks.annotation.Face;
import org.uengine.essencia.modeling.modeler.MethodComposer;
import org.uengine.modeling.IResource;

@Face(displayName="MethodComposer")
public class ComposerEditor extends DefinerEditor {
	
	public ComposerEditor(){
		
	}

	public ComposerEditor(IResource resource) {
		super(resource);
	}
	
	@Override
	public void createModeler() {
		this.setModeler(new MethodComposer());
	}	
}
