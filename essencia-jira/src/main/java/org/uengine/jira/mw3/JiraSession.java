package org.uengine.jira.mw3;

/**
 * Created by uengine on 2016. 2. 15..
 */
public class JiraSession {

    private String claimJson;

    private String clientKey;

    private String comCode;

    public String getClaimJson() {
        return claimJson;
    }

    public void setClaimJson(String claimJson) {
        this.claimJson = claimJson;
    }

    public String getClientKey() {
        return clientKey;
    }

    public void setClientKey(String clientKey) {
        this.clientKey = clientKey;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    @Override
    public String toString() {
        return "JiraSession{" +
                "claimJson='" + claimJson + '\'' +
                ", clientKey='" + clientKey + '\'' +
                ", comCode='" + comCode + '\'' +
                '}';
    }
}
