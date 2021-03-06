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
  <script src="/jira/js/getting-started.js" type="text/javascript"></script>
</head>

<body>
<section id="content" role="main">
  <%@include file="../template/navigator.jsp" %>
  <%@include file="../template/dialog.jsp" %>

  <section class="aui-page-panel-content" style="width: 100%">
    <iframe src="/jira/guide/Essencia-guide.html" width="100%" height="100%" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe>
  </section>
</section>

</body>

</html>
