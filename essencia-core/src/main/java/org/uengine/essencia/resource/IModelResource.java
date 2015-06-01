package org.uengine.essencia.resource;

import org.uengine.essencia.modeling.editor.Editor;
import org.uengine.modeling.IModel;

public interface IModelResource {

	public static final String UNTITLED = "untitled";

	public void saveResource(IModel model) throws Exception;

	public IModel loadModel() throws Exception;

	public Editor createEditor() throws Exception;
}
