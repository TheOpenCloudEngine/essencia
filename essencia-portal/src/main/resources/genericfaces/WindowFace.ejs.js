var WindowFace = function(objectId, className){
	this.objectId = objectId;
	this.className = className;
	this.object = mw3.objects[this.objectId];
	this.objectDivId = mw3._getObjectDivId(this.objectId);
	this.objectDiv = $('#' + this.objectDivId);
	
	this.metadata = mw3.getMetadata(this.className)
	var widthField = this.metadata.getFieldNameForFieldDescriptorType('width');
	if(widthField)
		this.objectDiv.css('width', this.object[widthField]);
	
	var heightField = this.metadata.getFieldNameForFieldDescriptorType('height');
	if(heightField)
		this.objectDiv.css('height', this.object[heightField])
}