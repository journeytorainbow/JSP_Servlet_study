package com.servlet;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/loginCon")
public class loginCon extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String mID = request.getParameter("mID");
		String mPW = request.getParameter("mPW");
		
		out.print("mID : " + mID);
		out.print("mPW : " + mPW);
		
		HttpSession session = request.getSession();
		session.setAttribute("memberId", mID);
		
		response.sendRedirect("loginOk.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}