<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
</head>
<body>
<div class="container">
	<h1>게시글 목록</h1>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="post" varStatus="vs">
				<tr>
					<td>${list.size() - vs.index }</td>
					<td>
						<a href="#">${post.bo_title}</a>
					</td>
					<td>${post.bo_me_id }</td>
					<td>${post.bo_view }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<ul class="pagination justify-content-center">
		<li class="page-item">
			<c:url var="url" value="/post/list">
				<c:param name="page" value="${pm.startPage - 1}"/>
			</c:url>
			<a class="page-link" href="${url}">이전</a>
		</li>
		<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i">
			<c:set var="active" value="${pm.cri.page == i ?'active':'' }"/>
			<li class="page-item ${active}">
				<c:url var="url" value="/post/list">
					<c:param name="page" value="${i}"/>
				</c:url>
				<a class="page-link" href="${url}">${i}</a>
			</li>
		</c:forEach>
		<li class="page-item">
			<c:url var="url" value="/post/list">
				<c:param name="page" value="${pm.endPage + 1}"/>
			</c:url>
			<a class="page-link" href="${url}">다음</a>
		</li>
	</ul>
</div>
</body>
</html>
