<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>XML Parsers</title>
	
	<link rel="stylesheet" type="text/css" href="resources/css/jpa.css" />
</head>
<body>
	<h2>DOM Parser</h2>
	<form action="uploadFile" method="POST" enctype="multipart/form-data">
		Please choose file to parse:</br>
		<input id="file" type="file" name="file" /></br>
		<input type="submit" value="Upload" />
	</form>
</body>
</html>