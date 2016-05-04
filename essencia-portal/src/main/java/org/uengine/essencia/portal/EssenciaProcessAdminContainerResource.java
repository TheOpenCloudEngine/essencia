package org.uengine.essencia.portal;

import org.metaworks.MetaworksContext;
import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.dwr.MetaworksRemoteService;
import org.metaworks.widget.ModalWindow;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.uengine.modeling.resource.DefaultResource;
import org.uengine.processadmin.ImportPopup;
import org.uengine.processadmin.ProcessAdminContainerResource;

import java.io.File;

/**
 * Created by jjy on 2015. 11. 10..
 */
@Component
@Scope("prototype")
public class EssenciaProcessAdminContainerResource extends ProcessAdminContainerResource{

    @ServiceMethod(inContextMenu = true, target = ServiceMethodContext.TARGET_POPUP)
    public void newMethod() throws Exception {

        ModalWindow popup = new ModalWindow(new NewMethodPopup(this), 500, 200);
        popup.getMetaworksContext().setWhen(MetaworksContext.WHEN_EDIT);
        popup.setTitle("Create new method :  Select Kernel");
        MetaworksRemoteService.wrapReturn(popup);

//
//        DefaultResource processResource = new DefaultResource();
//        processResource.setPath(getPath() + "/New Method.method");
//        processResource.setParent(this);
//
//        processResource.newOpen();
    }

//    @Override
//    @Hidden
//    public void newProcess() throws Exception {
//    }
//
//    @Override
//    @Hidden
//    public void newClass() throws Exception {
//    }
//
//    @Override
//    @Hidden
//    public void newURLApplication() throws Exception {
//    }

    @Override
    public void importResource() throws Exception {
        MetaworksRemoteService.wrapReturn(new ModalWindow(new ImportPopup(this), 500, 200));
    }
}
