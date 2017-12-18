package com.cg.ars.controller;

import java.io.IOException;
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
import com.cg.ars.service.ExecutiveService;
import com.cg.ars.service.ExecutiveServiveImpl;

/**
 * Servlet implementation class ExecutiveController
 */
@WebServlet("/ExecutiveController")
public class ExecutiveController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExecutiveController() {
		super();
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
		ExecutiveService service = new ExecutiveServiveImpl();
		String operation = request.getParameter("op");
		int op = Integer.parseInt(operation);
		switch (op) {
		// vefying the executive
		case 1:
			try {
				System.out.println(op);
				String userId = request.getParameter("userName");
				String password = request.getParameter("password");
				boolean result = service.verifyExecutive(userId, password);

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
							"executive.jsp");
					view.forward(request, response);
				}
			} catch (ArsException e) {
				request.setAttribute("errMsg", e.getMessage());
				request.getRequestDispatcher("error.jsp").forward(request,
						response);
			}
			break;

		// Fetech All the flight list in which seat is avilable
		case 2:
			try {
				List<FlightInformation> list = service.viewFlightOccu();
				if (list == null) {
					request.setAttribute("errMsg",
							"Executive Does Not Exist Please try After Some time");
					view = getServletContext()
							.getRequestDispatcher("error.jsp");
					view.forward(request, response);
				} else {

					request.setAttribute("list", list);
					view = getServletContext().getRequestDispatcher("view.jsp");
					view.forward(request, response);
				}

			} catch (ArsException e) {
				request.setAttribute("errMsg", e.getMessage());
				request.getRequestDispatcher("error.jsp").forward(request,
						response);
			}
			break;
		}// end of switch
	}// end of method
}// end of clas
