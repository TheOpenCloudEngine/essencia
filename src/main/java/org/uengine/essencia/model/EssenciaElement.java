package org.uengine.essencia.model;

import org.metaworks.ContextAware;
import org.metaworks.MetaworksContext;
import org.metaworks.component.CheckBox;

public class EssenciaElement implements ContextAware {

    private CheckBox checkBox;
    private Object value;
    private MetaworksContext metaworksContext;

    public Object getValue() {
	return value;
    }

    public void setValue(Object value) {
	this.value = value;
    }

    @Override
    public MetaworksContext getMetaworksContext() {
	return metaworksContext;
    }

    @Override
    public void setMetaworksContext(MetaworksContext metaworksContext) {
	this.metaworksContext = metaworksContext;
    }

    public CheckBox getCheckBox() {
	return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
	this.checkBox = checkBox;
    }

    public EssenciaElement() {
	setCheckBox(new CheckBox());
	getCheckBox().add("checkBox", "checkBox");
    }

}
