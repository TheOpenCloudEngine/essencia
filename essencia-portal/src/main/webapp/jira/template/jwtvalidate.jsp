<%@ page import="org.uengine.web.jiraclient.JiraClientService" %>
<%@ page import="org.uengine.web.util.ApplicationContextRegistry" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.uengine.web.company.CompanyService" %>
<%@ page import="org.uengine.codi.mw3.model.ICompany" %>
<%
    ApplicationContext context = ApplicationContextRegistry.getApplicationContext();
    JiraClientService clientService = (JiraClientService) context.getBean(JiraClientService.class);
    CompanyService companyService = (CompanyService) context.getBean(CompanyService.class);

    String claimJson = null;
    String clientKey = null;
    String comCode = null;

    try {
        claimJson = clientService.validateAndGetClaim(request);
        clientKey = clientService.getClientKeyFromClaimJson(claimJson);
        ICompany company = companyService.selectByAlias(clientKey);
        comCode = company.getComCode();

    } catch (Exception ex) {
        response.sendRedirect("./error/unauthorized.jsp");
    }
%>
<script type="text/javascript">
    var jiraSession = {
        claimJson: '<%=claimJson %>',
        clientKey: '<%=clientKey %>',
        comCode: '<%=comCode %>'
    };
</script>