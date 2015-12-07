package org.uengine.essencia.model.card;

import org.uengine.essencia.model.State;
import org.uengine.essencia.model.card.Detail;

/**
 * Created by jjy on 2015. 12. 4..
 */
public class StateDetail extends Detail {

    State state;
        public State getState() {
            return state;
        }
        public void setState(State state) {
            this.state = state;
        }



}
