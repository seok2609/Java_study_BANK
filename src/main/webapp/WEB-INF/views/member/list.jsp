<%@page import="java.util.ArrayList"%>
<%@page import="com.iu.start.bankMembers.BankMembersDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ArrayList<BankMembersDTO> ar = (ArrayList<BankMembersDTO>)request.getAttribute("list");
%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member List Page</h1>
	<table border ="1">
		<thead>
			<th>userName</th>
        	 <th>Name</th>
         	<th>Email</th>
         	<th>Phone</th>

		</thead>
		<tbody>
			<%
         for (BankMembersDTO bDto : ar) {%>
         <tr>
            <td><%=bDto.getUserName()%></td>
            <td><%=bDto.getName()%></td>
            <td><%=bDto.getEmail()%></td>
            <td><%=bDto.getPhone()%></td>
         </tr>
         <% } %>
      </tbody>

   </table>

</body>
</html>