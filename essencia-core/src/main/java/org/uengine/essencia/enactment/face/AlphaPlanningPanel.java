package org.uengine.essencia.enactment.face;

import org.uengine.essencia.enactment.AlphaInstance;
import org.uengine.essencia.model.State;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jjy on 2016. 1. 10..
 */
public class AlphaPlanningPanel {

    public AlphaPlanningPanel(){}

//    boolean inheritParentPlan;
//        public boolean isInheritParentPlan() {
//            return inheritParentPlan;
//        }
//        public void setInheritParentPlan(boolean inheritParentPlan) {
//            this.inheritParentPlan = inheritParentPlan;
//        }


    public AlphaPlanningPanel(AlphaInstance alphaInstance){
        if(alphaInstance==null) return;

        setDueDatePerStateList(new ArrayList<DueDatePerState>());

        if(alphaInstance.getAlpha()!=null && alphaInstance.getAlpha().getStates()!=null)
        for(State state : alphaInstance.getAlpha().getStates()){
            getDueDatePerStateList().add(new DueDatePerState(state, alphaInstance));
        }
    }

    List<DueDatePerState> dueDatePerStateList;
        public List<DueDatePerState> getDueDatePerStateList() {
            return dueDatePerStateList;
        }
        public void setDueDatePerStateList(List<DueDatePerState> dueDatePerStateList) {
            this.dueDatePerStateList = dueDatePerStateList;
        }

    public void applyToAlphaInstance(AlphaInstance alphaInstance) {
        Date today = new Date();

        if(getDueDatePerStateList()!=null){
            for(DueDatePerState dueDatePerState : getDueDatePerStateList()){
                dueDatePerState.applyToAlphaInstance(alphaInstance);

////// moved to the AlphaInstanceInEditor.save() of AlphaGameBoard.
//
//                if(dueDatePerState.getDueDate()!=null && today.after(dueDatePerState.getDueDate())){
//                    alphaInstance.setTargetStateName(dueDatePerState.getStateName());
//                }

                //calculate the targetState for the moment. //draw the flag there(targetState). //inherit the target state from the parent -- means 'inherit parent alpha's due dates'
            }
        }
    }

}
