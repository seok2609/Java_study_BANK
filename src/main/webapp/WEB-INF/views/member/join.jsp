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
	<h1>회원가입</h1>
	
	<form action="./join.iu" method="post">
        <div>
            ID <br> <input type="text" placeholder="ID입력" name="userName"> 
            ID 중복체크 <input type="button" value="ID 중복체크"> <br>
            PW  <br> <input type="password" name="passWord"> <br>
            PW 확인 <br> <input type="password" name="pw"><br>

            이름 <br> <input type="text" value="" name="name"> <br>
            생년월일 <br> <input type="date" name="birth"><br>
            이메일 <br> <input type="email" name="email"><br>
            전화번호 <br> <input type="text" name="phone">
        </div>
        <br>
        <br>
        <br>
        <br>
        <br>
        <div>	
            <input type="submit" value="회원가입">
        </div>
    </form>
    
<img src="../resources/images/cat2.jpg">

</section>

<c:import url="../template/footer.jsp"></c:import>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
    			 integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" 
    			 crossorigin="anonymous"></script>

</body>
</html>