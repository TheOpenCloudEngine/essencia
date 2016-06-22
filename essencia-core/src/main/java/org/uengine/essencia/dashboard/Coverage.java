package org.uengine.essencia.dashboard;

/**
 * Created by jjy on 2016. 6. 19..
 */
public class Coverage {


    int red, green, blue;

        public int getRed() {
            return red;
        }

        public void setRed(int red) {
            this.red = red;
        }

        public int getGreen() {
            return green;
        }

        public void setGreen(int green) {
            this.green = green;
        }

        public int getBlue() {
            return blue;
        }

        public void setBlue(int blue) {
            this.blue = blue;
        }

    String name;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


    public void add(Coverage coverage) {

        setRed(getRed() + coverage.getRed());
        setGreen(getGreen() + coverage.getGreen());
        setBlue(getBlue() + coverage.getBlue());

        mergedCount ++;

    }

    int mergedCount = 0;
        public int getMergedCount() {
            return mergedCount;
        }

        public void setMergedCount(int mergedCount) {
            this.mergedCount = mergedCount;
        }

    public void merge() {
        if(mergedCount > 0){
            setRed(getRed() / mergedCount);
            setGreen(getGreen() / mergedCount);
            setBlue(getBlue() / mergedCount);

            setMergedCount(0);
        }
    }

    public Coverage copy(){
        Coverage coverage = new Coverage();
        coverage.setRed(getRed());
        coverage.setGreen(getGreen());
        coverage.setBlue(getBlue());

        return coverage;
    }

    //    int minStateIndex;
//        public int getMinStateIndex() {
//            return minStateIndex;
//        }
//
//        public void setMinStateIndex(int minStateIndex) {
//            this.minStateIndex = minStateIndex;
//        }
//
//    int maxStateIndex;
//        public int getMaxStateIndex() {
//            return maxStateIndex;
//        }
//
//        public void setMaxStateIndex(int maxStateIndex) {
//            this.maxStateIndex = maxStateIndex;
//        }

}
