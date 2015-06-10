package org.uengine.essencia.enactment;

public class AlphaCardBoard {

    public AlphaCardBoard() throws Exception {
        AlphaGameBoard alphaGameBoard = new AlphaGameBoard();
        setAlphaInstance(alphaGameBoard.getAlphaInstances().get(alphaGameBoard.getAlpha().getName()).get(0));
    }

    AlphaInstance alphaInstance;
        public AlphaInstance getAlphaInstance() {
            return alphaInstance;
        }
        public void setAlphaInstance(AlphaInstance alphaInstance) {
            this.alphaInstance = alphaInstance;
        }

}
