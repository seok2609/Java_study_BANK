<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Board 수정 페이지</h1>
	
		<form action="./update.iu" method="post">
					<input type="hidden" name="boardNum" readonly="readonly" value="${dto.boardNum}">
		<div>
			글제목 : <input type="text" name="boardName" value="${dto.boardName}">
		</div>
		<br>
		<div>
			작성자 : <input type="text" name="boardWriter" value="${dto.boardWriter}">
		</div>
		<br>
		<div>
			글 내용 : <input type="text" name="boardContents" value="${dto.boardContents}">
		</div>
		<br>
<%-- 		<div>
			작성 날짜 : <input type="text" name="boardDate" value="${dto.boardDate}">
		</div> --%>
		<br>
		<div>
			조회수 : <input type="text" name="boardView" value="${dto.boardView}">
		</div>
		
		<input type="submit" value="수정">
		<button type="submit">수정</button>
		
		</form>
		
		<img src="../resources/cat2.jpg">

</body>
</html>