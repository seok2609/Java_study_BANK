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
	<h1>Detail Page</h1>
	
	<!-- 상대경로 -->
	<!-- <a href="./WEB-INF/view/member/login.jsp">Login</a> -->
	<a href="../member/login">Login</a>
	
	<!-- 절대경로 -->
	<a href="/member/join">Join</a>
	
	<%if(bankBookDTO != null) { %>
	
	<table border="1">
			<tr>
				<th>BookNum</th>
				<th>BookName</th>
				<th>BookRate</th>
				<th>BookSale</th>
			</tr>
		<tbody>
			<tr>
				<td><%= bankBookDTO.getBooknum() %> </td>
				<td><%= bankBookDTO.getBookname() %> </td>
				<td><%= bankBookDTO.getBookrate() %> </td>
				<td><%= bankBookDTO.getBooksale() %> </td> 
				<td><% if(bankBookDTO.getBooksale()==1) {%>
						판매중
					<%}else {%>
					    판매완료
					<%} %>		
				</td>
			</tr>
		</tbody>
	</table>
	<%}else {%>
		<h3>Data가 없다</h3>
	<%} %>

</body>
</html>