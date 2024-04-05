<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
</head>
<body>
<div class="container">
	<h1>게시글 등록</h1>
	<form action="<c:url value="/post/insert"/>" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label for="community">게시판:</label>
			<select class="form-control" id="community" name="bo_co_num">
				<c:forEach items="${list}" var="co">
					<option value="${co.co_num}">${co.co_name }</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label for="title">제목:</label>
			<input type="text" class="form-control" id="title" name="bo_title" required>
		</div>
		<div class="form-group">
			<label for="content">내용:</label>
			<textarea class="form-control" id="content" name="bo_content" required rows="10"></textarea>
		</div>
		<div class="form-group">
			<input type="file" class="form-control" name="files">
			<input type="file" class="form-control" name="files">
			<input type="file" class="form-control" name="files">
		</div>
		<button type="submit" class="btn btn-outline-success col-12">게시글 등록</button>
	</form>
</div>
</body>
</html>
