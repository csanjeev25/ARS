package com.cg.ars.service;

import java.util.Date;
import java.util.List;

import com.cg.ars.bean.FlightInformation;
import com.cg.ars.exception.ArsException;

public interface AdminService {

	public boolean veriyfAdmin(String userName,String password)  throws ArsException;
	public boolean updateFlightSchedule(FlightInformation flight) throws ArsException;
	public boolean updateFlightInfo(FlightInformation flight) throws ArsException;
	public List<FlightInformation> viewFlightDest(String destination) throws ArsException;
	public List<FlightInformation> viewFlightById(String flightNo) throws ArsException ;
	public List<String> viewPassengersByFlight(String flightNo) throws ArsException;
}
