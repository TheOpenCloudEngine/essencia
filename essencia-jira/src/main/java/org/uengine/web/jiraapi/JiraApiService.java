package org.uengine.web.jiraapi;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by uengine on 2016. 2. 22..
 */
public interface JiraApiService {
    Map getUser(HttpServletRequest request, String userKey) throws Exception;

    boolean isAdmin(HttpServletRequest request, String userKey) throws Exception;

    String createProject(HttpServletRequest request, String name, String key, String type, String lead) throws Exception;
}
