package com.servlet;

import java.io.IOException;

import javax.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/se")
public class ServletEx extends HttpServlet {
	
	// servlet 실행
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println(" -- doGet() -- ");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println(" -- postConstruct() --");
	}
	
	// servlet 생성
	@Override
	public void init() throws ServletException {
		System.out.println(" -- init() --");
	}
	
	@Override
	// servlet 종료
	public void destroy() {
		System.out.println(" -- destroy() --");
	}

	@PreDestroy
	public void preConstruct() {
		System.out.println(" -- preDestory() --");
	}
}