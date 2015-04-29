package org.uengine.essencia.modeling.modeler;

import java.util.ArrayList;
import java.util.List;

import org.uengine.contexts.TextContext;
import org.uengine.essencia.model.BasicElement;
import org.uengine.essencia.model.LanguageElement;
import org.uengine.essencia.model.Practice;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.modeling.canvas.PracticeCanvas;
import org.uengine.essencia.modeling.palette.EssenciaPalette;
import org.uengine.modeling.Canvas;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.IElement;
import org.uengine.modeling.IModel;
import org.uengine.modeling.Relation;
import org.uengine.modeling.RelationView;
import org.uengine.util.ObjectUtil;

/**
 * @author jyj
 */
public class PracticeDefiner extends EssenciaModeler {
	
	public final static String SUFFIX = ".practice";

	public PracticeDefiner() {
		setType(SUFFIX);
		setCanvas(new PracticeCanvas());
		setPalette(new EssenciaPalette());
	}
	
	@Override
	public void setModel(IModel model) throws Exception {
		List<ElementView> elementViewList = new ArrayList<ElementView>();
		List<RelationView> relationViewList = new ArrayList<RelationView>();

		PracticeDefinition practice = (PracticeDefinition)model;
		practice.afterDeserialize();
		
		for(IElement element : practice.getElementList()){
			elementViewList.add(ObjectUtil.convertToViewHasElement(element));
		}
				
		for(Relation relation : practice.getRelationList()){
			relationViewList.add(ObjectUtil.convertToViewHasRelation(relation));
		}
		
		getCanvas().setElementViewList(elementViewList);
		getCanvas().setRelationViewList(relationViewList);
	}
	

	@Override
	public IModel createModel() throws Exception {
		return makePracticeFromCanvas(getCanvas());
	}
		
	public PracticeDefinition makePracticeFromCanvas(Canvas canvas) throws Exception{
		PracticeDefinition practice = new PracticeDefinition();
		
		TextContext practiceName = new TextContext();
		
		for(ElementView elementView : canvas.getElementViewList()){
		    BasicElement element = (BasicElement)ObjectUtil.convertToElementHasView(elementView);
			element.setName(elementView.getLabel());
			if(element instanceof Practice){
				practiceName.setText(element.getName());
			}
			practice.addElement(element);
		}
		
		for(RelationView relationView : this.getCanvas().getRelationViewList()){
			Relation relation = (Relation)ObjectUtil.convertToRelationHasView(relationView);
			practice.addRelationList(relation);
		}
		
		practice.setName(practiceName);
		return practice;
	}
}
