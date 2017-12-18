package com.cg.ars.dao;

import java.util.List;

import com.cg.ars.bean.FlightInformation;
import com.cg.ars.exception.ArsException;
public interface IExecutiveDao {
	public boolean verifyExecutive(String userName,String password) throws ArsException;
	public List<FlightInformation> viewFlightOccu() throws ArsException;

}
