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
	
	<h1>${board}</h1>
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
						<td>${pageScope.dto.writer}</td>
						<td>${pageScope.dto.contents}</td>
						<td>${pageScope.dto.regDate}</td>
						<td>${pageScope.dto.hit}</td>
					</tr>
			</c:forEach>
			</tbody>
			</table>
			<div>
			<button onclick="location='add.iu'" class="btn btn-primary">글쓰기</button>
			</div>
	
	
	
	
	
	
	<a href="./add.iu">글 작성</a>		
	
	<nav aria-label="Page navigation example">
  <ul class="pagination">
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    
    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
    	    <li class="page-item"><a class="page-link" href="./list.iu?page=${i}">${i}</a></li>
    </c:forEach>

    <li class="page-item">
      <a class="page-link" href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>

	<a href="./detail.iu">글 조회</a>	
	<a href="./update.iu">글 수정</a>
	<a href="./delete.iu">글 삭제</a>
</section>

<c:import url="../template/footer.jsp"></c:import>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
    			 integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" 
    			 crossorigin="anonymous"></script>
</body>
</html>