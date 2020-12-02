<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	
		<!-- 쿠키를 조회해서 쿠키가 있다면 loginOk페이지로 리다이렉트 -->
		<!-- 쿠키가 존재하지 않는 경우에만, 로그인 form이 보여지게 됨 -->
		<%
			Cookie[] cookies = request.getCookies();
			System.out.println("cookies : " + cookies);
			
			if(cookies != null) {
				for(Cookie c : cookies) {
					
					if(c.getName().equals("memberId")) {
						response.sendRedirect("loginOk.jsp");
					}
				}
			}
		%>
		
		<form action="loginCon" method="post">
			ID : <input type="text" name="mID"><br>
			PW : <input type="password" name="mPW"><br>
			<input type="submit" value="login">
		</form>
		
	</body>
</html>