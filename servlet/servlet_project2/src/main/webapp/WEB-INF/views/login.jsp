<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<div class="container">
	<form action="<c:url value="/login"/>" method="post">
		<h1>로그인</h1>
		<div class="mb-3 mt-3">
			<label for="id" class="form-label">아이디</label>
			<input type="text" class="form-control" id="id" placeholder="아이디" name="id">
		</div>
		<div class="mb-3 mt-3">
			<label for="pw" class="form-label">비번</label>
			<input type="password" class="form-control" id="pw" placeholder="비번" name="pw">
		</div>
		<button class="btn btn-outline-danger">로그인</button>
	</form>
</div>
</body>
</html>