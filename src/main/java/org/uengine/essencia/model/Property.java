package org.uengine.essencia.model;

import org.metaworks.annotation.Range;

import java.io.Serializable;

public class Property implements Serializable{

    public Property(){}


    String key;
        public String getKey() {
            return key;
        }
        public void setKey(String key) {
            this.key = key;
        }


    String type;
    @Range(options={"Text", "Number", "Date"}, values={"java.lang.String", "java.lang.Long", "java.util.Calendar"})
        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
}
