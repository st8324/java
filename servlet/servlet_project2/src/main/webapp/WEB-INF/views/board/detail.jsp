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
				<div class="form-control" style="min-height: 400px">${board.bo_content }</div>
			</div>
			<c:if test="${fileList != null && fileList.size() != 0 }">
				<div class="mb-3 mt-3">
					<label class="form-label">첨부파일</label>
					<c:forEach items="${fileList}" var="file">
						<a href="<c:url value="/download?filename=${file.fi_name}"/>" download="${file.fi_ori_name}" class="form-control">${file.fi_ori_name}</a>
					</c:forEach>
				</div>
			</c:if>
			<hr>
			<h3>댓글</h3>
			<!-- 댓글들을 보여줄 박스 -->
			<div class="box-comment-list">
				<div class="box-comment input-group">
					<div class="col-3">아이디</div>
					<div class="col-9">
						<div>댓글 내용</div>
						<div class="btn-group">
							<button class="btn btn-outline-warning">수정</button>
							<button class="btn btn-outline-danger">삭제</button>
						</div>
					</div>
				</div>
			</div>
			<!-- 댓글 페이지네이션을 보여줄 박스 -->
			<div class="box-comment-pagination">
				<ul class="pagination justify-content-center">
					<li class="page-item">
						<a class="page-link" href="javascript:void(0);">이전</a>
					</li>
					<li class="page-item active">
						<a class="page-link" href="javascript:void(0);">1</a>
					</li>
					<li class="page-item">
						<a class="page-link" href="javascript:void(0);">다음</a>
					</li>
				</ul>
			</div>
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
<!-- 추천 기능 -->
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
<!-- 댓글 조회 기능 -->
<script type="text/javascript">
let cri = {
	page : 1,
	boNum : '${board.bo_num}'
}
displayCommentAndPagination(cri);
//댓글을 불러와서 화면에 출력하는 함수 : 현재 댓글 페이지 정보
function displayCommentAndPagination(cri){
	//ajax를 이용해서 서버에 현재 댓글 페이지 정보를 보내고, 
	//서버에서 보낸 댓글 리스트와 페이지네이션 정보를 받아와서 화면에 출력
	$.ajax({
		url : '<c:url value="/comment/list"/>',
		method : 'get',
		data : cri,
		success : function(data){
			displayComment(data.list);
			displayCommentPagination(JSON.parse(data.pm));
		}
	});
}

//댓글이 주어지면 댓글을 화면에 출력하는 함수
function displayComment(commentList){
	let str = '';
	if(commentList.length == 0){
		$(".box-comment-list").html('<h3>등록된 댓글이 없습니다.</h3>')	
		return;
	}
	
	for(comment of commentList){
		str += `
		<div class="box-comment input-group">
			<div class="col-3">\${comment.cm_me_id}</div>
			<div class="col-9">
				<div>\${comment.cm_content}</div>
				<div class="btn-group">
					<button class="btn btn-outline-warning">수정</button>
					<button class="btn btn-outline-danger">삭제</button>
				</div>
			</div>
		</div>`;
	}
	$(".box-comment-list").html(str);
	
}
//페이지네이션이 주어지면 댓글 페이지네이션을 화면에 출력하는 함수
function displayCommentPagination(pm){
	let str = '';
	//이전 버튼 활성화
	if(pm.prev){
		str += `
		<li class="page-item">
			<a class="page-link" href="javascript:void(0);" data-page="\${pm.startPage-1}">이전</a>
		</li>`;
	}
	
	for(i = pm.startPage; i<= pm.endPage; i++){
		let active = pm.cri.page == i ? "active" : "";
		str += 
		`<li class="page-item \${active}">
			<a class="page-link" href="javascript:void(0);" data-page="\${i}">\${i}</a>
		</li>`
	}
	
	if(pm.next){
		str += `
		<li class="page-item">
			<a class="page-link" href="javascript:void(0);" data-page="\${pm.endPage+1}">다음</a>
		</li>`;
	}
	$(".box-comment-pagination>ul").html(str);
}
//페이지 클릭 이벤트
$(document).on("click",".box-comment-pagination .page-link", function(){
	cri.page = $(this).data("page");
	displayCommentAndPagination(cri);
});

</script>
</body>
</html>