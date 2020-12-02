package com.servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/seg")
public class ServletGet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String connectedIP = (String) getServletContext().getAttribute("connectedIP");
		String connectedUser = (String) getServletContext().getAttribute("connectedUser");
		
		PrintWriter out = response.getWriter();
		out.print("<p> connectedIP : " + connectedIP + "</p>");
		out.print("<p> connectedUser : " + connectedUser + "</p>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
