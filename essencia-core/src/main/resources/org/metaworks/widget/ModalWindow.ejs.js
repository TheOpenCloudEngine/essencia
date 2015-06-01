var org_metaworks_widget_ModalWindow = function(objectId, className) {
	this.objectId = objectId;
	this.className = className;
	this.divId = '#objDiv_' + objectId;

	$('.mw3_layout').attr('fixed_size', true);
	
	this.openerId = mw3.recentOpenerObjectId[mw3.recentOpenerObjectId.length - 1];
	this.object = mw3.objects[this.objectId];

	if(this.object){
		var title = this.object.title;
		
		if (title == null){
			var metadata = mw3.getMetadata(this.className);
			
			title = metadata.displayName;
		}
	
		title = mw3.localize(title);
		
		if(this.object.metaworksContext && this.object.metaworksContext.where == 'mobile'){
			var modal = $(this.divId);			
			var popup = modal.parent();
			
			var header = '<div data-role=\"header\" data-theme=\"d\"><h1>' + title + '</h1></div>';			
 			
			modal.attr('data-role', 'content');
			modal.attr('data-theme', 'c');			
			
			popup.attr('id', 'dialog_' + this.objectId);
			popup.attr('data-role', 'dialog');
			popup.prepend(header);
			
			$.mobile.changePage('#dialog_' + this.objectId);
		}else{ 
			if (this.object.open) {		
				var options = {};
		
				options['title'] = title;
				options['modal'] = true;
				options['close'] = function(event, ui) {
					mw3.getFaceHelper(objectId).close();
				};
		
				var width = "";
				var height = "";
				
				if(this.object.panel.metaworksContext != null && this.object.panel.metaworksContext.how == "dynamicSize"){
					width = $(window).width() * this.object.width / 100;
					height = $(window).height() * this.object.height / 100;
				} else {
					width = this.object.width;
					height = this.object.height;
					var body_width = $(window).width();
					var body_height = $(window).height();
					
					if(!width || width > body_width - 20)
						width = body_width - 20;
					
					if(!height || height > body_height - 20)
						height = body_height - 20;
				}

				options['width'] = width;
				options['height'] = height;
				
				options['resizable'] = this.object.resizable;	
				
				var openerId = this.openerId;
				
				var buttons = [];
				for(var button in this.object.buttons){
					var action = this.object.buttons[button];
					buttons.push({text: mw3.localize(button), 'data.action':action, 'data.button':button, click: function(event){						
						var action = $(event.currentTarget).attr('data.action');
						var button = $(event.currentTarget).attr('data.button');
						
						if(action){					
							if(mw3.objects[objectId].panel && mw3.objects[objectId].panel.__objectId)
								mw3.call(mw3.objects[objectId].panel.__objectId, action, false, true);					
						}
						
						if(button){
							if(mw3.objects[objectId].callback && mw3.objects[objectId].callback[button])
								mw3.call(mw3.recentOpenerObjectId[mw3.recentOpenerObjectId.length - 1], mw3.objects[objectId].callback[button]);
						}
							
						mw3.getFaceHelper(objectId).close();
					}});
				}
				
				options['buttons'] = buttons;
				
				$("#dialog:ui-dialog").dialog("destroy");
				$(this.divId).dialog(options);
				$(this.divId).css({
					/*'margin-top' : '2px'*/
					})
					.parent().css({
					'box-shadow' : '2px 2px 5px #888'
				}).addClass('mw3_window').attr('objectId', objectId);;
				
				//$(this.divId).dialog(options).css('height', '100%');
			} else {
				$(this.divId).css('display', 'none');
			}
		}
	};
	
	this.destroy = function() {
		$('#objDiv_' + this.objectId).parent().empty();
		
		setTimeout(function(){
			$('.mw3_layout').attr('fixed_size', false);
		},500);
	};

	this.close = function() {
		mw3.removeObject(this.objectId);
	};

	this.setTitle = function(title){
		$('#ui-dialog-title-objDiv_' + this.objectId).html(title);
	};
	
	/*
	this.prototype.startLoading = function() {
		$('#loader_' + this.objectId).show();
	};

	this.prototype.endLoading = function() {
		$('#loader_' + this.objectId).hide();
	};
	*/
	
}