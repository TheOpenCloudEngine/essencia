package org.uengine.essencia.enactment;

import org.metaworks.Remover;
import org.metaworks.ToOpener;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.Payload;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.dwr.MetaworksRemoteService;
import org.metaworks.widget.ModalWindow;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.uengine.kernel.ProcessInstance;
import org.uengine.kernel.VariablePointer;
import org.uengine.processmanager.ProcessManagerRemote;

import java.rmi.RemoteException;

/**
 * Created by jjy on 2015. 12. 23..
 */
@Face(ejsPath="genericfaces/CleanObjectFace.ejs")
public class AlphaInstanceInEditor extends AlphaInstanceInList{

    @Override
    @Hidden
    public void edit(@Payload("instanceId") String instanceId, @Payload("variablePointer") VariablePointer variablePointer) throws Exception {
    //    super.edit(instanceId, variablePointer);
    }

    @Override
    @Hidden(on = false)
    public LanguageElementInstance getLanguageElementInstance() {
        return super.getLanguageElementInstance();
    }

    @Autowired
    public ProcessManagerRemote processManagerRemote;



    @ServiceMethod(callByContent = true, target=ServiceMethod.TARGET_POPUP)
    public void save() throws Exception {
        ProcessInstance instance = processManagerRemote.getProcessInstance(getInstanceId());

        if(getLanguageElementInstance() instanceof AlphaInstance){
            ((AlphaInstance) getLanguageElementInstance()).calculateState();
        }

        variablePointer.setValue(instance, getLanguageElementInstance());

        processManagerRemote.applyChanges();


        AlphaInstanceInList alphaInstanceInList = new AlphaInstanceInList();
        BeanUtils.copyProperties(this, alphaInstanceInList);

        MetaworksRemoteService.wrapReturn(new ToOpener(alphaInstanceInList), new Remover(new ModalWindow()));
    }

}
