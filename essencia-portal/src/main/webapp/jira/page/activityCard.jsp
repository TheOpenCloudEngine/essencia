<%@ page import="java.util.Map" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="../template/jwtvalidate.jsp" %>
<%
  Map parameterMap = request.getParameterMap();
  //아마도 저 맵 안에 project.id...  issue.id 이런식으로 지라쪽에서 던져준 파라미터가 있을거임.
%>
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
  <%@include file="../template/mw3_jira_common.jsp" %>
  <script src="/jira/js/project-detail.js" type="text/javascript"></script>

</head>

<body>

<script type="text/javascript">
  $(function(){
     // 메타웍스 액티비티 카드 통으로 불러오면 됨. 일단은 아무거나.

    //추후에 더 자세히 가져오고싶다면, jsp request 객체에서 넘어올때 Jira가 프로젝트 아이디와 이슈 아이디를 보내줌.
  })
</script>
</body>

</html>
