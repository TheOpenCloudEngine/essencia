package org.uengine.modeling.resource.resources;

import org.metaworks.Refresh;
import org.metaworks.Remover;
import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.Available;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.dwr.MetaworksRemoteService;
import org.metaworks.widget.Clipboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.uengine.codi.CodiProcessDefinitionFactory;
import org.uengine.codi.mw3.model.Session;
import org.uengine.essencia.enactment.LanguageElementInstance;
import org.uengine.essencia.modeling.canvas.EssenciaCanvas;
import org.uengine.essencia.modeling.editor.Editor;
import org.uengine.essencia.modeling.editor.MethodComposerEditor;
import org.uengine.essencia.resource.FolderResourceType;
import org.uengine.essencia.resource.ModelResource;
import org.uengine.essencia.resource.RepositoryFolderResource;
import org.uengine.essencia.resource.ResourceType;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.kernel.ProcessDefinition;
import org.uengine.kernel.ProcessDefinitionFactory;
import org.uengine.kernel.ProcessVariable;
import org.uengine.modeling.resource.DefaultResource;
import org.uengine.modeling.resource.IResource;
import org.uengine.modeling.resource.ResourceManager;
import org.uengine.uml.model.ClassDefinition;

public class MethodResource extends DefaultResource {


	@AutowiredFromClient
	public Session session;



	@Autowired
	public ProcessDefinitionFactory definitionFactory;

	@Override
	public void save(Object editingObject) throws Exception {

		ProcessDefinition processDefinition = (ProcessDefinition) editingObject;

		{//Extract Class Definitions and deploy them, and replace the class definition itself with a link

			for (ProcessVariable processVariable : processDefinition.getProcessVariables()) {
				if (processVariable.getDefaultValue() instanceof LanguageElementInstance) {
					LanguageElementInstance languageElementInstance = (LanguageElementInstance) processVariable.getDefaultValue();
					ClassDefinition classDefinition = languageElementInstance.getClassDefinition();

					String classLinkName = getPath() + "#" + classDefinition.getName();

					languageElementInstance.setClassName(classLinkName);

				}
			}

		}

		super.save(editingObject);

		definitionFactory.removeFromCache(getPath().substring(CodiProcessDefinitionFactory.codiProcessDefinitionFolder.length() + 1));
	}


	@Hidden
	@Available(condition = "metaworksContext.how == 'tree' && metaworksContext.where == 'navigator'")
	@ServiceMethod(mouseBinding = "drag", bindingHidden = true, target = ServiceMethodContext.TARGET_APPEND)
	public Object drag() {
		return new Refresh(new Clipboard(EssenciaCanvas.CANVAS_DROP, this),
				true);
	}

}
