package org.uengine.essencia.model.adapter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.uengine.contexts.TextContext;
import org.uengine.essencia.model.Activity;
import org.uengine.essencia.model.ActivitySpace;
import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.CheckPoint;
import org.uengine.essencia.model.Competency;
import org.uengine.essencia.model.CompetencyLevel;
import org.uengine.essencia.model.CompletionCriterion;
import org.uengine.essencia.model.Criterion;
import org.uengine.essencia.model.LanguageElement;
import org.uengine.essencia.model.LevelOfDetail;
import org.uengine.essencia.model.Practice;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.model.State;
import org.uengine.essencia.model.WorkProduct;
import org.uengine.essencia.model.XMIElement;
import org.uengine.essencia.model.XMIResourceElement;
import org.uengine.essencia.resource.FolderResourceType;
import org.uengine.essencia.resource.ResourceType;
import org.uengine.kernel.GlobalContext;
import org.uengine.modeling.*;
import org.uengine.uml.model.CompositionRelation;
import org.uengine.uml.ui.CompositionRelationView;
import org.uengine.util.FileUtil;

import Essence.ActivitySpaceAndActivity.AbstractActivity;
import Essence.ActivitySpaceAndActivity.EntryCriterion;
import Essence.Foundation.BasicElement;

public class EssenceXmiAPI {

	PracticeDefinition practiceDefinition = null;

	public String xmiPath = null;

	public EssenceXmiAPI() {

	}

	public EssenceXmiAPI(PracticeDefinition practiceDefinition) {
		this.practiceDefinition = practiceDefinition;
	}

	public String getExportPath() {
		String exportFolder = org.uengine.essencia.resource.Resource.getCodebase() + FolderResourceType.DOWNLOAD_TEMP_FOLDER.getName()
				+ File.separator;
		FileUtil.createFolders(exportFolder);
		return exportFolder + practiceDefinition.getName() + ResourceType.ESSENCE_RESOURCE.getType();
	}

	public void toXmi() {
		Essence.Foundation.FoundationPackage.eINSTANCE.eClass();

		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(ResourceType.ESSENCE_RESOURCE.getType().substring(1),
				new XMLResourceFactoryImpl());

		ResourceSet resSet = new ResourceSetImpl();

		Resource resource = resSet.createResource(URI.createFileURI(getExportPath()));

		Essence.Foundation.Practice practice = addEssenceElement();

		practice = addEssenceElementAssociation(practice);

		resource.getContents().add(practice);

		save(resSet);
	}

	/*
	 * Add essence language element to practice
	 */
	private Essence.Foundation.Practice addEssenceElement() {
		Essence.Foundation.Practice practice = Essence.Foundation.FoundationFactory.eINSTANCE.createPractice();
		practice.setName(practiceDefinition.getPracticeName());
		practice.setDescription(((org.uengine.essencia.model.BasicElement) practiceDefinition.getElementByName(practiceDefinition.getPracticeName()))
				.getDescription());

		for (XMIResourceElement element : practiceDefinition.getElements(XMIResourceElement.class)) {
			practice.getOwnedElements().add(element.toXmi());
		}
		for (XMIElement element : practiceDefinition.getElements(XMIElement.class)) {
			practice.getOwnedElements().add(element.toXmi(practice));
		}

		return practice;
	}

	/*
	 * Add essence language element association to practice
	 */
	private Essence.Foundation.Practice addEssenceElementAssociation(Essence.Foundation.Practice practice) {
		for (IElement e : practiceDefinition.getElementList()) {

			if (e.getElementView().getToEdge() == null)
				continue;

			String[] toEdges = e.getElementView().getToEdge().split(",");
			for (String toEdge : toEdges) {
				IElement toEdgeEle = getEssenciaElementWithFromEdge(toEdge);
				Essence.Foundation.LanguageElement essenceEle = getEssenceElementAssociation(e, toEdgeEle, practice);
				if (essenceEle != null) {
					practice.getOwnedElements().add(essenceEle);
				}
			}
		}
		return practice;
	}

	/*
	 * Get essence element with from edge.
	 */
	private IElement getEssenciaElementWithFromEdge(String fromEdge) {
		IElement element = null;

		for (IElement e : practiceDefinition.getElementList()) {
			if (fromEdge.equals(e.getElementView().getFromEdge())) {
				element = e;
				break;
			}
		}
		return element;
	}

