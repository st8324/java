<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html> 
<html>
<head>
</head>
<body>
	<h1>메인입니다.</h1>
	<a href="<c:url value="/find/pw"/>">비번찾기</a>
	<div id="test"></div>
	<button id="btn">새로고침</button>
	<script type="text/javascript">
		$("#btn").click(function(){
			$("#test").load("/spring/board/list2" + " #test")
		});
		function test(){
			$.ajax({
				url : "/spring/board/list2",
				success : function(data){
					console.log(data);
					$("#test").html(data);
				}
			})
		}
		test();
	</script>
</body>
</html>
