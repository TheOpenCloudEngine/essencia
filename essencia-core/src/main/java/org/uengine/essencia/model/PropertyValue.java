package org.uengine.essencia.model;

import org.metaworks.annotation.Available;
import org.uengine.essencia.Loader;

import java.io.Serializable;
import java.util.Calendar;

public class PropertyValue extends Property {

    public PropertyValue() {
    }


    private Serializable value;

    public Serializable getValue() {
        return value;
    }

    public void setValue(Serializable value) {
        this.value = value;
    }


    @Available(condition = "type=='java.lang.String'")
    public String getValueString() {
        if (value instanceof String)
            return (String) value;
        else
            return null;
    }

    public void setValueString(String valueString) {
        if (valueString != null)
            this.value = valueString;
    }


    @Available(condition = "type=='java.lang.Long'")
    public long getValueLong() {
        if (value instanceof Long)
            return (Long) value;
        else
            return 0;
    }

    public void setValueLong(long valueLong) {
        this.value = valueLong;
    }

    @Available(condition = "type=='java.util.Calendar'")
    public Calendar getValueDate() {
        if (value instanceof Calendar){
            return (Calendar) value;
       }else
            return null;
    }

    public void setValueDate(Calendar valueDate) {
        if(valueDate != null)
            this.value = valueDate;
    }


 }
