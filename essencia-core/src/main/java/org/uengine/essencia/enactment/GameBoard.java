package org.uengine.essencia.enactment;

import org.uengine.essencia.model.*;
import org.uengine.kernel.ProcessDefinition;
import org.uengine.kernel.ProcessInstance;
import org.uengine.kernel.ProcessVariable;
import org.uengine.kernel.ProcessVariableValue;
import org.uengine.modeling.IElement;
import org.uengine.modeling.Relation;

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
        practiceDefinition.arrangeRelations();

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

                if(alphaInstance instanceof AlphaInstance) {
                    ((AlphaInstance) alphaInstance).aggregateStateDetails(instance);
                    ((AlphaInstance) alphaInstance).calculateState();
                }

                alphaInstancesMap.put(pv.getName(), alpha1.getInstances(instance));

            }
        }


        for(IElement element : practiceDefinition.getElementList()){

            if(element instanceof Alpha){
                Alpha alpha = (Alpha)element;
                List<AlphaInstance> alphaInstances = alpha.getInstances(instance);

                if(alphaInstances==null){
                    alphaInstances = new ArrayList<AlphaInstance>();
                    alphaInstances.add(alpha.createObjectInstance());
                }

                for(AlphaInstance alphaInstance : alphaInstances){
                    alphaInstance.aggregateStateDetails(instance);
                }


                alphaInstancesMap.put(alpha.getName(), alphaInstances);

            }

            if(element instanceof Practice){

                Practice practice = (Practice) element;

                for(Relation relation : practice.getOutgoingRelations()){
                    if(relation.getTargetElement() instanceof Alpha){
                        AlphaGameBoard alphaGameBoard = new AlphaGameBoard((Alpha)relation.getTargetElement(), alphaInstancesMap);
                        getAlphaGameBoards().add(alphaGameBoard);
                    }
                }

            }

        }

    }

}
