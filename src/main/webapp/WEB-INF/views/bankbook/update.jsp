<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>통장정보 수정하기</h1>
	
	<form action="./update" method="post">
					<input type="hidden" name="bookNum" readonly="readonly" value="${dto.bookNum}">
		<div>
			통장이름 : <input type="text" name="bookName" value="${dto.bookName}">
		</div>
		<br>
		<div>
			이자율 : <input type="text" name="bookRate" value="${dto.bookRate}">
		</div>
		<br>
		
		<input type="submit" value="수정">
		<button type="submit">수정</button>
		
	</form>

</body>
</html>