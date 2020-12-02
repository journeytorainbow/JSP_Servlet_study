<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%!
		String m_name;
		String m_pass;
		String[] m_hobbies;
		%>
		
		<%
		m_name = request.getParameter("m_name");
		m_pass = request.getParameter("m_pass");
		m_hobbies = request.getParameterValues("m_hobby");
		%>
		
		m_name : <%= m_name%><br>
		m_pass : <%= m_pass%><br>
		m_hobbies : 
		<%
		for (String m_hobby : m_hobbies) {
		%>
			<%= m_hobby%>
		<%
		}
		%> <br>
	</body>
</html>