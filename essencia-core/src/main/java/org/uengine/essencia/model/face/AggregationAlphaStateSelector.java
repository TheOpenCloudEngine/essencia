package org.uengine.essencia.model.face;

import org.metaworks.Face;
import org.metaworks.FieldFace;
import org.metaworks.MetaworksContext;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.Order;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.component.SelectBox;
import org.metaworks.dao.TransactionContext;
import org.metaworks.model.MetaworksElement;
import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.model.State;
import org.uengine.modeling.resource.editor.MethodEditor;

import java.util.ArrayList;

/**
 * Created by jjy on 2016. 5. 28..
 */
public class AggregationAlphaStateSelector extends SelectBox implements Face<String>, FieldFace<State> {

    @AutowiredFromClient
    public MethodEditor methodEditor;

//    @AutowiredFromClient
//    public Alpha alpha;


    String parentAlphaName;
        public String getParentAlphaName() {
            return parentAlphaName;
        }
        public void setParentAlphaName(String parentAlphaName) {
            this.parentAlphaName = parentAlphaName;
        }



    public AggregationAlphaStateSelector(){
        super();
        getMetaworksContext().setHow("unloaded");
    }

    @Override
    public void setValueToFace(String value) {

       //  test if the FaceWrapper machanism is problematic.

        // end of test
        setSelected(value);

        if (/*alpha == null ||*/ methodEditor == null || methodEditor.getCanvas()==null || methodEditor.getCanvas().getElementViewList()==null || methodEditor.getCanvas().getElementViewList().size() < 2) {
            getOptionNames().add("Right-click & 'amend from kernel'");
            getMetaworksContext().setHow("unloaded");
            getOptionValues().add("");


            setSelected(value);

            return;
        }


        Alpha kernel = (Alpha) methodEditor.getCanvas().getElementViewList().get(0).getElement();
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


    @ServiceMethod(callByContent = true, /*onLoad = true,*/ inContextMenu = true, bindingFor = "this", eventBinding = "change", how="unloaded", target=ServiceMethod.TARGET_SELF)
    @Order(100)
    public void amendFromKernel(@AutowiredFromClient(payload = "canvas.elementViewList[element.name == value.parentAlphaName].element.states") MethodEditor methodEditor) {

        TransactionContext.getThreadLocalInstance().setMW3FaceOptionEnabled(false);

        this.methodEditor = methodEditor;

        setValueToFace(getSelected());
    }


    @Override
    public void visitHolderObjectOfField(State holderObject) {
        setParentAlphaName(holderObject.getParentAlpha() !=null ? holderObject.getParentAlpha().getParentElementId() : null);
    }
}