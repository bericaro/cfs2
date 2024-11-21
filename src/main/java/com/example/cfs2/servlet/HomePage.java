package com.example.cfs2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.cfs2.servlet.beans.Libri;
import com.example.cfs2.servlet.dao.DaoConnection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/home")
public class HomePage extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("home.html").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		DaoConnection categorie = new DaoConnection();
		List<Libri> libriList = new ArrayList<>();
		HttpSession session = request.getSession();
		if ("manga".equals(action)) {
			response.setContentType("text/plain");
			response.setCharacterEncoding("utf-8");
			String manga = "Manga";
//			request.setAttribute("categoria", manga);
			session.setAttribute("categoria", manga);
			request.getRequestDispatcher("category.jsp").forward(request, response);
		} else if (action.equals("libri")) {
			response.setContentType("text/plain");
			response.setCharacterEncoding("utf-8");
			String libri = "Libri";
			libriList = categorie.retrieveLibri();
			session.setAttribute("categoria", libri);
			session.setAttribute("libri", libriList);
			request.getRequestDispatcher("category.jsp").forward(request, response);
		}else if (action.equals("serietv")) {
			response.setContentType("text/plain");
			response.setCharacterEncoding("utf-8");
			String serieTv = "Serie TV";
			session.setAttribute("categoria", serieTv);
			request.getRequestDispatcher("category.jsp").forward(request, response);
		}else if (action.equals("fumetti")) {
			response.setContentType("text/plain");
			response.setCharacterEncoding("utf-8");
			String fumetti = "Fumetti";
			session.setAttribute("categoria", fumetti);
			
			request.getRequestDispatcher("category.jsp").forward(request, response);
		}
	}

}
