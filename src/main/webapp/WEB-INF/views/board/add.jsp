<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<h1>Board Add Page</h1>
	
	
<form action="./add.iu" method="post">
		<div>
			글번호(num) : <input type="text" name="boardNum">
		</div>
		<div>
			글제목(name) : <input type="text" name="boardName">
		</div>
		<div>
			작성자(Writer) : <input type="text" name="boardWriter">
		</div>
<!-- 		<div>
			작성날짜(Date) : <input type="text" name="boardDate">
		</div> -->
		<div>
			조회수(View) : <input type="text" name="boardView">
		</div>
		
		<div>
			<input type="submit" value="Create">
			<button type="submit">추가</button>
		</div>
		
<img src="../resources/cat2.jpg">
		
	</form>
	

</body>
</html>