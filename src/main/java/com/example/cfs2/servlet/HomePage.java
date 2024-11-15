package com.example.cfs2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/homepage")
public class HomePage extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		if("login".equals(action)) {
			response.sendRedirect("login.html");	
		}else if("signup".equals(action)) {
			request.getRequestDispatcher("signup.html").forward(request, response);
		}

		

	}
}
