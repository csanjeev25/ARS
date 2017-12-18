package com.cg.ars.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.ars.bean.BookingInformation;
import com.cg.ars.bean.FlightInformation;
import com.cg.ars.exception.ArsException;

public interface ICustomerDao {
 
	public ArrayList<FlightInformation> showFlightInfo() throws ArsException;
	public boolean verifyUser(String userName , String password) throws ArsException;
	public String makeReservation(String userName, BookingInformation bookInfo ) throws ArsException;
	public int cancelReservation(String bookingId) throws ArsException,SQLException;
	public ArrayList<BookingInformation> showReservation(String userName) throws ArsException;
	 
}
