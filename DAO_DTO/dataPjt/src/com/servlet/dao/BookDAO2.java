package com.servlet.dao;

import java.awt.print.*;

import java.sql.*;
import java.util.*;

import javax.naming.*;
import javax.sql.*;

import com.servlet.dto.*;
import oracle.jdbc.proxy.annotation.*;

// 커넥션풀을 이용한 코드
// BookDAO.java(커넥션풀 이용X)와 비교해보자
public class BookDAO2 {
	
	DataSource dataSource;
	
//	String driver = "oracle.jdbc.driver.OracleDriver";
//	String url = "jdbc:oracle:thin:@localhost:1521:xe";
//	String id = "c##ebichu";
//	String pw = "1234";

	public BookDAO2() {
		try {
//			Class.forName(driver);
			
			// 컨테이너로 부터 커넥션풀을 찾아온다
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle18c"); // context.xml에 지정해준 커넥션풀의 이름(name값)
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 이 메소드가 호출되면, 디비에 접근해서 데이터를 가져오도록 작성
	public ArrayList<BookDTO> select() {
		
		ArrayList<BookDTO> list = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		try {
//			con = DriverManager.getConnection(url, id, pw);
			con = dataSource.getConnection(); // 커넥션풀에서 커넥션을 rent
			String sql = "SELECT * FROM book";
			pstmt = con.prepareStatement(sql);
			res = pstmt.executeQuery();
			
			while (res.next()) {
				int bookId = res.getInt("idx");
				String bookName = res.getString("book_name");
				String bookLoc = res.getString("book_loc");
				
				BookDTO bookDTO = new BookDTO(bookId, bookName, bookLoc);
				list.add(bookDTO);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(res != null) res.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return list;
	}
}
