package org.uengine.web.jiraissue;

import org.uengine.web.jiraproject.JiraProject;

import java.util.Map;

public interface JiraIssueService {

    JiraIssue selectById(Long id);

    int insert(JiraIssue jiraIssue);

    JiraIssue selectByInstanceAndTracing(Long instanceId, Long tracingTag);

    void updated(String clientKey, Map payload) throws Exception;

    JiraIssue selectByJiraIssueInformation(String clientKey, String projectId, String issueId) throws Exception;

    String getJiraIssueActivityStatus(JiraIssue jiraIssue) throws Exception;
}
