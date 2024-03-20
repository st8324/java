<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.container-spinner{
	position: fixed; top:0; bottom:0; left:0; right:0;
	background: rgba(0,0,0,0.3);
	display: none;
	text-align: center; color : white;
	line-height: 100vh
}
</style>
</head>
<body>
<h1>비번찾기</h1>
<div class="form-group">
	<label for="id">아이디</label>
	<input type="text" class="form-control" id="id" name="id">
</div>
<button class="btn btn-outline-success col-12 btn-find">비번찾기</button>
<div class="container-spinner">
	찾기 중
	<span class="spinner-border text-danger"></span>
</div>
<script type="text/javascript">
$('.btn-find').click(function(){
	//아이디를 가져옴(데이터 생성)
	let obj = {
		id : $('[name=id]').val()
	}
	$(".container-spinner").show();
	//서버로 전송
	$.ajax({
		async : true,
		url : '<c:url value="/find/pw"/>', 
		type : 'post', 
		data : obj,
		dataType : "json", 
		success : function (data){
			if(data.result){
				alert("새 비번이 이메일로 전송됐습니다.");
			}else{
				alert("가입된 회원이 아니거나 이메일이 잘못됐습니다.");
			}
			$(".container-spinner").hide();
		}, 
		error : function(jqXHR, textStatus, errorThrown){

		}
	});
})

</script>
</body>
</html>