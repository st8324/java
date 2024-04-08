<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
</head>
<body>
<div class="container">
	<h1>게시글 상세</h1>
	<div class="form-group">
		<label>게시판:</label>
		<input type="text" class="form-control" readonly value="${board.bo_co_num}">
	</div>
	<div class="form-group">
		<label>제목:</label>
		<input type="text" class="form-control" readonly value="${board.bo_title }">
	</div>
	<div class="form-group">
		<label>조회수:</label>
		<input type="text" class="form-control" readonly value="${board.bo_view }">
	</div>
	<div class="form-group">
		<label>작성자:</label>
		<input type="text" class="form-control" readonly value="${board.bo_me_id }">
	</div>
	<div class="form-group">
		<label for="content">내용:</label>
		<textarea class="form-control" id="content" readonly rows="10">${board.bo_content }</textarea>
	</div>
	<div class="form-group">
		<c:forEach items="${list }" var="file">
			<c:if test="${file.img}">
				<a href="<c:url value="/download${file.fi_name}"/>" download="${file.fi_ori_name}">
					<img alt="이미지" height="100" src="<c:url value="/download${file.fi_name}"/>">
				</a>
			</c:if>
			<c:if test="${!file.img }">
				<a href="<c:url value="/download${file.fi_name}"/>" download="${file.fi_ori_name}">${file.fi_ori_name}</a>
			</c:if>
		</c:forEach>
	</div>
	<a href="<c:url value="/post/list"/>" class="btn btn-outline-success">목록으로</a>
</div>
</body>
</html>
