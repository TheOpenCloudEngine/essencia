var org_metaworks_website_AbstractMetaworksFile = function(objectId, className){
	this.objectId = objectId;
	this.className = className;
	this.fileChangeListeners = [];

	var faceHelper = this;
	var object = mw3.objects[this.objectId];

	$("#objDiv_" + this.objectId).attr("objectId", this.objectId);

	this.reset();
	
	if(object && object.uploadedPath){
		$("#filebtnadd_" + this.objectId).css('display', 'none');
		if(object.filename){
			faceHelper.setFilename(faceHelper.extraFilename(object.filename));
		}else{
			faceHelper.setFilename(faceHelper.extraFilename(object.uploadedPath));
		}
		var imageDiv = $("#image_" + this.objectId);
		
		if(imageDiv.length > 0){
			$("#convertProgress_" + objectId).show();
			try {
				var image = object.downloadImage(false);				
				var width = 0;
				var height = 0;
				var parentwidth = $("#image_" + this.objectId).parent().width();
				
//				imageDiv.html('<img style=\"display:none;\" src=\'' + image + '\'>').attr("href","javascript:mw3.objects[" + objectId + "].download()");
				imageDiv.html('<img style=\"display:none;\" src=\'' + image + '\'>');
				
				if(object.__descriptor){
					width = object.__descriptor.getOptionValue('width');
					height = object.__descriptor.getOptionValue('height');
					
					$("#objDiv_" + this.objectId).css('width',width+'px').css('height',height+'px');
				}
				
				if(image == null){
					if(console) console.log('org_metaworks_website_AbstractMetaworksFile : not found image(' + object.uploadedPath + ')');
					$("#convertProgress_" + objectId).hide();
					imageDiv.html('<img style=\"display:none;\" src=\"images/waveStyle/notfound.png\">');
				}
				
				imageDiv.find('img').load(function(){
					if($(this).width() > parentwidth){
						$(this).width("100%");
					}
					$("#convertProgress_" + objectId).hide();
					$(this).show();
				});
			}catch(e){
				
			}
		}	
	}
}

org_metaworks_website_AbstractMetaworksFile.prototype.extraFilename = function(filepath){
	
	var pos = filepath.lastIndexOf('\\');
	if(pos > 0)
		filepath = filepath.substring(pos + 1);
	
	pos = filepath.lastIndexOf('/');	
	if(pos > 0)
		filepath = filepath.substring(pos + 1);

	return filepath;

}

org_metaworks_website_AbstractMetaworksFile.prototype.setFilename = function(filename){

	var object = mw3.objects[this.objectId];
	
	object.filename = filename;
	if(filename == null){
		filename = '선택된 파일 없음';
		$("#filebtnadd_" + this.objectId).css('display', 'block');
		$("#filebtndel_" + this.objectId).css('display', 'none');
		$("#filebtndownload_" + this.objectId).css('display', 'none');
	} else {
		$("#filebtnadd_" + this.objectId).css('display', 'none');
		$("#filebtndel_" + this.objectId).css('display', 'block');
		
		if(object.uploadedPath)
			$("#filebtndownload_" + this.objectId).css('display', 'block');
	}
	
	$("#filename_" + this.objectId).html(filename);
	
	for(var i=0; i<this.fileChangeListeners.length; i++){
		var listner = this.fileChangeListeners[i];
		listner(object);
	}
	
};

org_metaworks_website_AbstractMetaworksFile.prototype.addFileChangeListener = function(listener){
	this.fileChangeListeners[this.fileChangeListeners.length] = listener;
};

org_metaworks_website_AbstractMetaworksFile.prototype.showStatus = function(message){
	if('upload DONE.' == message){
		$("#objDiv_" + this.objectId).triggerHandler('uploaded');
	}
};

org_metaworks_website_AbstractMetaworksFile.prototype.reset = function(){
	var fileTransfer = mw3.getInputElement(this.objectId, 'fileTransfer');
	$(fileTransfer).unbind('change');

	if(fileTransfer)
		fileTransfer.parentNode.innerHTML = fileTransfer.parentNode.innerHTML;
	
	fileTransfer = mw3.getInputElement(this.objectId, 'fileTransfer');
	$(fileTransfer).bind('change', {objectId: this.objectId}, function(event){
		event.stopPropagation();
		event.preventDefault();
		
		var object = mw3.objects[event.data.objectId];
		var faceHelper = mw3.getFaceHelper(event.data.objectId);
		
		if(object.auto)
			object.upload();
		else
			faceHelper.setFilename(faceHelper.extraFilename(this.value));
			
	});		
}

org_metaworks_website_AbstractMetaworksFile.prototype.add = function(event){
	$(mw3.getInputElement(this.objectId, 'fileTransfer')).trigger(event);
}


org_metaworks_website_AbstractMetaworksFile.prototype.del = function(event){
	var object = mw3.objects[this.objectId];
	
	if(object.uploadedPath){
		object.deletedPath = object.uploadedPath;
		
		if(object.auto)
			mw3.call(this.objectId, 'remove');
		else{
			$("#filebtndel_" + this.objectId).css('display', 'none');
			$("#filebtnadd_" + this.objectId).css('display', 'block');
			
			this.reset();
			this.setFilename(null);
		}
	}else{
		this.reset();
		this.setFilename(null);

	}
}

org_metaworks_website_AbstractMetaworksFile.prototype.download = function(){		
	mw3.call(this.objectId, 'download');
}
org_metaworks_website_AbstractMetaworksFile.prototype.getImage = function(){		
	mw3.call(this.objectId, 'download');
}
