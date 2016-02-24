package org.uengine.web.jiraproject;

import java.sql.Date;

/**
 * Created by uengine on 2016. 2. 23..
 */
public class JiraProject {

    private Long id;

    private Long instanceId;

    private Long jiraClientId;

    private String projectId;

    private String initiator;

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

    public String getInitiator() {
        return initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    public Date getRegDt() {
        return regDt;
    }

    public void setRegDt(Date regDt) {
        this.regDt = regDt;
    }

    @Override
    public String toString() {
        return "JiraProject{" +
                "id=" + id +
                ", instanceId=" + instanceId +
                ", jiraClientId=" + jiraClientId +
                ", projectId='" + projectId + '\'' +
                ", initiator='" + initiator + '\'' +
                ", regDt=" + regDt +
                '}';
    }
}
