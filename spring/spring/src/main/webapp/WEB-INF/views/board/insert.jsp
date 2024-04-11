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
<form action="<c:url value="/board/insert"/>" method="post" enctype="multipart/form-data">
	<h1>게시글 등록</h1>
	<div class="form-group">
		<label for="bo_title">게시판</label>
		<select name="bo_co_num" class="form-control">
			<c:forEach items="${list}" var="co">
				<option value="${co.co_num}">${co.co_name}</option>
			</c:forEach>
		</select>
	</div>
	<div class="form-group">
		<label for="bo_title">제목</label>
		<input type="text" class="form-control" id="bo_title" name="bo_title">
	</div>
	<div class="form-group">
		<label for="bo_content">내용</label>
		<textarea class="form-control" id="bo_content" name="bo_content"></textarea>
	</div>
	<div class="form-group">
		<label>첨부파일(최대 3개)</label>
		<input type="file" class="form-control" name="file">
		<input type="file" class="form-control" name="file">
		<input type="file" class="form-control" name="file">
	</div>
	<button class="btn btn-outline-success col-12">게시글 등록</button>
</form>

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
	height: 400,
	callbacks: {
 		// 이미지를 업로드할 경우 이벤트를 발생
   	onImageUpload: function(files, editor, welEditable) {
    	sendFile(files[0], this);
		},
		// 미디어(이미지 포함)을 삭제할 경우 이벤트를 발생
		onMediaDelete: function ($target, editor, $editable) {
			//이미지 경로를 추출
      var deletedImageUrl = $target
          .attr('src')
          .replace("<c:url value='/download'/>","");
			//해당 이미지를 서버에서 삭제해달라고 요청(ajax로)
      removeImg(deletedImageUrl)


    }
 	}
});

function sendFile(file, editor) {
	data = new FormData();
	data.append("file", file);
	//첨부파일을 ajax로 보내는 예제		
	$.ajax({
		data: data,
    type: "post",
    url: '<c:url value="/img/upload"/>',
 		cache : false,
    contentType : false,	
    processData : false,
    success : function(data){
    	console.log(data);
    	$(editor).summernote('editor.insertImage', "<c:url value='/download'/>"+data.url);
    }
	});
}
//업로드된 이미지를 삭제하는 함수
function removeImg(imageName){
	data = new FormData()
  data.append('file', imageName)
  $.ajax({
      data: data,
      type: 'POST',
      url: '<c:url value="/img/delete"/>',
      contentType: false,
      processData: false,
      success : function(data){
    	  console.log(data);
      }
  })
}
</script>
</body>
</html>