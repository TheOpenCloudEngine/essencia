var org_uengine_essencia_dashboard_Dashboard = function(objectId, className) {
    this.objectId = objectId;
    this.className = className;

    debugger;

    var value = mw3.getObject(objectId);

    for(var i = 0; i < 2; i++){
        for(var j =0; j < value.alphas[i].states.length; j++){
            $( "#state-" + i + "-" + j ).droppable({drop: function( event, ui ) {}});
            $( "#state-" + i + "-" + j  ).draggable({ revert: "valid", axis: "y"});
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

