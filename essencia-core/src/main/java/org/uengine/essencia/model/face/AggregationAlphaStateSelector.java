package org.uengine.essencia.model.face;

import org.metaworks.Face;
import org.metaworks.FieldFace;
import org.metaworks.MetaworksContext;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.Order;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.component.SelectBox;
import org.metaworks.model.MetaworksElement;
import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.model.State;
import org.uengine.modeling.resource.editor.MethodEditor;

import java.util.ArrayList;

/**
 * Created by jjy on 2016. 5. 28..
 */
public class AggregationAlphaStateSelector extends SelectBox implements Face<String> {

    @AutowiredFromClient
    public MethodEditor methodEditor;

    @AutowiredFromClient
    public Alpha alpha;

    public AggregationAlphaStateSelector(){
        super();
        getMetaworksContext().setHow("unloaded");
    }

    @Override
    public void setValueToFace(String value) {

       //  test if the FaceWrapper machanism is problematic.

        // end of test

        if (alpha == null || methodEditor == null) {
            getOptionNames().add("Right-click & 'amend from kernel'");
            //getOptionNames().add("reference from kernel");
            getMetaworksContext().setHow("unloaded");
            getOptionValues().add("");


            setSelected(value);

            return;
        }

        PracticeDefinition practiceDefinition = methodEditor.createPracticeDefinition();
        practiceDefinition.arrangeRelations();
        alpha = (Alpha) practiceDefinition.getElementByName(alpha.getName());

        if (alpha == null) return;
        //throw new RuntimeException("Please apply once before amending states from the kernel and try it after opening the properties dialog again.");

        if (!(alpha instanceof Alpha) || alpha.getIncomingRelations() == null || alpha.getIncomingRelations().size() == 0) {
            return; //throw new RuntimeException("There is no parent alpha to amend state.");
        }


        if (!(alpha.getIncomingRelations().get(0).getSourceElement() instanceof Alpha)) {
            return; //throw new RuntimeException("There is no parent alpha to amend state.");
        }


        Alpha kernel = (Alpha) alpha.getIncomingRelations().get(0).getSourceElement();
        if (kernel != null) {

            setOptionNames(new ArrayList<String>());

            getOptionNames().add("");

            for (State state : kernel.getStates()) {
                getOptionNames().add(state.getName());
            }
        }

        setOptionValues(getOptionNames());

        getMetaworksContext().setWhen(MetaworksContext.WHEN_EDIT);
        getMetaworksContext().setHow("loaded");

        setSelected(value);

    }


    @Override
    public String createValueFromFace() {
        return getSelected();
    }


    @ServiceMethod(callByContent = true, onLoad = true, inContextMenu = true, bindingFor = "this", eventBinding = "change", how="unloaded", target=ServiceMethod.TARGET_SELF)
    @Order(100)
    public void amendFromKernel(@AutowiredFromClient Alpha alpha, @AutowiredFromClient MethodEditor methodEditor) {
        this.alpha = (alpha);
        this.methodEditor = methodEditor;

        setValueToFace(getSelected());
    }
}