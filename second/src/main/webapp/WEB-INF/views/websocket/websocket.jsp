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
���� :       <input type=text id="nickname" value="${param.id }" >
			<input type=button id="enterbtn" value="����" >
			
			<h1>ä�ÿ���</h1>
			<div id="chatarea">ä�ó���ǥ��<br></div>
������ �޽��� : <input type=text id="message">
			<input type=button id="sendbtn" value="�޽��� ����" >

<script src="js/jquery-3.6.1.min.js"></script>
<script>
$(function() {
	let websocket;
	$("#enterbtn").on('click', function(){
		websocket = new WebSocket("ws://localhost:8085/ws");
		websocket.onopen = open;
		websocket.onclose = close;
		websocket.onmessage = message;	// ������ ������ �κ��� �����Ѵ� (�޾ƿ´�).
	});
	
	$("#sendbtn").on('click', function(){	// ������ �۽��Ѵ�. 
		let nickname = $("#nickname").val();
		let sendmessage = $("#message").val();
		websocket.send(nickname + " : " + sendmessage);
	});
})

function open() {
	console.log("������ ���� ����");
}

function close() {
	console.log("������ ���� ����");
}

function message(evt) {	// evt : ������ ������ �� ���� �� ���ڿ� ���� ����̴�.
	console.log("�����κ��� �޽��� ���� ����");
	$("#chatarea").append(evt.data + "<br>");
}

</script>

</body>
</html>