<%@include file="mw3_common.jsp" %>

<script>

    function loadMetaworksObject(){

        var resourcePath = request.getParameter('resourcePath');
        var accessToken = request.getParameter('accessToken');

        new MetaworksObject({
            __className : "com.abc.portal.ABCStarter",
            key : 'loader',
            resourcePath: resourcePath,
            accessToken: accessToken,
            defaultLoadingResourcePath: resourcePath
        }, 'body');

    }

</script>