<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
</head>
<body>
<div style=text-align:center>
<h1>Welcome  <%= request.getAttribute("name") %></h1><br>
<a href='AdminRegistration.html'>Create New Admin </a> | <a href='AddCourse.html'>Add Course</a> | <a href='ViewFeedbacks.jsp'>View Feedback's</a> 
</div>
</body>
</html>