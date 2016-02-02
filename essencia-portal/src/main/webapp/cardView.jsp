<%@include file="mw3_common.jsp"%>

<script>

    var loadMetaworksObject = function(){
        var card = new MetaworksObject({
            __className : "org.uengine.essencia.portal.StandaloneCard",
            instanceId : "<%=request.getParameter("instanceId")%>",
            token: "<%=request.getParameter("token")%>"
        }, 'body');

        card.load();

    }


</script>