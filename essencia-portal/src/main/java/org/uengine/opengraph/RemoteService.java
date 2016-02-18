package org.uengine.opengraph;

import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContextFactory;
import org.metaworks.ContextAware;
import org.metaworks.MetaworksContext;
import org.metaworks.annotation.ServiceMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RemoteService extends RemoteUserConvert implements ContextAware {

    protected static Map<String, ArrayList<RemoteUser>> RemoteSessionMappping = new HashMap();

    public static void setRemoteSessionMappping(Map<String, ArrayList<RemoteUser>> remoteSessionMappping) {
        RemoteSessionMappping = remoteSessionMappping;
    }

    public static Map<String, ArrayList<RemoteUser>> getRemoteSessionMappping() {
        return RemoteSessionMappping;
    }

    public MetaworksContext metaworksContext;

    public MetaworksContext getMetaworksContext() {
        return metaworksContext;
    }

    public void setMetaworksContext(MetaworksContext metaworksContext) {
        this.metaworksContext = metaworksContext;
    }

    private String identifier;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    private String messege;

    public String getMessege() {
        return messege;
    }

    public void setMessege(String messege) {
        this.messege = messege;
    }

    private String currentSessionId;

    public String getCurrentSessionId() {
        return currentSessionId;
    }

    public void setCurrentSessionId(String currentSessionId) {
        this.currentSessionId = currentSessionId;
    }

    private String remoteUsers;

    public String getRemoteUsers() {
        return remoteUsers;
    }

    public void setRemoteUsers(String remoteUsers) {
        this.remoteUsers = remoteUsers;
    }

    private String canvasData;

    public String getCanvasData() {
        return canvasData;
    }

    public void setCanvasData(String canvasData) {
        this.canvasData = canvasData;
    }

    @ServiceMethod(callByContent = true)
    public void selfSession() {
        ScriptSession current = WebContextFactory.get().getScriptSession();
        this.setCurrentSessionId(current.getId());
    }

    @ServiceMethod(callByContent = true)
    public void updateUserState() throws Exception{
        RemoteUser targetUser = this.remoteUser;
        ArrayList<RemoteUser> remoteUsers = this.getRemoteUsersByIdentifier(this.getIdentifier());
        for (int i = 0; i < remoteUsers.size(); i++) {
            RemoteUser remoteUser = remoteUsers.get(i);
            if (targetUser.getSessionId().equals(remoteUser.getSessionId())) {
                remoteUsers.set(i, targetUser);
            }
        }
        this.notiRemoteUserToBrowser(this.getIdentifier(), remoteUsers);
    }

    @ServiceMethod(callByContent = true)
    public void registe() throws Exception {
        this.selfSession();
        remoteUser.setSessionId(this.getCurrentSessionId());

        RemoteUser master = this.getMasterOfIdentifier(this.getIdentifier());
        if (master == null) {
            remoteUser.setIsMaster(true);
            remoteUser.setEditable(true);
        } else if (master.getSessionId().equals(this.getCurrentSessionId())) {
            remoteUser.setIsMaster(true);
            remoteUser.setEditable(true);
        }
        this.addUserToIdentifier(remoteUser, this.getIdentifier());
        this.updateUserMetaField(this.getIdentifier());
    }

    @ServiceMethod(callByContent = true)
    public void broadCastCanvas() throws Exception {
        this.selfSession();
        Map canvasMap = RemoteUtils.decodeJson(this.getCanvasData());

        ArrayList<RemoteUser> remoteUsers = this.getRemoteUsersByIdentifier(this.getIdentifier());
        ArrayList<RemoteUser> withoutMeUsers = new ArrayList<RemoteUser>();

        for (RemoteUser remoteUser : remoteUsers) {
            if (remoteUser.getSessionId() != this.getCurrentSessionId()) {
                withoutMeUsers.add(remoteUser);
            }
        }
        Map messageMap = new HashMap();
        messageMap.put("identifier", this.getIdentifier());
        messageMap.put("canvasData", canvasMap);

        new RemoteBroadCast("OG.RemoteHandler.updateCanvas", RemoteUtils.marshal(messageMap), withoutMeUsers).run();
    }

    /**
     * 브라우저가 종료되지 않은 상태에서 사용자가 캔버스를 삭제하였을 때 처리
     */
    @ServiceMethod(callByContent = true)
    public void remoteUserExited() throws Exception {
        this.selfSession();
        ArrayList<RemoteUser> remoteUsers = this.getRemoteUsersByIdentifier(this.getIdentifier());
        ArrayList<RemoteUser> withoutMeUsers = new ArrayList<RemoteUser>();

        for (RemoteUser remoteUser : remoteUsers) {
            if (remoteUser.getSessionId() != this.getCurrentSessionId()) {
                withoutMeUsers.add(remoteUser);
            }
        }
        RemoteSessionMappping.put(this.getIdentifier(), withoutMeUsers);
        this.notiRemoteUserToBrowser(this.getIdentifier(), withoutMeUsers);
    }

    private void prepareRemoteSessionMap() {
        if (!RemoteSessionMappping.containsKey(this.getIdentifier())) {
            RemoteSessionMappping.put(this.getIdentifier(), new ArrayList<RemoteUser>());
        }
    }

    private ArrayList<RemoteUser> getRemoteUsersByIdentifier(String identifier) {
        this.prepareRemoteSessionMap();
        return RemoteSessionMappping.get(identifier);
    }

    /**
     * 주어진 리모트 그룹의 마스터 유저를 반환한다.
     *
     * @param identifier String 그룹 식별자
     * @return RemoteUser 그룹유저
     */
    private RemoteUser getMasterOfIdentifier(String identifier) {
        RemoteUser masterUser = null;
        ArrayList<RemoteUser> remoteUsers = this.getRemoteUsersByIdentifier(identifier);
        for (RemoteUser remoteUser : remoteUsers) {
            if (remoteUser.getIsMaster()) {
                masterUser = remoteUser;
            }
        }
        return masterUser;
    }

    /**
     * 주어진 리모트 그룹에 유저를 추가하고 결과를 브라우저에 전달한다.
     *
     * @param newUser    유저
     * @param identifier String 그룹 식별자
     */
    private void addUserToIdentifier(RemoteUser newUser, String identifier) throws Exception {
        ArrayList<RemoteUser> remoteUsers = this.getRemoteUsersByIdentifier(identifier);
        boolean userExist = false;
        for (int i = 0; i < remoteUsers.size(); i++) {
            RemoteUser remoteUser = remoteUsers.get(i);
            if (newUser.getSessionId().equals(remoteUser.getSessionId())) {
                userExist = true;
                remoteUsers.set(i, newUser);
            }
        }
        if (!userExist) {
            remoteUsers.add(newUser);
        }

        this.notiRemoteUserToBrowser(identifier, remoteUsers);
    }

    /**
     * 주어진 리모트 그룹의 유저상황을 브라우저에 알린다.
     *
     * @param identifier  String 그룹 식별자
     * @param remoteUsers ArrayList<RemoteUser> 전달할 유저목록
     */
    public static void notiRemoteUserToBrowser(String identifier, ArrayList<RemoteUser> remoteUsers) throws Exception {

        Map messageMap = new HashMap();
        messageMap.put("identifier", identifier);
        messageMap.put("remoteUsers", remoteUsers);

        new RemoteBroadCast("OG.RemoteHandler.updateRemoteUser", RemoteUtils.marshal(messageMap), remoteUsers).run();
    }

    /**
     * remoteUsers 필드 매핑
     *
     * @param identifier String 그룹 식별자
     */
    private void updateUserMetaField(String identifier) throws Exception {
        String marshal = RemoteUtils.marshal(this.getRemoteUsersByIdentifier(identifier));
        this.setRemoteUsers(marshal);
    }


}
