<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시판 상세 페이지</h1>
	
		<table border="1">
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

	<a href="./list.iu">리스트보기</a>
	
	<a href="./update.iu?num=${dto.num}">수정하기</a>
	
	<a href="./delete.iu?num=${dto.num}">삭제하기</a>
	
	<a href="../bankAccount/add.iu?bookNum=${dto.num}">가입하기</a>
	
	
<img src="../resources/images/cat2.jpg">

</body>
</html>