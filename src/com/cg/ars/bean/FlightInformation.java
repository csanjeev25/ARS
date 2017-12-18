package com.cg.ars.bean;

import java.util.Date;

public class FlightInformation {

	private String flightNo;
	private String airline;
	private String departureCity;
	private String arrivalCity;
	private Date departureDate;
	private Date arrivalDate;
	private String departureTime;
	private String arrivalTime;
	private int firstSeats;
	private double firstSeatFare;
	private int bussinessSeats;
	private double bussinessSeatsFare;
	
	
	public FlightInformation() {
		// TODO Auto-generated constructor stub
	}
	
	
	public FlightInformation(String flightNo, String airline,
			String departureCity, String arrivalCity, Date departureDate,
			Date arrivalDate, String departureTime, String arrivalTime,
			int firstSeats, double firstSeatFare, int bussinessSeats,
			double bussinessSeatsFare) {
		super();
		this.flightNo = flightNo;
		this.airline = airline;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.firstSeats = firstSeats;
		this.firstSeatFare = firstSeatFare;
		this.bussinessSeats = bussinessSeats;
		this.bussinessSeatsFare = bussinessSeatsFare;
	}


	// Getters and Setters
	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getFirstSeats() {
		return firstSeats;
	}

	public void setFirstSeats(int firstSeats) {
		this.firstSeats = firstSeats;
	}

	public double getFirstSeatFare() {
		return firstSeatFare;
	}

	public void setFirstSeatFare(double firstSeatFare) {
		this.firstSeatFare = firstSeatFare;
	}

	public int getBussinessSeats() {
		return bussinessSeats;
	}

	public void setBussinessSeats(int bussinessSeats) {
		this.bussinessSeats = bussinessSeats;
	}

	public double getBussinessSeatsFare() {
		return bussinessSeatsFare;
	}

	public void setBussinessSeatsFare(double bussinessSeatsFare) {
		this.bussinessSeatsFare = bussinessSeatsFare;
	}

	@Override
	public String toString() {
		return "FlightInformation [flightNo=" + flightNo + ", airline="
				+ airline + ", departureCity=" + departureCity
				+ ", arrivalCity=" + arrivalCity + ", departureDate="
				+ departureDate + ", arrivalDate=" + arrivalDate
				+ ", departureTime=" + departureTime + ", arrivalTime="
				+ arrivalTime + ", firstSeats=" + firstSeats
				+ ", firstSeatFare=" + firstSeatFare + ", bussinessSeats="
				+ bussinessSeats + ", bussinessSeatsFare=" + bussinessSeatsFare
				+ "]";
	}
	
	
}
