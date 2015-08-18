package org.uengine.essencia.common;

/**
 * Created by manage on 3/5/2015.
 */
import org.metaworks.MetaworksContext;
import org.metaworks.annotation.Face;
import org.metaworks.dwr.MetaworksRemoteService;
import org.uengine.essencia.resource.RepositoryFolderResource;
import org.uengine.essencia.resource.Resource;
import org.uengine.modeling.resource.DefaultResource;
import org.uengine.modeling.resource.ResourceManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBException;
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

    public CommitRecord getRecentResourceRecord(String resourceName) {
        CommitRecord record = null;
        for(CommitRecord r : getRecords()){
            if(r.getResources().equals(resourceName))
                record = r;
        }

        return record;
    }

    public static CommitHistory load() {
        CommitHistory history = null;
        try {
            ResourceManager resourceManager = MetaworksRemoteService.getComponent(ResourceManager.class);
            history = (CommitHistory) resourceManager.getStorage().getObject(
                    DefaultResource.createResource(RepositoryFolderResource.getHistoryPath()));
        } catch (Exception e) {
            history = new CommitHistory();
            history.setRecords(new ArrayList<CommitRecord>());
        }
        return history;
    }

    public void addRecord(CommitRecord record) throws JAXBException {
        record.setDate(new Date());
        record.setRevision(getRecords().size()+1);
        getRecords().add(record);
    }

    public void save() throws Exception {
        Resource.saveToStorage(DefaultResource.createResource(RepositoryFolderResource.getHistoryPath()),this);
    }

    public void filterHistoryByFileName(String fileName){
        setRecords(getRecordsByFilename(fileName));
    }

    public List<CommitRecord> getRecordsByFilename(String fileName) {
        List<CommitRecord> recordsOfFile = new ArrayList<CommitRecord>();
        MetaworksContext metaworksContext = new MetaworksContext();
        metaworksContext.setWhen(MetaworksContext.WHEN_VIEW);

        for(CommitRecord record: getRecords()){
            if(fileName.equals(record.getResources())){
                record.setMetaworksContext(metaworksContext);
                recordsOfFile.add(record);
            }
        }
        return recordsOfFile;
    }
}
