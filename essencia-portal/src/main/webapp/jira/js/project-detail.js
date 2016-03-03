var onPageLoadScript = function () {
    var mapId = $('#mapId').val();
    var defId = $('#defId').val();
    var comCode = $('#comCode').val();

    var url = '/jira-process-map.jsp?defId=' + defId;
    $('#process-map-iframe').attr('src', customUtil.addJiraParametersToUrl(url));

    var createRoleMappingLayout = function () {

        customUtil.getUserByName('%', function (err, res) {
            if (err) {
                customUtil.renderWarningDialog('Can not access user list information.');
            } else {
                var users = [];
                $.each(res, function (index, user) {
                    users.push({
                        id: user.key,
                        text: user.displayName + ' - ' + user.emailAddress
                    })
                });
                var data = [
                    {
                        text: 'users',
                        children: users
                    }
                ];
                AJS.$(".ajax-get-user").auiSelect2({
                    data: data
                });
            }
        });
    }
    createRoleMappingLayout();

    AJS.$('#projectType').auiSelect2();


    marked.setOptions({
        highlight: function (code) {
            return hljs.highlightAuto(code).value;
        }
    });
    $.get('/jira/plugins/marked/README.md', function (data) {
        $('#marked-content').html(marked(data));
    });

    AJS.$('#add-project-form').on('aui-valid-submit', function (event) {
        event.preventDefault();

        var form = $('#add-project-form');
        var roleMapping = [];
        $.each(form.find('[name=role-mapping]'), function (index, mapping) {
            roleMapping.push({
                roleName: $(mapping).find('[name=rolename]').val(),
                userKey: $(mapping).find('[name=userkey]').val()
            });
        });

        blockSubmitStart();

        var params = {
            mapId: mapId,
            name: form.find('[name=name]').val(),
            key: form.find('[name=key]').val(),
            projectType: form.find('[name=projectType]').val(),
            roleMapping: roleMapping
        }
        $.ajax({
            type: "POST",
            url: "/api/process/create",
            data: JSON.stringify(params),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (response) {
                if (response.success) {
                    window.location.href = customUtil.addJiraParametersToUrl('./index');
                } else {
                    if (response.error.message == 'permission') {
                        customUtil.renderWarningDialog('You do not have permission to create a project. Only jira-administrators group members are enabled.');
                    } else {
                        customUtil.renderWarningDialog('Failed to create Essencia projects.');
                    }
                }
                blockStop();
            },
            error: function (response, status, errorThrown) {
                customUtil.renderWarningDialog('Failed to create Essencia projects.');
                blockStop();
            }
        });
    });
};