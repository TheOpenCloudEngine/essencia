package org.uengine.essencia.dashboard;

import java.util.Map;

/**
 * Created by jjy on 2016. 6. 19..
 */
public class CoverageTable {


    Map<String, Map<Integer, Coverage>> coverages;
        public Map<String, Map<Integer, Coverage>> getCoverages() {
            return coverages;
        }
        public void setCoverages(Map<String, Map<Integer, Coverage>> coverages) {
            this.coverages = coverages;
        }



}
