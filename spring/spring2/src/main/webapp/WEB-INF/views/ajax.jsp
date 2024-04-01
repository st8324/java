<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
	<title>Home</title>
	<script src="//code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
	<button class="btn1">json - json</button>
	
	<script type="text/javascript">
		$(".btn1").click(function(){
			let obj = {
				id : "abc",
				pw : "def"
			}
			//작업1
			$.ajax({
				//동기는 작업1이 다 끝날때까지 기다린 후 작업2가 실행
				//비동기는 작업1이 실행된 후, 끝날때까지 기다리지 않고 작업2가 실행
				async : true,//생략하면 true
				url : '<c:url value="/ajax/json/json"/>', 
				type : 'post', 
				data : JSON.stringify(obj), //객체를 json형태의 문자열로 변환
				//서버로 보내는 데이터의 타입. 위에 있는 data의 타입
				contentType : "application/json; charset=utf-8",
				//서버에서 화면으로 보내는 데이터의 타입. 아래에 있는 success의 data 타입
				dataType : "json", 
				success : function (data){
					console.log(data);
				}, 
				error : function(jqXHR, textStatus, errorThrown){

				}
			});
			//작업2
		});
	</script>
</body>
</html>
