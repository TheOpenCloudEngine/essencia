package org.uengine.essencia.model.face;

import org.metaworks.Face;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.component.SelectBox;
import org.uengine.essencia.model.Competency;
import org.uengine.essencia.model.view.CompetencyView;
import org.uengine.essencia.modeling.canvas.EssenciaCanvas;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.IElement;

import java.util.ArrayList;

/**
 * Created by jjy on 2015. 12. 4..
 */
public class CompetencySelector extends SelectBox implements Face<Competency> {

    @AutowiredFromClient
    public EssenciaCanvas essenciaCanvas;


    @Override
    public void setValueToFace(Competency value) {
        ArrayList<String> options = new ArrayList<String>();

        if(essenciaCanvas!=null)
        for (ElementView e : essenciaCanvas.getElementViewList()) {
            if (e instanceof CompetencyView) {
                options.add(e.getElement().getName());
            }
        }

        if(options==null || options.size()==0 && value!=null){
            options = new ArrayList<String>();
            options.add(value.getName());
        }

        setOptionNames(options);
        setOptionValues(options);

        if(value!=null) {
           // setSelectedValue(value.getName());
            setSelected(value.getName());
        }

    }

    @Override
    public Competency createValueFromFace() {
        Competency competency = new Competency();
        competency.setName(getSelected());

        return competency;
    }
}
