package org.uengine.essencia.modeling.editor;

import org.metaworks.annotation.Face;


@Face(ejsPath="dwr/metaworks/genericfaces/HiddenFace.ejs")
public class EmptyEditor extends Editor {

	@Override
	public void load() throws Exception {
	}

	@Override
	public void save() throws Exception {
	}

	@Override
	public boolean validate() throws Exception {
		return false;
	}
}
