<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>XML Parsers</title>
	<c:if test="${isFileUploaded}">
		<script type="text/javascript" src="resources/js/lib/jquery-3.1.1.min.js"></script>
		<script type="text/javascript" src="resources/js/xmlparsers.js"></script>
	</c:if>
	
	<link rel="stylesheet" type="text/css" href="resources/css/xmlparsers.css" />
</head>
<body>
  <c:choose>

	<c:when test="${isFileUploaded}">
		<p>File has been successfully uploaded</p>
		<h2>Now please choose the type of parser</h2>
		
		<form class="parser-form" action="" method="post">
			<!-- <select class="parse-select">
				<option class="parse-option" label="SAX parser" value="parse-with-sax"></option>
				<option class="parse-option" label="DOM parser" value="parse-with-dom"></option>
			</select> -->
			<input type="radio" name="parser" class="parse-option" label="SAX parser" value="parse-with-sax"/>SAX</br>
			<input type="radio" name="parser" class="parse-option" label="DOM parser" value="parse-with-dom"/>DOM</br>
			
			<button class="parse-btn" type="submit" value="parse">Parse</button>
		</form>
	</c:when>
	
	<c:otherwise>
		<h2>Upload file to parse</h2>
		<form action="xmlparsers" method="POST" enctype="multipart/form-data">
			Please choose file to parse:</br>
			<input id="file" type="file" name="file" /></br>
			<input type="submit" value="Upload" />
		</form>	
		
		<c:if test="${errorMessage != null && !errorMessage.isEmpty() }">
			<div style="color:red" class="error-msg"><c:out value="${errorMessage}" /></div>
		</c:if>
	</c:otherwise>
	
  </c:choose>	
</body>
</html>