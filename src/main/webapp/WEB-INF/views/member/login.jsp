<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Page</h1>
	
	<form action="./login.iu" method="post">
        <div class="container">
            ID <input type="text" value="noze" placeholder="ID입력" name="userName">
            PW <input type="password" value="1" name="passWord">
        </div>

        <div>
            아이디 저장 <input type="radio" name="r1">
        </div>

        <div>
            <input type="submit" value="로그인">
            <input type="button" value="회원가입">
            <input type="button" value="ID/PW찾기">
        </div>
    </form>
    
<img src="../resources/cat2.jpg">

</body>
</html>