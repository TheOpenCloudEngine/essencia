/**
 * Created by Misaka on 2016-02-19.
 */
var onPageLoadScript = function () {
    var essenciaInstanceTooltip = new MetaworksObject({
        __className: 'org.uengine.essencia.portal.EssenciaInstanceTooltip',
        instanceId: '58869'
    }, 'body');

    essenciaInstanceTooltip.showDashBoardPopup(null, function () {
        // essenciaToolTip 객체가 자꾸 찍혀 나온다.
        // info 도 마찬가지.
        // 서버단에서 해결하기 힘들기 때문에 스크립트를 통해 제어
        $('[classname="org.uengine.essencia.portal.EssenciaInstanceTooltip"]').next().remove();
        $('[classname="org.uengine.essencia.portal.EssenciaInstanceTooltip"]').remove();
    });
};
