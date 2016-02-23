package org.uengine.web.process;

import org.uengine.codi.mw3.model.IProcessMap;
import org.uengine.codi.mw3.model.ProcessMap;
import org.uengine.kernel.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface ProcessMapService {
    List<ProcessMap> listPublicAndOwnProcessMap(String comCode) throws Exception;

    List<ProcessMap> listProcessMapByComCode(String comCode) throws Exception;

    List<ProcessMap> listPublicProcessMap() throws Exception;

    ProcessMap getProcessMapByMapId(String mapId) throws Exception;

    List<Role> getRoles(String defId, String comCode) throws Exception;

    void createProcess(HttpServletRequest request, String projectName, String projectKey,
                       String projectType, String mapId, List<Map> roleMapping) throws Exception;
}
