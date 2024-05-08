<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<button id="btn">조회</button>
<table>
	<thead>
		<tr>
			<th>항목1</th>
			<th>항목2</th>
			<th>항목3</th>
		</tr>
	</thead>
	<tbody>
		
	</tbody>
</table>
<script src="//code.jquery.com/jquery-3.6.1.js"></script>
<script type="text/javascript">
	$("#btn").click(function(){
		$.ajax({
			url : '<c:url value="/air.do"/>',
			success : function (data){
				console.log(data);
				let list = data.response.body.items;
				let str = "";
				for(let i in list){
					let item = list[i];
					str += `
						<tr>
							<td>\${item.informData}</td>
							<td>\${item.informCause}</td>
							<td>\${item.informGrade}</td>
						</tr>
					`
				}
				$("table tbody").html(str);
			}
		})
	})
</script>
</body>
</html>




