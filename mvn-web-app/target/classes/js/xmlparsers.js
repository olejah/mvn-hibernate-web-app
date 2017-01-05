(function(app, $) {
	
	var app = app || {};
	
	function init() {
		app.xmlParser = {
			form	 : $(".parser-form"),
			parseBtn : $(".parse-btn")
		}
	}
	
	function initEvents(){
		app.xmlParser.parseBtn.on('click', function(){
			$(app.xmlParser.form).attr('action', $('form input[type=radio]:checked').val());
		});
	}
	
	$(document).ready(function(){
		init();
		initEvents();
	});
	
})(window.app, jQuery);