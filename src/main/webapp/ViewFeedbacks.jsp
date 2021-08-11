<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>view feedbacks</title>
</head>
<body>
<div style="text-align:center">
<h1>Feedbacks</h1><br>
<%@ page import="java.sql.*"%>
<% String query = "select * from feedback";
String dbDriver = "com.mysql.cj.jdbc.Driver";
String dbURL = "jdbc:mysql:// localhost:3306/";
String dbName = "demo";
String dbUsername = "root";
String dbPassword = "root";

Class.forName(dbDriver);
Connection con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
Statement st = con.createStatement();
ResultSet rs = st.executeQuery(query);
out.println("USER ID | NAME | EMAIL | FEEDBACK <br>");
while (rs.next()) {
	out.println(rs.getInt(2)+" "+rs.getString(1)+" "+rs.getString(4)+"<br>");
}
st.close();
con.close(); %>
</div>
</body>
</html>