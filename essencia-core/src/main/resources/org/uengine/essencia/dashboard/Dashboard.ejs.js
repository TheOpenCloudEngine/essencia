var org_uengine_essencia_dashboard_Dashboard = function(objectId, className) {
    this.objectId = objectId;
    this.className = className;

    var value = mw3.getObject(objectId);

    for(var i = 0; i < 2; i++){
        for(var j =0; j < value.alphas[i].states.length; j++){
            $( "#state-" + i + "-" + j ).droppable(
                {
                    drop: function( event, ui ) {

                    }
                }
            );

            $( "#state-" + i + "-" + j  ).draggable(
                {
                    containment: "#alpha-" + i,
                    revert: function(){
                        var id = $(this).attr("id");
                        var idSplit = id.split("-");
                        var nextElement = idSplit[0] + "-" + idSplit[1] + "-" + (parseInt(idSplit[2]) + 1);
                        var nextElementPosition = $("#" + nextElement).position();

                        var isRevert = true;
                        if(!nextElementPosition){
                            isRevert = false;
                        }else if(nextElementPosition.top > $(this).position().top + $(this).height()){
                            isRevert = false;
                        }
                        return isRevert;
                    },
                    axis: "y"
                }
            );
        }
    }
    //this.dashboard = mw3.getObject(objectId);
    //
    //alert(this.dashboard);
}


org_uengine_essencia_dashboard_Dashboard.prototype={

    getValue : function() {

        //dashboard.alphaInstanceMap['a'].

        return this.dashboard;
    }
};

