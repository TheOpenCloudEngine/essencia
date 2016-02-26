package org.uengine.web.jiraissue;

import org.metaworks.dao.TransactionAdvice;
import org.oce.garuda.multitenancy.TenantContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uengine.codi.mw3.model.Company;
import org.uengine.kernel.Activity;
import org.uengine.kernel.ProcessInstance;
import org.uengine.processmanager.ProcessManagerRemote;
import org.uengine.web.company.CompanyService;
import org.uengine.web.jiraclient.JiraClient;
import org.uengine.web.jiraclient.JiraClientService;
import org.uengine.web.jiraproject.JiraProject;
import org.uengine.web.jiraproject.JiraProjectRepository;
import org.uengine.web.jiraproject.JiraProjectService;

import java.util.List;
import java.util.Map;

@Service
public class JiraIssueServiceImpl implements JiraIssueService {

    @Autowired
    private JiraIssueRepository issueRepository;

    @Autowired
    private JiraClientService jiraClientService;

    @Autowired
    private ProcessManagerRemote processManager;

    @Autowired
    private CompanyService companyService;

    @Autowired
    TransactionAdvice transactionAdvice;

    @Override
    public JiraIssue selectById(Long id) {
        return issueRepository.selectById(id);
    }

    @Override
    public int insert(JiraIssue jiraIssue) {
        return issueRepository.insert(jiraIssue);
    }

    @Override
    public JiraIssue selectByInstanceAndTracing(Long instanceId, Long tracingTag) {
        return issueRepository.selectByInstanceAndTracing(instanceId, tracingTag);
    }

    @Override
    public JiraIssue selectByJiraIssueInformation(String clientKey, String projectId, String issueId) throws Exception {
        JiraClient jiraClient = jiraClientService.selectByClientKey(clientKey);
        Long jiraClientId = jiraClient.getId();
        return issueRepository.selectByJiraIssueInformation(jiraClientId, projectId, issueId);
    }

    @Override
    public void updated(String clientKey, Map payload) throws Exception {
        //필요정보를 분석한다.
        Map issue = (Map) payload.get("issue");
        String issueId = (String) issue.get("id"); //이슈아이디

        Map fields = (Map) issue.get("fields");
        Map project = (Map) fields.get("project");
        String projectId = (String) project.get("id"); //프로젝트 아이디

        Map changelog = (Map) payload.get("changelog");
        List<Map> items = (List) changelog.get("items"); //체인지 로그


        //이슈이벤트가 완료처리(Done) 으로 인해 발생한 것이 아니면 리턴한다.
        Map statusMap = null;
        for (Map item : items) {
            String field = (String) item.get("field");
            String fieldtype = (String) item.get("fieldtype");
            if (field.equals("status") && fieldtype.equals("jira")) {
                statusMap = item;
            }
        }
        if (statusMap == null) {
            return;
        }
        String changeValue = (String) statusMap.get("toString");
        if (!changeValue.equals("Done")) {
            return;
        }

        //클라이언트와 이슈아이디가 일치하는 에센시아 이슈가 있는지 살펴본다.
        JiraIssue jiraIssue = this.selectByJiraIssueInformation(clientKey, projectId, issueId);
        if (jiraIssue == null) {
            return;
        }

        //에센시아 이슈의 액티비티의 해당 단계를 완료시킨다.
        Company company = companyService.selectByAlias(clientKey);
        String comCode = company.getComCode();
        this.completeActivity(comCode, Long.toString(jiraIssue.getInstanceId()), Long.toString(jiraIssue.getTracingTag()));

    }

    private void completeActivity(String comCode, String instanceId, String tracingTag) throws Exception {
        try {
            transactionAdvice.initiateTransaction();

            new TenantContext(comCode);
            ProcessInstance instance = processManager.getProcessInstance(instanceId);
            Activity activity = instance.getProcessDefinition().getActivity(tracingTag);

            //다음단계의 액티비티를 실행시켜야 함.
            activity.fireComplete(instance);
            processManager.applyChanges();

            transactionAdvice.commitTransaction();
        } catch (Exception ex) {
            transactionAdvice.rollbackTransaction();
            throw new Exception(ex);
        }
    }
}
