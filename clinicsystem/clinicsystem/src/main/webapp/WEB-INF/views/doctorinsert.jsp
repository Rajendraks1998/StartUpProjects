<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<style>
h3 {
	text-align: center;
	margin: 20px;
	color: red
}

nav {
	text-align: center;
}

nav a {
	min-width: 150px;
}
main{ margin-top:50px;}
</style>
</head>
</head>
<body>
<div class="text-center" style="margin-top:50px;"><h1><b>Insert Doctor Details</b></h1></div>
<form:form action="saveform" modelAttribute="doctor">
<table width="500px" style="margin:auto">
<%--  <tr><td><b>DocotorId</b></td><td>:<form:input path="docotorId"/></td></tr>  --%>
<tr><td><b>Name</b></td><td>:<form:input path="docotorName"/></td></tr>
<tr><td><b>Specifiaction</b></td><td>:<form:input path="docotorSpecifiaction" /></td></tr>
<tr><td><b>Exprience</b></td><td>:<form:input path="docotorExprience"/></td></tr>
<tr><td><b>Gender</b></td><td>:Male<form:radiobutton path="gender" value="Male"/>Female <form:radiobutton path="gender" value="Female"/>
</table>
<div class="text-center" style="margin-top:20px;">
<button type="submit" >Submit</button>
</div>
</form:form>
</body>
</html>