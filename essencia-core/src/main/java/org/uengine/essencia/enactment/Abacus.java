package org.uengine.essencia.enactment;

import org.metaworks.ContextAware;
import org.metaworks.MetaworksContext;
import org.metaworks.annotation.Id;
import org.metaworks.annotation.Payload;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.dwr.MetaworksRemoteService;
import org.uengine.codi.mw3.model.Popup;
import org.uengine.kernel.ProcessInstance;

/**
 * Created by uengine on 2016. 12. 17..
 */
public class Abacus{

    GameBoard gameBoard;
        public GameBoard getGameBoard() {
            return gameBoard;
        }
        public void setGameBoard(GameBoard gameBoard) {
            this.gameBoard = gameBoard;
        }

    public Abacus(){

    }

    public Abacus(GameBoard gameBoard){
        setGameBoard(gameBoard);
        setInstanceId(gameBoard.getInstanceId());
    }

    String instanceId;
    @Id
        public String getInstanceId() {
            return instanceId;
        }
        public void setInstanceId(String instanceId) {
            this.instanceId = instanceId;
        }


    @ServiceMethod(eventBinding = "refresh", target = ServiceMethod.TARGET_SELF)
    public void refresh() throws Exception{

        GameBoard gameBoard = new GameBoard();
        MetaworksRemoteService.autowire(gameBoard);
        gameBoard.setInstanceId(getInstanceId());
        gameBoard.refresh();

        setGameBoard(gameBoard);
    }

    @ServiceMethod(target = ServiceMethod.TARGET_SELF)
    public void addMilestone(){

    }

    @ServiceMethod(target = ServiceMethod.TARGET_POPUP)
    public void editStateInstance(@Payload("instanceId") String instanceId, @Payload("stateInstanceEditor") StateInstanceEditor stateInstanceEditor) throws Exception {
        stateInstanceEditor.setInstanceId(instanceId);
        final Popup popup = new Popup(stateInstanceEditor.load());
        popup.setName("Due date : " + stateInstanceEditor.getTargetStateName());
        popup.setMetaworksContext(new MetaworksContext());
        popup.getMetaworksContext().setWhen(MetaworksContext.WHEN_EDIT);

        MetaworksRemoteService.wrapReturn(popup);
    }

    StateInstanceEditor stateInstanceEditor;
        public StateInstanceEditor getStateInstanceEditor() {
            return stateInstanceEditor;
        }
        public void setStateInstanceEditor(StateInstanceEditor stateInstanceEditor) {
            this.stateInstanceEditor = stateInstanceEditor;
        }




}
