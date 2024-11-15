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
//		String name = request.getParameter("email");
//		String password = request.getParameter("password");
//		log.debug("Name: {}, password: {}", name, password);
//        if (name == null || password ==null) {
//            log.info("Parameter user is null!");
//            name = "";
//        } else {
//            log.debug("Parameter user is '{}'", name);
//        }
//
//		response.setContentType("text/plain");
//		response.setCharacterEncoding("utf-8");
//		StringBuilder user = new StringBuilder();
//		for (int i = 0; i<name.length(); i++) {
//			if(name.charAt(i)!= '@') {
//				user.append(name.charAt(i));
//			}else {
//				break;
//			}
//		}
//		HttpSession session = request.getSession();
//		session.setAttribute("username", user.toString());
//		request.getRequestDispatcher("welcome.jsp").forward(request, response);
//		
//		
				

		}
}
