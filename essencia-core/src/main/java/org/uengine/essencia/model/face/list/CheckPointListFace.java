package org.uengine.essencia.model.face.list;

import org.metaworks.Face;
import org.metaworks.widget.TextArea;
import org.uengine.essencia.model.CheckPoint;

import java.util.ArrayList;
import java.util.List;

public class CheckPointListFace extends TextArea implements Face<List<CheckPoint>> {

    @Override
    public void setValueToFace(List<CheckPoint> value) {

        setRows(10);

        if(value==null) return;

        StringBuffer totalString = new StringBuffer();

        for(CheckPoint checkPoint : value){
            totalString.append(checkPoint.getName() + "\n");
        }

        setText(totalString.toString());
    }

    @Override
    public List<CheckPoint> createValueFromFace() {

        List<CheckPoint> checkPoints = new ArrayList<CheckPoint>();

        String totalString = getText();

        if(totalString!=null) {
            String[] checkpointTexts = totalString.split("\n");

            for (int i = 0; i < checkpointTexts.length; i++) {

                if (checkpointTexts[i].trim().length() == 0) continue;

                CheckPoint checkPoint = new CheckPoint();
                checkPoint.setName(checkpointTexts[i].trim());

                checkPoints.add(checkPoint);
            }
        }

        return checkPoints;
    }
}
