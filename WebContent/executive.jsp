<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css" type="text/css" media="all">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">

		<a href="commonLogin.jsp"><img src="pages/logo.jpg" width="200" height="170">
		</a><br /> <br />

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
		<br>
		<div>
			<center>
				<form action="viewOccupancy" method="post">
					<input type="button" value="View" id="view" name="view">
				</form>
			</center>
		</div>
		<div>
			<form action="logout" method="post">
				<center>
					<input type="button" value="Log out">
				</center>
			</form>
		</div>
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