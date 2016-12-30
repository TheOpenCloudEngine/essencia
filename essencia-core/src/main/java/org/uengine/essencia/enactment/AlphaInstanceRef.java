package org.uengine.essencia.enactment;

import java.util.List;

/**
 * Created by uengine on 2016. 12. 26..
 */
public class AlphaInstanceRef {

    String alphaName;
        public String getAlphaName() {
            return alphaName;
        }
        public void setAlphaName(String alphaName) {
            this.alphaName = alphaName;
        }

    boolean all;
        public boolean isAll() {
            return all;
        }
        public void setAll(boolean all) {
            this.all = all;
        }

    List<String> ids;
        public List<String> getIds() {
            return ids;
        }
        public void setIds(List<String> ids) {
            this.ids = ids;
        }

}
