package org.uengine.jira.mw3;

import org.uengine.web.util.JsonUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by uengine on 2016. 2. 15..
 */
public class JiraMwService {

    public JiraSession jiraSession;

    public String getJiraSession() throws Exception{
        if (jiraSession == null) {
            return null;
        }

        Map map = new HashMap();
        map.put("claimJson", jiraSession.getClaimJson());
        map.put("clientKey", jiraSession.getClientKey());
        map.put("comCode", jiraSession.getComCode());
        return JsonUtils.marshal(map);
    }

    public void setJiraSession(String jiraSession) throws Exception{
        Map map = JsonUtils.unmarshal(jiraSession);
        JiraSession session = new JiraSession();
        session.setClaimJson(map.get("claimJson").toString());
        session.setClientKey(map.get("clientKey").toString());
        session.setComCode(map.get("comCode").toString());
        this.jiraSession = session;
    }

}
