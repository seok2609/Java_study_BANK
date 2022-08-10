<%@page import="com.iu.start.bankBook.BankBookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//스크립틀릿 <% java code 작성% >
	//표현식 <% = 자바변수 또는 값 % >
	ArrayList<BankBookDTO> ar = (ArrayList<BankBookDTO>)request.getAttribute("list");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook List</h1>
	<!-- /BankBook/list -->
	
	<!-- /BankBook/detail  jsp:detail.jsp -->
	<!-- link 주소는 상대경로 작성 -->
	<table border="1">
		<thead>
			<tr>
				<th>Name</th><th>Rate</th>
			</tr>
		</thead>
	<tbody>
		<% for(BankBookDTO bankBookDTO : ar) { %>
			<tr>
				<td><a href ="./detail?BookNum=<%=bankBookDTO.getBookNum()%>"> <%= bankBookDTO.getBookName() %> </a></td>
				<td><%= bankBookDTO.getBookRate() %> </td>
			</tr>
		
		<% } %>
	</tbody>
	</table>
	
	<a href="./add">상품등록</a>
	<a href="./detail">Detail</a>
	

</body>
</html>