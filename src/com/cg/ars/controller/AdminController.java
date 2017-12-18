package com.cg.ars.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.ars.bean.FlightInformation;
import com.cg.ars.exception.ArsException;
import com.cg.ars.service.AdminService;
import com.cg.ars.service.AdminServiceImpl;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ram");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher view = null;
		// Initial setting the session parameter to false
		 HttpSession session = request.getSession(false);
		response.setContentType("text/html");
		AdminService service = new AdminServiceImpl();
		String operation = request.getParameter("op");
		int op = Integer.parseInt(operation);
		System.out.println("hello");
		switch (op) {

		// case of admin Login
		case 1:

			// session = request.getSession(true);
			try {
				if(session == null) {
					session = request.getSession(true);
				}
				System.out.println("fsdvbjh");
				System.out.println(op);
				String userId = request.getParameter("username");
				System.out.println(userId);
				session.setAttribute("userName", userId);
				if(session.getAttribute("userName")==null || session.getAttribute("userName")=="") {
					view = getServletContext().getRequestDispatcher(
							"/commonLogin.jsp");
					view.forward(request, response);
				}
		
				String password = request.getParameter("password");
				System.err.println(password);
				System.out.println("fsgbfh");
				boolean result = service.veriyfAdmin(userId, password);
				System.out.println("below service");
				System.out.println(result);
				// method to fetech all customer details
				// to-do
				if (result == false) {
					request.setAttribute("errMsg",
							"Admin Does Not Exit Please try After Some time");
					view = getServletContext()
							.getRequestDispatcher("/error.jsp");
					view.forward(request, response);
				} else {
					view = getServletContext().getRequestDispatcher(
							"/adminButton.jsp");
					view.forward(request, response);
				}
			} catch (ArsException e) {
				System.out.println("catch  of admin");
				e.printStackTrace();
				request.setAttribute("errMsg", e.getMessage());
				request.getRequestDispatcher("/error.jsp").forward(request,
						response);
			}
			break;
		// Transfer to Update Page
		case 2:
			if(session.getAttribute("userName")==null || session.getAttribute("userName")=="") {
				view = getServletContext().getRequestDispatcher(
						"/commonLogin.jsp");
				view.forward(request, response);
			}

			view = getServletContext().getRequestDispatcher("update.jsp");
			view.forward(request, response);
			break;
		// Pass Flight Id and get Flight Inforamtion
		case 3:
			String flightNo = request.getParameter("flightId");
			try {
				List<FlightInformation> flight = service.viewFlightById(flightNo);
				if (flight == null) {
					request.setAttribute("errMsg", "Flight Does NOt Exits");
					request.getRequestDispatcher("error.jsp").forward(request,
							response);
				} else
					request.setAttribute("flight", flight);
				request.getRequestDispatcher("update.jsp").forward(request,
						response);

			} catch (ArsException e) {
				request.setAttribute("errMsg", e.getMessage());
				request.getRequestDispatcher("error.jsp").forward(request,
						response);
			}
			break;
		// Pass Date And Destination and get List Of Flight
		case 4:
			try {
				String date1 = request.getParameter("date");
				String destination = request.getParameter("destination");
				DateFormat formatter1;
				formatter1 = new SimpleDateFormat("mm/DD/yyyy");
				Date date = null;
				try {
					date = formatter1.parse(date1);
				} catch (ParseException e) {
					request.setAttribute("errMsg", "Please Select Proper Date");
					request.getRequestDispatcher("error.jsp").forward(request,
							response);
				}
				List<FlightInformation> list = service.viewFlightDest(
						destination);

				if (list == null) {
					request.setAttribute("errMsg", "Input Is Invalid");
					request.getRequestDispatcher("error.jsp").forward(request,
							response);
				} else {
					request.setAttribute("list", list);
					request.getRequestDispatcher("reportsByDay.jsp").forward(
							request, response);
				}

			} catch (ArsException e) {
				request.setAttribute("errMsg", e.getMessage());
				request.getRequestDispatcher("error.jsp").forward(request,
						response);
			}
			break;
		case 5:
			try {
				String flightId = request.getParameter("flightId");
				List<String> list = service.viewPassengersByFlight(flightId);
				list = service.viewPassengersByFlight(flightId);
				if (list == null) {
					request.setAttribute("errMsg", "Flight Does NOt Exits");
					request.getRequestDispatcher("error.jsp").forward(request,
							response);
				} else
					request.setAttribute("list", list);
				request.getRequestDispatcher("reportByPassenger.jsp").forward(
						request, response);

			} catch (ArsException e) {
				request.setAttribute("errMsg", e.getMessage());
				request.getRequestDispatcher("error.jsp").forward(request,
						response);
			}
			break;
		case 6:
			try {

				String flightNo1 = request.getParameter("flightNo");
				String airline = request.getParameter("airline");

				String departureCity = request.getParameter("departureCity");
				String arrivalCity = request.getParameter("arrivalCity");

				DateFormat formatter1;
				formatter1 = new SimpleDateFormat("mm/DD/yyyy");
				Date departureDate = null;
				Date arrivalDate = null;
				try {
					departureDate = formatter1.parse(request
							.getParameter("departureDate"));
					arrivalDate = formatter1.parse(request
							.getParameter("arrivalDate"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				String departureTime = request.getParameter("departureTime");
				String arrivalTime = request.getParameter("arrivalTime");
				int firstSeats = Integer.parseInt(request
						.getParameter("firstSeats"));
				double firstSeatFare = Double.parseDouble(request
						.getParameter("firstSeatFare"));
				int bussinessSeats = Integer.parseInt(request
						.getParameter("bussinessSeats"));
				double bussinessSeatsFare = Double.parseDouble(request
						.getParameter("bussinessSeatsFare"));
				FlightInformation flight = new FlightInformation(flightNo1,
						airline, departureCity, arrivalCity, departureDate,
						arrivalDate, departureTime, arrivalTime, firstSeats,
						firstSeatFare, bussinessSeats, bussinessSeatsFare);
				boolean result = service.updateFlightInfo(flight);
				if (result == false) {
					request.setAttribute("errMsg", "Something is Wrong");
					request.getRequestDispatcher("error.jsp").forward(request,
							response);
				} else {
					request.getRequestDispatcher("adminButton.jsp").forward(
							request, response);
				}

			} catch (ArsException e) {
				request.setAttribute("errMsg", e.getMessage());
				request.getRequestDispatcher("error.jsp").forward(request,
						response);
			}
			break;
		}// end of switch
	}// edn of method
}// end of class