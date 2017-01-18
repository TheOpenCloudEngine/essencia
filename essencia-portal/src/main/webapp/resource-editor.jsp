<%@include file="mw3_common.jsp" %>

<script>

    function loadMetaworksObject(){
        <%
            String resourcePath = new String(org.uengine.util.Base64Util.decode(request.getParameter("resourcePath")), "UTF-8");
        %>

        var accessToken = request.getParameter('accessToken');
        var userId = request.getParameter('userId');

        new MetaworksObject({
            __className : "org.uengine.processadmin.ProcessAdminStarter",
            key : 'loader',
            resourcePath: "<%=resourcePath%>",
            accessToken: accessToken,
            userId: userId,
            defaultLoadingResourcePath: "<%=resourcePath%>"
        }, 'body');

    }

</script>