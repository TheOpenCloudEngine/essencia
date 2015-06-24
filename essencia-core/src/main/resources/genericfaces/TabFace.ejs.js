/*
TabFace.prototype = new ArrayFace();
TabFace.superclass = ArrayFace;
TabFace.prototype.constructor = TabFace;
*/

var TabFace = function(objectId, className){
	this.objectId = objectId;
	this.className = className;
	this.object = mw3.objects[this.objectId];
	this.afterLoad = this.object.__descriptor.getOptionValue("afterLoad");
	
	this.objectDivId = mw3._getObjectDivId(this.objectId);
	this.objectDiv = $('#' + this.objectDivId);

	this.tabTemplate = "<li><a href='#{href}' id='#{ui-id}'>#{label}</a> <span class='ui-icon ui-icon-close' role='presentation'>Remove Tab</span></li>",
	this.tabCounter = this.object.length;
	this.tabCounter++;
	this.tabLoaded = {"0": true};
	this.activeTabIndex = 0;
	
	this.layout = this.objectDiv.addClass('mw3_layout').addClass('mw3_tabs').layout();
	this.tabs = $('#tabs-' + this.objectId).tabs();
	$('#tabs-' + this.objectId).css({'padding':'0 10px 0 10px','background':'none'})

	this.tabs.delegate( "span.ui-icon-close", "click", {objectId: this.objectId}, function(event) {
		var panelId = $( this ).closest( "li" ).attr( "aria-controls" );
		var objectId = $( "#" + panelId ).children(':first').attr('objectId');

		$('#' + mw3._getObjectDivId(objectId)).trigger('close');
	});
	
	$(this.tabs).on("tabsactivate", {objectId: this.objectId}, function(event, ui) {
		var faceHelper = mw3.getFaceHelper(event.data.objectId);
		
		if(ui){
			var index = ui.newPanel.attr('index');
			faceHelper.getLayout().resizeAll();
			faceHelper.activate(index);
			
			if(!faceHelper.isLoaded(index)){
				if(!faceHelper.isLoaded(index))
					faceHelper.load(index, ui.newPanel.selector);
			}

			$(ui.newPanel).find('.mw3_tabs :first').trigger('tabsactivate');
			
			$(ui.newPanel).find('.mw3_refresh').each(function(){
				var objectId = $(this).attr('objectId');
				
				var faceHelper = mw3.getFaceHelper(objectId);
				if(faceHelper && faceHelper.refresh)
					faceHelper.refresh();
			});
		}else{
			var index = faceHelper.getActiveTabIndex();
			faceHelper.activate(index);
		}
		
		
	});
	
	this.getActiveTabIndex = function(){
		return this.activeTabIndex;
	}
	
	this.load = function(index, targetdivId){
		var object = this.object[index];
		$(targetdivId).append(mw3.locateObject(object, object.__className, null, null, {objectId: this.objectId, name: '[' + index + ']'}));
		
		this.callAfterLoadMethod(index);

	}
	this.findAfterLoadMethodName = function(index){
		var metadata = mw3.getMetadata(this.object[index].__className);
		
		if(metadata.serviceMethodContexts){
			for(var i=0; i<metadata.serviceMethodContexts.length; i++){
				var servceMethodContext = metadata.serviceMethodContexts[i];
				
				if(servceMethodContext.childrenLoader)
					return servceMethodContext.methodName;;
			}
		}
		
	}
	
	this.activate = function(index){
		this.activeTabIndex = index;
		this.putKeyMapping(index);
	}
	
	this.putKeyMapping = function(index){
		var object = this.object[index];
		if(object)
			mw3.putObjectIdKeyMappingAll(object.__objectId, object, true);
	}
	
	this.callAfterLoadMethod = function(index){
		this.tabLoaded[index] = true;
		
		mw3.call(this.object[index].__objectId, this.findAfterLoadMethodName(index));
	}
	
	this.isLoaded = function(index){
		if(this.tabLoaded[index])
			return true;
	}
	
	this.closeTab = function(panelId) {
		$( this ).closest( "li" ).remove();
		
		var objectId = $( "#" + panelId ).children(':first').attr('objectId');
		
		$('#tabs-' + this.objectId).find('ul li').filter(function(index){
			if(panelId == $(this).attr("aria-controls"))
				$(this).remove();
		});

		this.tabs.tabs( "refresh" );
		this.layout.resizeAll();
		
		var tabsNav = this.tabs.children();
		if(tabsNav.children().length == 0)
			tabsNav.hide();
	}
	 
	this.getTabs = function(){
		return this.tabs;
	}

	this.getLayout = function(){
		return this.layout;
	}
	
	this.destroy = function(){
		this.layout.destroy();
	}

	this.addTab = function(object){
		var prevObjectId = mw3.objectIndexOf(object);
		if(prevObjectId && mw3.objects[prevObjectId]){
			var metadata = mw3.getMetadata(mw3.objects[prevObjectId].__className);
			if(metadata.keyFieldDescriptor){
				if(object[metadata.keyFieldDescriptor.name]){
					var index = $('#' + mw3._getObjectDivId(prevObjectId)).closest('.ui-tabs-panel').prevAll().length;
					
					this.tabs.tabs('option', 'active', index);
					
					return;					
				}
			}
		}
		
		if(!this.afterLoad)
			this.tabLoaded[this.tabCounter] = true;

		var label = mw3.getObjectNameValue(object, true);
		var id = "tabs-" + this.objectId + '-' + this.tabCounter,
        li = $( this.tabTemplate.replace( /#\{href\}/g, "#" + id ).replace( /#\{label\}/g, label ).replace( /#\{ui-id\}/g, 'ui-id-' + this.tabCounter ) );
		
		this.tabs.find( ".ui-tabs-nav:first" ).append( li );
		this.tabs.find( ".ui-layout-content:first" ).append( "<div id='" + id + "' style='height: 100%' index='" + (this.tabCounter-1) + "'></div>" );
		this.tabs.tabs( "refresh" );
		this.tabs.children().show();
		this.tabs.tabs( "option", "active", this.tabs.find( ".ui-tabs-nav:first li" ).length-1 );
		
		this.tabCounter++;
		
		this.add(id, object);
	}
	
	this.add = function(targetDivId, item){
		var arrayObj = mw3.getObject(this.objectId);
		arrayObj[arrayObj.length] = item;
		
		mw3.locateObject(
				item, 
				item.__className, 
				'#' + targetDivId, 
				null, 
				{
					objectId: this.objectId,
					name: '[' + (arrayObj.length-1).toString() + ']'
				}
		);
	}	
}