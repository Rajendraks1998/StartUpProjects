<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UserLogin</title>
<style>
body {background-color:red;}
</style>
</head>
<body>

	<h2>Home Page</h2>
	<hr>
<h2>	<a href="logout">Logout</a></h2>
	
	<br><br>
	
		<a href="/patient/showall"><h2><b>Patient</b></h2></a><br><br>
		<a href="/doctors/insertdoctor"><h2><b>Doctor</b></h2></a><br><br>
		<a href="/appointment/insert"><h2><b>Appointment</b></h2></a><br><br>
		<a href="/schedule/insert"><h2><b>Schedule</b></h2></a><br><br>
</body>
</html>