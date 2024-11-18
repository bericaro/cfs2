package com.example.cfs2.servlet;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.cfs2.servlet.filter.User;

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
		if (password.equals(repeatPassword)) {

			response.setContentType("text/plain");
			response.setCharacterEncoding("utf-8");
			User user = new User();
			user.setEmail(email);
			user.setPassword(password);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			request.getRequestDispatcher("profilo.jsp").forward(request, response);
		}

	}

}
