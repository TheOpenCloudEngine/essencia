package org.uengine.essencia.modeling.editor;

import java.util.List;

import org.uengine.modeling.ElementView;
import org.uengine.modeling.RelationView;

public abstract class EssenciaModelerEditor extends ModelerEditor {

	public abstract String getAlias() throws Exception;
	
	public List<ElementView> obtainElementViewList(){
		return takeEssenciaModeler().obtainElementViewList();
	}
	
	public List<RelationView> obtainRelationViewList(){
		return takeEssenciaModeler().obtainRelationViewList();
	}
	
}