var onPageLoadScript = function () {
    $('#processTable').find('[name=name]').find('a').click(function () {
        var mapId = $(this).attr('data-mapId');
        var url = './project-detail?mapId=' + encodeURIComponent(mapId);
        console.log(url);
        window.location.href = customUtil.addJiraParametersToUrl(url);
    });


    var url = '/jira-add-process.jsp';
    var iframeUrl = customUtil.addJiraParametersToUrl(url);

    $("[name=add-app]").click(function () {
        $('#large-dialog').find('[name=msg]').html('<iframe style="border:none;width:100%;height:500px" src="' + iframeUrl + '"></iframe>');
        AJS.dialog2('#large-dialog').show();
    });
    $('#large-dialog').find('[name=close-button]').click(function (e) {
        e.preventDefault();
        AJS.dialog2("#large-dialog").hide();
    });

};