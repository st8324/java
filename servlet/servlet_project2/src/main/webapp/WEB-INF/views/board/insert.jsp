<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<div class="container">
	<form action="<c:url value="/board/insert"/>" method="post" enctype="multipart/form-data">
		<h1>게시글 등록</h1>
		<div class="mb-3 mt-3">
			<label for="community" class="form-label">게시판</label>
			<select class="form-control" name="community" id="community">
				<c:forEach items="${list}" var="community">
					<option value="${community.co_num }">${community.co_name }</option>
				</c:forEach>
			</select>
		</div>
		<div class="mb-3 mt-3">
			<label for="title" class="form-label">제목</label>
			<input type="text" class="form-control" id="title" placeholder="제목" name="title">
		</div>
		<div class="mb-3 mt-3">
			<label for="content" class="form-label">내용</label>
			<textarea rows="10" class="form-control" id="content" placeholder="내용" name="content"></textarea>
		</div>
		<div class="mb-3 mt-3">
			<label class="form-label">첨부파일</label>
			<input type="file" name="file" class="form-control">
			<input type="file" name="file" class="form-control">
			<input type="file" name="file" class="form-control">
		</div>
		<button type="submit" class="btn btn-outline-success col-12">등록하기</button>
	</form>
</div>
</body>
</html>