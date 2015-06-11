package org.uengine.essencia.model.face;

import java.util.ArrayList;
import java.util.List;

import org.metaworks.annotation.AutowiredFromClient;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.BasicElement;
import org.uengine.essencia.model.LanguageElement;
import org.uengine.essencia.model.face.selectbox.AbstractSelectBoxFace;
import org.uengine.essencia.model.face.selectbox.InputAlphaSelectBoxFace;
import org.uengine.essencia.modeling.canvas.EssenciaCanvas;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.modeling.IElement;

public class InputAlphaFace extends AbstractInputAndCriterionFace {

    @AutowiredFromClient
    public EssenciaCanvas essenciaCanvas;

    public InputAlphaFace() {
        setAbstractSelectBoxFaceList(new ArrayList<AbstractSelectBoxFace>());
    }

    @Override
    public void add() {
        AbstractSelectBoxFace box = new InputAlphaSelectBoxFace();
        for (IElement e : essenciaCanvas.takeElementList()) {
            if (e instanceof Alpha && ((Alpha) e).getName() != null && !"".equals(((Alpha) e).getName())) {
                box.getMainSelectBox().add(((Alpha) e).getName(), ((Alpha) e).getName());
            }
        }
        ContextUtil.setWhen(box, EssenciaContext.WHEN_EDIT);
        getAbstractSelectBoxFaceList().add(box);
    }

    @Override
    public List<LanguageElement> createValue() {
        List<LanguageElement> returnList = new ArrayList<LanguageElement>();
        for (AbstractSelectBoxFace box : getAbstractSelectBoxFaceList()) {
            Alpha alpha = new Alpha(box.getMainSelectBox().getSelected());
            returnList.add(alpha);
        }

        return returnList;
    }

    @Override
    public void fillElements(List<LanguageElement> inputList) {
        for (int i = 0; i < inputList.size(); i++) {
            AbstractSelectBoxFace inputSelectBox = new InputAlphaSelectBoxFace();
            for (IElement e : getElementListFromCanvas()) {
                if (e instanceof Alpha) {
                    inputSelectBox.getMainSelectBox().add(e.getName(), e.getName());
                }
            }
            inputSelectBox.getMainSelectBox().setSelected(((BasicElement) inputList.get(i)).getName());
            getAbstractSelectBoxFaceList().add(inputSelectBox);
        }
    }

}
