<%@page import="com.iu.start.bankBook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Page</h1>
	
	<form action="./add.iu" method="post">
		<div>
			통장번호(num) : <input type="text" name="bookNum">
		</div>
		<div>
			통장이름(name) : <input type="text" name="bookName">
		</div>
		<div>
			이자율(rate) : <input type="text" name="bookRate">
		</div>
		<div>
			판매여부(sale) : <input type="text" name="bookSale">
		</div>
		
		<div>
			<input type="submit" value="Create">
			<button type="submit">추가</button>
		</div>
		
<img src="../resources/cat2.jpg">
		
	</form>
	

</body>
</html>