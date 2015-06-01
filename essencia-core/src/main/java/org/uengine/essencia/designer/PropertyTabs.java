package org.uengine.essencia.designer;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.metaworks.annotation.Face;
import org.uengine.modeling.IProperty;

public class PropertyTabs {

	private List<IProperty> items;

	public PropertyTabs(){
		this.items = new ArrayList<IProperty>();
	}
	
	@Valid
	@Face(ejsPath="dwr/metaworks/genericfaces/TabFace.ejs")
	public List<IProperty> getItems() {
		return items;
	}
	public void setItems(List<IProperty> items) {
		this.items = items;
	}

	
}
