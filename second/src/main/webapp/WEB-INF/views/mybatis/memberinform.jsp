<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="<%=request.getContextPath()%>/resources/js/jquery-3.6.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#form").on('submit', function(e) {
		if($("#pw").val() != $("#pw2").val()) {
			alert("암호가 일치하지 않습니다.");
			$("#result").html("<h3>암호가 일치하지 않습니다.</h3>");
			e.preventDefault();
		}
	});
	
})
</script>
<title>Insert title here</title>
</head>
<body>
	<h1>회원정보수정 폼</h1>
	<form id="form" action="<%=request.getContextPath()%>/memberupdate" method="post">
		아이디 <input type="text" name="id" value="${informdto.id }" readonly> <br>
		비밀번호 <input type="password" name="pw" id="pw"> <br>
		비밀번호 확인 <input type="password" name="pw2" id="pw2"> <br>
		이름 <input type="text" name="name" value="${informdto.name }" ><br>
		이메일 <input type="text" name="email" value="${informdto.email }" ><br>
		전화번호 <input type="text" name="phone" value="${informdto.phone }" pattern="010[0-9]{8}" ><br>
		주소 <input type="text" name="address" value="${informdto.address }" ><br>
		<input type="submit" value="내정보수정">
	</form>
	<div id="result">
	
	</div>
</body>
</html>