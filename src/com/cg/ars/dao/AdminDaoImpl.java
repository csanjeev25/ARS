package com.cg.ars.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cg.ars.DBUtil.DBUtil;
import com.cg.ars.bean.BookingInformation;
import com.cg.ars.bean.FlightInformation;
import com.cg.ars.exception.ArsException;

public class AdminDaoImpl implements IAdminDao {
	Statement statement = null;
	ResultSet rsSet = null;
	PreparedStatement preparedStatement = null;
	private Connection connection = null;

	public AdminDaoImpl() {
		try {
		 connection = DBUtil.obtainConnection();
		} catch (ArsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean veriyfAdmin(String userName, String password)
			throws ArsException {
		boolean result = false;
		//connection = DBUtil.obtainConnection();
		String sql = "select password from users where username=?";
		try {
			System.out.println(userName);
			System.out.println(password);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			rsSet = preparedStatement.executeQuery();
			String passMatch = null;
			while (rsSet.next()) {
				passMatch = rsSet.getString("password");
				if (passMatch.equals(password)) {
					System.out.println(password);
					result = true;
					return result;
				}
			}
		} catch (SQLException e) {
			throw new ArsException("Error while database interaction:::"
					+ e.getMessage());
		}

		return result;
	}

	@Override
	public boolean updateFlightSchedule(FlightInformation flight) throws ArsException {
		connection = DBUtil.obtainConnection();
		String sqlString = "update flightinformation set dep_time=?,arr_time=? where flightno=?";
		try {
			preparedStatement = connection.prepareStatement(sqlString);
			preparedStatement.setString(1, flight.getDepartureTime());
			preparedStatement.setString(2, flight.getArrivalTime());
			preparedStatement.setString(3, flight.getFlightNo());
			rsSet = preparedStatement.executeQuery();
			if(rsSet.next()){
				return true;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		return false;

	}

	@Override
	public boolean updateFlightInfo(FlightInformation flight) throws ArsException {
		connection=DBUtil.obtainConnection();
		boolean result=false;
		int a=0;
		PreparedStatement st=null;
		String sql = "update flightinformation set dep_city=?,arr_city=? where flightno=?";
		try {
			System.out.println("afbdtgrta ");
			st = connection.prepareStatement(sql);
			st.setString(1, flight.getDepartureCity());
			st.setString(2, flight.getArrivalCity());
			st.setString(3, flight.getFlightNo());
			System.out.println("in dao "+a);
			a=st.executeUpdate();
			System.out.println("in dao "+a);
			if(a>0){
				result= true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<FlightInformation> viewFlightDest(
			String destination) throws ArsException {
		ArrayList<FlightInformation> flightList = new ArrayList<FlightInformation>();
		Connection connection = DBUtil.obtainConnection();
		String sql = "SELECT * FROM flightinformation WHERE  dep_City=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, destination);
			rsSet = preparedStatement.executeQuery();
			if (rsSet.next()) {
				FlightInformation flight = new FlightInformation();
				flight.setFlightNo(rsSet.getString("flightno"));
				flight.setAirline(rsSet.getString("airline"));
				flight.setDepartureCity(rsSet.getString("dep_city"));
				flight.setArrivalCity(rsSet.getString("arr_city"));
				java.util.Date departureDate=new java.util.Date(rsSet.getDate("departure_date").getTime());
				java.util.Date arrivalDate=new java.util.Date(rsSet.getDate("arrival_date").getTime());
				flight.setDepartureDate(departureDate);
				flight.setArrivalDate(arrivalDate);
				flight.setDepartureTime(rsSet.getString("dep_time"));
				flight.setArrivalTime(rsSet.getString("arr_time"));
				flight.setFirstSeats(rsSet.getInt("firstseats"));
				flight.setFirstSeatFare(rsSet.getDouble("firstseatfare"));
				flight.setBussinessSeats(rsSet.getInt("bussseats"));
				flight.setBussinessSeatsFare(rsSet.getDouble("bussseatsfare"));

				flightList.add(flight);			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ArsException("Error while database interaction:::"
					+ e.getMessage());
			
		}

		return flightList;

	}

	@Override
	public List<FlightInformation> viewFlightById(String flightNo) throws ArsException {
		ArrayList<FlightInformation> flightList = new ArrayList<FlightInformation>();
		Connection connection = DBUtil.obtainConnection();
		String sql = "SELECT * FROM flightinformation WHERE flightno=?";
		try {
			System.out.println("dsfjsgjfgsj");
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, flightNo);
			rsSet = preparedStatement.executeQuery();
			if (rsSet.next()) {
				FlightInformation flight = new FlightInformation();
				flight.setFlightNo(rsSet.getString("flightno"));
				flight.setAirline(rsSet.getString("airline"));
				flight.setDepartureCity(rsSet.getString("dep_city"));
				flight.setArrivalCity(rsSet.getString("arr_city"));
				java.util.Date departureDate=new java.util.Date(rsSet.getDate("departure_date").getTime());
				java.util.Date arrivalDate=new java.util.Date(rsSet.getDate("arrival_date").getTime());
				flight.setDepartureDate(departureDate);
				flight.setArrivalDate(arrivalDate);
				flight.setDepartureTime(rsSet.getString("dep_time"));
				flight.setArrivalTime(rsSet.getString("arr_time"));
				flight.setFirstSeats(rsSet.getInt("firstseats"));
				flight.setFirstSeatFare(rsSet.getDouble("firstseatfare"));
				flight.setBussinessSeats(rsSet.getInt("bussseats"));
				flight.setBussinessSeatsFare(rsSet.getDouble("bussseatsfare"));

				flightList.add(flight);
			}
		} catch (SQLException e) {
			throw new ArsException("Error while database interaction:::"
					+ e.getMessage());
		}

		return flightList;

	}

	@Override
	public List<String> viewPassengersByFlight(String flightNo) throws ArsException {
		//ArrayList<FlightInformation> flightList = new ArrayList<FlightInformation>();
		List<String> custList=new ArrayList<String>();
		connection = DBUtil.obtainConnection();
		String sql = "SELECT fname,lname  from customer where email in(select cust_email from bookinginformation where flightno=? )";		
		System.out.println(sql);
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, flightNo);
			rsSet=preparedStatement.executeQuery();
			System.out.println(rsSet);
			while(rsSet.next()){
				String name=rsSet.getString(1)+" "+rsSet.getString(2);
				custList.add(name);
				System.out.println(name);
					
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return custList;
	}

}
