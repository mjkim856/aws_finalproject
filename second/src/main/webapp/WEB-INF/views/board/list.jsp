<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>${param.page }�������� �Խù� ���</h1>
	<table>
		<tr>
			<th>��ȣ</th>
			<th>����</th>
			<th>�ۼ���</th>
		</tr>
		<c:forEach items="${list }" var="board">
			<tr>
				<td>${board.seq }</td>
				<td><a href="oneBoard?seq=${board.seq }">${board.title }</a></td>
				<td>${board.writer }</td>
			</tr>
		</c:forEach>
	</table>
	
	<% 
	int totalcount = (Integer)request.getAttribute("totalboard");
	int totalpage = 0;
	
	if (totalcount%3 == 0) {
		totalpage = totalcount/3;
	} else {
		totalpage = totalcount/3 + 1;
	}

	for(int i = 1; i <= totalpage; i++) {
	%>
		<a href="boardlist?page=<%=i%>"><%=i %>������</a>
	<%
	}
	%>		
	
	<input type="button" id="writebtn" value="�۾���">
	<script src="js/jquery-3.6.1.min.js"></script>
	<script>
	$("#writebtn").on('click', function(){
		location.href="insertboard";		// get
	})
	</script>
</body>
</html>