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

                <div class="description"><a name="jira-redirect" href="#" data-path="/jira-market-place.jsp"
                                            data-target="new">Can not find the desired project ?</a></div>
            </div>
        </form>


        <div class="aui-message">
            <p class="title">
                <strong>How to start a project with practices?</strong>
            </p>

            <p>First, You can easily start using the
                <a name="jira-redirect" href="#" data-path="/jira-market-place.jsp"
                   data-target="new">Marketplace</a>.
            </p>
            <br>

            <p>Also you can create a project from your <a name="add-app" href="#">resource repository</a>,
                It will show available process files list.
            </p>

            <p>Initially, the resource repository will be empty.
                You should create a method file using <a name="jira-redirect" href="#"
                                                         data-path="/jira-define-process.jsp"
                                                         data-target="new">define process</a>,
                run how to define process at <a name="jira-redirect" href="#"
                                                     data-path="/api/view/getting-started">getting stared</a></p>

            <br>
            <a class="aui-button aui-button-primary"
               name="jira-redirect" href="#" data-path="/jira-market-place.jsp"
               data-target="new">Marketplace
            </a>
            <a class="aui-button aui-button-primary"
               name="add-app">Add app from repository
            </a>
        </div>


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
