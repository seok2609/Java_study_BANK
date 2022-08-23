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
	<h1>게시판 목록</h1>
	<table border="1" class="table table-bordered border-danger" style="background-color: darksalmon">
				<thead class="table-dark">
					<tr>
						<th>NUM</th>
						<th>TITLE</th>
						<th>WRITER</th>
						<th>CONTENTS</th>
						<th>REGDATE</th>
						<th>HIT</th>
					</tr>
				</thead>
			<tbody>
				<c:forEach items="${requestScope.list}" var="dto">
				
					<tr>
						<td><a href ="./detail.iu?num=${pageScope.dto.num}">${pageScope.dto.num} </a></td>
						<td>${pageScope.dto.title}</td>
					</tr>
			</c:forEach>
			</tbody>
			</table>
	
	
	
	
	
	
	
	<a href="./add.iu">글 작성</a>		
	<a href="./detail.iu">글 조회</a>	
	<a href="./update.iu">글 수정</a>
	<a href="./delete.iu">글 삭제</a>

</body>
</html>