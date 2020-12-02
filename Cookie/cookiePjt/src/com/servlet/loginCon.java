package com.servlet;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/loginCon")
public class loginCon extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String mId = request.getParameter("mID");
		String mPw = request.getParameter("mPW");
		
		out.print("<p>mId : " + mId + "</p>");
		out.print("<p>mPw : " + mPw + "</p>");
		
		// request객체를 이용해 사용자 쪽에 쿠키가 있는지 조회
		Cookie[] cookies = request.getCookies(); 
		// 초기화
		Cookie cookie = null;
		
		for(Cookie c : cookies) {
			System.out.println("쿠키 이름 : " + c.getName() + " " + "쿠키 값 : " + c.getValue());
			
			if(c.getName().equals("memberId")) { // 쿠기가 존재하는 경우
				cookie = c;
			}
		}
		
		if(cookie == null) { // 쿠키가 존재하지 않는 경우
			System.out.println("cookie is null");
			cookie = new Cookie("memberId", mId);
		}
		
		response.addCookie(cookie); // 응답 시에 쿠키를 넘김
		cookie.setMaxAge(60*60); // 쿠키 유효 기간 설정(1시간) (초단위)
		response.sendRedirect("loginOk.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}