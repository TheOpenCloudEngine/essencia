package org.uengine.web.activity;

import org.metaworks.dao.TransactionAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.uengine.codi.mw3.model.Employee;
import org.uengine.kernel.*;
import org.uengine.web.employee.EmployeeService;
import org.uengine.web.exception.ServiceException;
import org.uengine.web.jiraapi.JiraApiService;
import org.uengine.web.jiraclient.JiraClient;
import org.uengine.web.jiraclient.JiraClientService;
import org.uengine.web.jiraissue.JiraIssue;
import org.uengine.web.jiraissue.JiraIssueService;
import org.uengine.web.jiraproject.JiraProject;
import org.uengine.web.jiraproject.JiraProjectService;
import org.uengine.web.util.ApplicationContextRegistry;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by jjy on 2016. 2. 2..
 */
public class JIRAIssueActivityFilter implements ActivityFilter {

    @Override
    public void beforeExecute(Activity activity, ProcessInstance instance) throws Exception {

    }

    @Override
    public void afterExecute(Activity activity, ProcessInstance instance) throws Exception {

        if (activity instanceof HumanActivity) {

            //필요 Bean 을 등록한다.
            ApplicationContext context = ApplicationContextRegistry.getApplicationContext();
            JiraProjectService projectService = (JiraProjectService) context.getBean(JiraProjectService.class);
            EmployeeService employeeService = (EmployeeService) context.getBean(EmployeeService.class);
            JiraApiService jiraApiService = (JiraApiService) context.getBean(JiraApiService.class);
            JiraClientService jiraClientService = (JiraClientService) context.getBean(JiraClientService.class);
            JiraIssueService jiraIssueService = (JiraIssueService) context.getBean(JiraIssueService.class);
            TransactionAdvice transactionAdvice = (TransactionAdvice) context.getBean(TransactionAdvice.class);

            //필요 정보를 모은다.
            String instanceId = instance.getInstanceId(); //인스턴스 아이디
            String tracingTag = activity.getTracingTag(); //트래이싱 태그
            String[] taskIds = ((HumanActivity) activity).getTaskIds(instance);
            String taskId = taskIds[0]; //타스크 아이디
            String activityName = activity.getName(); //이슈 제목
            Role role = ((HumanActivity) activity).getRole();
            String roleName = role.getName(); // 롤 이름

            //jira 프로젝트와 연동된 인스턴스가 아니면 리턴한다.
            JiraProject jiraProject = projectService.selectByInstanceId(Long.parseLong(instanceId));
            if (jiraProject == null) {
                return;
            }

            //동일한 인스턴스와 트래이싱 태그가 지라 이슈로 운영중이면 리턴한다.
            JiraIssue runningIssue = jiraIssueService.selectByInstanceAndTracing(
                    Long.parseLong(instanceId), Long.parseLong(tracingTag));
            if (runningIssue != null) {
                return;
            }

            //지라 클라이언트 키
            Long clientId = jiraProject.getJiraClientId();
            JiraClient jiraClient = jiraClientService.selectById(clientId);
            String jiraClientKey = jiraClient.getClientKey();


            //지라 프로젝트 아이디
            String projectId = jiraProject.getProjectId();


            //롤에 배정된 지라 유저키를 구한다.(이슈 배정자, 이슈 리포터)
            RoleMapping assignee = instance.getRoleMapping(roleName);
            if (assignee == null) {
                throw new ServiceException("No assignee user for " +
                        roleName + " , instanceId : " + instanceId);
            }
            String assigneeEndpoint = assignee.getEndpoint();
            Employee assigneeEmployee = employeeService.findByEmpCode(assigneeEndpoint);
            String assigneeKey = assigneeEmployee.getEmpName(); //assignee userKey

            String reporterKey = jiraProject.getInitiator(); //reporter userKey


            //jira 프로젝트의 디폴트 이슈타입아이디를 가져온다.
            String defaultIssueTypeId = jiraApiService.
                    getDefaultIssueTypeIdOfProject(jiraClientKey, projectId);

            //jira 이슈를 생성한다.
            String summary = "(" + roleName + ") " + activityName;
            String issueId = jiraApiService.createIssue(jiraClientKey, projectId,
                    summary, defaultIssueTypeId, assigneeKey, reporterKey);

            //생성된 지라 이슈와 액티비티를 매핑하여 저장한다.
            JiraIssue jiraIssue = new JiraIssue();
            jiraIssue.setInstanceId(Long.parseLong(instanceId));
            jiraIssue.setTracingTag(Long.parseLong(tracingTag));
            jiraIssue.setTaskId(Long.parseLong(taskId));
            jiraIssue.setJiraClientId(jiraClient.getId());
            jiraIssue.setProjectId(projectId);
            jiraIssue.setIssueId(issueId);
            jiraIssueService.insert(jiraIssue);

            //프로세스 후처리를 위한 트랜잭션 유지
            transactionAdvice.initiateTransaction();
        }
    }

    @Override
    public void afterComplete(Activity activity, ProcessInstance instance) throws Exception {

    }

    @Override
    public void onPropertyChange(Activity activity, ProcessInstance instance, String propertyName, Object changedValue) throws Exception {

    }

    @Override
    public void onDeploy(ProcessDefinition definition) throws Exception {

    }
}
