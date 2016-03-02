<%@ page contentType="text/html; charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="jira/template/jwtvalidate.jsp" %>
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
        console.log(tenant);

        var processAdminLayout = new MetaworksObject({
            __className: 'org.uengine.processadmin.ProcessAdminLayout'
        }, 'body');

        processAdminLayout.showMarketPlace(null, function () {

        });

    })
</script>
<div class="error_div"></div>
</body>
</html>