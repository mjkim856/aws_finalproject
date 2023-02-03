<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	#chatarea {
		background-color: buttonshadow;
		border: 2px solid black;
	}
</style>
</head>
<body>
별명 :       <input type=text id="nickname" value="${param.id }" >
			<input type=button id="enterbtn" value="입장" >
			
			<h1>채팅영역</h1>
			<div id="chatarea">채팅내용표시<br></div>
전송할 메시지 : <input type=text id="message">
			<input type=button id="sendbtn" value="메시지 전송" >

<script src="js/jquery-3.6.1.min.js"></script>
<script>
$(function() {
	let websocket;
	$("#enterbtn").on('click', function(){
		websocket = new WebSocket("ws://localhost:8085/ws");
		websocket.onopen = open;
		websocket.onclose = close;
		websocket.onmessage = message;	// 서버가 응답한 부분을 수신한다 (받아온다).
	});
	
	$("#sendbtn").on('click', function(){	// 서버로 송신한다. 
		let nickname = $("#nickname").val();
		let sendmessage = $("#message").val();
		websocket.send(nickname + " : " + sendmessage);
	});
})

function open() {
	console.log("웹소켓 연결 성공");
}

function close() {
	console.log("웹소켓 연결 실패");
}

function message(evt) {	// evt : 서버가 나에게 준 응답 중 문자열 응답 결과이다.
	console.log("서버로부터 메시지 수신 성공");
	$("#chatarea").append(evt.data + "<br>");
}

</script>

</body>
</html>