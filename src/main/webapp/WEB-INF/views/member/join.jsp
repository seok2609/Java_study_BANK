<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Join Page</h1>
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
    
<img src="../resources/cat2.jpg">

</body>
</html>