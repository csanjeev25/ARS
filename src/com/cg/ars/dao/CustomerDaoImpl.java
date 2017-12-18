package com.cg.ars.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import com.cg.ars.DBUtil.DBUtil;
import com.cg.ars.bean.BookingInformation;
import com.cg.ars.bean.FlightInformation;
import com.cg.ars.exception.ArsException;

public class CustomerDaoImpl implements ICustomerDao {
	Statement statement = null;
	ResultSet rsSet = null;
	PreparedStatement preparedStatement = null;
	private Connection connection = null;

	public CustomerDaoImpl() {
		try {
			 connection = DBUtil.obtainConnection();
		} catch (ArsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<FlightInformation> showFlightInfo() throws ArsException {

		ArrayList<FlightInformation> flightList = null;
		flightList = new ArrayList<>();

		String sql = "SELECT * FROM flightinformation";
		try {
			System.out.println("sfhs");
			System.out.println(sql);
			preparedStatement = connection.prepareStatement(sql);
			rsSet = preparedStatement.executeQuery();
			while (rsSet.next()) {
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
	public boolean verifyUser(String userName, String password)
			throws ArsException {
		boolean result = false;
		Connection connection = DBUtil.obtainConnection();
		String sql = "SELECT password from CUSTOMER where username=?";
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
	public String makeReservation(String userName, BookingInformation bookInfo)
			throws ArsException {
		
		String updateSql = null;
		String resultBook=null;
		int firstseats = 0, businessseat = 0;
		String sql = "select firstseats,bussseats from FlightInformation where flightno=? ";
		try {
			//connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, bookInfo.getFlightNo());
			rsSet = preparedStatement.executeQuery();
			if (rsSet.next()) {
				firstseats = rsSet.getInt(1);
				businessseat = rsSet.getInt(2);
			}

			if (bookInfo.getClassType().equals("First")
					&& firstseats > bookInfo.getNoOfPassengers()) {
				
				updateSql = "UPDATE FlightInformation SET firstseats=firstSeats-?  WHERE flightno=?";
			}
			if (bookInfo.getClassType().equals("Business")
					&& businessseat > bookInfo.getNoOfPassengers()) {
				updateSql = "UPDATE FlightInformation SET bussseats=bussseats-?  WHERE flightno=?";

			}

			String bookingId = getNextBookingId();
			String insertSql = "INSERT INTO bookinginformation VALUES(?,?,?,?,?,?,?,?,?,?)";
       
			preparedStatement = connection.prepareStatement(insertSql);
			
			preparedStatement.setString(1, bookingId);
			preparedStatement.setString(3, bookInfo.getCustEmail());
			preparedStatement.setInt(4, bookInfo.getNoOfPassengers());
			preparedStatement.setString(5, bookInfo.getClassType());
			preparedStatement.setDouble(6, bookInfo.getTotalFare());
			preparedStatement.setString(7, bookInfo.getSeatNumbers());
			preparedStatement.setString(8, bookInfo.getCreditCardInfo());
			preparedStatement.setString(9, bookInfo.getDepCity());
			preparedStatement.setString(10, bookInfo.getArrCity());
			preparedStatement.setString(2, bookInfo.getFlightNo());
			//System.out.println(preparedStatement.executeUpdate());
			int insertRows= preparedStatement.executeUpdate();
			//System.out.println(preparedStatement);
			System.out.println("yhgsgsudy");
			if (insertRows != 0) {
				System.out.println(insertRows);
				preparedStatement = connection.prepareStatement(updateSql);
				preparedStatement.setInt(1, bookInfo.getNoOfPassengers());
				preparedStatement.setString(2, bookInfo.getFlightNo());

				int updateRows = preparedStatement.executeUpdate();

				if (updateRows != 0) {
					System.out.println(bookingId);
					resultBook= bookingId;
					return resultBook;
				}
			}
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				//connection.rollback();
			} catch (SQLException e) {

				throw new ArsException(e.getMessage());
			}
		}
		return resultBook;
	}

	private String getNextBookingId() {
	Random random=new Random();
	StringBuffer sb=new StringBuffer();
	
	sb.append(random.nextInt(9)+1);
	for(int i=0;i<5;i++){
		sb.append(random.nextInt(10));
	}
		return sb.toString();
	}

	@Override
	public int cancelReservation(String bookingId) throws ArsException,SQLException{
		String sql = "DELETE FROM bookinginformation where booking_id=?";
		
		int dataDeleted = 0;
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			// setting the placeholder values
			preparedStatement.setString(1, bookingId);
			System.out.println(bookingId);
			dataDeleted = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {

			throw new ArsException(e.getMessage());
		 }finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {

				throw new ArsException(e.getMessage());
			}
		}
		return dataDeleted;
	}

	@Override
	public ArrayList<BookingInformation> showReservation(String userName)
			throws ArsException {
		ArrayList<BookingInformation> bookList = new ArrayList<BookingInformation>();
		Connection connection = DBUtil.obtainConnection();
		String sql = "SELECT * FROM bookinginformation WHERE username=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			rsSet = preparedStatement.executeQuery();
			while (rsSet.next()) {
				BookingInformation book = new BookingInformation();
				book.setBookingId(rsSet.getString("booking_id"));
				book.setCustEmail(rsSet.getString("cust_email"));
				book.setNoOfPassengers(rsSet.getInt("no_of_passengers"));
				book.setClassType(rsSet.getString("class_type"));
				book.setTotalFare(rsSet.getDouble("total_fare"));
				//book.setSeatNumbers(rsSet.getInt("seat_number"));

				book.setCreditCardInfo(rsSet.getString("creditcard_info"));
				book.setDepCity(rsSet.getString("dep_city"));
				book.setArrCity(rsSet.getString("arr_city"));

				bookList.add(book);
			}
		} catch (SQLException e) {
			throw new ArsException("Error while database interaction:::"
					+ e.getMessage());
		}

		return bookList;
	}

	
}
