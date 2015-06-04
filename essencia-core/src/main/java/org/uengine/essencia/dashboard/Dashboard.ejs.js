var org_uengine_essencia_dashboard_Dashboard = function(objectId, className) {
    this.objectId = objectId;
    this.className = className;

    this.dashboard = mw3.getObject(objectId);

alert(this.dashboard);
}


org_uengine_essencia_dashboard_Dashboard.prototype={

    getValue : function() {

        //dashboard.alphaInstanceMap['a'].

        return this.dashboard;
    }
};