	/*
	 * Get essence element association instance with essencia from and to
	 * language element.
	 */
	private Essence.Foundation.LanguageElement getEssenceElementAssociation(IElement fromEle, IElement toEle, Essence.Foundation.Practice practice) {
		Essence.Foundation.LanguageElement essenceEle = null;

		if (fromEle instanceof ActivitySpace && toEle instanceof Activity) {
			Essence.ActivitySpaceAndActivity.ActivityAssociation aas = Essence.ActivitySpaceAndActivity.impl.ActivitySpaceAndActivityFactoryImpl.eINSTANCE
					.createActivityAssociation();
			aas.setEnd1((AbstractActivity) matchEssencia2EssenceElement(fromEle, practice));
			aas.setEnd2((AbstractActivity) matchEssencia2EssenceElement(toEle, practice));
			essenceEle = aas;
		} else if (fromEle instanceof Activity && toEle instanceof Activity) {
			Essence.ActivitySpaceAndActivity.ActivityAssociation aas = Essence.ActivitySpaceAndActivity.impl.ActivitySpaceAndActivityFactoryImpl.eINSTANCE
					.createActivityAssociation();
			aas.setEnd1((AbstractActivity) matchEssencia2EssenceElement(fromEle, practice));
			aas.setEnd2((AbstractActivity) matchEssencia2EssenceElement(toEle, practice));
			essenceEle = aas;
		} else if (fromEle instanceof Alpha && toEle instanceof Alpha) {
			Essence.AlphaAndWorkProduct.AlphaAssociation aas = Essence.AlphaAndWorkProduct.impl.AlphaAndWorkProductFactoryImpl.eINSTANCE
					.createAlphaAssociation();
			aas.setEnd1((Essence.AlphaAndWorkProduct.Alpha) matchEssencia2EssenceElement(fromEle, practice));
			aas.setEnd2((Essence.AlphaAndWorkProduct.Alpha) matchEssencia2EssenceElement(toEle, practice));
			essenceEle = aas;
		} else if (fromEle instanceof Alpha && toEle instanceof WorkProduct) {
			Essence.AlphaAndWorkProduct.WorkProductManifest wpm = Essence.AlphaAndWorkProduct.impl.AlphaAndWorkProductFactoryImpl.eINSTANCE
					.createWorkProductManifest();
			wpm.setAlpha((Essence.AlphaAndWorkProduct.Alpha) matchEssencia2EssenceElement(fromEle, practice));
			wpm.setWorkProduct((Essence.AlphaAndWorkProduct.WorkProduct) matchEssencia2EssenceElement(toEle, practice));
			essenceEle = wpm;
		} else if (fromEle instanceof Practice) {
			Essence.Foundation.PracticeAsset practiceAsset = Essence.Foundation.impl.FoundationFactoryImpl.eINSTANCE.createPracticeAsset();
			practiceAsset.getReferredElements().add(matchEssencia2EssenceElement(toEle, practice));
			essenceEle = practiceAsset;
		}
		return essenceEle;
	}

	/*
	 * Match essencia element with essence element
	 */
	private Essence.Foundation.LanguageElement matchEssencia2EssenceElement(IElement essenciaEle, Essence.Foundation.Practice practice) {
		Essence.Foundation.LanguageElement element = null;
		if (essenciaEle instanceof Activity) {
			element = getEssenceElement(essenciaEle.getName(), Essence.ActivitySpaceAndActivity.Activity.class, practice);
		} else if (essenciaEle instanceof ActivitySpace) {
			element = getEssenceElement(essenciaEle.getName(), Essence.ActivitySpaceAndActivity.ActivitySpace.class, practice);
		} else if (essenciaEle instanceof Alpha) {
			element = getEssenceElement(essenciaEle.getName(), Essence.AlphaAndWorkProduct.Alpha.class, practice);
		} else if (essenciaEle instanceof WorkProduct) {
			element = getEssenceElement(essenciaEle.getName(), Essence.AlphaAndWorkProduct.WorkProduct.class, practice);
		} else if (essenciaEle instanceof Competency) {
			element = getEssenceElement(essenciaEle.getName(), Essence.Competency.Competency.class, practice);
		}
		return element;
	}

