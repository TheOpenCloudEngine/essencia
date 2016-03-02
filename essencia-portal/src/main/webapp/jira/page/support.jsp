<%@ page import="org.uengine.web.jiraapi.JiraApiService" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="../template/jwtvalidate.jsp" %>
<%

    String requestUserKey = clientService.getRequestUserKey(request);
    JiraApiService jiraApiService = (JiraApiService) context.getBean(JiraApiService.class);
    Map user = jiraApiService.getUser(request, requestUserKey);
    String emailAddress = user.get("emailAddress").toString();

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
    <%@include file="../template/aui_common.jsp" %>
    <script src="/jira/js/support.js" type="text/javascript"></script>
</head>

<body>
<script type="text/javascript">
    $(function () {
        var jiraEmail = '<%=emailAddress%>'
    })
</script>
<section id="content" role="main">
    <%@include file="../template/navigator.jsp" %>
    <%@include file="../template/dialog.jsp" %>

    <section class="aui-page-panel-content">
        <h2>Uengine Support Teams</h2>

        <h3>Contact our support team</h3>

        <div class="aui-message aui-message-warning">
            <p class="title">
                <strong>Contact us via the form below</strong>
            </p>

            <p>If you send email to us directly , we can not determine <strong>whether your jira-product came
                from</strong>.

                Please just <strong>contact us via the form below</strong> for accurate tracking data .</p>
        </div>

        <form id="contact-form" class="aui" action="#">
            <div class="field-group">
                <label for="email">Reply email
                    <span class="aui-icon icon-required">(required)</span></label>
                <input class="text" type="text"
                       id="email" name="email" value="<%=emailAddress%>"
                       data-aui-validation-field required>
            </div>
            <div class="field-group">
                <label for="subject">Subject
                    <span class="aui-icon icon-required">(required)</span></label>
                <input class="text" type="text"
                       id="subject" name="subject" placeholder="Subject here..."
                       data-aui-validation-field required>
            </div>
            <div class="field-group">
                <label for="contents">Comment
                    <span class="aui-icon icon-required">(required)</span></label>
                <textarea class="textarea long-field" name="contents"
                          id="contents" placeholder="Your questions here..."
                          data-aui-validation-field required>
                </textarea>
            </div>
            <div class="buttons-container">
                <button class="aui-button aui-button-primary"
                        id="send-contact" type="submit">Send
                </button>
            </div>
        </form>
    </section>
</section>

</body>

</html>
