package org.uengine.essencia.modeling.modeler;

import java.util.List;

import org.metaworks.MetaworksContext;
import org.metaworks.annotation.Available;
import org.uengine.modeling.*;

public abstract class EssenciaModeler extends DefaultModeler {

    public EssenciaModeler() {
        super();
    }

    public IModel takeModel() throws Exception {
        if(this.model == null)
            this.model = createModel();

        return this.model;
    }
  public abstract  IModel createModel();
}
