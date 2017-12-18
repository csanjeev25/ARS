package com.cg.ars.Client;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.ars.bean.BookingInformation;
import com.cg.ars.bean.FlightInformation;
import com.cg.ars.exception.ArsException;
import com.cg.ars.service.CustomerServiceImpl;
import com.cg.ars.service.ICustomerService;

public class CustomerClient {
	public static void main(String[] args) {
		ICustomerService s = new CustomerServiceImpl();
		/*try {
			ArrayList<FlightInformation> d=s.showFlightInfo();
			for(FlightInformation g:d){
				System.out.println(g.getAirline());
				System.out.println(g.getArrivalCity());
				System.out.println(g.g)
			}
		} catch (ArsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		/*String userName = "nmodi@gmail.com";
		String password = "narmodi";
		try {
			boolean r = s.verifyUser(userName, password);
			System.out.println(r);
		} catch (ArsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		BookingInformation book = new BookingInformation();
		book.setClassType("First");
		book.setCreditCardInfo("6454644666");
		book.setCustEmail("nmodi@gmail.com");
		book.setArrCity("Mumbai");
		book.setDepCity("Bhopal");
		book.setFlightNo("6B0985");
		book.setNoOfPassengers(1);
		book.setSeatNumbers("30");
		book.setTotalFare(9874);
		
		String user = "nmodi@gmail.com";
		
		try {
			String f = s.makeReservation(user, book);
			System.out.println(f);
		} catch (ArsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*try {
			ArrayList<BookingInformation> l = s.showReservation(user);
			for(BookingInformation f : l){
				System.out.println(f.getArrCity());
			}
		} catch (ArsException e) {
			// TODO: handle exception
		}*/
		
		
		/*int g = 0;
		try {
			String string="AQ543";
			g = s.cancelReservation(string);
			System.out.println(g);
		} catch (ArsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
	}

}
