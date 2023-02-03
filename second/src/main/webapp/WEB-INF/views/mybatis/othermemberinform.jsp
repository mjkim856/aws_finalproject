<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${otherinform.name }님의 정보입니다. (관리자만 허용)</h1>
	<h3>아이디 : ${otherinform.name }</h3>
	<h3>이메일 : ${otherinform.email }</h3>
	<h3>폰 : ${otherinform.phone }</h3>
	<h3>주소 : ${otherinform.address }</h3>
	<h3>사진 : <img src="/upload/${otherinform.image }"> </h3>
	<script type="text/javascript">
		alert('${updateresult}');
	</script>
</body>
</html>