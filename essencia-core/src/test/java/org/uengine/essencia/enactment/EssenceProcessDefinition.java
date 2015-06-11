package org.uengine.essencia.enactment;

import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.kernel.ProcessDefinition;

public class EssenceProcessDefinition extends ProcessDefinition{

    PracticeDefinition practiceDefinition;
        public PracticeDefinition getPracticeDefinition() {
            return practiceDefinition;
        }
        public void setPracticeDefinition(PracticeDefinition practiceDefinition) {
            this.practiceDefinition = practiceDefinition;
        }

}
