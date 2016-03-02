package org.uengine.web.jiraapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class JiraApiServiceImpl implements JiraApiService {

    @Autowired
    private JiraServiceFactory serviceFactory;

    @Override
    public Map getUser(HttpServletRequest request, String userKey) throws Exception {
        JiraApi jiraApi = serviceFactory.create(request);
        return jiraApi.getUser(userKey);
    }

    @Override
    public boolean isAdmin(HttpServletRequest request, String userKey) throws Exception {
        JiraApi jiraApi = serviceFactory.create(request);
        return jiraApi.isAdmin(userKey);
    }

    @Override
    public String createProject(HttpServletRequest request, String name, String key, String type, String lead) throws Exception {
        JiraApi jiraApi = serviceFactory.create(request);
        return jiraApi.createProject(name, key, type, lead);
    }

    @Override
    public String createProject(String clientKey, String name, String key, String type, String lead) throws Exception {
        JiraApi jiraApi = serviceFactory.create(clientKey);
        return jiraApi.createProject(name, key, type, lead);
    }

    @Override
    public String createIssue(String clientKey, String projectId, String summary, String issueType, String assignee, String reporter) throws Exception {
        JiraApi jiraApi = serviceFactory.create(clientKey);
        return jiraApi.createIssue(projectId, summary, issueType, assignee, reporter);
    }

    @Override
    public String addComment(String clientKey, String issueId, String message) throws Exception {
        JiraApi jiraApi = serviceFactory.create(clientKey);
        return jiraApi.addComment(issueId, message);
    }

    @Override
    public String getDefaultIssueTypeIdOfProject(String clientKey, String projectId) throws Exception {
        JiraApi jiraApi = serviceFactory.create(clientKey);
        Map project = jiraApi.getProject(projectId);
        List<Map> issueTypes = (List) project.get("issueTypes");
        List<Map> excludeSubTaskTypes = new ArrayList<>();

        for (Map issueType : issueTypes) {
            Boolean subtask = (Boolean) issueType.get("subtask");
            if (!subtask) {
                excludeSubTaskTypes.add(issueType);
            }
        }

        if (excludeSubTaskTypes.size() > 0) {
            return excludeSubTaskTypes.get(0).get("id").toString();
        } else {
            return null;
        }
    }

    @Override
    public String getIssueStatus(String clientKey, String issueId) throws Exception {
        JiraApi jiraApi = serviceFactory.create(clientKey);
        return jiraApi.getIssueStatus(issueId);
    }
}
