package org.uengine.essencia.model.face;

import org.metaworks.Face;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.component.SelectBox;
import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.BasicElement;
import org.uengine.essencia.model.WorkProduct;
import org.uengine.essencia.modeling.canvas.EssenciaCanvas;
import org.uengine.modeling.ElementView;

import java.util.ArrayList;

public class AlphaOrWorkProductSelectorFace extends SelectBox implements Face<BasicElement> {

    @AutowiredFromClient public EssenciaCanvas essenciaCanvas;

    @Override
    public void setValueToFace(BasicElement value) {
        ArrayList<String> elementNames = new ArrayList<String>();

        if(essenciaCanvas!=null && essenciaCanvas.getElementViewList()!=null)
        for(ElementView elementView : essenciaCanvas.getElementViewList()){
            if(elementView.getElement() instanceof Alpha || elementView.getElement() instanceof WorkProduct){

                elementNames.add(elementView.getElement().getName());
            }
        }

        setOptionNames(elementNames);
        setOptionValues(elementNames);

        if(value!=null)
            setSelected(value.getName());
    }

    @Override
    public BasicElement createValueFromFace() {
        BasicElement element =  new Alpha();
        element.setName(getSelected());

        return element;
    }
}
