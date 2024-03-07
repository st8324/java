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
<jsp:include page="/WEB-INF/views/header.jsp"/>
<div class="container">
	<form action="<c:url value="/signup"/>" method="post">
		<h1>회원가입</h1>
		<div class="mb-3 mt-3">
			<label for="id" class="form-label">아이디</label>
			<input type="text" class="form-control" id="id" placeholder="아이디" name="id">
		</div>
		<div class="mb-3 mt-3">
			<button type="button" class="btn btn-outline-success col-12" id="idCheck">아이디 중복 검사</button>
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
<script src="//code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
	let flag = false;
	$("#idCheck").click(function(){
		
		let id = $("[name=id]").val();
		$.ajax({
			url : '<c:url value="/id/check"/>',
			method : 'get',
			async : true, //동기/비동기 선택, true : 비동기, false : 동기
			data : {
				"id" : id
			},
			success : function(data){
				if(data){
					alert("사용 가능한 아이디입니다.");
					flag = true;
				}else{
					alert("이미 사용중인 아이디입니다.");
				}
			},
			error : function (a, b, c) {
				console.error("예외 발생");
			}
		});//ajax end
		
	});//click end
	$("form").submit(function(){
		if(!flag){
			alert("아이디 중복 검사를 해야합니다.");
			return false;
		}
	})
	$("[name=id]").change(function(){
		flag = false;
	})
</script>
</body>
</html>