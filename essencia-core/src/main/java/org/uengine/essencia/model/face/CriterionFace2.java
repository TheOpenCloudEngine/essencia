package org.uengine.essencia.model.face;

import org.metaworks.ContextAware;
import org.metaworks.Face;
import org.metaworks.MetaworksContext;
import org.metaworks.annotation.*;
import org.metaworks.component.SelectBox;
import org.uengine.essencia.model.*;
import org.uengine.essencia.modeling.canvas.EssenciaCanvas;

import java.util.ArrayList;
import java.util.logging.Level;

public class CriterionFace2 implements Face<Criterion>, ContextAware {

    public CriterionFace2(){
        setMetaworksContext(new MetaworksContext());
        setCriteriaElement(new Alpha());
    }

    BasicElement criteriaElement;
 //   @NonEditable(when="phase2")
    @org.metaworks.annotation.Face(faceClass=AlphaOrWorkProductSelectorFace.class)
        public BasicElement getCriteriaElement() {
            return criteriaElement;
        }
        public void setCriteriaElement(BasicElement criteriaElement) {
            this.criteriaElement = criteriaElement;
        }


    @ServiceMethod(eventBinding = "criteriaElement")
    public void next(
            @Payload("criteriaElement") BasicElement criteriaElement,
            @AutowiredFromClient(select = "criteriaElement.selected == autowiredObject.name") BasicElement basicElement,
            @AutowiredFromClient EssenciaCanvas essenciaCanvas

            ){
        getMetaworksContext().setWhere("phase2");

        BasicElement element = basicElement;

        if(element!=null){
            setLevelSelector(new SelectBox());
            getLevelSelector().setOptionNames(new ArrayList<String>());

            if(element instanceof Alpha){

                Alpha alpha = (Alpha)element;

                if(alpha.getStates()!=null)
                for(State state : alpha.getStates()){
                    getLevelSelector().getOptionNames().add(state.getName());
                }
            }else if(element instanceof WorkProduct){
                WorkProduct workProduct = (WorkProduct)element;

                if(workProduct.getLevelOfDetails()!=null)
                for(LevelOfDetail levelOfDetail : workProduct.getLevelOfDetails()){
                    getLevelSelector().getOptionNames().add(levelOfDetail.getName());
                }
            }

            getLevelSelector().setOptionValues(getLevelSelector().getOptionNames());
        }
    }

    SelectBox levelSelector;
    @Available(where="phase2")
        public SelectBox getLevelSelector() {
            return levelSelector;
        }
        public void setLevelSelector(SelectBox levelSelector) {
            this.levelSelector = levelSelector;
        }


    @Override
    public void setValueToFace(Criterion value) {

        if(value.getMetaworksContext()!=null)
            getMetaworksContext().setWhen(value.getMetaworksContext().getWhen());


        if(value.getElement()!=null)
            setCriteriaElement(value.getElement());

        setLevelSelector(new SelectBox());
        getLevelSelector().setOptionNames(new ArrayList<String>());

        if(getCriteriaElement() instanceof Alpha){


            if(value.getState()!=null) {
                getLevelSelector().getOptionNames().add(value.getState().getName());
                getLevelSelector().setOptionValues(getLevelSelector().getOptionNames());

                getLevelSelector().setSelectedValue(value.getState().getName());

            }

        }else{
            if(value.getLevelOfDetail()!=null) {
                getLevelSelector().getOptionNames().add(value.getLevelOfDetail().getName());
                getLevelSelector().setOptionValues(getLevelSelector().getOptionNames());

                getLevelSelector().setSelectedValue(value.getLevelOfDetail().getName());
            }
        }



    }

    @Override
    public Criterion createValueFromFace() {

        if(getCriteriaElement()==null){
            return null;
        }

        Criterion criterion = new Criterion();

        if(getLevelSelector()==null){
            return criterion;
        }

        if(getCriteriaElement() instanceof Alpha){
            State state = new State();
            state.setName(getLevelSelector().getSelected());

            Alpha alpha = (Alpha)getCriteriaElement();
            state.setParentAlpha(alpha);

            criterion.setState(state);
        }else if(getCriteriaElement() instanceof WorkProduct){
            LevelOfDetail levelOfDetail = new LevelOfDetail();
            levelOfDetail.setName(getLevelSelector().getSelected());

            WorkProduct workProduct = (WorkProduct)getCriteriaElement();
            levelOfDetail.setParentWorkProduct(workProduct);

            criterion.setLevelOfDetail(levelOfDetail);

        }


        return criterion;
    }


    MetaworksContext metaworksContext;
        @Override
        public MetaworksContext getMetaworksContext() {
            return metaworksContext;
        }
        @Override
        public void setMetaworksContext(MetaworksContext metaworksContext) {
            this.metaworksContext = metaworksContext;
        }

}
