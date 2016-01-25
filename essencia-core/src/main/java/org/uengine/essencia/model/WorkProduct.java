package org.uengine.essencia.model;

import java.util.ArrayList;
import java.util.List;

import org.metaworks.annotation.Face;
import org.metaworks.annotation.Hidden;
import org.uengine.essencia.component.EssenciaConcernSelectBox;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.enactment.LanguageElementInstance;
import org.uengine.essencia.enactment.WorkProductInstance;
import org.uengine.essencia.model.card.Card;
import org.uengine.essencia.model.card.WorkProductCard;
import org.uengine.essencia.model.face.list.LevelOfDetailListFace;
import org.uengine.essencia.model.face.list.ListFace;
import org.uengine.essencia.model.face.list.StateListFace;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.kernel.ProcessInstance;
import org.uengine.uml.model.ObjectInstance;

public class WorkProduct extends Alpha{//BasicElement implements ContextTransformer, CardViewable, FaceTransformer, XMIResourceElement, HasLevel {


//    private List<LevelOfDetail> levelOfDetails;
//    private transient LevelOfDetailListFace listFace;
//

    @Override
    @Face(displayName = "Levels Of Detail")
    public List<State> getStates() {
        return super.getStates();
    }


    @Override
    @Face(displayName = "Levels of detail")
    public ListFace getListFace() {
        return super.getListFace();
    }

    @Hidden
    public List<LevelOfDetail> getLevelOfDetails() {
        if(getStates()==null)
            return null;


        List<LevelOfDetail> levelOfDetails = new ArrayList<LevelOfDetail>();

        for(State state : getStates()){
            levelOfDetails.add((LevelOfDetail) state);
        }

        return levelOfDetails;
    }

//    public void setLevelOfDetails(List<LevelOfDetail> levelOfDetails) {
//        this.levelOfDetails = levelOfDetails;
//    }


//    @Face(displayName = "LevelOfDetail")
//    public LevelOfDetailListFace getListFace() {
//        return listFace;
//    }
//
//    public void setListFace(LevelOfDetailListFace listFace) {
//        this.listFace = listFace;
//    }

    public WorkProduct() {
        setListFace(new LevelOfDetailListFace());
    }

    public WorkProduct(String name) {
        this();
        setName(name);
    }

    @Override
    public Card createCardView() {
        Card card = new WorkProductCard(this);
        return card;
    }

    @Override
    public String getDescription() {
        return description.getText();
    }

    @Override
    public void transformContext() {
        ContextUtil.setWhen(this, EssenciaContext.WHEN_EDIT);
        ContextUtil.setWhen(getListFace(), EssenciaContext.WHEN_EDIT);
    }

    @Override
    public Essence.Foundation.BasicElement toXmi() {
        Essence.AlphaAndWorkProduct.WorkProduct workProduct = Essence.AlphaAndWorkProduct.AlphaAndWorkProductFactory.eINSTANCE.createWorkProduct();

        // set alpha
        workProduct.setName(getName());
        workProduct.setDescription(getDescription());
        for (LevelOfDetail levelOfDetail : getLevelOfDetails()) {
            workProduct.getLevelOfDetail().add((Essence.AlphaAndWorkProduct.LevelOfDetail) levelOfDetail.toXmi());
        }

        return workProduct;
    }

    @Override
    protected ListFace createListFace(){
        return new LevelOfDetailListFace();
    }



    public LevelOfDetail findLevelOfDetail(String levelOfDetailName) {
        if (levelOfDetailName == null) return null;//throw new IllegalArgumentException("Finding state name is null");

        for (LevelOfDetail levelOfDetail : getLevelOfDetails()) {
            if (levelOfDetailName.equals(levelOfDetail.getName())) {
                return levelOfDetail;
            }
        }

        throw new IllegalArgumentException("No such state named " + levelOfDetailName);

    }

//    @Override
//    public List<WorkProductInstance> getInstances(ProcessInstance instance) {
//        return (List<WorkProductInstance>) super.getInstances(instance);
//    }

    @Override
    public WorkProductInstance createObjectInstance() {
        return (WorkProductInstance) super.createObjectInstance();
    }

    @Override
    protected ObjectInstance newObjectInstance() {
        return new WorkProductInstance();
    }

}