package org.uengine.essencia.model;

import org.metaworks.annotation.Available;

import java.io.Serializable;
import java.util.Calendar;

public class PropertyValue extends Property{

    public PropertyValue(){}


    private Serializable value;
        public Serializable getValue() {
            return value;
        }
        public void setValue(Serializable value) {
            this.value = value;
        }


    @Available(condition = "type=='java.lang.String'")
    public String getValueString() {
        return (String)value;
    }
    public void setValueString(String valueString) {
        this.value = valueString;
    }


    @Available(condition = "type=='java.lang.Long'")
    public long getValueLong() {
        return (Long)value;
    }
    public void setValueLong(long valueLong) {
        this.value = valueLong;
    }

    @Available(condition = "type=='java.util.Calendar'")
    public Calendar getValueDate() {
            return (Calendar)value;
        }
    public void setValueDate(Calendar valueDate) {
        this.value = valueDate;
    }


 }
