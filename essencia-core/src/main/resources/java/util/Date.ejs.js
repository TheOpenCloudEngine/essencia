var java_util_Date = function(objectId, className){
	this.objectId = objectId;
	this.className = className;
	
	this.inputId = mw3.createInputId(objectId);	
	this.divObj = $('#' + this.inputId);
		
	var when = this.divObj.attr('when');
	var format = this.divObj.attr('format');
	
	
	if(when == 'edit' || when == 'new'){
		this.divObj.datepicker({
			monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],		// 월 한글로 출력
			dayNamesMin: ['일','월','화','수','목','금','토'],		// 요일 한글로 출력
		  	dateFormat: format, //데이터 포멧형식
		  	showMonthAfterYear: true
		});	
		
		
		if(mw3.objects[this.objectId] == null || typeof mw3.objects[this.objectId].__className == 'undefined')
			this.divObj.datepicker("setDate", mw3.objects[this.objectId]);
	}else if(when == 'timeago'){
		jQuery("abbr.timeago").timeago();
	}
};

java_util_Date.prototype = {
	getValue : function(){
		var when = this.divObj.attr('when');
		
		if(when == 'edit' || when == 'new'){
			if(mw3.objects[this.objectId] && typeof mw3.objects[this.objectId].__className != 'undefined'){
				var tagId = mw3.createInputId(this.objectId);
				
				var inputTag = document.getElementById(tagId);
				if(inputTag){
					var value = dwr.util.getValue(tagId);
					
					if(value == '')
						return null;
					else
						return value;
				}else{
					return null;
				}
			}else{
				return this.divObj.datepicker("getDate");	
			}
		}else{
			return mw3.objects[this.objectId];
		}
	},
	clear : function(){
		mw3.objects[this.objectId] = null;
		this.divObj.datepicker("setDate", null);
	}
};