package org.uengine.essencia.modeling.editor;

import org.metaworks.annotation.Face;
import org.uengine.essencia.modeling.modeler.EssenciaModeler;
import org.uengine.essencia.modeling.modeler.PracticeDefiner;
import org.uengine.modeling.IResource;

@Face(displayName="PracticeDefiner")
public class DefinerEditor extends EssenciaModelerEditor {

	public DefinerEditor(){
		
	}
	
	public DefinerEditor(IResource resource){
		setResource(resource);
	}
	
	@Override
	public void createModeler() {
		this.setModeler(new PracticeDefiner());
	}	

	@Override
	public String getAlias() throws Exception {
		EssenciaModeler modeler = this.takeEssenciaModeler();
		
		return modeler.takeModel().getAlias();
	}

}
