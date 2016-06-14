package org.uengine.essencia.portal;

import Essence.Competency.Competency;
import org.metaworks.Refresh;
import org.metaworks.dwr.MetaworksRemoteService;
import org.metaworks.widget.ModalWindow;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.uengine.codi.mw3.model.Popup;
import org.uengine.essencia.enactment.EssenceActivity;
import org.uengine.essencia.model.BasicElement;
import org.uengine.essencia.model.CardViewable;
import org.uengine.essencia.model.LanguageElement;
import org.uengine.essencia.model.State;
import org.uengine.essencia.model.card.ActivityCard;
import org.uengine.essencia.model.card.StateDetail;
import org.uengine.essencia.model.view.CompetencyView;
import org.uengine.essencia.model.view.LanguageElementView;
import org.uengine.essencia.model.view.StateView;
import org.uengine.kernel.view.ActivityView;
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
    @Override
    public void onDoubleClick(ElementView elementView) {
        if(elementView instanceof ActivityView && ((ActivityView) elementView).getElement() instanceof EssenceActivity){
            EssenceActivity essenceActivity = (EssenceActivity) ((ActivityView) elementView).getElement();
            ActivityCard activityCard = (ActivityCard) essenceActivity.getActivityInEssenceDefinition().createCardView();

//            Popup popup = new Popup();
//            popup.setPanel(activityCard);
//            popup.setWidth(1000);
//            popup.setHeight(600);
//
//            MetaworksRemoteService.wrapReturn(popup);

            MetaworksRemoteService.wrapReturn(new ModalWindow(activityCard, 800, 500, "Card View"));

        }else if(elementView instanceof StateView) {
            State state = (State) ((StateView)elementView).getElement();
            StateDetail stateDetail = new StateDetail();
            stateDetail.setState(state);

            MetaworksRemoteService.wrapReturn(new Refresh(stateDetail));
        }else if(elementView instanceof LanguageElementView) {
            LanguageElementView languageElementView = (LanguageElementView) elementView;
            BasicElement languageElement = (BasicElement) languageElementView.getElement();
            if(languageElement instanceof CardViewable){
                languageElement.setElementView(languageElementView);


                Card card = ((CardViewable) languageElement).createCardView();

//                Popup popup = new Popup();
//                popup.setPanel(card);
//                popup.setWidth(1000);
//                popup.setHeight(600);
//                popup.setName("Card View");
//                popup.setSticky(false);
//                MetaworksRemoteService.wrapReturn(popup);


                MetaworksRemoteService.wrapReturn(new ModalWindow(card, 800, 500, "Card View"));

            }
        }else{
            super.onDoubleClick(elementView);
        }
    }
}

