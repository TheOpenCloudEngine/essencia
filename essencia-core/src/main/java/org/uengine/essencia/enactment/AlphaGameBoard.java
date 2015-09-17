package org.uengine.essencia.enactment;

import org.metaworks.Instance;
import org.uengine.essencia.model.Alpha;
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

public class AlphaGameBoard {

    public AlphaGameBoard(Alpha alpha, Map<String, List<? extends LanguageElementInstance>> alphaInstancesMap) {
        setAlpha(alpha);
        setAlphaInstances(alphaInstancesMap);
    }

    Map<String, List<? extends LanguageElementInstance>> alphaInstances;
        public Map<String, List<? extends LanguageElementInstance>> getAlphaInstances() {
                return alphaInstances;
            }
        public void setAlphaInstances(Map<String, List<? extends LanguageElementInstance>> alphaInstances) {
            this.alphaInstances = alphaInstances;
        }

    Alpha alpha;
        public Alpha getAlpha() {
            return alpha;
        }
        public void setAlpha(Alpha alpha) {
            this.alpha = alpha;
        }


    public AlphaGameBoard() throws Exception {
        /*ExampleAlphaInstance exampleAlphaInstance = new ExampleAlphaInstance();

        ProcessInstance instance = exampleAlphaInstance.getProcessInstance();
        ProcessDefinition processDefinition = exampleAlphaInstance.getProcessInstance().getProcessDefinition();

        setAlphaInstances(new HashMap<String, List<? extends LanguageElementInstance>>());


        for(ProcessVariable pv : processDefinition.getProcessVariables()){

            ProcessVariableValue pvv = pv.getMultiple(instance, "");
            Alpha alpha1 = null;
            if(pvv!=null && pvv.size() > 0){
                AlphaInstance alphaInstance = (AlphaInstance) pvv.getValue();
                alpha1 = alphaInstance.getAlpha();

                getAlphaInstances().put(pv.getName(), alpha1.getInstances(instance));

            }
        }

        setAlpha(exampleAlphaInstance.getAlphaInstance().getAlpha());*/

    }


}
