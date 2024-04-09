<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <a class="navbar-brand" href="#">Home</a>

  <ul class="navbar-nav">
  	<c:if test="${user == null }">
	  	<li class="nav-item">
	      <a class="nav-link" href="<c:url value="/login"/>">로그인</a>
	    </li>
    </c:if>
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/sse"/>">sse 예제</a>
    </li>
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        예제링크
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="#">Link 1</a>
        <a class="dropdown-item" href="#">Link 2</a>
        <a class="dropdown-item" href="#">Link 3</a>
      </div>
    </li>
  </ul>
  <c:if test="${user != null }">			
  	<a href="#" class="text-muted ml-auto">${user.me_id}님 환영합니다.</a>
  </c:if>
</nav>
</body>
</html>
