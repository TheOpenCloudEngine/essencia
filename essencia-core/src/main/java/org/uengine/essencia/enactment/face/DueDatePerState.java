package org.uengine.essencia.enactment.face;

import org.uengine.essencia.enactment.AlphaInstance;
import org.uengine.essencia.model.State;

import java.util.Calendar;

/**
 * Created by jjy on 2016. 1. 10..
 */
public class DueDatePerState {

    public DueDatePerState(State state, AlphaInstance alphaInstance) {
        setStateName(state.getName());
        setDueDate((java.util.Date) alphaInstance.getStateDetails(getStateName(), AlphaInstance.STATE_PROP_KEY_DueDate));
    }

    public DueDatePerState() {}

    String stateName;
        public String getStateName() {
            return stateName;
        }
        public void setStateName(String stateName) {
            this.stateName = stateName;
        }


    java.util.Date dueDate;
        public java.util.Date getDueDate() {
            return dueDate;
        }
        public void setDueDate(java.util.Date dueDate) {
            this.dueDate = dueDate;
        }

    protected void applyToAlphaInstance(AlphaInstance instance){
        instance.setStateDetails(getStateName(), AlphaInstance.STATE_PROP_KEY_DueDate, getDueDate());
    }

}
