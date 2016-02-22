var onPageLoadScript = function () {
    $('#processTable').find('[name=name]').find('a').click(function () {
        var mapId = $(this).attr('data-mapId');
        var url = './project-detail?mapId=' + encodeURIComponent(mapId);
        console.log(url);
        window.location.href = customUtil.addJiraParametersToUrl(url);
    });
};