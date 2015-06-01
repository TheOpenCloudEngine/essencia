var org_uengine_essencia_Loader = function(objectId, className){
	this.objectId = objectId;
	this.className = className;
	this.objectDivId = mw3._getObjectDivId(this.objectId);
	this.objectDiv = $('#' + this.objectDivId);
	
	this.object = mw3.objects[this.objectId];

	if(this.object == null)
		return true;	
};

org_uengine_essencia_Loader.prototype = {
	loaded : function(){
		/*if(this.object.key == 'logout'){
			this.object.logout();
		}else */if(this.object.key == 'login')
			this.object.login();
	} 
};
