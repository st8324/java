<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>게시글 리스트</h1>
<table class="table table-hover">
	<thead>
		<tr>
			<th>번호</th>
			<th>게시판</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>추천/비추천</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="board">
			<tr>
				<td>${board.bo_num }</td>
				<td></td>
				<td>${board.bo_title }</td>
				<td>${board.bo_me_id }</td>
				<td>${board.bo_view }</td>
				<td></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
