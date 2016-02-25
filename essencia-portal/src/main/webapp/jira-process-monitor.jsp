<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Map" %>
<%@ page import="org.uengine.web.jiraproject.JiraProjectService" %>
<%@ page import="org.uengine.web.jiraproject.JiraProject" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="jira/template/jwtvalidate.jsp" %>
<%
    String projectId = request.getParameter("projectId");
    String instanceId = null;

    if (projectId == null) {
        response.sendRedirect("/jira/page/invalid.jsp");
    }

    JiraProjectService projectService = (JiraProjectService) context.getBean(JiraProjectService.class);
    JiraProject jiraProject = projectService.selectByClientKeyAndProjectId(clientKey, projectId);

    if (jiraProject != null) {

        instanceId = jiraProject.getInstanceId().toString();

    } else {
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
        var essenciaInstanceTooltip = new MetaworksObject({
            __className: 'org.uengine.essencia.portal.EssenciaInstanceTooltip',
            instanceId: '<%=instanceId %>'
        }, 'body');

        essenciaInstanceTooltip.monitorPopup(null, function () {
            // svg 영역을 popup 창 바로 아래까지 끌어올린다.
            // java 영역에서 해결하기 힘들었기 때문에 스크립트를 통해 제어

            // 1. svg 영역을 클론으로 만들어 놓은 후
            // 2. popup 하위의 children을 모두 empty (그 사이들의 객체 삭제)
            // 3. 그 후에 svg 영역 만 append
            // 4. info 삭제
            // 5. essenciaToolTip 삭제
            var cloneSVG = $('svg');
            $('.target_popup').empty();
            $('.target_popup').append(cloneSVG);

            $('[classname="org.uengine.essencia.portal.EssenciaInstanceTooltip"]').next().remove();
            $('[classname="org.uengine.essencia.portal.EssenciaInstanceTooltip"]').remove();
        });
    })
</script>
<div class="error_div"></div>
</body>
</html>

