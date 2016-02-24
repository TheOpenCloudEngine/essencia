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

    workItem.activityCardPopup(null, function () {
        // 서버단에서 해결하기 힘들기 때문에 스크립트를 통해 제어
        // 1. info 삭제
        // 2. workItem 껍데기 삭제 (객체 안에 어떠한 정보도 없기 때문에 삭제)
        $('[classname="org.uengine.codi.mw3.model.WorkItem"]').next().remove();
        $('[classname="org.uengine.codi.mw3.model.WorkItem"]').remove();
    });
};

