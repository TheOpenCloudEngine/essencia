var org_uengine_essencia_modeling_editor_EditorTabs = function(objectId, className){
	this.objectId = objectId;
	this.className = className;
	this.object = mw3.objects[this.objectId];
	this.objectDivId = mw3._getObjectDivId(this.objectId);
	this.objectDiv = $('#' + this.objectDivId);
	this.toAppend = function(object){
		var itemsObjectId = mw3.getChildObjectId(this.objectId, 'items');
		var itemsObjectFaceHelper = mw3.getFaceHelper(itemsObjectId);
		
		itemsObjectFaceHelper.addTab(object);
	}
}