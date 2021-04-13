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
</style>
</head>
<body>
	<form method="post"   action="${contextPath}/room/addroom.do">
	<h1  class="text_center">방 설정</h1>
	<table  align="center">
	
	   <tr>
	      <td width="200"><p align="right">아이디</td>
	      <td width="400"><input type="text" name="chief_id" disabled="disabled"></td>
	   </tr>
	   <tr>
	      <td width="200"><p align="right">방 번호</td>
	      <td width="400"><input type="text" value="2" name="roomNum" disabled="disabled"></td>
	   </tr>
	   <tr>
	      <td width="200"><p align="right">방 제목</td>
	      <td width="400"><input type="text" name="title"></td>
	    </tr>
	    <tr>
	       <td width="200"><p>&nbsp;</p></td>
	       <td width="400"><input type="submit" value="방 생성"><input type="button" value="돌아가기" onClick="location.href='${contextPath}/room/roomlistmain.do'"></td>
	    </tr>

	</table>
	</form>
</body>
