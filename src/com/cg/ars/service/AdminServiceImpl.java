package com.cg.ars.service;

import java.util.Date;
import java.util.List;

import com.cg.ars.bean.FlightInformation;
import com.cg.ars.dao.IAdminDao;
import com.cg.ars.dao.AdminDaoImpl;
import com.cg.ars.exception.ArsException;

public class AdminServiceImpl implements AdminService{

	private IAdminDao adminDao;
	public AdminServiceImpl() {
		adminDao=new AdminDaoImpl();
	}
	@Override
	public boolean veriyfAdmin(String userName, String password)
			throws ArsException {
		
		return adminDao.veriyfAdmin(userName, password);
	}

	@Override
	public boolean updateFlightSchedule(FlightInformation flight)
			throws ArsException {
		
		return adminDao.updateFlightSchedule(flight);
	}

	@Override
	public boolean updateFlightInfo(FlightInformation flight)
			throws ArsException {
		// TODO Auto-generated method stub
		return adminDao.updateFlightInfo(flight);
	}

	@Override
	public List<FlightInformation> viewFlightDest(
			String destination) throws ArsException {
		// TODO Auto-generated method stub
		return adminDao.viewFlightDest(destination);
	}

	@Override
	public List<FlightInformation> viewFlightById(String flightNo)
			throws ArsException {
		// TODO Auto-generated method stub
		return adminDao.viewFlightById(flightNo);
	}

	@Override
	public List<String> viewPassengersByFlight(String flightNo)
			throws ArsException {
		// TODO Auto-generated method stub
		return adminDao.viewPassengersByFlight(flightNo);
	}

}
