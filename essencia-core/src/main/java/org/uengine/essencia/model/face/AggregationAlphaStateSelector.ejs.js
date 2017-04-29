var org_uengine_essencia_model_face_AggregationAlphaStateSelector = function(objectId, className){
    org_metaworks_component_SelectBox.apply(this, new Array(objectId, className));

    this.objectId = objectId;

}
extend(org_uengine_essencia_model_face_AggregationAlphaStateSelector, "org_metaworks_component_SelectBox");  //equals to extends in java


org_uengine_essencia_model_face_AggregationAlphaStateSelector.prototype = {

    amendFromKernel : function(object, autowiredObjects){

        var alpha = mw3.getClosestObject(this.objectId, "org.uengine.essencia.model.Alpha")
        var canvas = mw3.getAutowiredObject("org.uengine.essencia.modeling.canvas.MethodCanvas")
        var alphaView;
        for(var elemCnt in canvas.elementViewList){
            var elem = canvas.elementViewList[elemCnt];
            if(elem && elem.element && elem.element.name == alpha.name) {
                alphaView = elem;
                break;
            }
        }

        var relationId = alphaView.fromEdge
        var fromAlphaId =
            $("#" + relationId)[0].getAttribute('_from');

        var fromAlphaView;
        for(var elemCnt in canvas.elementViewList){
            var elem = canvas.elementViewList[elemCnt];
            if(fromAlphaId.indexOf(elem.id + "_TERMINAL") >= 0){
                fromAlphaView = elem;

                break;
            }
        }

        var stateNames = [];
        for(var idx in fromAlphaView.element.states){
            stateNames.push(fromAlphaView.element.states[idx].name);
        }

       // console.log(stateNames);

        var object = mw3.objects[this.objectId];
        object.optionNames = stateNames;
        object.optionValues = stateNames;
        object.metaworksContext = {when: 'edit'};

        mw3.setObject(this.objectId, object);

    }

};

