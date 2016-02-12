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
    <%@include file="../template/mw3_jira_common.jsp" %>
    <script src="/jira/js/project-detail.js" type="text/javascript"></script>

    <link rel="stylesheet" href="/jira/plugins/highlight/styles/default.css" media="all">
    <script src="/jira/plugins/highlight/highlight.pack.js" type="text/javascript"></script>
    <script src="/jira/plugins/marked/lib/marked.js" type="text/javascript"></script>
</head>

<body>

<section id="content" role="main">
    <%@include file="../template/navigator.jsp" %>
    <%@include file="../template/dialog.jsp" %>

    <section class="aui-page-panel-content">
        <h2>Essence Project Detail</h2>

        <h3>${processMap.name}</h3>

        <div class="aui-tabs horizontal-tabs" id="tabs-example1">
            <ul class="tabs-menu">
                <li class="menu-item active-tab">
                    <a href="#tabs-create"><strong>Create Project</strong></a>
                </li>
                <li class="menu-item">
                    <a href="#tabs-overview"><strong>Overview</strong></a>
                </li>
            </ul>
            <div class="tabs-pane active-pane" id="tabs-create">

                <div class="aui-group">
                    <div class="aui-item">
                        <form id="add-project-form" class="aui" action="#">
                            <br>
                            <h4>Basic Information</h4>
                            <fieldset>
                                <div class="field-group"><label for="name">Project Name</label>
                                    <input class="text" type="text" name="name" id="name" data-aui-validation-field
                                           maxlength="80" minlength="2" required>

                                    <div class="description">Max. 80 characters.</div>
                                </div>
                                <div class="field-group"><label for="key">Project Key</label>
                                    <input class="text" type="text" name="key" id="key" data-aui-validation-field
                                           maxlength="10" minlength="2" required
                                           style="text-transform: uppercase">

                                    <div class="description">Max. 10 characters.</div>
                                </div>
                            </fieldset>
                            <br>
                            <h4>Assigned personnel</h4>

                            <fieldset id="roleMappingFieldset">

                            </fieldset>
                            <div class="buttons-container form-footer">
                                <div class="buttons">
                                    <button class="aui-button aui-button-primary"
                                         id="create-project" type="submit">Create
                                    </button>
                                    <a class="cancel" id="cancle-project">Cancel</a>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="aui-item">
                        <br>
                        <h4>Process Map</h4>
                        <img width="300" src="/jira/images/sample1.png">
                    </div>
                </div>
            </div>
            <div class="tabs-pane" id="tabs-overview">
                <br>
                <h4>Process Map</h4>
                <img width="300" src="/jira/images/sample1.png">

                <br>
                <h4>Process Usage</h4>

                <div id="marked-content"></div>
            </div>
        </div>
        <!-- .aui-tabs -->
    </section>

</section>

<!-- Metaworks Space -->
<div id="metaworks_space" style="display: none">
    <input type="hidden" value="${processMap.defId}" id="defId">
</div>
<!-- Metaworks Space End -->
</body>

</html>
