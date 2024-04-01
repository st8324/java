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
	<br>
	<button class="btn2">object - json</button>
	
	<script type="text/javascript">
		//서버에서 보낸 이름을 가져오는 함수
		function clickTest1(obj){
			let name = "";
			$.ajax({
				//동기는 작업1이 다 끝날때까지 기다린 후 작업2가 실행
				//비동기는 작업1이 실행된 후, 끝날때까지 기다리지 않고 작업2가 실행
				async : false,//생략하면 true
				url : '<c:url value="/ajax/json/json"/>', 
				type : 'post', 
				data : JSON.stringify(obj), //객체를 json형태의 문자열로 변환
				//서버로 보내는 데이터의 타입. 위에 있는 data의 타입
				contentType : "application/json; charset=utf-8",
				//서버에서 화면으로 보내는 데이터의 타입. 아래에 있는 success의 data 타입
				dataType : "json", 
				success : function (data){
					//서버에서 보낸 name과 회원 id, pw을 콘솔창에 출력하는 코드
					console.log(data.member.id);
					console.log(data.member.pw);
					console.log(data.name);
					$(this); //2번 
					//1번 this와 2번 this는 같다?(X)
					//
					//clickTest1의 return을 원하지만 success에 구현한 함수에 
					//return을 지정하면 success함수의 결과를 리턴 
					//return data.name;
					name = data.name;
				}, 
				error : function(jqXHR, textStatus, errorThrown){

				}
			});
			return name;
		}
		$(".btn1").click(function(){
			let obj = {
				id : "abc",
				pw : "def"
			}
			$(this);//1번 
			//작업1
			let name = clickTest1(obj);
			console.log(name);
			//작업2
		});
	</script>

	<script type="text/javascript">
		$(".btn2").click(function(){
			let obj = {
				id : "abc",
				name : "홍길동"
			}
			$.ajax({
				async : true, 
				url : '<c:url value="/ajax/object/json"/>', 
				type : 'get', 
				data : obj, 
				dataType : "json", 
				success : function (data){
					console.log(data.age);
				}, 
				error : function(jqXHR, textStatus, errorThrown){

				}
			});
		});
	
	</script>
</body>
</html>
