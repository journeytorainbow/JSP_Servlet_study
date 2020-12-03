package com.servlet;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/modifyBook")
public class ModifyBook extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String bookName = request.getParameter("book_name");
		String bookLoc = request.getParameter("book_loc");
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "c##ebichu";
		String pw = "1234";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, id, pw); // Connection 객체 얻어오기
			
			String sql = "UPDATE book SET book_loc = ? WHERE book_name = ?"; // ?를 이용해 쿼리의 골격을 먼저 잡아줌(훨씬 깔끔해보인다)
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  "01-0001-001");
			pstmt.setString(2, "hong");
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				out.print("UPDATE success!");
			} else { 
				out.print("UPDATE fail!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}