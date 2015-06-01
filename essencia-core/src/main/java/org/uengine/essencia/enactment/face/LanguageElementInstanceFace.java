package org.uengine.essencia.enactment.face;

import org.metaworks.Face;
import org.metaworks.annotation.Hidden;
import org.uengine.essencia.enactment.LanguageElementInstance;
import org.uengine.essencia.model.BasicElement;
import org.uengine.essencia.model.PropertyValue;

import java.util.List;

public class LanguageElementInstanceFace implements Face<LanguageElementInstance> {

    String id;

    List<PropertyValue> propertyValueList;
        public List<PropertyValue> getPropertyValueList() {
            return propertyValueList;
        }
        public void setPropertyValueList(List<PropertyValue> propertyValueList) {
            this.propertyValueList = propertyValueList;
        }

    BasicElement languageElement;
        @Hidden
        public BasicElement getLanguageElement() {
            return languageElement;
        }

        public void setLanguageElement(BasicElement languageElement) {
            this.languageElement = languageElement;
        }

    @Override
    public void setValueToFace(LanguageElementInstance languageElementInstance) {
        setPropertyValueList(languageElementInstance.getPropertyValues());
        setLanguageElement(languageElementInstance.getLanguageElement());
    }

    @Override
    public LanguageElementInstance createValueFromFace() {


        return null;
    }
}
