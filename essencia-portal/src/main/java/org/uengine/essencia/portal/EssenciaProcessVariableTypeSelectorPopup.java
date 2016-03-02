package org.uengine.essencia.portal;

import org.metaworks.ContextAware;
import org.metaworks.MetaworksContext;
import org.metaworks.Remover;
import org.metaworks.ToOpener;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.component.SelectBox;
import org.metaworks.dwr.MetaworksRemoteService;
import org.metaworks.widget.ModalWindow;
import org.uengine.essencia.enactment.EssenceProcessDefinition;
import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.modeling.canvas.MethodCanvas;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.resource.Serializer;
import org.uengine.modeling.resource.editor.MethodEditor;
import org.uengine.modeling.resource.editor.MethodEditor_ProcessMode;
import org.uengine.social.SocialBPMProcessVariableTypeSelector;
import org.uengine.social.SocialBPMProcessVariableTypeSelectorPopup;

/**
 * Created by jjy on 2016. 3. 1..
 */
public class EssenciaProcessVariableTypeSelectorPopup implements ContextAware{

    MetaworksContext metaworksContext;
        @Override
        public MetaworksContext getMetaworksContext() {
            return metaworksContext;
        }
        @Override
        public void setMetaworksContext(MetaworksContext metaworksContext) {
            this.metaworksContext = metaworksContext;
        }


    SelectBox alpha;
        public SelectBox getAlpha() {
            return alpha;
        }
        public void setAlpha(SelectBox alpha) {
            this.alpha = alpha;
        }


    public EssenciaProcessVariableTypeSelectorPopup(){}

    public EssenciaProcessVariableTypeSelectorPopup(MethodEditor_ProcessMode methodEditor) throws Exception {

        setMetaworksContext(new MetaworksContext());
        getMetaworksContext().setWhen(MetaworksContext.WHEN_EDIT);

        setAlpha(new SelectBox());

        String practiceObjectStr = methodEditor.getObjStr();
        PracticeDefinition practiceDefinition = (PracticeDefinition) Serializer.deserialize(practiceObjectStr);

        for(Alpha element : practiceDefinition.getElements(Alpha.class)){
            getAlpha().getOptionValues().add(element.getName());
        }

        getAlpha().setOptionNames(getAlpha().getOptionValues());
    }

    @ServiceMethod(callByContent = true, target=ServiceMethod.TARGET_APPEND)
    public void select(){
        String alphaName = getAlpha().getSelected();

        SocialBPMProcessVariableTypeSelector socialBPMProcessVariableTypeSelector = new SocialBPMProcessVariableTypeSelector();
        socialBPMProcessVariableTypeSelector.setSelectedClassName("#" + alphaName);

        MetaworksRemoteService.wrapReturn(new ToOpener(socialBPMProcessVariableTypeSelector), new Remover(new ModalWindow()));

    }
}
