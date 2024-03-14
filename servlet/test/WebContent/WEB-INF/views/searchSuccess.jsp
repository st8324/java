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
<h1>게시글 정보</h1>
<table border="1">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<th>${board.bo_num}</th>
			<th>${board.bo_title }</th>
			<th>${board.bo_me_id }</th>
		</tr>
	</tbody>
</table>
<a href="<c:url value="/"/>">메인으로</a>
</body>
</html>