<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
   request.setCharacterEncoding("UTF-8");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입창</title>
<style>
	body{
	width:80%;
	margin:auto;
	background-color: #d3d3d3;
	}
	header{
	padding-bottom: 55px;
	}
	.logo{
	float:left;
	}
   .text_center{
     text-align:center;
   }
   .btn1{
   background-color: #CCFFCC; width: 100px; height: 30px; font-size: 15px; font-weight: bolder;
   }
   .btn2{
   padding: 25px; display: block;
   }
</style>
</head>
<body>
	<header>
	<div>
	<img class="logo" src="${contextPath}/resources/image/logo.jpg" width="100" height="100" >
	<h1 class="text_center">먹이사슬 게임</h1>
	</div>
	</header>
	<form method="post" action="${contextPath}/member/addMember.do">
	<h1 class="text_center">회원 가입</h1>
	<table class="table" align="center" display="block">
	   <tr>
	      <td width="200"><p align="left">아이디</td>
	      <td width="300"><input type="text" name="id"></td>
	   </tr>
	   <tr>
	      <td width="200"><p align="left">패스워드</td>
	      <td width="300"><input type="password" name="pwd"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="left">패스워드확인</td>
	       <td width="300"><p><input type="password" name="pwdchk"></td>
	    </tr>
	</table>
		
		<a class="btn2" align="center">
		<input type="submit" value="가입" class="btn1">
		<input type="button" value="취소" class="btn1" onClick="location.href='${contextPath}/frontpage/main1.do'"></td>
	    </a>
	
	</form>
</body>
