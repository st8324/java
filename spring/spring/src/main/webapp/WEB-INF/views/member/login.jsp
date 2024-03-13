<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<form action="<c:url value="/login"/>" method="post">
	<h1>로그인</h1>
	<div class="form-group">
		<label for="id">아이디</label>
		<input type="text" class="form-control" id="id" name="id">
	</div>
	<div class="form-group">
		<label for="pw">비번</label>
		<input type="password" class="form-control" id="pw" name="pw">
	</div>
	<button class="btn btn-outline-success col-12">회원가입</button>
</form>
</body>
</html>