package org.uengine.essencia.portal;

import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.Id;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.dwr.MetaworksRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.uengine.codi.mw3.model.Instance;
import org.uengine.codi.mw3.model.InstancePreview;
import org.uengine.codi.mw3.model.Session;
import org.uengine.essencia.enactment.GameBoard;
import org.uengine.kernel.ProcessInstance;
import org.uengine.processmanager.ProcessManagerRemote;

import java.rmi.RemoteException;

/**
 * Created by jangjinyoung on 2016. 6. 12..
 */
@Component
@Scope("prototype")
public class MethodInstancePreview extends InstancePreview{

    public MethodInstancePreview(){}

    @Override
    public void load(Instance instance) throws Exception {

        if(!instance.getDefVerId().endsWith(".method")) return;

        ProcessInstance processInstance = processManagerRemote.getProcessInstance(instance.getInstId().toString());

        setGameBoard(new GameBoard());

        MetaworksRemoteService.autowire(getGameBoard());

        try {
            getGameBoard().load(processInstance, false);
            getGameBoard().getMetaworksContext().setWhere(null); //small version
        }catch (Exception e){}

        setInstId(instance.getInstId());

    }

    @Id
    public Long getInstId() {
        return instId;
    }

    public void setInstId(Long instId) {
        this.instId = instId;
    }

    Long instId;

    @ServiceMethod(mouseBinding = "drag")
    public void drag(@AutowiredFromClient Session session){

        Instance instance = new Instance();
        instance.setInstId(getInstId());

        session.setClipboard(instance);

        MetaworksRemoteService.wrapReturn(session);
    }

    @Autowired
    public ProcessManagerRemote processManagerRemote;

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    GameBoard gameBoard;
}
