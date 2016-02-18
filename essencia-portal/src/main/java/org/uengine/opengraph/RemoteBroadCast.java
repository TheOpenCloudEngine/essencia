package org.uengine.opengraph;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ScriptSessionFilter;
import org.directwebremoting.ScriptSessions;

import java.util.ArrayList;

/**
 * Created by uengine on 2016. 2. 18..
 */
public class RemoteBroadCast {

    private final String broadCastscript;
    private final String broadCastmessage;
    private final ArrayList<RemoteUser> broadCastRemoteUsers;

    public RemoteBroadCast(String script, String messege, ArrayList<RemoteUser> remoteUsers) {
        broadCastscript = script;
        broadCastmessage = messege;
        broadCastRemoteUsers = remoteUsers;
    }

    public String getBroadCastscript() {
        return broadCastscript;
    }

    public String getBroadCastmessage() {
        return broadCastmessage;
    }

    public ArrayList<RemoteUser> getBroadCastRemoteUsers() {
        return broadCastRemoteUsers;
    }

    public void run() {
        try {
            Browser.withAllSessionsFiltered(new ScriptSessionFilter() {
                public boolean match(ScriptSession session) {
                    boolean enable = false;
                    for(RemoteUser remoteUser: broadCastRemoteUsers){
                        if(remoteUser.getSessionId().equals(session.getId())){
                            enable = true;
                        }
                    }
                    if(enable){
                        return true;
                    }else{
                        return false;
                    }
                }
            }, new Runnable() {
                public void run() {
                    ScriptSessions.addFunctionCall(broadCastscript, broadCastmessage);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
