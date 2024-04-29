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
	<button id="btn">공공데이터 지진해일 대피소 정보 가져오기</button>
	<script type="text/javascript">
		$("#btn").click(function(){
			$.ajax({
				url : "/spring/apis/data/test",
				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
				success : function(data){
					//JSON 문자열을 객체로 변환
					let result = JSON.parse(data);
					//이부분은 가져온 데이터가 보내준 값에 따라 다를 수 있음
					let list = result.TsunamiShelter[1].row;
					console.log(list)
					//가져온 데이터가 없으면
					if(!list){
						return;
					}
					display(list);
					
				}
			})
		});
		function test(){
			$.ajax({
				url : "/spring/board/list2",
				success : function(data){
					//console.log(data);
					$("#test").html(data);
				}
			})
		}
		test();
		function display(list){
			let trs = '';
			for(item of list){
				trs += `
					<tr>
		        <td>\${item.sido_name}</td>
		        <td>\${item.sigungu_name}</td>
		        <td>\${item.address}</td>
		      </tr>
				`;
			}
			let str = `
				<table class="table table-hover">
			    <thead>
			      <tr>
			        <th>시도명</th>
			        <th>시군구명</th>
			        <th>주소</th>
			      </tr>
			    </thead>
			    <tbody>
			      \${trs}
			    </tbody>
			  </table>
			`
			$("#btn").after(str);
		}
	</script>
</body>
</html>
