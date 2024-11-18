package com.example.cfs2.servlet;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/passdimenticata")
public class PassDimenticata extends HttpServlet {
		private static final Logger log = LogManager.getLogger(Login.class);
		
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		request.getRequestDispatcher("passdimenticata.html").forward(request, response);	
		}

		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String email = request.getParameter("email");
			
		}
}
