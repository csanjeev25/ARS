
<head>
<title>Book</title>
<link rel="stylesheet" href="style.css" type="text/css" media="all">
</head>

<body>
	<script src="book1.js"></script>
		<div class="container" style="margin-top: 00px">
			<a href="commonLogin.jsp"><img src="logo.jpg" width="200"
				height="170"> <marquee>
					<FONT COLOR="Indigo" FONT SIZE="5"><u>*Whether it is
							your first flight or simply your latest, we work to anticipate
							your every need.</u></FONT> <FONT COLOR="Indigo" FONT SIZE="5"><u>*Your
							comfort comes first aboard the Chief A380 - Private Suites,
							Shower Spas, exclusive Onboard Lounges and inflight Wi-Fi.</u></FONT> <FONT
						COLOR="Indigo" FONT SIZE="5"><u>Fly with Sky Chief! :)</u></FONT>
				</marquee></a><br />
			<br />

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

			<section id="content">
				<div class="wrapper pad1">
					<article class="col1">
						<div class="box1">
							<h2 class="top">Hot Offers of the Week</h2>
							<div class="pad">
								<strong> Mumbai </strong><br>
								<ul class="pad_bot1 list1">
									<li><span class="right color1">from 4200 Rupees.</span>Delhi</li>
									<li><span class="right color1">from 4400 Rupees.</span>Kolkata</li>
								</ul>
								<strong> Chennai </strong><br>
								<ul class="pad_bot1 list1">
									<li><span class="right color1">from 4300 Rupees.</span>Mumbai</li>
								</ul>
								<strong> Delhi </strong><br>
								<ul class="pad_bot1 list1">
									<li><span class="right color1">from 5200 Rupees.</span>Chennai</li>
									<li><span class="right color1">from 4250 Rupees.</span>Mumbai</li>
								</ul>
								<strong> Kolkata </strong><br>
								<ul class="pad_bot1 list1">
									<li><span class="right color1">from 6200 Rupees.</span>Delhi</li>
									<li><span class="right color1">from 5100 Rupees.</span>Chennai</li>
								</ul>
							</div>
						</div>
					</article>

					<article class="col2">
						<form name="abc" onSubmit="return validate()">
							<TABLE>
								<TH colspan="2"><center>
										<h1 class="top">Book a Flight Now</h1>
									</center></TH>

								<TR>
									<TD style="background-color: #FFCC99;"><center>
											<FONT FACE="sans-serif" FONT COLOR=#A64D0D FONT SIZE="4 ">Departure
												City</FONT>
										</center></TD>
									<TD style="background-color: #CCFFCC;">
										<center>
											<select name="depart">
												<option value="-1" selected>--Select--</option>
												<option value="Mumbai">Mumbai</option>
												<option value="Delhi">Delhi</option>
												<option value="Kolkata">Kolkata</option>
												<option value="Chennai">Chennai</option>
											</select>
										</center>
									</TD>
								</TR>

								<TR>
									<TD style="background-color: #FFCC99;"><center>
											<FONT FACE="sans-serif" FONT COLOR=#A64D0D FONT SIZE="4 ">Arrival
												City </FONT>
										</center></TD>
									<TD style="background-color: #CCFFCC;">
										<center>
											<select name="arrive">
												<option value="-1" selected>--Select--</option>
												<option value="Mumbai">Mumbai</option>
												<option value="Delhi">Delhi</option>
												<option value="Kolkata">Kolkata</option>
												<option value="Chennai">Chennai</option>
											</select>
										</center>
									</TD>
								</TR>

								<TR>
									<TD style="background-color: #FFCC99;"><center>
											<FONT FACE="sans-serif" FONT COLOR=#A64D0D FONT SIZE="4 ">Travel
												Class </FONT>
										</center></TD>
									<TD style="background-color: #CCFFCC;">
										<center>
											<select name="class">
												<option value="-1" selected>--Select--</option>
												<option value="Economy">Economy</option>
												<option value="F.Class">First Class</option>
												<option value="Business">Business</option>
											</select>
										</center>
									</TD>
								</TR>

								<TR>
									<TD style="background-color: #FFCC99;"><center>
											<FONT FACE="sans-serif" FONT COLOR=#A64D0D FONT SIZE="4 ">Enter
												Departure Date</FONT>
										</center></TD>
									<TD style="background-color: #CCFFCC;"><center>
											<input type="datetime-local" name="departdate">
										</center></TD>
								</TR>

								<TR>
									<TD style="background-color: #FFCC99;"><center>
											<FONT FACE="sans-serif" FONT COLOR=#A64D0D FONT SIZE="4 ">Enter
												Seats</FONT>
										</center></TD>
									<TD style="background-color: #CCFFCC;"><center>
											<input type="datetime-local" name="seats">
										</center></TD>
								</TR>

<TR>
									<TD style="background-color: #FFCC99;"><center>
											<FONT FACE="sans-serif" FONT COLOR=#A64D0D FONT SIZE="4 ">Payment Through</FONT>
										</center></TD>
									<TD style="background-color: #CCFFCC;">
										<center>
											<input type="radio" name="jtype">Master-Card <input
												type="radio" name="jtype">VISA <input type="radio"
												name="jtype">Other
										</center>
									</TD>
								</TR>
								<TR>
									<TD style="background-color: #FFCC99;"><center>
											<FONT FACE="sans-serif" FONT COLOR=#A64D0D FONT SIZE="4 ">Indian
												Armed Forces</FONT>
										</center></TD>
									<TD style="background-color: #CCFFCC;"><center>
											<input type="radio" name="concession">Yes <input
												type="radio" name="concession">No

											<tr>
												<td></td>
												<td><center>
														<input type="submit" onClick="validate()">&nbsp;<input
															type="reset">
													</center></td>
											</tr>
										</center></TD>
								</TR>

								<TR>
									<TD colspan="2" style="background-color: #FFCC99;"><center>
								</TR>

							</TABLE>
						</form>
			</section>
			<br />

			<footer>
				<div class="wrapper">
					<ul id="icons">
						<li><a href="http://www.facebook.com" class="normaltip"
							title="Facebook"><img src="images/icon1.jpg" alt=""></a></li>
						<li><a href="http://www.twitter.com" class="normaltip"
							title="Twitter"><img src="images/icon4.jpg" alt=""></a></li>
						<li><a href="http://www.linkedin.com" class="normaltip"
							title="Linkedin"><img src="images/icon5.jpg" alt=""></a></li>
					</ul>
					<div class="links">
						<div style="padding-left: 150px">
							Designed by <b> ARS Group (Team 1, Sept 12) </b> of <a
								href="https://www.capgemini.com/" target="_blank" rel="nofollow">
								Capgemini 
						</div>
						</a> <br>
						<div style="padding-left: 150px">Copyright 2016-17. All
							rights reserved.</div>
					</div>

				</div>
			</footer>

		</div>
</body>
</html>