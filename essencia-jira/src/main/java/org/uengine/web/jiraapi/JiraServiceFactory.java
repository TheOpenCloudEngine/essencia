package org.uengine.web.jiraapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.uengine.web.exception.ServiceException;
import org.uengine.web.jiraclient.JiraClient;
import org.uengine.web.jiraclient.JiraClientRepository;
import org.uengine.web.jiraclient.JiraClientService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by uengine on 2016. 2. 22..
 */

@Component
public class JiraServiceFactory {

    @Autowired
    JiraClientService jiraClientService;

    @Autowired
    private JiraClientRepository clientRepository;

    public JiraApi create(HttpServletRequest request) throws Exception {

        String productContext = jiraClientService.getProductContext(request);
        String productBaseUrl = jiraClientService.getProductBaseUrl(request);
        String requestUserKey = jiraClientService.getRequestUserKey(request);

        String clientKey = jiraClientService.getClientKeyFromRequest(request);
        JiraClient jiraClient = clientRepository.selectByClientKey(clientKey);
        if (jiraClient == null) {
            throw new ServiceException("Can not find JiraClient");
        }

        return new JiraApi(productContext, productBaseUrl, requestUserKey,
                jiraClient.getAddonKey(), jiraClient.getSharedSecret());
    }
}
