package org.uengine.essencia.enactment;

import org.metaworks.ContextAware;
import org.metaworks.MetaworksContext;
import org.metaworks.annotation.ServiceMethod;

import java.util.List;

/**
 * Created by jangjinyoung on 15. 12. 20..
 */
public class CheckPointInstanceGroup{

    String title;
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }

    boolean completionCriteria;
        public boolean isCompletionCriteria() {
            return completionCriteria;
        }

        public void setCompletionCriteria(boolean completionCriteria) {
            this.completionCriteria = completionCriteria;
        }

    List<CheckPointInstance> checkPointInstanceList;
    public List<CheckPointInstance> getCheckPointInstanceList() {
        return checkPointInstanceList;
    }
    public void setCheckPointInstanceList(List<CheckPointInstance> checkPointInstanceList) {
        this.checkPointInstanceList = checkPointInstanceList;
    }

    public CheckPointInstanceGroup() {
    }

    @ServiceMethod(target = ServiceMethod.TARGET_SELF, callByContent = true)
    public void checkAll(){

        setCheckedAll(!isCheckedAll());

        if(checkPointInstanceList!=null)
        for(CheckPointInstance checkPointInstance : checkPointInstanceList){
            checkPointInstance.setChecked(checkedAll);
        }
    }

    boolean checkedAll;
        public boolean isCheckedAll() {
            return checkedAll;
        }
        public void setCheckedAll(boolean checkedAll) {
            this.checkedAll = checkedAll;
        }

}
