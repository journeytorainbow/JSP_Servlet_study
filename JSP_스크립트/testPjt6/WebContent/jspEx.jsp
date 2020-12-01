<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		
		<!-- 지시어 태그 : include(다른 페이지 삽입) -->
		<%@ include file="header.jsp" %>
		
		<!-- 선언 태그 -->
		<%!
		int num = 10;
		String str = "jsp";	
		ArrayList<String> list = new ArrayList<>();
		
		public void jspMethod() {
			System.out.println(" --jspMethod() -- ");
		}
		%>
		
		<!-- 주석 태그 -->
		<!-- 여기는 주석입니다. -->
		<%-- JSP 주석입니다. --%>
		
		<!-- 스크립트릿 태그 -->
		<%
			if(num > 0) {
		%>
			<p>num > 0</p>
		<%
			} else {
		%>
			<p>num <= 0</p>
		<%
			}
		%>
		
		<!-- 표현식 태그 -->
		num is <%= num %>
		
		<%@ include file="footer.jsp" %>
	</body>
</html>