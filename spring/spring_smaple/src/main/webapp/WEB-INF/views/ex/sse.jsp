<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
	<form>
		<div class="form-group">
		  <label for="to">받는 사람:</label>
		  <input type="text" class="form-control" id="to" name="to">
		</div>
		<div class="form-group">
		  <label for="msg">메세지</label>
		  <input type="text" class="form-control" id="msg" name="msg">
		</div>
		<button class="btn btn-outline-success btn-send" type="submit">전송</button>
	</form>
	<script type="text/javascript">
	$("form").submit(function(e){
		e.preventDefault();
		let obj = $(this).serialize()
		console.log(obj)
		$.ajax({
			async : false,
			url : '<c:url value="/sse/send"/>', 
			type : "post", 
			data : obj, 
			success : function (data){
				console.log(data);
			}, 
			error : function(jqXHR, textStatus, errorThrown){

			}
		});
		return false;
	})
	</script>
</body>
</html>
