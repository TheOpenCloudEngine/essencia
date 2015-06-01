package org.uengine.essencia.model.card;

import java.util.ArrayList;
import java.util.List;

import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.CheckPoint;
import org.uengine.essencia.model.State;
import org.uengine.modeling.IElement;


public class StateCard extends DetailCard{
	
	protected List<String> list;
		public List<String> getList() {
			return list;
		}
		public void setList(List<String> list) {
			this.list = list;
		}
		
	protected String stateNumber;
		public String getStateNumber() {
			return stateNumber;
		}
		public void setStateNumber(String stateNumber) {
			this.stateNumber = stateNumber;
		}
		
	public StateCard(){
		setList(new ArrayList<String>());
	}
	
	public StateCard(IElement element, Alpha parentElement){
		this();
		makeCard(element, parentElement);
	}
	
	@Override
	protected void makeCard(IElement element, IElement parentElement) {
		setName(element.getName());
		setImg(IMG_LOCATION + parentElement.createView().createSymbol().getShapeId() + IMG_EXTENSION);
		setParentName(parentElement.getName());
		
		for(int i=0; i < ((Alpha)parentElement).getList().size(); i++){
			State state = ((Alpha)parentElement).getList().get(i);
			if(state.getName().equals(element.getName())){
				setStateNumber(i + 1 + "/" + ((Alpha)parentElement).getList().size());
				for (CheckPoint checkPoint : state.getList()){
					getList().add(checkPoint.getName());
				}
			}
		}
	}

}

