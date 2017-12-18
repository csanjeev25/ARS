package com.cg.ars.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.ars.bean.BookingInformation;
import com.cg.ars.bean.FlightInformation;
import com.cg.ars.exception.ArsException;
import com.cg.ars.service.CustomerServiceImpl;
import com.cg.ars.service.ICustomerService;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class CustController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public CustController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
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
		ICustomerService  service = new CustomerServiceImpl();
		String operation = request.getParameter("op");
		int op = Integer.parseInt(operation);
		switch (op) {

		case 1:
			try {
				System.out.println(op);
				String userName = request.getParameter("userName");
				session.setAttribute("userName", userName);
				String password = request.getParameter("password");
				boolean result = service.verifyUser(userName, password);

				// method to fetech all customer details
				// to-do
				if (result == false) {
					request.setAttribute("errMsg",
							"Admin Does Not Exit Please try After Some time");
					view = getServletContext()
							.getRequestDispatcher("error.jsp");
					view.forward(request, response);
				} else {
					view = getServletContext().getRequestDispatcher(
							"customerButton.jsp");
					view.forward(request, response);
				}
			} catch (ArsException e) {
				request.setAttribute("errMsg", e.getMessage());
				request.getRequestDispatcher("error.jsp").forward(request,
						response);
			}
			break;

		// Fetech All The Flight Information
		case 2:
			try {
				ArrayList<FlightInformation> list = new ArrayList<FlightInformation>();
				list = service.showFlightInfo();
				if (list == null) {
					request.setAttribute("errMsg",
							"Admin Does Not Exit Please try After Some time");
					view = getServletContext()
							.getRequestDispatcher("error.jsp");
					view.forward(request, response);
				} else {
					request.setAttribute("list", list);
					view = getServletContext().getRequestDispatcher(
							"schedule.jsp");
					view.forward(request, response);
				}
			} catch (ArsException e) {
				request.setAttribute("errMsg", e.getMessage());
				request.getRequestDispatcher("error.jsp").forward(request,
						response);
			}
			break;

		// cancel Reservation

		case 3:
			try {
				String bookingId = request.getParameter("bookingId");
				int deletedId=0;
				try {
					deletedId = service.cancelReservation(bookingId);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (deletedId == 0) {
					request.setAttribute("errMsg",
							"Your Reservation is Not deleted please try after some time");
					view = getServletContext()
							.getRequestDispatcher("error.jsp");
					view.forward(request, response);
				} else {

					view = getServletContext().getRequestDispatcher(
							"userButton.jsp");
					view.forward(request, response);
				}

			} catch (ArsException e) {
				request.setAttribute("errMsg", e.getMessage());
				request.getRequestDispatcher("error.jsp").forward(request,
						response);
			}
			break;

		case 4:
			try {
				String userName = (String) session.getAttribute("userName");
				ArrayList<BookingInformation> list = service
						.showReservation(userName);
				if (list == null) {

					request.setAttribute("errMsg", "Some Went Wrong Get Lost");
					view = getServletContext()
							.getRequestDispatcher("error.jsp");
					view.forward(request, response);
				} else {

					view = getServletContext().getRequestDispatcher(
							"viewCustomer.jsp");
					view.forward(request, response);
				}

			} catch (ArsException e) {
				request.setAttribute("errMsg", e.getMessage());
				request.getRequestDispatcher("error.jsp").forward(request,
						response);
			}
			break;

		case 5:	
			
			
		}// end of switch

	}// end of method

}// end of class

