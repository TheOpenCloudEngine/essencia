package org.uengine.opengraph;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by uengine on 2016. 2. 17..
 */
public class RemoteUserConvert {

    public RemoteUser remoteUser;

    public String getRemoteUser() throws Exception {
        if (remoteUser == null) {
            return null;
        }

        Map map = new HashMap();
        map.put("key", remoteUser.getKey());
        map.put("name", remoteUser.getName());
        map.put("sessionId", remoteUser.getSessionId());
        map.put("isMaster", remoteUser.getIsMaster());
        map.put("editable", remoteUser.isEditable());
        return RemoteUtils.marshal(map);
    }

    public void setRemoteUser(String remoteUser) throws Exception {
        if (StringUtils.isEmpty(remoteUser)) {
            this.remoteUser = null;
        } else {
            Map map = RemoteUtils.decodeJson(remoteUser);
            RemoteUser user = new RemoteUser();
            user.setKey(map.containsKey("key") ? map.get("key").toString() : null);
            user.setName(map.containsKey("name") ? map.get("name").toString() : null);
            user.setSessionId(map.containsKey("sessionId") ? map.get("sessionId").toString() : null);
            user.setIsMaster(map.containsKey("isMaster") ? (Boolean) map.get("isMaster") : false);
            user.setEditable(map.containsKey("editable") ? (Boolean) map.get("editable") : false);
            this.remoteUser = user;
        }
    }
}
