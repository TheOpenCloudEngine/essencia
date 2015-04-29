package org.uengine.essencia.model.card;

import org.uengine.contexts.TextContext;
import org.uengine.essencia.model.BasicElement;
import org.uengine.kernel.graph.Transition;
import org.uengine.modeling.Canvas;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.IElement;
import org.uengine.modeling.RelationView;
import org.uengine.modeling.Symbol;


public abstract class BasicCard implements Card{
	
	protected int x = 0;
	protected int y = 0;
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

	protected Canvas canvas;
		public Canvas getCanvas() {
			return canvas;
		}
		public void setCanvas(Canvas canvas) {
			this.canvas = canvas;
		}
	
	
	
	public BasicCard(){
		this.name = new TextContext();
		this.description = new TextContext();
		setCanvas(new Canvas());
	}
	
	protected void makeRelation(String prefix){
		Transition transition = new Transition();
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
		getView().setX(String.valueOf(x));
		getView().setY(String.valueOf(y));
		y = y + Integer.valueOf(getView().getHeight()) + addedY;
		getView().setElement(element);
		getView().setLabel(element.getName());
	}
	
	protected abstract void makeCard(BasicElement element);
	
	@Override
	public String toString() {
		return "Card [view=" + view + ", name=" + name + ", description=" + description + "]";
	}
}
