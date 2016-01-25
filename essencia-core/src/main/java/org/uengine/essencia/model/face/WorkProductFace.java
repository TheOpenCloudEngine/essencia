package org.uengine.essencia.model.face;

import java.util.ArrayList;
import java.util.List;

import org.uengine.essencia.component.EssenciaSelectBox;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.model.CompletionCriterion;
import org.uengine.essencia.model.Criterion;
import org.uengine.essencia.model.LanguageElement;
import org.uengine.essencia.model.LevelOfDetail;
import org.uengine.essencia.model.WorkProduct;
import org.uengine.essencia.model.face.selectbox.AbstractSelectBoxFace;
import org.uengine.essencia.model.face.selectbox.CriterionSelectBoxFace;
import org.uengine.essencia.model.face.selectbox.WorkProductSelectBoxFace;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.essencia.util.ElementUtil;
import org.uengine.modeling.IElement;

public class WorkProductFace extends CriterionFace {

    @Override
    public void add() {
        WorkProductSelectBoxFace box = new WorkProductSelectBoxFace();
        for (IElement e : getElementListFromCanvas()) {
            if (e instanceof WorkProduct && !"".equals(((WorkProduct) e).getName())) {
                box.getMainSelectBox().add(((WorkProduct) e).getName(), ((WorkProduct) e).getName());
            }
        }
        ContextUtil.setWhen(box, EssenciaContext.WHEN_EDIT);
        setAbstractSelectBoxFaceList(ElementUtil.syncList(getAbstractSelectBoxFaceList()));
        getAbstractSelectBoxFaceList().add(box);
    }

    @Override
    public List<CompletionCriterion> createValue() {
        List<CompletionCriterion> returnList = new ArrayList<CompletionCriterion>();
        for (AbstractSelectBoxFace box : getAbstractSelectBoxFaceList()) {
            Criterion criterion = new CompletionCriterion();
            criterion.setUpLevelOfDetail(((CriterionSelectBoxFace) box).getSubSelectBox().getSelectedText(), box.getMainSelectBox()
                    .getSelectedText());
            returnList.add((CompletionCriterion)criterion);
        }
        getAbstractSelectBoxFaceList().clear();
        return returnList;
    }

    @Override
    public void fillElements(List<? extends LanguageElement> list) {
        for (int i = 0; i < list.size(); i++) {

            if(((Criterion) list.get(i)).getLevelOfDetail().getParentAlpha() == null) continue; //skip invalid data

            add();


            getAbstractSelectBoxFaceList().get(i).getMainSelectBox()
                    .setSelected(((Criterion) list.get(i)).getLevelOfDetail().getParentWorkProduct().getName());
            ((CriterionSelectBoxFace) getAbstractSelectBoxFaceList().get(i)).setSubSelectBox(new EssenciaSelectBox());


            for (IElement e : getElementListFromCanvas()) {
                if (e instanceof WorkProduct
                        && ((Criterion) list.get(i)).getLevelOfDetail().getParentWorkProduct().getName().equals(((WorkProduct) e).getName())) {
                    for (LevelOfDetail l : ((WorkProduct) e).getLevelOfDetails()) {
                        ((CriterionSelectBoxFace) getAbstractSelectBoxFaceList().get(i)).getSubSelectBox().add(l.getName(), l.getName());
                    }
                }
            }

            ((CriterionSelectBoxFace) getAbstractSelectBoxFaceList().get(i)).getSubSelectBox().setSelected(
                    ((Criterion) list.get(i)).getLevelOfDetail().getName());
        }

    }
}
