<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
	<title>테스트</title>
</head>
<body>
	<form action="<c:url value="/send/object"/>" method="post">
		<input type="text" name="list[0].id"> 
	 	<br>
	 	<input type="password" name="list[0].pw">
	 	<br>
	 	<input type="text" name="list[1].id"> 
	 	<br>
	 	<input type="password" name="list[1].pw">
	 	<br>
	 	<input type="text" name="list[2].id"> 
	 	<br>
	 	<input type="password" name="list[2].pw">
	 	<br>
	 	<button type="submit">로그인</button>
	</form>
</body>
</html>
