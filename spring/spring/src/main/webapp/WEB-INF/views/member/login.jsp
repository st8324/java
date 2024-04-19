<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<form action="<c:url value="/login"/>" method="post">
	<h1>로그인</h1>
	<div class="form-group">
		<label for="id">아이디</label>
		<input type="text" class="form-control" id="id" name="id">
	</div>
	<div class="form-group">
		<label for="pw">비번</label>
		<input type="password" class="form-control" id="pw" name="pw">
	</div>
	<div class="form-check">
		<label class="form-check-label">
			<input type="checkbox" class="form-check-input" value="true" name="autoLogin">자동로그인
		</label>
	</div>
	<button class="btn btn-outline-success col-12">로그인</button>
</form>
<a id="kakao-login-btn" href="javascript:loginWithKakao()">
  <img src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg" width="222"
    alt="카카오 로그인 버튼" />
</a>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript">
	Kakao.init('앱키'); // 사용하려는 앱의 JavaScript 키 입력
	function loginWithKakao() {
		Kakao.Auth.login({
      success: function (authObj) {
         Kakao.Auth.setAccessToken(authObj.access_token); // access토큰값 저장
					
         getInfo();
      },
      fail: function (err) {
          console.log(err);
      }
    });
  }
	function getInfo() {
    Kakao.API.request({
      url: '/v2/user/me',
      success: function (res) {
        // 이메일, 성별, 닉네임, 프로필이미지
        var id = res.id;
        var email = res.kakao_account.email;
        var sns = "kakao";
        if(!checkMember(sns, id)){
        	if(confirm("회원이 아닙니다. 가입하시겠습니까?")){
        		signupSns(sns, id, email);
        	}else{
        		return;
        	}
        }
        snsLogin(sns, id);
       	location.href = '<c:url value="/"/>';

      },
      fail: function (error) {
          alert('카카오 로그인에 실패했습니다. 관리자에게 문의하세요.' + JSON.stringify(error));
      }
    });
  }
  function checkMember(sns, id){
	  var res;
	  $.ajax({
			async : false,
			url : `<c:url value="/sns"/>/\${sns}/check/id`, 
			type : 'post', 
			data : {id}, 
			success : function (data){
				res = data;
			}, 
			error : function(jqXHR, textStatus, errorThrown){

			}
		});
	  return res;
  }
  function signupSns(sns, id, email){
	  $.ajax({
			async : false,
			url : `<c:url value="/sns"/>/\${sns}/signup`, 
			type : 'post', 
			data : {id, email}, 
			success : function (data){
				
			}, 
			error : function(jqXHR, textStatus, errorThrown){
				
			}
		});
  }
  function snsLogin(sns, id){
	  $.ajax({
			async : false,
			url : `<c:url value="/sns"/>/\${sns}/login`, 
			type : 'post', 
			data : {id}, 
			success : function (data){
				if(data){
					alert("로그인 되었습니다.");
				}
			}, 
			error : function(jqXHR, textStatus, errorThrown){
				
			}
		});
  }
</script>
</body>
</html>