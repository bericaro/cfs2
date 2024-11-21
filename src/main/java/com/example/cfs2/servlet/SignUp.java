package com.example.cfs2.servlet;

import java.io.IOException;

import java.time.LocalDate;
import java.time.Period;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.cfs2.servlet.beans.Utenti;
import com.example.cfs2.servlet.dao.DaoConnection;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SuppressWarnings("serial")
@WebServlet("/signup")
public class SignUp extends HttpServlet {
	@Resource(name = "jdbc/storyflow")
	private DataSource ds;
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
		Date birth = new Date(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
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

//				CALCOLO ETA' PER FILTRO
//			LocalDate birth = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
//				int age = Period.between(birth, LocalDate.now()).getYears();
			Utenti user = new Utenti();
			DaoConnection retrieveUser = new DaoConnection();
			retrieveUser.setDs(ds);
			user = retrieveUser.signUp(firstName, surname, email, password, birth);
//			user.setEmail(email);
//			user.setPassword(password);
//			user.setName(firstName);
//			user.setSurname(surname);
//			user.setBirth(birth);
//				String query = """
//						INSERT INTO users (nome,cognome,email,password) VALUES(?,?,?,?)""";
//				try (PreparedStatement stmt = conn.prepareStatement(query)) {
//					stmt.setString(1, user.getName().toString());
//					stmt.setString(2, user.getSurname().toString());
//					stmt.setString(3, user.getEmail().toString());
//					stmt.setString(4, user.getPassword().toString());
//					int rs = stmt.executeUpdate();
//					response.setContentType("text/plain");
//					response.setCharacterEncoding("utf-8");

			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			request.getRequestDispatcher("profilo.jsp").forward(request, response);

		}

	}
}
