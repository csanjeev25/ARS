package com.cg.ars.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.ars.bean.BookingInformation;
import com.cg.ars.bean.FlightInformation;
import com.cg.ars.dao.ICustomerDao;
import com.cg.ars.dao.CustomerDaoImpl;
import com.cg.ars.exception.ArsException;

public class CustomerServiceImpl implements ICustomerService{

	private ICustomerDao userDao;
	public CustomerServiceImpl() {
		userDao=new CustomerDaoImpl();
	}
	@Override
	public ArrayList<FlightInformation> showFlightInfo() throws ArsException {
		
		return userDao.showFlightInfo();
	}

	@Override
	public boolean verifyUser(String userName, String password)
			throws ArsException {
		
		return userDao.verifyUser(userName, password);
	}

	@Override
	public String makeReservation(String userName, BookingInformation bookInfo)
			throws ArsException {
		
		return userDao.makeReservation(userName, bookInfo);
	}

	@Override
	public int cancelReservation(String bookingId) throws ArsException,SQLException {
		System.out.println("ashdgbah");
		return userDao.cancelReservation(bookingId);
	}

	@Override
	public ArrayList<BookingInformation> showReservation(String userName)
			throws ArsException {
		
		return userDao.showReservation(userName);
	}

	
}
