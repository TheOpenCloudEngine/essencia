package org.uengine.essencia.model.face.list;

import org.metaworks.MetaworksContext;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.ServiceMethod;
import org.uengine.essencia.enactment.EssenceProcessDefinition;
import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.EssenciaElement;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.model.State;
import org.uengine.modeling.Canvas;
import org.uengine.modeling.resource.editor.MethodEditor;

import java.util.ArrayList;

public class StateListFace extends ListFace<State> {


    @ServiceMethod(callByContent = true)
    public void amendFromKernel(@AutowiredFromClient Alpha alpha, @AutowiredFromClient MethodEditor methodEditor){

        PracticeDefinition practiceDefinition = methodEditor.createPracticeDefinition();
        practiceDefinition.arrangeRelations();
        alpha = (Alpha) practiceDefinition.getElementByName(alpha.getName());

        if(alpha.getIncomingRelations()==null || alpha.getIncomingRelations().size() == 0){
            throw new RuntimeException("There is no parent alpha to amend state.");
        }

        Alpha kernel = (Alpha) alpha.getIncomingRelations().get(0).getSourceElement();
        if(kernel!=null){

            setEssenciaElementList(new ArrayList<EssenciaElement>());


            for(State state : kernel.getStates()){
                EssenciaElement essenciaElement = new EssenciaElement();
                essenciaElement.setValue(state);
                essenciaElement.setMetaworksContext(new MetaworksContext());
                essenciaElement.getMetaworksContext().setWhen(MetaworksContext.WHEN_EDIT);
                state.setUpElement();
                state.setAggregationAlphaState(state.getName());
                getEssenciaElementList().add(essenciaElement);
            }
//            getEssenciaElementList();
        }

    }

}
