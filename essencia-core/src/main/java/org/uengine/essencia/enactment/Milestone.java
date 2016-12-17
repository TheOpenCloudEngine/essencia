package org.uengine.essencia.enactment;

import java.util.Date;

/**
 * Created by jjy on 2016. 12. 17..
 */
public class Milestone {

    String title;
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }


    String description;
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }


    Date dueDate;
        public Date getDueDate() {
            return dueDate;
        }
        public void setDueDate(Date dueDate) {
            this.dueDate = dueDate;
        }

}
