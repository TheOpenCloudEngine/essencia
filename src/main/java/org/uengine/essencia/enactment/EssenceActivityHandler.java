package org.uengine.essencia.enactment;

import org.metaworks.annotation.Hidden;
import org.uengine.essencia.model.LanguageElement;
import org.uengine.essencia.model.PropertyValue;
import org.uengine.essencia.model.WorkProduct;
import org.uengine.kernel.ITool;
import org.uengine.processmanager.TransactionContext;

import java.util.List;

public class EssenceActivityHandler implements ITool{

    EssenceActivity essenceActivity;
    @Hidden
        public EssenceActivity getEssenceActivity() {
            return essenceActivity;
        }
        public void setEssenceActivity(EssenceActivity essenceActivity) {
            this.essenceActivity = essenceActivity;
        }


    List<PropertyValue> propertyValueList;
        public List<PropertyValue> getPropertyValueList() {
            return propertyValueList;
        }
        public void setPropertyValueList(List<PropertyValue> propertyValueList) {
            this.propertyValueList = propertyValueList;
        }



    @Override
    public void onLoad() throws Exception {

        //org.metaworks.dao.TransactionContext.getThreadLocalInstance().getSharedContext("processManager");

        for(LanguageElement workProduct_ : getEssenceActivity().getActivityInEssenceDefinition().getWorkProductList()){
            WorkProduct workProduct = (WorkProduct) workProduct_; //TODO: why need we casting?

            setPropertyValueList(workProduct.createDefaultPropertyValues());
        }
    }

    @Override
    public void beforeComplete() throws Exception {

    }

    @Override
    public void afterComplete() throws Exception {

    }

    public EssenceActivityHandler(){

    }


}
