<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	
	<section class="container-fluid col-lg-4 mt-5">
	<h1>${board}게시판 상세 페이지</h1>
	
		<table border="1" class="table table-striped table-hover">
			<tr>
				<th>num</th>
				<th>title</th>
				<th>writer</th>
				<th>contents</th>
				<th>regdate</th>
				<th>hit</th>
			</tr>
		<tbody>
			<tr>
				<td>${requestScope.boardDTO.getNum()}</td>
				<td>${requestScope.boardDTO.getTitle()}</td>
				<td>${requestScope.boardDTO.getWriter()}</td>
				<td>${requestScope.boardDTO.getContents()}</td>
				<td>${requestScope.boardDTO.getRegDate()}</td>
				<td>${requestScope.boardDTO.getHit()}</td>
			</tr>
		</tbody>
	</table>
	
		<!-- 상대경로 -->
	<!-- <a href="./WEB-INF/view/member/login.jsp">Login</a> -->

	<a href="./list.iu" class="btn btn-default" role="button">QNA리스트</a>
	<a href="./update.iu?num=${boardDTO.num}" class="btn btn-default" role="button">질문수정</a>
	<a href="./delete.iu?num=${boardDTO.num}" class="btn btn-default" role="button">삭제</a>
	<a href="./reply.iu?num=${boardDTO.num}" class="btn btn-default" role="button">답글입력</a>
	
	
<img src="../resources/images/cat2.jpg">
</section>
<c:import url="../template/footer.jsp"></c:import>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
    			 integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" 
    			 crossorigin="anonymous"></script>
</body>
</html>