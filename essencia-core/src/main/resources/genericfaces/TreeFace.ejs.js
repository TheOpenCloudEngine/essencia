var TreeFace = function(objectId, className){
	this.objectId = objectId;
	this.className = className;
	this.objectDivId = mw3._getObjectDivId(this.objectId);
	this.objectDiv = $('#' + this.objectDivId);
	
	this.object = mw3.objects[this.objectId];

	if(this.object == null)
		return true;
	
	if('java.util.List' != this.objectDiv.parent().attr('classname'))		
		this.objectDiv.addClass('filemgr-tree').addClass('filemgr-treeFocus')
}