package org.uengine.essencia.model;

import java.util.List;

import org.metaworks.annotation.Face;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.Order;
import org.metaworks.component.SelectBox;
import org.uengine.essencia.component.EssenciaConcernSelectBox;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.model.card.Card;
import org.uengine.essencia.model.card.CompetencyCard;
import org.uengine.essencia.model.face.list.CompetencyLevelListFace;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.kernel.Role;
import org.uengine.kernel.view.RoleView;
import org.uengine.uml.model.Attribute;

public class Competency extends BasicElement implements Concernable, ContextTransformer, CardViewable, FaceTransformer, XMIResourceElement {

    private String concern;
    private transient SelectBox concernSelectBox;

    private List<CompetencyLevel> competencyLevels;
    private transient CompetencyLevelListFace listFace;

    @Hidden
    public List<CompetencyLevel> getCompetencyLevels() {
        return competencyLevels;
    }

    public void setCompetencyLevels(List<CompetencyLevel> competencyLevels) {
        this.competencyLevels = competencyLevels;
    }

    @Hidden
    @Override
    public String getConcern() {
        return concern;
    }

    @Override
    public void setConcern(String concern) {
        this.concern = concern;
    }

    @Face(displayName = "Concern")
    @Order(4)
    @Override
    public SelectBox getConcernBox() {
        return concernSelectBox;
    }

    @Override
    public void setConcernBox(SelectBox concern) {
        this.concernSelectBox = concern;
    }

    @Order(5)
    @Face(displayName = "CompetencyLevel")
    public CompetencyLevelListFace getListFace() {
        return listFace;
    }

    public void setListFace(CompetencyLevelListFace listFace) {
        this.listFace = listFace;
    }

    public Competency() {
        setConcernBox(new EssenciaConcernSelectBox());

        setListFace(new CompetencyLevelListFace());
    }

    @Override
    public boolean equals(Object obj) {
        if( obj == null){
            return false;
        }
        if (obj instanceof Role) {
            Role role = (Role) obj;
            return getName().equals(role.getName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public Card createCardView() {
        Card card = new CompetencyCard(this);
        return card;
    }

    @Override
    public void transformContext() {
        if (getOwner() != null && EssenciaContext.ESSENCE_KERNEL.equals(getOwner().getName())) {
            ContextUtil.setWhen(this, EssenciaContext.WHEN_VIEW);
            ContextUtil.setWhen(getListFace(), EssenciaContext.WHEN_VIEW);
        } else {
            ContextUtil.setWhen(this, EssenciaContext.WHEN_EDIT);
            ContextUtil.setWhen(getListFace(), EssenciaContext.WHEN_EDIT);
        }
    }

    @Override
    public Essence.Foundation.BasicElement toXmi() {
        Essence.Competency.Competency competency = Essence.Competency.CompetencyFactory.eINSTANCE.createCompetency();

        // set alpha
        competency.setName(getName());
        competency.setDescription(getDescription());
        for (CompetencyLevel cl : getCompetencyLevels()) {
            competency.getPossibleLevel().add(cl.toXmi());
        }

        return competency;
    }

    @Override
    public void setUpElement() {
        super.setUpElement();
        setListFace(new CompetencyLevelListFace());
        if (getCompetencyLevels() != null) {
            getListFace().fillElements(getCompetencyLevels());
            getCompetencyLevels().clear();
        }

        setConcernBox(new EssenciaConcernSelectBox());
        getConcernBox().setSelected(getConcern());
        setConcern("");
    }

    @Override
    public void beforeApply() {
        super.beforeApply();
        setCompetencyLevels(getListFace().createValue());

        setConcern(getConcernBox().getSelected());
        setConcernBox(null);
    }

    @Override
    @Hidden(on=false)
    public Attribute[] getFieldDescriptors() {
        return super.getFieldDescriptors();
    }


}