package org.uengine.essencia.model;

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
