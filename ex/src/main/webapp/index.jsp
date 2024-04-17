<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<!-- 서버에서 보내준 게시글이 없으면 검색창을 출력 -->
	<c:if test="${empty board}">
		<form action="<c:url value="/board/detail"/>" method="get">
			<input type="text" placeholder="게시글 번호 입력" name="boNum">
			<button>검색</button>
		</form>
	</c:if>
	<!-- 서버에서 보내준 게시글이 있으면 게시글 내용을 출력 -->
	<c:if test="${!empty board }">
		<div>${board.boTitle}</div>
	</c:if>
</body>
</html>
