<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    	request.setCharacterEncoding("UTF-8");
    %>
    <c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<script>
<%--아이디 비밀번호 공란 경고창 출력 (권우경/21/04/10)--%>
	function fn_login(){
		var frm = document.frmLogin;
		var id = document.getElementById("id");
		var pwd = document.getElementById("pwd");
		
		if(id.value == ""){
			alert('아이디를 입력해주세요');
			id.focus();
		}else if(pwd.value == ""){
			alert('비밀번호를 입력해주세요');
			pwd.focus();
		}else{
			frm.action="${contextPath}/login/loginCheck.do";
			frm.method="post"
			frm.submit();
		}
	}
</script>
<style>
	header{
		margin : 0 auto;
		margin-bottom: 100px;
		
	}
	#logo{
		width:20%;
	}
	#logo img{
		margin:5px;
		width: 150px;
	}
	#title{
		clear:both;
		width:60%;
		text-align: center;
		font-size: 24px;
	}
	article{
		margin:0 auto;
		width: 60%;
		height: 40%;
	}
	#loginSec{
	font-size: 30px;
	text-align: center;
	}
	#loginSec td{
		margin:10px;
		padding : 3px;
	}
	
	#loginSec input[type=text],
	#loginSec input[type=password]
	{
		width: 90%;
		height: 40px;
		text-align: left;
		font-size: 30px;
		outline-style: none;
		border : 1px solid black;
	
	}
	#loginSec input[type=button]{
		width: 150px;
		font-size: 15px;
		height: 50px;
		font-weight: bold;
		margin: 10px;
		background-color: #CCFFCC
	}
	body{
		background-color: #D3D3D3;
	}
	section{
		margin-top: 100px;
	}
</style>
</head>
<body>
<header class="headers">
	<table width="100%"><tr>
		<td id="logo"><a href="#"><img src="${contextPath}/resources/image/logo.jpg"></a></td> <td id="title"> <h1>먹이사슬 게임</h1></td><td> </td>
	</tr></table>
</header>
<nav>

</nav>
<aside>

</aside>
<section>
	<article id="loginSec">
	<form name="frmLogin" method="post"  action="${contextPath}/member/login.do">
	   <table border="0"   align="center">
	      <tr align="center">
	         <td width="30%" >아이디</td>
	         <td>
		    	<input type="text" name="id" id="id">
			 </td>
	         
	      </tr>
	      <tr align="center">
	       	 <td>비밀번호</td>
	         <td>
		    	<input type="password" name="pwd" id="pwd">
		 	 </td>
	      </tr>
	      <tr align="center">
	         <td colspan="2" width="100%">
	         	<br>
	            <input type="button" value="로그인" onclick="fn_login()" >  
	            <input type="button"  value="회원가입" onclick="location.href='${contextPath}/join/join.do'" > 
	            <input type="button" value="나가기" onclick="location.href='${contextPath}/frontpage/main1.do'">  
	         </td>
	      </tr>
	   	</table>
	</form>
</article>
</section>
<footer></footer>
</body>
</html>