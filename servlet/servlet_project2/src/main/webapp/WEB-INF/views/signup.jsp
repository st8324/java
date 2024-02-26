<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<div class="container-fluid">
		<a class="navbar-brand" href="<c:url value="/"/>">Logo</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link" href="<c:url value="/signup"/>">회원가입</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">Link</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">Link</a>
				</li>  
			</ul>
		</div>
	</div>
</nav>
<div class="container">
	<form action="<c:url value="/signup"/>" method="post">
		<h1>회원가입</h1>
		<div class="mb-3 mt-3">
			<label for="id" class="form-label">아이디</label>
			<input type="text" class="form-control" id="id" placeholder="아이디" name="id">
		</div>
		<div class="mb-3 mt-3">
			<label for="pw" class="form-label">비번</label>
			<input type="password" class="form-control" id="pw" placeholder="비번" name="pw">
		</div>
		<div class="mb-3 mt-3">
			<label for="pw2" class="form-label">비번</label>
			<input type="password" class="form-control" id="pw2" placeholder="비번확인" name="pw2">
		</div>
		<div class="mb-3 mt-3">
			<label for="email" class="form-label">이메일</label>
			<input type="text" class="form-control" id="email" placeholder="이메일" name="email">
		</div>
		<button type="submit" class="btn btn-outline-success col-12">회원가입</button>
	</form>
</div>

</body>
</html>