<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
<title>${param.seq }번째게시물</title>
<script src="js/jquery-3.6.1.min.js"></script>

</head>
<body>
		<ul class="nav">
			<li class="nav-item"><a class="nav-link active"	aria-current="page" href="#">Active</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
			<li class="nav-item"><a class="nav-link disabled">Disabled</a></li>
		</ul>
		<h1>${param.seq }번째게시물입니다.</h1>
		<div class="row mt-5 mb-5">
			<div class="col" id="box-detail">
				<form action="">
					<table border="2">
						<tr>
							<td> 번호 </td> <td> <input type="text" value= " ${oneboard.seq}" readonly>  </td>
						</tr>
						<tr>
							<td> 제목 </td> <td><input type="text" value= "${oneboard.title}" readonly> </td>
						</tr>
						<tr>
							<td> 내용 </td> <td> <textarea cols=50 rows=5 readonly> ${oneboard.contents}</textarea>  </td>
						</tr>
						<tr>
							<td> 작성자 </td> <td><input type="text" value= " ${oneboard.writer}" readonly> </td>
						</tr>
						<tr>
							<td> 조회수 </td> <td> ${oneboard.viewcount} </td>
						</tr>
						<%-- <tr>
							<td> 작성시간 </td> <td> ${board.writingtime} </td>
						</tr> --%>
						<tr>
							<td colspan="2"> <input type="submit" value="수정 버튼"> <input type="submit" value="삭제 버튼"> </td> 
						</tr>
					</table>
				</form>
			<button type="submit" class="btn btn-primary" id="btn-update">수정하기</button>
			<button type="submit" class="btn btn-primary"  id="btn-delete">삭제하기</button>
			<button type="button" class="btn btn-primary" data-bs-toggle="modal"
				data-bs-target="#modal-delete" id="btn-delete1">삭제하기1(modal
				연습용)</button>
			<a href="/boardlist">홈으로 가기</a>
		</div>
	</div>

	<!-- 삭제 모달 -->
	<div class="modal fade" id="modal-delete" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<p>정말 삭제하시겠습니까?</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">예</button>
				</div>
			</div>
		</div>
	</div>

</body>
</html>