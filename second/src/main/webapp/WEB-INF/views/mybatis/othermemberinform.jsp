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
	<h1>${otherinform.name }���� �����Դϴ�. (�����ڸ� ���)</h1>
	<h3>���̵� : ${otherinform.name }</h3>
	<h3>�̸��� : ${otherinform.email }</h3>
	<h3>�� : ${otherinform.phone }</h3>
	<h3>�ּ� : ${otherinform.address }</h3>
	<h3>���� : <img src="/upload/${otherinform.image }"> </h3>
	<script type="text/javascript">
		alert('${updateresult}');
	</script>
</body>
</html>