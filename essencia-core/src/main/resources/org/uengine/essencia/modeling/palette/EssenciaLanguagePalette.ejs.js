var org_uengine_essencia_modeling_palette_EssenciaLanguagePalette = function(objectId, className){
	this.objectId = objectId;
	this.className = className;
	this.object = mw3.objects[this.objectId];
	this.objectDivId = mw3._getObjectDivId(this.objectId);
	this.objectDiv = $('#' + this.objectDivId);
	
	this.objectDiv.css({
		height: '50%',
		overflow: 'auto'
	});
}