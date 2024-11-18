package com.example.cfs2.servlet;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/signup")
public class SignUp extends HttpServlet {
	private static final Logger log = LogManager.getLogger(Login.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("signup.html").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("name");
		String surname = request.getParameter("surname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String repeatPassword = request.getParameter("repeatpassword");
		String day = request.getParameter("day");
		String month = request.getParameter("month");
		String year = request.getParameter("year");

		log.debug("Name: {}, surname: {}, email: {}, password: {} , day: {}, month: {}, year: {}", firstName, surname,
				email, password, day, month, year);
		if (firstName == null || email == null || password == null) {
			log.info("One or more parameters are null!");
		} else {
			log.debug("All fields completed");
		}
		if(password.equals(repeatPassword)) {

		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		StringBuilder user = new StringBuilder();
		for (int i = 0; i < email.length(); i++) {
			if (email.charAt(i) != '@') {
				user.append(email.charAt(i));
			} else {
				break;
			}
		}

		HttpSession session = request.getSession();
		session.setAttribute("username", user.toString());
		request.getRequestDispatcher("profilo.jsp").forward(request, response);
		}else {
            response.setContentType("text/html");
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h3 style='color: red;'>Passwords do not match. Please try again.</h3>");
            response.getWriter().println("<a href='signup.html'>Go back to Sign Up</a>");
            response.getWriter().println("</body></html>");
			
		}

	}

}
