package org.uengine.essencia.enactment;

import org.metaworks.*;
import org.metaworks.annotation.*;
import org.metaworks.annotation.Face;
import org.metaworks.dwr.MetaworksRemoteService;
import org.metaworks.widget.ModalWindow;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.uengine.codi.mw3.filter.OtherSessionFilter;
import org.uengine.codi.mw3.model.Session;
import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.BasicElement;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.kernel.ProcessInstance;
import org.uengine.kernel.VariablePointer;
import org.uengine.modeling.Relation;
import org.uengine.processmanager.ProcessManagerRemote;
import org.uengine.uml.model.Attribute;
import org.uengine.uml.model.ClassDefinition;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jjy on 2015. 12. 23..
 */
@Face(ejsPath="genericfaces/CleanObjectFace.ejs")
public class AlphaInstanceInEditor extends AlphaInstanceInList{

    @Override
    @Hidden
    @Available(when="NONE")
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


    @AutowiredFromClient
    public Session session;

    @ServiceMethod(
            payload = {
                    "instanceId",
                    "variablePointer",
                    "languageElementInstance.className",
                    "languageElementInstance.currentStateName",
                    "languageElementInstance._face_",
                    "languageElementInstance.valueMap"
                },
        target=ServiceMethod.TARGET_POPUP
    )
    public void save() throws Exception {
        ProcessInstance instance = processManagerRemote.getProcessInstance(getInstanceId());

        if(getLanguageElementInstance() instanceof AlphaInstance){
            AlphaInstance alphaInstance = ((AlphaInstance) getLanguageElementInstance());
            alphaInstance.fillStates();
            alphaInstance.calculateState();
        }

        variablePointer.setValue(instance, getLanguageElementInstance());

        processManagerRemote.applyChanges();

        // finding parent alpha instances should be refreshed
        AlphaInstanceInList alphaInstanceListToRefresh = null;

        PracticeDefinition practiceDefinition = ((EssenceProcessDefinition)instance.getProcessDefinition()).getPracticeDefinition();
        BasicElement alphaOrWP = (BasicElement) practiceDefinition.getElementByName(getLanguageElementInstance().getLanguageElement().getName());

        if(alphaOrWP.getIncomingRelations()!=null){

            for(Relation relation : alphaOrWP.getIncomingRelations()){
                if(relation.getSourceElement() instanceof Alpha){ //if the element has kernel, this mean if there's one or more kernel elements, the root can't be aggregated.
                    Alpha parentAlpha = (Alpha)relation.getSourceElement();

                    List<AlphaInstance> parentAlphaInstances = parentAlpha.getInstances(instance);
                    int i = -1;

                    if(parentAlphaInstances==null){  //parent alpha should be a kernel alpha, and it never have a instance value or just have single instance.
                        AlphaInstance parentAlphaObjectInstance = (AlphaInstance) parentAlpha.createObjectInstance();

                        parentAlphaObjectInstance.aggregateStateDetails(instance);

                        alphaInstanceListToRefresh = new AlphaInstanceInList(parentAlphaObjectInstance, instance, 0);
                    }else {

                        Map<String, Integer> rowSpanMap = new HashMap<String, Integer>();
                        AlphaInstance prevInstance = null;

                        for(AlphaInstance alphaInstance : parentAlphaInstances){

                            i++;

                            if(alphaInstance==null) continue;

                            alphaInstance.aggregateStateDetails(instance);

                            alphaInstanceListToRefresh = new AlphaInstanceInList(alphaInstance, instance, i);

                            ClassDefinition type = alphaInstance.getAlpha();

                        }
                    }

                }
            }

        }

        getLanguageElementInstance().setId((String) getLanguageElementInstance().getAttribute("Id"));

        AlphaInstanceInList alphaInstanceInList = new AlphaInstanceInList();
        BeanUtils.copyProperties(this, alphaInstanceInList);
        alphaInstanceInList.setMetaworksContext(new MetaworksContext());
        alphaInstanceInList.getMetaworksContext().setWhen(MetaworksContext.WHEN_EDIT);
        alphaInstanceInList.getMetaworksContext().setHow("agile");

        if(false) { //if agile mode
            MetaworksRemoteService.wrapReturn(new ToEvent(new GameBoard(), "refresh"), new Remover(new ModalWindow()));

            return;
        }

        if(alphaInstanceListToRefresh!=null){
            MetaworksRemoteService.wrapReturn(new ToOpener(alphaInstanceInList), new Refresh(alphaInstanceListToRefresh), new Remover(new ModalWindow()), new ToEvent(new Abacus(), "refresh"));

//            HashMap<String, String> pushUserMap = new HashMap<String, String>();
//            pushUserMap.put("3","3");
//
//            MetaworksRemoteService.pushClientObjectsFiltered(
//                    new OtherSessionFilter(pushUserMap, session.getUser().getUserId().toUpperCase()),
//                    new Object[]{new Refresh(alphaInstanceInList), new Refresh(alphaInstanceListToRefresh)});

        }else{
            MetaworksRemoteService.wrapReturn(new ToOpener(alphaInstanceInList), new Remover(new ModalWindow()));

//            HashMap<String, String> pushUserMap = new HashMap<String, String>();
//            pushUserMap.put("4","4");
//
//            MetaworksRemoteService.pushClientObjectsFiltered(
//                    new OtherSessionFilter(pushUserMap, session.getUser().getUserId().toUpperCase()),
//                    new Object[]{new Refresh(alphaInstanceInList)});
        }
    }

    @Override
    @Hidden
    @Available(when="NONE")
    public void delete(@Payload("instanceId") String instanceId, @Payload("variablePointer") VariablePointer variablePointer) throws Exception {
    }


}
