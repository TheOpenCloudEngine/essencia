package org.uengine.essencia.common;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * Created by manage on 3/5/2015.
 */
public interface Commitable {
    public void setRecord(CommitRecord record);

    public void commit() throws JAXBException, IOException, Exception;
}
