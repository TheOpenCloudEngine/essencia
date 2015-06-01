package org.uengine.essencia.resource.element;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import org.metaworks.ContextAware;
import org.metaworks.MetaworksContext;
import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.Available;
import org.metaworks.annotation.Children;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Field;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.Name;
import org.metaworks.annotation.ServiceMethod;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.resource.IModelResource;
import org.uengine.essencia.resource.Resource;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.modeling.IElement;

@Face(ejsPath = "dwr/metaworks/genericfaces/FormFace.ejs", ejsPathMappingByContext = { "{how: 'tree', face: 'dwr/metaworks/genericfaces/TreeFace.ejs'}" })
public abstract class EssenciaResource implements ContextAware {

	public final static String HOW_TREE = "tree";
	public final static String WHERE_NAVIGATOR = "navigator";

	private String path;
	private String displayName;
	private List<EssenciaResource> children;
	private boolean isContainer;
	private MetaworksContext metaworksContext;

	public EssenciaResource() {
		setTreeContext();
		setContainer(true);
	}

	@Id
	@Hidden
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Name
	@Face(displayName = "name")
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Children
	@Available(when = MetaworksContext.WHEN_VIEW)
	public List<EssenciaResource> getChildren() {
		if (children == null) {
			children = new ArrayList<EssenciaResource>();
		}
		return children;
	}

	public void setChildren(List<EssenciaResource> children) {
		this.children = children;
	}

	@Field(descriptor = "container")
	public boolean isContainer() {
		return isContainer;
	}

	public void setContainer(boolean container) {
		isContainer = container;
	}

	@Override
	public MetaworksContext getMetaworksContext() {
		return metaworksContext;
	}

	@Override
	public void setMetaworksContext(MetaworksContext metaworksContext) {
		this.metaworksContext = metaworksContext;
	}

	@ServiceMethod(callByContent = true, childrenLoader = true, target = ServiceMethodContext.TARGET_SELF)
	public void open() {
		this.setChildren(this.list());
	}

	protected void addResourceAsChild(EssenciaElementResource resource, IElement element, String path) {
		EssenciaElementResource completedResource = fillInfo(resource, element, path);
		getChildren().add(completedResource);
	}

	protected EssenciaElementResource fillInfo(EssenciaElementResource resource, IElement element, String path) {
		resource.setPath(path);

		if (element.getElementView().getToEdge() == null) {
			resource.setContainer(false);
		}
		return resource;
	}

	protected PracticeDefinition getPractice(String path) {
		IModelResource modelResource = (IModelResource)Resource.newInstance(path);
		PracticeDefinition practice = null;
		try {
			practice = (PracticeDefinition) modelResource.loadModel();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return practice;
	}

	public List<EssenciaResource> list() {
		PracticeDefinition practice = getPractice(getPath());

		List<IElement> firstDepthElements = findCandidateResources(practice);

		for (IElement element : firstDepthElements) {
			makeChildResource(element, getPath());
		}

		return getChildren();
	}

	public void setTreeContext() {
		ContextUtil.setWhen(this, EssenciaContext.WHEN_VIEW);
		ContextUtil.setHow(this, HOW_TREE);
		ContextUtil.setWhere(this, WHERE_NAVIGATOR);
	}

	protected abstract void makeChildResource(IElement element, String path);

	protected abstract List<IElement> findCandidateResources(PracticeDefinition practice);
}
