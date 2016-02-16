package org.uengine.web.process;

import org.uengine.codi.mw3.model.IProcessMap;

import java.util.List;

public interface ProcessMapService {
    List<ProcessMap> listProcessMap() throws Exception;

    List<ProcessMap> listProcessMapByComCode(String comCode) throws Exception;

    List<ProcessMap> listPublicProcessMap() throws Exception;

    ProcessMap getProcessMapByMapId(String mapId) throws Exception;
}
