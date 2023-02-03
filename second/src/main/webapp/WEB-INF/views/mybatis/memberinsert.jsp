<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인폼</h1>
	<form action="<%=request.getContextPath()%>/memberinsert" 
		  enctype="multipart/form-data"
		  method="post">
		아이디 <input type="text" name="id"> <br>
		비밀번호 <input type="password" name="pw"> <br>
		이름 <input type="text" name="name"><br>
		이메일 <input type="text" name="email"><br>
		전화번호 <input type="text" name="phone"><br>
		주소 <input type="text" name="address"><br>
		이미지 <input type="file" id="imagefile" name="imagefile"><br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>