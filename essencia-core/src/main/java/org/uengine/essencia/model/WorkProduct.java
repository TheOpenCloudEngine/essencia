package org.uengine.essencia.model;

import java.util.List;

import org.metaworks.annotation.Face;
import org.metaworks.annotation.Hidden;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.enactment.LanguageElementInstance;
import org.uengine.essencia.enactment.WorkProductInstance;
import org.uengine.essencia.model.card.Card;
import org.uengine.essencia.model.card.WorkProductCard;
import org.uengine.essencia.model.face.list.LevelOfDetailListFace;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.kernel.ProcessInstance;

public class WorkProduct extends BasicElement implements ContextTransformer, CardViewable, FaceTransformer, XMIResourceElement {



    private List<LevelOfDetail> list;
    private transient LevelOfDetailListFace listFace;

    public List<LevelOfDetail> getLevelOfDetails() {
        return getList();
    }

    @Hidden
    public List<LevelOfDetail> getList() {
        return list;
    }

    public void setList(List<LevelOfDetail> list) {
        this.list = list;
    }

    @Face(displayName = "LevelOfDetail")
    public LevelOfDetailListFace getListFace() {
        return listFace;
    }

    public void setListFace(LevelOfDetailListFace listFace) {
        this.listFace = listFace;
    }

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
        for (LevelOfDetail levelOfDetail : getList()) {
            workProduct.getLevelOfDetail().add(levelOfDetail.toXmi());
        }

        return workProduct;
    }

    @Override
    public void setUpElement() {
        super.setUpElement();
        setListFace(new LevelOfDetailListFace());
        if (getList() != null) {
            getListFace().fillElements(getList());
            getList().clear();
        }
    }

    @Override
    public void beforeApply() {
        super.beforeApply();
        setList(getListFace().createValue());
    }

    public LevelOfDetail findLevelOfDetail(String levelOfDetailName) {
        if(levelOfDetailName==null) return null;//throw new IllegalArgumentException("Finding state name is null");

        for(LevelOfDetail levelOfDetail : getList()){
            if(levelOfDetailName.equals(levelOfDetail.getName())){
                return levelOfDetail;
            }
        }

        throw new IllegalArgumentException("No such state named " + levelOfDetailName);

    }

    @Override
    public List<WorkProductInstance> getInstances(ProcessInstance instance) {
        return (List<WorkProductInstance>)super.getInstances(instance);
    }

    @Override
    public WorkProductInstance createInstance(String id) {
        return (WorkProductInstance) new WorkProductInstance(this, id);
    }
}