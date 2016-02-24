package org.uengine.web.jiraissue;

import org.uengine.web.jiraproject.JiraProject;
import org.uengine.web.repository.PersistentRepository;

public interface JiraIssueRepository extends PersistentRepository<JiraIssue, Long> {

    public static final String NAMESPACE = JiraIssueRepository.class.getName();

    JiraIssue selectById(Long id);

    JiraIssue selectByInstanceAndTracing(Long instanceId, Long tracingTag);

    JiraIssue selectByJiraIssueInformation(Long jiraClientId, String projectId, String issueId);
}
