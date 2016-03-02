package org.uengine.essencia.portal;

import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.dwr.MetaworksRemoteService;
import org.metaworks.widget.ModalWindow;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.uengine.codi.mw3.model.Popup;
import org.uengine.essencia.modeling.canvas.MethodCanvas;
import org.uengine.kernel.face.ProcessVariableTypeSelector;
import org.uengine.modeling.Canvas;
import org.uengine.modeling.resource.editor.MethodEditor;
import org.uengine.modeling.resource.editor.MethodEditor_ProcessMode;
import org.uengine.social.SocialBPMProcessVariableTypeSelector;
import org.uengine.social.SocialBPMProcessVariableTypeSelectorPopup;

/**
 * Created by jjy on 2016. 3. 1..
 */
@Order(5)
@Component
@Scope("prototype")
public class EssenciaProcessVariableTypeSelector extends SocialBPMProcessVariableTypeSelector{ // ---(1)

//    public EssenciaProcessVariableTypeSelector(){
//    }


    /** if you want to introduce the functionality of adding processvariable from the essence elements by user, remove the comments (1)
     * since process variable definitions are automatically added by converting to process model from the essence model, user never need this functionality.
     *
      */

    // ----- (1)
//    @ServiceMethod(callByContent = true, target=ServiceMethod.TARGET_STICK)
//    public void select(@AutowiredFromClient MethodEditor_ProcessMode methodEditor) throws Exception{
//        MetaworksRemoteService.wrapReturn(new Popup(new EssenciaProcessVariableTypeSelectorPopup(methodEditor)));//, "Select Process Data Type");
//    }
}
