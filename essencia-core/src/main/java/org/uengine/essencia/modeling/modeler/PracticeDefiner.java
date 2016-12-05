package org.uengine.essencia.modeling.modeler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.uengine.contexts.TextContext;
import org.uengine.essencia.model.BasicElement;
import org.uengine.essencia.model.Practice;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.modeling.canvas.EssenciaCanvas;
import org.uengine.essencia.modeling.canvas.PracticeCanvas;
import org.uengine.essencia.modeling.palette.EssenciaPalette;
import org.uengine.modeling.*;

/**
 * @author jyj
 */
public class PracticeDefiner extends DefaultModeler {

    public final static String SUFFIX = ".practice";

    public PracticeDefiner() {
//        setType(SUFFIX);
        setCanvas(new PracticeCanvas());
        setPalette(new EssenciaPalette());
    }


    String baseKernel;
        public String getBaseKernel() {
            return baseKernel;
        }
        public void setBaseKernel(String baseKernel) {
            this.baseKernel = baseKernel;
        }


    @Override
    public void setModel(IModel model) throws Exception {


        if( model != null ){
            List<ElementView> elementViewList = new ArrayList<ElementView>();
            List<RelationView> relationViewList = new ArrayList<RelationView>();

            PracticeDefinition practice = (PracticeDefinition) model;
            practice.afterDeserialize();

            for (IElement element : practice.getElementList()) {
                elementViewList.add(((BasicElement) element).asView());
            }

            for (IRelation relation : practice.getRelationList()) {
                relationViewList.add(relation.asView());
            }

            getCanvas().setElementViewList(elementViewList);
            getCanvas().setRelationViewList(relationViewList);
            getCanvas().setId(((PracticeDefinition) model).getId());

            setBaseKernel(practice.getBaseKernel());


        }
    }


    @Override
    public IModel createModel() {
        try {
            return makePracticeFromCanvas(getCanvas());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public PracticeDefinition makePracticeFromCanvas(Canvas canvas) throws Exception {
        PracticeDefinition practice = new PracticeDefinition();

        practice.setBaseKernel(getBaseKernel());

        TextContext practiceName = new TextContext();

        for (ElementView elementView : ((EssenciaCanvas) canvas).getSafeElementViewList()) {

            BasicElement element = (BasicElement) elementView.asElement();

            element.setName(elementView.getLabel());
            if (element instanceof Practice) {
                practiceName.setText(element.getName());
            }
            practice.addElement(element);
        }

        for (RelationView relationView : ((EssenciaCanvas) canvas).getSafeRelationViewList()) {
            Relation relation = (Relation) relationView.asRelation();
            practice.addRelationList(relation);
        }

        practice.setName(practiceName);
        return practice;
    }
}
