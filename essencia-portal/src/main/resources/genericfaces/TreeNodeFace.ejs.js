var TreeNodeFace = function(objectId, className){
	this.objectId = objectId;
	this.className = className;
	this.objectDivId = mw3._getObjectDivId(this.objectId);
	this.objectDiv = $('#' + this.objectDivId);
	this.nodeDiv = this.objectDiv.children('div');
	
	this.object = mw3.objects[this.objectId];

	if(this.object == null)
		return true;

	var metadata = mw3.getMetadata(this.className);
	
	if(metadata.childrenFieldDescriptor)
		this.childFieldName = metadata.childrenFieldDescriptor.name;

	this.containerFieldName = metadata.getFieldNameForFieldDescriptorType('container');
	if(this.containerFieldName){
		if(this.object[this.containerFieldName]){
			if(this.childFieldName && this.object[this.childFieldName] != null && this.object[this.childFieldName].length > 0)
				this.expanded = true;

			if(this.expanded)
				this.nodeDiv.addClass('minlast');
			else
				this.nodeDiv.addClass('plus');
		}
		
		var actionEvent = 'dblclick';
		if( jQuery.browser.mobile )
			actionEvent = 'click';
		
		$(this.objectDiv).bind(actionEvent, {objectId : this.objectId}, function(event){
			mw3.getFaceHelper(event.data.objectId).action();
		});
	}
	
	if(metadata.serviceMethodContexts){
		for(var i=0; i<metadata.serviceMethodContexts.length; i++){
			var servceMethodContext = metadata.serviceMethodContexts[i];
			
			if(servceMethodContext.childrenLoader)
				this.childrenLoaderMethodName = servceMethodContext.methodName;
		}
	}
	
	if(this.objectDiv.hasClass('filemgr-tree'))
		this.nodeDiv.addClass('root');
	
	// add event mouse click
	$(this.objectDiv).bind('click', {objectId : this.objectId}, function(event){
		mw3.getFaceHelper(event.data.objectId).select();
	});
}

TreeNodeFace.prototype = {
	destroy : function() {
		$(this.nodeDiv).unbind('click').unbind('dblclick');
	},
	startLoading : function(){
		mw3.startLoading();
	},

	endLoading : function(){
		this.nodeDiv.removeClass('loading');
		mw3.endLoading();
	},
	
	showStatus : function(message){
		if(this.childrenLoaderMethodName + ' DONE.' == message){
			this.nodeDiv.addClass('minlast');
			this.nodeDiv.removeClass('min');

			if(this.object[this.childFieldName] == null || this.object[this.childFieldName].length == 0)
				this.nodeDiv.removeClass('minlast');
			
			var tree = this.getTree();

			tree.trigger('expanded');
		}
	},
	
	getTree : function(){
		var tree = this.objectDiv;
		
		if(!this.objectDiv.hasClass('filemgr-tree'))
			tree = tree.parentsUntil('.filemgr-tree').parent('.filemgr-tree');
		
		return tree;
	},
	
	select : function(){
		if(event.stopPropagation){
			event.stopPropagation();
		}else if(window.event){
			window.event.cancelBubble = true;
		}

		var tree = this.getTree();
		
		if(!this.nodeDiv.hasClass('selected'))
			tree.trigger('change', [this.objectId]);
		
		
		tree.find('.item-fix.selected').removeClass('selected');
		this.nodeDiv.addClass('selected');
	},
	
	expand : function(){
		this.expanded = true;
		if(this.nodeDiv.hasClass('pluslast')){
			this.nodeDiv.removeClass('pluslast');
			this.nodeDiv.addClass('minlast');
			
			this.objectDiv.children('u').show();
		}else if(this.nodeDiv.hasClass('plus')){
			this.nodeDiv.removeClass('plus');
			this.nodeDiv.addClass('min');

			if(this.childrenLoaderMethodName && this.childFieldName){
				this.nodeDiv.addClass('loading');
				
				mw3.call(this.objectId, this.childrenLoaderMethodName);
			}
		}
	},
	
	collapse : function(){
		if(this.nodeDiv.hasClass('minlast')){
			this.nodeDiv.removeClass('minlast');
			this.nodeDiv.addClass('pluslast');
		}else if(this.nodeDiv.hasClass('min')){
			this.nodeDiv.removeClass('min');
			this.nodeDiv.addClass('plus');
		}
		
		this.expanded = false;
		this.objectDiv.children('u').hide();
		
		var tree = this.getTree();
		
		tree.trigger('collapsed', [this.objectId]);
	},
	
	action : function(){
		if(event.stopPropagation){
			event.stopPropagation();
		}else if(window.event){
			window.event.cancelBubble = true;
		}
		
		this.select();
		
		if(this.expanded)
			this.collapse();
		else
			this.expand();
	},
	
	draggable : function(command){
		this.objectDiv.find('.label-content:first').draggable({
			appendTo: "body",
			helper: function( event ) {
				return $('<div>').addClass('filemgr-tree').append($('<div>').addClass('item').append($(this).clone()));
			},
			zIndex: 100,
			start: function(event, ui) {
				eval(command);
			},
			drag: function() {
			},
			stop: function() {
			}
		});
	}
}