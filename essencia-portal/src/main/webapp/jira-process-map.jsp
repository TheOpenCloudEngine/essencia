<%@ page import="org.uengine.web.employee.EmployeeService" %>
<%@ page import="org.uengine.codi.mw3.model.Employee" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="jira/template/jwtvalidate.jsp" %>
<%

    String requestUserKey = clientService.getRequestUserKey(request);

    EmployeeService employeeService = (EmployeeService) context.getBean(EmployeeService.class);
    Employee employee = employeeService.createJiraEmployeeIfNotExist(request, requestUserKey);
    String empCode = employee.getEmpCode();

    String defId = request.getParameter("defId");

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
    var tenant = jiraSession.comCode;
    $(function () {
        var session = new MetaworksObject({
            __className: 'org.uengine.codi.mw3.model.Session',
            jiraComCode: jiraSession.comCode,
            jiraEmpCode: '<%=empCode%>'
        }, 'body');
        session.jiraLogin(null, function () {
            var panel = new MetaworksObject({
                __className: 'org.uengine.web.process.ProcessMapPanel',
                jiraTenant: jiraSession.comCode,
                defId: '<%=defId%>'
            }, 'body');
            panel.loadJira(null, function () {
                $('body').css('overflow', 'hidden');
            });
        });
    })
</script>
<div class="error_div"></div>
</body>
</html>