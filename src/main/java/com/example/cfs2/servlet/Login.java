package com.example.cfs2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.cfs2.servlet.filter.User;

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
        if (name == null || password ==null) {
            log.info("Parameter user is null!");
            name = "";
        } else {
            log.debug("Parameter user is '{}'", name);
        }
        
        if("user@gmail.com".equals(name) && "password".equals(password)) {
        	User user = new User(name, password);
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		request.getRequestDispatcher("profilo.jsp").forward(request, response);
        }else {
            response.setContentType("text/html");
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h3 style='color: red;'>Utente non trovato.</h3>");
            response.getWriter().println("<a href='login.html'>Torna al login</a>");
            response.getWriter().println("<a href='signup.html'>Nuovo utente? Registrati.</a>");
            response.getWriter().println("</body></html>");
        }
		
		
				

		}

	}

