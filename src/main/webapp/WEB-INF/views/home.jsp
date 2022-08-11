<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	어서오세요!
</h1>

<P>  The time on the server is ${serverTime}. </P>
<p> 저희 은행에 오신걸 환영합니다.! </p>

<img src="../resources/cat2.jpg">
<br>

<c:if test="${empty member}">
<a href="./member/login">Login</a>
<a href="./member/join">join</a>
</c:if>

<c:if test="${not empty member}">
<a href="#">Logout</a>
<a href="#">Mypage</a>
</c:if>

<a href="./member/search">search</a>

<a href="./bankbook/detail">Detail</a>
<a href="./bankbook/list">List</a>
<a href="./bankbook/add">Add</a>
<a href="./bankbook/update">수정하기</a>
<a href="./bankbook/delete">삭제하기</a>


<br>
<br>
<img src ="../resources/cat.jpg">


</body>
</html>
