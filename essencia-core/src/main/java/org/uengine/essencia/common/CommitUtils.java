package org.uengine.essencia.common;

import org.metaworks.MetaworksContext;
import org.uengine.essencia.resource.RepositoryFolderResource;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by manage on 3/5/2015.
 */
public class CommitUtils {
    public static CommitRecord getRecentResourceRecord(String resourceName) {
        CommitHistory history = getHistory();

        if(history == null)
            return null;

        CommitRecord record = null;
        for(CommitRecord r : history.getRecords()){
            if(r.getResources().equals(resourceName))
                record = r;
        }

        return record;
    }

    public static CommitHistory getHistory() {
        CommitHistory history = null;
        try {
            history = SerializeUtils.deserialize(CommitHistory.class,
                    RepositoryFolderResource.getHistoryPath());
        } catch (JAXBException e) {
            System.out.println("History file is not exist.");
        }
        return history;
    }

    public static CommitHistory getHistoryByFilename(String filename) {
        CommitHistory history = null;
        List<CommitRecord> records = new ArrayList<CommitRecord>();
        MetaworksContext metaworksContext = new MetaworksContext();
        metaworksContext.setWhen(MetaworksContext.WHEN_VIEW);

        try {
            history = SerializeUtils.deserialize(CommitHistory.class,
                    RepositoryFolderResource.getHistoryPath());

            for(CommitRecord record: history.getRecords()){
                if(filename.equals(record.getResources())){
                    record.setMetaworksContext(metaworksContext);
                    records.add(record);
                }

            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        history.setRecords(records);

        return history;
    }

    public static List<CommitRecord> getRecordsByFilename(String filename) {
        CommitHistory history = null;
        List<CommitRecord> records = new ArrayList<CommitRecord>();
        MetaworksContext metaworksContext = new MetaworksContext();
        metaworksContext.setWhen(MetaworksContext.WHEN_VIEW);

        try {
            history = SerializeUtils.deserialize(CommitHistory.class,
                    RepositoryFolderResource.getHistoryPath());

            for(CommitRecord record: history.getRecords()){
                if(filename.equals(record.getResources())){
                    record.setMetaworksContext(metaworksContext);
                    records.add(record);
                }

            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return records;
    }

    public static void serializeRecord(CommitRecord record) throws JAXBException {
        CommitHistory history = getHistory();

        if (history == null) {
            history = new CommitHistory();
            history.setRecords(new ArrayList<CommitRecord>());
        }

        record.setDate(new Date());
        record.setRevision(history.getRecords().size()+1);
        history.getRecords().add(record);

        SerializeUtils.serialize(history, CommitHistory.class, RepositoryFolderResource.getHistoryPath());
    }
}
