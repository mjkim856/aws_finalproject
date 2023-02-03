<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>나의 회원관리 프로그램입니다.</h1>
	<h3>
		<ul>
<!-- 			<li><a href="mybatismemberlist" />회원리스트 보러 가기</li> -->
			<li><a href="<%=request.getContextPath() %>/login" >로그인하기</a></li>
			<li><a href="<%=request.getContextPath() %>/logout" >로그아웃하기</a></li>
			<li><a href="<%=request.getContextPath() %>/mybatismemberlist" >회원리스트 보러 가기(로그인필요없음)</a></li>
			<li><a href="<%=request.getContextPath() %>/memberinsert" >회원가입 하러 가기(로그인필요없음)</a></li>
			<li><a href="<%=request.getContextPath() %>/memberinform" >내 정보 보러 가기</a></li>
			<li><a href="<%=request.getContextPath() %>/logout" >로그아웃하기</a></li>
			<li><a href="<%=request.getContextPath() %>/memberdelete" >회원 탈퇴하기</a></li>
			<li><a href="<%=request.getContextPath() %>/boardlist" >게시판 가기</a></li>
		</ul>
	</h3>
	
	<%if(session.getAttribute("loginid") != null) {
		out.println("<h1>"+session.getAttribute("loginid")+" 회원님 환영합니다.</h1>");
	} else {
		out.println("<h1>로그인 하신 적이 없습니다.</h1>");
	}
	%>
	
	${!empty result ? result : "" }
</body>
</html>