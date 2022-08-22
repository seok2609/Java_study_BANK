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
		<h1>게시판</h1>
	
	<table border="1" class="table table-success table-striped">
		<thead class="table-dark">
			<tr>
				<th>Num</th><th>Name</th><th>Writer</th><th>Date</th><th>View</th>
			</tr>
		</thead>
			<tbody>
				<c:forEach items="${requestScope.list}" var="dto">				
					<tr>						
						<td><a href ="./detail.iu?BoardNum=${pageScope.dto.boardNum}">${pageScope.dto.boardNum}</a></td>					
	
						<td>${pageScope.dto.boardName}</td>
						<td>${pageScope.dto.boardWriter}</td>
						<td>${pageScope.dto.boardDate}</td>
						<td>${pageScope.dto.boardView}</td>
					</tr>
					
				</c:forEach>
			</tbody>
		
		</table>
	
	
		<a href="./add.iu">추가하기</a>
		<a href="./detail.iu">상세정보</a>
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