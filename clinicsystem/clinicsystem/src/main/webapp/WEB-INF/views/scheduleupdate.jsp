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
			<form:form action="/schedule/update" modelAttribute="schedule">
			
				<form:input type="hidden" path="scheduleId" value="${schedule.scheduleId}" />
				
				<table width="500px" style="margin:auto">
					<tr><td><b>docotorid</b></td><td>: <form:input value="${schedule.docotorid}"  path="docotorid"/></td></tr>
					<tr><td><b>scheduleDate</b></td><td>: <form:input value="${schedule.scheduleDate}" path="scheduleDate"/></td></tr>
					</table>
				<div class="text-center" style="margin-top:20px;">
                       <button type="submit" class="btn btn-success">Update</button>
                 </div>
			</form:form>
		</main>
	
</body>
</html>