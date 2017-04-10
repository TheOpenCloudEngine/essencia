package org.uengine.essencia.portal;

import Essence.Competency.Competency;
import org.metaworks.Refresh;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.dwr.MetaworksRemoteService;
import org.metaworks.widget.ModalWindow;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.uengine.codi.mw3.model.Popup;
import org.uengine.essencia.enactment.EssenceActivity;
import org.uengine.essencia.enactment.EssenceProcessDefinition;
import org.uengine.essencia.model.BasicElement;
import org.uengine.essencia.model.CardViewable;
import org.uengine.essencia.model.LanguageElement;
import org.uengine.essencia.model.State;
import org.uengine.essencia.model.card.ActivityCard;
import org.uengine.essencia.model.card.StateDetail;
import org.uengine.essencia.model.view.CompetencyView;
import org.uengine.essencia.model.view.LanguageElementView;
import org.uengine.essencia.model.view.StateView;
import org.uengine.kernel.ProcessDefinitionFactory;
import org.uengine.kernel.bpmn.SubProcess;
import org.uengine.kernel.bpmn.view.SubProcessView;
import org.uengine.kernel.view.ActivityView;
import org.uengine.modeling.Canvas;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.ElementViewActionDelegate;
import org.uengine.social.ElementViewActionDelegateForInstanceMonitoring;
import org.uengine.essencia.model.card.Card;


/**
 * Created by jjy on 2015. 11. 25..
 */
@Component
//@Scope("prototype")
public class ElementViewActionDelegateForCardView extends ElementViewActionDelegateForInstanceMonitoring {

    @AutowiredFromClient(payload = "id")
    public Canvas canvas;

    @Override
    public void onDoubleClick(ElementView elementView) {

        //load full definition for element
        if(elementView instanceof LanguageElementView){
            try {
                EssenceProcessDefinition processDefinition = (EssenceProcessDefinition) ProcessDefinitionFactory.getInstance(null).getDefinition(canvas.getId());
                elementView.setElement(processDefinition.getPracticeDefinition().getElementByName(elementView.getElement().getName()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        if(elementView instanceof ActivityView && ((ActivityView) elementView).getElement() instanceof EssenceActivity){
            EssenceActivity essenceActivity = (EssenceActivity) ((ActivityView) elementView).getElement();
            ActivityCard activityCard = (ActivityCard) essenceActivity.getActivityInEssenceDefinition().createCardView();

            MetaworksRemoteService.wrapReturn(new ModalWindow(activityCard, 800, 500, "Card View"));

        }else if(elementView instanceof StateView) {
            State state = (State) ((StateView)elementView).getElement();
            StateDetail stateDetail = new StateDetail();
            stateDetail.setState(state);

            MetaworksRemoteService.wrapReturn(new Refresh(stateDetail));
        }else if(elementView instanceof LanguageElementView) {
            BasicElement languageElement = (BasicElement) elementView.getElement();
            if(languageElement instanceof CardViewable){
//                languageElement.setElementView(languageElementView); //this effects to the memory cache


                Card card = ((CardViewable) languageElement).createCardView();

                MetaworksRemoteService.wrapReturn(new ModalWindow(card, 800, 500, "Card View"));

            }
        }else if(elementView instanceof SubProcessView){
            //nothing.
        }else{
            super.onDoubleClick(elementView);
        }
    }
}

