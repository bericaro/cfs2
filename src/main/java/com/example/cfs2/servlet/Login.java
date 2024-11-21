package com.example.cfs2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.cfs2.servlet.beans.Utenti;
import com.example.cfs2.servlet.dao.DaoConnection;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/login")
public class Login extends HttpServlet {
	@Resource(name = "jdbc/storyflow")
	private DataSource ds;
	private static final Logger log = LogManager.getLogger(Login.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.html").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("email");
		String password = request.getParameter("password");
		log.debug("Name: {}, password: {}", name, password);
		if (name == null || password == null) {
			log.info("Parameter user is null!");
			name = "";
		} else {
			log.debug("Parameter user is '{}'", name);
		}
		Utenti user = new Utenti(name, password);
		DaoConnection logIn = new DaoConnection();
		logIn.setDs(ds);
		if (!logIn.logInUser(user)) {
			response.setContentType("text/html");
			response.getWriter().println("<html><body>");
			response.getWriter().println("<h3 style='color: red;'>Username o password errati. Prova di nuovo.</h3>");
			response.getWriter().println("<p><a href='signup.html'>Nuovo utente? Registrati</a></p>");
			response.getWriter().println("<a href='login.html'>Torna al login</a>");
			response.getWriter().println("</body></html>");
		} else {
			response.setContentType("text/plain");
			response.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			request.getRequestDispatcher("profilo.jsp").forward(request, response);
		}

	}
}
