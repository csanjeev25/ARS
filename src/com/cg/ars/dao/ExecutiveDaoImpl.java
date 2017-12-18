package com.cg.ars.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cg.ars.DBUtil.DBUtil;
import com.cg.ars.bean.FlightInformation;
import com.cg.ars.exception.ArsException;

public class ExecutiveDaoImpl implements IExecutiveDao {
	Statement statement = null;
	ResultSet rsSet = null;
	PreparedStatement preparedStatement = null;
	private Connection connection = null;

	public ExecutiveDaoImpl() {
		try {
			 connection = DBUtil.obtainConnection();
		} catch (ArsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean verifyExecutive(String userName, String password) throws ArsException {
		boolean result = false;
		String sql = "SELECT password from USERS where username=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			rsSet = preparedStatement.executeQuery();
			String passMatch = null;
			while (rsSet.next()) {
				passMatch = rsSet.getString("password");

				if (passMatch.equals(password)) {
					result = true;
				}
			}
		} catch (SQLException e) {
			throw new ArsException("Error while database interaction:::"
					+ e.getMessage());
		}

		return result;
	}

	@Override
	public List<FlightInformation> viewFlightOccu()throws ArsException {
		List<FlightInformation> flightList = new ArrayList<FlightInformation>();
		String sql = "SELECT FLIGHTNO,FIRSTSEATS,BUSSSEATS FROM FLIGHTINFORMATION ";
		try {
			preparedStatement = connection.prepareStatement(sql);
			rsSet=preparedStatement.executeQuery();
			while(rsSet.next()){
				FlightInformation flight = new FlightInformation();
				flight.setFlightNo(rsSet.getString("flightno"));
				flight.setFirstSeats(rsSet.getInt("firstseats"));
				flight.setBussinessSeats(rsSet.getInt("bussseats"));
				flightList.add(flight);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flightList;
	}
}
