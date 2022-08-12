<%@page import="com.iu.start.bankBook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 
<%
	//요청이 발생하면 생성, 응답이 나가면 소멸 : RequestScope
	BankBookDTO bankBookDTO = (BankBookDTO)request.getAttribute("dto");
%>
--%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Detail Page</h1>

	<table border="1">
			<tr>
				<th>BookNum</th>
				<th>BookName</th>
				<th>BookRate</th>
				<th>BookSale</th>
			</tr>
		<tbody>
			<tr>
				<td>${requestScope.dto.getBookNum()}</td>
				<td>${requestScope.dto.bookName}</td>
				<td>${dto.bookRate}</td>
			</tr>
		</tbody>
	</table>
	
		<!-- 상대경로 -->
	<!-- <a href="./WEB-INF/view/member/login.jsp">Login</a> -->
	<a href="../member/login.iu">Login</a>
	
	<!-- 절대경로 -->
	<a href="/member/join.iu">Join</a>

	<a href="./list.iu">리스트보기</a>
	
	<a href="./update.iu?bookNum=${dto.bookNum}">수정하기</a>
	
	<a href="./delete.iu?bookNum=${dto.bookNum}">삭제하기</a>
	
	<c:if test="${not empty sessionScope.member}">
	
	<a href="../bankAccount/add.iu?bookNum=${dto.bookNum}">가입하기</a>
	
	</c:if>
	
<img src="../resources/cat2.jpg">
</body>
</html>