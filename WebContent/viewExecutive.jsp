<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight Occupancy</title>
</head>
<body>
<table>
<tr>
<td>Enter Flight number</td><td><input type="text"></td>
<td><input type="submit" value="Enter"></td>
</tr>
</table>
<form >
<table border="1">
<th>FlightId</th>
<th>First Class</th>
<th>Business Class</th>
<tr>
	<td><c:out value="${flight.flightId}"/></td>
	<td><c:out value="${flight.firstseats}"/></td>
	<td><C:out value="${flight,bussseats}"/></td>
</tr>
</table>
</form>
</body>
</html>