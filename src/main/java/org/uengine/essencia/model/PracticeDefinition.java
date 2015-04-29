package org.uengine.essencia.model;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import org.metaworks.ContextAware;
import org.metaworks.MetaworksContext;
import org.uengine.contexts.TextContext;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.model.adapter.EssenceXmiAPI;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.essencia.util.ElementUtil;
import org.uengine.kernel.EndActivity;
import org.uengine.kernel.GlobalContext;
import org.uengine.kernel.HumanActivity;
import org.uengine.kernel.Role;
import org.uengine.kernel.StartActivity;
import org.uengine.kernel.designer.ui.HumanActivityView;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.IElement;
import org.uengine.modeling.IModel;
import org.uengine.modeling.Relation;
import org.uengine.util.ObjectUtil;

public class PracticeDefinition implements Serializable, IModel, ContextAware {

	private static final long serialVersionUID = GlobalContext.SERIALIZATION_UID;

	private transient MetaworksContext metaworksContext;
	private String id;
	private TextContext name;
	private String description;
	private List<IElement> elementList;
	private List<Relation> relationList;

	public PracticeDefinition() {
		ContextUtil.setWhen(this, EssenciaContext.WHEN_EDIT);
	}

	@Override
	public MetaworksContext getMetaworksContext() {
		return metaworksContext;
	}

