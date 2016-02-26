package org.uengine.web.jiraclient;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public interface JiraClientService {

    void install(Map payload) throws Exception;

    void uninstalled(Map payload) throws Exception;

    void enabled(Map payload) throws IOException;

    void disabled(Map payload) throws IOException;

    String validateAndGetClaim(HttpServletRequest request) throws Exception;

    String getClientKeyFromClaimJson(String claimJson) throws Exception;

    String getClientKeyFromRequest(HttpServletRequest request) throws Exception;

    String getClientKeyFromSession(HttpSession session) throws Exception;

    String getProductContext(HttpServletRequest request);

    String getProductBaseUrl(HttpServletRequest request);

    String getRequestUserKey(HttpServletRequest request);

    JiraClient selectByClientKey(String clientKey) throws Exception;

    JiraClient selectById(Long id) throws Exception;
}
