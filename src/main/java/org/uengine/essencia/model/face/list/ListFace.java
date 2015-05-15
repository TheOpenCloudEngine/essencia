package org.uengine.essencia.model.face.list;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.metaworks.ContextAware;
import org.metaworks.MetaworksContext;
import org.metaworks.annotation.*;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.model.EssenciaElement;
import org.uengine.essencia.model.FaceTransformer;
import org.uengine.essencia.model.LanguageElement;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.essencia.util.ElementUtil;

import static org.metaworks.MetaworksContext.*;

@Face(ejsPath = "dwr/metaworks/org/uengine/essencia/model/ChildProperty.ejs")
public abstract class ListFace<T> implements ContextAware {

	private String id;
	private MetaworksContext metaworksContext;
	private List<EssenciaElement> essenciaElementList;

	public List<EssenciaElement> getEssenciaElementList() {
		return essenciaElementList;
	}

	public void setEssenciaElementList(List<EssenciaElement> essenciaElementList) {
		this.essenciaElementList = essenciaElementList;
	}

	@Hidden
	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public MetaworksContext getMetaworksContext() {
		return metaworksContext;
	}

	@Override
	public void setMetaworksContext(MetaworksContext metaworksContext) {
		this.metaworksContext = metaworksContext;
	}

	public ListFace() {
		// TODO:change id to unique and meaningful
		setId(getClass().getSimpleName() + "_" + System.currentTimeMillis() + "_" + new Random().nextInt());
		setEssenciaElementList(new ArrayList<EssenciaElement>());
		ContextUtil.setWhen(this, EssenciaContext.WHEN_EDIT);
	}

	@Hidden(when= EssenciaContext.WHEN_VIEW)
	@Face(displayName = "add")
	@ServiceMethod(callByContent = true)
	public void add() {
		T t = null;

		try {
			t = (T) ((Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

		EssenciaElement element = new EssenciaElement();
		element.setValue(t);

		ContextUtil.setWhen(element, EssenciaContext.WHEN_EDIT);
		ContextUtil.setWhen((LanguageElement) t, EssenciaContext.WHEN_EDIT);

		getEssenciaElementList().add(element);
	}

	@Hidden(when= EssenciaContext.WHEN_VIEW)
	@Face(displayName = "remove")
	@ServiceMethod(callByContent = true)
	public void remove() {
		for (int i = 0; i < getEssenciaElementList().size(); i++) {
			if (!getEssenciaElementList().get(i).getCheckBox().getSelected().equals("")) {
				getEssenciaElementList().set(i, null);
			}
		}
		setEssenciaElementList(ElementUtil.syncList(getEssenciaElementList()));
	}

	public List<T> createValue() {
		List<T> returnList = new ArrayList<T>();
		for (EssenciaElement e : getEssenciaElementList()) {
			T t = (T) e.getValue();
			if (t instanceof FaceTransformer) {
				((FaceTransformer) t).beforeApply();
			}
			returnList.add(t);
		}
		getEssenciaElementList().clear();
		return returnList;
	}

	public void fillElements(List<T> list) {
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				EssenciaElement e = new EssenciaElement();
				if (list.get(i) instanceof FaceTransformer) {
					((FaceTransformer) list.get(i)).setUpElement();
				}
				e.setValue((T) list.get(i));
				getEssenciaElementList().add(e);
			}
		}
	}
}
