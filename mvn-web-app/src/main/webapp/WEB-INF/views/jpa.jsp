<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>JPA implementation</title>
	
	<link rel="stylesheet" type="text/css" href="resources/css/jpa.css" />
	<script type="text/javascript" src="resources/js/lib/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="resources/js/jpa.js"></script>
</head>
<body>
	<h1>JPA implementation</h1>
	
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Salary</th>
			<th>Position</th>
		</tr>
		<c:forEach items="${employeeList}" var="employee">
			<tr>
				<th><c:out value="${employee.id}"/></th>
				<th><c:out value="${employee.name}"/></th>
				<th><c:out value="${employee.salary}"/></th>
				<th><c:out value="${employee.deg}"/></th>
			</tr>	
		</c:forEach>
	</table>
	
	<form class="add-employee-form" method="POST">
		<input class="employee-name" pattern="[a-zA-z]+" type="text" placeholder="Name" name="name" required/></br>
		<input class="employee-salary" type="number" min="0" step="0.1" placeholder="Salary" name="salary" required/></br>
		<input class="employee-deg" pattern="[A-za-z]+" type="text" placeholder="Position" name="deg" required/></br>
		<input class="add-employee" type="submit" value="Add Employee"/>
	</form>
	<div id="error-message" >
		
	</div>
</body>
</html>