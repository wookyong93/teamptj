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
<title>방 생성</title>
<style>
   .text_center{
     text-align:center;
   }
body{
	width:80%;
	margin:auto;
	background-color: #d3d3d3;
	}
.logo{
	float:left;
	}
.btn1{
	outline-color:#CCFFCC; background-color: #CCFFCC; width: 100px; height: 30px; font-size: 15px; font-weight: bolder; width:100px; height:40px;
   }
.btn2{
	outline-color:#CCFFCC; background-color: #CCFFCC; width: 100px; height: 30px; font-size: 15px; font-weight: bolder; float: right; margin: 5px; display: block; width:100px; height:40px;
	}
table{
	margin-top: 120px;
}
ul{
position:absolute;
width:450px;
font-size:18px;
font:bold;
left:50%;
list-style-type: none;
margin: 35px 35px 35px -75px;
padding: 5px;
background-color: white;
text-align:center;
}
li{	
	left:50%;
	float:left;
	border-right:1px solid black;
}
li:last-child {
	border-right: none;
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



	<input type="button" value="마이페이지" class="btn2" onclick="location.href='${contextPath}/mypage/mypageView.do?id=${loginID}'">
	<input type="button" value="로그아웃" class="btn2" onclick="location.href='${contextPath}/login/login.do'">


	<ul>
	<li>번호</li>
	<li>방제목</li>
	<li>방장</li>
	<li>인원수</li>
	<li>게임상태</li>
	</ul>
	
	<table align="center">
		
		<tr>
	      <td width="200"><p align="right">방 제목</td>
	      <td width="400"><input type="text" name="title"></td>
	    </tr>
	    <tr>
	      <td width="200"><p align="right">대기시간</td>
	      <td width="400"><select name="timer">
	      <option value="">시간 선택</option>
	      <option value="15">15초</option>
	      <option value="20">20초</option>
	      <option value="25">25초</option>
	      </select>
	      </td>
	    </tr>
	   <tr>
	      <td width="200"><p align="right">인원수</td>
	      <td width="400"><input type="text" value="13" name="roomNum" disabled="disabled"></td>
	   </tr>
	   
	    <tr>
	       <td width="200"><p>&nbsp;</p></td>
	       <td width="400"><input type="submit" value="방 생성" style="margin: 15px; background-color: #CCFFCC;"><input type="button" value="돌아가기" style="background-color: #CCFFCC;" onClick="location.href='${contextPath}/room/roomlistmain.do'"></td>
	    </tr>

	</table>
</body>
