package org.uengine.essencia.modeling.modeler;

import org.uengine.essencia.enactment.EssenceProcessDefinition;
import org.uengine.kernel.ProcessDefinition;
import org.uengine.modeling.Modeler;
import org.uengine.modeling.modeler.ProcessModeler;

public class EssenciaProcessModeler extends ProcessModeler {

    @Override
    protected ProcessDefinition createEmptyProcessDefinition() {
        return new EssenceProcessDefinition();
    }
}
