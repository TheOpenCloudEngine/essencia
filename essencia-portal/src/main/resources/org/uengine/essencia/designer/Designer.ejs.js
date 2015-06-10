var org_uengine_essencia_designer_Designer = function(objectId, className){
	this.objectId = objectId;
	this.className = className;
	this.object = mw3.objects[this.objectId];
	this.objectDivId = mw3._getObjectDivId(this.objectId);
	this.objectDiv = $('#' + this.objectDivId);
	
	var layoutOption = {east__size: '300', togglerLength_open: 0, spacing_open: 5, spacing_closed: 5};
	this.layout = this.objectDiv.addClass('mw3_layout').layout(layoutOption);
	  
	
	this.destroy = function(){
		this.layout.destroy();
	}
}