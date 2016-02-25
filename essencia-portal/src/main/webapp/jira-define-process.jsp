<%@ page import="java.util.Map" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="org.uengine.web.jiraissue.JiraIssueService" %>
<%@ page import="org.uengine.web.jiraissue.JiraIssue" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--<%@include file="jira/template/jwtvalidate.jsp" %>--%>
<%--<%--%>
    <%--String issueId = request.getParameter("issueId");--%>
    <%--String projectId = request.getParameter("projectId");--%>
    <%--String instanceId = null;--%>
    <%--String tracingTag = null;--%>
    <%--String taskId = null;--%>

    <%--if (issueId == null || projectId == null) {--%>
        <%--response.sendRedirect("/jira/page/invalid.jsp");--%>
    <%--}--%>

    <%--JiraIssueService issueService = (JiraIssueService) context.getBean(JiraIssueService.class);--%>
    <%--JiraIssue jiraIssue = issueService.selectByJiraIssueInformation(clientKey, projectId, issueId);--%>
    <%--if (jiraIssue != null) {--%>

        <%--instanceId = jiraIssue.getInstanceId().toString();--%>
        <%--tracingTag = jiraIssue.getTracingTag().toString();--%>
        <%--taskId = jiraIssue.getTaskId().toString();--%>

    <%--} else {--%>
        <%--String redirectQuery = "";--%>
        <%--Map parameterMap = request.getParameterMap();--%>
        <%--Iterator iterator = parameterMap.keySet().iterator();--%>
        <%--while (iterator.hasNext()) {--%>
            <%--String key = (String) iterator.next();--%>
            <%--String value = ((String[]) parameterMap.get(key))[0];--%>
            <%--if (redirectQuery.length() < 1) {--%>
                <%--redirectQuery = redirectQuery + "?" + key + "=" + value;--%>
            <%--} else {--%>
                <%--redirectQuery = redirectQuery + "&" + key + "=" + value;--%>
            <%--}--%>
        <%--}--%>
        <%--response.sendRedirect("/jira/page/not-jira.jsp" + redirectQuery);--%>
    <%--}--%>

<%--%>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:fb="http://ogp.me/ns/fb#" xml:lang="en" lang="en">

<head>
    <%@include file="jira/template/header.jsp" %>
    <%@include file="jira/template/mw3_jira_common.jsp" %>
</head>

<body onload="dwr.engine.setActiveReverseAjax(true);">
<script type="text/javascript">
    $(function () {
        var workItem = new MetaworksObject({
            __className: 'org.uengine.processadmin.ProcessAdminWorkbench'
        }, 'body');
        //workItem.showDashboard();

//        workItem.activityCardPopup(null, function () {
//            // 서버단에서 해결하기 힘들기 때문에 스크립트를 통해 제어
//            // 1. info 삭제
//            // 2. workItem 껍데기 삭제 (객체 안에 어떠한 정보도 없기 때문에 삭제)
//            //$('[classname="org.uengine.codi.mw3.model.WorkItem"]').next().remove();
//            //$('[classname="org.uengine.codi.mw3.model.WorkItem"]').remove();
//        });
    })
</script>
<div class="error_div"></div>
</body>
</html>