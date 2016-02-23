package org.uengine.web.jiraapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Service
public class JiraApiServiceImpl implements JiraApiService {

    @Autowired
    private JiraServiceFactory serviceFactory;

    @Override
    public Map getUser(HttpServletRequest request, String userKey) throws Exception {
        JiraApi jiraApi = serviceFactory.create(request);
        return jiraApi.getUser(userKey);
    }

    @Override
    public boolean isAdmin(HttpServletRequest request, String userKey) throws Exception {
        JiraApi jiraApi = serviceFactory.create(request);
        return jiraApi.isAdmin(userKey);
    }

    @Override
    public String createProject(HttpServletRequest request, String name, String key, String type, String lead) throws Exception {
        JiraApi jiraApi = serviceFactory.create(request);
        return jiraApi.createProject(name, key, type, lead);
    }
}
