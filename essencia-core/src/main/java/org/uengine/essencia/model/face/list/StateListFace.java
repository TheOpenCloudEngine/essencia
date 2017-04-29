package org.uengine.essencia.model.face.list;

import org.metaworks.MetaworksContext;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.Order;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.model.MetaworksElement;
import org.metaworks.model.SortableElement;
import org.uengine.essencia.enactment.EssenceProcessDefinition;
import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.EssenciaElement;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.model.State;
import org.uengine.modeling.Canvas;
import org.uengine.modeling.resource.editor.MethodEditor;

import java.util.ArrayList;

public class StateListFace extends org.metaworks.widget.SortableListFace<State> {


    @ServiceMethod(callByContent = true)
    @Order(100)
    public void amendFromKernel(@AutowiredFromClient Alpha alpha, @AutowiredFromClient MethodEditor methodEditor){

        PracticeDefinition practiceDefinition = methodEditor.createPracticeDefinition();
        practiceDefinition.arrangeRelations();
        alpha = (Alpha) practiceDefinition.getElementByName(alpha.getName());

        if(alpha==null)
            throw new RuntimeException("Please connect to any kernel before amending from the kernel. Or name your element and try it after opening the properties dialog again.");

        if(!(alpha instanceof Alpha) || alpha.getIncomingRelations()==null || alpha.getIncomingRelations().size() == 0){
            throw new RuntimeException("There is no parent alpha to amend state.");
        }


        if(!(alpha.getIncomingRelations().get(0).getSourceElement() instanceof Alpha)){
            throw new RuntimeException("There is no parent alpha to amend state.");
        }



        Alpha kernel = (Alpha) alpha.getIncomingRelations().get(0).getSourceElement();
        if(kernel!=null){

            setElements(new ArrayList<SortableElement>());


            for(State state : kernel.getStates()){
                SortableElement essenciaElement = new SortableElement();
                essenciaElement.setValue(state);
                essenciaElement.setMetaworksContext(new MetaworksContext());
                essenciaElement.getMetaworksContext().setWhen(MetaworksContext.WHEN_EDIT);
                state.setUpElement();
                state.setAggregationAlphaState(state.getName());
                getElements().add(essenciaElement);
            }
//            getEssenciaElementList();
        }

    }

}
