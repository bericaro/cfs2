package com.example.cfs2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.cfs2.servlet.beans.Fumetti;
import com.example.cfs2.servlet.beans.Libri;
import com.example.cfs2.servlet.beans.Manga;
import com.example.cfs2.servlet.beans.Scrittori;
import com.example.cfs2.servlet.beans.SerieTv;
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
@WebServlet("/home")
public class HomePage extends HttpServlet {
	@Resource(name = "jdbc/storyflow")
	private DataSource ds;
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
		categorie.setDs(ds);
		DaoConnection autori = new DaoConnection();
		autori.setDs(ds);
		List<Libri> libriList = new ArrayList<>();
		List<Manga> mangaList = new ArrayList<>();
		List<SerieTv> serieTvList = new ArrayList<>();
		List<Fumetti> fumettiList = new ArrayList<>();
		List<Scrittori> scrittori = new ArrayList<>();
		HttpSession session = request.getSession();
		if ("manga".equals(action)) {
			response.setContentType("text/plain");
			response.setCharacterEncoding("utf-8");
			String manga = "Manga";
			mangaList = categorie.retrieveManga();
//			request.setAttribute("categoria", manga);
			session.setAttribute("categoria", manga);
			session.setAttribute("listaManga", mangaList);
			request.getRequestDispatcher("category.jsp").forward(request, response);
		} else if (action.equals("libri")) {
			response.setContentType("text/plain");
			response.setCharacterEncoding("utf-8");
			String libri = "Libri";
			libriList = categorie.retrieveLibri();
			scrittori = autori.retrieveScrittori();
			session.setAttribute("categoria", libri);
			session.setAttribute("libri", libriList);
			session.setAttribute("scrittori", scrittori);
			request.getRequestDispatcher("category.jsp").forward(request, response);
		}else if (action.equals("serietv")) {
			response.setContentType("text/plain");
			response.setCharacterEncoding("utf-8");
			String serieTv = "Serie TV";
			serieTvList = categorie.retrieveSerieTv();
			session.setAttribute("categoria", serieTv);
			session.setAttribute("listaSerieTv", serieTvList);
			request.getRequestDispatcher("category.jsp").forward(request, response);
		}else if (action.equals("fumetti")) {
			response.setContentType("text/plain");
			response.setCharacterEncoding("utf-8");
			String fumetti = "Fumetti";
			fumettiList = categorie.retrieveFumetti();
			session.setAttribute("categoria", fumetti);
			session.setAttribute("fumetti", fumettiList);
			request.getRequestDispatcher("category.jsp").forward(request, response);
		}
	}

}
