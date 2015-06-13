package org.uengine.essencia.enactment;

import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.BasicElement;
import org.uengine.essencia.model.LanguageElement;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.kernel.ProcessDefinition;
import org.uengine.kernel.ProcessInstance;
import org.uengine.kernel.ProcessVariable;
import org.uengine.kernel.ProcessVariableValue;
import org.uengine.modeling.IElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameBoard {

    List<AlphaGameBoard> alphaGameBoards;
        public List<AlphaGameBoard> getAlphaGameBoards() {
            return alphaGameBoards;
        }
        public void setAlphaGameBoards(List<AlphaGameBoard> alphaGameBoards) {
            this.alphaGameBoards = alphaGameBoards;
        }


    public GameBoard(PracticeDefinition practiceDefinition, ProcessInstance instance) throws Exception {

        ProcessDefinition processDefinition = instance.getProcessDefinition();
        setAlphaGameBoards(new ArrayList<AlphaGameBoard>());
        Map<String, List<? extends LanguageElementInstance>> alphaInstancesMap = new HashMap<String, List<? extends LanguageElementInstance>>();

        for(ProcessVariable pv : processDefinition.getProcessVariables()){

            ProcessVariableValue pvv = pv.getMultiple(instance, "");
            BasicElement alpha1 = null;
            if(pvv!=null && pvv.size() > 0){
                LanguageElementInstance alphaInstance = (LanguageElementInstance) pvv.getValue();

                if(alphaInstance==null) continue;

                alpha1 = alphaInstance.getLanguageElement();


                alphaInstancesMap.put(pv.getName(), alpha1.getInstances(instance));

            }
        }

        for(IElement element : practiceDefinition.getElementList()){

            if(element instanceof Alpha){
               AlphaGameBoard alphaGameBoard = new AlphaGameBoard((Alpha)element, alphaInstancesMap);
                getAlphaGameBoards().add(alphaGameBoard);
            }

        }

    }

}
