<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
 </head>
 <body>
 <!-- header import -->
 	<c:import url="../template/header.jsp"></c:import>
    <div class="container-fluid">
    	<div class="row mt-5 justify-content-center">
    		<div class="col-lg-6">    		
    			<h1 class="text-center">회원가입 페이지</h1>
    		</div>
    	</div>
    
    	<div class="row justify-content-center mt-5">
    		<div class="col-lg-6">
        	<form action="./join.iu" method="post" enctype="multipart/form-data">
			  <div class="row mb-3">
			    <label for="inputUserName" class="col-sm-2 col-form-label">아이디</label>
			    <div class="col-sm-10">
			      <input type="text" name="userName" class="form-control" id="inputUserName" placeholder="ID 입력">
			    </div>
			  </div>
			  <div class="row mb-3">
			    <label for="inputPassword" class="col-sm-2 col-form-label">비밀번호</label>
			    <div class="col-sm-10">
			      <input type="password" name="passWord" class="form-control" id="inputPassword" placeholder="Password 입력">
			    </div>
			  </div>
			  <div class="row mb-3">
			    <label for="inputName" class="col-sm-2 col-form-label">이름</label>
			    <div class="col-sm-10">
			      <input type="text" name="name" class="form-control" id="inputName" placeholder="이름 입력">
			    </div>
			  </div>
			  
			  <div class="row mb-3">
			    <label for="inputEmail" class="col-sm-2 col-form-label">이메일</label>
			    <div class="col-sm-10">
			      <input type="email" name="email" class="form-control" id="inputEmail" placeholder="Email 입력">
			    </div>
			  </div>
			  <div class="row mb-3">
			    <label for="inputPhone" class="col-sm-2 col-form-label">전화번호</label>
			    <div class="col-sm-10">
			      <input type="text" name="phone" class="form-control" id="inputPhone" placeholder="전화번호 입력">
			    </div>
			  </div>
			  <!-- name=""과 같은 이름으로 컨트롤러 변수이름 -->
			   <div class="row mb-3">
				 		  <label for="photo" class="col-sm-2 col-form-label">첨부파일</label>
				   	 <div class="col-sm-10">
				    	  <input type="file" name="photo" class="form-control" id="photo">
					 </div>
				</div>
				
			  <div class="row justify-content-end">
			  	<div >
			  		<button type="submit" class="btn btn-primary mb-3">회원가입</button>
			  	</div>
			  </div>
			  
			</form>
        	</div>
        <img src="../resources/images/cat2.jpg">
        </div>
    </div>
	<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>    
</body>

<script src="/resources/js/member.js"></script>
<script>
	checkjoin();
</script>
</html>