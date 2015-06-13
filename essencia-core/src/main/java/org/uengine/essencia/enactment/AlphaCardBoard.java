package org.uengine.essencia.enactment;

import org.metaworks.annotation.ServiceMethod;

public class AlphaCardBoard {

    public AlphaCardBoard() throws Exception {
        AlphaGameBoard alphaGameBoard = new AlphaGameBoard();
        setAlphaInstance((AlphaInstance) alphaGameBoard.getAlphaInstances().get(alphaGameBoard.getAlpha().getName()).get(0));
    }

    AlphaInstance alphaInstance;
        public AlphaInstance getAlphaInstance() {
            return alphaInstance;
        }
        public void setAlphaInstance(AlphaInstance alphaInstance) {
            this.alphaInstance = alphaInstance;
        }

    @ServiceMethod
    public void save(){
        alphaInstance.isCurrentStateCompletable();
    }

}
