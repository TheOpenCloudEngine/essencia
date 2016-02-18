package org.uengine.opengraph;

import org.directwebremoting.Container;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.extend.ScriptSessionManager;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by uengine on 2016. 2. 18..
 */
@Component
public class RemoteSessionManager implements InitializingBean {

    public void afterPropertiesSet() throws Exception {
        Thread t = new Thread(new CleanExpiredRemoteSession());
        t.setDaemon(true);
        t.start();
    }

    private class CleanExpiredRemoteSession implements Runnable {
        public void run() {
            try {
                while (true) {
                    try {
                        Container container = ServerContextFactory.get().getContainer();
                        ScriptSessionManager manager = container.getBean(ScriptSessionManager.class);
                        Collection<ScriptSession> sessions = manager.getAllScriptSessions();
                        List<ScriptSession> sessionList;
                        List<String> sessionIdList = new ArrayList<String>();
                        if (sessions instanceof List)
                            sessionList = (List) sessions;
                        else
                            sessionList = new ArrayList(sessions);
                        for (int i = 0; i < sessionList.size(); i++) {
                            ScriptSession session = sessionList.get(i);
                            sessionIdList.add(session.getId());
                        }

                        Map<String, ArrayList<RemoteUser>> sessionMappping = RemoteService.getRemoteSessionMappping();
                        Set<String> identifierSet = sessionMappping.keySet();
                        Iterator<String> iterator = identifierSet.iterator();

                        while (iterator.hasNext()) {
                            boolean memberChanged = false;
                            String identifier = iterator.next();
                            ArrayList<RemoteUser> remoteUsers = sessionMappping.get(identifier);
                            ArrayList<RemoteUser> liveUsers = new ArrayList<RemoteUser>();
                            for (RemoteUser remoteUser : remoteUsers) {
                                if (sessionIdList.contains(remoteUser.getSessionId())) {
                                    liveUsers.add(remoteUser);
                                } else {
                                    memberChanged = true;
                                }
                            }
                            sessionMappping.put(identifier, liveUsers);
                            if (memberChanged) {
                                RemoteService.notiRemoteUserToBrowser(identifier, liveUsers);
                            }
                        }

                        RemoteService.setRemoteSessionMappping(sessionMappping);

                        Thread.sleep(1000);
                    } catch (Exception e) {

                    }
                }
            } finally {
                System.out.println("CleanExpiredRemoteSession Method Exit");
            }
        }
    }
}
