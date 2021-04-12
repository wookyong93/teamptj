<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 화면1</title>
<!-- 이소정 (2021/04/10) -->
<!-- main 두개 합쳐보기 -->
<style>
   body{
      background-color:d3d3d3;
   }
   #title {
      width:60%;
      margin: 0 auto;

   }
   #main {
      margin:0 auto ;
   }
   a{ color:black; }
   a:link { color:black; text-decoration:none; }
   a:visited { 
	   color:black; 
	   text-decoration:none;
	   font-weight:bold;
    }
   input[type=button]{
   	background-color:#CCFFCC;
   	width:100px;
   	height:40px;
   }
</style>
</head>
<body>
	<table id="title">
      <tr>
         <td><img src="${contextPath}/resources/image/logo.jpg" width="100px">
         <td ><h1><br>먹이사슬 게임</h1></td>
      </tr>
    </table>
    <table id="main" align="center" width="100%">
		<tr align="center">
			<td>
				<p align="center">
				 <iframe width="700" height="400"
						src="https://www.youtube.com/embed/TQrVOoFr3lM"
				 		title="YouTube video player" frameborder="0" 
				 		allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" 
				 		allowfullscreen>
				 </iframe> 
				 </p>
		 	</td>
		 </tr>
		 <tr align="center">
		 	<td><a href="${contextPath}/frontpage/main1.do">[1]</a>
		 	<a href="${contextPath}/frontpage/main2.do">[2]</a></td>
		 </tr>
		 <tr align="center">
		 	<td>
				 <input type="button" value="로그인" onclick="location.href='${contextPath}/login/login.do'">
                <input type="button" value="회원가입" onclick="location.href='${contextPath}/join/join.do'">
		 	</td>
		 </tr>
	 </table>
</body>
</html>