package org.uengine.essencia.enactment.face;

import org.uengine.essencia.enactment.AlphaInstance;

/**
 * Created by jangjinyoung on 2016. 12. 31..
 */
public class AlphaInstanceIcon {

    public AlphaInstanceIcon(){}

    public AlphaInstanceIcon(AlphaInstance alphaInstance) {
        setName((String) alphaInstance.getValueMap().get("Id"));
        setConcern(alphaInstance.getAlpha().getConcern());
        setAlphaName(alphaInstance.getAlpha().getName());
    }

    String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }


    String concern;
        public String getConcern() {
            return concern;
        }
        public void setConcern(String concern) {
            this.concern = concern;
        }


    String alphaName;
        public String getAlphaName() {
            return alphaName;
        }
        public void setAlphaName(String alphaName) {
            this.alphaName = alphaName;
        }


}
