package org.uengine.essencia.model;

import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.util.ContextUtil;

public class Practice extends BasicElement implements ContextTransformer {

    public Practice() {
    }

    @Override
    public void transformContext() {
	ContextUtil.setWhen(this, EssenciaContext.WHEN_EDIT);
    }

}