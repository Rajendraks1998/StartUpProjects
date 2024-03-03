<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<style>
.bg{
background-image :src=('Doctor.jpg') 
}
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
	
		<h3>${msg}</h3>
		<nav> 
		<a href="insert" class="btn btn-primary">Insert</a> 
  		<a href="showall" class="btn btn-success">ShowAll</a> 

 			<a href="logout" class="btn btn-danger">Logout</a> 
  		</nav>
	<main> <c:if test="${list.size() > 0}">
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>appointmentId</th>
						<th>status</th>
						<th>appointmentDate</th>
						<th>doctor</th>
						<th>patient</th>
						<th width="80px">Update</th>
						<th width="80px">Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="appointment" items="${list}">
						<tr>
							<td>${appointment.appointmentId}</td>
							<td>${appointment.status}</td>
							<td>${appointment.appointmentDate}</td>
							<td>${appointment.doctorId}</td>
							<td>${appointment.patientId}</td>
							<td><a href="update/${appointment.appointmentId}" class="btn btn-warning">Update</a></td>
							<td><a href="delete/${appointment.appointmentId}" class="btn btn-danger">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if> </main>
</body>
</html>