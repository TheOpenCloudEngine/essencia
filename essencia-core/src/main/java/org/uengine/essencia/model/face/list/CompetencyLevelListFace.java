package org.uengine.essencia.model.face.list;

import org.metaworks.MetaworksContext;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.Order;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.model.MetaworksElement;
import org.uengine.essencia.model.*;
import org.uengine.modeling.resource.editor.MethodEditor;

import java.util.ArrayList;

public class CompetencyLevelListFace extends org.metaworks.widget.ListFace<CompetencyLevel> {

    @ServiceMethod(callByContent = true)
    @Order(100)
    public void amendFromKernel(@AutowiredFromClient Competency competency, @AutowiredFromClient MethodEditor methodEditor){

        PracticeDefinition practiceDefinition = methodEditor.createPracticeDefinition();
        practiceDefinition.arrangeRelations();
        competency = (Competency) practiceDefinition.getElementByName(competency.getName());

        if(competency==null)
            throw new RuntimeException("Please apply once before amending states from the kernel and try it after opening the properties dialog again.");

        if(!(competency instanceof Competency) || competency.getIncomingRelations()==null || competency.getIncomingRelations().size() == 0){
            throw new RuntimeException("There is no parent competency to amend state.");
        }


        if(!(competency.getIncomingRelations().get(0).getSourceElement() instanceof Competency)){
            throw new RuntimeException("There is no parent competency to amend state.");
        }



        Competency kernel = (Competency) competency.getIncomingRelations().get(0).getSourceElement();
        if(kernel!=null){

            setElements(new ArrayList<MetaworksElement>());


            for(CompetencyLevel competencyLevel : kernel.getCompetencyLevels()){
                MetaworksElement essenciaElement = new MetaworksElement();
                essenciaElement.setValue(competencyLevel);
                essenciaElement.setMetaworksContext(new MetaworksContext());
                essenciaElement.getMetaworksContext().setWhen(MetaworksContext.WHEN_EDIT);
                competencyLevel.setUpElement();
                //state.setAggregationAlphaState(state.getName());
                getElements().add(essenciaElement);
            }
//            getEssenciaElementList();
        }

    }

}
