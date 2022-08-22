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
	
		  <form action="./login.iu" method="post">
		  
			  <div class="mb-3">
			    <label for="exampleInputEmail1" class="form-label">ID</label>
			    <input type="text" name="userName" value="noze" class="form-control" id="exampleInputEmail1"aria-describedby="emailHelp" >
			    <div id="emailHelp" class="form-text">아이디를 입력하세요</div>
			  </div>
			  
			  
			  <div class="mb-3">
			    <label for="exampleInputPassword1" class="form-label">Password</label>
			    <input type="password" name="passWord" value="1" class="form-control" id="exampleInputPassword1">
			  </div>
			  
			  
			  <div class="mb-3 form-check">
			    <input type="checkbox" class="form-check-input" id="exampleCheck1">
			    <label class="form-check-label" for="exampleCheck1">Check me out</label>
			  </div>
			  
			  
			  	<button type="submit" class="btn btn-primary">로그인</button>
			</form>
	</section>
	  
	  
	  
	  
	  
	  <c:import url="../template/footer.jsp"></c:import>
    	
    
    
    
    

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
    			 integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" 
    			 crossorigin="anonymous"></script>
</body>
</html>