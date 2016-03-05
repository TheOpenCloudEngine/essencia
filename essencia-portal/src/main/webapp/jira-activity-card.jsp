<%@ page import="java.util.Map" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="org.uengine.web.jiraissue.JiraIssueService" %>
<%@ page import="org.uengine.web.jiraissue.JiraIssue" %>
<%@ page import="org.uengine.web.employee.EmployeeService" %>
<%@ page import="org.uengine.codi.mw3.model.Employee" %>
<%@ page import="org.uengine.web.jiraapi.JiraApiService" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="jira/template/jwtvalidate.jsp" %>
<%
    String redirectQuery = "";
    Map parameterMap = request.getParameterMap();
    Iterator iterator = parameterMap.keySet().iterator();
    while (iterator.hasNext()) {
        String key = (String) iterator.next();
        String value = ((String[]) parameterMap.get(key))[0];
        if (redirectQuery.length() < 1) {
            redirectQuery = redirectQuery + "?" + key + "=" + value;
        } else {
            redirectQuery = redirectQuery + "&" + key + "=" + value;
        }
    }

    String issueId = request.getParameter("issueId");
    String projectId = request.getParameter("projectId");
    String instanceId = null;
    String tracingTag = null;
    String taskId = null;

    String requestUserKey = clientService.getRequestUserKey(request);
    JiraApiService jiraApiService = (JiraApiService) context.getBean(JiraApiService.class);
    Map user = jiraApiService.getUser(request, requestUserKey);
    String emailAddress = user.get("emailAddress").toString();

    EmployeeService employeeService = (EmployeeService) context.getBean(EmployeeService.class);
    Employee employee = employeeService.findByEmailAndGlobalCom(emailAddress, requestUserKey, comCode);
    String empCode = employee.getEmpCode();


    if (issueId == null || projectId == null) {
        response.sendRedirect("/jira/page/invalid.jsp");
    }

    JiraIssueService issueService = (JiraIssueService) context.getBean(JiraIssueService.class);
    JiraIssue jiraIssue = issueService.selectByJiraIssueInformation(clientKey, projectId, issueId);
    if (jiraIssue != null) {

        instanceId = jiraIssue.getInstanceId().toString();
        tracingTag = jiraIssue.getTracingTag().toString();
        taskId = jiraIssue.getTaskId().toString();

        String issueStatus = jiraApiService.getIssueStatus(clientKey, jiraIssue.getIssueId());

        String activityStatus = issueService.getJiraIssueActivityStatus(jiraIssue);

        //지라이슈는 Done 처리되었지만 액티비티는 Completed 상태가 아닐때
        //액티비티를 완료하도록 안내하는 페이지를 띄운다.
        if (issueStatus.equals("Done") && !activityStatus.equals("Completed")) {
            response.sendRedirect("/jira/page/activity-not-completed.jsp" + redirectQuery);
        }

    } else {
        response.sendRedirect("/jira/page/not-jira.jsp" + redirectQuery);
    }

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:fb="http://ogp.me/ns/fb#" xml:lang="en" lang="en">

<head>
    <%@include file="jira/template/header.jsp" %>
    <%@include file="jira/template/mw3_jira_common.jsp" %>
</head>

<body onload="dwr.engine.setActiveReverseAjax(true);">
<script type="text/javascript">
    $(function () {
        var session = new MetaworksObject({
            __className: 'org.uengine.codi.mw3.model.Session',
            jiraComCode: jiraSession.comCode,
            jiraEmpCode: '<%=empCode%>'
        }, 'body');
        session.jiraLogin(null, function () {
            var workItem = new MetaworksObject({
                __className: 'org.uengine.codi.mw3.model.WorkItem',
                instId: '<%=instanceId %>',
                taskId: '<%=taskId %>',
                tracingTag: '<%=tracingTag %>',
                jiraTenant: jiraSession.comCode
            }, 'body');

            workItem.jiraActivityCardPopup(null, function () {
                $('.target_popup').css('width', '100%');

                var width = console.log($('.target_popup').width());
                if (width < 600) {
                    return;
                }
                var tbody = $('[name=activityCard]').find('tbody');
                var header = $(tbody.find('tr').get(0));
                var activityTr = $(tbody.find('tr').get(1));
                var view = $(activityTr.find('td').get(0));
                var desc = $(activityTr.find('td').get(1));
                var clone = desc.clone();
                var newTr = $('<tr></tr>');

                view.attr('colspan', '2');
                view.css('width', '100%');
                view.find('svg').attr('width', '100%');

                clone.attr('colspan', '2');
                clone.css('width', '100%');

                newTr.append(clone);
                desc.remove();

                header.after(newTr);
            });
        });
    })
</script>
<div class="error_div"></div>
</body>
</html>