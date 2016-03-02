<%@ page import="org.uengine.web.jiraapi.JiraApiService" %>
<%@ page import="java.util.Map" %>
<%@ page import="org.uengine.web.employee.EmployeeService" %>
<%@ page import="org.uengine.codi.mw3.model.Employee" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="jira/template/jwtvalidate.jsp" %>
<%

    String requestUserKey = clientService.getRequestUserKey(request);
    JiraApiService jiraApiService = (JiraApiService) context.getBean(JiraApiService.class);
    Map user = jiraApiService.getUser(request, requestUserKey);
    String emailAddress = user.get("emailAddress").toString();

    EmployeeService employeeService = (EmployeeService) context.getBean(EmployeeService.class);
    Employee employee = employeeService.findByEmailAndGlobalCom(emailAddress, requestUserKey, comCode);
    String empCode = employee.getEmpCode();

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:fb="http://ogp.me/ns/fb#" xml:lang="en" lang="en">

<head>
    <%@include file="jira/template/header.jsp" %>
    <%@include file="jira/template/mw3_jira_common.jsp" %>
</head>

<body onload="dwr.engine.setActiveReverseAjax(true);">
<script type="text/javascript">
    page_mode = "popup";
    $(function () {

        //에센시아 프랙티스 콤포저 화면 전체를 불러와야한다.


        var tenant = jiraSession.comCode;
//        var tenant = '1';
        console.log(tenant);

        var session = new MetaworksObject({
            __className: 'org.uengine.codi.mw3.model.Session',
            jiraComCode: jiraSession.comCode,
            jiraEmpCode: '<%=empCode%>'
        }, 'body');
        session.jiraLogin(null, function () {
            var processAdminLayout = new MetaworksObject({
                __className: 'org.uengine.processadmin.ProcessAdminLayout',
                jiraTenant: tenant
            }, 'body');

            processAdminLayout.showProcessAdmin(null, function () {

            });
        });
    })
</script>
<div class="error_div"></div>
</body>
</html>