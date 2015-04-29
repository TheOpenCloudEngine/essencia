package org.uengine.essencia.modeling.canvas;

import org.metaworks.ContextAware;
import org.metaworks.MetaworksContext;
import org.metaworks.Refresh;
import org.metaworks.ServiceMethodContext;
import org.metaworks.ToAppend;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.Available;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.Clipboard;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.modeling.Canvas;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.IElement;
import org.uengine.modeling.IRelation;
import org.uengine.modeling.RelationView;
import org.uengine.modeling.Symbol;

public class ProcessCanvas extends Canvas {

	public final static String CANVAS_DROP = "drop";

	@AutowiredFromClient
	public Clipboard clipboard;
	private MetaworksContext metaworksContext;
	private String modelerType;

	public ProcessCanvas() {
	}

	public ProcessCanvas(String modelerType) {
		this();
		this.setModelerType(modelerType);
	}

	public MetaworksContext getMetaworksContext() {
		return metaworksContext;
	}

	public void setMetaworksContext(MetaworksContext metaworksContext) {
		this.metaworksContext = metaworksContext;
	}

	public String getModelerType() {
		return modelerType;
	}

	public void setModelerType(String modelerType) {
		this.modelerType = modelerType;

	}

	@Available(when = { MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT })
	@ServiceMethod(payload = { "clipboard", "modelerType" }, target = ServiceMethodContext.TARGET_APPEND, mouseBinding = CANVAS_DROP)
	public Object[] drop() {

		ElementView elementView = null;

		Object content = clipboard.getContent();
		if (content instanceof Symbol) {
			Symbol symbol = (Symbol) content;

			if ("EDGE".equals(symbol.getShapeType())) {
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

				return new Object[] { new Refresh(new Clipboard(CANVAS_DROP)), new ToAppend(ServiceMethodContext.TARGET_SELF, relationView) };
			} else {

				try {
					IElement element = (IElement) Thread.currentThread().getContextClassLoader().loadClass(symbol.getElementClassName()).newInstance();
					if (element instanceof ContextAware){
						ContextUtil.setWhen((ContextAware)element, EssenciaContext.WHEN_NEW);
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
				return new Object[] { new Refresh(new Clipboard(CANVAS_DROP)), new ToAppend(ServiceMethodContext.TARGET_SELF, elementView) };
			}
		}
		return new Object[] { new Refresh(new Clipboard(CANVAS_DROP)) };
	}
}
