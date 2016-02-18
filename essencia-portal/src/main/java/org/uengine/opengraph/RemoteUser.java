package org.uengine.opengraph;

/**
 * Created by uengine on 2016. 2. 17..
 */
public class RemoteUser {
    private String key;

    private String name;

    private String sessionId;

    private boolean isMaster;

    private boolean editable;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public boolean getIsMaster() {
        return isMaster;
    }

    public void setIsMaster(boolean isMaster) {
        this.isMaster = isMaster;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    @Override
    public String toString() {
        return "RemoteUser{" +
                "key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", isMaster=" + isMaster +
                ", editable=" + editable +
                '}';
    }
}
