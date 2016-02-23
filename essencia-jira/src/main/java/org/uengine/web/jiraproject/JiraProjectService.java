package org.uengine.web.jiraproject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public interface JiraProjectService {

    void mappingWithInstanceId(Long instanceId, String clientKey, String jiraProjectId) throws Exception;
}
