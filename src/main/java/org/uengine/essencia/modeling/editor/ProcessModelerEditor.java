package org.uengine.essencia.modeling.editor;

import org.metaworks.annotation.Face;
import org.uengine.essencia.modeling.modeler.ProcessModeler;
import org.uengine.modeling.IResource;

@Face(displayName="ProcessModeler")
public class ProcessModelerEditor extends ModelerEditor {
	
	public ProcessModelerEditor(){
		
	}

	public ProcessModelerEditor(IResource resource) {
		setResource(resource);
	}
	
	public void createModeler() {
		this.setModeler(new ProcessModeler());
	}	
}
