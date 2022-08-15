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
	<h1>Board Detail Page</h1>
	
	<table border="1">
		<tr>
			<th>BoardNum</th>
			<th>BoardName</th>
			<th>BoardWriter</th>
			<th>BoardDate</th>
			<th>BoardView</th>
		</tr>
		
		<tbody>
			<tr>
				<td>${requestScope.dto.getBoardNum()}</td>
				<td>${requestScope.dto.boardName}</td>
				<td>${dto.boardWriter}</td>
				<td>${dto.boardDate}</td>
				<td>${dto.boardView}</td>
			</tr>
		</tbody>
	</table>
	
<a href="./list.iu">Board 리스트 보기</a>
<a href="./update.iu">Board 수정하기</a>
<a href="./add.iu">Board 추가하기</a>
<a href="./delete.iu">Board 삭제하기</a>


<img src="../resources/cat2.jpg">
</body>
</html>