	/*
	 * Get essence language element from practice
	 */
	private <T> Essence.Foundation.LanguageElement getEssenceElement(String elementName, Class<T> clazz, Essence.Foundation.Practice practice) {
		List<T> elements = getEssenceElementList(clazz, practice);
		Essence.Foundation.BasicElement element = null;
		for (T t : elements) {
			if (((BasicElement) t).getName().equals(elementName)) {
				element = (BasicElement) t;
			}
		}
		return element;
	}

	/*
	 * Get essence language element list from practice
	 */
	private <T> List<T> getEssenceElementList(Class<T> clazz, Essence.Foundation.Practice practice) {
		List<T> elements = new ArrayList<T>();
		for (Essence.Foundation.LanguageElement e : practice.getOwnedElements()) {
			if (clazz.isInstance(e)) {
				elements.add((T) e);
			}
		}
		return elements;
	}

	/*
	 * Save essence resource to xmi file.
	 */
	private void save(ResourceSet resSet) {
		Iterator<Resource> r = resSet.getResources().iterator();
		while (r.hasNext()) {
			Resource res = (Resource) r.next();
			Map<String, Object> options = new HashMap<String, Object>();
			options.put(XMIResource.OPTION_DECLARE_XML, Boolean.TRUE);
			options.put(XMIResource.OPTION_ENCODING, GlobalContext.ENCODING);
			try {
				res.save(options);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public PracticeDefinition importXmi() {
		Essence.Foundation.FoundationPackage.eINSTANCE.eClass();

		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(ResourceType.ESSENCE_RESOURCE.getType().substring(1),
				new XMLResourceFactoryImpl());

		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.getResource(URI.createFileURI(xmiPath), true);
		Essence.Foundation.Practice practice = (Essence.Foundation.Practice) resource.getContents().get(0);

		PracticeDefinition pd = new PracticeDefinition();
		TextContext tc = new TextContext();
		tc.setText(practice.getName());	
		pd.setName(tc);

		for (Essence.Foundation.LanguageElement essenceEle : practice.getOwnedElements()) {
			IElement e = getEssenciaElement(essenceEle, practice.getOwnedElements());
			if (e != null)
				pd.addElement(e);
		}

		for (Essence.Foundation.LanguageElement essenceEle : practice.getOwnedElements()) {
			Relation relation = getEssenciaRelation(essenceEle);
			if (relation != null)
				pd.getRelationList().add(getEssenciaRelation(essenceEle));
		}

		addPracticeRelation(practice, pd);

		pd = setAutoLayout(pd);

		return pd;
	}

	private boolean compareElements(IElement source, IElement target) {
		if (source.getClass().getName().equals(target.getClass().getName()) && source.getName().equals(target.getName()))
			return true;
		return false;
	}

	private List<IRelation> loadRelation(List<IRelation> relationList, List<IElement> elementList) {
		for (int i = 0; i < relationList.size(); i++) {
			IElement from = relationList.get(i).getSourceElement();
			IElement to = relationList.get(i).getTargetElement();

			RelationView relationView = relationList.get(i).createView();
			Symbol symbol = relationView.createSymbol();
			relationView.fill(symbol);
			relationView.setShapeId(CompositionRelationView.SHAPE_ID);

			for (IElement element : elementList) {
				if (compareElements(from, element)) {
					relationList.get(i).getSourceElement().setElementView(element.getElementView());
					relationView.setFrom(element.getElementView().getId() + "_TERMINAL_C_INOUT_0");
				}
				if (compareElements(to, element)) {
					relationList.get(i).getTargetElement().setElementView(element.getElementView());
					relationView.setTo(element.getElementView().getId() + "_TERMINAL_C_OUT_0");
				}
			}
			relationList.get(i).setRelationView(relationView);
		}
		return relationList;
	}

	private int createCanvasId() {
		return (int) Math.floor(Math.random() * 10000);
	}

	private PracticeDefinition setAutoLayout(PracticeDefinition pd) {

		List<IElement> tmpElementList = null;
		int canvasId = createCanvasId();
		int i = 0;

		for (; i < pd.getElementList().size(); i++) {
			String id = String.format("OG_%04d_%04d", canvasId, i);
			ElementView elementView = pd.getElementList().get(i).createView();
			Symbol symbol = elementView.createSymbol();
			elementView.fill(symbol);
			elementView.setId(id);
			pd.getElementList().get(i).setElementView(elementView);
		}

		tmpElementList = pd.getElementList();
		List<IRelation> relationList = loadRelation(pd.getRelationList(), tmpElementList);

		for (int j = 0; j < relationList.size(); ++i, j++) {
			String id = String.format("OG_%04d_%04d", canvasId, i);
			pd.getRelationList().get(j).getRelationView().setId(id);
		}

		for (int j = 0; j < pd.getElementList().size(); j++) {
			String fromEdge = null;
			String toEdge = null;
			IElement element = pd.getElementList().get(j);

			for (IRelation relation : relationList) {
				if (compareElements(element, relation.getTargetElement())) {
					if (fromEdge == null)
						fromEdge = relation.getRelationView().getId();
					else
						fromEdge += "," + relation.getRelationView().getId();
				}
				if (compareElements(element, relation.getSourceElement())) {
					if (toEdge == null)
						toEdge = relation.getRelationView().getId();
					else
						toEdge += "," + relation.getRelationView().getId();
				}
			}
			pd.getElementList().get(j).getElementView().setFromEdge(fromEdge);
			pd.getElementList().get(j).getElementView().setToEdge(toEdge);
		}

		return autoLocatePractice(pd);
	}

	private PracticeDefinition autoLocatePractice(PracticeDefinition pd) {
		List<IElement> elementList = pd.getElementList();
		for (int i = 0; i < elementList.size(); i++) {
			if (elementList.get(i) instanceof Practice) {
				IElement removedElement = pd.getElementList().remove(i);
				removedElement.getElementView().setX("96");
				removedElement.getElementView().setY("96");
				String[] toEdges = removedElement.getElementView().getToEdge().split(",");
				pd.setElementList(autoLocateElements(pd.getElementList(), toEdges, 1, 0));
				pd.getElementList().add(removedElement);
			}
		}
		return pd;
	}

	private boolean hasToElement(IElement element) {
		if (element.getElementView().getToEdge() == null)
			return false;
		return true;
	}

	private String[] splitElementEdges(IElement element) {
		return element.getElementView().getToEdge().split(",");
	}

	private List<IElement> autoLocateElements(List<IElement> elements, String[] toEdges, int x, int y) {
		List<IElement> tmpList = new ArrayList<IElement>();
		List<IElement> returnList = new ArrayList<IElement>();
		for (int i = 0; i < toEdges.length; i++, y++) {
			for (int j = 0; j < elements.size(); j++) {
				if (toEdges[i].equals(elements.get(j).getElementView().getFromEdge())) {
					elements.get(j).getElementView().setX(96 + x * 150);
					elements.get(j).getElementView().setY(96 + y * 110);
					IElement removedElement = elements.remove(j);
					returnList.add(removedElement);
					if (hasToElement(removedElement)) {
						tmpList = autoLocateElements(elements, splitElementEdges(removedElement), x + 1, y);
						for (IElement element : tmpList) {
							returnList.add(element);
						}
					}
				}
			}
		}
		return returnList;
	}

	public void setXmiPath(String xmiPath) {
		this.xmiPath = xmiPath;
	}

	private IElement getEssenciaElement(Essence.Foundation.LanguageElement essenceElement, EList<Essence.Foundation.LanguageElement> essenceElements) {
		IElement element = null;
		if (essenceElement instanceof Essence.AlphaAndWorkProduct.Alpha) {
			Alpha alpha = new Alpha();
			alpha.setList(new ArrayList<State>());
			alpha.setName(((Essence.AlphaAndWorkProduct.Alpha) essenceElement).getName());
			alpha.setDescription(((Essence.AlphaAndWorkProduct.Alpha) essenceElement).getDescription());

			EList<Essence.AlphaAndWorkProduct.State> states = ((Essence.AlphaAndWorkProduct.Alpha) essenceElement).getStates();
			for (Essence.AlphaAndWorkProduct.State state : states) {
				State s = new State();
				s.setList(new ArrayList<CheckPoint>());
				s.setName(state.getName());
				s.setDescription(state.getDescription());

				for (Essence.Foundation.Checkpoint cp : state.getCheckListItem()) {
					CheckPoint c = new CheckPoint();
					c.setName(cp.getName());
					c.setDescription(cp.getDescription());
					s.getList().add(c);
				}
				alpha.getList().add(s);
			}
			element = alpha;
		} else if (essenceElement instanceof Essence.AlphaAndWorkProduct.WorkProduct) {
			WorkProduct workProduct = new WorkProduct();
			workProduct.setList(new ArrayList<LevelOfDetail>());
			workProduct.setName(((Essence.AlphaAndWorkProduct.WorkProduct) essenceElement).getName());
			workProduct.setDescription(((Essence.AlphaAndWorkProduct.WorkProduct) essenceElement).getDescription());

			EList<Essence.AlphaAndWorkProduct.LevelOfDetail> levels = ((Essence.AlphaAndWorkProduct.WorkProduct) essenceElement).getLevelOfDetail();
			for (Essence.AlphaAndWorkProduct.LevelOfDetail lod : levels) {
				LevelOfDetail l = new LevelOfDetail();
				l.setName(lod.getName());
				l.setDescription(lod.getDescription());

				workProduct.getList().add(l);
			}
			element = workProduct;
		} else if (essenceElement instanceof Essence.Competency.Competency) {
			Competency competency = new Competency();
			competency.setList(new ArrayList<CompetencyLevel>());
			competency.setName(((Essence.Competency.Competency) essenceElement).getName());
			competency.setDescription(((Essence.Competency.Competency) essenceElement).getDescription());

			for (Essence.Competency.CompetencyLevel cl : ((Essence.Competency.Competency) essenceElement).getPossibleLevel()) {
				CompetencyLevel c = new CompetencyLevel();
				c.setList(new ArrayList<CheckPoint>());
				c.setName(cl.getName());
				c.setBriefDescription(cl.getBriefDescription());
				c.setLevel(cl.getLevel());

				competency.getList().add(c);
			}
			element = competency;
		} else if (essenceElement instanceof Essence.ActivitySpaceAndActivity.Activity) {
			Activity activity = new Activity();
			activity.setEntryCriteria(new ArrayList<Criterion>());
			activity.setCompletionCriteria(new ArrayList<LanguageElement>());
			activity.setRequiredCompetencyLevel(new ArrayList<LanguageElement>());
			activity.setName(((Essence.ActivitySpaceAndActivity.Activity) essenceElement).getName());
			activity.setDescription(((Essence.ActivitySpaceAndActivity.Activity) essenceElement).getDescription());
			activity.setBriefDescription(((Essence.ActivitySpaceAndActivity.Activity) essenceElement).getBriefDescription());

			for (Essence.ActivitySpaceAndActivity.Criterion criterion : ((Essence.ActivitySpaceAndActivity.Activity) essenceElement).getCriterion()) {
				Criterion essenciaCriterion = null;
				if (criterion instanceof Essence.ActivitySpaceAndActivity.EntryCriterion) {
					essenciaCriterion = new org.uengine.essencia.model.EntryCriterion();
				} else {
					essenciaCriterion = new org.uengine.essencia.model.CompletionCriterion();
				}
				if (criterion.getState() != null) {
					essenciaCriterion.setUpState(criterion.getState().getName(), criterion.getState().getAlpha().getName());
					essenciaCriterion.getState().setDescription(criterion.getState().getDescription());
					essenciaCriterion.getState().getParentAlpha().setDescription(criterion.getState().getAlpha().getDescription());
					if (criterion instanceof EntryCriterion) {
						activity.getEntryCriteria().add(essenciaCriterion);
					} else {
						activity.getCompletionCriteria().add(essenciaCriterion);
					}
				} else if (criterion.getLevelOfDetail() != null) {
					essenciaCriterion.setUpLevelOfDetail(criterion.getLevelOfDetail().getName(), criterion.getLevelOfDetail().getWorkProduct()
							.getName());
					essenciaCriterion.getLevelOfDetail().setDescription(criterion.getLevelOfDetail().getDescription());
					essenciaCriterion.getLevelOfDetail().getParentWorkProduct()
							.setDescription(criterion.getLevelOfDetail().getWorkProduct().getDescription());
					activity.getCompletionCriteria().add(essenciaCriterion);
				}
			}
			for (Essence.Competency.CompetencyLevel competencyLevel : ((Essence.ActivitySpaceAndActivity.Activity) essenceElement)
					.getRequiredCompetencyLevel()) {
				for (Essence.Foundation.LanguageElement tempElement : essenceElements) {
					if (tempElement instanceof Essence.Competency.Competency) {
						for (Essence.Competency.CompetencyLevel tempLevel : ((Essence.Competency.Competency) tempElement).getPossibleLevel()) {
							if (tempLevel == competencyLevel) {
								CompetencyLevel essenciaCompetencyLevel = new CompetencyLevel();
								essenciaCompetencyLevel.setName(competencyLevel.getName());
								essenciaCompetencyLevel.setBriefDescription(competencyLevel.getBriefDescription());
								essenciaCompetencyLevel.setParentElementId(((Essence.Competency.Competency) tempElement).getName());
								activity.getRequiredCompetencyLevel().add(essenciaCompetencyLevel);
							}
						}
					}

				}

			}

			element = activity;
		} else if (essenceElement instanceof Essence.ActivitySpaceAndActivity.ActivitySpace) {
			ActivitySpace as = new ActivitySpace();

			as.setCompletionCriteria(new ArrayList<LanguageElement>());
			as.setName(((Essence.ActivitySpaceAndActivity.ActivitySpace) essenceElement).getName());
			as.setDescription(((Essence.ActivitySpaceAndActivity.ActivitySpace) essenceElement).getDescription());
			as.setBriefDescription(((Essence.ActivitySpaceAndActivity.ActivitySpace) essenceElement).getBriefDescription());

			for (Essence.ActivitySpaceAndActivity.Criterion criterion : ((Essence.ActivitySpaceAndActivity.ActivitySpace) essenceElement)
					.getCriterion()) {
				if (criterion.getState() != null) {
					State s = new State();
					s.setName(criterion.getState().getName());
					s.setDescription(criterion.getState().getDescription());

					Alpha a = new Alpha();
					a.setName(criterion.getState().getAlpha().getName());
					a.setDescription(criterion.getState().getAlpha().getDescription());

					Criterion essenciaCriterion = new CompletionCriterion();
					essenciaCriterion.setState(s);
					essenciaCriterion.getState().setParentAlpha(a);

					as.getCompletionCriteria().add(essenciaCriterion);
				}
			}

			if (((Essence.ActivitySpaceAndActivity.ActivitySpace) essenceElement).getInput() != null) {
				as.setInputList(new ArrayList<LanguageElement>());
				for (Essence.AlphaAndWorkProduct.Alpha essenceAlpha : ((Essence.ActivitySpaceAndActivity.ActivitySpace) essenceElement).getInput()) {
					Alpha alpha = new Alpha();
					alpha.setName(essenceAlpha.getName());
					alpha.setDescription(essenceAlpha.getDescription());
					alpha.setBriefDescription(essenceAlpha.getBriefDescription());
					as.getInputList().add(alpha);
				}
			}
			element = as;
		}

		return element;
	}

	private void addPracticeRelation(Essence.Foundation.Practice practice, PracticeDefinition pd) {
		Practice pc = new Practice();
		pc.setName(practice.getName());
		pc.setDescription(practice.getDescription());
		pd.addElement(pc);

		for (Essence.Foundation.LanguageElement essenceEle : practice.getOwnedElements()) {
			if (essenceEle instanceof Essence.Foundation.PracticeAsset) {
				for (Essence.Foundation.LanguageElement ele : ((Essence.Foundation.PracticeAsset) essenceEle).getReferredElements()) {
					org.uengine.essencia.model.BasicElement e = null;

					if (ele instanceof Essence.ActivitySpaceAndActivity.ActivitySpace) {
						e = new ActivitySpace();
						e.setName(((Essence.ActivitySpaceAndActivity.ActivitySpace) ele).getName());
						e.setDescription(((Essence.ActivitySpaceAndActivity.ActivitySpace) ele).getDescription());
					} else if (ele instanceof Essence.ActivitySpaceAndActivity.Activity) {
						e = new Activity();
						e.setName(((Essence.ActivitySpaceAndActivity.Activity) ele).getName());
						e.setDescription(((Essence.ActivitySpaceAndActivity.Activity) ele).getDescription());
					} else if (ele instanceof Essence.AlphaAndWorkProduct.Alpha) {
						e = new Alpha();
						e.setName(((Essence.AlphaAndWorkProduct.Alpha) ele).getName());
						e.setDescription(((Essence.AlphaAndWorkProduct.Alpha) ele).getDescription());
					} else if (ele instanceof Essence.Competency.Competency) {
						e = new Competency();
						e.setName(((Essence.Competency.Competency) ele).getName());
						e.setDescription(((Essence.Competency.Competency) ele).getDescription());
					}

					if (e != null) {
						Relation relation = new Relation();
						relation.setSourceElement(pc);
						relation.setTargetElement(e);
						pd.getRelationList().add(relation);
					}
				}
			}
		}
	}

	private Relation getEssenciaRelation(Essence.Foundation.LanguageElement essenceEle) {
		Relation relation = null;
		if (essenceEle instanceof Essence.AlphaAndWorkProduct.WorkProductManifest) {
			relation = new CompositionRelation();

			Alpha a = new Alpha();
			a.setName(((Essence.AlphaAndWorkProduct.WorkProductManifest) essenceEle).getAlpha().getName());
			a.setDescription(((Essence.AlphaAndWorkProduct.WorkProductManifest) essenceEle).getAlpha().getDescription());

			WorkProduct wp = new WorkProduct();
			wp.setName(((Essence.AlphaAndWorkProduct.WorkProductManifest) essenceEle).getWorkProduct().getName());
			wp.setDescription(((Essence.AlphaAndWorkProduct.WorkProductManifest) essenceEle).getWorkProduct().getDescription());

			relation.setSourceElement(a);
			relation.setTargetElement(wp);
		} else if (essenceEle instanceof Essence.AlphaAndWorkProduct.AlphaAssociation) {
			relation = new CompositionRelation();

			Alpha a1 = new Alpha();
			a1.setName(((Essence.AlphaAndWorkProduct.AlphaAssociation) essenceEle).getEnd1().getName());
			a1.setDescription(((Essence.AlphaAndWorkProduct.AlphaAssociation) essenceEle).getEnd1().getDescription());

			Alpha a2 = new Alpha();
			a2.setName(((Essence.AlphaAndWorkProduct.AlphaAssociation) essenceEle).getEnd2().getName());
			a2.setDescription(((Essence.AlphaAndWorkProduct.AlphaAssociation) essenceEle).getEnd2().getDescription());

			relation.setSourceElement(a1);
			relation.setTargetElement(a2);
		} else if (essenceEle instanceof Essence.ActivitySpaceAndActivity.ActivityAssociation) {
			relation = new CompositionRelation();
			Essence.ActivitySpaceAndActivity.AbstractActivity end1 = ((Essence.ActivitySpaceAndActivity.ActivityAssociation) essenceEle).getEnd1();
			Essence.ActivitySpaceAndActivity.AbstractActivity end2 = ((Essence.ActivitySpaceAndActivity.ActivityAssociation) essenceEle).getEnd2();

			org.uengine.essencia.model.BasicElement e1 = null;
			org.uengine.essencia.model.BasicElement e2 = null;

			if (end1 instanceof Essence.ActivitySpaceAndActivity.ActivitySpace) {
				e1 = new ActivitySpace();
				e1.setName(end1.getName());
				e1.setDescription(end1.getDescription());
			} else {
				e1 = new Activity();
				e1.setName(end1.getName());
				e1.setDescription(end1.getDescription());
			}

			if (end2 instanceof Essence.ActivitySpaceAndActivity.ActivitySpace) {
				e2 = new ActivitySpace();
				e2.setName(end2.getName());
				e2.setDescription(end2.getDescription());
			} else {
				e2 = new Activity();
				e2.setName(end2.getName());
				e2.setDescription(end2.getDescription());
			}
			relation.setSourceElement(e1);
			relation.setTargetElement(e2);
		}
		return relation;
	}

}