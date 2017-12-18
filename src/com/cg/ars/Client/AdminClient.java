package com.cg.ars.Client;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.cg.ars.bean.FlightInformation;
import com.cg.ars.bean.User;
import com.cg.ars.exception.ArsException;
import com.cg.ars.service.AdminService;
import com.cg.ars.service.AdminServiceImpl;

public class AdminClient {
	public static void main(String[] args) {
		AdminService service = new AdminServiceImpl();
		Scanner scanner = new Scanner(System.in);
		String flightno = "5T8754";
		String username = "Donald";
		String password = "Trump";

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);

		try {
			boolean t = service.veriyfAdmin(username, password);
			System.out.println(t);
		} catch (ArsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*System.out.println("Enetr destination");
		String dest = scanner.next();
		String stringdate = "2016-11-18";
		Date flightdate = null;

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		try {
			flightdate = df.parse(stringdate);
			String newDate = df.format(flightdate);
			System.out.println(newDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
		
		/*try {
			List<FlightInformation> list = service.viewFlightDest();
			for(FlightInformation h : list){
				System.out.println(h);
			}
		} catch (ArsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		/*String id = "9W6738";
		try {
			FlightInformation flight = (FlightInformation) service.viewFlightById(id);
			
			System.out.println(flight.getAirline());
			System.out.println(flight.getArrivalCity());
			System.out.println(flight.getArrivalTime());
			System.out.println(flight.getBussinessSeats());
			System.out.println(flight.getBussinessSeatsFare());
			System.out.println(flight.getDepartureCity());
			System.out.println(flight.getDepartureTime());
			System.out.println(flight.getFirstSeatFare());
			System.out.println(flight.getFirstSeats());
			System.out.println(flight.getFlightNo());
			
		} catch (ArsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/ 
		
		/*try {
			System.out.println(service.viewPassengersByFlight("6B0985"));
		} catch (ArsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*FlightInformation fg = new FlightInformation();
		fg.setArrivalCity("Indore");
		fg.setDepartureCity("Mumbai");
		fg.setFlightNo(flightno);
		fg.setDepartureCity("Mumbai");
		List<FlightInformation> list=new ArrayList<FlightInformation>();
		System.out.println(fg);
		try {
			list=service.viewFlightDest(fg.getDepartureCity());
			for(FlightInformation h : list){
			System.out.println(h);
			}
		} catch (ArsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
