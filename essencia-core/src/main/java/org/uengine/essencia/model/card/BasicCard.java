package org.uengine.essencia.model.card;

import org.uengine.contexts.TextContext;
import org.uengine.essencia.model.BasicElement;
import org.uengine.essencia.modeling.canvas.CardCanvas;
import org.uengine.kernel.bpmn.SequenceFlow;
import org.uengine.modeling.*;


public abstract class BasicCard implements Card{
	
	protected double x = 0;
	protected double y = 0;
	protected int trcTag = 0;
	
	protected Symbol symbol = null;
		public Symbol getSymbol() {
			return symbol;
		}
		public void setSymbol(Symbol symbol) {
			this.symbol = symbol;
		}
		
	protected ElementView view = null;
		public ElementView getView() {
			return view;
		}
		public void setView(ElementView view) {
			this.view = view;
		}

	protected TextContext name;
		@Override	
		public String getName() {
			return name.getText();
		}
		@Override
		public void setName(String name) {
			this.name.setText(name);
		}
	
	protected String img;
		@Override
		public String getImg() {
			return img;
		}
		@Override
		public void setImg(String img) {
			this.img = img;
		}
		
	protected String parentName;
		@Override
		public String getParentName() {
			return parentName;
		}
		@Override
		public void setParentName(String parentName) {
			this.parentName = parentName;
		}
		
	protected TextContext description;
		public String getDescription() {
			return description.getText();
		}
		public void setDescription(String description) {
			this.description.setText(description);
		}

	protected CardCanvas canvas;
		public CardCanvas getCanvas() {
			return canvas;
		}
		public void setCanvas(CardCanvas canvas) {
			this.canvas = canvas;
		}


	Detail detail;
		public Detail getDetail() {
			return detail;
		}
		public void setDetail(Detail detail) {
			this.detail = detail;
		}


	public BasicCard(){
		this.name = new TextContext();
		this.description = new TextContext();
		setCanvas(new CardCanvas());
	}
	
	protected void makeRelation(String prefix){
		SequenceFlow transition = new SequenceFlow();
		RelationView view = transition.createView();
		setSymbol(view.createSymbol());
		
		view.fill(getSymbol());
		view.setRelation(transition);
		
		view.setId(prefix + String.valueOf(trcTag));
		view.setFrom(prefix + String.valueOf(trcTag - 1) + TERMINAL_IN_OUT);
		view.setTo(prefix + String.valueOf(trcTag + 1) + TERMINAL_IN_OUT);
		
		getCanvas().getRelationViewList().add(view);
	}

	protected void makeUpView(IElement element){
		makeUpView(element, 40);
	}
	
	protected void makeUpView(IElement element, int addedY){
		getView().fill(getSymbol());
		getView().setX((x));
		getView().setY((y));
		y = y + (getView().getHeight()) + addedY;
		getView().setElement(element);
		getView().setLabel(element.getName());
	}
	
	protected abstract void makeCard(BasicElement element);
	
	@Override
	public String toString() {
		return "Card [view=" + view + ", name=" + name + ", description=" + description + "]";
	}
}
