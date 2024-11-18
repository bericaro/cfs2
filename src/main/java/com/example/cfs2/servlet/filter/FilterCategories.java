package com.example.cfs2.servlet.filter;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter({"/home", "/profilo.jsp","/storico.jsp"})
public class FilterCategories implements Filter{
//Il filtro delle categorie sarà implementato per le jsp delle categorie
//libri.jsp / manga.jsp /serieTv.jsp/ fumetti.jsp
	 public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	            throws IOException, ServletException {

	        HttpServletRequest httpRequest = (HttpServletRequest) request;
	        HttpServletResponse httpResponse = (HttpServletResponse) response;

	        // Check if the user is logged in
	        HttpSession session = httpRequest.getSession(false);

	        if (session == null || session.getAttribute("user") == null) {
	            // Redirect to login page if user is not authenticated
	            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.html");
	        } else {
	            // Continue processing the request if authenticated
	            chain.doFilter(request, response);
	        }
	    }
	
}
