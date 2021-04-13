<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    


<html>
<head>
<meta charset=UTF-8">
<title>방 목록</title>
<style>
body{
	width:80%;
	margin:auto;
	background-color: #d3d3d3;
	}
.logo{
	float:left;
	}
.btn1{
   background-color: #CCFFCC; width: 100px; height: 30px; font-size: 15px; font-weight: bolder;
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
<input type="button" value="방 만들기" class="btn1" onclick="location.href='${contextPath}/room/createroom.do?id=${loginID}'">
<table border="1"  align="center"  width="80%">
    <tr align="center"   bgcolor="#CCFFCC">
      <td ><b>상태</b></td>
      <td><b>방 번호</b></td>
      <td><b>방 제목</b></td>
      <td><b>인원</b></td>
      <td><b>방장</b></td>
   </tr>
   
 <c:forEach var="room" items="${roomList}" >     
   <tr align="center">
      <td>대기중</td>
      <td>${room.roomNum}</td>
      <td>${room.title}</td>
      <td>인원수</td>
      <td>${room.chief_id}</td>
   </tr>
  </c:forEach>   
</table>
</body>
</html>
