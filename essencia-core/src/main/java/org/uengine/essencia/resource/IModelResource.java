package org.uengine.essencia.resource;

import org.uengine.essencia.modeling.editor.Editor;
import org.uengine.modeling.IModel;
import org.uengine.modeling.resource.IResource;

public interface IModelResource extends IResource{

	public static final String UNTITLED = "untitled";

	public void saveResource(IModel model) throws Exception;

	public IModel loadModel() throws Exception;

	public Editor createEditor() throws Exception;
}
