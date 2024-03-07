<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<div class="container">
	<c:choose>
		<c:when test="${board != null }">
			<h1>게시글 상세</h1>
			<div class="mb-3 mt-3">
				<label class="form-label">게시판</label>
				<input type="text" class="form-control" readonly="readonly" value="${board.community.co_name}">
			</div>
			<div class="mb-3 mt-3">
				<label class="form-label">제목</label>
				<input type="text" class="form-control" readonly="readonly" value="${board.bo_title}">
			</div>
			<div class="mb-3 mt-3">
				<label class="form-label">작성자</label>
				<input type="text" class="form-control" readonly="readonly" value="${board.bo_me_id}">
			</div>
			<div class="mb-3 mt-3">
				<label for="title" class="form-label">조회수</label>
				<input type="text" class="form-control" readonly="readonly" value="${board.bo_view}">
			</div>
			<div class="mb-3 mt-3 clearfix">
				<button type="button" class="btn btn-outline-success btn-up float-start col-6" data-state="1">추천</button>
				<button type="button" class="btn btn-outline-success btn-down float-end col-6" data-state="-1">비추천</button>
			</div>
			<div class="mb-3 mt-3">
				<label for="content" class="form-label">내용</label>
				<textarea rows="10" class="form-control" readonly>${board.bo_content }</textarea>
			</div>
			<c:if test="${fileList != null && fileList.size() != 0 }">
				<div class="mb-3 mt-3">
					<label class="form-label">첨부파일</label>
					<c:forEach items="${fileList}" var="file">
						<a href="<c:url value="/download?filename=${file.fi_name}"/>" download="${file.fi_ori_name}" class="form-control">${file.fi_ori_name}</a>
					</c:forEach>
				</div>
			</c:if>
		</c:when>
		<c:otherwise>
			<h1>없는 게시글이거나 삭제된 게시글입니다.</h1>
		</c:otherwise>
	</c:choose>
	<a href="<c:url value="/board/list"/>" class="btn btn-outline-primary">목록으로</a>
	<c:if test="${user.me_id == board.bo_me_id }">
		<a href="<c:url value="/board/delete?num=${board.bo_num }"/>" class="btn btn-outline-danger">삭제</a>
		<a href="<c:url value="/board/update?num=${board.bo_num }"/>" class="btn btn-outline-danger">수정</a>
	</c:if>
</div>

<script src="//code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(".btn-up,.btn-down").click(function(){
		
		if('${user.me_id}' == ''){
			if(confirm("로그인이 필요한 서비스입니다. 로그인 페이지로 이동하겠습니까?")){
				location.href = '<c:url value="/login"/>'
			}else{
				return;
			}
		}
		
		let state = $(this).data('state');
		let boNum = '${board.bo_num}';
		$.ajax({
			url : '<c:url value="/recommend"/>',
			method : 'get',
			async : true, //동기/비동기 선택, true : 비동기, false : 동기
			data : {
				"state" : state,
				"boNum" : boNum
			},
			success : function(data){
				initBtn(".btn-up","btn-outline-success","btn-success");
				initBtn(".btn-down","btn-outline-success","btn-success");
				switch(data){
				case "1":
					alert("추천 되었습니다.");
					initBtn(".btn-up","btn-success","btn-outline-success");
					break;
				case "0":
					alert(`\${state == 1 ? '' : '비'}추천이 취소 되었습니다.`);
					break;
				case "-1":
					alert("비추천 되었습니다.");
					initBtn(".btn-down","btn-success","btn-outline-success");
					break;
				}
			},
			error : function (a, b, c) {
				console.error("예외 발생");
			}
		});//ajax end
		
	});//click end
	
	function initBtn(selector, addClassName, removeClassName){
		$(selector).addClass(addClassName);
		$(selector).removeClass(removeClassName);
	}
	
	<c:if test="${recommend != null}">
		<c:if test="${recommend.re_state == 1}">
			initBtn(".btn-up","btn-success","btn-outline-success");
		</c:if>
		<c:if test="${recommend.re_state == -1}">
			initBtn(".btn-down","btn-success","btn-outline-success");
		</c:if>
	</c:if>
</script>
</body>
</html>