<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<!-- jquery validtaion -->	
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/additional-methods.min.js"></script>
	<title>스프링 - 회원가입</title>
</head>
<body>
<form action="<c:url value="/signup"/>" method="post">
	<h1>회원가입</h1>
	<div class="form-group">
		<label for="id">아이디</label>
		<input type="text" class="form-control" id="id" name="me_id">
		<label id="id-error" class="error text-danger" for="id"></label>
		<label id="id-error2" class="error text-danger"></label>
	</div>
	<div class="form-group">
		<label for="pw">비번</label>
		<input type="password" class="form-control" id="pw" name="me_pw">
		<label id="pw-error" class="error text-danger" for="pw"></label>
	</div>
	<div class="form-group">
		<label for="pw2">비번확인</label>
		<input type="password" class="form-control" id="pw2" name="me_pw2">
		<label id="pw2-error" class="error text-danger" for="pw2"></label>
	</div>
	<div class="form-group">
		<label for="email">이메일</label>
		<input type="text" class="form-control" id="email" name="me_email">
		<label id="email-error" class="error text-danger" for="email"></label>
	</div>
	<button class="btn btn-outline-success col-12">회원가입</button>
</form>
<!-- 유효성 검사 -->
<script type="text/javascript">
$("form").validate({
	rules : {
		me_id : {
			required : true,
			regex : /^\w{6,13}$/
		},
		me_pw : {
			required : true,
			regex : /^[a-zA-Z0-9!@#]{6,15}$/
		},
		me_pw2 : {
			equalTo : pw //name이 아닌 id를 써 줌
		},
		me_email : {
			required : true,
			email : true
		}
	}, 
	messages : {
		me_id : {
			required : "필수 항목입니다.",
			regex : "아이디는 숫자 영문 6~13자입니다."
		},
		me_pw : {
			required : "필수 항목입니다.",
			regex : "비밀번호는 숫자,영문, !@#만 사용가능하며 6~15자입니다."
		},
		me_pw2 : {
			equalTo : "비밀번호와 일치하지 않습니다."
		},
		me_email : {
			required : "필수 항목입니다.",
			email : "이메일 형식이 아닙니다."
		}
	},
	submitHandler : function(form){
		return idCheckDup();
	}
});

$.validator.addMethod(
	"regex",
	function (value, element, regexp){
		var re= new RegExp(regexp);
		return this.optional(element) || re.test(value);
	},
	"정규표현식에 맞지 않습니다."
)

</script>
<!-- 아이디 중복 검사 -->
<script type="text/javascript">
function idCheckDup(){
	$("#id-error2").text("");
	$("#id-error2").hide();
	//입력된 아이디를 가져옴
	let id = $('[name=me_id]').val();
	let obj = {
		id : id
	}
	let idRegex = /^\w{6,13}$/;
	if(!idRegex.test(id)){
		return false;
	}
	let result = false;
	//서버에 아이디를 전송해서 사용 가능/불가능 처리
	$.ajax({
		async : false,
		url : '<c:url value="/id/check/dup"/>', 
		type : 'get', 
		data : obj, 
		dataType : "json", 
		success : function (data){
			result = data.result;
			if(!result){
				$("#id-error2").text("이미 사용중인 아이디입니다.");
				$("#id-error2").show();
			}
		}, 
		error : function(jqXHR, textStatus, errorThrown){

		}
	});
	return result;
}
$('[name=me_id]').on('input',function(){
	idCheckDup();
})
</script>
</body>
</html>