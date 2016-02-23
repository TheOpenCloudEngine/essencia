/**
 * Created by Misaka on 2016-02-19.
 */
var onPageLoadScript = function () {
    var workItem = new MetaworksObject({
        __className: 'org.uengine.codi.mw3.model.WorkItem',
        instId: '58869',
        taskId: '129449',
        tracingTag: '1',
        type: 'process'
    }, 'body');
    workItem.workItemPopup();
};