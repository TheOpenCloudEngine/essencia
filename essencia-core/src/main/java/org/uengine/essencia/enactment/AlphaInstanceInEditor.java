package org.uengine.essencia.enactment;

import org.metaworks.Refresh;
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
import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.BasicElement;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.kernel.ProcessInstance;
import org.uengine.kernel.VariablePointer;
import org.uengine.modeling.Relation;
import org.uengine.processmanager.ProcessManagerRemote;

import java.rmi.RemoteException;
import java.util.List;

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

        // finding parent alpha instances should be refreshed
        AlphaInstanceInList alphaInstanceListToRefresh = null;

        PracticeDefinition practiceDefinition = ((EssenceProcessDefinition)instance.getProcessDefinition()).getPracticeDefinition();
        BasicElement alphaOrWP = (BasicElement) practiceDefinition.getElementByName(getLanguageElementInstance().getLanguageElement().getName());
        if(alphaOrWP.getIncomingRelations()!=null){

            for(Relation relation : alphaOrWP.getIncomingRelations()){
                if(relation.getSourceElement() instanceof Alpha){
                    Alpha parentAlpha = (Alpha)relation.getSourceElement();

                    List<AlphaInstance> parentAlphaInstances = parentAlpha.getInstances(instance);
                    int i = -1;
                    for(AlphaInstance alphaInstance : parentAlphaInstances){
                        i++;

                        if(alphaInstance==null) continue;

                        alphaInstance.aggregateStateDetails(instance);

                        alphaInstanceListToRefresh = new AlphaInstanceInList(alphaInstance, instance, i);
                    }

                }
            }

        }



        AlphaInstanceInList alphaInstanceInList = new AlphaInstanceInList();
        BeanUtils.copyProperties(this, alphaInstanceInList);

        if(alphaInstanceListToRefresh!=null){
            MetaworksRemoteService.wrapReturn(new ToOpener(alphaInstanceInList), new Refresh(alphaInstanceListToRefresh), new Remover(new ModalWindow()));
        }else{
            MetaworksRemoteService.wrapReturn(new ToOpener(alphaInstanceInList), new Remover(new ModalWindow()));
        }
    }

    @Override
    @Hidden
    public void delete(@Payload("instanceId") String instanceId, @Payload("variablePointer") VariablePointer variablePointer) throws Exception {
    }
}
