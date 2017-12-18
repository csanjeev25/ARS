<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css" type="text/css" media="all">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="AdminController?op=2" method="post">

		<div class="container">
			<a href="commonLogin.jsp"><img src="logo.jpg" width="200"
				height="170"> </a><br /> <br />

			<div id='cssmenu' style="height: 60px; width: 960px; float: left">
				<ul>
					<li class='active'><a href='Home.jsp'><span>Home</span></a></li>
					<li class='active'><a href='Register.jsp'><span>Register</span></a></li>
					<li class='active'><a href='flightSchedule.jsp'><span>Flight
								Schedule</span></a></li>
					<li class='has-sub'><a href='book.jsp'><span>Book
								Now</span></a></li>
								<li class='has-sub'><a href='login1.jsp'><span>Login</span></a></li>
					<li class='has-sub last'><a href='Contact Us.html'><span>Contact
								Us</span></a></li>
				</ul>
			</div>
		</div>
	</form:form>
	<center>
		<form:form action="modifyTrainee.obj" method="post">
			<table>
				<tr>
					<td>
						<h1 class="top">Update</h1>
					</td>
				</tr>
			</table>
		Flight Id :<input type="text" value="Flight Id">
		</form:form>
		<c:if test="${trainee ne null}">
			<form:form method="post" modelAttribute="trainee"
				action="ModifyTrainee.obj">
				<table border="1">
					<tr>
						<th>FlightId</th>
						<td><input type="text" value="${flight.flightId} " /></td>
					</tr>
					<tr>
						<th>FlightName</th>
						<td><input type="text" value="${flight.flightName} " /></td>
					</tr>
					<tr>
						<th>ArrivalDate</th>
						<td><input type="text" value="${flight.arrivalDate} " /></td>
					</tr>
					<tr>
						<th>DestinationDate</th>
						<td><input type="text" value="${flight.destinationDate} " /></td>
					</tr>
					<tr>
						<th>ArrivalTime</th>
						<td><input type="text" value="${flight.arrivalTime} " /></td>
					</tr>
					<tr>
						<th>DestinationTime</th>
						<td><input type="text" value="${flight.destinationTime} " /></td>
					</tr>
					<tr>
						<th>Seats</th>
						<td><input type="text" value="${flight.seats} " /></td>
					</tr>
					<tr>
						<th>Fare</th>
						<td><input type="text" value="${flight.fare} " /></td>
					</tr>
				</table>
			</form:form>
		</c:if>
		<input type="submit" value="Update"> <input type="submit"
			value="logout">
	</center>
	<br>
	<footer>
	<div class="wrapper">
		<ul id="icons">
			<li><a href="http://www.facebook.com" class="normaltip"
				title="Facebook"><img src="icon1.jpg" alt=""></a></li>
			<li><a href="http://www.twitter.com" class="normaltip"
				title="Twitter"><img src="icon4.jpg" alt=""></a></li>
			<li><a href="http://www.linkedin.com" class="normaltip"
				title="Linkedin"><img src="icon5.jpg" alt=""></a></li>
		</ul>
		<div class="links">
			<div style="padding-left: 150px">
				Designed by <b> ARS Group (Team 1, Sept 12) </b> of <a
					href="https://www.capgemini.com/" target="_blank" rel="nofollow">
					Capgemini 
			</div>
			</a> <br>
			<div style="padding-left: 150px">Copyright 2016-17. All rights
				reserved.</div>
		</div>
	</div>
	</footer>
</body>
</html>