<%@page import="com.iu.start.bankBook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	BankBookDTO bankBookDTO = (BankBookDTO)request.getAttribute("dto");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Page</h1>
	
	<table border = "1">
		<tr>
			<th>BookNum</th>
			<th>BookName</th>
			<th>BookRate</th>
			<th>BookSale</th>
			<th>판매 여부</th>
		</tr>
		
		<tbody>

		</tbody>
		<form action="./add" method="post">
			<div>
				<h3>일련번호</h3>
					<input type="text" name="Booknum">
				<h3>통장이름</h3>
					<input type="text" name="Bookname">
				<h3>이자율</h3>
				 	<input type="text" name="Bookrate">
				<h3>판매여부</h3>
					<input type="text" name="Booksale">
				<br>
				<h4>등록하기</h4>
				<input type="submit" name="">
			</div>
		</form>
	
	</table>
	

</body>
</html>