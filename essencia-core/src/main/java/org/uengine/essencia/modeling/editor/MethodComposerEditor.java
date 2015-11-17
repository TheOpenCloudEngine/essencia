package org.uengine.essencia.modeling.editor;

import org.uengine.modeling.resource.resources.MethodResource;
import org.uengine.modeling.resource.IResource;


public class MethodComposerEditor extends EssenciaEditor {
	
	public MethodComposerEditor(){
		System.out.println();
	}
	
	public MethodComposerEditor(IResource resource) throws Exception {
		super(resource);
	}
	
	@Override
	public void createEditors(){
		super.add(new ComposerEditor(getResource()));
		super.add(new ProcessModelerEditor(null));
	}
}