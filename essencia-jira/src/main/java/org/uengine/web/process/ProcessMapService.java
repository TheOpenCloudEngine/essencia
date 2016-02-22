package org.uengine.web.process;

import org.uengine.codi.mw3.model.IProcessMap;
import org.uengine.codi.mw3.model.ProcessMap;
import org.uengine.kernel.Role;

import java.util.List;

public interface ProcessMapService {
    List<ProcessMap> listPublicAndOwnProcessMap(String comCode) throws Exception;

    List<ProcessMap> listProcessMapByComCode(String comCode) throws Exception;

    List<ProcessMap> listPublicProcessMap() throws Exception;

    ProcessMap getProcessMapByMapId(String mapId) throws Exception;

    List<Role> getRoles(String defId, String comCode) throws Exception;
}
