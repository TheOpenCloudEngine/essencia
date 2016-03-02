package org.uengine.web.mail;

import org.apache.velocity.app.VelocityEngine;
import org.metaworks.dao.TransactionAdvice;
import org.oce.garuda.multitenancy.TenantContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.uengine.codi.mw3.model.Company;
import org.uengine.codi.mw3.model.Employee;
import org.uengine.codi.mw3.model.IProcessMap;
import org.uengine.codi.mw3.model.ProcessMap;
import org.uengine.kernel.GlobalContext;
import org.uengine.kernel.Role;
import org.uengine.modeling.resource.ResourceManager;
import org.uengine.modeling.resource.VersionManager;
import org.uengine.processmanager.ProcessManagerRemote;
import org.uengine.web.company.CompanyService;
import org.uengine.web.employee.EmployeeService;
import org.uengine.web.jiraapi.JiraApiService;
import org.uengine.web.jiraclient.JiraClient;
import org.uengine.web.jiraclient.JiraClientService;
import org.uengine.web.jiraproject.JiraProjectService;
import org.uengine.web.process.ProcessMapService;
import org.uengine.webservices.emailserver.impl.EMailServerSoapBindingImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    JiraClientService jiraClientService;

    @Autowired
    JiraApiService jiraApiService;

    @Autowired
    VelocityEngine velocityEngine;

    @Override
    public void sendMail(HttpServletRequest request, String email, String subject, String contents) throws Exception {
        String clientKey = jiraClientService.getClientKeyFromRequest(request);
        String requestUserKey = jiraClientService.getRequestUserKey(request);
        JiraClient jiraClient = jiraClientService.selectByClientKey(clientKey);

        String description = jiraClient.getDescription();
        String baseUrl = jiraClient.getBaseUrl();

        Map user = jiraApiService.getUser(request, requestUserKey);
        String displayName = (String) user.get("displayName");
        String emailAddress = (String) user.get("emailAddress");
        boolean admin = jiraApiService.isAdmin(request, requestUserKey);

        Map model = new HashMap();
        model.put("clientKey", clientKey);
        model.put("description", description);
        model.put("baseUrl", baseUrl);
        model.put("userKey", requestUserKey);
        model.put("displayName", displayName);
        model.put("emailAddress", emailAddress);
        model.put("admin", admin);
        model.put("contents", contents);

        String body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "jira/template/contact.vm", "UTF-8", model);

        String from = email;
        String to = GlobalContext.getPropertyString("essencia.support", "sppark@uengine.org");

        (new EMailServerSoapBindingImpl()).sendMail(from, to, subject, body);
    }
}
