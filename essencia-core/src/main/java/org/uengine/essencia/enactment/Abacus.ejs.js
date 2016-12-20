var org_uengine_essencia_enactment_Abacus = function(objectId, className){
    this.object = mw3.objects[objectId];
}

org_uengine_essencia_enactment_Abacus.prototype = {

    editStateInstance: function(alphaName, stateName){
        this.object.stateInstanceEditor = {
            __className: 'org.uengine.essencia.enactment.StateInstanceEditor',
            targetAlphaName: alphaName,
            targetStateName: stateName
        };

        this.object.editStateInstance();
    }

}