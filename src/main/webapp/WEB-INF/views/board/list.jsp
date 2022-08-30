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
	
	<h1>${board} List Page</h1>
	
	<form action="./list.iu" class="row row-cols-lg-auto g-3 align-items-center">
	
	  <div class="col-12">
	    <label class="visually-hidden" for="kind">Kind</label>
	    <select name="kind" class="form-select" id="kind">
	      <option selected>선택하세요</option>
	      <option class="kinds" value="contents">Contents</option>
	      <option class="kinds" value="title">Title</option>
	      <option class="kinds" value="writer">Writer</option>
	    </select>
	  </div>
	  
	  <div class="col-12">
	    <label class="visually-hidden" for="search">검색어</label>
	    <div class="input-group">
	      <input type="text" name="search" value="${param.search}" class="form-control" id="search">
	  	</div>
	  </div>
	 
  

  <div class="col-12">
    <button type="submit" class="btn btn-primary">검색</button>
  </div>
</form>
	<table border="1" class="table table-striped table-hover">
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
						<td>${pageScope.dto.num} </td>
						<td>
						<c:catch>
           				 <c:forEach begin="1" end="${dto.depth}" >--</c:forEach>
           				 </c:catch>
						<a href ="./detail.iu?num=${pageScope.dto.num}">${pageScope.dto.title}</a></td>
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
			<br>

	<nav aria-label="Page navigation example">
  <ul class="pagination">
  	<c:if test="${pager.pre}">
	    <li class="page-item">
	      <a class="page-link" href="./list.iu?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>
    </c:if>
    
    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
    	    <li class="page-item"><a class="page-link" href="./list.iu?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
    </c:forEach>

<%-- 	<c:choose>
		<c:when test="${pager.next}">
			 <li class="page-item">
		</c:when>
		<c:otherwise>
			 <li class="page-item disabled">
		</c:otherwise>
	</c:choose> --%>
	<li class="page-item ${pager.next?'':'disabled'}">
      <a class="page-link" href="./list.iu?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>

</section>

<c:import url="../template/footer.jsp"></c:import>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
    			 integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" 
    			 crossorigin="anonymous"></script>
	<script src="/resources/JS/board.js"></script>
	<script>
		const kinds = document.getElementsByClassName("kinds");
		let k = '${param.kind}';	//title,contents,writer
		let p = '${param.kinds}';
	
		console.log(k);
		console.log(p);

		for(let i=0;i<kinds.length;i++){
			if(kinds[i].value == k){
				kinds[i].selected = true;
				break;
			}
		}
	</script>
</body>
</html>