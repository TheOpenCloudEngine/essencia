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
  <script src="/jira/js/not-jira.js" type="text/javascript"></script>
</head>

<body>
<section id="content" role="main">
  <section class="aui-page-panel-content">
    <div class="aui-message">
      <p class="title">
        <strong>Not an Essencia project</strong>
      </p>
      <p>Start your own Essencia project with navigation top panel Essencia menu.</p>
    </div>
  </section>
</section>

</body>

</html>
