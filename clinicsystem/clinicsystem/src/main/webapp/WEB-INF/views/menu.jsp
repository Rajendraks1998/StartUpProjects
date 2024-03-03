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
	
	<main> <c:if test="${list.size() > 0}">
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>patientId</th>
						<th>patientName</th>
						<th>gender</th>
						<th>patientContactNum</th>
						<th>patientEmail</th>
						<th>patientSymptoms</th>
						<th>patientDob</th>
						<th width="80px">Update</th>
						<th width="80px">Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="patient" items="${list}">
						<tr>
							<td>${patient.patientId}</td>
							<td>${patient.patientName}</td>
							<td>${patient.gender}</td>
							<td>${patient.patientContactNum}</td>
							<td>${patient.patientEmail}</td>
							<td>${patient.patientSymptoms}</td>
							<td>${patient.patientDob}</td>
							<td><a href="update/${patient.patientId}" >Update</a></td>
							<td><a href="delete/${patient.patientId}" >Delete</a></td>
						</tr>
					</c:forEach>
					
				</tbody>
				
			</table>
			<a href="/doctors/insertdoctor"><b>Doctor</b></a><br><br>
			<a href="/appointment/insert"><b>Appointment</b></a><br><br>
		    <a href="/schedule/insert"><b>Schedule</b></a><br><br>
		    <a href="/appointment/insert"><b>Appointment</b></a><br><br>
		    <a href="/account/login"><b>back</b></a><br><br>
		</c:if> </main>
</body>
</html>