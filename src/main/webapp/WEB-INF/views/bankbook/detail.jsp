<%@page import="com.iu.start.bankBook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 
<%
	//요청이 발생하면 생성, 응답이 나가면 소멸 : RequestScope
	BankBookDTO bankBookDTO = (BankBookDTO)request.getAttribute("dto");
%>
--%>    
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
	<h1>Detail Page</h1>

	<table border="1">
			<tr>
				<th>BookNum</th>
				<th>BookName</th>
				<th>BookRate</th>
				<th>BookSale</th>
			</tr>
		<tbody>
			<tr>
				<td>${requestScope.dto.getBookNum()}</td>
				<td>${requestScope.dto.bookName}</td>
				<td>${dto.bookRate}</td>
			</tr>
		</tbody>
	</table>
	
	   <!-- comment시작 -->
   <div class="row">

      <div class="mb-3">
         <label for="writer" class="form-label">USERNAME</label>
         <input type="text" class="form-control" id="writer" placeholder="Enter Your USERNAME">
      </div>

      <div class="mb-3">
         <label for="contents" class="form-label">WRITE CONTENTS</label>
         <textarea class="form-control" id="contents" rows="3"></textarea>
      </div>
	  

      <div class="mb-3">
         <button type="button" id="btn" data-bookNum="${dto.bookNum}">댓글 작성</button>
      </div>


	  	<!-- CommentList 출력 -->
	  <div>
		<table id="commentList" class="table table-bordered border-primary">
			<th>내용</th>
			<th>작성자</th>
			<th>bookNum</th>
		</table>
		
	</div>
	<button id="plus" class="btn btn-success disabled">더보기</button>
	  <!-----------Comment------------>
      

   </div>
   <!-- comment끝 -->
   <!----- Modal ------>
   <div>
		<button type="button" style="display: none;" id="up" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@getbootstrap">바튼</button>

		<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">수정하기</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form>
						<input type="hidden" id="num">
						<div class="mb-3">
							<label for="recipient-name" class="col-form-label">작성자</label>
							<input type="text" class="form-control" id="updateWriter">
						</div>
						<div class="mb-3">
							<label for="message-text" class="col-form-label">내용</label>
							<textarea class="form-control" id="updateContents"></textarea>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
					<button type="button" id="update" data-bs-dismiss="modal" class="btn btn-primary">Send message</button>
				</div>
				</div>
			</div>
		</div>
   </div>
   
   
		<!-- 상대경로 -->
	<!-- <a href="./WEB-INF/view/member/login.jsp">Login</a> -->
	<a href="../member/login.iu">Login</a>
	
	<!-- 절대경로 -->
	<a href="/member/join.iu">Join</a>

	<a href="./list.iu">리스트보기</a>
	
	<a href="./update.iu?bookNum=${dto.bookNum}">수정하기</a>
	
	<a href="./delete.iu?bookNum=${dto.bookNum}">삭제하기</a>
	
	<c:if test="${not empty sessionScope.member}">
	
	<a href="../bankAccount/add.iu?bookNum=${dto.bookNum}">가입하기</a>
	
	</c:if>
	
<img src="../resources/cat2.jpg">
<c:import url="../template/footer.jsp"></c:import>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
    			 integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" 
    			 crossorigin="anonymous"></script>

	<script src="/resources/JS/bankBookComment.js"></script>
</section>
</body>
</html>