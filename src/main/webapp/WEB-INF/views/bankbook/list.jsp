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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
	<section class="container-fluid col-lg-4 mt-5">
			<h1>BankBook List</h1>
			<!-- /BankBook/list -->
			
			<!-- /BankBook/detail  jsp:detail.jsp -->
			<!-- link 주소는 상대경로 작성 -->
			<table border="1" class="table table-bordered border-danger" style="background-color: darksalmon">
				<thead class="table-dark">
					<tr>
						<th>Name</th><th>Rate</th>
					</tr>
				</thead>
			<tbody>
				<c:forEach items="${requestScope.list}" var="dto">
					<%-- <tr>
						<td>${pageScope.dto.bookName}</td>
						<td>${pageScope.dto.bookRate}</td>
					</tr> --%>
				
					<tr>
						<td><a href ="./detail.iu?BookNum=${pageScope.dto.bookNum}">${pageScope.dto.bookName} </a></td>
						<td>${pageScope.dto.bookRate} </td>
					</tr>
			</c:forEach>
			</tbody>
			</table>
			
			<a href="./add.iu">상품등록</a>
			<a href="./detail.iu">Detail</a>
			<a href="./update.iu">수정하기</a>
			<a href="./delete.iu">삭제하기</a>
		<img src="../resources/images/cat2.jpg">
		
		</section>
		
		<c:import url="../template/footer.jsp"></c:import>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
    			 integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" 
    			 crossorigin="anonymous"></script>

</body>
</html>