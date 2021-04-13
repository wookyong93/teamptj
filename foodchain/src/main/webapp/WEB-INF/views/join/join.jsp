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
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	<%-- id 값 처리 --%>
	window.onload = function(){
		var id = '<%=request.getParameter("id")%>';
		if(id != 'null'){
			document.getElementById("id").value = id;
			document.getElementById('idck').disabled="disabled"
		}
	}
	<%--id 중복체크 확인중입니다. /권우경 작성--%>
	function fn_idCheck(){
		var id = document.getElementById("id").value;
		location.href="${contextPath}/member/idCheck.do?id="+id;
	}
	
	<%--회원가입 진행 /권우경 작성--%>
	function fn_insert(){
		var frm = document.frm;
		var id = frm.id;
		var pwd = frm.pwd;
		var pwdchk = frm.pwdchk;
		if(id.value == ""){
			alert('아이디를 입력하세요');
			id.focus();
		}else if(pwd.value==""){
			alert('비밀번호를 입력하세요');
			pwd.focus();
		}else if(pwdchk.value==""){
			alert('비밀번호 확인을 입력하세요');
			pwdchk.focus();
		}else if(pwdchk.value != pwd.value){
			alert('비밀번호가 서로 다릅니다.');
			pwd.value="";
			pwdchk.value="";
			pwd.focus();
		}else{
			frm.method="post";
			frm.action="${contextPath}/member/addMember.do";
			frm.submit();
		}
	}
</script>
</head>
<body>
	<header>
	<div>
	<img class="logo" src="${contextPath}/resources/image/logo.jpg" width="100" height="100" >
	<h1 class="text_center">먹이사슬 게임</h1>
	</div>
	</header>
	<form method="post" name ="frm">
	<h1 class="text_center">회원 가입</h1>
	<table class="table" align="center" display="block">
	   <tr>
	      <td width="200"><p align="left">아이디</td>
	      <td width="300"><input type="text" name="id" id="id"/></td>
	      <td><input class="btn1" type="button" value="중복체크" id="idck" onclick="fn_idCheck()" />
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
		<input type="submit" value="가입" class="btn1" id="joinbtn" onclick="fn_insert()">
		<input type="button" value="취소" class="btn1" onClick="location.href='${contextPath}/frontpage/main1.do'">
	    </a>
	
	</form>
</body>
