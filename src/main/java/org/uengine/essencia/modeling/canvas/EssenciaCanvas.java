package org.uengine.essencia.modeling.canvas;

import java.util.List;

import org.metaworks.ContextAware;
import org.metaworks.MetaworksContext;
import org.metaworks.Refresh;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.widget.Clipboard;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.model.Practice;
import org.uengine.essencia.model.view.PracticeView;
import org.uengine.essencia.modeling.EssenciaKernelSymbol;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.essencia.util.ElementUtil;
import org.uengine.modeling.Canvas;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.IElement;
import org.uengine.modeling.IRelation;
import org.uengine.modeling.RelationView;
import org.uengine.modeling.Symbol;
import org.uengine.modeling.SymbolFactory;

public abstract class EssenciaCanvas extends Canvas implements ContextAware {

	public final static String CANVAS_DROP = "drop";

	@AutowiredFromClient
	public Clipboard clipboard;
	protected MetaworksContext metaworksContext;
	protected String modelerType;

	public EssenciaCanvas() {
	}

	public EssenciaCanvas(String modelerType) {
		this.setModelerType(modelerType);
	}

	@Override
	public MetaworksContext getMetaworksContext() {
		return metaworksContext;
	}

	@Override
	public void setMetaworksContext(MetaworksContext metaworksContext) {
		this.metaworksContext = metaworksContext;
	}

	public String getModelerType() {
		return modelerType;
	}

	public void setModelerType(String modelerType) {
		this.modelerType = modelerType;
	}

	protected void initPracticeView() {
		Practice practice = new Practice();
		practice.setName("untitled");
		ElementView view = practice.createView();
		Symbol symbol = SymbolFactory.create(PracticeView.class);
		view.fill(symbol);
		view.setX("96");
		view.setY("96");
		view.setElement(practice);
		view.setLabel("untitled");

		getElementViewList().add(view);
	}

	protected boolean validate(ElementView elementView) {
		for (ElementView view : getElementViewList()) {
			if (elementView.getClass() == view.getClass() && elementView.getLabel().equals(view.getLabel())) {
				return false;
			}
		}
		return true;
	}

	protected Object[] initReturnArr() {
		Object[] returnArr = new Object[2];

		returnArr[0] = new Refresh(new Clipboard(CANVAS_DROP));

		return returnArr;
	}

	protected ElementView makeElementViewFromEssenciaKernelSymbol(EssenciaKernelSymbol symbol) {
		return symbol.getLanguageElementView();
	}

	protected RelationView makeRelationViewFromSymbol(Symbol symbol) {
		RelationView relationView = null;

		try {
			IRelation relation = (IRelation) Thread.currentThread().getContextClassLoader().loadClass(symbol.getElementClassName()).newInstance();
			relationView = relation.createView();
			relationView.fill(symbol);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return relationView;
	}

	protected ElementView makeElementViewFromSymbol(Symbol symbol) {
		ElementView elementView = null;

		try {
			IElement element = (IElement) Thread.currentThread().getContextClassLoader().loadClass(symbol.getElementClassName()).newInstance();

			if (element instanceof ContextAware) {
				ContextUtil.setWhen((ContextAware) element, EssenciaContext.WHEN_NEW);
			}

			elementView = element.createView();
			elementView.fill(symbol);
			ContextUtil.setWhen(elementView, EssenciaContext.WHEN_EDIT);

		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return elementView;
	}

	public abstract Object[] drop();

	public List<IElement> takeElementList(){
		return ElementUtil.convertToIElementList(getElementViewList());
	}

}
