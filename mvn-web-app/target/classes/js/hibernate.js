(function (app, $) {
	var app = app || {};
	
	function init() {
		app.hibernate = {
			'cache' : {
				addEmployeeForm : $('.add-employee-form'), 
				addEmployeeBtn  : $('.add-employee'),
				employeeTable   : $('.employee-table'),
				deleteBtn		: $('.delete-btn'),
				editBtn			: $('.edit-btn'),
				modal			: $('.modal'),
				closeModal		: $('.modal-close'),
				employeeArray	: []
			},
			
			'getEmployeeList' : function () {
				var request = $.ajax({
					url : "hibernate-get-employee-list",
					type: "GET"
				}).done(function(data){
					let employeeArray = app.hibernate.cache.employeeArray = JSON.parse(data);
					for (let i = 0; i < employeeArray.length; i++) {
						app.hibernate.cache.employeeTable.append('<tr class="employee-info"><th class="employee-id">' + 
								employeeArray[i].id + '</th><th class="employee-name">' + employeeArray[i].name + '</th><th class="employee-salary">' + 
								employeeArray[i].salary + '</th><th class="employee-deg">' + employeeArray[i].deg + '</th></tr>');
					}
					app.hibernate.cache.employeeTable = $('.employee-table');
					$('.employee-info').click( function() {
						var $this = $(this);
						var id = $this.children().first().html();
						var employeeObject = getEmployeeById(id);
						$(".selected").removeClass("selected");
						$(".user-actions").removeClass("hidden");
						
						$this.addClass("selected");
//						removeEmployeeButtons();
//						addEmployeeButtons();
					});
					
				}).fail(function(dataObj) {
					$("#error-message").html("Status : " + dataObj.statusText + ", Code : " + dataObj.status + 
							"\nError : " + dataObj.responseText);
				});
			},
			
			'addEmployee' : function(formObject){
				var dataObject = {};
				formObject.serializeArray().map(function(x) {
					dataObject[x.name] = x.value;
				});
				var request = $.ajax({
						url: "hibernate-add-employee",
						data: JSON.stringify(dataObject),
						type: "POST"
					}).done(function(data){
						app.hibernate.cache.employeeTable.append('<tr class="employee-info"><th class="employee-id">' + data + '</th><th class="employee-name">' + dataObject.name + '</th><th class="employee-salary">' + dataObject.salary + '</th><th class="employee-deg">' + dataObject.deg + '</th></tr>	');
						employeeArray.push(dataObject);
					}).fail(function(dataObj) {
						$("#error-message").html("Status : " + dataObj.statusText + ", Code : " + dataObj.status + 
								"\nError : " + dataObj.responseText);
					});
			},
			
			'deleteEmployee' : function (dataObject) {
				var request = $.ajax({
					url: "hibernate-delete-employee",
					data: JSON.stringify(dataObject),
					type: "DELETE"
				}).done(function(data){
					
				}).fail(function(dataObj) {
//					$("#error-message").html("Status : " + dataObj.statusText + ", Code : " + dataObj.status + 
//							"\nError : " + dataObj.responseText);
				});
			},
			
			'updateEmployee' : function (dataObject) {
				var request = $.ajax({
					url: "hibernate-edit-employee",
					data: JSON.stringify(dataObject),
					type: "PUT"
				}).done(function(data){
					setEmployee(dataObject);
					updateEmployee(dataObject);
					$('.selected').removeClass('selected');
					$('.modal').addClass('hidden');
				}).fail(function(dataObj) {
//					$("#error-message").html("Status : " + dataObj.statusText + ", Code : " + dataObj.status + 
//							"\nError : " + dataObj.responseText);
				});
			}
		}; 
	}
	
	function initEvents () {
		app.hibernate.cache.addEmployeeForm.submit( function(e) {
			app.hibernate.addEmployee($(this));
		});
		
		app.hibernate.cache.deleteBtn.click( function(e) {
			openModalDialog();
			$('.modal-header-content').html('Delete Employee');
			$('.delete-user-modal').removeClass('hidden');
		});
		
		app.hibernate.cache.editBtn.click( function(e) {
			openModalDialog();
			$('.modal-header-content').html('Edit Employee');
			$('.edit-employee-modal').removeClass('hidden');
			
			var employee = getEmployeeById($('.selected').children().first().html());
			
			$(".modal-id").val(employee.id);
			$(".modal-name").val(employee.name);
			$(".modal-salary").val(employee.salary);
			$(".modal-deg").val(employee.deg);
			
			$(".modal-edit-form").submit( function(e) {
				e.preventDefault();
				$(".modal-id").removeAttr('disabled');
				employee.name = $(".modal-name").val();
				employee.salary = $(".modal-salary").val();
				employee.deg = $(".modal-deg").val();
				app.hibernate.updateEmployee(employee);
			});
			
		});
		
		$('.delete-selected-employee').click( function(e) {
			app.hibernate.deleteEmployee(getEmployeeById($('.selected').children().first().html()));
		});
	}
	
	function openModalDialog() {
		var modal = document.getElementById('myModal'),
			closeBtns = document.getElementsByClassName("modal-close");
		
		modal.style.display = "block";
		
		for (let i = 0; i < closeBtns.length; i++ ){
			closeBtns[i].onclick = function() {
				modal.style.display = "none";
			};
		}
		window.onclick = function(event) {
		    if (event.target == modal) {
		    	modal.style.display = "none";
		    }
		}
	}
	
	function getEmployeeById (id) {
		var employee;
		for ( let i = 0; i < app.hibernate.cache.employeeArray.length; i++) {
			if (app.hibernate.cache.employeeArray[i].id == id){
				employee = app.hibernate.cache.employeeArray[i];
			}
		}
		return employee;
	}
	
	function setEmployee(employee) {
		for ( let i = 0; i < app.hibernate.cache.employeeArray.length; i++) {
			if (app.hibernate.cache.employeeArray[i].id == employee.id){
				app.hibernate.cache.employeeArray[i].name = employee.name;
				app.hibernate.cache.employeeArray[i].salary = employee.salary;
				app.hibernate.cache.employeeArray[i].deg = employee.deg;
			}
		}
	}
	
	function updateEmployee(employee) {
		$('.selected .employee-name').html(employee.name);
	}
	
	$(document).ready( function() {
		init();
		app.hibernate.getEmployeeList();
		initEvents();
	});
	
})(window.app, jQuery);