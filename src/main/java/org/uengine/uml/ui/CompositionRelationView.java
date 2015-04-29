package org.uengine.uml.ui;

import org.uengine.modeling.IRelation;
import org.uengine.modeling.RelationView;

/**
 * @author jyj
 *	compositeRealtion의 View 
 */
public class CompositionRelationView extends RelationView  {
	
	public final static String SHAPE_ID = "OG.shape.EdgeShape";
	
	public CompositionRelationView(){
		
	}
	
	public CompositionRelationView(IRelation element){
		super(element);
	}
}
