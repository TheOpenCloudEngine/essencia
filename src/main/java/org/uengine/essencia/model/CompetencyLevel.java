package org.uengine.essencia.model;

import java.util.List;

import org.metaworks.annotation.Face;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.Name;
import org.metaworks.annotation.Order;
import org.uengine.essencia.model.face.list.CheckPointListFace;
import org.uengine.essencia.model.view.CompetencyLevelView;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.IElement;

public class CompetencyLevel extends LanguageElement implements IElement, FaceTransformer {

	private List<CheckPoint> list;
	private transient CheckPointListFace listFace;

	private String name;
	private String briefDescription;
	private ElementView elementView;
	private int level;

	@Name
	@Order(1)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Order(2)
	public String getBriefDescription() {
		return briefDescription;
	}

	public void setBriefDescription(String briefDescription) {
		this.briefDescription = briefDescription;
	}

	@Hidden
	public List<CheckPoint> getList() {
		return list;
	}

	public void setList(List<CheckPoint> list) {
		this.list = list;
	}

	@Face(displayName = "CheckPoint")
	@Order(4)
	public CheckPointListFace getListFace() {
		return listFace;
	}

	public void setListFace(CheckPointListFace listFace) {
		this.listFace = listFace;
	}

	@Order(3)
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public CompetencyLevel() {
		setListFace(new CheckPointListFace());
	}

	public Essence.Competency.CompetencyLevel toXmi() {
		Essence.Competency.CompetencyLevel competencyLevel = Essence.Competency.CompetencyFactory.eINSTANCE.createCompetencyLevel();

		// set alpha
		competencyLevel.setName(getName());
		competencyLevel.setBriefDescription(getBriefDescription());
		competencyLevel.setLevel(getLevel());
		for (CheckPoint checkPoint : getList()) {
			competencyLevel.getChecklistItem().add(checkPoint.toXmi());
		}
		return competencyLevel;
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
		return new CompetencyLevelView(this);
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
}