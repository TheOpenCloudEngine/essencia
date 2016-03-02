var org_uengine_essencia_enactment_handler_EssenceActivityHandler = function (objectId, className) {

    this.objectId = objectId;
    this.className = className;
    this.objectDivId = mw3._getObjectDivId(this.objectId);
    this.objectDiv = $('#' + this.objectDivId);
    this.object = mw3.objects[this.objectId];

    if (this.object == null) {
        return true;
    }

    if (this.object.handleByJira) {
        this.objectDiv.find('.btn-group').each(function () {
            $(this).find('button').each(function () {
                if ($(this).text().indexOf('Save') < 0) {
                    $(this).hide();
                }
            })
        })
    }
};

