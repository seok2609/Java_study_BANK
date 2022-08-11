<%@page import="com.iu.start.bankBook.BankBookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook List</h1>
	<!-- /BankBook/list -->
	
	<!-- /BankBook/detail  jsp:detail.jsp -->
	<!-- link 주소는 상대경로 작성 -->
	<table border="1">
		<thead>
			<tr>
				<th>Name</th><th>Rate</th>
			</tr>
		</thead>
	<tbody>
		<c:forEach items="${requestScope.list}" var="dto">
			<tr>
				<td>${pageScope.dto.bookName}</td>
				<td>${pageScope.dto.bookRate}</td>
			</tr>
		
		</c:forEach>
	
	
		
			<tr>
				<td><a href ="./detail?BookNum=${dto.bookNum}">${dto.bookName} </a></td>
				<td>${dto.bookRate} </td>
			</tr>
	
	</tbody>
	</table>
	
	<a href="./add">상품등록</a>
	<a href="./detail">Detail</a>
<img src="../resources/cat2.jpg">

</body>
</html>