package org.uengine.web.process;

import java.util.List;

public interface ProcessMapService {
    List<ProcessMap> getListProcessMap() throws Exception;

    ProcessMap getProcessMapByMapId(String mapId) throws Exception;
}
