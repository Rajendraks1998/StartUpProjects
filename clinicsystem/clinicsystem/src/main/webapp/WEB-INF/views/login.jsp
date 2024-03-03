<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UserLogin</title>
<style>
body {background-color:pink;}
</style>
</head>
<body>

	<h2>Login</h2>
	<hr>

	<form:form action="login" modelAttribute="userDao">

		<table width="500px" style="margin: auto">
			<tr>
				<td >Admin Name</td>
				<td>: <form:input path="adminname" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td>: <form:password path="adminpassword" /></td>
			</tr>
		</table>
		<div class="text-center" style="margin-top: 20px; text-align:center">
			<button type="submit" class="btn btn-success">Submit</button>
			<br><br>
			New  User <a href="frmsignup">SignUp</a>
		</div>
	</form:form>

</body>
</html>