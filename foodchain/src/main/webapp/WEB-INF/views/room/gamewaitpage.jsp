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
	
	String title = request.getParameter("title");
	session.setAttribute("title", title);
	
	String roomNum = request.getParameter("roomNum");
	session.setAttribute("roomNum", roomNum);
	
	String chief_id = request.getParameter("chief_id");
	session.setAttribute("chief_id", chief_id);
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
	border-color:#CCFFCC; background-color: #CCFFCC; width: 100px; height: 30px; font-size: 15px; font-weight: bolder; width:100px; height:40px;
   }
.btn2{
	border-color:#CCFFCC; background-color: #CCFFCC; width: 100px; height: 30px; font-size: 15px; font-weight: bolder; float: right; margin: 5px; display: block; width:100px; height:40px;
	}
.tab1{
	border:1px solid white;
	position:absolute;
	top:28%;
	left:8%;
	display: block;
}

.tab2{
	border-bottom: 1px solid black;
}

.ul1{
position:absolute;
font-size:18px;
font-weight:bold;
top:20%;
left:50%;
list-style-type: none;
margin: -25px 35px 35px -195px;
padding: 5px;
background-color: white;
text-align:center;
display: block;
}
.ul2{
position:absolute;
font-size:15px;
top:20%;
left:50%;
list-style-type: none;
margin: 5px 35px 35px -195px;
padding: 5px;
background-color: white;
text-align:center;
display: block;
}
li{	
	width:75px;
	left:50%;
	float:left;
	border-right:1px solid black;
	padding: 0 10px 0 10px;
}
li:last-child {
	border-right: none;
}
form{
position:absolute;
left:27%;
top:27%;
}
</style>
<script type="text/javascript">
	function popup(){
		var url = "${contextPath}/room/popup.do";
		var name = "popup pop";
		var option = "width = 750, height = 450, left=1250, location = no"
		window.open(url,name,option);	
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



	<input type="button" value="마이페이지" class="btn2" onclick="location.href='${contextPath}/mypage/mypageView.do?id=${loginID}'">
	<input type="button" value="로그아웃" class="btn2" onclick="location.href='${contextPath}/login/login.do'">


	<ul class="ul1">
	<li>번호</li>
	<li>방제목</li>
	<li>방장</li>
	<li>인원수</li>
	<li>게임상태</li>
	</ul>
	<ul class="ul2">
	<li>${roomNum }</li>
	<li>${title }</li>
	<li>${chief_id }</li>
	<li>2/13</li>
	<li>대기중</li>
	</ul>
	
	<table class="tab1">	
		<tr style="background-color: white;">
	      <td width="200"><p align="center">접속자</td>
	    </tr>
	    
	    <tr class="tab2">
			<td width="200"><p align="center">접속자name</td>
		</tr>
		<tr class="tab2">
			<td width="200"><p align="center">접속자name</td>
		</tr>
		<tr class="tab2">
			<td width="200"><p align="center">접속자name</td>
		</tr>
		<tr class="tab2">
			<td width="200"><p align="center">접속자name</td>
		</tr> 
	</table>
	
	<form>
	<input type="text" style="background-color: white; width: 750px; height: 550px; display: block;">
	<input type="text" id="chat" style="background-color: white; width: 380px; height:30px; margin: 0px;">
	<input type="submit" value="채팅" style="border-color:#CCFFCC; background-color: #CCFFCC; width: 120px; height: 40px;">
	
	<input type="button" value="준비/시작" class="btn1" id="commitchk" onclick="location.href='${contextPath}/room/gameplaypage.do'">
	<input type="button" value="나가기" class="btn1" onclick="location.href='${contextPath}/room/roomlistmain.do'">
	<input type="button" value="설명" class="btn1" onclick="location.href='javascript:popup()'">
	
	</form>
</body>
