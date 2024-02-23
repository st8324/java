<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 리스트</title>
<!-- 부트스트랩5 css/js -->
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
      	<c:if test="${user == null}">
	        <li class="nav-item">
	          <a class="nav-link" href="<c:url value="/signup"/>">회원가입</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="<c:url value="/login"/>">로그인</a>
	        </li>
        </c:if>
        <li class="nav-item">
          <a class="nav-link" href="<c:url value="/board/list"/>">게시글</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
<div class="container">
	<h1>게시글 리스트</h1>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>게시판</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="board">
				<tr>
					<td>${board.bo_num }</td>
					<td>${board.community.co_name}</td>
					<td>
						<a href="">${board.bo_title}</a>
					</td>
					<td>
						<a href="">${board.bo_me_id}</a>
					</td>
					<td>${board.bo_view }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="<c:url value="/board/insert"/>" class="btn btn-outline-danger">글등록</a>
</div>
</body>
</html>