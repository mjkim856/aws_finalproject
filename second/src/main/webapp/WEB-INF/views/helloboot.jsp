<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="js/jquery-3.6.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#ajaxbtn").on('click', function() {
		$.ajax({
			url: "helloajax",
			type: 'get',
			dataType: "json",
			success: function(data) {
				$("#result").html(data.result);
			} // function end
		});
	});
});
	

</script>
</head>
<body>
	${dto.model }
	<input type="button" value="ajax요청버튼" id="ajaxbtn">
	<h1><div id="result"></div></h1> 
</body>
</html>