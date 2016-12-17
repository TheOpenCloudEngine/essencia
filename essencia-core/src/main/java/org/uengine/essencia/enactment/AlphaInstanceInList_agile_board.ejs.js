var org_uengine_essencia_enactment_AlphaInstanceInList_agile_board = function(objectId, className){
    var object = mw3.objects[objectId];

    //if(object.metaworksContext && object.metaworksContext.how=='agile'){
    var div = $("#objDiv_" + objectId);
    var ths = div.closest("table").find("th");
    var state = object.languageElementInstance.currentStateName;

    div.click(
        function(){
            mw3.objects[objectId].edit();
        }
    );

    var whereWeMove = -1;
    for(var i=0; i<ths.length; i++){
        if(ths[i].childNodes[0] && ths[i].childNodes[0].data && ths[i].childNodes[0].data.indexOf(state) > -1){
            whereWeMove = i;
            break;
        }
    }

    if(whereWeMove>-1){
        var tds = div.closest("table").find("td");

        div.insertAfter(tds[whereWeMove].childNodes[0]);
    }

    // }
}