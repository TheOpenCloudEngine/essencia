var org_uengine_essencia_model_view_StateView = function(objectId, className){
    org_uengine_modeling_ElementView.apply(this, new Array(objectId, className));

    this.objectId = objectId;

}
extend(org_uengine_essencia_model_view_StateView, "org_uengine_modeling_ElementView");  //equals to extends in java


org_uengine_essencia_model_view_StateView.prototype = {

    showProperty: function (object, autowiredObjects) {

        var stateView = mw3.objects[this.objectId];
        var stateDetailRefresh = {
            __className: 'org.metaworks.Refresh',
            target: {
                __className: 'org.uengine.essencia.model.card.StateDetail',
                state: stateView.element
            }
        };

        return stateDetailRefresh;
    },

    showPropertyWhenView: function (object, autowiredObjects) {
        return this.showProperty(object, autowiredObjects);
    }
};
