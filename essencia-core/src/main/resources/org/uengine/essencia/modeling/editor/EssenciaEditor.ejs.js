var org_uengine_essencia_modeling_editor_EssenciaEditor = function(objectId, className){
	this.objectId = objectId;
	this.className = className;
	this.object = mw3.objects[this.objectId];
	this.objectDivId = mw3._getObjectDivId(this.objectId);
	this.objectDiv = $('#' + this.objectDivId);

	this.tabs = this.objectDiv.closest('.ui-tabs');
	this.tabs.attr('keep', true);
	
	var layoutOption = {north__size: '50', togglerLength_open: 0, spacing_open: 0, spacing_closed: 0};

	this.layout = this.objectDiv.addClass('mw3_layout').addClass('mw3_editor').layout(layoutOption);
	
	this.getName = function(){
		return mw3.getValueForFieldDescriptor(this.object, 'name');
	}
	
	this.updateName = function(){
		var name = this.getName();
		
		var label = name;
		
		if(label.length > 15){
			label = label.substring(0, 15) + '...';
		}
		
		if(this.object.changed){
			if(label.indexOf('*') == -1)
				label = '*' + label;
		}
		
		$('#' + this.objectDiv.closest('.ui-tabs-panel').attr('aria-labelledby')).html(label);
		$('#' + this.objectDiv.closest('.ui-tabs-panel').attr('aria-labelledby')).attr('title', name);
	}
	
	this.destroy = function(){
		this.layout.destroy();
		if(this.tabs.attr('keep') == 'false'){
			var tabId = this.tabs.attr('objectId');
			var tabPanelId = this.objectDiv.closest( ".ui-tabs-panel" ).attr("id");
	
			mw3.getFaceHelper(tabId).closeTab(tabPanelId);
		}
	}
	
	this.change = function(){
		if(!this.object.changed){
			this.object.changed = true;
						
			this.updateName();
		}
		this.syncable = true;
	}
	
	this.sync = function(){

		//TODO: should be restored
		//if(this.syncable){
			this.syncable = false;
			
			var modelerEditor = mw3.getAutowiredObject('org.uengine.essencia.modeling.editor.ModelerEditor');
			this.objectDiv.trigger('sync');
		//}
	}
	
	//this.checkIn = function(){
	//	if(this.object.changed)
	//		this.confirmChanged(
	//			'체크인',
	//			function(){
	//				mw3.call($(element).data('objectId'), 'checkIn');
	//			},
	//			function(){
	//				mw3.call($(element).data('objectId'), 'saveAndCheckIn');
	//			}
	//		);
	//	else
	//		mw3.call(this.objectId, 'checkIn');
	//}
	
	this.closeTab = function(){
		this.tabs.attr('keep', false);
		mw3.removeObject(this.objectId);
	}
	
	this.close = function(){
		if(this.object.changed)
			this.confirmChanged(
					'닫기',
					function(element){
						mw3.getFaceHelper($(element).data('objectId')).closeTab();
						
					}, 
					function(element){						
						mw3.call($(element).data('objectId'), 'save');
						mw3.getFaceHelper($(element).data('objectId')).closeTab();
					}
				);
		else
			this.closeTab();
	}
	
	this.confirmChanged = function(title, callbackNoFunc, callbackYesFunc){
		var confirmContinue = $('<div>');
		confirmContinue.attr('title', title)
					   .append(
							   $('<p>').append(
									   $('<span>').addClass('ui-icon ui-icon-alert')
									   	          .css({float: 'left', margin: '0 7px 20px 0;'}))
							           .append('\'' + this.getName() + '\' 는 수정되었습니다.<br>')
							   		   .append('변경된 사항을 저장하시겠습니까?')
					   );
		
		confirmContinue
			.data('objectId', this.objectId)
			.dialog({
				resizable: false,
				height:170,
				modal: true,
				buttons: {
					"아니오": function() {
						$( this ).dialog( "close" );		
						callbackNoFunc(this);
					},
					"취소": function() {
						$( this ).dialog( "close" );
					},
					"예": function() {
						$( this ).dialog( "close" );
						callbackYesFunc(this);
					},
			}
	    });
	}
	
	this.objectDiv.bind('change', {objectId: this.objectId}, function(event, ui){
		event.stopPropagation();
		event.preventDefault();

		mw3.getFaceHelper(event.data.objectId).change();
	});
	
	this.objectDiv.bind('tabsactivate', {objectId: this.objectId}, function(event, ui){
		event.stopPropagation();
		event.preventDefault();
		
		mw3.getFaceHelper(event.data.objectId).sync();
	});
	
	//this.objectDiv.bind('check_in', {objectId: this.objectId}, function(event, ui){
	//	event.stopPropagation();
	//	event.preventDefault();
	//
	//	mw3.getFaceHelper(event.data.objectId).checkIn();
	//});
	
	
	this.objectDiv.bind('close', {objectId: this.objectId}, function(event, ui){
		event.stopPropagation();
		event.preventDefault();
		
		mw3.getFaceHelper(event.data.objectId).close();
	});
	
	this.updateName();
}