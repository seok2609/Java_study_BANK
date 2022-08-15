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
	<h1>게시판</h1>
	
	<table border="1">
		<thead>
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
<img src="../resources/cat2.jpg">

</body>
</html>