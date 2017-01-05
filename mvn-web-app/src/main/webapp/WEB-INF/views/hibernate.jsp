<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="resources/css/hibernate.css" />
	<script type="text/javascript" src="resources/js/lib/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="resources/js/hibernate.js"></script>
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Hibernate implementation</title>
	
</head>
<body>
<h1>Hibernate implementation</h1>

	<table class="employee-table">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Salary</th>
			<th>Position</th>
		</tr>
	</table>
	
	<form class="add-employee-form" method="POST">
		<input class="employee-name" pattern="[a-zA-z]+" type="text" placeholder="Name" name="name" required/></br>
		<input class="employee-salary" type="number" min="0" step="0.1" placeholder="Salary" name="salary" required/></br>
		<input class="employee-deg" pattern="[A-za-z]+" type="text" placeholder="Position" name="deg" required/></br>
		<input class="add-employee" type="submit" value="Add Employee"/>
	</form>

	<div class="delete-employee" hidden>
		<p class="selected-employee">Delete selected employee: </p>
	</div>
		
	<div id="error-message" >
		
	</div>
	
	<div class="user-actions hidden">
		Actions for selected user
		<button class="employee-btn delete-btn" >Delete</button>
		<button class="employee-btn edit-btn" >Edit</button>
	</div>
	
	<!-- The Modal -->
	<div id="myModal" class="modal">
	
	  <!-- Modal content -->
	  <div class="modal-content">
	    <div class="modal-header">
	      <span class="modal-close">&times;</span>
	      <h2 class="modal-header-content"></h2>
	    </div>
	    <div class="modal-body">
	      
	      <div class="hidden delete-user-modal">
	      	<p>Are you sure you want to delete this user?</p>
	      	<div class="user-to-delete"></div>
	      	<button class="modal-btn delete-selected-employee">Yes</button>
	      	<button class="modal-btn modal-close">No</button>
	      </div>
	      
	      <div class="hidden edit-employee-modal">
	      	<form class="modal-edit-form">
	      		<label for="id" >Id</label>
	      		<input class="modal-id" type="number" name="id" disabled/></br>
	      		
	      		<label for="name" >Name</label>
	      		<input class="modal-name" pattern="[a-zA-z]+" type="text" name="name" /></br>
	      		
				<label for="salary" >Salary</label>
				<input class="modal-salary" type="number" min="0" step="0.1" name="salary" /></br>
				
				<label for="deg" >Position</label>
				<input class="modal-deg" pattern="[A-za-z]+" type="text"  name="deg" /></br>
				
				<input class="edit-employee-submit" type="submit" value="Submit"/>
	      		<button class="modal-btn modal-close">Cancel</button>
	      		
	      	</form>
	      </div>
	    </div>
	  </div>
	
	</div>
</body>
</html>