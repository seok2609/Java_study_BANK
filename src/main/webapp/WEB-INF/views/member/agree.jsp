<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <style>
    #col{
      background-color:cornsilk;
      overflow: scroll;
      width: 600px;
      height: 100px;
    }
    #po{
      font-size: 10pt;
      color: black;
    }
    
    
  </style>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
  </head>
<body>

    <c:import url="../template/header.jsp"></c:import>
    
		
	
<section class="container-fluid col-lg-4">
<div class="row">
<h1>개인정보 동의 페이지</h1>
<h4 id="po">필수항목에 동의하셔야 로그인 페이지로 이동합니다.</h4>

  <div>

  <h5><strong>전체동의<input type="checkbox" id="all"></strong></h5>
  <div></div>

  약관(필수)<input type="checkbox" class="cb req" >
  <div class="col">


  </div>
  약관(필수)<input type="checkbox" class="cb req" >

  
  <div class="col">


  </div>
  약관(필수)<input type="checkbox" class="cb req" >
  
  <div class="col">

  </div>
  약관(선택)<input type="checkbox" class="cb" >
</div>

<form id="frm" action="./join.iu">
  <button type="button" id="join">회원가입</button>

</form>
</div>
</section>
  <script src="/resources/JS/member.js"></script>
  <script>
    check();
    </script>
    <c:import url="../template/footer.jsp"></c:import>
</body>
</html>