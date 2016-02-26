<%@ page contentType="text/html; charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="../template/jwtvalidate.jsp" %>
<!DOCTYPE html>
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if !IE]><!-->
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org"
      lang="en">
<!--<![endif]-->
<head>
    <%@include file="../template/header.jsp" %>
    <%@include file="../template/aui_common.jsp" %>
    <script src="/jira/js/index.js" type="text/javascript"></script>
</head>

<body>
<section id="content" role="main">
    <%@include file="../template/navigator.jsp" %>
    <%@include file="../template/dialog.jsp" %>

    <section class="aui-page-panel-content">
        <h1>What is Essencia?</h1>

        <br>
        <h2>Practice Definer</h2>
        <p>Practices are defined and become the elements of Methods via mapping the kernel elements of Essence language. Practice author mapping Alpha and Activity space both via reversible order and repeatable way.</p>

        <br>
        <h2>Methods Composer</h2>
        <p>t can compose Methods out of one or more defined Practices and support automatic integration within same elements. Additionally it supports conversion into BPMN Process Model, ordering of Activities and deploy into web launch.</p>

        <br>
        <h2>Runner</h2>
        <p>It signifies integrate community that provide environment for implementation of deployed Method Process and community for stakeholders. Defining of Role is offered at the starting point of Process and provide checklist for Essence Specification according to Activities. Monitoring of task progress according to each Activity states and area of concern is possible.</p>

        <br>
        <h2>Import-Export in Essence XMI</h2>
        <p>Newly defined Practices can be imported and exported by integration with JIRA and Microsoft Project. Files can be opened via Notepad to be viewed and Practice and Methods are stored and loaded with Essence XMI by using Eclipse eCore framework.</p>

        <br>
        <iframe src="https://player.vimeo.com/video/130615038" width="100%" height="375" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe>


    </section>
</section>

</body>

</html>
