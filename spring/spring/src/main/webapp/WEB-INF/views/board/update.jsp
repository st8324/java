<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
<form action="<c:url value="/board/update"/>" method="post" enctype="multipart/form-data">
	<h1>게시글 수정</h1>
	<input type="hidden" name="bo_num" value="${board.bo_num}">
	<div class="form-group">
		<label for="bo_title">게시판</label>
		<select name="bo_co_num" class="form-control">
			<c:forEach items="${list}" var="co">
				<option value="${co.co_num}" 
					<c:if test="${co.co_num == board.bo_co_num }">selected</c:if>
				>${co.co_name}</option>
			</c:forEach>
		</select>
	</div>
	<div class="form-group">
		<label for="bo_title">제목</label>
		<input type="text" class="form-control" id="bo_title" name="bo_title" value="${board.bo_title }">
	</div>
	<div class="form-group">
		<label for="bo_content">내용</label>
		<textarea class="form-control" id="bo_content" name="bo_content">${board.bo_content }</textarea>
	</div>
	<div class="form-group box-attachment">
		<label>첨부파일(최대 3개)</label>
		<c:forEach items="${fileList}" var="file">
			<div class="form-control">
				<span>${file.fi_ori_name }</span>
				<a href="javascript:void(0);" class="btn-del" data-num="${file.fi_num}">&times;</a>
			</div>
		</c:forEach>
		<c:forEach begin="1" end="${3 - fileList.size() }">
			<input type="file" class="form-control" name="file">
		</c:forEach>
	</div>
	<button class="btn btn-outline-success col-12">게시글 등록</button>
</form>
<!-- 제목, 내용 유효성 검사 및 썸머노트 적용 -->
<script type="text/javascript">
//서버에 전송하기 전에 제목, 내용 글자수 확인
$("form").submit(function(){
	let title = $("[name=bo_title]").val();
	if(title.length == 0){
		alert("제목은 1글자 이상 입력해야 합니다.");
		$("[name=bo_title]").focus();
		return false;
	}
	let content = $("[name=bo_content]").val();
	if(content.length == 0){
		alert("내용은 1글자 이상 입력해야 합니다.");
		$("[name=bo_content]").focus();
		return false;
	}
});

$('[name=bo_content]').summernote({
	placeholder: '내용을 입력하세요.',
	tabsize: 2,
	height: 400
});
</script>
<!-- 첨부파일 x버튼 구현 -->
<script type="text/javascript">
$(".btn-del").click(function(){
	let num = $(this).data("num");
	//input hidden 삭제한 첨부파일 번호를 추가
	$(this).parents(".box-attachment").prepend(`<input type="hidden" name="delNums" value="\${num}">`)
	//input file을 추가
	$(this).parents(".box-attachment").append(`<input type="file" class="form-control" name="file">`);	
	//클릭한 x버튼의 첨부파일을 삭제
	$(this).parent().remove();
});
</script>
</body>
</html>