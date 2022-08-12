<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>삭제를 원하십니까??</h1>
	
	<form action="./delete.iu" method="get">
			<div>
				삭제를 원하는 통장번호 : <input type="text" name="bookNum" value="${dto.bookNum}">
			</div>
			
			<Button type="submit">삭제</Button>
			
			
	</form>
		<br>
			<div>	
			<a href="./list">리스트로 돌아가기</a>
			</div>
			
<img src="../resources/cat2.jpg">
</body>
</html>