var Record = function(objectId, className){
	this.objectId = objectId;
	this.className = className;
}

Record.prototype = {
	toggleChild : function(element){
		// Checks for display:[none|block], ignores visible:[true|false]
		if($(element).parent().next().is(":visible")){
			$(element).html("+");
		}else{
			$(element).html("-");
		}
		$(element).parent().next().toggle();
	}
}