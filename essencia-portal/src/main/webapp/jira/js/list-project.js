var onPageLoadScript = function () {

    $.ajax({
        type: "GET",
        url: "/api/process/list",
        data: "",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {
            if (response.success) {
                $.each(response.list, function (index, processmap) {
                    var row = '' +
                        '<tr>' +
                        '<td name="name"><a href="#">' + processmap.name + '</a></td>' +
                        '<td name="tags"></td>' +
                        '<td name="watchers">1581</td>' +
                        '<td name="description">Essencia helps you adopting OMG&quot;s Standard &quot;Essence&quot; stands for SW engineering practice authoring and execution.</td>' +
                        '<tr>';

                    row = $(row);
                    $('#processTable').find('tbody').append(row);
                    row.find('[name=name]').find('a').data('mapId', processmap.mapId);

                    //태그 입력
                    var tags = [];
                    if(processmap.isPublic){
                        tags.push('public');
                    };
                    if(processmap.isNew){
                        tags.push('new');
                    };

                    var tagsHtml = '';
                    for (var i = 0; i < tags.length; i++) {
                        if (tags[i] === 'public') {
                            tagsHtml = tagsHtml + '<span class="aui-lozenge aui-lozenge-success">public</span>'
                        }
                        if (tags[i] === 'new') {
                            tagsHtml = tagsHtml + '<span class="aui-lozenge aui-lozenge-complete">new</span>'
                        }
                    }
                    row.find('[name=tags]').append(tagsHtml);

                    //이동 이벤트
                    row.find('[name=name]').find('a').click(function () {
                        var mapId = $(this).data('mapId');
                        var url = './project-detail?mapId=' + encodeURIComponent(mapId);
                        window.location.href = customUtil.addJiraParametersToUrl(url);
                    });
                })
            } else {
                customUtil.renderWarningDialog('Failed to get list of Essencia projects.');
            }
        },
        error: function (response, status, errorThrown) {
            customUtil.renderWarningDialog('Failed to get list of Essencia projects.');
        }
    });
};