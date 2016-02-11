<%@ page import="org.uengine.web.jiraclient.JiraClientService" %>
<%@ page import="org.uengine.web.util.ApplicationContextRegistry" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%
    ApplicationContext context = ApplicationContextRegistry.getApplicationContext();
    Object bean = context.getBean(JiraClientService.class);
    JiraClientService clientService = (JiraClientService) bean;
    String claimJson = null;

    try {
        claimJson = clientService.validateAndGetClaim(request);
    } catch (Exception ex) {
        response.sendRedirect("./error/unauthorized.jsp");
    }
%>