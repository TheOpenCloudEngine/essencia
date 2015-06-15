package org.uengine.essencia.model;

import java.util.List;

import org.metaworks.annotation.Face;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.Name;
import org.metaworks.annotation.Order;
import org.uengine.contexts.TextContext;
import org.uengine.essencia.model.face.list.CheckPointListFace;
import org.uengine.essencia.model.view.LevelOfDetailView;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.IElement;

public class LevelOfDetail extends LanguageElement implements IElement, FaceTransformer {

	private List<CheckPoint> list;
	private transient CheckPointListFace listFace;

	private ElementView elementView;
	private WorkProduct parentWorkProduct;

	private TextContext name;
		@Name
		@Order(1)
		public String getName() {
			if (this.name == null) {
				return "";
			}
			return name.getText();
		}

		public void setName(String name) {
			if (this.name == null) {
				this.name = new TextContext();
			}
			this.name.setText(name);
		}

		public String getName(String locale) {
			return name.getText(locale);
		}

		public void setName(String locale, String name) {
			this.name.setText(locale, name);
		}

	private TextContext description;
	private boolean isSufficientLevel;
	private String aggregationAlphaState;

	@Hidden
	public List<CheckPoint> getList() {
		return list;
	}

	public void setList(List<CheckPoint> list) {
		this.list = list;
	}

	@Order(3)
	@Face(displayName = "CheckPoint")
	public CheckPointListFace getListFace() {
		return listFace;
	}

	public void setListFace(CheckPointListFace listFace) {
		this.listFace = listFace;
	}

	public boolean isSufficientLevel() {
		return isSufficientLevel;
	}

	public void setSufficientLevel(boolean isSufficientLevel) {
		this.isSufficientLevel = isSufficientLevel;
	}

	@Hidden
	public WorkProduct getParentWorkProduct() {
		return parentWorkProduct;
	}

	public void setParentWorkProduct(WorkProduct parentWorkProduct) {
		this.parentWorkProduct = parentWorkProduct;
	}


	@Order(2)
	public String getDescription() {
		if (this.description == null) {
			return "";
		}
		return description.getText();
	}

	public void setDescription(String description) {
		if (this.description == null) {
			this.description = new TextContext();
		}
		this.description.setText(description);
	}

	public String getDescription(String locale) {
		return description.getText(locale);
	}

	public void setDescription(String locale, String description) {
		this.description.setText(locale, description);
	}

	public LevelOfDetail() {
		setListFace(new CheckPointListFace());
	}

	public LevelOfDetail(String name) {
		setName(name);
	}

	public Essence.AlphaAndWorkProduct.LevelOfDetail toXmi() {
		Essence.AlphaAndWorkProduct.LevelOfDetail levelOfDetail = Essence.AlphaAndWorkProduct.AlphaAndWorkProductFactory.eINSTANCE
				.createLevelOfDetail();

		// set alpha
		levelOfDetail.setName(getName());
		levelOfDetail.setDescription(getDescription());

		for (CheckPoint checkPoint : getList()) {
			levelOfDetail.getCheckListItem().add(checkPoint.toXmi());
		}
		return levelOfDetail;
	}

	@Hidden
	@Override
	public ElementView getElementView() {
		return this.elementView;
	}

	@Override
	public void setElementView(ElementView elementView) {
		this.elementView = elementView;
	}

	@Override
	public ElementView createView() {
		return new LevelOfDetailView(this);
	}

	@Override
	public void setUpElement() {
		setListFace(new CheckPointListFace());
		if (getList() != null) {
			getListFace().fillElements(getList());
			getList().clear();
		}
	}

	@Override
	public void beforeApply() {
		setList(getListFace().createValue());
	}

	public String getAggregationAlphaState() {
		return aggregationAlphaState;
	}

	public void setAggregationAlphaState(String aggregationAlphaState) {
		this.aggregationAlphaState = aggregationAlphaState;
	}
}