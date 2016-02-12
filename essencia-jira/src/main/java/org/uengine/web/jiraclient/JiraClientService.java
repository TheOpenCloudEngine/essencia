package org.uengine.web.jiraclient;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

public interface JiraClientService {

    void install(Map payload) throws IOException, Exception;

    void uninstalled(Map payload) throws IOException;

    void enabled(Map payload) throws IOException;

    void disabled(Map payload) throws IOException;

    String validateAndGetClaim(HttpServletRequest request) throws Exception;

}
