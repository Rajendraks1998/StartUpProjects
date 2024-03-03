<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

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
<body>
		<h3>${msg} </h3>
		
		<main> 
			<form:form action="/doctors/update" modelAttribute="doctor">
			
				<form:input type="hidden" path="docotorId" value="${doctor.docotorId}" />
				
				<table width="500px" style="margin:auto">
					<tr><td><b>Name</b></td><td>: <form:input value="${doctor.docotorName}" path="docotorName"/></td></tr>
					<tr><td><b>Specifiaction</b></td><td>: <form:input value="${doctor.docotorSpecifiaction}"  path="docotorSpecifiaction"/></td></tr>
					<tr><td><b>Exprience</b></td><td>: <form:input value="${doctor.docotorExprience}" path="docotorExprience"/></td></tr>
					<tr><td><b>Gender</b></td><td>:Male<form:radiobutton path="Gender" value="Male"/>Female <form:radiobutton path="Gender" value="Female"/>  				
					</table>
				<div class="text-center" style="margin-top:20px;">
                       <button type="submit" class="btn btn-success">Update</button>
                 </div>
			</form:form>
		</main>
	
</body>
</html>