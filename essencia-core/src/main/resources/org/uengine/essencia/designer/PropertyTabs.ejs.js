var org_uengine_essencia_designer_PropertyTabs = function(objectId, className){
	this.objectId = objectId;
	this.className = className;
	this.object = mw3.objects[this.objectId];
	this.objectDivId = mw3._getObjectDivId(this.objectId);
	this.objectDiv = $('#' + this.objectDivId);
	
	this.layout = this.objectDiv.addClass('mw3_layout').layout();
	
	this.destroy = function(){
		this.layout.destroy();
	}
}


//var org_uengine_essencia_designer_PropertiesTabs = function(objectId, className){
//	this.objectId = objectId;
//	this.className = className;
//	this.object = mw3.objects[this.objectId];
//	this.objectDivId = mw3._getObjectDivId(this.objectId);
//	this.objectDiv = $('#' + this.objectDivId);
//	
//	this.layout = this.objectDiv.addClass('mw3_layout').layout();
//	
//	this.objectDiv.children('.ui-layout-center').css({
//		'height': this.objectDiv.children('.ui-layout-center').height()-100 
//	});
//
//	this.objectDiv.find('.ui-layout-center .ui-layout-content').css({
//		'border-bottom': '1px solid #000'
//	});
//	
//	this.destroy = function(){
//		this.layout.destroy();
//	}
//}