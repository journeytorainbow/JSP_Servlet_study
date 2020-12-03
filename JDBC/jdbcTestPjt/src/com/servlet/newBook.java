package com.servlet;

import java.beans.*;
import java.io.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jdi.connect.spi.*;

@WebServlet("/newBook")
public class newBook extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String bookName = request.getParameter("book_name");
		String bookLoc = request.getParameter("book_loc");
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "c##ebichu"; // c##을 꼭 붙여주자
		String pw = "1234";
		
		Connection con = null;
		Statement stmt = null;
		
		try {
			Class.forName(driver); // 메모리에 드라이버 로딩
			
			con = DriverManager.getConnection(url, id, pw); // Connection 객체 얻어오기
			stmt = con.createStatement(); // Statement 객체 얻어오기
			
			String sql = "INSERT INTO book(idx, book_name, book_loc)";
					sql += " VALUES (IDX_SEQ.NEXTVAL, '" + bookName + "', '" + bookLoc + "')";
			int result = stmt.executeUpdate(sql); // sql로 하나의 레코드를 삽입했으니 1이 나와야함
			
			if(result == 1) {
				out.print("INSERT success!!");
			} else {
				out.print("INSERT fail!!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 자원 해제를 위한 코드 작성
			try {
				if(stmt != null) stmt.close();
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
