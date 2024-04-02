<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>회원가입</title>
</head>
<body>
<div class="container">
	<h1>회원가입</h1>
	<form action="<c:url value="/signup"/>" method="post">
		<div class="form-group">
			<label for="id">아이디:</label>
			<input type="text" class="form-control" id="id" name="me_id" required>
		</div>
		<div class="form-group">
			<label for="pw">비번:</label>
			<input type="password" class="form-control" id="pw" name="me_pw" required>
		</div>
		<div class="form-group">
			<label for="pw2">비번확인:</label>
			<input type="password" class="form-control" id="pw2">
		</div>
		<div class="form-group">
			<label for="email">이메일:</label>
			<input type="email" class="form-control" id="email" name="me_email" required>
		</div>
		<button type="submit" class="btn btn-outline-success col-12">회원가입</button>
	</form>
</div>
</body>
</html>
