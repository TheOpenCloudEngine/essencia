package org.uengine.essencia.common;

/**
 * Created by manage on 3/5/2015.
 */
import org.metaworks.annotation.Face;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="history")
@Face(ejsPath = "dwr/metaworks/genericfaces/History.ejs")
public class CommitHistory {

    private List<CommitRecord> records;

    @XmlElement(name="record")
    public List<CommitRecord> getRecords() {
        return records;
    }

    public void setRecords(List<CommitRecord> records) {
        this.records = records;
    }
}
