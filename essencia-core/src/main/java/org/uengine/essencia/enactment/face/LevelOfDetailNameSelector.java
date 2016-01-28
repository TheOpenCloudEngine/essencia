package org.uengine.essencia.enactment.face;

import org.metaworks.Face;
import org.metaworks.FieldFace;
import org.metaworks.component.SelectBox;
import org.uengine.essencia.enactment.WorkProductInstance;
import org.uengine.essencia.model.LevelOfDetail;
import org.uengine.essencia.model.State;
import org.uengine.essencia.model.WorkProduct;

import java.util.ArrayList;
import java.util.List;

public class LevelOfDetailNameSelector extends SelectBox implements Face<String>, FieldFace<WorkProductInstance> {
    @Override
    public void setValueToFace(String value) {
        setSelectedValue(value);
    }

    @Override
    public String createValueFromFace() {
        return getSelected();
    }

    @Override
    public void visitHolderObjectOfField(WorkProductInstance holderObject) {

        ArrayList<String> options = new ArrayList<String>();
        for(State levelOfDetail : holderObject.getAlpha().getStates()){
            options.add(levelOfDetail.getName());
        }

        setOptionNames(options);
        setOptionValues(options);
    }
}
