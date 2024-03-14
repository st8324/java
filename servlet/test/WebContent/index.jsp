<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 정보 조회(회원 번호 검색)</h1>
<form action="<c:url value="/select/user"/>">
	<input type="text" name="num" placeholder="회원 번호 입력">
	<button type="submit">조회</button>
</form>
</body>
</html>