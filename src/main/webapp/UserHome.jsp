<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Home</title>
</head>
<body>
<div style=text-align:center>
<h1>Welcome  <%= request.getAttribute("name") %></h1><br>
<a href='EnrollCourse.html'>Enroll into course </a> | <a href='AddFeedback.html'>Add Feedback </a> | <a href="Contact.html">Contact</a>
</div>

</body>
</html>