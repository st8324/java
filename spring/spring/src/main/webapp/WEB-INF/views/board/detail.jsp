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
<div>
	<h1>게시글 상세</h1>
	<div>
		<label>제목</label>
		<div class="form-control">${board.bo_title}</div>
	</div>
	<div>
		<label>작성자</label>
		<div class="form-control">${board.bo_me_id}</div>
	</div>
	<div>
		<label>조회수</label>
		<div class="form-control">${board.bo_view}</div>
	</div>
	<div class="input-group mb-3 mt-3">
		<button class="btn btn-outline-success btn-up col-6">추천(${board.bo_up})</button>
		<button class="btn btn-outline-success btn-down col-6">비추천(${board.bo_down})</button>
	</div>
	<div>
		<label>내용</label>
		<div class="form-control" style="min-height: 400px">${board.bo_content}</div>
	</div>
	<div>
		<c:choose>
			<c:when test="${fileList.size() != 0}">
				<label>첨부파일</label>
				<c:forEach items="${fileList }" var="file">
					<a href="<c:url value="/download${file.fi_name}"/>" 
						class="form-control"
						download="${file.fi_ori_name}">${file.fi_ori_name}</a>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<div>첨부파일 없음</div>
			</c:otherwise>
		</c:choose>
	</div>
	<c:url value="/board/list" var="url">
		<c:param name="page" value="${cri.page}"/>
		<c:param name="type" value="${cri.type}"/>
		<c:param name="search" value="${cri.search}"/>
	</c:url>
	<a href="${url}" class="btn btn-outline-dark">목록으로</a>
</div>
</body>
</html>