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

        <br>

        <h3>Process Map</h3>

        <p>You can see detail "Activity Card", which contains the competency who should do the activity, and the
            input/output alphas and work-products, and the checkpoints of completion criteria. To see these
            details, double-click the activity.</p>
        <iframe frameborder=no scrolling=no style="width: 100%; height: 400px;overflow: hidden;"
                id="process-map-iframe"></iframe>

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
                        <div class="field-group"><label for="key">Project Type</label>
                            <select name="projectType" id="projectType" data-aui-validation-field required>
                                <c:forEach items="${projectTypes}" var="projectType" varStatus="status">
                                    <option value="${projectType.key}">${projectType.formattedKey}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </fieldset>
                    <br>
                    <h4>Assigned personnel</h4>

                    <fieldset id="roleMappingFieldset">
                        <c:forEach items="${roles}" var="role" varStatus="status">
                            <div class="field-group" name="role-mapping">
                                <label>${role.name}</label>
                                <input name="userkey" class="text long-field ajax-get-user"
                                       data-aui-validation-field required type="text">
                                <input type="hidden" name="rolename" value="${role.name}">
                            </div>
                        </c:forEach>
                    </fieldset>
                    <div class="buttons-container form-footer">
                        <div class="buttons">
                            <button class="aui-button aui-button-primary"
                                    id="create-project" type="submit">Create
                            </button>
                            <a class="cancel" id="cancle-project">Cancel</a>
                        </div>
                    </div>
                    <input type="hidden" value="${processMap.mapId}" id="mapId">
                    <input type="hidden" value="${processMap.defId}" id="defId">
                    <input type="hidden" value="${processMap.comCode}" id="comCode">
                </form>
            </div>
        </div>

    </section>

</section>

</body>

</html>
