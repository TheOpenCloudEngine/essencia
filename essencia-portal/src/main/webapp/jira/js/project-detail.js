var onPageLoadScript = function () {
    var defId = $('#defId').val();
    var roles = [];
    var processMwService;

    var createRoleMappingLayout = function () {

        $.each(roles, function (index, role) {
            var selectBox = '' +
                '<div class="field-group" name="role-mapping">' +
                '<label>'+role.name+'</label>' +
                '<input name="userkey" class="text long-field ajax-get-user" data-aui-validation-field required type="text">' +
                '<input type="hidden" name="rolename" value="'+role.name+'">' +
                '</div>';
            selectBox = $(selectBox);
            $('#roleMappingFieldset').append(selectBox);
        });

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
    var getRoles = function () {
        processMwService = new MetaworksObject({
            __className: 'org.uengine.jira.mw3.ProcessMwService',
            defId: defId
        }, '#metaworks_space');

        processMwService.loadRoles(null, function () {
            var rolesJson = $('#metaworks_space').find('[name=rolesJson]').html();
            if (rolesJson && rolesJson.length) {
                roles = JSON.parse(rolesJson);
                createRoleMappingLayout();
            }
        });
    };
    getRoles();

    marked.setOptions({
        highlight: function (code) {
            return hljs.highlightAuto(code).value;
        }
    });
    $.get('/jira/plugins/marked/README.md', function (data) {
        $('#marked-content').html(marked(data));
    });


    AJS.$('#add-project-form').on('aui-valid-submit', function(event) {
        event.preventDefault();

        if(!roles || !roles.length){
            customUtil.renderWarningDialog('Assigned personnel required.');
            return;
        }

        var form = $('#add-project-form');
        var roleMapping = [];
        $.each(form.find('[name=role-mapping]'), function(index,mapping){
            roleMapping.push({
               name: $(mapping).find('[name=rolename]').val(),
               userkey: $(mapping).find('[name=userkey]').val()
            });
        });

        blockSubmitStart();
        processMwService = new MetaworksObject({
                    __className: 'org.uengine.jira.mw3.ProcessMwService',
                    defId: defId,
                    name : form.find('[name=name]').val(),
                    key  : form.find('[name=key]').val(),
                    roleMapping: JSON.stringify(roleMapping)
                }, '#metaworks_space');
        processMwService.saveProject(null, function(){
            blockStop();
        });
    });
};