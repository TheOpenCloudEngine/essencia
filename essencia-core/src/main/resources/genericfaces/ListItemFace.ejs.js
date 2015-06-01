var ListItemFace = function(objectId, className){
	this.objectId = objectId;
	this.className = className;
	this.objectDivId = mw3._getObjectDivId(this.objectId);
	this.objectDiv = $('#' + this.objectDivId);
	this.object = mw3.objects[this.objectId];
	
	this.selector = this.objectDiv.find('.mw3_selector');
	
	if(this.selector.length > 0){
		this.objectDiv.bind('click', {objectId: this.objectId}, function(event){
			if($(event.target).hasClass('mw3_selector'))
				mw3.getFaceHelper(event.data.objectId).setValue();
			else
				mw3.getFaceHelper(event.data.objectId).select();
		});
	}
}

ListItemFace.prototype = {
	setValue: function(){
		var selectField = this.selector.attr('selectField');
		var selectedValue = this.selector.attr('selectedValue');

		if(!this.selector.attr('mw3_checked')){
			this.selector.attr('mw3_checked', true);
		}else{
			selectedValue = null;
			this.selector.attr('mw3_checked', false);
		}
		
		var pos = selectField.indexOf('metaworksContext.');
		if(pos == 0){
			if(this.object && this.object.metaworksContext){
				var metaworksContext = mw3.clone(this.object.metaworksContext)
				
				metaworksContext[selectField.substring('metaworksContext.'.length)] = selectedValue;
				this.object.metaworksContext = metaworksContext;
			}
		}else{
			if(this.object)
				this.object[selectField] = selectedValue;
		}
	},
	select: function(){
		this.selector.trigger('click');
		
	}
}