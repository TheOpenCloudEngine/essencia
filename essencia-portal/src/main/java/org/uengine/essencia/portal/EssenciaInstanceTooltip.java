package org.uengine.essencia.portal;

import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.ModalWindow;
import org.springframework.stereotype.Component;
import org.uengine.codi.mw3.model.InstanceTooltip;
import org.uengine.essencia.enactment.AlphaGameBoard;

@Component
public class EssenciaInstanceTooltip extends InstanceTooltip{
    public EssenciaInstanceTooltip() throws Exception {
        super();
    }

    @Override
    @ServiceMethod(callByContent=true, target= ServiceMethodContext.TARGET_POPUP)
    public ModalWindow monitor() throws Exception{
        ModalWindow modal = new ModalWindow(new AlphaGameBoard());
        return modal;
    }



}