	@Override
	public void setMetaworksContext(MetaworksContext metaworksContext) {
		this.metaworksContext = metaworksContext;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAlias() {
		if (this.getName() == null) {
			return null;
		}

		return this.getName().getText();
	}

	public TextContext getName() {
		return name;
	}

	public void setName(TextContext name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<IElement> getElementList() {
		if (elementList == null) {
			setElementList(new ArrayList<IElement>());
		}
		return elementList;
	}

	public void setElementList(List<IElement> iElementList) {
		this.elementList = iElementList;
	}

	public void addElement(IElement iElementList) {
		if (getElementList() == null) {
			setElementList(new ArrayList<IElement>());
		}
		this.getElementList().add(iElementList);
	}

	public List<Relation> getRelationList() {
		if (this.relationList == null) {
			this.setRelationList(new ArrayList<Relation>());
		}
		return relationList;
	}

	public void setRelationList(List<Relation> relationList) {
		this.relationList = relationList;
	}

	public void addRelationList(Relation relationList) {
		if (getRelationList() == null) {
			setRelationList(new ArrayList<Relation>());
		}
		this.getRelationList().add(relationList);
	}

	public String getPracticeName() {
		String practiceName = "";
		for (IElement e : getElementList()) {
			if (e instanceof Practice) {
				practiceName = e.getName();
			}
		}
		return practiceName;
	}

	public IElement findCompetencyByName(String name) {
		Competency competency = new Competency();
		competency.setName(name);

		int pos = this.getElementList().indexOf(name);
		if (pos > -1) {
			return this.getElementList().get(pos);
		}
		return competency;
	}

	public List<Activity> findSameCompetencyActivities(String competencyName) {
		List<Activity> list = new ArrayList<Activity>();

		for (IElement element : this.getElementList()) {
			if (element instanceof Activity && competencyName.equals(((Activity) element).getCompetencyName())) {
				list.add((Activity) element);
			}
		}

		return list;
	}

	private org.uengine.essencia.model.Activity castEssenciaActivity(IElement element) {
		return ((org.uengine.essencia.model.Activity) element);
	}

	public List<ElementView> converToProcessAsElementViewList(PracticeDefinition practice) throws Exception {
		List<ElementView> elementViewList = new ArrayList<ElementView>();
		ElementView roleView = null;
		int laneCnt = 0;
		ElementView humanView = null;
		for (IElement element : practice.getElementList()) {
			if (element instanceof org.uengine.essencia.model.Activity) {
				String roleName = castEssenciaActivity(element).getCompetencyName();

				Competency competency = (Competency) practice.findCompetencyByName(roleName);

				int pos = elementViewList.indexOf(competency);
				if (pos > -1) {
					roleView = elementViewList.get(pos);

				} else {

					List<org.uengine.essencia.model.Activity> lists = practice.findSameCompetencyActivities(roleName);

					Role role = new Role(roleName);
					role.setDisplayName(role.getName());
					roleView = role.createView();

					roleView.setWidth(calculateLaneWidth(lists) + 40 + 192);
					roleView.setHeight("128");
					roleView.setX(48 + Integer.valueOf(roleView.getWidth()) / 2);
					roleView.setY(40 + Integer.valueOf(roleView.getHeight()) / 2 + laneCnt * Integer.valueOf(roleView.getHeight()));
					roleView.setShapeId("OG.shape.HorizontalLaneShape");
					roleView.setLabel(role.getName());

					roleView.setElement(role);

					elementViewList.add(roleView);

					laneCnt++;
				}

				HumanActivity human = new HumanActivity();
				humanView = human.createView();

				String activityName = castEssenciaActivity(element).getName();

				human.setRole(new Role(roleName));
				human.getRole().setDisplayName(roleName);
				human.setName(activityName);

				humanView.setLabel(activityName);
				humanView.setShapeId("OG.shape.bpmn.A_HumanTask");
				humanView.setHeight("96");
				humanView.setWidth("96");

				int laneX = Integer.valueOf(roleView.getX());
				int laneHalfWidth = Integer.valueOf(roleView.getWidth()) / 2;
				int prevActivitiesCnt = prevActivitiesCntWithSameCompetency(elementViewList, competency);
				int humanX = Integer.valueOf(humanView.getWidth()) * prevActivitiesCnt;

				int rst = laneX - laneHalfWidth + humanX;
				rst = rst + 64 * prevActivitiesCnt;

				humanView.setX(rst);
				humanView.setY(roleView.getY());

				// setTool
				// http://localhost:8080/essencia/CardService.jsp?className=org.uengine.essencia.CardTest&practiceName=ScrumUPMethod&elementName=Design_the_program&type=method
				StringBuffer url = new StringBuffer("http://");
				url.append(InetAddress.getLocalHost().getHostAddress());
				url.append(":");
				url.append(GlobalContext.getPropertyString("port", "9999"));
				url.append("/essencia/CardService.jsp?className=org.uengine.essencia.Activity");
				url.append("&practiceName=" + getPracticeName());
				url.append("&elementName=" + activityName);
				url.append("&type=" + "method");
				human.setTool(url.toString());

				humanView.setElement(human);
				elementViewList.add(humanView);

				if (elementViewList.size() == 2) {
					StartActivity s = new StartActivity();
					s.setTracingTag("0");
					ElementView view = s.createView();
					view.setElement(s);
					view.setShapeId("OG.shape.bpmn.E_Start");
					view.setHeight("32");
					view.setWidth("32");
					int temp = Integer.valueOf(humanView.getX()) - 83;

					view.setX(temp);
					view.setY(humanView.getY());
					elementViewList.add(view);

				}
			}
		}

		if (elementViewList.size() != 0) {
			EndActivity e = new EndActivity();
			e.setTracingTag("99");
			ElementView view = e.createView();
			view.setElement(e);
			view.setShapeId("OG.shape.bpmn.E_End");
			view.setHeight("32");
			view.setWidth("32");
			int temp = Integer.valueOf(humanView.getX()) + 83;

			view.setX(temp);
			view.setY(humanView.getY());
			elementViewList.add(view);
		} else {
			throw new Exception("There is no activity.");
		}

		return elementViewList;
	}

	private int calculateLaneWidth(List<org.uengine.essencia.model.Activity> list) {
		return list.size() * 96;
	}

	private int prevActivitiesCntWithSameCompetency(List<ElementView> list, Competency c) {
		int cnt = 1;
		for (ElementView v : list) {
			if (v instanceof HumanActivityView && ((HumanActivity) v.getElement()).getRole().getDisplayName().getText().equals(c.getName())) {
				cnt++;
			}
		}
		return cnt;
	}

	public IElement getElementByName(String name) {
		IElement languageElement = null;
		for (IElement e : getElementList()) {
			if (name.equals(e.getName())) {
				languageElement = e;
				break;
			}
		}
		return languageElement;
	}

	public <T extends LanguageElement> T getElement(String elementName, Class<T> clazz) {
		IElement languageElement = this.getElementByName(elementName);
		if (clazz.isInstance(languageElement)) {
			return (T) languageElement;
		}
		return null;
	}

	/*
	 * Get essence element with from edge.
	 */
	public IElement getElementWithFromEdge(String fromEdge) {
		IElement element = null;

		for (IElement e : getElementList()) {
			if (fromEdge.equals(e.getElementView().getFromEdge())) {
				element = e;
				break;
			}
		}
		return element;
	}

	public <T> List<T> getElements(Class<T> clazz) {
		List<T> elementList = new ArrayList<T>();
		for (IElement e : getElementList()) {
			if (clazz.isInstance(e)) {
				elementList.add((T) e);
			}
		}
		return elementList;
	}

	public IElement pickElementByViewId(String id) {
		IElement element = null;
		for (IElement e : getElementList()) {
			String[] stringArrays = id.split("_");
			String temp = stringArrays[0] + "_" + stringArrays[1] + "_" + stringArrays[2];
			if (temp.equals(e.getElementView().getId())) {
				element = e;
				break;
			}
		}
		return element;
	}

	private transient List<BasicElement> returnElementList = new ArrayList<BasicElement>();

	public List<BasicElement> findParentElements(ElementView view) {

		if (view.getFromEdge() != null) {
			String[] fromEdges = view.getFromEdge().split(",");
			for (IElement element : getElementList()) {
				if (element.getElementView().getToEdge() != null) {

					String[] toEdges = element.getElementView().getToEdge().split(",");
					for (String toEdge : toEdges) {
						for (String fromEdge : fromEdges) {
							if (toEdge.equals(fromEdge)) {
								returnElementList.add((BasicElement) element);
								findParentElements(element.getElementView());
							}
						}
					}
				}
			}
		}
		return returnElementList;
	}

	public Relation findFromRelation(ElementView view) {
		Relation returnRelation = null;
		for (Relation relation : getRelationList()) {
			for (String edge : view.getFromEdge().split(",")) {
				if (relation.getRelationView().getId().equals(edge)) {
					returnRelation = relation;
				}
			}
		}
		return returnRelation;
	}

	public List<Relation> findFromRelations(ElementView view) {
		List<Relation> returnRelations = new ArrayList<Relation>();
		if (view.getFromEdge() != null) {
			for (String edge : view.getFromEdge().split(",")) {
				for (Relation relation : getRelationList()) {
					if (relation.getRelationView().getId().equals(edge)) {
						returnRelations.add(relation);
					}
				}
			}
		}
		return returnRelations;

	}

	public List<Relation> findToRelation(ElementView view) {
		List<Relation> returnRelations = new ArrayList<Relation>();
		if (view.getToEdge() != null) {
			for (String edge : view.getToEdge().split(",")) {
				for (Relation relation : getRelationList()) {
					if (relation.getRelationView().getId().equals(edge)) {
						returnRelations.add(relation);
					}
				}
			}
		}
		return returnRelations;
	}

	public List<IElement> findChildElements(ElementView view) {
		List<IElement> elementList = new ArrayList<IElement>();
		if (view.getToEdge() != null) {
			String[] toEdges = view.getToEdge().split(",");
			for (ElementView elementView : ElementUtil.convertToElementViewList(getElementList())) {
				for (String edge : toEdges) {
					if (elementView.getFromEdge() != null) {
						for (String fromEdge : elementView.getFromEdge().split(",")) {
							if (edge.equals(fromEdge)) {
								elementList.add(ObjectUtil.convertToElementHasView(elementView));
							}
						}
					}
				}
			}
		}
		return elementList;
	}

	public void changeRelation(ElementView newTarget, IElement target) {
		if (target.getElementView().getToEdge() != null) {
			String[] edges = target.getElementView().getToEdge().split(",");
			for (String edge : edges) {
				for (Relation relation : getRelationList()) {
					if (relation.getRelationView().getId().equals(edge)) {

						relation.getRelationView().setFromWithTerminal(newTarget.getId());
						newTarget.addToEdge(relation.getRelationView().getId());
					}
				}
			}
		}
	}

	public void toXmi() {
		EssenceXmiAPI essenceXmiAPI = new EssenceXmiAPI(this);
		essenceXmiAPI.toXmi();
	}

	public void afterDeserialize() {
		addActivityToActivitySpace();

		addCheckpointToState();
	}

	private void addActivityToActivitySpace() {
		for (ActivitySpace activitySpace : getElements(ActivitySpace.class)) {
			activitySpace.addActivity(this);
		}
	}

	private void addCheckpointToState() {
		List<Activity> activityList = this.getElements(Activity.class);
		for (Activity activity : activityList) {
			if( activity.getCompletionCriteria() != null){
				for (LanguageElement e : activity.getCompletionCriteria()) {
					Criterion criterion = (Criterion) e;
					State state = criterion.getState();
					State fullState = getState(criterion.getState().getParentAlpha().getName(), state.getName());
					if (fullState != null) {
						state.setListFace(fullState.getListFace());
					}
				}
			}
		}
	}

	public State getState(String alphaName, String stateName) {
		List<Alpha> alphaList = this.getElements(Alpha.class);
		for (Alpha alpha : alphaList) {
			if (alpha.getName().equals(alphaName)) {
				for (State state : alpha.getList()) {
					if (state.getName().equals(stateName))
						return state;
				}
			}
		}
		return null;
	}

	public void beforeSerialize() {

	}

}