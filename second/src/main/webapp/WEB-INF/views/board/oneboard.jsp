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
<title>${param.seq }��°�Խù�</title>
<script src="js/jquery-3.6.1.min.js"></script>

</head>
<body>
		<ul class="nav">
			<li class="nav-item"><a class="nav-link active"	aria-current="page" href="#">Active</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
			<li class="nav-item"><a class="nav-link disabled">Disabled</a></li>
		</ul>
		<h1>${param.seq }��°�Խù��Դϴ�.</h1>
		<div class="row mt-5 mb-5">
			<div class="col" id="box-detail">
				<form action="">
					<table border="2">
						<tr>
							<td> ��ȣ </td> <td> <input type="text" value= " ${oneboard.seq}" readonly>  </td>
						</tr>
						<tr>
							<td> ���� </td> <td><input type="text" value= "${oneboard.title}" readonly> </td>
						</tr>
						<tr>
							<td> ���� </td> <td> <textarea cols=50 rows=5 readonly> ${oneboard.contents}</textarea>  </td>
						</tr>
						<tr>
							<td> �ۼ��� </td> <td><input type="text" value= " ${oneboard.writer}" readonly> </td>
						</tr>
						<tr>
							<td> ��ȸ�� </td> <td> ${oneboard.viewcount} </td>
						</tr>
						<%-- <tr>
							<td> �ۼ��ð� </td> <td> ${board.writingtime} </td>
						</tr> --%>
						<tr>
							<td colspan="2"> <input type="submit" value="���� ��ư"> <input type="submit" value="���� ��ư"> </td> 
						</tr>
					</table>
				</form>
			<button type="submit" class="btn btn-primary" id="btn-update">�����ϱ�</button>
			<button type="submit" class="btn btn-primary"  id="btn-delete">�����ϱ�</button>
			<button type="button" class="btn btn-primary" data-bs-toggle="modal"
				data-bs-target="#modal-delete" id="btn-delete1">�����ϱ�1(modal
				������)</button>
			<a href="/boardlist">Ȩ���� ����</a>
		</div>
	</div>

	<!-- ���� ��� -->
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
					<p>���� �����Ͻðڽ��ϱ�?</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">��</button>
				</div>
			</div>
		</div>
	</div>

</body>
</html>