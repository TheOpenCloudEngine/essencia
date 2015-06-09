var org_uengine_essencia_modeling_editor_ModelerEditor = function(objectId, className){
	this.objectId = objectId;
	this.className = className;
	this.object = mw3.objects[this.objectId];
	this.objectDivId = mw3._getObjectDivId(this.objectId);
	this.objectDiv = $('#' + this.objectDivId);

	this.tabs = this.objectDiv.closest('.ui-tabs');
	
	this.objectDiv.addClass('mw3_activate');
	
	this.activate = function(){
		mw3.putObjectIdKeyMappingAll(this.objectId, mw3.objects[this.objectId], true);
	}
	
	var layoutOption = {north__size: '100', togglerLength_open: 0, spacing_open: 0, spacing_closed: 0};

	this.layout = this.objectDiv.addClass('mw3_layout').addClass('mw3_editor').layout(layoutOption);
	
	this.startLoading = function(methodName){
		if('destroy' == methodName){
			this.tabs.attr('keep', false);
		}else{
			this.tabs.attr('keep', true);
		}
	}
	
	this.destroy = function(){
		this.layout.destroy();
		if(this.tabs.attr('keep') == 'false'){
			var tabId = this.tabs.attr('objectId');
			var tabPanelId = this.objectDiv.closest( ".ui-tabs-panel" ).attr("id");
	
			mw3.getFaceHelper(tabId).closeTab(tabPanelId);
		}
	}
}