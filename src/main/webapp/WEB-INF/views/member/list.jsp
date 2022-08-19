<%@page import="java.util.ArrayList"%>
<%@page import="com.iu.start.bankMembers.BankMembersDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body> 
	<c:import url="../template/header.jsp"></c:import>
	
	<section class="container-fluid col-lg-4 mt-5">
	
		<h1>Member List Page</h1>
		<table border ="1" class="table table-dark table-striped">
			<thead class="table-dark">
				<tr>
					<th>userName</th>
	        	 	<th>Name</th>
	         		<th>Email</th>
	         		<th>Phone</th>
				</tr>
			</thead>
			<tbody>
<%-- 		<c:forEach begin="0" end="10" var="i" step="1">
		for(int i=0;i<=10;i=i+1)
			<h3>${pageScope.i}</h3>
		</c:forEach> --%>
		
		<c:forEach items="${requestScope.list}" var="dto">
			<tr>
				<td>${pageScope.dto.userName}</td>
				<td>${pageScope.dto.name}</td>
				<td>${pageScope.dto.email}</td>
				<td>${pageScope.dto.phone}</td>
			</tr>
		
		</c:forEach>
		
<%-- 			<%
         for (BankMembersDTO bDto : ar) {%>
         <tr>
            <td><%=bDto.getUserName()%></td>
            <td><%=bDto.getName()%></td>
            <td><%=bDto.getEmail()%></td>
            <td><%=bDto.getPhone()%></td>
         </tr>
         <% } %> --%>
      </tbody>

   		</table>
  	 	<a href="../">홈으로 돌아가기</a>
			<img src="../resources/images/cat2.jpg">
	</section>
	
	 <c:import url="../template/footer.jsp"></c:import>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
    			 integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" 
    			 crossorigin="anonymous"></script>
</body>
</html>