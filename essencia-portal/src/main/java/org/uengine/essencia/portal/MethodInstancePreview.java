package org.uengine.essencia.portal;

import org.metaworks.dwr.MetaworksRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.uengine.codi.mw3.model.Instance;
import org.uengine.codi.mw3.model.InstancePreview;
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

    @Override
    public void load(Instance instance) throws Exception {

        ProcessInstance processInstance = processManagerRemote.getProcessInstance(instance.getInstId().toString());

        setGameBoard(new GameBoard());

        MetaworksRemoteService.autowire(getGameBoard());

        getGameBoard().load(processInstance, false);
        getGameBoard().getMetaworksContext().setWhere(null); //small version

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
