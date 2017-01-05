(function(app){
	var app = app || {};
	
	function init(){
		app.jpa = {
			
			cache : {
				addEmployeeForm : $(".add-employee-form")
			},
			
			'addEmployee' : function(formObject) {
				
				var dataObject = {};
				formObject.serializeArray().map(function(x) {
					dataObject[x.name] = x.value;
				});
				var request = $.ajax({
						url: "jpa-add-employee",
						data: JSON.stringify(dataObject),
						type: "POST"
					}).done(function(data){
						console.log(data)
					}).fail(function(dataObj) {
						$("#error-message").html("Status : " + dataObj.statusText + ", Code : " + dataObj.status + 
								"\nError : " + dataObj.responseText);
					});
			},
			
			'findEmployeeById' : function() {
				
			},
			
		};
	}
	
	function initEvents(){
		app.jpa.cache.addEmployeeForm.submit(function(e){
			e.preventDefault();
			
			app.jpa.addEmployee($(this));
		});
	} 
	
	
	$(document).ready(function(){
		init();
		initEvents();
	});
})(window.app);