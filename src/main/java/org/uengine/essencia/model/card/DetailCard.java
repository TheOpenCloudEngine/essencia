package org.uengine.essencia.model.card;

import org.uengine.contexts.TextContext;
import org.uengine.modeling.IElement;


public abstract class DetailCard implements Card{

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
		
	public DetailCard(){
		this.name = new TextContext();
	}
	
	protected abstract void makeCard(IElement element, IElement parentElement);
	
	@Override
	public String toString() {
		return "DetailCard [name=" + name + ", img=" + img + ", parentName=" + parentName + "]";
	}
	
}
