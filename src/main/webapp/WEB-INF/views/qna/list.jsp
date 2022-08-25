<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>

	<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid col-lg-6">

	<h1 class="align-center">Q&A List Page</h1>
	
	
	<form action="./list.iu" class="row row-cols-lg-auto g-3 align-items-center">
	
	  <div class="col-12">
	    <label class="visually-hidden" for="kind">Kind</label>
	    <select name="kind" class="form-select" id="kind">
	      <option selected>선택하세요</option>
	      <option value="contents">Contents</option>
	      <option value="title">Title</option>
	      <option value="writer">Writer</option>
	    </select>
	  </div>
	  
	  <div class="col-12">
	    <label class="visually-hidden" for="search">검색어</label>
	    <div class="input-group">
	      <input type="text" name="search" class="form-control" id="search">
	  	</div>
	  </div>
	    <div class="col-12">
   			 <button type="submit" class="btn btn-primary">검색</button>
 		 </div>
	  
	  </form>
	
	<div class="row">
	<table class="table">
	  <thead class="table-dark">
	    <tr>
	      <th scope="col">NUM</th>
	      <th scope="col">TITLE</th>
	      <th scope="col">WRITER</th>
	      <th scope="col">DATE</th>
	      <th scope="col">HIT</th>
	    </tr>
	  </thead>
	  <tbody>
	    <c:forEach items="${requestScopelist}" var="dto" >
			<tr>
				<td>${dto.num}</td>
				<td><a href="./detail.iu?num=${dto.num}">${dto.title}</a></td>
				<td>${dto.writer}</td>
				<td>${dto.regDate}</td>
				<td>${dto.hit}</td>	
			</tr>
		</c:forEach>
	  </tbody>
</table>


</div>

</section>

<c:import url="../template/footer.jsp"></c:import>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

</body>
</html>