package org.uengine.jira.mw3;

import org.springframework.context.ApplicationContext;
import org.uengine.web.jiraclient.JiraClientService;
import org.uengine.web.util.ApplicationContextRegistry;

/**
 * Created by uengine on 2016. 2. 15..
 */
public class BeanServices {

    public static JiraClientService jiraClientService() {
        ApplicationContext context = ApplicationContextRegistry.getApplicationContext();
        JiraClientService jiraClientService = context.getBean(JiraClientService.class);
        return jiraClientService;
    }
}
