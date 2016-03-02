var onPageLoadScript = function () {
    $('#processTable').find('[name=name]').find('a').click(function () {
        var mapId = $(this).attr('data-mapId');
        var url = './project-detail?mapId=' + encodeURIComponent(mapId);
        console.log(url);
        window.location.href = customUtil.addJiraParametersToUrl(url);
    });


    var url = '/jira-add-process.jsp';
    var iframeUrl = customUtil.addJiraParametersToUrl(url);

    ////$('#add-app').click(function () {
    ////    var url = '/jira-add-process.jsp';
    ////    window.open(customUtil.addJiraParametersToUrl(url));
    ////});
    //
    //// Standard sizes are 400, 600, 800 and 960 pixels wide
    //var dialog = new AJS.Dialog({
    //    width: 800,
    //    height: 500,
    //    id: "add-app",
    //    closeOnOutsideClick: true
    //});
    //
    //// PAGE 0 (first page)
    //// adds header for first page
    //dialog.addHeader("Dialog");
    //
    //console.log(iframeUrl);
    //// add panel 1
    ////dialog.addPanel('Panel 1', '<iframe style="width:100%; heigth:100%" src="'+iframeUrl+'"></iframe>', 'panel-body');
    //dialog.addPanel('Panel 1', '<iframe style="width:100%; heigth:100%" src=""></iframe>', 'panel-body');
    //// You can remove padding with:
    //// dialog.get("panel:0").setPadding(0);
    //
    //dialog.addLink("Cancel", function (dialog) {
    //    dialog.hide();
    //}, "#");
    //
    //
    //// Add events to dialog trigger elements
    //AJS.$("#add-app").click(function () {
    //    dialog.show();
    //});
    $("#add-app").click(function(){
        $('#large-dialog').find('[name=msg]').html('<iframe style="border:none;width:100%;height:500px" src="'+iframeUrl+'"></iframe>');
        AJS.dialog2('#large-dialog').show();

        $('#larget-dialog').find('[name=close-button]').click(function(e){
            e.preventDefault();
            AJS.dialog2("#large-dialog").hide();
        });
    });

};