package org.uengine.essencia.enactment;

import org.uengine.essencia.enactment.LanguageElementInstance;
import org.uengine.essencia.model.BasicElement;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.kernel.ProcessDefinition;
import org.uengine.kernel.ProcessVariable;

public class EssenceProcessDefinition extends ProcessDefinition{

    PracticeDefinition practiceDefinition;
        public PracticeDefinition getPracticeDefinition() {
            return practiceDefinition;
        }
        public void setPracticeDefinition(PracticeDefinition practiceDefinition) {
            this.practiceDefinition = practiceDefinition;
        }


    @Override
    public void beforeSerialization() {

        for(ProcessVariable processVariable : getProcessVariables()){
            if(processVariable.getDefaultValue() instanceof LanguageElementInstance){
                LanguageElementInstance languageElementInstance = (LanguageElementInstance)processVariable.getDefaultValue();

                languageElementInstance.setLanguageElement((BasicElement) getPracticeDefinition().getElementByName(languageElementInstance.getLanguageElement().getName()));
            }
        }

        super.beforeSerialization();
    }
}
