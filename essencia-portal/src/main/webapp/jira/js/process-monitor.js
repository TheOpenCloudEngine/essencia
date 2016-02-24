/**
 * Created by Misaka on 2016-02-19.
 */
var onPageLoadScript = function () {
    var essenciaInstanceTooltip = new MetaworksObject({
        __className: 'org.uengine.essencia.portal.EssenciaInstanceTooltip',
        instanceId: '58869'
    }, 'body');

    essenciaInstanceTooltip.monitorPopup(null, function () {
        // svg 영역을 popup 창 바로 아래까지 끌어올린다.
        // java 영역에서 해결하기 힘들었기 때문에 스크립트를 통해 제어

        // 1. svg 영역을 클론으로 만들어 놓은 후
        // 2. popup 하위의 children을 모두 empty (그 사이들의 객체 삭제)
        // 3. 그 후에 svg 영역 만 append
        // 4. info 삭제
        // 5. essenciaToolTip 삭제
        var cloneSVG = $('svg');
        $('.target_popup').empty();
        $('.target_popup').append(cloneSVG);

        $('[classname="org.uengine.essencia.portal.EssenciaInstanceTooltip"]').next().remove();
        $('[classname="org.uengine.essencia.portal.EssenciaInstanceTooltip"]').remove();
    });
};