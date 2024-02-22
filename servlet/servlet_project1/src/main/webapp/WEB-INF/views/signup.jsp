<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<!-- 아이디, 비번, 비번확인, 이메일을 입력받아 서버로 전송하는 코드 get과 post 중에 선택해서 전송 -->
	<form action="<%=request.getContextPath()%>" method="post">
		<input type="text" name="id" placeholder="아이디">
		<br>
		<input type="password" name="pw" placeholder="비번">
		<br>
		<input type="password" name="pw2" placeholder="비번확인">
		<br>
		<input type="text" name="email" placeholder="이메일">
		<br>
		<button>회원가입</button>
	</form>
</body>
</html>