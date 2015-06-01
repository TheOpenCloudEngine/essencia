package org.uengine.uml.model;

import org.uengine.modeling.Relation;
import org.uengine.modeling.RelationView;
import org.uengine.uml.ui.CompositionRelationView;

/**
 * @author jyj
 */
public class CompositionRelation extends Relation {
	
	public CompositionRelation() {
	}
	
	@Override
	public RelationView createView() {
		return new CompositionRelationView(this);
	}
	
}
