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

<c:if test="${empty sessionScope.member}">
<a href="./member/login.iu">Login</a>
<a href="./member/join.iu">join</a>
</c:if>

<c:if test="${not empty sessionScope.member}">
<h3>${sessionScope.member.name} 님 환영합니다!</h3>
<a href="./member/logout.iu">Logout</a>
<a href="#">Mypage</a>
</c:if>

<a href="./member/search.iu">search</a>
<a href="./bankbook/detail.iu">Detail</a>
<a href="./bankbook/list.iu">List</a>
<a href="./bankbook/add.iu">Add</a>
<a href="./bankbook/update.iu">수정하기</a>
<a href="./bankbook/delete.iu">삭제하기</a>

<br>
<br>
<img src ="../resources/cat.jpg">

<p>Board 게시판 입니다!!</p>
	<a href="./board/list.iu">목록보기</a>
	<a href="./board/add.iu">추가하기</a>
	<a href="./board/detail.iu">상세정보</a>
	<a href="./board/update.iu">수정하기</a>
	<a href="./board/delete.iu">삭제하기</a>ㄴ


</body>
</html>
