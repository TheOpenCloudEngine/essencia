package org.uengine.essencia.portal;


import org.metaworks.Refresh;
import org.metaworks.Remover;
import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.*;
import org.metaworks.dwr.MetaworksRemoteService;
import org.metaworks.widget.ModalWindow;
import org.uengine.essencia.enactment.EssenceProcessDefinition;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.util.KernelUtil;
import org.uengine.modeling.resource.DefaultResource;
import org.uengine.modeling.resource.SelectedResource;
import org.uengine.modeling.resource.VersionManager;
import org.uengine.processadmin.ProcessAdminResourceNavigator;

/**
 * Created by jjy on 2016. 5. 4..
 */
//@Face(ejsPath="genericfaces/CleanObjectFace.ejs")
    @Face(displayName = "New Method")
public class NewMethodPopup {

    public NewMethodPopup() {
    }

    String methodName;
    @Order(2)
        public String getMethodName() {
            return methodName;
        }
        public void setMethodName(String methodName) {
            this.methodName = methodName;
        }


    String path;
    @Hidden
        public String getPath() {
            return path;
        }
        public void setPath(String path) {
            this.path = path;
        }

    String baseKernel;
    @Range(options={
            "OMG Essence Kernel 1.0",
            "OMG Essence Kernel (Korean)",
            "OMG Essence Kernel (Russian)",
        },
            values={
                    KernelUtil.DEFAULT_KERNEL,
                    "essence_kor",
                    "essence_ru",
            })
    @Order(10)
        public String getBaseKernel() {
            return baseKernel;
        }
        public void setBaseKernel(String baseKernel) {
            this.baseKernel = baseKernel;
        }


//    ProcessAdminResourceNavigator processAdminResourceNavigator;
//        public ProcessAdminResourceNavigator getProcessAdminResourceNavigator() {
//            return processAdminResourceNavigator;
//        }
//        public void setProcessAdminResourceNavigator(ProcessAdminResourceNavigator processAdminResourceNavigator) {
//            this.processAdminResourceNavigator = processAdminResourceNavigator;
//        }

    public NewMethodPopup(EssenciaProcessAdminContainerResource essenciaProcessAdminContainerResource) {
        setPath(essenciaProcessAdminContainerResource.getPath());

//        setProcessAdminResourceNavigator(new ProcessAdminResourceNavigator(){
//            @Override
//            protected String getAppName() {
//                return (super.getAppName() + "/" + VersionManager.getProductionResourcePath(super.getAppName(), ""));
//            }
//        });
//
//        getProcessAdminResourceNavigator().setResourceControlDelegate(new ResourceControlDelegateForSelect());
//        getProcessAdminResourceNavigator().getRoot().filtResources(KernelResource.class);

    }

    @ServiceMethod(target = ServiceMethodContext.TARGET_POPUP, callByContent = true)
    public void create() throws Exception {
        DefaultResource processResource = new DefaultResource();
        processResource.setPath(getPath() + "/"+ getMethodName() +".method");
       // processResource.setParent(this);

        EssenceProcessDefinition processDefinition = new EssenceProcessDefinition();
        processDefinition.setPracticeDefinition(new PracticeDefinition());
        processDefinition.getPracticeDefinition().setBaseKernel(getBaseKernel());

        MetaworksRemoteService.autowire(processResource);

        processResource.save(processDefinition);

        processResource.reopen();


        ProcessAdminResourceNavigator navigator = new ProcessAdminResourceNavigator();
        MetaworksRemoteService.autowire(navigator);
        navigator.load();


        MetaworksRemoteService.addReturn(new Remover(new ModalWindow()));
        MetaworksRemoteService.addReturn(new Refresh(navigator));

    }
}
