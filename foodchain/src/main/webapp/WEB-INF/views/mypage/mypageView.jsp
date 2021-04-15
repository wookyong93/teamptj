<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  	request.setCharacterEncoding("UTF-8");
	String loginID = request.getParameter("id");
	session.setAttribute("loginID", loginID);
%> 

<!-- 04/12 강민경 작성 중 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
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
   .select {
		border-radius: 0.5em;
	}
	.logout{
		float:right;
		background-color: #CCFFCC; width: 100px; height: 30px; font-size: 15px; font-weight: bolder;
	}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	function mod() {
		var frm = document.view;
		var pwd = frm.pwd;
		var pwdchk = frm.pwdchk;
		var nickname = frm.nickname;
		
		
		if(nickname.value==""||nickname.length==0){
			alert("닉네임을 입력해주세요.");
			nickname.focus();
		}else if(pwd.value==""||pwd.length==0){
			alert("비밀번호를 입력해주세요.");
			pwd.focus();
		}else if(pwdchk.value==""||pwdchk.length==0){
			alert("비밀번호 확인을 입력해주세요.");
			pwdchk.focus();
		}else if(pwd.value!=pwdchk.value){
			alert("비밀번호가 일치하지 않습니다.");
			pwd.focus();
		}else{
			alert("수정되었습니다.");
			frm.action="${contextPath}/mypage/modifyMypage.do";
			frm.method="POST";
			frm.submit();
		}
	}
	<%--우경님 작성 copy / 수정해야함--%>
	function nicknameCheck() {
		var nickname = document.getElementById("nickname").value;
		var id = document.getElementById("id").value;
		location.href='${contextPath}/mypage/nicknameCheck.do?nickname='+nickname+'&id='+id;
	}
	
	function logout(){
		alert("로그아웃 되었습니다.");
		<% session.invalidate(); %>
		location.href='${contextPath}/frontpage/main1.do';
	}
	
</script>
</head>
<body>
	<header>
	<div>
	<img class="logo" src="${contextPath}/resources/image/logo.jpg" width="100" height="100" >
	<h1 class="text_center">먹이사슬 게임</h1>
	<input type="button" class="logout" value="로그아웃" onclick="logout()">
	</div>
	</header>
	<form name="view">
	<h1 class="text_center">마이페이지</h1>
	<table class="table" align="center" display="block">
	<c:forEach var = "mypageView" items="${mypageView}">   
	   <tr>
	      <td width="200"><p align="left">아이디</td>
	      <td width="300">
	      <input type="text" name="id" id="id" value="${mypageView.id}" readonly="readonly"/>
	      </td>
	   </tr>
	    <tr>
			<td width="200"><p align="left">닉네임</td>
			<td width="300">
			
			<p><input type="text" name='nickname' id="nickname" value="${mypageView.nickname}">
			</p>
			
			</td>
			<td><input class="btn1" type="button" value="중복확인" onclick="nicknameCheck()"></td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td>
				<input type="date" value="${mypageView.birth}" readonly="readonly">
			</td>
		</tr>
		 <tr>
	      <td width="200"><p align="left">비밀번호</td>
	      <td width="300"><input type="password" name="pwd"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="left">비밀번호 확인</td>
	       <td width="300"><p><input type="password" name="pwdchk"></td>
	    </tr>
	    </c:forEach>
	</table>
		
		<a class="btn2" align="center">
		<input type="button" value="수정" class="btn1" onclick="mod()">
		<input type="button" value="취소" class="btn1" onClick="location.href='${contextPath}/room/roomlistmain.do?id=<%=loginID%>'">
	    </a>
	
	</form>
</body>
