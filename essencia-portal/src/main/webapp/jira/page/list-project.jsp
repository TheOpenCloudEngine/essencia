<%@ page contentType="text/html; charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script src="/jira/js/list-project.js" type="text/javascript"></script>
</head>

<body>

<section id="content" role="main">
    <%@include file="../template/navigator.jsp" %>
    <%@include file="../template/dialog.jsp" %>

    <section class="aui-page-panel-content">
        <h2>Select Essence Project</h2>

        <form class="aui">
            <div class="field-group">
                <label for="project_name"><span class="aui-icon aui-icon-small aui-iconfont-search"></span>
                    Search</label>
                <input class="text" type="text" id="project_name" name="project_name" title="Name">

                <div class="description"><a href="#">Can not find the desired project ?</a></div>
            </div>
        </form>

        <table id="processTable" class="aui aui-table-sortable">
            <thead>
            <tr>
                <th>Name</th>
                <th class="aui-table-column-unsortable">Tags</th>
                <th>Watchers</th>
                <th class="aui-table-column-unsortable">Description</th>
            </tr>
            <c:forEach items="${processMaps}" var="processMap" varStatus="status">
            <tr>
                <td name="name"><a href="#" data-mapId="${processMap.mapId}">${processMap.name}</a></td>
                <td name="tags">
                    <span class="aui-lozenge aui-lozenge-success">public</span>
                    <span class="aui-lozenge aui-lozenge-complete">new</span>
                </td>
                <td name="watchers">1581</td>
                <td name="description">Essencia helps you adopting OMG&quot;s Standard &quot;Essence&quot; stands for SW
                    engineering practice authoring and execution.
                </td>
            <tr>

                </c:forEach>
            </thead>
            <tbody>

            </tbody>
        </table>

    </section>

</section>
</body>

</html>
