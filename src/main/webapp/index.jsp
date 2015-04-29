<html class="sidebar-large">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Essencia Web UI</title>
			
		<!-- metaworks3 for ie7(json2) -->
		<script type="text/javascript" src="dwr/metaworks/scripts/json/json2.js"></script>
		
		<!-- metaworks3 for dwr engine -->
		<script type='text/javascript' src='dwr/engine.js'></script>
		<script type='text/javascript' src='dwr/util.js'></script>
		<script type='text/javascript' src='dwr/interface/Metaworks.js'></script>
		
		<!-- metaworks3 for jQuery -->
		<script type="text/javascript" src="lib/jquery-1.11.1/jquery-1.11.1.min.js"></script>
		
		<!-- metaworks3 for keyboard mapping -->
		<script type="text/javascript" src="dwr/metaworks/scripts/event/shortcut.js"></script>
		
		<!-- metaworks3 for context menu, import YUI -->
		<!-- 
		<link rel="stylesheet" type="text/css" href="dwr/metaworks/style/menu/reset.css">
		-->
		<link rel="stylesheet" type="text/css" href="dwr/metaworks/style/menu/container.css">
		<link rel="stylesheet" type="text/css" href="dwr/metaworks/style/menu/sam/menu.css">
		
		<script type="text/javascript" src="dwr/metaworks/scripts/yui-3.2.0-min.js"></script>
		<script type="text/javascript" src="dwr/metaworks/scripts/yui/build/utilities/utilities.js"></script>
		<script type="text/javascript" src="dwr/metaworks/scripts/yui/build/container/container.js"></script>
		<script type="text/javascript" src="dwr/metaworks/scripts/yui/build/menu/menu.js"></script>
		 
		<!-- metaworks3 for ejs templete engine -->
		<script type="text/javascript" src="dwr/metaworks/scripts/ejs/ejs_production.js"></script>
		<script type="text/javascript" src="dwr/metaworks/scripts/ejs/ejs_debugger.js"></script>
		<script type="text/javascript" src="dwr/metaworks/scripts/ejs/view.js"></script>
		
		<!-- metaworks3 engine -->
		<script type="text/javascript" src="dwr/metaworks/scripts/metaworks.js"></script>
		
		<script type="text/javascript" src="lib/jquery-ui-1.11.0.custom/jquery-ui.js"></script>
		<script type="text/javascript" src="lib/jquery/jquery.layout-latest.js"></script>
		
		<link rel="stylesheet" type="text/css" href="lib/jquery-ui-1.11.0.custom/jquery-ui.min.css" />
		
		<script type="text/javascript" src="lib/jquery/jquery.contextMenu.js"></script>
		
		<script type="text/javascript" src="lib/opengraph/OpenGraph-0.1-SNAPSHOT.js"></script>
		
		<!-- init -->
		<link rel="stylesheet" type="text/css" href="style/tree.css" />
		<link rel="stylesheet" type="text/css" href="style/palette.css" />
		<link rel="stylesheet" type="text/css" href="style/login.css" />
				
	    <script type="text/javascript" src="dwr/metaworks/org/uengine/modeling/ElementView.ejs.js"></script>
	    <script type="text/javascript" src="dwr/metaworks/org/uengine/kernel/designer/ui/ActivityView.ejs.js"></script>
	    
	     <!-- ##STYLE -->
	    
	    <!-- BEGIN DATEPICKER -->
		<link href="assets/plugins/datetimepicker/jquery.datetimepicker.css" rel="stylesheet">
	    <link href="assets/plugins/pickadate/themes/default.css" rel="stylesheet">
	    <link href="assets/plugins/pickadate/themes/default.date.css" rel="stylesheet">
	    <link href="assets/plugins/pickadate/themes/default.time.css" rel="stylesheet">
			
	    <!-- END MANDATORY SCRIPTS -->
	    <!-- BEGIN PAGE LEVEL SCRIPTS -->
	    <!--
	    <script src="assets/plugins/datetimepicker/jquery.datetimepicker.js"></script>
	    <script src="assets/plugins/bootstrap-datepicker/bootstrap-datepicker.js"></script>
	    <script src="assets/plugins/pickadate/picker.js"></script>
	    <script src="assets/plugins/pickadate/picker.date.js"></script>
	     -->
		<!-- END DATEPICKER -->
		
		<!-- BEGIN MANDATORY STYLE -->
	    <link href="assets/css/icons/icons.min.css" rel="stylesheet">
	    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
	    <link href="assets/css/plugins.css" rel="stylesheet">
	    <link href="assets/css/style.min.css" rel="stylesheet">
	    <link href="#" rel="stylesheet" id="theme-color">
	    <!-- END  MANDATORY STYLE -->
	    
	    <!-- BEGIN PAGE LEVEL STYLE -->
	    <link href="assets/plugins/fullcalendar/fullcalendar.css" rel="stylesheet">
	    <link href="assets/plugins/metrojs/metrojs.css" rel="stylesheet">
	    
	    <!-- END PAGE LEVEL STYLE -->
	    <script src="assets/plugins/modernizr/modernizr-2.6.2-respond-1.1.0.min.js"></script>
	    
	    <link rel="stylesheet" href="assets/plugins/jnotify/jNotify.jquery.css">
	    
	    <!-- BEGIN MANDATORY SCRIPTS -->
	    <script src="assets/plugins/bootstrap/bootstrap.min.js"></script>
	    <script src="assets/plugins/mcustom-scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
	    <script src="assets/plugins/nprogress/nprogress.js"></script>
	    <script src="assets/plugins/breakpoints/breakpoints.js"></script>
	    <script src="assets/plugins/jquery.cookie.min.js" type="text/javascript"></script>
	    <!-- END MANDATORY SCRIPTS -->
	    
	    
	    
	    <script src="assets/js/application.js"></script>
	    <!-- ##STYLE -->
	   
    
		<style>
			html,
			body {
				width: 100%;
				height: 100%;
				padding: 0;
				margin: 0;
				overflow: hidden; /* when page gets too small for container min-width/height */
			}
			.mw3_layout {
				min-height: 10px;
				min-width: 10px;
				position: absolute;
				top: 0px;	/* margins in pixels */
				bottom: 0px;	/* could also use a percent */
				left: 0px;
				right: 0px;
			}
			
			.form-page.readonly .controls {
				border-bottom: 1px solid #eeeeee;
				padding-top: 10px;
				color: #999;
			}
			.form-page.view .controls {
				border-bottom: 1px solid #eeeeee;
				padding-top: 10px;
				color: #999;
			}
		</style>
		
		<script type="text/javascript">
		jQuery.browser = {};
		(function () {
		    jQuery.browser.msie = false;
		    jQuery.browser.version = 0;
		    if (navigator.userAgent.match(/MSIE ([0-9]+)\./)) {
		        jQuery.browser.msie = true;
		        jQuery.browser.version = RegExp.$1;
		    }
		    
		    if( /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent) )
		    	jQuery.browser.mobile = true;
		})();		
		
		var Request = function() {
			this.getParameter = function(name) {
				var rtnval = "";
				var nowAddress = unescape(location.href);
				var parameters = (nowAddress.slice(nowAddress.indexOf("?") + 1,
						nowAddress.length)).split("&");

				for ( var i = 0; i < parameters.length; i++) {
					var varName = parameters[i].split("=")[0];
					if (varName.toUpperCase() == name.toUpperCase()) {
						rtnval = parameters[i].split("=")[1];
						break;
					}
				}
				return rtnval;
			}
		}
		
				$(document).ready(function() {
					mw3.setWhen(mw3.WHEN_VIEW);
					mw3.template_error = function(e, actualFace) {
			 			if( this.getFaceHelper(objId) && this.getFaceHelper(objId).endLoading)
							this.getFaceHelper(objId).endLoading();	
						else
							mw3.endLoading(objId);
						
							try{mw3.endLoading(objId);}catch(x){}

							
						if(e.lineNumber){
							if(e.lineText)
								var message = "["+actualFace+"] at line "+e.lineNumber+": "+e.lineText+": "+e.message;
							else
								var message = "["+actualFace+"] at line "+e.lineNumber+": "+e.message;
						}else
							var message = "["+actualFace+"] "+e.message;
					
						if(console){
							console.log('template_error');
							console.log(message);
							console.log(e);
						}
			 		};
			 		mw3.showError = function(objId, message, methodName){
			 			if( this.getFaceHelper(objId) && this.getFaceHelper(objId).endLoading)
							this.getFaceHelper(objId).endLoading();	
						else
							mw3.endLoading(objId);
						
							try{mw3.endLoading(objId);}catch(x){}
					
			 			var html = '<div id=\"jError\" style=\"right: 10px; bottom: 10px; min-width: 250px; opacity: 1;\"><i class=\"fa fa-frown-o\" style=\"padding-right: 6px;\"></i>' + message + '</div>';
			 			
			 			$('body').prepend(html);
			 			$('#jError').one('click', function(event){
			 				$(this).remove();
			 			});
			 		};
			 		
			 		mw3.showInfo = function(objId, message){
			 		};
			 		
			 		mw3.startLoading = function(){
			 			$('body').prepend('<div id=\"mw3_progress\" style=\"position:absolute; z-index:9999999; top:50%; left:50%; margin-top:-90px; margin-left:-60px;\"><div id=\"info_div_box\"><img src=\"images/loading.gif\"></div></div>');
			 		};
			 		mw3.endLoading = function(){
			 			setTimeout(function(){
			 				$('#mw3_progress').remove();
			 			}, 100);	
			 		};
			 		
			 		mw3.showValidation = function(objId, inputObjectId, result, message){
			 			if(!result){
			 				var html = '<div id=\"jNotify\" style=\"right: 10px; bottom: 10px; min-width: 250px; opacity: 1;\"><i class=\"fa fa-frown-o\" style=\"padding-right: 6px;\"></i>' + message + '</div>';
				 			
				 			$('body').prepend(html);
				 			
				 			$('#jNotify').fadeOut(5000);
				 			setTimeout(function(){
				 				$('#jNotify').remove();
				 			}, 5000);				 			
			 			}
			 		};
			 		
			 		mw3.getMessage = function(key, defaultValue){
			 			var localeHandler = mw3.getAutowiredObject("org.uengine.essencia.i18n.Locale");
			 			
			 			if(localeHandler!=null && localeHandler.resourceBundle != null){		 				
			 				var message = localeHandler.resourceBundle[key];		 				
			 				if(message)
			 					return message;
			 			}
			 			
			 			if(defaultValue)
			 				return defaultValue;
			 			
			 			return key;		
			 		}
			 		
			 		var request = new Request();
			 		var userId = request.getParameter("userId")!=null?request.getParameter("userId"):""; 
			 		var runner = new MetaworksObject({
    	                __className : "org.uengine.essencia.Loader",
    	                userId : userId
            	    }, 'body');			 		
					runner.run();
					
					window.onbeforeunload= function(){
						return '이 페이지를 벗어나면 저장하지 않은 정보들이 손실될 수 있습니다.';
					};
					
			 		mw3.onLoadFaceHelperScript();
				});
				
		</script>		
	</head>
	<body  data-page="typography">

	</body>
</html>
