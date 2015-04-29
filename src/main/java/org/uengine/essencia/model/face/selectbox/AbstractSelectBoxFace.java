package org.uengine.essencia.model.face.selectbox;

import org.metaworks.ContextAware;
import org.metaworks.MetaworksContext;
import org.metaworks.annotation.Face;
import org.metaworks.component.CheckBox;
import org.uengine.essencia.component.EssenciaSelectBox;

@Face(ejsPath = "dwr/metaworks/org/uengine/essencia/model/ChildProperty.ejs")
public abstract class AbstractSelectBoxFace implements ContextAware {

    private transient MetaworksContext metaworksContext;
    private transient EssenciaSelectBox mainSelectBox;
    private transient CheckBox checkBox;

    public CheckBox getCheckBox() {
	return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
	this.checkBox = checkBox;
    }

    @Override
    public MetaworksContext getMetaworksContext() {
	return metaworksContext;
    }

    @Override
    public void setMetaworksContext(MetaworksContext context) {
	this.metaworksContext = context;
    }

    public EssenciaSelectBox getMainSelectBox() {
	return mainSelectBox;
    }

    public void setMainSelectBox(EssenciaSelectBox mainSelectBox) {
	this.mainSelectBox = mainSelectBox;
    }

    public AbstractSelectBoxFace() {
	setMainSelectBox(new EssenciaSelectBox());
	setCheckBox(new CheckBox());
	getCheckBox().add("checkBox", "checkBox");
    }
}
