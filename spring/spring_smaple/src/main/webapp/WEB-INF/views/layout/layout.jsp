<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>스프링</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	
	<script type="text/javascript">
	$(function(){
		bodyMinHeight();
		$(window).resize(bodyMinHeight)
		
	});
	function bodyMinHeight(){
		let footerHeight = $("footer").outerHeight();
		let navHeight = $("nav").outerHeight();
		$("#body").css("min-height", "calc(100vh - " + (footerHeight + navHeight)+"px");
	}
	</script>
	<script type="text/javascript">
	//이벤트 생성
	const sse = new EventSource("<c:url value='/sse/connect'></c:url>");
	sse.addEventListener('connect', (e) => {
		const { data: receivedConnectData } = e;
		console.log('connect event data: ',receivedConnectData);  // "connected!"
	});
	sse.addEventListener('receive', e => {  
	    const { data: receivedData } = e;  
	    obj = JSON.parse(receivedData);
	    console.log(obj)
	    console.log("보낸 사람 : " + obj.from);
	    console.log("메세지 : " + obj.msg)
	});
	
	//페이지 이동 시 sse 연결 끊기.
	window.addEventListener('beforeunload', function (e) {
		if (sse) {
	  	sse.close(); // SSE 연결 닫기
	  }
	});
	</script>
</head>
<body>
    <tiles:insertAttribute name="header"/>
    <div class="container" id="body">        
        <tiles:insertAttribute name="body" />
    </div>                                                  
    <tiles:insertAttribute name="footer" />
</body>
</html>
