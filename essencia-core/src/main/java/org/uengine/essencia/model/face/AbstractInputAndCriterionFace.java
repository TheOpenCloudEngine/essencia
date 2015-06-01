package org.uengine.essencia.model.face;

import java.util.List;

import org.metaworks.ContextAware;
import org.metaworks.MetaworksContext;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.ServiceMethod;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.model.LanguageElement;
import org.uengine.essencia.model.face.selectbox.AbstractSelectBoxFace;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.essencia.util.ElementUtil;
import org.uengine.modeling.IElement;

@Face(ejsPath = "dwr/metaworks/org/uengine/essencia/model/ChildProperty.ejs")
public abstract class AbstractInputAndCriterionFace implements ContextAware {

    private transient List<IElement> elementListFromCanvas;
    private transient MetaworksContext metaworksContext;

    private transient List<AbstractSelectBoxFace> abstractSelectBoxFaceList;

    @Override
    public MetaworksContext getMetaworksContext() {
	return metaworksContext;
    }

    @Override
    public void setMetaworksContext(MetaworksContext context) {
	this.metaworksContext = context;
    }

    public List<AbstractSelectBoxFace> getAbstractSelectBoxFaceList() {
	return abstractSelectBoxFaceList;
    }

    public void setAbstractSelectBoxFaceList(List<AbstractSelectBoxFace> abstractSelectBoxFaceList) {
	this.abstractSelectBoxFaceList = abstractSelectBoxFaceList;
    }

    @Hidden
    public List<IElement> getElementListFromCanvas() {
	return elementListFromCanvas;
    }

    public void setElementListFromCanvas(List<IElement> elementListFromCanvas) {
	this.elementListFromCanvas = elementListFromCanvas;
    }

    public AbstractInputAndCriterionFace() {
	ContextUtil.setWhen(this, EssenciaContext.WHEN_EDIT);
    }

    @Hidden(when = MetaworksContext.WHEN_VIEW)
    @Face(displayName = "add")
    @ServiceMethod(callByContent = true)
    public abstract void add();

    @Hidden(when = MetaworksContext.WHEN_VIEW)
    @Face(displayName = "remove")
    @ServiceMethod(callByContent = true)
    public void remove() {
	for (int i = 0; i < getAbstractSelectBoxFaceList().size(); i++) {
	    if (!getAbstractSelectBoxFaceList().get(i).getCheckBox().getSelected().equals("")) {
		getAbstractSelectBoxFaceList().set(i, null);
	    }
	}
	setAbstractSelectBoxFaceList(ElementUtil.syncList(getAbstractSelectBoxFaceList()));
    }

    public void fill(List<IElement> list) {
	setElementListFromCanvas(list);
    }
    
    public abstract List<LanguageElement> createValue();

    public abstract void fillElements(List<LanguageElement> list);

}
