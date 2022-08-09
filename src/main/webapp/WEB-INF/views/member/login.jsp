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
	
	<form action="./login" method="post">
        <div class="container">
            ID <input type="text" placeholder="ID입력" name="id">
            PW <input type="password" name="pw">
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

</body>
</html>