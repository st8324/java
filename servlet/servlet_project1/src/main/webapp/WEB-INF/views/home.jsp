<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
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
	<h1>메인 페이지입니다.</h1>
	<c:forEach begin="1" end="4" var="i" step="2">
	${i },
	</c:forEach>
	<c:set var="name" value="홍길동1"/>
	${name}
	<c:if test='${name eq "홍길동" }'>홍길동입니다.</c:if>
	<c:choose>
		<c:when test='${name eq "홍길동" }'>홍길동입니다.</c:when>
		<c:otherwise>홍길동이 아닙니다.</c:otherwise>
	</c:choose>
	
	<!-- 서버에서 보낸 id가 "abc"로 되어 있으면  -->
	<input type="text" value="${id }">
	<br>
	<c:forTokens items="a|b|c|d" delims="|" var="ch">${ch }</c:forTokens>
	<br>
	<c:url value="/" var="url">
		<c:param name="name" value="홍길동"/>
		<c:param name="age" value="30"/>
	</c:url>
	${url}
</div>

</body>
</html>