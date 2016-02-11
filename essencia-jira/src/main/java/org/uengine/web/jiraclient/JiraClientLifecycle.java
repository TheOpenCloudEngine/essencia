package org.uengine.web.jiraclient;

import java.sql.Date;

/**
 * Created by uengine on 2016. 2. 1..
 */
public class JiraClientLifecycle {

    private Long id;

    private Long jiraClientId;

    private Date eventDate;

    private String eventType;

    private String payload;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJiraClientId() {
        return jiraClientId;
    }

    public void setJiraClientId(Long jiraClientId) {
        this.jiraClientId = jiraClientId;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "JiraClientLifecycle{" +
                "id=" + id +
                ", jiraClientId=" + jiraClientId +
                ", eventDate=" + eventDate +
                ", eventType='" + eventType + '\'' +
                ", payload='" + payload + '\'' +
                '}';
    }
}
