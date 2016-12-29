package org.uengine.essencia.enactment.handler;

import org.uengine.codi.mw3.model.ParameterValue;
import org.uengine.essencia.enactment.AlphaGameBoard;
import org.uengine.essencia.enactment.AlphaInstance;
import org.uengine.essencia.enactment.AlphaInstanceInList;
import org.uengine.essencia.enactment.GameBoard;
import org.uengine.essencia.model.Alpha;
import org.uengine.kernel.ProcessInstance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jangjinyoung on 2016. 12. 29..
 */
public class AlphaInstanceParameterValue extends ParameterValue {

    public AlphaInstanceParameterValue(){}

    public AlphaInstanceParameterValue(ProcessInstance instance, Alpha alpha) {

        List<AlphaInstanceInList> alphaInstanceInListList = alpha.getInstanceInLists(instance);
        try {
            Map<String, List<AlphaInstanceInList>> map = new HashMap<String, List<AlphaInstanceInList>>();
            map.put(alpha.getName(), alphaInstanceInListList);

            setAlphaGameBoard(new AlphaGameBoard(instance.getInstanceId(), alpha, map));
        } catch (Exception e) {
            e.printStackTrace();
        }

        setValue(null);
        setProcessVariableValueList(null);

        setIgnore(true);

        //setAlphaGameBoard(new AlphaGameBoard(instanceId, alpha));
    }

    AlphaGameBoard alphaGameBoard;
        public AlphaGameBoard getAlphaGameBoard() {
            return alphaGameBoard;
        }
        public void setAlphaGameBoard(AlphaGameBoard alphaGameBoard) {
            this.alphaGameBoard = alphaGameBoard;
        }

}
