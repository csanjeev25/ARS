   <head>
    <title>Login</title>
	<link rel="stylesheet" href="style.css" type="text/css" media="all">
</head>

<body>
<script src="Register1.js"></script>
<div style="margin-top:-500px!important;">
<div id="side">
<table style="width:100%">
<tr>
<td><p style="padding-left:-200px; padding-top:550px; position: absolute; right: 80px; padding:-20px -20px;"><img src="pages/flipkart.jpg"></p></td>
<td><p style="padding-left:-200px; padding-top:550px; position: absolute; left: 80px; padding:-20px -20px;"><img src="pages/amazon.png"></p></td>
</tr>
</table>
</div>

<div class="container" style="margin-top:520px">
<a href="commonLogin.jsp"><img src="pages/logo.jpg" width="200" height="170">
<marquee>
<FONT COLOR="Dark orange" FONT SIZE="5"><u>*Whether it is your first flight or simply your latest, we work to anticipate your every need.</u></FONT>
<FONT COLOR="Indigo" FONT SIZE="5"><u>*Your comfort comes first aboard the Chief A380 - Private Suites, Shower Spas, exclusive Onboard Lounges and inflight Wi-Fi.</u></FONT>
<FONT COLOR="Dark Orange" FONT SIZE="5"><u>Fly with Sky Chief! :)</u></FONT>
</marquee></a><br /><br />

<div id='cssmenu' style="height:60px;width:960px;float:left">
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
	<form name="abc" action="register" onSubmit="return validate()">				
	
	<TABLE>
<TH colspan="4"><center><h1 class="top">Register</h1></center></TH>
<TR>
<TD style="background-color:#FFCC99;"><center>
<FONT FACE="sans-serif" FONT COLOR=#A64D0D FONT SIZE="4 ">Title</FONT></center></TD>
<TD style="background-color:#CCFFCC;">

<center>
  <select name="title">
  <option value="-1" selected>--Select--</option>
  <option value="Mr">Mr</option>
  <option value="Mrs">Mrs</option>
  <option value="Miss">Miss</option>
  </select>
</center></TD>
</TR>

<TR>
<TD style="background-color:#FFCC99;"><center>
<FONT FACE="sans-serif" FONT COLOR=#A64D0D FONT SIZE="4 ">First Name </FONT></center></TD>
<TD style="background-color:#CCFFCC;">
<center> <input type="text" class="input" name="fname" maxlength="10" autofocus>
</center></TD>
</TR>

<TR>
<TD style="background-color:#FFCC99;"><center>
<FONT FACE="sans-serif" FONT COLOR=#A64D0D FONT SIZE="4 ">Last Name </FONT></center></TD>
<TD style="background-color:#CCFFCC;">
<center>
<input type="text" class="input" name="lname" maxlength="10" >
</center></TD>
</TR>

<TR>
<TD style="background-color:#FFCC99;"><center>
<FONT FACE="sans-serif" FONT COLOR=#A64D0D FONT SIZE="4 " maxlength="10">User Name </FONT></center></TD>
<TD style="background-color:#CCFFCC;">
<center>
<input type="text" class="input" name="uname" maxlength="10" >
</center></TD>
</TR>

<TR>
<TD style="background-color:#FFCC99;"><center>
<FONT FACE="sans-serif" FONT COLOR=#A64D0D FONT SIZE="4 " >Password </FONT></center></TD>
<TD style="background-color:#CCFFCC;">
<center>
<input type="password" class="input" name = "password" maxlength="12"  >
</center></TD>
</TR>

<TR>
<TD style="background-color:#FFCC99;"><center>
<FONT FACE="sans-serif" FONT COLOR=#A64D0D FONT SIZE="4 " >Confirm Password </FONT></center></TD>
<TD style="background-color:#CCFFCC;">
<center>
<input type="password" class="input" name = "conpassword" maxlength="12" >
</center></TD>
</TR>

<TR>
<TD style="background-color:#FFCC99;"><center>
<FONT FACE="sans-serif" FONT COLOR=#A64D0D FONT SIZE="4 " >E-Mail </FONT></center></TD>
<TD style="background-color:#CCFFCC;">
<center>
<input type="email" class="input" name = "email" >
</center></TD>
</TR>

<TR>
<TD style="background-color:#FFCC99;"><center>
<FONT FACE="sans-serif" FONT COLOR=#A64D0D FONT SIZE="4 ">Country</FONT></center></TD>
<TD style="background-color:#CCFFCC;">
<center>
  <select name="country">
  <option value="-1" selected>--Select--</option>
  <option value="Australia">Australia</option>
  <option value="Argentina">Argentina</option>
  <option value="Brazil">Brazil</option>
  <option value="Chile">Chile</option>
  <option value="Germany">Germany</option>
  <option value="India">India</option>
  <option value="Italy">Italy</option>
  <option value="Mexico">Mexico</option>
  <option value="New Zealand">New Zealand</option>
  </select>
</center></TD>
</TR>

<TR>
<TD style="background-color:#FFCC99;"><center>
<FONT FACE="sans-serif" FONT COLOR=#A64D0D FONT SIZE="4 " maxlength="12">Phone Number</FONT></center></TD>
<TD style="background-color:#CCFFCC;" name="phoneno">
<center>
<input type="text" class="input" >
</center></TD>
</TR>

<TR>
<TD style="background-color:#FFCC99;"><center>
<FONT FACE="sans-serif" FONT COLOR=#A64D0D FONT SIZE="4 ">DOB</FONT></center></TD>
<TD style="background-color:#CCFFCC;" >
<center>
<input type="date" class="input" name="dob">
</center></TD>
</TR>

<TR>
<TD colspan="2" style="background-color:#FFCC99;"><center>
<tr><td><center><input type="submit" value="Submit" onClick="validate()">&nbsp;<input type="reset"></center></td></tr>
</center></TD>
</TR>
</TR>
</TABLE>

<br><TD style="background-color:#FFCC99;">
<FONT FACE="sans-serif" FONT COLOR=#A64D0D FONT SIZE="4 " >Already An User?</FONT>
<a href="login1.html" class="button1"><strong>Login</strong></a>
</form>
</section>
<br />
  <footer>
				<div class="wrapper">
					<ul id="icons">
						<li><a href="http://www.facebook.com" class="normaltip" title="Facebook"><img src="images/icon1.jpg" alt=""></a></li>
						<li><a href="http://www.twitter.com" class="normaltip" title="Twitter"><img src="images/icon4.jpg" alt=""></a></li>
						<li><a href="http://www.linkedin.com" class="normaltip" title="Linkedin"><img src="images/icon5.jpg" alt=""></a></li>
						</ul>
					<div class="links">
						<div style="padding-left:150px"> Designed by <b> ARS Group (Team 1, Sept 12) </b> of <a href="https://www.capgemini.com/" target="_blank" rel="nofollow"> Capgemini </div></a>
						<br>   <div style="padding-left:150px">Copyright 2016-17. All rights reserved. </div>                      
					</div>
				        	
				</div>
			</footer>

</div>

</body>
</html>