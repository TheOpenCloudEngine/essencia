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
            </thead>
            <tbody>

            </tbody>
        </table>

    </section>

</section>

</body>

</html>
