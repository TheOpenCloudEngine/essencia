package org.uengine.essencia.portal;

import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.ServiceMethod;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.uengine.modeling.resource.DefaultResource;
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

        DefaultResource processResource = new DefaultResource();
        processResource.setPath(getPath() + File.separator + "New Method.method");
        processResource.setParent(this);

        processResource.newOpen();
    }

}
