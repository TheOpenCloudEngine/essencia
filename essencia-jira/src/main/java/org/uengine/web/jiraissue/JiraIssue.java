package org.uengine.web.jiraissue;

import java.sql.Date;

/**
 * Created by uengine on 2016. 2. 23..
 */
public class JiraIssue {
    private Long id;

    private Long instanceId;

    private Long tracingTag;

    private Long taskId;

    private Long jiraClientId;

    private String projectId;

    private String issueId;

    private Date regDt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(Long instanceId) {
        this.instanceId = instanceId;
    }

    public Long getTracingTag() {
        return tracingTag;
    }

    public void setTracingTag(Long tracingTag) {
        this.tracingTag = tracingTag;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getJiraClientId() {
        return jiraClientId;
    }

    public void setJiraClientId(Long jiraClientId) {
        this.jiraClientId = jiraClientId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public Date getRegDt() {
        return regDt;
    }

    public void setRegDt(Date regDt) {
        this.regDt = regDt;
    }

    @Override
    public String toString() {
        return "JiraIssue{" +
                "id=" + id +
                ", instanceId=" + instanceId +
                ", tracingTag=" + tracingTag +
                ", taskId=" + taskId +
                ", jiraClientId=" + jiraClientId +
                ", projectId='" + projectId + '\'' +
                ", issueId='" + issueId + '\'' +
                ", regDt=" + regDt +
                '}';
    }
}
