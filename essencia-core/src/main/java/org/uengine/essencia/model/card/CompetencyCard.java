package org.uengine.essencia.model.card;

import org.uengine.essencia.model.BasicElement;
import org.uengine.essencia.model.Competency;
import org.uengine.essencia.model.CompetencyLevel;
import org.uengine.essencia.model.view.CompetencyLevelView;


public class CompetencyCard extends BasicCard{
	

	public CompetencyCard(){
		
	}
	
	public CompetencyCard(BasicElement element){
		this();
		makeCard(element);
	}
	
	protected void makeCard(BasicElement element){
		
		setName(element.getName());
		setDescription(element.getDescription());
		setImg(IMG_LOCATION + element.getElementView().getShapeId() + IMG_EXTENSION);
		
		x = 120;
		y = 80;
		int addedWidth = 16;
		
		for(CompetencyLevel competencyLevel : ((Competency)element).getCompetencyLevels()){
			setSymbol(new CompetencyLevelView().createSymbol());
			setView(competencyLevel.createView());
			
			makeUpView(competencyLevel, 0);
			
			getView().setWidth(getView().getWidth() + trcTag * addedWidth);

			getView().setId(String.valueOf(trcTag++));
			
			getCanvas().getElementViewList().add(getView());
		}
	}
	
}
