package org.uengine.essencia.model.face;

import org.metaworks.Face;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.Order;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.ListFace;
import org.uengine.essencia.model.Criterion;
import org.uengine.essencia.modeling.canvas.EssenciaCanvas;

public class CriterionListFace extends ListFace<Criterion> {

    @Order(1)
    @org.metaworks.annotation.Face(displayName="Add New")
    @ServiceMethod(callByContent=true)
    public void add(@AutowiredFromClient EssenciaCanvas essenciaCanvas) {
        super.add();
    }
}
