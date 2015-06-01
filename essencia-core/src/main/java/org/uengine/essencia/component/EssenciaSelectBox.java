package org.uengine.essencia.component;

import org.metaworks.component.SelectBox;
import org.uengine.essencia.model.ActivitySpace;
import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.Criterion;
import org.uengine.essencia.model.LanguageElement;

public class EssenciaSelectBox extends SelectBox {

    @Override
    public void add(String name, String value) {
        defaultValueSetting();
        for (String registeredName : getOptionNames()) {
            if(registeredName == null || "".equals(registeredName)){
                break;
            }
            if (registeredName.equals(name)) {
                return;
            }
        }
        super.add(name, value);
    }

    public void addActivitySpaceForEntry(ActivitySpace activitySpace) {
	// entry 
        defaultValueSetting();
        if ("".equals(activitySpace.getName())) {
            return;
        }
        for (LanguageElement e : activitySpace.getInputList()) {
            Alpha alpha = (Alpha)e;
            super.add(alpha.getName(), alpha.getName());
        }

    }
    public void addActivitySpaceForCompletion(ActivitySpace activitySpace) {
	// completion
	defaultValueSetting();
	if ("".equals(activitySpace.getName())) {
	    return;
	}
	for (LanguageElement e : activitySpace.getCompletionCriteria()) {
	    Criterion c = (Criterion)e;
	    super.add(c.getState().getParentAlpha().getName(), c.getState().getParentAlpha().getName());
	}
	
    }

    private void defaultValueSetting() {
        if (getOptionNames().size() == 0) {
            super.add("==choose==", "==choose==");
        }
    }

}
